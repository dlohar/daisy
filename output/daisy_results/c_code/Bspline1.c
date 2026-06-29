#include <math.h>


/* @pre: ((0.0 <= u) && (u <= 1.0)) */
/* @post: (res) => (res +/- 2.0e-07) */
double bspline1(double u) {
  float _const0 = 3.0f;
  float _const1 = 6.0f;
  double _const2 = 4;
  double _const3 = 6.0;
  double _tmp = (_const0 * u);
  double _tmp1 = (_tmp * u);
  double _tmp3 = (_tmp1 * u);
  double _tmp2 = (_const1 * u);
  double _tmp4 = (_tmp2 * u);
  double _tmp5 = (_tmp3 - _tmp4);
  double _tmp6 = (_tmp5 + _const2);
  return (_tmp6 / _const3);
} // [-0.3333333333333333, 1.1666666666666667] +/- 7.956598343146956e-16

