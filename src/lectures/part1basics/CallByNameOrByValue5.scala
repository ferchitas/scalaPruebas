package lectures.part1basics

object CallByNameOrByValue5 extends App{

  /**
   * Igual que en cualquier otro lenguaje, el valor que se le pasa se evalua antes de la llamada a esta funcion.
   * Por esta razon, ambos println pintan el mismo long.
   * En el ejemplo con el tiempo, se evalua la funcion nanoTime y su resutlado se pasa y se sustituye por la x.
   *
   * @param x
   */
  def calledByValue(x: Long): Unit = {

    println("by value:" + x)
    println("by value:" + x)
  }

  /**
   * Cuando se pone la directiva "=>" el valor se pasa por nombre, es decir se pasa directamente la llamada a la funcion
   * y se sustituye donde este la x.
   * Esto en definitiva evalua la funcion en todos los sitios donde este x, ademas la evalua cuando la encuentra
   * en el codigo, no antes, y si no la encuentra nunca la evalua. Por esto el ejemplo de la funcion pintarSoloElPrimero
   * no lanza una stackOverflow.
   * En el caso de la funcion nanoTime como cambia su resultado con el tiempo el valor que pinta el println tambien varia,
   * en este caso se evalua 2 veces.
   *
   * @param x
   */
  def calledByName(x: => Long): Unit = {

    println("by name:" + x)
    println("by name:" + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinito(): Int = 1 + infinito()
  def pintarSoloElPrimero(x: Int, y: => Int) = println(x)

  pintarSoloElPrimero(2, infinito())
}
