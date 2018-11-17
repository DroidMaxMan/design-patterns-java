# Apuntes de [Patrones de diseño] en [Java] - WIP

Los patrones de diseño son unas técnicas para resolver problemas comunes en el desarrollo de software y otros ámbitos referentes al diseño de interacción o interfaces.

Los patrones de diseño pretenden:

* Proporcionar catálogos de elementos reusables en el diseño de sistemas software.
* Evitar la reiteración en la búsqueda de soluciones a problemas ya conocidos y solucionados anteriormente.
* Formalizar un vocabulario común entre diseñadores.
* Estandarizar el modo en que se realiza el diseño.
* Facilitar el aprendizaje de las nuevas generaciones de diseñadores condensando conocimiento ya existente.

Asimismo, no pretenden:

* Imponer ciertas alternativas de diseño frente a otras.
* Eliminar la creatividad inherente al proceso de diseño.

No es obligatorio utilizar los patrones, solo es aconsejable en el caso de tener el mismo problema o similar que soluciona el patrón, siempre teniendo en cuenta que en un caso particular puede no ser aplicable. "Abusar o forzar el uso de los patrones puede ser un error".

## Behavioral Patterns

Los patrones de comportamiento se definen como patrones de diseño software que ofrecen soluciones respecto a la interacción y responsabilidades entre clases y objetos, así como los algoritmos que encapsulan.

Los patrones de comportamiento son _Chain of Responsibility_, _Command_, _Interpreter_, _Iterator_, _Mediator_, _Memento_, _Observer_, _State_, _Strategy_, _Template Method_ y _Visitor_.

* [Chain of Responsibility](https://es.wikipedia.org/wiki/Cadena_de_responsabilidad) - Este patrón es un patrón de comportamiento que evita acoplar el emisor de una petición a su receptor dando a más de un objeto la posibilidad de responder a una petición. Para ello, se encadenan los receptores y pasa la petición a través de la cadena hasta que es procesada por algún objeto.

* [x] [Command](https://es.wikipedia.org/wiki/Command_%28patr%C3%B3n_de_dise%C3%B1o%29) - Este patrón permite solicitar una operación a un objeto sin conocer realmente el contenido de esta operación ni el receptor real de la misma. Para ello se encapsula la petición como un objeto, con lo que además facilita la parametrización de los métodos.

* [Interpreter](https://es.wikipedia.org/wiki/Interpreter_(patr%C3%B3n_de_dise%C3%B1o)) - Es un patrón de diseño que, dado un lenguaje, define una representación para su gramática junto con un intérprete del lenguaje. Se usa para definir un lenguaje para representar expresiones regulares que representen cadenas a buscar dentro de otras cadenas. Además, en general, para definir un lenguaje que permita representar las distintas instancias de una familia de problemas.

* [Iterator](https://es.wikipedia.org/wiki/Iterador_%28patr%C3%B3n_de_dise%C3%B1o%29) - Permite realizar recorridos sobre objetos compuestos independientemente de la implementación de éstos.

* [Mediator](https://es.wikipedia.org/wiki/Mediator_(patr%C3%B3n_de_dise%C3%B1o)) - Este patrón define un objeto que encapsula cómo un conjunto de objetos interactúan

* [Memento](https://es.wikipedia.org/wiki/Memento_(patr%C3%B3n_de_dise%C3%B1o)) - Es un patrón de diseño cuya finalidad es almacenar el estado de un objeto (o del sistema completo) en un momento dado de manera que se pueda restaurar en ese punto de manera sencilla. Para ello se mantiene almacenado el estado del objeto para un instante de tiempo en una clase independiente de aquella a la que pertenece el objeto (pero sin romper la encapsulación), de forma que ese recuerdo permita que el objeto sea modificado y pueda volver a su estado anterior.

* [Observer](https://es.wikipedia.org/wiki/Observer_%28patr%C3%B3n_de_dise%C3%B1o%29) - Se utiliza para definir relaciones 1 a *n* de forma que un objeto pueda notificar y/o actualizar el estado de otros automáticamente.

* [State](https://es.wikipedia.org/wiki/State_%28patr%C3%B3n_de_dise%C3%B1o%29) - Permite que un objeto modifique su comportamiento cada vez que cambie su estado interno.

* [Strategy](https://es.wikipedia.org/wiki/Strategy_%28patr%C3%B3n_de_dise%C3%B1o%29) - Se utiliza para encapsular el funcionamiento de una familia de algoritmos, de forma que se pueda intercambiar su uso sin necesidad de modificar los clientes.

* [Template Method](https://es.wikipedia.org/wiki/Template_Method_%28patr%C3%B3n_de_dise%C3%B1o%29) - Se puede utilizar cuando es necesario redefinir algunos pasos de un determinado algoritmo utilizando herencia.

* [Visitor](https://es.wikipedia.org/wiki/Visitor_%28patr%C3%B3n_de_dise%C3%B1o%29) - Proporciona un mecanismo para realizar diferentes operaciones sobre una jerarquía de objetos de forma que añadir nuevas operaciones no haga necesario cambiar las clases de los objetos sobre los que se realizan las operaciones.

### *__Command__*

**Gof**: Encapsule una solicitud como un objeto, lo que le permite parametrizar a los clientes con diferentes solicitudes, solicitudes de cola o registro y admite operaciones que no se pueden deshacer.

El patrón *__'Command'__* permite solicitar una operación a un objeto sin conocer realmente el contenido de esta operación ni el receptor real de la misma. Para ello se encapsula la petición como un objeto, con lo que además facilita la parametrización de los métodos.

#### Concepto

En general, se asocian cuatro términos: **invocador**, **cliente**, **comando** y **receptor**.

El objeto **cliente** crea y contiene el objeto invocador y los objetos de comando asociados con el receptor. El cliente decide cuál de estos comandos debe ejecutar en un momento determinado, como por ejemplo como respuesta a un botón pulsado en la UI. En ese momento, el cliente pasa el objeto de comando concreto al invocador para ejecutar la acción en el receptor asociada a ese comando.

Un **invocador** solo conoce la interfaz de comandos, pero desconoce totalmente los comandos concretos. El invocador recibe la orden de ejecución y el comando a ejecutar e invoca el método del comando.

Un objeto de **comando** es capaz de llamar a un método particular en el receptor. La lógica de la acción a ejecutar está definida en el método en el **receptor** que es invocado por el **comando**.

![Concepto](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/behavioral/command/command.png)

#### Problema

Existe un gran número de situaciones y escenarios en las que la relación directa entre el emisor de una orden y el receptor de la misma es insuficiente:

* La invocación directa afecta sólo a emisor y receptor por lo que resulta complicado ampliar dicha relación a otros actores, como por ejemplo barras de progreso, ayuda contextual, etc...

* A veces es necesario un modelo de ejecución transaccional (al igual que en las bases de datos) en las que es necesario que se ejecuten todas las órdenes o si en caso de que alguna falle o no sea posible ejecutar, se deshagan todas las órdenes relacionadas y se mantenga o restaure el estado anterior.

* En las aplicaciones multi-hilo, este patrón es un método sencillo para desacoplar productores y receptores de órdenes, dado que los productores y receptores pueden estar en diferentes hilos.

* En los juegos en red mayormente se necesitan ejecutar órdenes en todos los dispositivos participantes. Este patrón facilita la serialización de las órdenes ya que sólo hay que serializar los objetos que las representan.

* Muchos juegos añaden algún tipo de consola para interactuar directamente con el motor del juego empleando un intérprete de comandos. Mediante este patrón, se pueden sintetizar las órdenes como si hubieran sido producidas por el propio motor, facilitando la prueba y su depuración.

* En el uso de macros también se hace necesario el uso de este patrón.

* En el caso de los asistentes o *'wizards'* este patrón permite desacoplar el interfaz de usuario de las órdenes ya que una vez configurada la secuencia y tipo de órdenes desde el asistente, una vez sea aceptado por el usuario es cuando se emite el mensaje y se ejecutan dichas órdenes.

#### Implementación

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/behavioral/command/demo/diagram.png)

```java
interface ICommand {
    void action();
}

// Command
public class Redo implements ICommand {
    private Receiver receiver;

    public Redo(Receiver recv) {
        receiver = recv;
    }

    @Override
    public void action() {
        //Call redo in receiver
        receiver.performRedo();
    }
}

// Receptor que contiene la lógica a ejecutar
public class Receiver {
    void performUndo() { System.out.println("Executing - Undo"); }

    void performRedo() { System.out.println("Executing - Redo"); }

}

// Un invocador sólo conoce la interfaz de comandos ('ICommand')
public class Invoker {
    public void execute(ICommand cmd) {
        cmd.action();
    }
}
```

#### Consideraciones

* Como se ha comentado, este patrón desacopla el objeto que invoca la operación del objeto que sabe realizarla.

* Las órdenes son objetos y por tanto pueden ser manipulados y extendidos como cualquier otro objeto. Además, permite que sean gestionados en colas de objetos o mantener un registro de mensajes.

* Las órdenes pueden incluir transacciones para garantizar la consistencia y estado de los objetos. Por tanto, existe la posibilidad de restaurar estados anteriores.

* Al usar objetos se facilita el uso de parámetros a la hora de ejecutar las órdenes.

* Este patrón es ampliamente utilizado para operaciones de deshacer/rehacer.

* Una función de devolución de llamada se puede diseñar con este patrón.

### *__Iterator__*

**GoF**: Proporcionar una forma de acceder a los elementos de un objeto agregado de forma secuencial sin exponer su representación subyacente.

#### Concepto

El patrón *__Iterator__* se utiliza para ofrecer una interfaz de acceso secuencial a una determinada estructura ocultando la representación interna y la forma en que realmente se accede.

La solución que propone el patrón *__Iterator__* es añadir métodos que permitan recorrer la estructura sin referenciar explícitamente su representación, es decir, sin exponer su representación interna. La responsabilidad del recorrido se traslada a un objeto iterador.

El problema de introducir este objeto iterador reside en que los clientes necesitan conocer la estructura para crear el iterador apropiado. Esto se soluciona generalizando los distintos iteradores en una abstracción y dotando a las estructuras de datos de un método de fabricación que cree un iterador concreto.

Diferentes iteradores pueden presentar diferentes tipos de recorrido sobre la estructura. No sólo eso, sino que podrían incorporar funcionalidad extra como por ejemplo filtrado de elementos, etc..

![Concepto](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/behavioral/iterator/iterador.png)

#### Problema

Manejar colecciones de datos es algo muy habitual en el desarrollo de aplicaciones. Listas, pilas y, sobre todo, árboles son ejemplos de estructuras de datos muy presentes en los juegos y se utilizan de forma intensiva.

Una operación muy habitual es recorrer las estructuras para analizar y/o buscar los datos que contienen. Es posible que sea necesario recorrer la estructura de forma secuencial, de dos en dos o, simplemente, de forma aleatoria. Los clientes suelen implementar el método concreto con el que desean recorrer la estructura por lo que puede ser un problema si, por ejemplo, se desea recorrer una misma estructura de datos de varias formas distintas. Conforme aumenta las combinaciones entre los tipos de estructuras y métodos de acceso, el problema se agrava.

#### Implementación

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/behavioral/iterator/example/diagram.png)

La estructura de datos es la encargada de crear el iterador adecuado para ser accedida a través del método `'iterator()'`. Una vez que el cliente ha obtenido el  iterador, puede utilizar los métodos de acceso que ofrecen tales como `'next()'` (para obtener el siguiente elemento) o `'isDone()'` para comprobar si existen más elementos.

```java
public class RandomData {
    int[] data;

    public RandomData(int length) {
        data = new int[length];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Random().nextInt(500);
        }
    }

    public IteratorData iterator() {
        return new IteratorData(this);
    }
}

public class IteratorData {
    private int[] data;
    private int pos;

    IteratorData(RandomData randomData) {
        data = randomData.data;
        pos = 0;
    }

    public boolean hasNext() {
        return pos < data.length;
    }

    public Object next() {
        int valor = data[pos];
        pos++;
        return valor;
    }
}

public class Client {
    public static void main(String[] args) {
        RandomData vector = new RandomData(5);

        IteratorData iterator = vector.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
```

## Creational Patterns

Los patrones creacionales corresponden a patrones de diseño de software que solucionan problemas de creación de instancias. Nos ayudan a encapsular y abstraer dicha creación.

Los patrones creacionales son _Abstract Factory_, _Builder_, _Factory Method_, _Prototype_ y _Singleton_.

* [Abstract Factory](https://es.wikipedia.org/wiki/Abstract_Factory) - permite trabajar con objetos de distintas familias de manera que las familias no se mezclen entre sí y haciendo transparente el tipo de familia concreta que se esté usando.

* [Builer](https://es.wikipedia.org/wiki/Builder_(patr%C3%B3n_de_dise%C3%B1o)) - Este patrón es usado para permitir la creación de una variedad de objetos complejos desde un objeto fuente (Producto), el objeto fuente se compone de una variedad de partes que contribuyen individualmente a la creación de cada objeto complejo a través de un conjunto de llamadas a interfaces comunes de la clase Abstract Builder.

* [Factory Method](https://es.wikipedia.org/wiki/Factory_Method_%28patr%C3%B3n_de_dise%C3%B1o%29) - consiste en utilizar una clase constructora (al estilo del Abstract Factory) abstracta con unos cuantos métodos definidos y otro(s) abstracto(s): el dedicado a la construcción de objetos de un subtipo de un tipo determinado.

* [Prototype](https://es.wikipedia.org/wiki/Prototype_%28patr%C3%B3n_de_dise%C3%B1o%29) -  crea nuevos objetos clonándolos de una instancia ya existente.

* [Singleton](https://es.wikipedia.org/wiki/Singleton) - garantiza la existencia de una única instancia para una clase y la creación de un mecanismo de acceso global a dicha instancia. Restringe la instanciación de una clase o valor de un tipo a un solo objeto.

## Structural Patterns

Los patrones estructurales son los patrones de diseño software que solucionan problemas de composición (agregación) de clases y objetos.

Los patrones estructurales son _Adapter_, _Bridge_, _Composite_, _Decorator_, _Facade_, _Flyweight_ y _Proxy_.

* [Adapter](https://es.wikipedia.org/wiki/Adapter_%28patr%C3%B3n_de_dise%C3%B1o%29) - Este patrón se utiliza para proporcionar una interfaz que, por un lado, cumpla con las demandas de los clientes y, por otra, haga compatible otra interfaz que, a priori, no lo es.

* [Bridge](https://es.wikipedia.org/wiki/Bridge_(patr%C3%B3n_de_dise%C3%B1o)) - Este patrón es una técnica usada en programación para desacoplar una abstracción de su implementación, de manera que ambas puedan ser modificadas independientemente sin necesidad de alterar por ello la otra. Esto es, se desacopla una abstracción de su implementación para que puedan variar independientemente.

* [Composite](https://es.wikipedia.org/wiki/Composite_%28patr%C3%B3n_de_dise%C3%B1o%29) - sirve para construir objetos complejos a partir de otros más simples y similares entre sí, gracias a la composición recursiva y a una estructura en forma de árbol.

* [Decorator](https://es.wikipedia.org/wiki/Decorator_%28patr%C3%B3n_de_dise%C3%B1o%29) - Añade funcionalidad a una clase dinámicamente.

* [Facade](https://es.wikipedia.org/wiki/Facade_%28patr%C3%B3n_de_dise%C3%B1o%29) - Provee de una interfaz unificada simple para acceder a una interfaz o grupo de interfaces de un sistema.

* [Flyweight](https://es.wikipedia.org/wiki/Flyweight_(patr%C3%B3n_de_dise%C3%B1o)) - El patrón Flyweight (u objeto ligero) sirve para eliminar o reducir la redundancia cuando tenemos gran cantidad de objetos que contienen información idéntica, además de lograr un equilibrio entre flexibilidad y rendimiento (uso de recursos).

* [Proxy](https://es.wikipedia.org/wiki/Proxy_%28patr%C3%B3n_de_dise%C3%B1o%29) - Proporciona mecanismos de abstracción y control para acceder a un determinado objeto "simulando" que se trata del objeto real.

## Otros patrones

* [Reactor](https://es.wikipedia.org/wiki/Reactor_%28patr%C3%B3n_de_dise%C3%B1o%29) - Es un patrón de programación concurrente para manejar los pedidos de servicio entregados de forma concurrente a un manejador de servicio desde una o más entradas. El manejador de servicio demultiplexa los pedidos entrantes y los entrega de forma sincrónica a los manejadores de pedidos asociados.

* [MVC](https://es.wikipedia.org/wiki/Modelo%E2%80%93vista%E2%80%93controlador) - Separa los datos y la lógica de negocio de una aplicación de la interfaz de usuario y el módulo encargado de gestionar los eventos y las comunicaciones.

---

## License

[![Licencia de Creative Commons](https://i.creativecommons.org/l/by-sa/4.0/80x15.png)](http://creativecommons.org/licenses/by-sa/4.0/)  
Esta obra está bajo una [licencia de Creative Commons Reconocimiento-Compartir Igual 4.0 Internacional](http://creativecommons.org/licenses/by-sa/4.0/).
