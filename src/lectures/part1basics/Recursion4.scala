package lectures.part1basics

import scala.annotation.tailrec

/**
 *
 * Una funcion es tail recursive si su ultima espresion es una llamada recursiva.
 * Esto es importante para evitar que en llamadas recursivas muy grandes acaben lanzando
 * una stackOverflowException.
 *  
 */
object Recursion4 extends App {

  /**
   * Esta función no es tail recursive porque su iltimo elemento es una multiplicacion
   * que dentro tiene una llamada recursiva. Esto hace que por cada llamada recursiva de la
   * multiplicacion sea necesario crear una pila de llamada nueva que acabara explotando por algun sitio.
   *
   * Podemos analizar la funcion y deducir si es tail recursive a ojo o podemos añadir la anotacion @tailrec
   * del lenguaje. En caso de que no lo sea, el compilador nos lanza un error en el IDE.
   *
   * @param n
   * @return
   */
  //@tailrec
  def factorial(n: Int): Int =
    if (n == 1) n
    else n * factorial(n - 1)

  /**
   *
   * la primera llamada se la traga bien, la segunda se le hace bola :)
   */
  println(factorial(4))

//  println(factorial(50000))

  /**
   * Ahora con la funcion auxiliar podemos hacer la multiplicacion en su llamada
   * y solo se genera una pila de llamadas, de todas formas si le paso el 5000 explota
   *
   * @param n
   * @return
   */
  def factorialTailRec(n: BigInt): BigInt = {
    @tailrec
    def factorial(n: BigInt, acumulado: BigInt): BigInt = {
      if(n <= 1) acumulado
      else factorial(n - 1, acumulado * n)
    }
    factorial(n, 1)
  }

  println(factorialTailRec(4))

  println(factorialTailRec(1000))
}
