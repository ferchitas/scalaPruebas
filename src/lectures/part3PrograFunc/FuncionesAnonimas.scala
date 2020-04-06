package lectures.part3PrograFunc

object FuncionesAnonimas extends App {

  /**
   *
   * ambas expresiones hacen lo mismo, definir una funcion anonima, la de abajo es syntatic sugar.
   *
   */
  val doblar = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  /** Se pueden ir quitando cosas y el compilador ira infiriendo lo que pueda *
   * Lo que hemos definido basicamente es una expresion lambda:
   * (tipo de datos de entrada, tipo de datos de salida) => "logica de la funcion"
   */
  val doblar1: Int => Int = (x: Int) => x * 2
  /** Quitamos el tipo de la funcion */
  val doblar2 = (x: Int) => x * 2

  /** Si no hay parametros es asi */
  val sinParametros = () => 2

  /** Mas syntactic sugar */
  val incremetnador: Int => Int = _ + 1 //equivalente a x => x + 1
  val suma: (Int, Int) => Int = _ + _ //equivalente a: (a, b) => a + b
  // en ambos casos de arriba es necesario tener definido el tipo de la funcion


  /**
   *
   * Ejercicios:
   *
   * 1º Cambiar en MiLista todas las funciones por lambdas
   * 2º Rehacer la funcion SuperSUmador para que sea anonima
   */
  /** Primero hay una funcion que tiene como entrada un int (x1) y como salida una funcion,
   * esta funcion tiene como entrada un un (x2) y devuelve la suma de los dos enteros de entrada */
  val superSumador = (x1: Int) => (x2: Int) => x1 + x2
  println(superSumador(2)(3))
}
