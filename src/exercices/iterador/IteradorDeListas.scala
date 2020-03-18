package exercices.iterador

class IteradorDeListas(lista: Lista) extends Iterador[Int] {

  override var elementoActual: Int = 0
  val coleccion: Coleccion[Int] = lista
  override def siguienteElemento: Int = {

    if(hayMas){

      elementoActual += 1
      coleccion.array(elementoActual - 1)
    }
    throw new Exception
  }
  override def hayMas: Boolean = {

    var resultado = false
    var contador: Int = 0
    for(numbero <- coleccion.array){
      contador += 1
    }
    if(contador > elementoActual){
      resultado = true
    }
    resultado
  }

  override def insertar(elementoAInsertar: Int): Unit = {

    if(hayMas){
      coleccion.array(elementoActual) = elementoAInsertar
    }
    else {

      var elementosExistentes: Array[Int] = coleccion.array
      coleccion.array = new Array[Int](elementoActual * 2)
      var i: Int = 0
      for(numero <- elementosExistentes){
        coleccion.array(i) = numero
        i+=1
      }
    }
    elementoActual+=1
  }
}
