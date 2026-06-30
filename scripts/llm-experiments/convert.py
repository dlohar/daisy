# HOW TO RUN:
#   Batch (directory → directory):
#     python3 convert.py <input_dir> [<output_dir>]
#
#   No arguments (uses default paths):
#     python3 convert.py
#     reads from testcases/llm/qnn, writes to testcases/llm/nn-bench
#
#   Single file:
#     python3 convert.py <input.scala> <output.scala>
#
# INPUT FORMAT (qnn):
#   - Weights and biases are defined as local val inside the function body.
#   - Input bounds are given via lowerBounds(x, List(...)) / upperBounds(x, List(...)).
#   - Layers are computed as: val layerN = relu/linear(weightsN * prev + biasN)
#
# OUTPUT FORMAT (ds2l / --ds):
#   - Weights and biases become function parameters (Matrix / Vector types).
#   - The require block contains specM/specV constraints for each parameter,
#     grouping entries with similar values into shared intervals (±0.01 padding).
#   - relu layers are rewritten as: (W.x(prev) + b).map(el => { relu.max() })
#   - linear layers are rewritten as: (W.x(prev) + b)

import re
import sys


def parse_matrix(name, content):
    pattern = rf'val {name}\s*=\s*Matrix\(List\((.*?)\)\)'
    match = re.search(pattern, content, re.DOTALL)
    if not match:
        print(f"Could not parse matrix: {name}")
        return None

    raw = re.sub(r'\s+', ' ', match.group(1)).strip()

    raw += ')'

    rows = re.findall(r'List\((.*?)\)', raw)
    if not rows:
        print(f"No rows found for matrix: {name}")
        return None
    return [[float(v.strip()) for v in row.split(',') if v.strip()] for row in rows]


def parse_vector(name, content):
    # Match Vector(List(...)) for the given variable name.
    pattern = rf'val {name}\s*=\s*Vector\(List\((.*?)\)\)'
    match = re.search(pattern, content, re.DOTALL)
    if not match:
        return None
    raw = match.group(1)

    return [float(v) for v in re.findall(r'[-+]?\d+(?:\.\d+)?(?:[eE][+-]?\d+)?', raw)]


def group(values_with_index, bandwidth=0.1):
    # Sort entries by value and greedily merge consecutive ones whose values
    # fall within `bandwidth` of each other into a single interval.
    # Each group is returned as (members, lo, hi) where lo/hi are the interval
    # bounds padded by ±0.01 and rounded to 6 decimal places.
    sorted_vals = sorted(values_with_index, key=lambda x: x[-1])
    groups = [[sorted_vals[0]]]
    for item in sorted_vals[1:]:
        if item[-1] - groups[-1][0][-1] <= bandwidth:
            groups[-1].append(item)
        else:
            groups.append([item])
    result = []
    for g in groups:
        lo = round(min(x[-1] for x in g) - 0.01, 6)
        hi = round(max(x[-1] for x in g) + 0.01, 6)
        result.append((g, lo, hi))
    return result


def spec_matrix(name, matrix):
    # Build the specM constraint for a weight matrix.
    nrows, ncols = len(matrix), len(matrix[0])
    entries = [(r, c, matrix[r][c]) for r in range(nrows) for c in range(ncols)]
    groups = group(entries)
    overall_lo = min(lo for _, lo, _ in groups)
    overall_hi = max(hi for _, _, hi in groups)
    sets = []
    for g, lo, hi in groups:
        idx = ", ".join(f"({r}, {c})" for r, c, _ in sorted(g))
        sets.append(f"(Set({idx}),({lo}, {hi}))")
    spec = ",\n\t\t".join(sets)
    return (
        f"&& {name} >= {overall_lo} && {name} <= {overall_hi} && {name}.size({nrows},{ncols})\n"
        f"\t\t&& {name}.specM(Set({spec}))"
    )


def spec_vector(name, vec):
    # Build the specV constraint for a bias vector.
    entries = [(i, v) for i, v in enumerate(vec)]
    groups = group(entries)
    overall_lo = min(lo for _, lo, _ in groups)
    overall_hi = max(hi for _, _, hi in groups)
    sets = []
    for g, lo, hi in groups:
        for i, _ in sorted(g):
            sets.append(f"(({i}, {i}),({lo}, {hi}))")
    spec = ",\n\t\t".join(sets)
    return (
        f"&& {name} >= {overall_lo} && {name} <= {overall_hi} && {name}.size({len(vec)})\n"
        f"\t\t&& {name}.specV(Set({spec}))"
    )


def convert_input_bounds(content):
    # Convert lowerBounds(x, List(...)) / upperBounds(x, List(...)) calls
    # into the ds2l specV format with per-element intervals and an overall range.
    lo_match = re.search(r'lowerBounds\(x,\s*List\((.*?)\)\)', content, re.DOTALL)
    hi_match = re.search(r'upperBounds\(x,\s*List\((.*?)\)\)', content, re.DOTALL)
    if not lo_match or not hi_match:
        return None
    lo_vals = [float(v.strip()) for v in lo_match.group(1).split(',') if v.strip()]
    hi_vals = [float(v.strip()) for v in hi_match.group(1).split(',') if v.strip()]
    size = len(lo_vals)
    overall_lo = min(lo_vals)
    overall_hi = max(hi_vals)
    specV = ", ".join(f"(({i}, {i}),({lo_vals[i]}, {hi_vals[i]}))" for i in range(size))
    return (f"x >= {overall_lo} && x <= {overall_hi} && x.size({size})\n"
            f"\t && x.specV(Set({specV}))")


def build_layers(content):
    # Find all layer definitions of the form:
    #   val layerN = relu/linear(weightsN * prev + biasN)
    # and rewrite them into ds2l syntax:
    layers = re.findall(
        r'val (layer\d+)\s*=\s*(relu|linear)\((weights\w+)\s*\*\s*(\w+)\s*\+\s*(bias\w+)\)',
        content
    )
    lines = []
    for layer_name, activation, weight, prev, bias in layers:
        if activation == 'relu':
            lines.append(
                f"    val {layer_name} = ({weight}.x({prev}) + {bias}).map(el => {{\n"
                f"      val relu = Vector(List(el, 0.0))\n"
                f"      relu.max()\n"
                f"    }})"
            )
        else:
            lines.append(f"    val {layer_name} = ({weight}.x({prev}) + {bias})")
    lines.append(f"\n    {layers[-1][0]}")
    return "\n".join(lines)


def convert(input_file, output_file):
    with open(input_file) as f:
        content = f.read()

    matrix_names = [n for n in re.findall(r'val (\w+)\s*=\s*Matrix\(', content) if 'layer' not in n]
    vector_names = [n for n in re.findall(r'val (\w+)\s*=\s*Vector\(', content) if 'layer' not in n]

    print(f"Found matrices: {matrix_names}")
    print(f"Found vectors:  {vector_names}")

    specs = []
    for name in matrix_names:
        m = parse_matrix(name, content)
        if m:
            specs.append(spec_matrix(name, m))
    for name in vector_names:
        v = parse_vector(name, content)
        if v:
            specs.append(spec_vector(name, v))

    # Extract structural pieces from the original file.
    imports   = "import daisy.lang._\nimport Real._\nimport daisy.lang.Vector._"
    obj_name  = re.search(r'object\s+(\w+)', content).group(1)
    fn_name   = re.search(r'def\s+(\w+)\s*\(', content).group(1)
    orig_param = re.search(r'def\s+\w+\s*\((.*?)\)\s*:', content, re.DOTALL).group(1).strip()
    ret_type  = re.search(r'\)\s*:\s*(\w+)\s*=', content).group(1)
    ensuring  = re.search(r'(ensuring\(.*?\))', content, re.DOTALL).group(1)

    # Build the new parameter list: original input (x: Vector) followed by
    # all weight matrices and bias vectors as explicit parameters.
    new_params = (orig_param
                  + ", " + ", ".join(f"{n}: Matrix" for n in matrix_names)
                  + ", " + ", ".join(f"{n}: Vector" for n in vector_names))

    # Convert lowerBounds/upperBounds into the ds2l specV require clause for x.
    orig_req = convert_input_bounds(content)

    # Write the output file in ds2l format.
    with open(output_file, 'w') as f:
        f.write(f"{imports}\n\n")
        f.write(f"object {obj_name} {{\n\n")
        f.write(f"  def {fn_name}({new_params}): {ret_type} = {{\n")
        f.write(f"  require({orig_req}\n")
        for spec in specs:
            f.write(f"\t {spec}\n")
        f.write("  )\n\n")
        f.write(build_layers(content))
        f.write("\n\n")
        f.write(f"  }} {ensuring}\n\n")
        f.write("}\n")

    print(f"Done. Written to {output_file}")


def batch_convert(input_dir, output_dir):
    # Convert every .scala file in input_dir and write results to output_dir.
    import os
    os.makedirs(output_dir, exist_ok=True)
    for fname in sorted(os.listdir(input_dir)):
        if fname.endswith(".scala"):
            inp = os.path.join(input_dir, fname)
            out = os.path.join(output_dir, fname)
            print(f"\n=== Converting {fname} ===")
            convert(inp, out)


if __name__ == "__main__":
    import os
    if len(sys.argv) == 3 and not os.path.isdir(sys.argv[1]):
        # Two file paths → single-file conversion.
        convert(sys.argv[1], sys.argv[2])
    elif len(sys.argv) in (2, 3):
        # If output_dir is omitted, defaults to testcases/llm/nn-bench.
        input_dir  = sys.argv[1]
        output_dir = sys.argv[2] if len(sys.argv) == 3 else "testcases/llm/nn-bench"
        batch_convert(input_dir, output_dir)
    elif len(sys.argv) == 1:
        # No arguments → use hardcoded default paths.
        batch_convert("testcases/llm/qnn", "testcases/llm/nn-bench")
    else:
        print("Usage: python convert.py <input_dir> [<output_dir>]")
        print("   or: python convert.py <input.scala> <output.scala>")
        sys.exit(1)
