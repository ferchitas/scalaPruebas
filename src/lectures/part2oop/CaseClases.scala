package lectures.part2oop

object CaseClases extends App{

  /**
   *
   * Las clases case tiene algunas caracteristicas:
   *    - los parametros del contructor son atributos de la clase
   *    - Tienen una implementacion de toString mostrando el nombre de la clase y sus atributos. SI nopenmos solo la
   *    variable, sin la llamada a toString, tambien llama por detras (azucar sintactica)
   *    - Equals y hasCode tambien estan implementados especialemnte. Equals compara que sea del mismo tipo y que tenga
   *    los mismo valores al contrario que en clases normales que compara que sean la misma instacia independientemente
   *    de sus campos.
   *    - Tiene metodos para copiar y generar nuevas isntacias iguales (como el clone pero ya implementado).
   *    Ademas el metodo copy permite pasarle los mismos paramentros que a la clase como tal dando la posibilidad de
   *    sobreecrbir su valor
   *    - Tiene companion objects por loq ue eprmite crear objetos que tengan el case sin que sea necesario poner el new.
   *    - Son serializables, si se trabaja con akka es util
   *    - Tiene patrones de extraccion, esto quere decir que se peuden utilziar con una caracterstica de scala llamada
   *    pattern matching (mas adelante se verá)
   */
  case class Persona(nombre: String, edad: Int)

  val jose = new Persona("Jose", 32)
  println(jose.nombre)
  println(jose.toString)
  println(jose)

  val jose2 = new Persona("Jose", 32)
  println(jose == jose2)

  val jose3 = jose.copy()

  val Maria = Persona("Maria", 43)

  case object China {

    def nombre: String = "Soy Chinaa"
  }
}
