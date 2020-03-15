package lectures.part1basics

object Functions3 extends App {

  def factorial (n: Int): Int =
    if(n == 1) n
    else n * factorial(n-1)
  println(factorial(4))

  def fibonacci (n: Int): Int =
    if(n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  println(fibonacci(7))

  def prime (n: Int): Boolean = {
    val i = n - 1
    def divide(n: Int, i: Int): Boolean =
      if(i == 1) true
      else if (n%i == 0) false
      else divide(n, i - 1)
    divide(n, i)
  }
  println(prime(2003))
}
