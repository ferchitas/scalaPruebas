package lectures.part2oop

object TiposDeDatosAbstractos extends App {

  /**
   *
   * Abstract
   */

  abstract class Animal {

    val tipoDeCreatura: String
    def comer: Unit
  }

  class Dog extends Animal {
    override val tipoDeCreatura: String = "Canino"
    override def comer: Unit = println("mordiendo...")
  }

  /**
   *
   * Traits
   */

  trait Carnivoro {

    def comer(animal: Animal): Unit
  }

  class Cocodrilo extends Animal with Carnivoro {

    val tipoDeCreatura: String = "Reptil"
    def comer: Unit = println("masticando...")
    def comer(animal: Animal): Unit = println(s"Soy un cocodrilo y me estoy comiendo un ${animal.tipoDeCreatura}")
  }

  /**
   *
   * Diferencias entre basrtact y trait
   * abstract pueden tener miembros definidos como abstractos y como no abstractos
   * Los traits no tienen constructores
   * Una clase puede heredar varios traits
   * Los tratis definen comportamientos de las clases que los heredan
   */
}
