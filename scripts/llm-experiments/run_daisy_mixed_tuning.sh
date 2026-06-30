#!/bin/bash

TESTCASE_DIR="testcases/llm/test-bench"
OUTPUT_DIR="output/daisy_results"
COST_FILE="$OUTPUT_DIR/costs.txt"
C_OUTPUT_DIR="$OUTPUT_DIR/c_code"

# Create output directories
mkdir -p "$OUTPUT_DIR"
mkdir -p "$C_OUTPUT_DIR"

# Clear previous cost results
> "$COST_FILE"

# Compile Daisy first
echo "Compiling Daisy..."
sbt compile
if [ $? -ne 0 ]; then
    echo "Compilation failed. Exiting."
    exit 1
fi
echo "Compilation successful."
echo "=================================================="

echo "Running Daisy's mixed-tuning on all testcases in $TESTCASE_DIR"
echo "=================================================="

# Loop over all .scala files in testcases/llm
for testcase in "$TESTCASE_DIR"/*.scala; do

    benchmark=$(basename "$testcase" .scala)

    echo "Running: $benchmark"

    # Run Daisy
    output=$(sbt -batch "run --mixed-tuning --precision=Quad --codegen --lang=C $testcase" 2>&1)
    echo "$output"

    # Check if error bound was not satisfied
    if echo "$output" | grep -q "Error bound is not satisfied"; then
        echo "$benchmark, ERROR BOUND NOT SATISFIED WITH MAX PRECISION" >> "$COST_FILE"
        echo "Warning: error bound not satisfied for $benchmark, deleting generated code"

        # Delete any generated C files
        for c_file in output/*.c; do
            if [ -f "$c_file" ]; then
                rm "$c_file"
                echo "Deleted $(basename $c_file)"
            fi
        done

    else
        # Extract the final cost from the line:
        # "initial Cost: X - final cost: Y"
        final_cost=$(echo "$output" | grep "final cost:" | sed 's/.*final cost: //')

        if [ -n "$final_cost" ]; then
            echo "$benchmark, $final_cost" >> "$COST_FILE"
            echo "Cost recorded: $final_cost"
        else
            echo "$benchmark, N/A" >> "$COST_FILE"
            echo "Warning: could not extract cost for $benchmark"
        fi

        # Move generated C files to output directory
        for c_file in output/*.c; do
            if [ -f "$c_file" ]; then
                mv "$c_file" "$C_OUTPUT_DIR/"
                echo "Moved $(basename $c_file) to $C_OUTPUT_DIR"
            fi
        done
    fi

    echo "--------------------------------------------------"
done

echo ""
echo "Done. Costs written to $COST_FILE"
echo "C code files are in $C_OUTPUT_DIR"
