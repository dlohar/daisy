
import daisy.lang._
import Real._


object RigidBody1 {
  // 0.5 f32
  def rigidBody1(x1: Real, x2: Real, x3: Real): Real = {
    require(-15.0 <= x1 && x1 <= 15 && -15.0 <= x2 && x2 <= 15.0 && -15.0 <= x3 && x3 <= 15)

    val result = -x1*x2 - 2*x2*x3 - x1 - x3
    result
  } ensuring(res => res +/- 1e-4)
}
