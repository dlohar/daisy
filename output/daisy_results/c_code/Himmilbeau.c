#include <math.h>


/* @pre: ((-5.0 <= x1) && (x1 <= 5.0) && (-5.0 <= x2) && (x2 <= 5.0)) */
/* @post: (res) => (res +/- 0.000275) */
double himmilbeau(double x1, double x2) {
  float _const0 = 11.0f;
  float _const1 = 11.0f;
  float _const2 = 7.0f;
  double _const3 = 7;
  double _tmp = (x1 * x1);
  double _tmp1 = (_tmp + x2);
  double _tmp4 = (_tmp1 - _const0);
  double _tmp2 = (x1 * x1);
  double _tmp3 = (_tmp2 + x2);
  double _tmp5 = (_tmp3 - _const1);
  double _tmp12 = (_tmp4 * _tmp5);
  double _tmp6 = (x2 * x2);
  double _tmp7 = (x1 + _tmp6);
  double _tmp10 = (_tmp7 - _const2);
  double _tmp8 = (x2 * x2);
  double _tmp9 = (x1 + _tmp8);
  double _tmp11 = (_tmp9 - _const3);
  double _tmp13 = (_tmp10 * _tmp11);
  double result = (_tmp12 + _tmp13);
  return result;
} // [-1630.0, 3050.0] +/- 2.3252511027749283e-12

