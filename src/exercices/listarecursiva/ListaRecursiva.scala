package exercices.listarecursiva

import javax.swing.plaf.multi.MultiListUI

import scala.collection.View.Empty

abstract class ListaRecursiva[+A]{

  def cabeza: A
  def cola: ListaRecursiva[A]
  def esVacia: Boolean
  def insertar [C >: A] (elementoAInsertar: C): ListaRecursiva[C]
  def imprimirElementos: String
  override def toString: String = "[" + imprimirElementos + "]"
  def mapear[C >: A](transformador: Transformador[C]): ListaRecursiva[C]
  def filtrar[T](predicado: Predicado[T]): ListaRecursiva[A]
  def mapaTransformar[C >: A](transformador: Transformador[C]): ListaRecursiva[C]
}

trait Predicado[-T] {
  def test(elementoATestear: T): Boolean
}

trait Transformador[A] {
  def transformar(elementoATransformar: A): A
}

object Vacio extends ListaRecursiva[Nothing] {

  override def cabeza: Nothing = throw new NoSuchElementException
  override def cola: ListaRecursiva[Nothing] = throw new NoSuchElementException
  override def esVacia: Boolean = true
  override def insertar[B >: Nothing](elementoAInsertar: B): ListaRecursiva[B] = new Elemento[B](elementoAInsertar, this)
  override def imprimirElementos: String = ""
  override def mapear[B](transformador: Transformador[Nothing]): ListaRecursiva[Nothing] = throw new NoSuchElementException
  override def filtrar[T](predicado: Predicado[T]): ListaRecursiva[Nothing] = ???
  override def mapaTransformar[B](transformador: Transformador[Nothing]): ListaRecursiva[B] = ???
}

class Elemento [+A] (elemento: A, listaRecursiva: ListaRecursiva[A]) extends ListaRecursiva[A] {

  override def cabeza: A = elemento
  override def cola: ListaRecursiva[A] = listaRecursiva
  override def esVacia: Boolean = false
  override def insertar [B >: A] (elementoAInsertar: B): ListaRecursiva[B] = new Elemento[B](elementoAInsertar, Vacio)
  override def imprimirElementos: String =
    if(listaRecursiva.esVacia) "" + elemento
    else elemento + " " + listaRecursiva.imprimirElementos
  override def mapear(transformador: Transformador[A]): ListaRecursiva[A] = mapearLista(transformador, this)
  override def filtrar[T](predicado: Predicado[T]): ListaRecursiva[A] = ???
    //if(predicado.test(elemento))
  override def mapaTransformar(transformador: Transformador[A]): ListaRecursiva[A] = ???

  def mapearLista[B](transformador: Transformador[B], listaRecursiva: ListaRecursiva[B]): ListaRecursiva[B] = {

    if(listaRecursiva.esVacia) new Elemento[B](transformador.transformar(listaRecursiva.cabeza), Vacio)
    else new Elemento[B](transformador.transformar(listaRecursiva.cabeza), mapearLista(transformador, listaRecursiva.cola))
  }
}

class PredicadoImpar extends Predicado[Int] {
  override def test(elementoATestear: Int): Boolean = elementoATestear%2 == 0
}

class duplicarValorTransformador extends Transformador[Int] {
  override def transformar(elementoATransformar: Int): Int = elementoATransformar * 2
}

object Test extends App {

  val lista1 = new Elemento[Int](1, new Elemento[Int](2, new Elemento[Int](3, Vacio)))
  val transformador = new duplicarValorTransformador()
  val lista2 = lista1.mapear(transformador)
  println(lista1.toString)
  println(lista2.toString)
}
