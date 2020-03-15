package lectures.part2oop


/**
 *
 * en scala no existe el modificador "static", se deben de utilizar instacion, nunca las clases en si mismas.
 * Para conseguir este fin estan los "object".
 * Un objeto no peude recibir paramentros en sus constructor.
 * Un object en scala es un singleton.
 * Se pueden definir clases y objetos con el mismo nombre, de esta forma la aprte estatica de una clase se puede separar
 * Los objetos tambien se utilizan para almacenar metodos factoria de la clase
 * en un object.
 */
object Objects extends App {

  object Persona {
    val N_OJOS = 2;
    def puedeVolar: Boolean = false

    //si definimos un metodo factoria que se llame apply, cuando lo queramos llamar no es necesario indicar su nombre
    def apply(mother: Persona, padre: Persona): Persona = new Persona("Pedro")
  }

  class Persona(val nombre: String) {

    println(Persona.N_OJOS)
    println(Persona.puedeVolar)

    //Pinta falso porque son instacias diferentes
    val maria = new Persona("Maria")
    val jose = new Persona("Jose")
    println(maria == jose)

    //Pinta verdadero porque son la misma instancia porque es un "object"
    val rosa = Persona
    val juan = Persona
    println(rosa == juan)

    //llamando al metodo apply del object Persona
    val pedro = Persona(maria, jose)


    /**
     *
     * Aplicaciones en scala:
     * El extends App de arriba hace que lo que haya dentro sea un object con el metodo:
     * def main(args: Array[String]): Unit
     * si quitamos el extends y no ponemos el main, no se executara ya que scala se traduce en cosigo Java y sin ese
     * la JVM no sabe por donde empezar
     */


  }
}
