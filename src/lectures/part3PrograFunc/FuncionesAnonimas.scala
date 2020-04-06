package lectures.part3PrograFunc

object FuncionesAnonimas extends App {

  /**
   *
   * ambas expresiones hacen lo mismo, definir una funcion anonima, la de abajo es syntatic sugar.
   */
  val doblar = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  /** Se pueden ir quitando cosas y el compilador ira ifiriendo lo que pueda */
  val doblar1: Int => Int = (x: Int) => x * 2
  /** Quitamos el tipo de la funcion */
  val doblar2 = (x: Int) => x * 2

  /** Si no ay parametros es asi */
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

  val superSumador: Int => Function[Int, Int] = (x1: Int) => (Int => Int = (x2: Int) => x1 + x2)

}
