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
  def mapear[B](transformador: Transformador[A, B]): ListaRecursiva[B]
  def filtrar(predicado: Predicado[A]): ListaRecursiva[A]
  def mapaTransformar[B](transformador: Transformador[A, ListaRecursiva[B]]): ListaRecursiva[B]
  def ++[B >: A](listaRecursiva: ListaRecursiva[B]): ListaRecursiva[B]
}

trait Predicado[-T] {
  def test(elementoATestear: T): Boolean
}

trait Transformador[-A, B] {
  def transformar(elementoATransformar: A): B
}

object Vacio extends ListaRecursiva[Nothing] {

  override def cabeza: Nothing = throw new NoSuchElementException
  override def cola: ListaRecursiva[Nothing] = throw new NoSuchElementException
  override def esVacia: Boolean = true
  override def insertar[B >: Nothing](elementoAInsertar: B): ListaRecursiva[B] = new Elemento[B](elementoAInsertar, this)
  override def imprimirElementos: String = ""
  override def mapear[B](transformador: Transformador[Nothing, B]): ListaRecursiva[B] = Vacio
  override def filtrar(predicado: Predicado[Nothing]): ListaRecursiva[Nothing] = Vacio
  override def mapaTransformar[B](transformador: Transformador[Nothing, ListaRecursiva[B]]): ListaRecursiva[B] = Vacio
  override def ++[B >: Nothing](listaRecursiva: ListaRecursiva[B]): ListaRecursiva[B] = listaRecursiva
}

class Elemento [+A] (elemento: A, listaRecursiva: ListaRecursiva[A]) extends ListaRecursiva[A] {

  override def cabeza: A = elemento
  override def cola: ListaRecursiva[A] = listaRecursiva
  override def esVacia: Boolean = false
  override def insertar [B >: A] (elementoAInsertar: B): ListaRecursiva[B] = new Elemento[B](elementoAInsertar, Vacio)
  override def imprimirElementos: String =
    if(listaRecursiva.esVacia) "" + elemento
    else elemento + " " + listaRecursiva.imprimirElementos

  override def filtrar(predicado: Predicado[A]): ListaRecursiva[A] = {
    if(predicado.test(cabeza)) new Elemento(cabeza, cola.filtrar(predicado))
    else cola.filtrar(predicado)
  }
  override def mapear[B](transformador: Transformador[A, B]): ListaRecursiva[B] = {
    new Elemento(transformador.transformar(cabeza), cola.mapear(transformador))
  }
  override def mapaTransformar[B](transformador: Transformador[A, ListaRecursiva[B]]): ListaRecursiva[B] =
    transformador.transformar(cabeza) ++ cola.mapaTransformar(transformador)

  override def ++[B >: A](listaRecursiva: ListaRecursiva[B]): ListaRecursiva[B] = new Elemento(cabeza, cola ++ listaRecursiva)
}

class PredicadoImpar extends Predicado[Int] {
  override def test(elementoATestear: Int): Boolean = elementoATestear % 2 == 0
}

class DuplicarValorTransformador extends Transformador[Int, ListaRecursiva[Int]] {
  override def transformar(elementoATransformar: Int): ListaRecursiva[Int] = new Elemento(elementoATransformar , new Elemento(elementoATransformar + 1, Vacio))
}

object Test extends App {

  val lista1 = new Elemento[Int](1, new Elemento[Int](2, new Elemento[Int](3, Vacio)))
  val lista2 = lista1.mapear(new DuplicarValorTransformador())
  println(lista1.toString)
  println(lista2.toString)
  println(lista1.filtrar(new PredicadoImpar()).toString)
  println(lista1.mapaTransformar(new DuplicarValorTransformador()))
}
