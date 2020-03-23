package lectures.part2oop

import lectures.part1basics.{DefaultArgs6, Expressions2}

import java.util.{Date => UtilDate}
import java.sql.{Date => SqlDate}
/**
 *
 * los elementos que esten dentro del mismo paquete se les puede utilizar con su nombre directamente, no e snecesario
 * el import.
 * Si estan fuera si es necesario.
 * Esto es igual que Java
 *
 * Pero Scala tiene algunas cosas mas, por ejemplo los package objects, solo puede haber uno de ellos por paquete y se
 * llaman igual que el paquete y el fichero se llama package.scala, no como el paquete.scala. Se utiliza para almacenar
 * elementos (variables, metodos) que solo tienen sentido dentro del paquete
 *
 * Si importamos dos o mas elementos del mismo paquete, envez de poner dos imports pondra el nombre del paquete y las
 * clases entre {}, ejemplo con las clases del paquete lectures.part1basics.
 *
 * Tambien se le puede poner un alias a la clase que se esta importando con =>. Esto viene bien si
 * hay dos clases que se llaman igual en distintos paquetes. De esta forma podemos utilizar ambos sin tener que utilizar
 * el nombre completo cualificado (Ejemplo con Date).
 *
 * El paquete java.lang esta importado por defecto, entre otros
 */
object EmpaquetamientoEImports extends App {

  val defaul = DefaultArgs6
  val expresion = Expressions2

  val dateUtil = new UtilDate
  val dateSql = new SqlDate(2020, 3,23)


}
