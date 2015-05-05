import org.scalacheck.Properties

import org.scalacheck._
import Gen._
import Arbitrary.arbitrary
import Prop.{forAll, BooleanOperators}

import fpinscala.datastructures._

object List_Specification extends Properties("List") {

  implicit def arbList[T](implicit a: Arbitrary[T]): Arbitrary[List[T]] = Arbitrary {
    val genNil = const(Nil)
    def genCons: Gen[List[T]] = for {
      x <- arbitrary[T]
      xs <- genList
    } yield (Cons(x, xs))

    def genList: Gen[List[T]] = Gen.oneOf(genNil, genCons)

    genList
  }

  property("tail") = forAll { l: List[Int] =>
    (l == Nil) ==> (List.tail(l) == Nil)
    (l != Nil) ==> (List.length(List.tail(l)) == List.length(l) - 1)
  }

  property("drop") = forAll { (l: List[Int], n: Int) =>
    (n <= 0) ==> (List.drop(l, n) == l)
    (n > 0 && n <= List.length(l)) ==> (List.length(List.drop(l, n)) == List.length(l) - n)
    (n > List.length(l)) ==> (List.drop(l, n) == Nil)
  }

  property("init") = forAll { l: List[Int] =>
    (List.length(l) <= 1) ==> (List.init(l) == Nil)
    (List.length(l) > 1) ==> (List.length(l) == List.length(List.init(l)) + 1)
  }
}
