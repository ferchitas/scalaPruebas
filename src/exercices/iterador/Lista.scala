package exercices.iterador

class Lista extends Coleccion[Int] {
  override val array: Array[Int] = new Array[Int](5)

  override def crearIterador: Iterador[Int] = {

    new IteradorDeListas(this)
  }
}
