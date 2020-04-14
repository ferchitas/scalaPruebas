package lectures.part3PrograFunc

object MapFlapMapFilterFor extends App {

  val lista = List(1, 2, 3)
  val lista1 = List('a', 'b', 'c')
  val colores = List("Rojo", "Negro")
  println(lista)

  /**
   *  combinacion de todos los elementos con todos de las tres listas
   * flatMap lo que hace generar una unica lista a partir de las que le entren
   * map lo que hace es iterar en los elementos de la lista
   * */
  val lista3 = lista.flatMap(n => lista1.flatMap(c => colores.map(color => "" + c + n + color)))
  println(lista3)

  /**
   * foreach es como map, itera sobre los elementos de la lista, pero
   * la funcion que le entra como paramentro y la funcion foreach no devuelven nada
   * */

  val ls = lista.foreach(n => n + 1)
  println(ls.getClass)
  val l = lista.map(n => n + 1)
  println(l)

  /**
   * para evitar tener que poner el chorizo de arriba (flatMap y map) y que nadie sea capaz de entenderlo,
   * en scala hay un for un poco raro, esto se llama cmprehensions, ir a ListaConFunctionTypes para ver
   * como tenerlo en nuestras propias clases
   *
   * a esto se le pueden meter condiciones de por medio hay cometada una en la definion de n, esto actua
   * la funcion filter
   */
  val listaCompresible = for {
    n <- lista //if n % 2 == 0
    c <- lista1
    color <- colores
  } yield "" + c + n + color

  // listaCompresible y lista3 son lo mismo
  println(listaCompresible)
}
