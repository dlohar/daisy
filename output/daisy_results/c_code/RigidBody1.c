#include <math.h>


/* @pre: ((-15.0 <= x1) && (x1 <= 15.0) && (-15.0 <= x2) && (x2 <= 15.0) && (-15.0 <= x3) && (x3 <= 15.0)) */
/* @post: (res) => (res +/- 0.0001) */
double rigidBody1(float x1, float x2, double x3) {
  double _const0 = 2;
  double _tmp = -(x1);
  double _tmp2 = (_tmp * x2);
  double _tmp1 = (_const0 * x2);
  double _tmp3 = (_tmp1 * x3);
  double _tmp4 = (_tmp2 - _tmp3);
  double _tmp5 = (_tmp4 - x1);
  return (_tmp5 - x3);
} // [-705.0, 705.0] +/- 3.67164616354998e-05

