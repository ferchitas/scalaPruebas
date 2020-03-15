package lectures.part2oop

object MethodNotations extends App {
  class Persona (name: String, peliculaFavorita: String) {
    def meGusta(pelicula: String): Boolean = pelicula == peliculaFavorita
    def salirCon (persona: Persona): Persona = persona
  }
  val fernando = new Persona("fernando", "fargo")

  /**
   *
   * estas dos expresiones son los mismo, asi tambien se puede llamar a una funcion, esta notcion se llama infix.
   * Slo funciona con metodos con un unico parametro.
   */
  println(fernando.meGusta("fargo"))
  println(fernando meGusta "fargo")
}
