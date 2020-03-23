package lectures.part2oop

object ClasesAnonimas extends App {

  abstract class Animal {

    def comer: Unit
  }

  val animalDivertido = new Animal {
    override def comer: Unit = println("soy un animal divertido!!")
  }

  println(animalDivertido.getClass)

  /**
   * Asi es como por detras el compilador crea la clase "anonima"
   * class ClasesAnonimas$$anon$1 extends Animal {
   *    override def comer: Unit = println("clase desanonimizada.")
   * }
   */


  /**
   *
   * Las clases anonimas no pueden tener constores, es decir, no se les "puede pasar parametros"
   */
  class Persona (nombre: String) {

    def diHola: Unit = println("Hola!")
  }

  val jose = new Persona ("Jose") {

    override def diHola: Unit = println(s"Hola, soy ${this}")
  }
}
