import org.scalatest._

import fpinscala.datastructures._

class Exercise_3_6 extends FlatSpec with Matchers {

  "init of empty list" should "be empty list" in {
    List.init(Nil) shouldBe Nil
  }

  "init of list with one element" should "be empty list" in {
    List.init(List(1)) shouldBe Nil
  }

  "init of list" should "contain all but last element of list" in {
    List.init(List(1, 2, 3)) shouldBe List(1, 2)
  }
}
