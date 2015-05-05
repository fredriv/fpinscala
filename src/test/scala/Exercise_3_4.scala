import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_4 extends FlatSpec with Matchers  {

  "Dropping first two elements" should "return rest of list" in {
    val l = List(1, 2, 3)
    drop(l, 2) shouldBe List(3)
  }

  "Dropping from empty list" should "return empty list" in {
    val l = Nil
    drop(l, 3) shouldBe Nil
  }
}
