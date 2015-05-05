package fpinscala.datastructures

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def length(l: List[Any]): Int = foldRight(l, 0)((el, acc) => acc + 1)

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => xs
  }

  def setHead[A](l: List[A], newHead: A): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => Cons(newHead, xs)
  }

  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => if (n > 0) drop(xs, n - 1) else l
  }

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => if (f(x)) dropWhile(xs)(f) else Cons(x, dropWhile(xs)(f))
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }

  def sumFoldL(l: List[Int]) = foldLeft(l, 0)(_+_)

  def productFoldL(l: List[Double]) = foldLeft(l, 1.0)(_*_)

  def lengthFoldL(l: List[Any]) = foldLeft(l, 0)((acc, el) => acc + 1)

  def reverse[A](l: List[A]): List[A] = foldLeft(l, Nil:List[A])((xs, x) => Cons(x, xs))

  def foldLeftViaFoldRight[A,B](as: List[A], z: B)(f: (B, A) => B): B =
    foldRight(as, (b:B) => b)((a, g) => b => g(f(b, a)))(z)

  def foldRightViaFoldLeft[A,B](as: List[A], z: B)(f: (A, B) => B): B =
    foldLeft(reverse(as), z)((b, a) => f(a, b))

  def appendViaFold[A](a1: List[A], a2: List[A]): List[A] =
    foldRight(a1, a2)(Cons(_,_))

}