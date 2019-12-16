package exercices

object EjercicioOOP {

  class Escritor(nombre: String, apellidos: String, val edad: Int) {

    def getNombreCompleto: Unit = println(s"$nombre $apellidos")
  }

  class Novela(nombre: String, anyo: Int, autor: Escritor) {

    def getEdadDelAutor: Int = autor.edad
    def escritaPor: Escritor = autor
    def copia(nuevoAnyoDePublicacion: Int): Novela = new Novela(nombre, nuevoAnyoDePublicacion, autor)
  }

  class Contador(val inicio: Int = 0) {

    def sumarUno: Contador = new Contador(inicio + 1)
    def restaUno: Contador = new Contador(inicio - 1)

    def sumar(cantidad: Int): Contador = new Contador(inicio + cantidad)
    def resta(cantidad: Int): Contador = new Contador(inicio - cantidad)
  }
}
