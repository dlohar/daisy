
import daisy.lang._
import Real._


object Sine {
  // 0.5 f32
  def sine(x: Real): Real = {
    require(x > -1.57079632679 && x < 1.57079632679)
    val result = x - (x*x*x)/6.0 + (x*x*x*x*x)/120.0 - (x*x*x*x*x*x*x)/5040.0
  	result
  } ensuring(res => res +/- 2e-7)
}
