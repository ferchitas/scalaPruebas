package exercices.ListaConFunctionTypes

import exercices.ListaConFunctionTypes.Vacio.{cabeza, cola}

abstract class ListaConFunctionTypes [+A]{

  def cabeza: A
  def cola: ListaConFunctionTypes[A]
  def esVacia: Boolean
  def insertar [C >: A] (elementoAInsertar: C): ListaConFunctionTypes[C]
  def imprimirElementos: String
  override def toString: String = "[" + imprimirElementos + "]"
  def map[B](transformador: A => B): ListaConFunctionTypes[B]
  def withFilter(predicado: A => Boolean): ListaConFunctionTypes[A]
  def flatMap[B](transformador: A => ListaConFunctionTypes[B]): ListaConFunctionTypes[B]
  def ++[B >: A](ListaConFunctionTypes: ListaConFunctionTypes[B]): ListaConFunctionTypes[B]

  //HOFs
  def porCada (f: A => Unit): Unit
  def ordenar(comparador: (A, A) => Int): ListaConFunctionTypes[A]
  def comprimirListas [B, C] (lista: ListaConFunctionTypes[B], union: (A, B) => C): ListaConFunctionTypes[C]
  def unificar [B] (elementoInicial: B)(f: (A, B) => B): B
}

case object Vacio extends ListaConFunctionTypes[Nothing] {

  override def cabeza: Nothing = throw new NoSuchElementException
  override def cola: ListaConFunctionTypes[Nothing] = throw new NoSuchElementException
  override def esVacia: Boolean = true
  override def insertar[B >: Nothing](elementoAInsertar: B): ListaConFunctionTypes[B] = new Elemento[B](elementoAInsertar, this)
  override def imprimirElementos: String = ""
  override def map[B](transformador: Nothing => B): ListaConFunctionTypes[B] = Vacio
  override def withFilter(predicado: Nothing => Boolean): ListaConFunctionTypes[Nothing] = Vacio
  override def flatMap[B](transformador: Nothing => ListaConFunctionTypes[B]): ListaConFunctionTypes[B] = Vacio
  override def ++[B >: Nothing](ListaConFunctionTypes: ListaConFunctionTypes[B]): ListaConFunctionTypes[B] = ListaConFunctionTypes

  //hofs
  override def porCada(f: Nothing => Unit): Unit = ()
  override def ordenar(comparador: (Nothing, Nothing) => Int): ListaConFunctionTypes[Nothing] = Vacio
  override def comprimirListas[B, C](lista: ListaConFunctionTypes[B], union: (Nothing, B) => C): ListaConFunctionTypes[C] =
    if(!lista.esVacia) throw new RuntimeException("Las lsitas no tienen la misma longitud")
    else Vacio

  override def unificar[B](elementoInicial: B)(f: (Nothing, B) => B): B = elementoInicial
}

case class Elemento [+A] (elemento: A, ListaConFunctionTypes: ListaConFunctionTypes[A]) extends ListaConFunctionTypes[A] {

  override def cabeza: A = elemento
  override def cola: ListaConFunctionTypes[A] = ListaConFunctionTypes
  override def esVacia: Boolean = false
  override def insertar [B >: A] (elementoAInsertar: B): ListaConFunctionTypes[B] = new Elemento[B](elementoAInsertar, Vacio)
  override def imprimirElementos: String =
    if(ListaConFunctionTypes.esVacia) "" + elemento
    else elemento + " " + ListaConFunctionTypes.imprimirElementos

  override def withFilter(predicado: A => Boolean): ListaConFunctionTypes[A] = {
    if(predicado(cabeza)) new Elemento(cabeza, cola.withFilter(predicado))
    else cola.withFilter(predicado)
  }
  override def map[B](transformador: A => B): ListaConFunctionTypes[B] = {
    new Elemento(transformador(cabeza), cola.map(transformador))
  }
  override def flatMap[B](transformador: A => ListaConFunctionTypes[B]): ListaConFunctionTypes[B] =
    transformador(cabeza) ++ cola.flatMap(transformador)

  override def ++[B >: A](ListaConFunctionTypes: ListaConFunctionTypes[B]): ListaConFunctionTypes[B] = new Elemento(cabeza, cola ++ ListaConFunctionTypes)

  //hofs
  override def porCada(f: A => Unit): Unit = {
    f(cabeza)
    cola.porCada(f)
  }

  override def ordenar(comparador: (A, A) => Int): ListaConFunctionTypes[A] = {
    def insertar(x: A, listaOrdenada: ListaConFunctionTypes[A]): ListaConFunctionTypes[A] =
      if (listaOrdenada.esVacia) new Elemento(x, Vacio)
      else if(comparador(x, listaOrdenada.cabeza) <= 0) new Elemento(x, listaOrdenada)
      else new Elemento(listaOrdenada.cabeza, insertar(x, listaOrdenada.cola))

    val colaOrdenada = cola.ordenar(comparador)
    insertar(cabeza, colaOrdenada)
  }

  override def comprimirListas[B, C](lista: ListaConFunctionTypes[B], union: (A, B) => C): ListaConFunctionTypes[C] =

    if(lista.esVacia) throw new RuntimeException("Las lsitas no tienen la misma longitud")
    else new Elemento(union(cabeza, lista.cabeza), cola.comprimirListas(lista.cola, union))

  override def unificar[B](elementoInicial: B)(f: (A, B) => B): B = {
    cola.unificar(f(cabeza, elementoInicial))(f)
  }
}

object Test extends App {

  val lista1 = new Elemento[Int](1, new Elemento[Int](2, new Elemento[Int](3, Vacio)))
  val listaString = new Elemento[String]("1", new Elemento[String]("2", new Elemento[String]("3", Vacio)))
  val lista2 = lista1.map(_ % 2 == 0)
  println(lista1.toString)
  println(lista2.toString)
  println(lista1.withFilter(_ % 2 == 0).toString)
  println(lista1.flatMap(v1 => new Elemento(v1 , new Elemento(v1 + 1, Vacio))).toString)

  //hofs
  lista1.porCada(println)
  println(lista1.ordenar((x, y) => y - x))
  println(lista1.comprimirListas[String, String](listaString, _ + "-" + _))
  println(lista1.unificar(0)(_ + _))

  /**
   * comprehensions: para que esta notacion funcione, el objeto a iterar necesita las
   * las funciones: map(f: A => B) => ObjetoAIterar[B], filter(p: A => Boolean) => ObjetoAIterar[A]
   * y flatMap(f: A => ObjetoAIterar[B]) => ObjetoAIterar[B]
   * */

  val listaResultado = for {
    elemento <- lista1 if elemento % 2 == 0
  } yield elemento + 1
  println(listaResultado)
}