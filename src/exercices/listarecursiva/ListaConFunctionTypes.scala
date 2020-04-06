package exercices.ListaConFunctionTypes

abstract class ListaConFunctionTypes [+A]{

  def cabeza: A
  def cola: ListaConFunctionTypes[A]
  def esVacia: Boolean
  def insertar [C >: A] (elementoAInsertar: C): ListaConFunctionTypes[C]
  def imprimirElementos: String
  override def toString: String = "[" + imprimirElementos + "]"
  def mapear[B](transformador: A => B): ListaConFunctionTypes[B]
  def filtrar(predicado: A => Boolean): ListaConFunctionTypes[A]
  def mapaTransformar[B](transformador: A => ListaConFunctionTypes[B]): ListaConFunctionTypes[B]
  def ++[B >: A](ListaConFunctionTypes: ListaConFunctionTypes[B]): ListaConFunctionTypes[B]
}

case object Vacio extends ListaConFunctionTypes[Nothing] {

  override def cabeza: Nothing = throw new NoSuchElementException
  override def cola: ListaConFunctionTypes[Nothing] = throw new NoSuchElementException
  override def esVacia: Boolean = true
  override def insertar[B >: Nothing](elementoAInsertar: B): ListaConFunctionTypes[B] = new Elemento[B](elementoAInsertar, this)
  override def imprimirElementos: String = ""
  override def mapear[B](transformador: Nothing => B): ListaConFunctionTypes[B] = Vacio
  override def filtrar(predicado: Nothing => Boolean): ListaConFunctionTypes[Nothing] = Vacio
  override def mapaTransformar[B](transformador: Nothing => ListaConFunctionTypes[B]): ListaConFunctionTypes[B] = Vacio
  override def ++[B >: Nothing](ListaConFunctionTypes: ListaConFunctionTypes[B]): ListaConFunctionTypes[B] = ListaConFunctionTypes
}

case class Elemento [+A] (elemento: A, ListaConFunctionTypes: ListaConFunctionTypes[A]) extends ListaConFunctionTypes[A] {

  override def cabeza: A = elemento
  override def cola: ListaConFunctionTypes[A] = ListaConFunctionTypes
  override def esVacia: Boolean = false
  override def insertar [B >: A] (elementoAInsertar: B): ListaConFunctionTypes[B] = new Elemento[B](elementoAInsertar, Vacio)
  override def imprimirElementos: String =
    if(ListaConFunctionTypes.esVacia) "" + elemento
    else elemento + " " + ListaConFunctionTypes.imprimirElementos

  override def filtrar(predicado: A => Boolean): ListaConFunctionTypes[A] = {
    if(predicado(cabeza)) new Elemento(cabeza, cola.filtrar(predicado))
    else cola.filtrar(predicado)
  }
  override def mapear[B](transformador: A => B): ListaConFunctionTypes[B] = {
    new Elemento(transformador(cabeza), cola.mapear(transformador))
  }
  override def mapaTransformar[B](transformador: A => ListaConFunctionTypes[B]): ListaConFunctionTypes[B] =
    transformador(cabeza) ++ cola.mapaTransformar(transformador)

  override def ++[B >: A](ListaConFunctionTypes: ListaConFunctionTypes[B]): ListaConFunctionTypes[B] = new Elemento(cabeza, cola ++ ListaConFunctionTypes)
}

object Test extends App {

  val lista1 = new Elemento[Int](1, new Elemento[Int](2, new Elemento[Int](3, Vacio)))
  val lista2 = lista1.mapear(_ % 2 == 0)
  println(lista1.toString)
  println(lista2.toString)
  println(lista1.filtrar(_ % 2 == 0).toString)
  println(lista1.mapaTransformar(v1 => new Elemento(v1 , new Elemento(v1 + 1, Vacio))).toString)
}