
import daisy.lang._
import Real._

object Traincar1 {

  // y1, y2: <1, 30, 16>    s1, s2, s3: <1, 30, 25>
  def out1(s0: Real, s1: Real, s2: Real) = {
    require(0 <= s0 && s0 <= 4.6 && 0 <= s1 && s1 <= 10 && 0 <= s2 && s2 <= 10)
    (-3.795323e2) * s0 + (-5.443608e2) * s1 + 92.729 * s2 + 4.5165916241610748e3
  }

  def state1(s0: Real, s1: Real, s2: Real, y0: Real, y1: Real) = {
    require(0 <= s0 && s0 <= 4.6 && 0 <= s1 && s1 <= 10 && 0 <= s2 && s2 <= 10 &&
      0 <= y0 && y0 <= 10 && 0 <= y1 && y1 <= 10)
    (9.9992292212695999e-01)*s0+ (6.7987387059578006e-02)*s1+ (-5.7849982690687002e-02)*s2 +
      (-6.7093068270769995e-02)*y0 + (5.6868444245656999e-02)*y1+ (1.93109421e-07)*4.5165916241610748e+03
  }

  def state2(s0: Real, s1: Real, s2: Real, y0: Real, y1: Real) = {
    require(0 <= s0 && s0 <= 4.6 && 0 <= s1 && s1 <= 10 && 0 <= s2 && s2 <= 10 &&
      0 <= y0 && y0 <= 10 && 0 <= y1 && y1 <= 10)
    (-2.1755689728790001e-03)*s0+ (9.8343791204296505e-01)*s1+ (2.6908497812900001e-03)*s2 +
      (1.3497550507479000e-02)*y0 + (-2.1628302791680000e-03)*y1+ (5.615999103e-06)*4.5165916241610748e+03
  }

  def state3(s0: Real, s1: Real, s2: Real, y0: Real, y1: Real) = {
    require(0 <= s0 && s0 <= 4.6 && 0 <= s1 && s1 <= 10 && 0 <= s2 && s2 <= 10 &&
      0 <= y0 && y0 <= 10 && 0 <= y1 && y1 <= 10)
    (7.5141305955000001e-05)*s0+ (2.4840831806619999e-03)*s1+ (9.9188004018882503e-01)*s2 + (-2.4770170720600001e-03)*y0 +
     (8.1097048460159991e-03)*y1+ (7.060315e-09)*4.5165916241610748e+03
  }


}