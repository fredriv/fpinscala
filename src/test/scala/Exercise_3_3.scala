import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_3 extends FlatSpec with Matchers {

  "Setting head on list" should "return the list with the first element replaced" in {
    val l = List(1, 2, 3)
    setHead(l, 4) shouldBe List(4, 2, 3)
  }

  "Setting head on empty list" should "return the empty list" in {
    val l = Nil
    setHead(l, 4) shouldBe Nil
  }

}