#include <math.h>


/* @pre: ((-50.0 <= s1) && (s1 <= 50.0) && (-10.0 <= s2) && (s2 <= 10.0) && (-0.785 <= s3) && (s3 <= 0.785) && (-0.785 <= s4) && (s4 <= 0.785)) */
/* @post: (res) => (res +/- 1.0e-05) */
double invpendulum(double s1, double s2, double s3, float s4) {
  float _const0 = 1.0f;
  float _const1 = 1.6567f;
  float _const2 = -18.6854f;
  double _const3 = -3.4594;
  double _tmp = (_const0 * s1);
  double _tmp1 = (_const1 * s2);
  double _tmp2 = (_tmp + _tmp1);
  double _tmp3 = (_const2 * s3);
  double _tmp4 = (_tmp2 + _tmp3);
  double _tmp5 = (_const3 * s4);
  return (_tmp4 + _tmp5);
} // [-83.950668, 83.950668] +/- 1.4477789706393797e-06

