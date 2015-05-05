import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_11 extends FlatSpec with Matchers {

  "sumFoldL" should "return sum of elements" in {
    val l = List(1, 2, 3)
    sumFoldL(l) shouldBe 6
  }

  "productFoldL" should "return product of elements" in {
    val l = List(4.0, 3.0, 0.5)
    productFoldL(l) shouldBe 6.0
  }

  "lengthFoldL" should "return length of list" in {
    val l = List(1, 2, 3, 4)
    lengthFoldL(l) shouldBe 4
  }
}
