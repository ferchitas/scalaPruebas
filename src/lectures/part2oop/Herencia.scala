package lectures.part2oop

object Herencia extends App{

  /**
   *
   * el modificar protected significa que se peude llamr al metodo desde entro de esa clase y sus subclases pero
   * no fuera de ellas.
   * Tambien esta private, es como en Java
   * Si no se pone nada es public
   */
  class Animal {

    val typoDeCreatura = "Salvaje"
    protected def eat = println("comida")
  }

  class Cat extends Animal {

    def crujir = {

      eat
      println("crujido...")
    }
  }


  /**
   *
   * Constructores
   *
   * Hay que poner en el extends los paramentros del constructor de la clase padre porque es como hacer la llamada
   * neceasria al super.
   * Como en persona tenemos definidos dos constructores, uno con un parametro y otro con dos, en el extends se puede
   * llamar a ambos.
   */

  class Persona (nombre: String, edad: Int) {

    def this(nombre: String) = this(nombre, 0)
  }
  class Adulto (nombre: String, edad: Int, id: String) extends Persona(nombre, edad)


  /**
   *
   * Sobreescritura
   *
   * Sobreescribiendo el metodo eat del padre
   * Sobreescribiendo el valor del padre typoDeCreatura, esto se puede hacer poniendolo dentro de la clase como en el
   * comentario o poniendolo en la definicion de la clase a traves del constructor implicito
   */

  class Perro(override val typoDeCreatura: String) extends Animal {

    //override val typoDeCreatura: String = "Domestica"
    override def eat: Unit = println("guau")
  }

  /**
   *
   * Tambien hay polimorfismo
   */


  /**
   *
   * Super para llamar a las cosas del padre
   */

  /**
   *
   * Para evitar la sobreescribir metodos se utiliza el modficador final, tanto a nivel de clase como de miembros.
   * Por ejemplo String en scala es final
   * Tambien tiene un modificador que se llama sealed, con el solo las clases de dentro del mismo fichero pueden extender,
   * clases de ficheros externos fallaran al compilar.
   */
}
