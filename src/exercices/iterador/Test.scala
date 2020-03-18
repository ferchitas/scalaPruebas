package exercices.iterador

object Test extends App {


  val lista: Lista = new Lista
  val iteradorDeListas: IteradorDeListas = new IteradorDeListas(lista)

  iteradorDeListas.insertar(1)
  iteradorDeListas.insertar(2)
}
