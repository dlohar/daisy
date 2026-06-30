#include <math.h>


/* @pre: ((-2.5 <= s0) && (s0 <= 6.5) && (-2.5 <= s1) && (s1 <= 6.5) && (-2.5 <= s2) && (s2 <= 6.5) && (-2.5 <= s3) && (s3 <= 6.5) && (-2.0 <= s4) && (s4 <= 12.0) && (-2.0 <= s5) && (s5 <= 12.0) && (-2.0 <= s6) && (s6 <= 12.0) && (-2.0 <= s7) && (s7 <= 12.0) && (-2.0 <= s8) && (s8 <= 12.0) && (-2.0 <= y0) && (y0 <= 12.0) && (-2.0 <= y1) && (y1 <= 12.0) && (-2.0 <= y2) && (y2 <= 12.0) && (-2.0 <= y3) && (y3 <= 12.0) && (-2.0 <= y4) && (y4 <= 12.0)) */
/* @post: (res) => (res +/- 2.75e-06) */
double train4_state8(float s0, float s1, float s2, float s3, float s4, float s5, float s6, float s7, float s8, float y0, float y1, float y2, float y3, float y4) {
  float _const0 = 2.5093E-10f;
  float _const1 = 9.15884E-10f;
  float _const2 = 7.81656E-6f;
  float _const3 = -7.81701E-6f;
  float _const4 = -6.54335E-7f;
  float _const5 = 6.87341E-6f;
  float _const6 = 1.00368E-5f;
  double _const7 = 0.999907;
  double _const8 = 3.32876E-5;
  double _const9 = 6.5448232E-7;
  double _const10 = -6.8708837E-6;
  double _const11 = -8.9460042E-6;
  double _const12 = 9.0317123E-5;
  double _const13 = -3.2191562E-5;
  float _const14 = -9.65830567023206E-10f;
  float _tmp = (_const0 * s0);
  float _tmp1 = (_const1 * s1);
  float _tmp2 = (_tmp + _tmp1);
  float _tmp3 = (_const2 * s2);
  float _tmp4 = (_tmp2 + _tmp3);
  float _tmp5 = (_const3 * s3);
  float _tmp6 = (_tmp4 + _tmp5);
  float _tmp7 = (_const4 * s4);
  float _tmp8 = (_tmp6 + _tmp7);
  float _tmp9 = (_const5 * s5);
  float _tmp10 = (_tmp8 + _tmp9);
  float _tmp11 = (_const6 * s6);
  float _tmp12 = (_tmp10 + _tmp11);
  double _tmp13 = (_const7 * s7);
  double _tmp14 = (_tmp12 + _tmp13);
  double _tmp15 = (_const8 * s8);
  double _tmp16 = (_tmp14 + _tmp15);
  double _tmp17 = (_const9 * y0);
  double _tmp18 = (_tmp16 + _tmp17);
  double _tmp19 = (_const10 * y1);
  double _tmp20 = (_tmp18 + _tmp19);
  double _tmp21 = (_const11 * y2);
  double _tmp22 = (_tmp20 + _tmp21);
  double _tmp23 = (_const12 * y3);
  double _tmp24 = (_tmp22 + _tmp23);
  double _tmp25 = (_const13 * y4);
  double _tmp26 = (_tmp24 + _tmp25);
  double result = (_tmp26 + _const14);
  return result;
} // [-2.0007506480973056, 12.0007457153371] +/- 4.769437984464831e-07

