#include <math.h>


/* @pre: ((x > -1.57079632679) && (x < 1.57079632679)) */
/* @post: (res) => (res +/- 2.0e-07) */
double sine(double x) {
  float _const0 = 6.0f;
  double _const1 = 120.0;
  double _const2 = 5040.0;
  double _tmp = (x * x);
  double _tmp1 = (_tmp * x);
  double _tmp2 = (_tmp1 / _const0);
  double _tmp7 = (x - _tmp2);
  double _tmp3 = (x * x);
  double _tmp4 = (_tmp3 * x);
  double _tmp5 = (_tmp4 * x);
  double _tmp6 = (_tmp5 * x);
  double _tmp8 = (_tmp6 / _const1);
  double _tmp15 = (_tmp7 + _tmp8);
  double _tmp9 = (x * x);
  double _tmp10 = (_tmp9 * x);
  double _tmp11 = (_tmp10 * x);
  double _tmp12 = (_tmp11 * x);
  double _tmp13 = (_tmp12 * x);
  double _tmp14 = (_tmp13 * x);
  double _tmp16 = (_tmp14 / _const2);
  return (_tmp15 - _tmp16);
} // [-2.3011348046703466, 2.3011348046703466] +/- 1.1296729607621835e-15

