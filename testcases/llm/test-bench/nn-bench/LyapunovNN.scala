import daisy.lang._
import Real._
import daisy.lang.Vector._

object LyapunovNN {

  def nn1(x: Vector, weights1: Matrix, weights2: Matrix, bias1: Vector, bias2: Vector): Vector = {
  require(x >= -6.0 && x <= 6.0 && x.size(2)
	 && x.specV(Set(((0, 0),(-6.0, 6.0)), ((1, 1),(-6.0, 6.0))))
	 && weights1 >= -0.646301 && weights1 <= 1.031177 && weights1.size(6,2)
		&& weights1.specM(Set((Set((3, 0)),(-0.646301, -0.626301)),
		(Set((4, 1)),(-0.542236, -0.522236)),
		(Set((3, 1)),(-0.404451, -0.384451)),
		(Set((0, 0), (0, 1), (1, 0), (1, 1), (2, 1), (4, 0)),(-0.073488, 0.04138)),
		(Set((5, 1)),(0.089215, 0.109215)),
		(Set((5, 0)),(0.615589, 0.635589)),
		(Set((2, 0)),(1.011177, 1.031177))))
	 && weights2 >= -0.818469 && weights2 <= 1.118173 && weights2.size(1,6)
		&& weights2.specM(Set((Set((0, 2)),(-0.818469, -0.798469)),
		(Set((0, 0)),(-0.533092, -0.513092)),
		(Set((0, 4)),(-0.099498, -0.079498)),
		(Set((0, 3)),(0.399467, 0.419467)),
		(Set((0, 5)),(0.903873, 0.923873)),
		(Set((0, 1)),(1.098173, 1.118173))))
	 && bias1 >= -1.265824 && bias1 <= 1.558368 && bias1.size(6)
		&& bias1.specV(Set(((3, 3),(-1.265824, -1.245824)),
		((0, 0),(-0.884696, -0.768576)),
		((5, 5),(-0.884696, -0.768576)),
		((1, 1),(1.144886, 1.19608)),
		((2, 2),(1.144886, 1.19608)),
		((4, 4),(1.538368, 1.558368))))
	 && bias2 >= 0.520713 && bias2 <= 0.540713 && bias2.size(1)
		&& bias2.specV(Set(((0, 0),(0.520713, 0.540713))))
  )

    val layer1 = (weights1.x(x) + bias1).map(el => {
      val relu = Vector(List(el, 0.0))
      relu.max()
    })
    val layer2 = (weights2.x(layer1) + bias2).map(el => {
      val relu = Vector(List(el, 0.0))
      relu.max()
    })

    layer2

  } ensuring(res => res +/- 1e-3)

}
