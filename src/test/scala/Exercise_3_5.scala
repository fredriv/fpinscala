import org.scalatest._

import fpinscala.datastructures._

class Exercise_3_5 extends FlatSpec with Matchers  {

  "Dropping no elements" should "return original list" in {
    val l = List(1, 2, 3)
    List.dropWhile(l)(_ => false) shouldBe l
  }

  "Dropping all elements" should "return empty list" in {
    val l = List(1, 2, 3)
    List.dropWhile(l)(_ => true) shouldBe Nil
  }

  "Dropping on empty list" should "return empty list" in {
    val l = Nil
    List.dropWhile(l)(_ => true) shouldBe Nil
  }

  "Dropping even numbers" should "return list with odd numbers" in {
    val l = List(1, 2, 3)
    List.dropWhile(l)(_ % 2 == 0) shouldBe List(1, 3)
  }

}
