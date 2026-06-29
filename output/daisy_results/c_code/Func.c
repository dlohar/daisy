#include <math.h>


/* @pre: ((0.0 <= x) && (x <= 1.0) && (0.0 <= y) && (y <= 1.0)) */
/* @post: (res) => (res +/- 1.0e-10) */
double func(double x, double y) {
  double _const0 = 2;
  double _const1 = 3.0;
  double t1 = (x - y);
  double t2 = (t1 * t1);
  double t3 = (_const0 * t2);
  double result = (t3 / _const1);
  return result;
} // [-0.6666666666666666, 0.6666666666666666] +/- 5.736152293896642e-16

