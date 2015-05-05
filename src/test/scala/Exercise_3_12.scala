import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_12 extends FlatSpec with Matchers {

  "reversed list" should "be have elements in reverse order" in {
    val l = List(1, 2, 3)
    reverse(l) shouldBe List(3, 2, 1)
  }

}
