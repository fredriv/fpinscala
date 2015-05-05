import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_15 extends FlatSpec with Matchers {

  "Flattening a list of lists" should "result in a list all the elements of the sublists concatenated" in {
    val l = List(List(1, 2), Nil, List(3))
    flatten(l) shouldBe List(1, 2, 3)
  }

}
