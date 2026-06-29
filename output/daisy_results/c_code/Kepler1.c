#include <math.h>


/* @pre: ((4.0 <= x1) && (x1 <= 6.36) && (4.0 <= x2) && (x2 <= 6.36) && (4.0 <= x3) && (x3 <= 6.36) && (4.0 <= x4) && (x4 <= 6.36)) */
/* @post: (res) => (res +/- 0.000125) */
double kepler1(float x1, float x2, float x3, double x4) {
  double _tmp3 = (x1 * x4);
  double _tmp = -(x1);
  double _tmp1 = (_tmp + x2);
  double _tmp2 = (_tmp1 + x3);
  double _tmp4 = (_tmp2 - x4);
  double _tmp8 = (_tmp3 * _tmp4);
  double _tmp5 = (x1 - x2);
  double _tmp6 = (_tmp5 + x3);
  double _tmp7 = (_tmp6 + x4);
  double _tmp9 = (x2 * _tmp7);
  double _tmp13 = (_tmp8 + _tmp9);
  double _tmp10 = (x1 + x2);
  double _tmp11 = (_tmp10 - x3);
  double _tmp12 = (_tmp11 + x4);
  double _tmp14 = (x3 * _tmp12);
  double _tmp16 = (_tmp13 + _tmp14);
  double _tmp15 = (x2 * x3);
  double _tmp17 = (_tmp15 * x4);
  double _tmp18 = (_tmp16 - _tmp17);
  double _tmp19 = (x1 * x3);
  double _tmp20 = (_tmp18 - _tmp19);
  double _tmp21 = (x1 * x2);
  double _tmp22 = (_tmp20 - _tmp21);
  return (_tmp22 - x4);
} // [-490.320768, 282.739712] +/- 8.647480357513048e-05

