import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_2 extends FlatSpec with Matchers {
  
  "Tail of list" should "return the list minus the first element" in {
    val l = List(1, 2, 3)
    tail(l) shouldBe List(2, 3)
  }
  
  "Tail of empty list" should "return empty list" in {
    val l = Nil
    tail(l) shouldBe Nil
  }
}