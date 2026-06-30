import daisy.lang._
import Real._
import daisy.lang.Vector._

object SmallNN {

  def nn1(x: Vector, weights1: Matrix, weights2: Matrix, bias1: Vector, bias2: Vector): Vector = {
  require(x >= -10.0 && x <= 10.0 && x.size(2)
	 && x.specV(Set(((0, 0),(-10.0, 10.0)), ((1, 1),(-5.0, 5.0))))
	 && weights1 >= 0.09 && weights1 <= 0.31 && weights1.size(2,2)
		&& weights1.specM(Set((Set((0, 0), (1, 0), (1, 1)),(0.09, 0.21)),
		(Set((0, 1)),(0.29, 0.31))))
	 && weights2 >= 0.09 && weights2 <= 0.21 && weights2.size(1,2)
		&& weights2.specM(Set((Set((0, 0), (0, 1)),(0.09, 0.21))))
	 && bias1 >= 0.99 && bias1 <= 2.01 && bias1.size(2)
		&& bias1.specV(Set(((0, 0),(0.99, 1.01)),
		((1, 1),(1.99, 2.01))))
	 && bias2 >= 0.49 && bias2 <= 0.51 && bias2.size(1)
		&& bias2.specV(Set(((0, 0),(0.49, 0.51))))
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
