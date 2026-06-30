import daisy.lang._
import Real._


object Doppler {

  //0.5 f32
  def doppler(u: Real, v: Real, T: Real): Real = {
    require(-100.0 <= u && u <= 100 && 20 <= v && v <= 20000 && -30 <= T && T <= 50)

    val t1 = 331.4 + 0.6 * T
    val result = (- (t1) *v) / ((t1 + u)*(t1 + u))
    result

  } ensuring(res => res +/- 1.25e-4)
}
