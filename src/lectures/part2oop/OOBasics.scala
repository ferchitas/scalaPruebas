package lectures.part2oop

object OOBasics extends App {

  val persona = new Persona("Fernando", 12)
  println(persona.edad)
  persona.saludo("Juan")
}

/**
 *
 * Esto es un constructor, si no inidicamos en los parametros del constructor que son val, solos eran paametros del
 * constructor, con el val lo convertimos en atributos de la clase y se puede acceder a ellos, no es necesario un getter.
 * Los atributos definidos en el constructor de la definicion de la clase peuden tener valores por defecto.
 *
 * Los val que se definan dentro del cuerpo de la clase seran atributos de la clase.
 * Cuando se instancia una clase cada elemento dentro de él se ejecutará, por ejemplo un println suelto. Los metodos no.
 *
 * Con this hacemos referencia al objeto dentro de este
 *
 * Scala permite sobrecarga de metodos
 *
 * Se pueden tener mas de un constructor se hacen con la palabra this, no con el nombre de la clase
 *
 * @param nombre
 * @param edad
 */
class Persona(nombre: String, val edad: Int) {

  def saludo(nombre: String): Unit = println(s"Soy ${this.nombre}, buenas $nombre")
  def saludo(): Unit = println(s"Soy ${this.nombre}")

  def this(nombre: String) = this(nombre, 0)
}