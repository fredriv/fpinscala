import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_13 extends FlatSpec with Matchers {

  "foldLeft of Nil and Cons" should "return reversed list" in {
    val l = List(1, 2, 3)
    foldLeftViaFoldRight(l, Nil:List[Int])((xs, x) => Cons(x, xs)) shouldBe List(3, 2, 1)
  }

  "foldRight of Nil and Cons" should "retain list order" in {
    val l = List(1, 2, 3)
    foldRightViaFoldLeft(l, Nil:List[Int])(Cons(_,_)) shouldBe List(1, 2, 3)
  }
}
