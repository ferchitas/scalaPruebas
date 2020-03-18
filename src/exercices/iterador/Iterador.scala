package exercices.iterador

abstract class Iterador[A] {

  var elementoActual: Int
  def siguienteElemento: A
  def hayMas: Boolean
  def insertar(elementoAInsertar: A)
}
