package lectures.part3PrograFunc

import scala.util.Random

object Sequences extends App {

  /** Secuencias */
  val secuencia = Seq(1, 2, 4, 3)
  println(secuencia)
  println(secuencia.reverse)
  println(secuencia(2)) // devuelve el valor en la posicion 2
  println(secuencia ++ Seq(4, 5, 6)) // concatena en una unica secuencia
  println(secuencia.sorted) // hay clases como los enteros que ya implementan una forma de ordenar

  /** Rangos */
  val rango: Seq[Int] = 1 to 10 // tambien se puede poner tail
  rango.foreach(println)

  // por ejemplo se pueden utilizar para hacer bucles
  (1 to 10).foreach(x => println("Hola" + x))

  /** Listas */
  val lista = List(1, 2, 3)
  val concatenarAntesYdespues = 0 +: lista :+ 4
  println(concatenarAntesYdespues)

  // crear una lista de un valor repetido n veces se puede hacer con la funcion curried fill:
  val cincoManzanas = List.fill(5)("Manzana")
  println(cincoManzanas)

  //el metodo mkString de lista mete un sepaador entre cada elemento y genera un String
  println(lista.mkString("-"))

  /** Arrays */
  val numeros = Array(1, 2, 3, 4)
  // o tambien
  val tresElementos = Array.ofDim[Int](3)

  // para tipos basicos tenemos valores por defecto aunque no lo inicialicemos, en el resto pone null
  tresElementos.foreach(println)

  // los array pueden mutar
  numeros(2) = 0 //syntactic sugar del metodo numeros.update(2, 0)
  println(numeros.mkString(" "))

  // un array se puede convertir en una secuencia
  val secNumeros: Seq[Int] = numeros
  println(secNumeros)

  /** Vectores */
  val vector: Vector[Int] = Vector (1, 2 ,3)

  //eficiencia, vectores vs listas
  val maxRuns = 1000
  val maxCapacidad = 1000000
  def tiempoDeEscritura(coleccion: Seq[Int]): Double = {

    val r = new Random
    val veces = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      coleccion.updated(r.nextInt(maxCapacidad), r.nextInt())
      System.nanoTime() - currentTime
    }
    veces.sum * 1.0 / maxRuns
  }
  val listaTest = (1 to maxCapacidad).toList
  val vectorTest = (1 to maxCapacidad).toVector

  //la ventaja de las listas es que matienen referencias a la cola.
  //la desventaja de las listas es que cambiar un elemento de enmedio consume tiempo.
  println(tiempoDeEscritura(listaTest))
  //la ventaja de los vectores es que el arbol de busqueda es pequeño.
  //la desventaja de los vectores es que cambiar un elemento implica cambiar tambien
  //partes del arbol
  println(tiempoDeEscritura(vectorTest))
}
