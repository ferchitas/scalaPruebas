package lectures.part2oop

import javax.swing.AncestorNotifier
import lectures.part2oop.TiposDeDatosAbstractos.Dog


/**
 *
 * como los Generics en Java sirve para reemplazarlo por un tipo
 */
object Generics extends App {

  class Lista[A] {

  }
  val listaEnteros = new Lista[Int]

  /**
   *
   * Lo interesante de Scala son los genericos covariantes. En Java podemos tener una jerarquia con dos clases y meter una
   * variable de tipo hijo en una de tipo padre. Lo que no podemos hacer es meter una lista de tipo hijo en una de tipo
   * padre.
   *
   * En Scala si se puede indicando que la lista (o el tipo de dato) es covariante (ponemos un + delante del tipo generico):
   */
  class Animal
  class Perro extends Animal
  class Gato extends Animal

  class ListaCovariante[+A]
  val listaDeAnimales: ListaCovariante[Animal] = new ListaCovariante[Gato]

  /**
   *
   * Pero tenemos un problema, si a la lista anterior de animales tratamos de meterle un perro, es decir estariamos
   * tratando de meter un perro dentro de una lista de gatos. Para solucionar esto, Scala implementa un mecanismo que en
   * caso de que la lista que tenemos no es de un tipo requerido, le podemos decir a que tipo debe de "transformarse"
   * para que si pueda almacenar los tipos que esperamos, es asi:
   *
   * A = gato
   * B = Animal
   *
   * Lo que hace es, si es una lista de gatos y metes un gato, sigues con una lista de gatos, pero si metes un perro,
   * el la lista pasa a ser una lista de animales que tiene gatos y un perro.
   */
  object Generics extends App {

    class Lista[+A] {
      def insertar[B >: A](elemento: B): Lista[B] = ???
    }

    val listaEnteros = new Lista[Int]

    /**
     *
     * Scala tambien tiene los genericos contravariantes. Esto es, que un tipo con un generico puede tener ese mismo tipo
     * con un generico que sea padre del anterior, esto se hace indicando un - en la definicion del tipo con el generico,
     * ejemplo (FLIPAS):
     *
     * Esto peude servir para hacer que un entrenador que inicialmente es de gatos tengas capcidades realmente
     */
    //class EntrenadorDeAnimales[-A]
    //val entrenador: EntrenadorDeAnimales[Gato] = new EntrenadorDeAnimales[Animal]

    /**
     *
     * Bound types, sirve para hacer que los genericos que tenga una clase solo puedan ser de un tipo o subtipos.
     * Se hace poniendo < dentro de la parte donde se indica que es generico. Despues se ponen : y a continuacion la clase
     * que va a hacer de corte.
     *
     * Si se pone > funciona al contrario y solo permite superclases de la indicada
     * En el ejemplo, una jaula solo puede tener animales "dentro"
     */
    class Jaula[A <: Animal](animal: A)

    val jaula = new Jaula(new Perro)
  }
}