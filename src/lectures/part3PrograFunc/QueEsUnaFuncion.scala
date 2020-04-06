package lectures.part3PrograFunc

object QueEsUnaFuncion extends App {

 val doblar = new MiFuncion[Int, Int] {
   override def apply(elemento: Int): Int = elemento * 2
 }

  println(doblar(2))

  val stringAInt = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringAInt("2") + 2)

  val suma = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  trait MiFuncion[A, B] {

    def apply(elemento: A): B
  }

  /**
   *
   * Ejercicio
   *
   * 1º funcion que tome dos String y los concatene
   * 2º transformar Predicado y Transformador en type functions
   * 3º definir una funcion que le entre un int y devuelva otra fucion que tome un int y devuelva un int
   *
   */

  val concatenarStrings = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println("hola " + "guapo")

  val superSumador = new Function[Int, Function[Int, Int]] {
    override def apply(v1: Int): Function[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val sumador3 = superSumador(3)
  println(sumador3(2))
  /**
   *
   * superSumador devuelve una funcion, y a esa funcion se le pasa un int:
   * este tipo de funciones se llaman curried function
   */
  println(superSumador(3)(2))

}
