

import daisy.lang._
import Real._


object InvertedPendulum {
  // 0.5 f32
  def invpendulum(s1: Real, s2: Real, s3: Real, s4: Real) = {
    require(-50 <= s1 && s1 <= 50 && -10 <= s2 && s2 <= 10 && -0.785 <= s3 && s3 <= 0.785 && -0.785 <= s4 && s4 <= 0.785)

    val result = 1.0000 * s1 + 1.6567 * s2 + (-18.6854) * s3 + (-3.4594) * s4
  	result
  } ensuring(res => res +/- 1e-5)
}
