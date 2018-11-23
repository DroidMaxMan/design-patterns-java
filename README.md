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

## "Behavioral Patterns"

Los patrones de comportamiento se definen como patrones de diseño software que ofrecen soluciones respecto a la interacción y responsabilidades entre clases y objetos, así como los algoritmos que encapsulan.

Los patrones de comportamiento son _Chain of Responsibility_, _Command_, _Interpreter_, _Iterator_, _Mediator_, _Memento_, _Observer_, _State_, _Strategy_, _Template Method_ y _Visitor_.

* [Chain of Responsibility](https://es.wikipedia.org/wiki/Cadena_de_responsabilidad) - Este patrón es un patrón de comportamiento que evita acoplar el emisor de una petición a su receptor dando a más de un objeto la posibilidad de responder a una petición. Para ello, se encadenan los receptores y pasa la petición a través de la cadena hasta que es procesada por algún objeto.

* [Interpreter](https://es.wikipedia.org/wiki/Interpreter_(patr%C3%B3n_de_dise%C3%B1o)) - Es un patrón de diseño que, dado un lenguaje, define una representación para su gramática junto con un intérprete del lenguaje. Se usa para definir un lenguaje para representar expresiones regulares que representen cadenas a buscar dentro de otras cadenas. Además, en general, para definir un lenguaje que permita representar las distintas instancias de una familia de problemas.

* [Mediator](https://es.wikipedia.org/wiki/Mediator_(patr%C3%B3n_de_dise%C3%B1o)) - Este patrón define un objeto que encapsula cómo un conjunto de objetos interactúan

* [Memento](https://es.wikipedia.org/wiki/Memento_(patr%C3%B3n_de_dise%C3%B1o)) - Es un patrón de diseño cuya finalidad es almacenar el estado de un objeto (o del sistema completo) en un momento dado de manera que se pueda restaurar en ese punto de manera sencilla. Para ello se mantiene almacenado el estado del objeto para un instante de tiempo en una clase independiente de aquella a la que pertenece el objeto (pero sin romper la encapsulación), de forma que ese recuerdo permita que el objeto sea modificado y pueda volver a su estado anterior.

* [Strategy](https://es.wikipedia.org/wiki/Strategy_%28patr%C3%B3n_de_dise%C3%B1o%29) - Se utiliza para encapsular el funcionamiento de una familia de algoritmos, de forma que se pueda intercambiar su uso sin necesidad de modificar los clientes.

* [Template Method](https://es.wikipedia.org/wiki/Template_Method_%28patr%C3%B3n_de_dise%C3%B1o%29) - Se puede utilizar cuando es necesario redefinir algunos pasos de un determinado algoritmo utilizando herencia.

* [Visitor](https://es.wikipedia.org/wiki/Visitor_%28patr%C3%B3n_de_dise%C3%B1o%29) - Proporciona un mecanismo para realizar diferentes operaciones sobre una jerarquía de objetos de forma que añadir nuevas operaciones no haga necesario cambiar las clases de los objetos sobre los que se realizan las operaciones.

### - *__Command__* -

**Gof**: Encapsule una solicitud como un objeto, lo que le permite parametrizar a los clientes con diferentes solicitudes, solicitudes de cola o registro y admite operaciones que no se pueden deshacer.

#### Concepto

El patrón *__'Command'__* permite solicitar una operación a un objeto sin conocer realmente el contenido de esta operación ni el receptor real de la misma. Para ello se encapsula la petición como un objeto, con lo que además facilita la parametrización de los métodos.

En general, se asocian cuatro términos: **invocador**, **cliente**, **comando** y **receptor**.

El objeto **cliente** crea y contiene el objeto invocador y los objetos de comando asociados con el receptor. El cliente decide cuál de estos comandos debe ejecutar en un momento determinado, como por ejemplo como respuesta a un botón pulsado en la UI. En ese momento, el cliente pasa el objeto de comando concreto al invocador para ejecutar la acción en el receptor asociada a ese comando.

Un **invocador** solo conoce la interfaz de comandos, pero desconoce totalmente los comandos concretos. El invocador recibe la orden de ejecución y el comando a ejecutar e invoca el método del comando.

Un objeto de **comando** es capaz de llamar a un método particular en el receptor. La lógica de la acción a ejecutar está definida en el método en el **receptor** que es invocado por el **comando**.

![Concepto](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/behavioral/command.png)

El uso del patrón *__'Command'__* puede ser productivo en aquellas situaciones y escenarios en las que la relación directa entre el emisor de una orden y el receptor de la misma es insuficiente:

* La invocación directa afecta sólo a emisor y receptor por lo que resulta complicado ampliar dicha relación a otros actores, como por ejemplo barras de progreso, ayuda contextual, etc...

* A veces es necesario un modelo de ejecución transaccional (al igual que en las bases de datos) en las que es necesario que se ejecuten todas las órdenes o si en caso de que alguna falle o no sea posible ejecutar, se deshagan todas las órdenes relacionadas y se mantenga o restaure el estado anterior.

* En las aplicaciones multi-hilo, este patrón es un método sencillo para desacoplar productores y receptores de órdenes, dado que los productores y receptores pueden estar en diferentes hilos.

* En los juegos en red mayormente se necesitan ejecutar órdenes en todos los dispositivos participantes. Este patrón facilita la serialización de las órdenes ya que sólo hay que serializar los objetos que las representan.

* Muchos juegos añaden algún tipo de consola para interactuar directamente con el motor del juego empleando un intérprete de comandos. Mediante este patrón, se pueden sintetizar las órdenes como si hubieran sido producidas por el propio motor, facilitando la prueba y su depuración.

* En el uso de macros también se hace necesario el uso de este patrón.

* En el caso de los asistentes o *'wizards'* este patrón permite desacoplar el interfaz de usuario de las órdenes ya que una vez configurada la secuencia y tipo de órdenes desde el asistente, una vez sea aceptado por el usuario es cuando se emite el mensaje y se ejecutan dichas órdenes.

#### Implementación

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/behavioral/command/example2/diagram.png)

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

#### Referencia

<https://es.wikipedia.org/wiki/Command_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Iterator__* -

**GoF**: Proporcionar una forma de acceder a los elementos de un objeto agregado de forma secuencial sin exponer su representación subyacente.

#### Concepto

El patrón *__'Iterator'__* se utiliza para ofrecer una interfaz de acceso secuencial a una determinada estructura ocultando la representación interna y la forma en que realmente se accede, o lo que es lo mismo, permite realizar recorridos sobre objetos compuestos independientemente de la implementación de éstos.

La solución que propone el patrón *__'Iterator'__* es añadir métodos que permitan recorrer la estructura sin referenciar explícitamente su representación, es decir, sin exponer su representación interna. La responsabilidad del recorrido se traslada a un objeto iterador.

El problema de introducir este objeto iterador reside en que los clientes necesitan conocer la estructura para crear el iterador apropiado. Esto se soluciona generalizando los distintos iteradores en una abstracción y dotando a las estructuras de datos de un método de fabricación que cree un iterador concreto.

Diferentes iteradores pueden presentar diferentes tipos de recorrido sobre la estructura. No sólo eso, sino que podrían incorporar funcionalidad extra como por ejemplo filtrado de elementos, etc..

![Concepto](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/behavioral/iterador.png)

El uso del patrón *__'Iterator'__* es muy común ya que manejar colecciones de datos es algo muy habitual en el desarrollo de aplicaciones. Listas, pilas y, sobre todo, árboles son ejemplos de estructuras de datos muy presentes en los juegos y se utilizan de forma intensiva.

Una operación muy habitual es recorrer las estructuras para analizar y/o buscar los datos que contienen. Es posible que sea necesario recorrer la estructura de forma secuencial, de dos en dos o, simplemente, de forma aleatoria. Los clientes suelen implementar el método concreto con el que desean recorrer la estructura por lo que puede ser un problema si, por ejemplo, se desea recorrer una misma estructura de datos de varias formas distintas. Conforme aumenta las combinaciones entre los tipos de estructuras y métodos de acceso, el problema se agrava.

#### Implementación

La estructura de datos es la encargada de crear el iterador adecuado para ser accedida a través del método `'iterator()'`. Una vez que el cliente ha obtenido el  iterador, puede utilizar los métodos de acceso que ofrecen tales como `'next()'` (para obtener el siguiente elemento) o `'isDone()'` para comprobar si existen más elementos.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/behavioral/iterator/example/diagram.png)

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

#### Referencia

<https://es.wikipedia.org/wiki/Iterador_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Observer__* -

**GoF**: Define una dependencia de uno a muchos entre objetos para que cuando un objeto cambie de estado, todos sus dependientes sean notificados y actualizados automáticamente.

#### Concepto

El patrón *__'Observer'__* se utiliza para definir relaciones 1 a *n* de forma que un objeto pueda notificar y/o actualizar el estado de otros automáticamente.

El patrón *__'Observer'__* proporciona un diseño con **poco acomplamiento** entre los *observadores* y el objeto *observado*.

Siguiendo la filosofía de *publicación/suscripción*, los objetos observadores se deben registrar en el objeto observado llamado **sujeto** pasándole una referencia de si mismo. El sujeto mantiene una lista de de las referencias de los observadores. Cuando un observador ya no necesita ser notificado simplemente se borra de la lista de observadores.

Además, los observadores a su vez están obligados a implementar unos métodos determinados mediante los cuales el **sujeto** es capaz de notificar a los observadores suscritos los cambios que sufre para que todos ellos tengan constancia. Por tanto, cuando el evento oportuno, el sujeto recibirá una invocación y será el encargado de "notificar" a todos los elementos suscritos a él.

Los observadores que reciben la invocación pueden realizar las acciones pertinentes como consultar el estado del dominio para obtener nuevos valores.

![Concepto](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/behavioral/observer.png)

Puede pensarse en aplicar este patrón cuando una modificación en el estado de un objeto requiere cambios de otros, y no se desea que se conozca el número de objetos que deben ser cambiados. También cuando queremos que un objeto sea capaz de notificar a otros objetos sin hacer ninguna suposición acerca de los objetos notificados y cuando una abstracción tiene dos aspectos diferentes, que dependen uno del otro; si encapsulamos estos aspectos en objetos separados permitiremos su variación y reutilización de modo independiente.

#### Implementación

El siguiente ejemplo es una situación en que tenemos un único observador y un único sujeto. El patrón se puede adaptar para los casos en que haya uno o varios observadores y uno o varios sujetos.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/behavioral/observer/example2/diagram.png)

```java
interface ISubject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}

class Subject implements ISubject {
    private List<Observer> observerList = new ArrayList<>();
    private int flag;

    void setFlag(int flag) {
        this.flag = flag;
        //flag value changed. So notify observer(s)
        notifyObservers();
    }

    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}

class Observer {
    void update() {
        System.out.println("flag value changed in Subject");
    }
}
```

#### Referencia

<https://es.wikipedia.org/wiki/Observer_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__State__* -

**GoF**: Permitir que un objeto altere su comportamiento cuando cambia su estado interno. El objeto aparecerá para cambiar su clase.

#### Concepto

El patrón *__'State'__* permite que un objeto modifique su comportamiento cada vez que cambie su estado interno.

Es muy común que en cualquier aplicación, incluído los videojuegos, existan estructuras que pueden ser modeladas directamente como un autómata, es decir, una colección de estados y unas transiciones dependientes de una entrada. En este caso, la entrada pueden ser invocaciones y/o eventos recibidos.

Por ejemplo, los estados de un personaje de un videojuego podrían ser: de pie, tumbado, andando y saltando. Dependiendo del estado en el que se encuentre y de la invocación recibida, el siguiente estado será uno u otro. Si por ejemplo, está de pie y recibe la orden de tumbarse, ésta se podrá realizar. Sin embargo, si ya está tumbado no tiene sentido volver a tumbarse, por lo que debe permanecer en ese estado.

El patrón *__'State'__* permite encapsular el mecanismo de las transiciones que sufre un objeto a partir de los estímulos externos.

#### Implementación

A continuación se muestra un ejemplo de aplicación del mismo. La idea es crear una clase abstracta o interfaz que representa al estado del personaje (CharacterState). En ella se definen las mismas operaciones que puede recibir el personaje con una implementación por defecto. En este caso, la implementación es vacía.

Por cada estado en el que puede encontrarse el personaje, se crea una clase que hereda de la clase abstracta anterior, de forma que en cada una de ellas se implementen los métodos que producen cambio de estado, es decir, contendrán un método por cada posible transición.

Por ejemplo, según el diagrama, en el estado "de pie" se puede recibir la orden de caminar, tumbarse y saltar, pero no de levantarse. En caso de recibir esta última, se ejecutará la implementación por defecto, es decir, no hacer nada.

En definitiva, la idea es que las clases que representan a los estados sean las encargadas de cambiar el estado del personaje, de forma que los cambios de estados quedan encapsulados y delegados al estado correspondiente.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/behavioral/state.png)

```java
interface CharacterState {
    void walk();
    void getUp();
    void getDown();
    void jump();
}

class CharacterStanding implements CharacterState {
    private Character character;

    CharacterStanding(Character character) {
        this.character = character;
    }

    @Override
    public void walk() {
        System.out.println("Transición: De pie -> Andar");
        character.setState(new CharacterWalk(character));
    }

    @Override
    public void getUp() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getDown() {
        System.out.println("Transición: De pie -> Agachado");
        character.setState(new CharacterLying(character));
    }

    @Override
    public void jump() {
        System.out.println("Transición: De pie -> Saltando");
        character.setState(new CharacterJump(character));
    }
}

class CharacterJump implements CharacterState {
    private Character character;

    CharacterJump(Character character) {
        this.character = character;
    }

    @Override
    public void walk() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getUp() {
        System.out.println("Transición: Saltando -> Quieto");

        character.setState(new CharacterStanding(character));
    }

    @Override
    public void getDown() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void jump() {
        throw new UnsupportedOperationException();
    }
}

class Character {
    private CharacterState currentState;

    Character() {
        currentState = new CharacterStanding(this);
    }

    CharacterState getState() {
        return currentState;
    }

    void setState(CharacterState currentState) {
        this.currentState = currentState;
    }

    public void walk() {
        currentState.walk();
    }

    void getUp() {
        currentState.getUp();
    }

    void getDown() {
        currentState.getDown();
    }

    void jump() {
        currentState.jump();
    }
}
```

#### Consideraciones

Este patrón puede usarse cuando un determinado objeto tiene diferentes estados y también diferentes responsabilidades según el estado en que se encuentre en determinado instante. También puede utilizarse para simplificar casos en los que se tiene un complicado y extenso código de decisión que depende del estado del objeto.

Los componentes de diseño que se comporten como autómatas son buenos candidatos a ser modelos con el patrón *__'State'__*.

Es posible que una entrada provoque una situación de error estando en un determinado estado. Para ello es posible utilizar las excepciones para notificar dicho error.

Las clases que representan los estados **no deben mantener un estado intrínseco**, es decir, no se debe hacer uso de variables que dependan de un contexto.

Un sistema con muchos estados o si el número se incrementa significativamente se convierte en un sistema difícil de mantener.

#### Referencia

<https://es.wikipedia.org/wiki/State_%28patr%C3%B3n_de_dise%C3%B1o%29>
<https://danielggarcia.wordpress.com/2014/05/20/patrones-de-comportamiento-v-patron-state/>

## Creational Patterns

Los patrones creacionales corresponden a patrones de diseño de software que solucionan problemas de creación de instancias. Nos ayudan a encapsular y abstraer dicha creación.

Los patrones creacionales son _Abstract Factory_, _Builder_, _Factory Method_, _Prototype_ y _Singleton_.

* [Abstract Factory](https://es.wikipedia.org/wiki/Abstract_Factory) - permite trabajar con objetos de distintas familias de manera que las familias no se mezclen entre sí y haciendo transparente el tipo de familia concreta que se esté usando.

* [Builder](https://es.wikipedia.org/wiki/Builder_(patr%C3%B3n_de_dise%C3%B1o)) - Este patrón es usado para permitir la creación de una variedad de objetos complejos desde un objeto fuente (Producto), el objeto fuente se compone de una variedad de partes que contribuyen individualmente a la creación de cada objeto complejo a través de un conjunto de llamadas a interfaces comunes de la clase Abstract Builder.

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

### - *__Reactor__* -

El patrón *__'Reactor'__* es un patrón de programación concurrente para manejar los pedidos de servicio entregados de forma concurrente a un manejador de servicio desde una o más entradas. El manejador de servicio demultiplexa los pedidos entrantes y los entrega de forma sincrónica a los manejadores de pedidos asociados.

#### Concepto

El **patrón Reactor** es un patrón arquitectural para resolver el problema de cómo atender peticiones concurrentes a través de señales y manejadores de señales.

Existen aplicaciones, como los servidores web, cuyo comportamiento es *reactivo*, es decir, a partir de la ocurrencia de un evento externo se realizan todas las operaciones necesarias para atender a ese evento externo. En el caso del servidor web, una conexión entrante **(evento)** dispararía la ejecución del código pertinente que crearía un hilo de ejecución para atender a dicha conexión. Pero también pueden tener comportamiento *proactivo*. Por ejemplo, una señal interna puede indicar cuándo destruir una conexión con un cliente que lleva demasiado tiempo sin estar accesible.

En los videojuegos ocurre algo muy similar: diferentes entidades pueden lanzar eventos que deben ser tratados en el momento en el que se producen. Por ejemplo, la pulsación de un botón en el joystick de un jugador es un evento que debe ejecutar el código pertinente para que la acción tenga efecto en el juego.

El patrón *__'Reactor'__* se compone de **eventos**, **manejadores de eventos**, **recursos** y el **reactor**:

* **Eventos** - los eventos externos que pueden ocurrir sobre los recursos **(Handles)**. Normalmente su ocurrencia es asíncrona y siempre está relacionada a un recurso determinado.

* **Recursos (Handles)** - se refiere a los objetos sobre los que ocurren los eventos.

* **Manejadores de Eventos** - Asociados a los recursos y a los eventos que se producen en ellos, se encuentran los manejadores de eventos **(EventHandler)** que reciben una invocación a través del método **handle()** con la información del evento que se ha producido.

* **Reactor** - se trata de la clase que encapsula todo el comportamiento relativo a la desmultiplexación de los eventos en manejadores de eventos **(dispatching)**. Cuando ocurre cierto evento, se busca los manejadores asociados y se les invoca el método **handle()**.

![Concepto](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/others/reactor.png)

#### Implementación

```java
interface EventHandler {
    void handle(Event event);
}

class ConcreteEventHandler implements EventHandler {
    @Override
    public void handle(Event event) {
        event.getInfo();
    }
}

class Event {
    void getInfo() {
        System.out.println("Event occurs");
    }
}

public class Reactor {
    private static List<EventHandler> registeredHandlers = new ArrayList<>();

    private static void registerHandler(EventHandler eventHandler) {
        registeredHandlers.add(eventHandler);
    }

    public static void main(String[] args) {
        // Handler registration
        EventHandler eventHandler = new ConcreteEventHandler();
        registerHandler(eventHandler);
        while (true) {
            // Simulate event
            if (new Random().nextInt(10000000) == 50) {
                Event event = new Event();

                for (EventHandler handler : registeredHandlers) {
                    handler.handle(event);
                }
            }
        }
    }
}
```

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/other/reactor/example/diagram.png)

#### Comportamiento

1. Los manejadores se registran usando el método *'regHandler()'* del **reactor**. De esta forma, el Reactor puede configurarse para esperar los eventos del recurso que el manejador espera. El manejador puede dejar de recibir notificaciones con *'unregHandler()'*

1. A continuación, el **reactor** entra en el bucle infinito *'loop()'*, en el que se espera la ocurrencia de eventos.

1. Utilizando alguna llamada al sistema, como puede ser *'select()'*, el **reactor** espera a que se produzca algún evento sobre los recursos monitorizados.

1. Cuando ocurre, busca los manejadores asociados a ese recurso y les invoca el método *'handle()'* con el evento que ha ocurrido como parámetro.

1. El manejador recibe la invocación y ejecuta todo el código asociado al evento.

#### Consideraciones

Aunque los eventos puede ocurrir de forma concurrente, el **reactor** serializa las llamadas a los manejadores. Por lo tanto, la ejecución de los manejadores de eventos ocurre de forma **secuencial**

Para evitar que el sistema quede inoperable, los manejadores de eventos no pueden consumir mucho tiempo. En general, cuanto mayor sea la frecuencia en que ocurren los eventos, menos tiempo deben consumir los manejadores.

Desde un punto de vista general, el patrón *__'Reactor'__* tiene un comportamiento muy parecido al patrón *__'Observer'__*. Sin embargo, el patrón *__'Reactor'__* está pensado para las relaciones **1 a 1** mientras que en el caso del patrón *__'Observer'__* se producen relaciones **1 a n**.

#### Referencia

<https://es.wikipedia.org/wiki/Reactor_%28patr%C3%B3n_de_dise%C3%B1o%29>

### *__MVC__*

#### Concepto

El patrón *__'MVC'__* separa los datos y la lógica de negocio de una aplicación de la interfaz de usuario y el módulo encargado de gestionar los eventos y las comunicaciones.

Para ello el patrón *__'MVC'__* propone la construcción de tres componentes distintos que son el modelo, la vista y el controlador, es decir, por un lado define componentes para la representación de la información, y por otro lado para la interacción del usuario.

Este patrón de arquitectura de software se basa en las ideas de reutilización de código y la separación de conceptos, características que buscan facilitar la tarea de desarrollo de aplicaciones y su posterior mantenimiento.

#### Implementación

* **Vista** - se trata de la interfaz de usuario que interactúa con el usuario y recibe las órdenes (pulsar un botón, introducir texto, etc...). También recibe órdenes desde el controlador para mostrar información o realizar un cambio en la interfaz.

* **Controlador** - el controlador recibe órdenes utilizando, habitualmente, manejadores o *'callbacks'* y traduce esa acción al dominio del modelo de la aplicación. La acción puede ser crear una nueva instancia de un objeto determinado, actualizar estados, pedir operaciones al modelo, etc...

* **Modelo** - el modelo de la aplicación recibe las acciones a realizar por el usuario, pero ya independientes del tipo de interfaz utilizado porque se utilizan, únicamente, estructuras propias del dominio del modelo y llamadas desde el controlador.

![MVC](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/others/mvc.png)

Normalmente, la mayoría de las acciones que realiza el controlador sobre el modelo son operaciones de consulta de su estado para que pueda ser convenientemente representado por la vista.

El patrón *__'MVC'__* no es un patrón con una separación rígida. Es posible encontrar implementaciones en las que, por ejemplo, el modelo notifique directamente a las interfaces de forma asíncrona eventos producidos en sus estructuras y que deber ser representados en la vista (siempre y cuando exista una aceptable independencia entre capas). Para ello es de gran utilidad el patrón *__'Observer'__*.

El patrón *__'MVC'__* se utiliza en un gran número de entornos de ventanas y sobretodo en entornos web.

Sin embargo, es la estructura más utilizada en los videojuegos: la interfaz gráfica utilizando gráficos 2D/3D (vista), bucle de eventos (controlador) y las estructuras de datos internas (modelo).

#### Referencia

<https://es.wikipedia.org/wiki/Modelo%E2%80%93vista%E2%80%93controlador>

---

Versión en PDF: [Design_Patterns_Java.pdf](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/design-patterns-java.pdf)

## License

[![Licencia de Creative Commons](https://i.creativecommons.org/l/by-sa/4.0/80x15.png)](http://creativecommons.org/licenses/by-sa/4.0/)  
Esta obra está bajo una [licencia de Creative Commons Reconocimiento-Compartir Igual 4.0 Internacional](http://creativecommons.org/licenses/by-sa/4.0/).
