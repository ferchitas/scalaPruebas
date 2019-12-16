package lectures.part1basics

object StringsOps7 extends App {

  /**
   *
   * Esto es un interpolador y lo que hace es inyectar un en in String el valo de un valor/variable, como concatenar.
   * Para que esto funciones es necesario añadir una "s" antes de las comillas de inicio.
   * Estos valores se pueden operar dentro de las expresion poniendo corchetes.
   *
   * Otro interpolardor es la f, sirve para indicar que es un String formateado.
   *
   * Si ponemos la palabra "raw delante del string, no la interpreta, por ejemplo si ponemos "\n" no hace un salto de
   * linea
   */
  val nombre = "Fernando"
  val edad = 24
  val saludo = s"Me llamo $nombre y tengo $edad"
  val saludo2 = s"Me llamo $nombre y tengo ${edad + 1}"

  println(saludo)
  println(saludo2)

  val coche = "Mercedes"
  val acceleracion = 10.9f

  println(f"my $coche%s puede acelerar de 0 a 100 km/h en $acceleracion%2.2f")

}
