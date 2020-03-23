package lectures.part2oop

import lectures.part2oop.Exception.MathCalculationException

/**
 *
 * muy similares a Java
 */
object Exception extends App {

  object Calculadora {

    def sumar(x: Int, y: Int): Int = {
      val resultado = x + y
      // si nos pasamos por arriba
      if (x > 0 && y > 0 && resultado < 0) throw new OverFlowException
        //si nos pasamos por debajo
      else if (x < 0 && y < 0 && resultado > 0) throw new UnderFlowException
      else resultado
    }

    def restar(x: Int, y: Int): Int = {
      val resultado = x - y
      //si nos pasamos por arriba
      if (x > 0 && y < 0 && resultado < 0) throw new OverFlowException
        //si nos pasamos por abajo
      else if (x < 0 && y > 0 && resultado > 0) throw new UnderFlowException
      else resultado
    }
    def multiplicar(x: Int, y: Int): Int ={
      val resultado = x * y
      //si nos pasamos por arriba, tanto multiplciando ambos numeros positivos o negativos
      if ((x > 0 && y > 0 && resultado < 0) || (x < 0 && y < 0 && resultado < 0)) throw new OverFlowException
      //si nos pasamos por abajo, porque uno de los numeros es negativo
      else if ((x < 0 && y > 0 && resultado < 0) || (x < 0 && y > 0 && resultado > 0)) throw new UnderFlowException
      else resultado
    }

    def dividir(x: Int, y: Int): Int =
      if(y == 0) throw new MathCalculationException
      else x / y
  }

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Estas dividiendo entre 0.")

//  println(Calculadora.sumar(Int.MaxValue, 10))
//  println(Calculadora.restar(Int.MinValue, 10))
//  println(Calculadora.multiplicar(Int.MaxValue, 10))
  try {

    println(Calculadora.dividir(Int.MaxValue, 0))
  } catch {
    case e: MathCalculationException => println("Excepcion matematica. " + e)
  }
  finally {
    println("Codigo que se ejecutara independientemente de si salta una excepcio o no como en Java")
  }
}
