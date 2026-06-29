#include <math.h>


/* @pre: ((x >= 0.0) && (x < 10.0)) */
/* @post: (res) => (res +/- 0.0001) */
double sqroot(float x) {
  float _const0 = 0.5f;
  float _const1 = 1.0f;
  float _const2 = 0.125f;
  double _const3 = 0.0625;
  double _const4 = 0.0390625;
  double _tmp = (_const0 * x);
  double _tmp2 = (_const1 + _tmp);
  double _tmp1 = (_const2 * x);
  double _tmp3 = (_tmp1 * x);
  double _tmp6 = (_tmp2 - _tmp3);
  double _tmp4 = (_const3 * x);
  double _tmp5 = (_tmp4 * x);
  double _tmp7 = (_tmp5 * x);
  double _tmp11 = (_tmp6 + _tmp7);
  double _tmp8 = (_const4 * x);
  double _tmp9 = (_tmp8 * x);
  double _tmp10 = (_tmp9 * x);
  double _tmp12 = (_tmp10 * x);
  return (_tmp11 - _tmp12);
} // [-402.125, 68.5] +/- 7.963181114800672e-05

