#include <math.h>


/* @pre: ((-4.5 <= v) && (v <= -0.3) && (0.4 <= w) && (w <= 0.9) && (3.8 <= r) && (r <= 7.8)) */
/* @post: (res) => (res +/- 2.5e-05) */
double turbine1(double v, double w, float r) {
  float _const0 = 2.0f;
  float _const1 = 3.0f;
  double _const2 = 2;
  double _const3 = 3;
  double _const4 = 0.125;
  double _const5 = 1;
  double _const6 = 4.5;
  double _tmp = (r * r);
  double _tmp1 = (_const0 / _tmp);
  double _tmp10 = (_const1 + _tmp1);
  double _tmp2 = (_const2 * v);
  double _tmp3 = (_const3 - _tmp2);
  double _tmp6 = (_const4 * _tmp3);
  double _tmp4 = (w * w);
  double _tmp5 = (_tmp4 * r);
  double _tmp7 = (_tmp5 * r);
  double _tmp8 = (_tmp6 * _tmp7);
  double _tmp9 = (_const5 - v);
  double _tmp11 = (_tmp8 / _tmp9);
  double _tmp12 = (_tmp10 - _tmp11);
  return (_tmp12 - _const6);
} // [-58.32912689020381, -1.5505285721480735] +/- 3.656772343479721e-06

