
import daisy.lang._
import Real._

/*
  These benchmarks were used by the Real2Float tool,
  and come from the proof of the Kepler conjecture
  Introduction to the flyspec project, T.C. Hales, Dagstuhl 2006
*/
object Kepler1 {
  // 0.5 f32
  def kepler1(x1: Real, x2: Real, x3: Real, x4: Real): Real = {
    require(4 <= x1 && x1 <= 6.36 && 4 <= x2 && x2 <= 6.36 && 4 <= x3 && x3 <= 6.36 &&
      4 <= x4 && x4 <= 6.36)
    val result = x1 * x4 * (-x1 + x2 + x3 - x4) + x2 * (x1 - x2 + x3 + x4) + x3 * (x1 + x2 - x3 + x4) -
      x2 * x3 * x4 - x1 * x3 - x1 * x2 - x4
    result
  } ensuring(res => res +/- 1.25e-4)
}
