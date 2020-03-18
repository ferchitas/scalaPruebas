package exercices.iterador

abstract class Coleccion[A] {

  var array: Array[A]
  def crearIterador: Iterador[A]
}
