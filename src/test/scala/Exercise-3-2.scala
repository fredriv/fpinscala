import org.scalatest._

import fpinscala.datastructures._

class Exercise_3_2 extends FlatSpec with Matchers {
  
  "Tail" should "remove first element of list" in {
    val l = List(1, 2, 3)
    List.tail(l) shouldBe List(2, 3)
  }
  
  "Tail of empty list" should "return empty list" in {
    val l = Nil
    List.tail(l) shouldBe Nil
  }
}