#include <math.h>


/* @pre: ((-100.0 <= u) && (u <= 100.0) && (20.0 <= v) && (v <= 20000.0) && (-30.0 <= T) && (T <= 50.0)) */
/* @post: (res) => (res +/- 0.000125) */
double doppler(float u, float v, float T) {
  double _const0 = 0.6;
  double _const1 = 331.4;
  double _tmp = (_const0 * T);
  double t1 = (_const1 + _tmp);
  double _tmp1 = -(t1);
  double _tmp4 = (_tmp1 * v);
  double _tmp2 = (t1 + u);
  double _tmp3 = (t1 + u);
  double _tmp5 = (_tmp2 * _tmp3);
  double result = (_tmp4 / _tmp5);
  return result;
} // [-158.7191444098274, -0.02944244059231351] +/- 2.389686436884487e-05

