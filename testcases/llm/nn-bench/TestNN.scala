import daisy.lang._
import Real._
import daisy.lang.Vector._

object TestNN {

  def nn1(x: Vector, weights1: Matrix, weights2: Matrix, bias1: Vector, bias2: Vector): Vector = {
  require(x >= -10.0 && x <= 10.0 && x.size(2)
	 && x.specV(Set(((0, 0),(-10.0, 10.0)), ((1, 1),(-5.0, 5.0))))
	 && weights1 >= 1.19 && weights1 <= 5.61 && weights1.size(3,2)
		&& weights1.specM(Set((Set((0, 0)),(1.19, 1.21)),
		(Set((0, 1)),(2.29, 2.31)),
		(Set((1, 0)),(3.39, 3.41)),
		(Set((1, 1), (2, 0)),(4.49, 4.51)),
		(Set((2, 1)),(5.59, 5.61))))
	 && weights2 >= 1.09 && weights2 <= 5.51 && weights2.size(3,3)
		&& weights2.specM(Set((Set((0, 0)),(1.09, 1.11)),
		(Set((0, 1), (1, 0)),(2.19, 2.21)),
		(Set((0, 2), (1, 1), (2, 0)),(3.29, 3.31)),
		(Set((1, 2), (2, 1)),(4.39, 4.41)),
		(Set((2, 2)),(5.49, 5.51))))
	 && bias1 >= 0.99 && bias1 <= 3.01 && bias1.size(3)
		&& bias1.specV(Set(((0, 0),(0.99, 1.01)),
		((1, 1),(1.99, 2.01)),
		((2, 2),(2.99, 3.01))))
	 && bias2 >= 0.49 && bias2 <= 0.71 && bias2.size(3)
		&& bias2.specV(Set(((0, 0),(0.49, 0.61)),
		((1, 1),(0.49, 0.61)),
		((2, 2),(0.69, 0.71))))
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
