package lectures.part3PrograFunc

object HOFsCurries extends App {

  /** Una funcion que toma o devuelve otra funcion se llama higher order function (HOF) */
  val superFuncion: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  def nVeces(f: Int => Int, n: Int, x: Int): Int =
    if(n <= 0) x
    else nVeces(f, n - 1, f(x))

  val masUno = (x: Int) => x + 1

  println(nVeces(masUno, 10, 1))

  def nVecesMejorada(f:Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nVecesMejorada(f, n - 1)(f(x))

  val mas10 = nVecesMejorada(masUno, 10)
  println(mas10(1))

  /** Las funciones curried, son funciones que tienen varias listas de parametros */
  val superSumador: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  /** Se pueden definir luego funciones que llamen a estas con menos listas de parametros */
  def formateadorCurried(s: String)(d: Double): String = s.format(d)

  val formateadorStandar: (Double => String) = formateadorCurried("%4.2f")
  val formateadorPreciso: (Double => String) = formateadorCurried("%10.8f")

  println(formateadorStandar(Math.PI))
  println(formateadorPreciso(Math.PI))
}
