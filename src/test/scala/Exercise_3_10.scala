import org.scalatest._

import fpinscala.datastructures._
import List._

class Exercise_3_10 extends FlatSpec with Matchers {

  "foldLeft using +" should "return sum of elements" in {
    val l = List(1, 2, 3)
    foldLeft(l, 0)(_+_) shouldBe 6
  }

}
