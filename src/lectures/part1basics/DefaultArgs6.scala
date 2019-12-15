package lectures.part1basics

object DefaultArgs6 extends App {

  /**
   * Los argumentos por defecto se utilizan apra inicializar algunos de los argumentos que es necesario que se les pase
   * a la funcion pero que en muchisimos casos tendran el mismo valor.
   * En el caso de la funcion factorial, el acumulado siempre empieza por 1. Este valor nos e puede tampoco inicializar
   * dentro de al funcion por evidnetes razones.
   * POr esto le ponemos en la signatura de la funcion el valor por defecto al parametro con un "="
   *
   * @param n
   * @param acumulado
   * @return
   */
  def factorial(n: BigInt, acumulado: BigInt = 1): BigInt = {
    if(n <= 1) acumulado
    else factorial(n - 1, acumulado * n)
  }

  val fact10 = factorial(10)

  /**
   *
   * Con el valor por defecto no es necesario que le pasemos ese paramentro como se ve arriba.
   * SIn embargo, si le añadimos un valor en la posicion de ese parametro, sobreescribira el valor por defecto
   */
  val wrongFact10 = factorial(10, 3)

  /**
   * Si tenemos una funcion con varios parametros y alguno de ellos tiene argumentos inicializados por defecto, tenemos
   * un problema al llamarlo porque el compilador no es capaz de asignar cada uno al que le corresponda
   *
   * @param formato
   * @param anchura
   * @param altura
   */
  def guardarImagen(formato: String = "jpg", anchura: Int = 1, altura: Int = 1): Unit = println("Guardando...")

  /**
   *
   * Esto se soluciona poniendo el nombre de los apramentros que si queremos sobreescribir.
   * esto tambien permite cambiar el orden de los paramentros
   */
  guardarImagen(anchura = 2)
}
