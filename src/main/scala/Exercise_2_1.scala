object Exercise_2_1 {

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else loop(n - 1, n * acc)

    loop(n, 1)
  }

  def fib(n: Int): BigInt = {
    @annotation.tailrec
    def loop(n: Int, a: BigInt, b: BigInt): BigInt =
      if (n <= 1) a
      else loop(n - 1, b, a + b)

    loop(n, 0, 1)
  }

  def main(args: Array[String]): Unit =
    println(factorial(5))
}