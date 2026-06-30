import daisy.lang._
import Real._

object Func {  
	
  def func(x: Real, y: Real): Real = {
    require(0 <= x && x <= 1 && 0 <= y && y <= 1)

    val t1 = x - y
    val t2 = t1 * t1
    val t3 = 2 * t2
    val result = t3 / 3.0
    result
  } ensuring (res => res +/- 1e-10)
}