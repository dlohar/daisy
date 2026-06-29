
import daisy.lang._
import Real._


object Bspline1 {

  //0.5 f32
  def bspline1(u: Real): Real = {
    require(0 <= u && u <= 1)
    (3 * u*u*u - 6 * u*u + 4) / 6.0
  } ensuring (res => res +/- 2e-7)
}