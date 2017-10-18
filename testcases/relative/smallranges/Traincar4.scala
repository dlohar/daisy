import daisy.lang._
import Real._


object Traincar4 {

  // y: <1, 30, 16>     s: <1, 30, 25>
//  def out1(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real) = {
//    require(-2.5 <= s0 && s0 <= 6.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
//      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12)
//      (-1201.0) * s0  + (-4876.0) * s1  + 1.3415999999999998E+04 * s2  + (-10484.0) * s3  + (-774.0) * s4  + (-1.3620000000000002E+04) * s5  +
//       10481.0 * s6  + 20425.0 * s7  + (-17815.0) * s8  + 5.2121094496644555E+03
//  }
//
//  def state1(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
//    require(-2.5 <= s0 && s0 <= 6.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
//      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
//      -2 <= y0 && y0 <= 12 && -2 <= y1 && y1 <= 12 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -2 <= y4 && y4 <= 12)
//    s0 + (-9.6239E-08)*s1+ (2.65102E-07)*s2+ (-2.07133E-07)*s3+ (6.97639E-05)*s4+ (-4.78152E-05)*s5+ (-2.63725E-05)*s6+ (-1.05202E-05)*s7+ (-1.57626E-05)*s8 +
//      (3.0220751E-05)*y0 + (-5.2453841E-05)*y1+ (2.6579541E-05)*y2+ (1.0923688E-05)*y3+ (1.5410654E-05)*y4+ (1.9755163E-11)*5.2121094496644555E+03
//  }
//
//  def state2(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
//    require(-2.5 <= s0 && s0 <= 6.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
//      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
//      -2 <= y0 && y0 <= 12 && -2 <= y1 && y1 <= 12 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -2 <= y4 && y4 <= 12)
//    (-1.13598E-08)*s0 + (1.0)*s1+ (1.2786E-07)*s2+ (-9.96874E-08)*s3+ (3.36288E-05)*s4+ (3.94595E-05)*s5+ (-6.09589E-05)*s6+
//    (-3.51073E-05)*s7+ (2.7313E-06)*s8+ (-3.3636111E-05)*y0 + (6.0410747E-05)*y1+ (-3.8941208E-05)*y2+ (3.5301806E-05)*y3+
//    (-2.9009623E-06)*y4+ (9.522692E-12)*5.2121094496644555E+03
//  }
//
//  def state3(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
//    require(-2.5 <= s0 && s0 <= 6.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
//      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
//      -2 <= y0 && y0 <= 12 && -2 <= y1 && y1 <= 12 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -2 <= y4 && y4 <= 12)
//    (-3.85494E-09)*s0 + (-1.55578E-08)*s1+ (1.0)*s2+ (-3.33852E-08)*s3+ (1.13515E-05)*s4+ (8.09597E-06)*s5+ (3.75166E-05)*s6+
//    (-7.28888E-05)*s7+ (7.51347E-06)*s8 + (-1.1353997E-05)*y0 + (-8.1397399E-06)*y1+ (6.2517037E-05)*y2+
//    (-2.7045432E-05)*y3+ (-7.570773E-06)*y4+ (3.2144001E-12)*5.2121094496644555E+03
//  }
//
//  def state4(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
//    require(-2.5 <= s0 && s0 <= 6.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
//      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
//      -2 <= y0 && y0 <= 12 && -2 <= y1 && y1 <= 12 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -2 <= y4 && y4 <= 12)
//    (-4.88831E-09)*s0 + (-1.94328E-08)*s1+ (5.40591E-08)*s2+ (1.0)*s3+ (1.41246E-05)*s4+ (-1.33425E-05)*s5+ (4.35487E-06)*s6+
//    (1.06102E-04)*s7+ (-9.66574E-05)*s8+ (-1.4127737E-05)*y0 + (1.328804E-05)*y1+ (-4.3128989E-06)*y2+
//    (-6.0208156E-06)*y3+ (-3.4137075E-06)*y4+ (3.9997189E-12)*5.2121094496644555E+03
//  }
//
//  def state5(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
//    require(-2.5 <= s0 && s0 <= 6.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
//      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
//      -2 <= y0 && y0 <= 12 && -2 <= y1 && y1 <= 12 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -2 <= y4 && y4 <= 12)
//    (-6.84591E-04)*s0 + (-0.00276041)*s1+ (0.00759572)*s2+ (-0.00593566)*s3+ (0.999506)*s4+ (-0.00770228)*s5+ (0.00593952)*s6+
//    (0.0115632)*s7+ (-0.0100812)*s8+ (5.4816343E-05)*y0 + (-8.1959323E-06)*y1+(-5.0852166E-06)*y2+ (-1.5117184E-07)*y3+
//    (-4.5614134E-06)*y4+ (5.6615597E-07)*5.2121094496644555E+03
//
//  }
//
//  def state6(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
//    require(-2.5 <= s0 && s0 <= 6.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
//      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
//      -2 <= y0 && y0 <= 12 && -2 <= y1 && y1 <= 12 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -2 <= y4 && y4 <= 12)
//    (7.81569E-06)*s0 +(-7.83331E-06)*s1+ (3.894E-08)*s2+ (-3.04854E-08)*s3+ (1.02522E-05)*s4+ (0.999937)*s5+ (9.27415E-06)*s6+
//     (6.88119E-06)*s7+ (-5.63471E-06)*s8 + (-9.161729E-06)*y0 + (6.1088274E-05)*y1+ (-8.1509892E-06)*y2+ (-6.8219061E-06)*y3+ (5.5829936E-06)*y4+
//      (2.9031464E-12)*5.2121094496644555E+03
//
//  }
//
//  def state7(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
//    require(-2.5 <= s0 && s0 <= 6.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
//      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
//      -2 <= y0 && y0 <= 12 && -2 <= y1 && y1 <= 12 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -2 <= y4 && y4 <= 12)
//    (-2.3463E-09)*s0 +(7.80955E-06)*s1+ (-7.79273E-06)*s2+ (-2.06835E-08)*s3+ (6.95227E-06)*s4+ (8.71732E-06)*s5+ (0.999932)*s6+
//     (1.01306E-05)*s7+ (-1.09525E-06)*s8+ (-6.953786E-06)*y0 + (-7.6514151E-06)*y1+ (6.5402276E-05)*y2+ (-8.997669E-06)*y3+ (1.0601845E-06)*y4+
//      (1.9686912E-12)*5.2121094496644555E+03
//
//  }

  def state8(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
    require(250 <= s0 && s0 <= 650 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
      -2 <= s5 && s5 <= 12 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
      -2 <= y0 && y0 <= 12 && -2 <= y1 && y1 <= 12 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -200000 <= y4 && y4 <= -120000)
    (2.5093E-10)*s0 +(9.15884E-10)*s1+ (7.81656E-06)*s2+ (-7.81701E-06)*s3+ (-6.54335E-07)*s4+ (6.87341E-06)*s5+ (1.00368E-05)*s6+ (0.999907)*s7+
     (3.32876E-05)*s8+ (6.5448232E-07)*y0 + (-6.8708837E-06)*y1+ (-8.9460042E-06)*y2+ (9.0317123E-05)*y3+ (-3.2191562E-05)*y4+
      (-1.8530512E-13)*5.2121094496644555E+03
  }

  def state9(s0: Real, s1: Real, s2: Real, s3: Real, s4: Real, s5: Real, s6: Real, s7: Real, s8: Real, y0: Real, y1: Real, y2: Real, y3: Real, y4: Real) = {
    require(-250 <= s0 && s0 <= -0.5 && -2.5 <= s1 && s1 <= 6.5 && -2.5 <= s2 && s2 <= 6.5 && -2.5 <= s3 && s3 <= 6.5 && -2 <= s4 && s4 <= 12 &&
      -2000000 <= s5 && s5 <= -1200000 && -2 <= s6 && s6 <= 12 && -2 <= s7 && s7 <= 12 && -2 <= s8 && s8 <= 12 &&
      -200 <= y0 && y0 <= -120 && 200000 <= y1 && y1 <= 1200000 && -2 <= y2 && y2 <= 12 && -2 <= y3 && y3 <= 12 && -2 <= y4 && y4 <= 12)
    (-1.73572E-09)*s0 +(-6.90441E-09)*s1+ (1.91831E-08)*s2+ (7.80416E-06)*s3+ (5.01527E-06)*s4+ (-4.73947E-06)*s5+ (4.30545E-07)*s6+
     (3.35281E-05)*s7+ (0.999934)*s8 + (-5.0163739E-06)*y0 + (4.7201386E-06)*y1+ (-4.156438E-07)*y2+ (-3.2406398E-05)*y3+ (6.4987306E-05)*y4+
      (1.4201936E-12)*5.2121094496644555E+03

  }

}