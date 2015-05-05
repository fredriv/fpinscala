import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_14 extends FlatSpec with Matchers {

  "Appending a list to another" should "result in a list with the elements of the original list followed by the elements of the appended list" in {
    val l1 = List(1, 2, 3)
    val l2 = List(4, 5, 6)

    appendViaFold(l1, l2) shouldBe List(1, 2, 3, 4, 5, 6)
  }
}
