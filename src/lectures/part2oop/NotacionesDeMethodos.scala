package lectures.part2oop

import scala.language.postfixOps

object NotacionesDeMethodos extends App {

  class PersonaN(val nombre: String, peliculaFavorita: String, edad: Integer = 0) {

    def leGusta(pelicula: String): Boolean = pelicula == peliculaFavorita

    def +(persona: PersonaN): String = s"${this.nombre} esta saliendo con ${persona.nombre}"

    def unary_! : String = s"$nombre, como??"

    def estaVivo: Boolean = true

    def apply(): String = s"Hola, sont $nombre y me gusta $peliculaFavorita"

    /**
     *
     * Ejercicios
     */
    //1
    //def +(persona: PersonaN): PersonaN =
    //  new PersonaN(s"${persona.nombre}, la estrella", s"${persona.peliculaFavorita}")

    //2
    //def uniry_+(person: PersonaN): PersonaN =
    //  new PersonaN(s"${person.nombre} mas mayor", s"${person.peliculaFavorita}", person.edad + 1)

    //3
    def aprendiendo(persona: PersonaN): String = s"${persona.nombre} esta aprendiendo Scala"

    //4
    def apply(nVeces: Integer): String = s"${this.nombre} ha visto $nVeces ${this.peliculaFavorita}"
  }

  val jose = new PersonaN("jose", "origen")
  println(jose.leGusta("la vida es bella"))

  /**
   *
   * para llamar a metodos con un solo paramentro podemos evitar poner el punto y podemos poner el paramentro dictamente sin parentesis
   * esto se llama "syntactic sugar"
   */
  println(jose leGusta "origen")

  val juan = new PersonaN("Juan", "Fargo")

  /**
   *
   * se pueden poner algunos caracteres que en otros lenguajes no se permiten como nombres de los metodos
   */
  println(juan + juan)

  /**
   *
   * esto es porque los operadores como + al final son metodos, ambas expresiones son los mismo:
   */
  println(1 + 2)
  println(1.+(2))

  /**
   *
   * este es otro ejemplo de syntactic sugar, llamado prefix notation, este tipo de metohod (unary_) solo funcionan con -, +, ~ y !
   * ambas expresiones son lo mismo:
   */
  print(!jose)
  print(jose.unary_!)

  /**
   *
   * Esta syntatic sugar se llama postfix notation, llamar a un metodo sin el punto
   */

  println(jose estaVivo)
  println(jose.estaVivo)

  /**
   *
   * metodos apply, con este metodo no es neceario poner su nombre
   */
  println(jose.apply())
  println(jose())
}

