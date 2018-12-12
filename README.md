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

### - *__Strategy__* -

**GoF**: Defina una familia de algoritmos, encapsule cada uno de ellos y hágalos intercambiables. Este patrón permite que el algoritmo varíe independientemente de cliente a cliente.

#### Concepto

El patrón *__'Strategy'__* se utiliza para encapsular el funcionamiento de una familia de algoritmos, de forma que se pueda intercambiar su uso sin necesidad de modificar los clientes. Permite disponer de varios métodos para resolver un problema y elegir cuál utilizar en tiempo de ejecución.

En muchas ocasiones, se suele proporcionar diferentes algoritmos para realizar una misma tarea. Por ejemplo, el nivel de habilidad de un jugador viene determinado por diferentes algoritmos y heurísticas que determinan el grado de dificultad. Utilizando diferentes tipos algoritmos podemos obtener desde jugadores que realizan movimientos aleatorios hasta aquellos que pueden tener cierta inteligencia y que se basan en técnicas de IA.

Lo deseable sería poder tener jugadores de ambos tipos y que, desde el punto de vista del cliente, no fueran tipos distintos de jugadores. Simplemente se comportan diferente porque usan distintos algoritmos internamente, pero todos ellos son jugadores.

Otro ejemplo para entender este patrón es el de un protagonista de un videojuego en el cual manejamos a un soldado que puede portar y utilizar varias armas distintas. La clase (o clases) que representan a nuestro soldado no deberían de preocuparse de los detalles de las armas que porta: debería bastar, por ejemplo, con un método de interfaz "atacar" que dispare el arma actual y otro método "recargar" que inserte munición en ésta (si se diera el caso). En un momento dado, otro método "cambiarArma" podrá sustituir el objeto equipado por otro, manteniendo la interfaz intacta.

Da igual que nuestro soldado porte un rifle, una pistola o un fusil: los detalles de cada estrategia estarán encapsulados dentro de cada una de las clases intercambiables que representan las armas. Nuestra clase cliente (el soldado) únicamente debe preocuparse de las acciones comunes a todas ellas: atacar, recargar y cambiar de arma. Éste último método, de hecho, será el encargado de realizar la operación de "cambio de estrategia" que forma parte del patrón.

#### Implementación

Mediante el uso de la herencia, el patrón *__'Strategy'__* permite encapsular diferentes algoritmos para que los clientes puedan utilizarlos de forma transparente.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/behavioral/strategy.png)

La idea es extraer los métodos que conforman el comportamiento que puede ser intercambiado y encapsularlo en una familia de algoritmos. En este ejemplo, el movimiento del jugador se extrae para formar una jerarquía de diferentes movimientos. Todos ellos implementan el método *'move()'* que recibe un contexto que incluye toda la información necesaria para llevar a cabo el algoritmo.

Para el cliente todo se produce de forma transparente. Al configurarse cada jugador, ambos son del mismo tipo de cara al cliente aunque ambos se comportarán de forma diferente al invocar al método *'doBestMove()'*.

```java
interface Movement {
    void move();
}

class IAMovement implements Movement {
    @Override
    public void move() {
        System.out.println("IA Movement");
    }
}

class RandomMovement implements Movement {
    @Override
    public void move() {
        System.out.println("Random movement");
    }
}

class GamePlayer {
    private Movement movement;

    void setMovement(Movement movement) {
        this.movement = movement;
    }

    void doBestMove() {
        movement.move();
    }
}

public class Client {

    public static void main(String[] args) {
        GamePlayer player = new GamePlayer();

        Movement movement = new RandomMovement();
        player.setMovement(movement);

        player.doBestMove();
    }
}
```

#### Consideraciones

El patrón *__'Strategy'__* es una buena alternativa a realizar subclases en las entidades que deben comportarse de forma diferente en función del algoritmo utilizado. Al extraer la heurística a una familia de algoritmos externos, obtenemos los siguientes beneficios:

* Se aumenta la reutilización de dichos algoritmos.
* Se evitan sentencias condicionales para elegir el comportamiento deseado.
* Los clientes pueden elegir diferentes implementaciones para un mismo comportamiento deseado, lo que es útil para depuración y pruebas donde se pueden escoger implementaciones más simples y rápidas.

Este patrón es aconsejable, como ya hemos comentado, en situaciones en los que una misma operación (o conjunto de operaciones) puedan realizarse de formas distintas. A grosso modo, el patrón *__'Strategy'__* realiza una tarea bastante similar al patrón *__'Template Method'__*, salvo porque en este caso el algoritmo no tiene por qué contar con pasos en común y porque *__'Strategy'__* confía en la composición mientras que *__'Template Method'__* se basa en la herencia.

#### Referencia

<https://es.wikipedia.org/wiki/Strategy_%28patr%C3%B3n_de_dise%C3%B1o%29>  
<https://danielggarcia.wordpress.com/2014/05/12/patrones-de-comportamiento-iv-patron-strategy/>

### - *__Template Method__* -

**GoF**: Define el esqueleto de un algoritmo en una operación, aplazando algunos pasos a las subclases. El método de la plantilla permite subclases redefinir ciertos pasos de un algoritmo sin cambiar la estructura del algoritmo.

#### Concepto

El patrón *__'Template Method'__* define en una operación el esqueleto de un algoritmo, delegando en las subclases algunos de sus pasos. Esto permite que las subclases redefinan ciertos pasos de un algoritmo sin cambiar su estructura.

En un buen diseño los algoritmos complejos se dividen en funciones más pequeñas, de forma que si se llama a dichas funciones en un determinado orden se consigue implementar el algoritmo completo. Conforme se diseña cada paso concreto, se suele ir detectando funcionalidad común con otros algoritmos.

Por ejemplo, supongamos que tenemos dos tipos de jugadores de juegos de mesa: ajedrez y damas. En esencia, ambos juegan igual; lo que cambia son las reglas del juego que, obviamente, condiciona su estrategia y su forma de jugar concreta. Sin embargo, en ambos juegos, los jugadores mueven en su turno, esperan al rival y esto se repite hasta que acaba la partida.

El patrón *__'Template Method'__* consiste extraer este comportamiento común en una clase padre y definir en las clases hijas la funcionalidad concreta.

Si el patrón *__'Command'__* nos permite encapsular una invocación a un método, el patrón *__'Template Method'__* establece una forma de encapsular algoritmos. Este patrón se basa en un principio muy sencillo: si un algoritmo puede aplicarse a varios supuestos en los que únicamente cambie un pequeño número de operaciones, la idea será utilizar una clase para modelarlo a través de sus operaciones. Esta clase base se encargará de definir los pasos comunes del algoritmo, mientras que las clases que hereden de ella implementarán los detalles propios de cada caso concreto, es decir, el código específico para cada caso.

#### Implementación

* Se declara una clase abstracta, que será la plantilla o modelo. Esta clase definirá una serie de funciones y métodos. Aquellas que sean comunes estarán implementadas. Aquellas que dependan de cada caso concreto, se declararán como abstractas, obligando a las clases hijas a implementarlas.

* Cada clase derivada implementará los métodos específicos, acudiendo a la clase base para ejecutar el código común.

* La clase base también se encargará de la lógica del algoritmo, ejecutando los pasos en un orden preestablecido (las clases hijas no deberían poder modificar el algoritmo, únicamente definir la funcionalidad específica que tienen que implementar).

Dado que la clase padre es la que se encarga de llamar los métodos de las clases derivadas (los pasos del algoritmo estarán implementado en la clase base), se trata de una aplicación manifiesta del principio de **inversión de dependencias**: la clase base no tiene por qué saber nada acerca de sus hijas, pero aún así, se encargará de invocar su funcionalidad cuando sea necesario. El **principio de Hollywood** (“no nos llames, nosotros te llamaremos”) vuelve a entrar en escena.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/behavioral/template_method.png)

La clase *GamePlayer* es la que implementa el método *'play()'* que es el que invoca a los otros métodos que son implementados por las clases hijas. Este método es el **método plantilla**.

```java
abstract class GamePlayer {
    void play() {
        if (moveFirst()) {
            doBestMove();
        }

        while (!isOver()) {
            // Movimiento del rival
            //....

            if (!isOver()) {
                doBestMove();
            }
        }
    }

    abstract void doBestMove();

    abstract boolean moveFirst();

    abstract boolean isOver();
}

class ChessPlayer extends GamePlayer {
    private int movements = 0;

    @Override
    boolean moveFirst() {
        System.out.println("El rival mueve primero");
        return false;
    }

    @Override
    void doBestMove() {
        System.out.println("Moviendo ficha - Movimiento " + movements);
        movements++;
    }

    // Como convención para el ejemplo, la partida acaba al alcanzar 50 movimientos
    @Override
    boolean isOver() {
        if (movements < 50) {
            return false;
        } else {
            System.out.println("Fin de la partida - Alcanzado los " + movements + " como máximo");
            return true;
        }
    }
}

class CheckersPlayer extends GamePlayer {
    private int movements = 0;

    @Override
    void doBestMove() {
        System.out.println("Moviendo ficha - Movimiento " + movements);
        movements++;
    }

    @Override
    boolean moveFirst() {
        System.out.println("Movemos primero");
        return true;
    }

    // Como convención para el ejemplo, la partida acaba al alcanzar 25 movimientos
    @Override
    boolean isOver() {
        if (movements < 25) {
            return false;
        } else {
            System.out.println("Fin de la partida - Alcanzado los " + movements + " como máximo");
            return true;
        }
    }
}
```

#### Consideraciones

* Utilizando el patrón *__'Template Method'__* se suelen obtener estructuras altamente reutilizables. Esta reutilización de código es el objetivo primordial de este patrón. Es por ello que es ampliamente utilizado en bibliotecas de clases.

* Introduce el concepto de operaciones *'hook'* que, en caso de no estar implementadas en las clases hijas, tienen una implementación por defecto. Las clases hijas pueden sobreescribirlas para añadir su propia funcionalidad.

* Hay que minimizar el número de métodos abstractos (métodos sin cuerpo). De lo contrario, cada una de las subclases debe sobreescribirlos y el proceso global perderá la efectividad de este patrón de diseño.

#### Referencia

<https://es.wikipedia.org/wiki/Template_Method_%28patr%C3%B3n_de_dise%C3%B1o%29>  
<https://danielggarcia.wordpress.com/2014/05/05/patrones-de-comportamiento-iii-template-method/>

### - *__Visitor__* -

**GoF**: Representa una operación a realizar en los elementos de una estructura de objeto. Este patrón le permite definir una nueva operación sin cambiar las clases de los elementos sobre los que opera.

El patrón *__'Visitor'__* proporciona un mecanismo para realizar diferentes operaciones sobre una jerarquía de objetos de forma que añadir nuevas operaciones no haga necesario cambiar las clases de los objetos sobre los que se realizan las operaciones.

#### Concepto

En el diseño de un programa, normalmente se obtienen jerarquías de objetos a través de herencia o utilizando el patrón *__'Composite'__*. Considerando una jerarquía de objetos que sea más o menos estable, es muy probable que necesitemos realizar operaciones sobre dicha jerarquía. Sin embargo, puede ser que cada objeto deba ser tratado de una forma diferente en función de su tipo. La complejidad de estas operaciones aumenta muchísimo.

En el patrón *__'Visitor'__* se distinguen dos participantes:

* **Visitables**: son los elementos de la estructura de objetos que aceptan a un determinado visitante y que le proporcionan toda la información a éste para realizar una determinada operación. Definen una operación "Accept" que toma un visitante como argumento.

* **Visitantes:** jerarquía de objetos que realizan una operación determinada sobre dichos elementos.

![Concepto](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/behavioral/visitor.png)

Cada visitante concreto realiza una operación sobre la estructura de objetos. Es posible que al visitante no le interesen todos los objetos y, por lo tanto, la implementación de alguno de sus métodos sea vacía.

Sin embargo, lo importante del patrón *__'Visitor'__* es que se pueden añadir nuevos tipos de visitantes concretos y, por lo tanto, realizar nuevas operaciones sobre la estructura sin la necesidad de modificar nada en la propia estructura. Por tanto se seguiría el **principio 'Open/Closes' (abierto a la extensión, cerrado a la modificación).

#### Implementación

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/behavioral/visitor/example/diagram.png)

```java
interface Element {
    void accept(Visitor visitor);
}

class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }
}

class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }
}

interface Visitor {
    void visitElementA(Element element);
    void visitElementB(Element element);
}

class ConcreteVisitor1 implements Visitor {
    @Override
    public void visitElementA(Element element) {
        System.out.println("Visitando " + element.toString());
    }
    @Override
    public void visitElementB(Element element) {
        throw new UnsupportedOperationException();
    }
}

class ConcreteVisitor2 implements Visitor {
    @Override
    public void visitElementA(Element element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void visitElementB(Element element) {
        System.out.println("Visitando " + element.toString());
    }
}
```

#### Consideraciones

* El patrón *__'Visitor'__* es muy conveniente para recorrer estructuras arbóreas y realizar operaciones en base a los datos almacenados.

* La forma en que se recorra la estructura influirá notablemente en el rendimiento del análisis de la estructura. Se puede hacer uso del patrón *__'Iterator'__* para decidir cómo escoger el siguiente elemento.

* Uno de los problemas de este patrón es que no es recomendable si la estructura  de objetos cambia frecuentemente o es necesario añadir nuevos tipos de objetos de forma habitual. Cada nuevo objeto que sea susceptible de ser visitado puede provocar grandes cambios en la jerarquía de los visitantes.

#### Referencia

<https://es.wikipedia.org/wiki/Visitor_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Memento__* -

**GoF**: Sin violar la encapsulación, captura y externaliza el estado interno de un objeto para que el objeto pueda restaurarse a este estado más adelante.

#### Concepto

Es un patrón de diseño cuya finalidad es almacenar el estado de un objeto (o del sistema completo) en un momento dado de manera que se pueda restaurar en ese punto de manera sencilla. Para ello se mantiene almacenado el estado del objeto para un instante de tiempo en una clase independiente de aquella a la que pertenece el objeto (pero sin romper la encapsulación), de forma que ese recuerdo permita que el objeto sea modificado y pueda volver a su estado anterior.

Se usa este patrón cuando se quiere poder restaurar el sistema desde estados pasados y por otra parte, es usado cuando se desea facilitar el hacer y deshacer de determinadas operaciones, para lo que habrá que guardar los estados anteriores de los objetos sobre los que se opere (o bien recordar los cambios de forma incremental).

#### Implementación

El patrón *__'Memento'__* define tres roles principales:

* ***Originator***: La clase _'originator'_ puede producir instantáneas de su propio estado, así como restaurar su estado a partir de las instantáneas cuando sea necesario.

* ***Caretaker***: El _'caretaker'_ sabe no solo "cuándo" y "por qué" capturar el estado del originador, sino también cuándo debe restaurarse el estado. Puede realizar un seguimiento del historial del _'originator'_ almacenando una pila de _'mementos'_. Cuando el _'originator'_ tiene que retroceder en la historia, el _'caretaker'_ busca el recuerdo más alto de la pila y lo pasa al método de restauración del _'originator'_.

* ***Memento***: Es un objeto de valor que actúa como una instantánea del estado del _'originator'_. Es una práctica común hacer que el _'memento'_ sea inmutable y pasar los datos solo una vez, a través del constructor.

![Implementación](https://upload.wikimedia.org/wikipedia/commons/3/38/W3sDesign_Memento_Design_Pattern_UML.jpg)

La clase `'Originator'` implementa el método `'createMemento()'` que crea y devuelve un objeto `'Memento'` que almacena el estado interno actual del objeto _'originator'_ y el método `'restore(memento)'` que restaura el estado a partir del objeto _'memento'_ pasado como argumento.

Para guardar el estado original, la clase `'Caretaker'` invoca el método `'createMemento()'` que creará un objeto de tipo `'Memento'` con el estado actual y lo retornará al invocador que lo custodiará (sin alterar su estado ni acceder a él). Cuando sea necesario restaurar el estado anterior, el objeto `'Caretaker'`  invocará el método `'restore(memento)'` especificando el objeto `'Memento'` que guarda el estado que debe ser restaurado. El objeto _'originator'_ recupera el estado del método `'getState()'` del objeto `'Memento'`.  

```java
class Originator {
    private String state;
    // The class could also contain additional data that is not part of the
    // state saved in the memento..

    void set(String state) {
        this.state = state;
        System.out.println("Originator: Setting state to " + state);
    }

    Memento createMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(this.state);
    }

    void restore(Memento memento) {
        this.state = memento.getSavedState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }

    static class Memento {
        private final String state;

        Memento(String stateToSave) {
            state = stateToSave;
        }

        // accessible by outer class only
        private String getSavedState() {
            return state;
        }
    }
}

class Caretaker {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<>();

        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.createMemento());
        originator.set("State3");
        // We can request multiple mementos, and choose which one to roll back to.
        savedStates.add(originator.createMemento());
        originator.set("State4");

        originator.restore(savedStates.get(1));
    }
}
```

#### Consideraciones

* En un escenario real en que puede haber varios puntos de restauración o _'snapshots'_ del estado de un objeto en varias instancias de tiempo se puede emplear una estructura como un `'ArrayList'` o similares.

* Este patrón se utiliza cuando queremos implementar operaciones como _'undo'_ o _'rollback'_.

* Un número alto de puntos de restauración o _'snapshots'_ requiere espacio extra de almacenamiento.

* Este patrón se puede implementar utilizando la serialización, que es bastante común en Java. Si bien no es la única ni la forma más eficiente de hacer instantáneas del estado de un objeto, todavía permite almacenar copias de seguridad del estado mientras protege la estructura del _'originator'_ frente a otros objetos.

#### Referencia

<https://en.wikipedia.org/wiki/Memento_pattern>
<https://es.wikipedia.org/wiki/Memento_(patr%C3%B3n_de_dise%C3%B1o)>
<https://sourcemaking.com/design_patterns/memento>
<https://refactoring.guru/design-patterns/memento>

### - *__Mediator__* -

(todo)

* [Mediator](https://es.wikipedia.org/wiki/Mediator_(patr%C3%B3n_de_dise%C3%B1o)) - Este patrón define un objeto que encapsula cómo un conjunto de objetos interactúan

#### Concepto

#### Implementación

#### Consideraciones

#### Referencia

<>

### - *__Interpreter__* -

(todo)

* [Interpreter](https://es.wikipedia.org/wiki/Interpreter_(patr%C3%B3n_de_dise%C3%B1o)) - Es un patrón de diseño que, dado un lenguaje, define una representación para su gramática junto con un intérprete del lenguaje. Se usa para definir un lenguaje para representar expresiones regulares que representen cadenas a buscar dentro de otras cadenas. Además, en general, para definir un lenguaje que permita representar las distintas instancias de una familia de problemas.

#### Concepto

#### Implementación

#### Consideraciones

#### Referencia

<>

### - *__Chain of Responsibility__* -

(todo)

* [Chain of Responsibility](https://es.wikipedia.org/wiki/Cadena_de_responsabilidad) - Este patrón es un patrón de comportamiento que evita acoplar el emisor de una petición a su receptor dando a más de un objeto la posibilidad de responder a una petición. Para ello, se encadenan los receptores y pasa la petición a través de la cadena hasta que es procesada por algún objeto.

#### Concepto

#### Implementación

#### Consideraciones

#### Referencia

<>

## Creational Patterns

Los patrones creacionales corresponden a patrones de diseño de software que solucionan problemas de creación de instancias. Nos ayudan a encapsular y abstraer dicha creación.

Los patrones creacionales son _Abstract Factory_, _Builder_, _Factory Method_, _Prototype_ y _Singleton_.

### - *__Builder__* -

(todo)

* [Builder](https://es.wikipedia.org/wiki/Builder_(patr%C3%B3n_de_dise%C3%B1o)) - Este patrón es usado para permitir la creación de una variedad de objetos complejos desde un objeto fuente (Producto), el objeto fuente se compone de una variedad de partes que contribuyen individualmente a la creación de cada objeto complejo a través de un conjunto de llamadas a interfaces comunes de la clase Abstract Builder.

#### Concepto

#### Implementación

#### Consideraciones

#### Referencia

<>

### - *__Abstract Factory__* -

**GoF**: Proporciona una interfaz para crear familias de objetos relacionados o dependientes sin especificar sus clases concretas.

El patrón *__'Abstract Factory'__* permite crear diferentes tipos o familias de instancias, aislando al cliente sobre cómo se debe crear cada una de ellas.

#### Concepto

El patrón *__'Abstract Factory'__* recomienda crear las siguientes entidades:

* **Factoría abstracta** que defina una interfaz para que los clientes puedan crear los distintos tipos de objetos.
* **Factorías concretas** que realmente crean las instancias finales y que son hijas de la factoría abstracta.

El patrón *__'Abstract Factory'__* puede ser aplicable cuando:

* el sistema de creación de instancias debe aislarse.
* es necesaria la creación de varias instancias de objetos para tener el sistema configurado.
* cuando la creación de instancias implican la imposición de restricciones u otras particularidades propias de los objetos que se construyen.
* los objetos que deben construirse en las factorías no cambian excesivamente en el tiempo.

Añadir nuevos tipos implica cambiar todas las factorías. Por ello, se recomienda aplicar este patrón sobre diseños con un cierto grado de estabilidad.

Un ejemplo de uso de este patrón podría ser las interfaces gráficas o UI. Las bibliotecas para crear interfaces gráficas suelen utilizar este patrón y cada familia sería un SO distinto. Así pues, el usuario declara un elemento como podría ser un _Button_ pero de forma más interna lo que está creando es un _WindowsButton_ o un _LinuxButton_ según el SO, siendo transparente para el cliente o usuario.

Otro ejemplo podría ser la jerarquía de objetos existentes en cualquier juego.

![Ejemplo](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/creational/abstract_factory_01.png)

En ella, se muestra jerarquías de clases que modelan los diferentes tipos de personajes de un juego y algunas de sus armas. Para construir cada tipo de personaje es necesario saber cómo construirlo y con qué otro tipo de objetos tiene relación. Por ejemplo, restricciones del tipo "la gente del pueblo no puede llevar armas" o "los arqueros sólo pueden puede tener un arco", es conocimiento específico de la clase que se está construyendo.

#### Implementación

En primer lugar se define una factoría abstracta que será la que utilice el cliente *(Game)* para crear los diferentes objetos. _'CharFactory'_ es una factoría que sólo define métodos abstractos y que serán implementados por sus clases hijas.

Éstas son factorías concretas de cada tipo de raza ( *'ManFactory'* y *'OrcFactory'* ) y ellas son las que crean las instancias concretas de objetos *'Archer'* y *'Rider'* para cada una de las razas.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/creational/abstract_factory_02.png)

El patrón *__'Abstract Factory'__* es de ayuda en este tipo de situaciones en las que es necesario crear diferentes tipos de objetos utilizando una jerarquía de componentes. Dada la complejidad que puede llegar a tener la creación de una instancia es deseable aislar la forma en que se construye cada clase de objeto.

```java
// Jerarquía de tipos
abstract class Soldier {
    String name;
    int life;

    abstract int shotsPerSecond();
}

class Rider extends Soldier {
    Rider(String name, int life) {
        this.name = name;
        this.life = life;
    }

    @Override
    public int shotsPerSecond() {
        return 5;
    }
}

class Archer extends Soldier {
    Archer(String name, int life) {
        this.name = name;
        this.life = life;
    }

    @Override
    public int shotsPerSecond() {
        return 2;
    }
}

// Factoría abstracta
interface SoldierFactory {
    Archer makeArcher();
    Rider makeRider();
}

// Factoría concreta
class OrcFactory implements SoldierFactory {
    @Override
    public Archer makeArcher() {
        return new Archer("Orc Archer", 200);
    }
    @Override
    public Rider makeRider() {
        return new Rider("Orc Rider", 250);
    }
}

// Factoría concreta
class ManFactory implements SoldierFactory {
    @Override
    public Archer makeArcher() {
        return new Archer("Man Archer", 100);
    }

    @Override
    public Rider makeRider() {
        return new Rider("Man Rider", 150);
    }
}
```

#### Consideraciones

* Utilizamos este patrón cuando a nuestro sistema no le importa cómo se crearán o compondrán sus productos.

* Usamos este patrón cuando necesitamos tratar con varias _factories_.

* Este patrón separa las clases concretas y facilita el intercambio de productos. También puede mejorar la fiabilidad entre los productos. Pero, al mismo tiempo, debemos reconocer el hecho de que crear un nuevo producto es difícil con este patrón (porque necesitamos extender la interfaz y, como resultado, se requerirán cambios en todas las subclases que ya implementaron la interfaz).

#### Referencia

<https://es.wikipedia.org/wiki/Abstract_Factory>

### - *__Factory Method__* -

**GoF**: Defina una interfaz para crear un objeto, pero deje que las subclases decidan qué clase instanciar. Este patrón permite que una clase difiera la creación de instancias a subclases.

#### Concepto

El patrón *__'Factory Method'__* centraliza en una clase constructora la creación de objetos de un subtipo de un tipo determinado, ocultando al usuario la diversidad de casos particulares que se pueden preveer en la elección del subtipo.

Al igual que ocurre con el patrón *__'Abstract Factory'__* el problema que se pretende resolver es la creación de diferentes instancias de objetos abstrayendo la forma en que realmente se crean.

En el patrón *__'Factory Method'__* se utiliza una clase constructora abstracta con métodos definidos y otro(s) abstracto(s) dedicado(s) a la construcción de objetos de un subtipo de un tipo determinado. Es una simplificación del patrón *__'Abstract Factory'__* en la que la clase abstracta tiene métodos concretos.

A diferencia del patrón *__'Abstract Factory'__* no es necesario tener una factoría o una jerarquía de factorías para la creación de objetos. Permite diseños más adaptados a la realidad.

#### Implementación

Las clases principales de este patrón son el **creador** y el **producto**. El creador necesita crear instancias de productos, pero el tipo concreto de producto no debe ser forzado en las subclases del creador porque las posibles subclases del creador deber poder especificar subclases del producto para utilizar.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/creational/factory_method.png)

La solución para esto es hacer un método abstracto (el método de la fábrica) que se define en el creador. Este método abstracto se define para que devuelva un producto. Las subclases del creador pueden sobreescribir este método para devolver subclases apropiadas del producto.

```java
interface Product {
    void operacion();
}

class ConcreteProductA implements Product {
    @Override
    public void operacion() {
        System.out.println("ConcreteProductA");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void operacion() {
        System.out.println("ConcreteProductB");
    }
}

abstract class Creator {
    abstract Product factoryMethod();
}

class ConcreteCreatorA extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProductB();
    }
}
```

#### Consideraciones

* Este patrón es útil cuando las clases delegan las responsabilidades de la creación de objetos a sus subclases.

* Este patrón también es útil cuando se implementan jerarquías de clases paralelas (cuando algunas de las responsabilidades cambian de una clase a otra) y cuando es posible crear un sistema con acoplamiento débil.

#### Referencia

<https://es.wikipedia.org/wiki/Factory_Method_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Prototype__* -

**GoF**: Especifique los tipos de objetos para crear utilizando una instancia prototípica y cree nuevos objetos copiando este prototipo.

#### Concepto

El patrón *__'Prototype'__* proporciona abstracción a la hora de crear diferentes objetos en un contexto donde se desconoce cúantos y cuáles deben ser creados a priori. La idea principal es que los objetos deben poder clonarse o copiarse en tiempo de ejecución. Por tanto, este patrón tiene como finalidad crear nuevos objetos duplicándolos, clonando una instancia creada previamente. Dado que crear una nueva instancia normalmente suele ser una operación costosa, este patrón ayuda a lidiar con ese problema.

Los patrones *__'Factory Method'__* y *__'Abstract Factory'__* tiene el problema de que se basan en la herencia e implementación de métodos abstractos por subclases para definir cómo se construye cada producto concreto. Para sistemas donde el número de productos concretos puede ser elevado o indeterminado esto puede ser un problema.

La clase de los objetos que servirán de prototipo para la copia deberán incluir en su interfaz la manera de solicitar esa copia, que será desarrollada luego por las clases concretas de prototipos.

Este patrón se utiliza en casos como:

* Evitar las subclases de un objeto creador como hace el patrón *__'Abstract Factory'__*
* Evitar el costo inherente a la creación de un objeto nuevo mediante el operador **new** cuando esto es demasiado costoso para la aplicación.
* La decisión del tipo de objeto necesario se decide en tiempo de ejecución en función de determinados parámetros, configuraciones o condiciones en un momento dado.

Este patrón, dicho de otro modo, propone la creación de distintas variantes de objetos que la aplicación necesite en el momento y contexto adecuados. Toda la lógica necesaria para la decisión sobre el tipo de objetos que usará la aplicación es su ejecución se hace independiente, de manera que el código que utiliza estos objetos solicitará una copia del objeto que necesite. En este contexto, una copia significa otra instancia del objeto. El único requisito que debe cumplir este objeto es suministrar la funcionalidad de clonarse.

#### Implementación

Para implementar este patrón se declara una clase base abstracta que tiene un método `clone()`. Cualquier clase que necesite un constructor deriva de la clase abstracta e implementa el método `clone()`.

![Concepto](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/creational/prototype.png)

El cliente, en vez de escribir código que hace uso del generador `'new'` sobre una clase específica, llama al método `clone()` de la clase prototipo, o llama a un método factoría con un parámetro que especifíca la clase deseada, o invoca el método `clone()` de la clase de alguna otra forma.

Por ejemplo, es posible usar un **gestor de prototipos** que permita cargar y descargar los prototipos disponibles en tiempo de ejecución.

Aunque en un principio este patrón parece que entra en conflicto con *__'Abstract Factory'__* es posible utilizar ambas aproximaciones en una *__'Prototype Abstract Factory'__* de forma que la factoría se configura con los prototipos concretos que puede crear y ésta sólo invoca al método `clone()`.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/src/patterns/creational/prototype/example/diagram.png)

```java
interface Producto {
    Producto copy();
}

class ProductoA implements Producto {
    private String name = "ProductoA";

    @Override
    public Producto copy() {
        return new ProductoA();
    }

    @Override
    public String toString() {
        return name;
    }
}

// Factoría que crea y copia los objetos
class FactoriaPrototipo {
    private Producto productoA;

    FactoriaPrototipo() {
        productoA = new ProductoA();
    }

    Producto create() {
        return productoA.copy();
    }
}
```

#### Consideraciones

* Este patrón es útil para implementar *plugins* o cuando se cargan en tiempo de ejecución liberías dinámicas.

* Cuando el sistema no se preocupa por el mecanismo de creación de los productos, este patrón es muy útil.

* Podemos usar este patrón cuando necesitamos instanciar clases en tiempo de ejecución.

* Una de las ventajas de este patrón es que ayuda a crear nuevas instancias con un coste bajo.

* Por el contrario, una de las desventajas es que cada subclase tiene que implementar el mecanismo de clonación. Implementar el mecanismo de clonación puede ser un desafío si los objetos en consideración no admiten la copia o si hay algún tipo de referencia circular.

#### Referencia

<https://es.wikipedia.org/wiki/Prototype_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Singleton__* -

**GoF**: Asegúrese de que una clase solo tenga una instancia y proporcione un punto de acceso global a ella.

#### Concepto

El patrón *__'Singleton'__* garantiza la existencia de una única instancia para una clase y la creación de un mecanismo de acceso global a dicha instancia. Restringe la instanciación de una clase o valor de un tipo a un solo objeto.

En Java, los objetos normalmente se crean con el operador `'new'`. Sin embargo, es posible que en un determinado momento sea necesario que sólo exista una instancia de una clase concreta (prevención de errores, seguridad, creación costosa, etc..).

Para garantizar que sólo existe una instancia de una clase es necesario que los clientes no puedan acceder directamente al constructor. Por ello, cuando se aplica el patrón *__'Singleton'__* el constructor es, por lo menos, `'protected'` o inferior. A cambio se debe proporcionar un único punto controlado por el cual se pide la instancia única.

La instrumentación del patrón puede ser delicada en programas con múltiples hilos de ejecución. Si dos hilos de ejecución intentan crear la instancia al mismo tiempo y esta no existe todavía, sólo uno de ellos debe lograr crear el objeto.

El patrón *__'Singleton'__* puede ser utilizado para modelar:

* Gestores de acceso a base de datos, sistemas de ficheros, _render_ de gráficos, etc..
* Estructuras que representan la configuración del programa para que sea accesible por todos los elementos en  cualquier instante.

#### Implementación

El patrón *_'Singleton'__* provee una única instancia global gracias a que:

* La propia clase es responsable de crear la única instancia.
* Permite el acceso global a dicha instancia mediante un método de clase.
* Declara el contructor de clase como privado para que no sea instanciable directamente.

En este ejemplo, primero hemos hecho que el constructor sea privado, de modo que no podemos crear instancias de manera normal. Además, al proporcionar un constructor privado, evitamos que el compilador genere un constructor por defecto. Cuando intentamos crear una instancia de la clase, estamos comprobando si ya tenemos una copia disponible. Si no tenemos una copia de ese tipo, la crearemos; de lo contrario, simplemente reutilizaremos la copia existente.

La inicialización de la instancia se denomina _'lazy initialization'_ ya que la instancia no se crea hasta que el método `'getINSTANCE()'` se invoca.

```java
public class Singleton {
    private static Singleton INSTANCE = null;

    // Constructor privado
    private Singleton() {}

    // Lazy initialization
    public static Singleton getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}

// Modo 'Lazy initialization'
public class SingletonSyncronized {
    private static SingletonSyncronized INSTANCE = null;

    // Constructor privado
    private SingletonSyncronized() {}

    // Creador sincronizado para protegerse de posibles problemas multi-hilo
    private static synchronized void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonSyncronized();
        }
    }

    public static SingletonSyncronized getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }
}

// Modo 'Early Initialization'
public class Singleton {

    // Early initialization
    private static Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

#### Consideraciones

El patrón *__'Singleton'__* es un caso particular de un patrón de diseño más general llamado *__'Object Pool'__*, que permite crear **n instancias de objetos de forma controlada**.

#### Referencia

<https://es.wikipedia.org/wiki/Singleton>

## Structural Patterns

Los patrones estructurales son los patrones de diseño software que solucionan problemas de composición (agregación) de clases y objetos.

Los patrones estructurales son _Adapter_, _Bridge_, _Composite_, _Decorator_, _Facade_, _Flyweight_ y _Proxy_.

### - *__Bridge__* -

(todo)

* [Bridge](https://es.wikipedia.org/wiki/Bridge_(patr%C3%B3n_de_dise%C3%B1o)) - Este patrón es una técnica usada en programación para desacoplar una abstracción de su implementación, de manera que ambas puedan ser modificadas independientemente sin necesidad de alterar por ello la otra. Esto es, se desacopla una abstracción de su implementación para que puedan variar independientemente.

#### Concepto

#### Implementación

#### Consideraciones

#### Referencia

<>

### - *__Flyweight__* -

(todo)

* [Flyweight](https://es.wikipedia.org/wiki/Flyweight_(patr%C3%B3n_de_dise%C3%B1o)) - El patrón Flyweight (u objeto ligero) sirve para eliminar o reducir la redundancia cuando tenemos gran cantidad de objetos que contienen información idéntica, además de lograr un equilibrio entre flexibilidad y rendimiento (uso de recursos).

#### Concepto

#### Implementación

#### Consideraciones

#### Referencia

<>

### - *__Adapter__* -

**GoF**: Convierte la interfaz de una clase en otra interfaz que los clientes esperan. Este patrón permite que las clases trabajen juntas que de otra manera no podrían hacerlo debido a interfaces incompatibles.

#### Concepto

El patrón *__'Adapter'__*, también conocido como *_'Wrapper'_* (envoltorio), se utiliza para proporcionar una interfaz que, por un lado, cumpla con las demandas de los clientes y, por otra, haga compatible otra interfaz que, a priori, no lo es. Dicho de otra forma, se utiliza para transformar una interfaz en otra, de tal modo que una clase que no pudiera utilizar la primera, haga uso de ella a través de la segunda.

Conforme avanza la construcción de una aplicación, el diseño de las interfaces que ofrecen los componentes pueden no ser las adecuadas o, al menos, las esperadas por los usuarios de los mismos.

Una solución rápida podría ser adaptar dichas interfaces a las necesidades de la aplicación. Sin embargo, esto no siempre es posible debido a que no se pueda modificar el código porque sea un requisito funcional, sea una biblioteca de terceros, etc...

Usando el patrón *__'Adapter'__* es posible crear una nueva interfaz de acceso a un determinado objeto, por lo que proporciona un mecanismo de **adaptación** entre las demandas del objeto cliente y el objeto servidor que proporciona la funcionalidad.

#### Implementación

El cliente no utiliza el sistema adaptado, si no que hace uso del *adaptador*. Este es el que transforma la invocación a `'method()'` en `'otherMethod()'`.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/structural/adapter.png)

Es posible que el adaptador también incluya nueva funcionalidad relacionada con la adaptación como por ejemplo:

* Comprobación de la corrección de los parámetros.

* Transformación de los parámetros para ser compatibles con el sistema adaptado.

```java
interface Target {
    String method();
}

class Adapter implements Target {
    @Override
    public String method() {
        OtherSystem otherSystem = new OtherSystem();
        return otherSystem.otherMethod();
    }
}

class OtherSystem {
    String otherMethod() {
        return OtherSystem.class.getSimpleName();
    }
}

public class Client {
    public static void main(String[] args) {
        Target target = new patterns.structural.adapter.example.Adapter();
        System.out.println("Método adaptado: " + target.method());
    }
}
```

#### Consideraciones

* Tener sistemas muy reutilizables puede hacer que las interfaces no puedan ser compatibles con una interfaz en común. En ese caso el patrón *__'Adapter'__* es una buena solución.

* Un mismo adaptador puede usarse en varios sistemas.

* Este patrón se parece al patrón *__'Decorator'__*. Sin embargo, difieren en que la finalidad de éste es proporcionar una interfaz completa del objeto adaptador, mientras que el decorador pueden centrarse en una sola parte.

#### Referencia

<https://es.wikipedia.org/wiki/Adapter_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Decorator__* -

**GoF**: Asignar responsabilidades adicionales a un objeto de forma dinámica. Los decoradores ofrecen una alternativa flexible a la subclasificación para ampliar la funcionalidad.

#### Concepto

El patrón *__'Decorator'__* sirve para añadir y/o modificar la responsabilidad, funcionalidad o propiedades de un objeto en tiempo de ejecución. Permite organizar el diseño de forma que la incorporación de nueva funcionalidad en tiempo de ejecución sea transparente desde el punto de vista del usuario de la **clase decorada**.

Este patrón permite tener una jerarquía de clases compuestas, formando una estructura más dinámica y flexible que la herencia estática. Al utilizar este patrón, se pueden añadir y eliminar responsabilidades en tiempo de ejecución. Además, evita la utilización de la herencia con muchas clases y también, la herencia múltiple (si fuera posible en el lenguaje utilizado).

#### Implementación

Supongamos que el personaje de un videojuego porta un arma que utiliza para eliminar a sus enemigos. Dicha arma, por ser de un tipo determinado, tiene una serie de propiedades como podrían ser "radio de acción", "número de balas", etc.. Sin embargo, es posible que el personaje incorpore elementos al arma que pueden cambiar estas propiedades como un silenciador o un cargador extra.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/structural/decorator.png)

Básicamente, los diferentes tipos de armas de fuego implementan una clase abstracta llamada *'Firearm'*. Una de sus subclases es *'FirearmDecorator'* que a su vez es la superclase de todos los componentes que _"decoran"_ a un objeto *'Firearm'*. Nótese que este decorador implementa la interfaz propuesta por *'Firearm'* y está compuesto por un objeto *'gun'*, el cual decora.

```java
class Firearm {
    private static final int MAX_BULLETS = 5;
    private static final float GENERIC_NOISE = 150.0f;

    float noise() {
        return GENERIC_NOISE;
    }

    int bullets() {
        return MAX_BULLETS;
    }
}

class Rifle extends Firearm {
    @Override
    float noise() {
        return super.noise();
    }

    @Override
    int bullets() {
        return super.bullets();
    }
}

class FirearmDecorator extends Firearm {
    private Firearm gun;

    FirearmDecorator(Firearm gun) {
        this.gun = gun;
    }

    @Override
    float noise() {
        return gun.noise();
    }

    @Override
    int bullets() {
        return gun.bullets();
    }
}

class Silencer extends FirearmDecorator {
    Silencer(Firearm gun) {
        super(gun);
    }

    @Override
    float noise() {
        return super.noise() - 55;
    }

    @Override
    int bullets() {
        return super.bullets();
    }
}

class Magazine extends FirearmDecorator {
    Magazine(Firearm gun) {
        super(gun);
    }

    @Override
    float noise() {
        return super.noise();
    }

    @Override
    int bullets() {
        return super.bullets() + 5;
    }
}
```

#### Consideraciones

* El patrón *__'Decorator'__* está más centrado en la extensión de la funcionalidad que en la composición de objetos para la generación de una jerarquía como ocurre con el patrón *__'Composite'__*.

* Normalmente, sólo existe una objeto decorado y no un vector de objetos (aunque también es posible).

* Este patrón puede generar gran cantidad de objetos pequeños y parecidos que dificulta su identificación.

* Este patrón se diferencia de la simple herencia en que podemos añadir o quitar responsabilidades simplemente adjuntando o quitando decoradores. Pero únicamente con la herencia, necesitamos crear una nueva clase para nuevas responsabilidades. Por lo tanto, habrá muchas clases dentro del sistema, lo que a su vez puede hacer que el sistema sea complejo.

#### Referencia

<https://es.wikipedia.org/wiki/Decorator_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Composite__* -

**GoF**: Componer objetos en estructuras de árbol para representar jerarquías parciales. Este patrón permite a los clientes tratar objetos individuales y composiciones de objetos de manera uniforme.

#### Concepto

El patrón *__'Composite'__* sirve para construir objetos complejos a partir de otros más simples y similares entre sí gracias a la composición recursiva y a una estructura en forma de árbol.

Esto simplifica el tratamiento de los objetos creados ya que al poseer todos ellos una interfaz común, se tratan todos de la misma manera. Un cliente puede tratar un objeto compuesto como si fuera un solo objeto.

Una buena manera de identificar la situación en que se puede aplicar este patrón es cuando tengo "un X y tiene varios objetos X".

#### Implementación

Para ilustrar el problema supóngase un juego de estrategia en el que los jugadores pueden recoger objetos o items, los cuales tienen una serie de propiedades como "precio", "descripción", etc. Cada item, a su vez, puede contener otros items. Por ejemplo, un bolso de cuero puede contener una pequeña caja de madera que, a su vez, contiene un pequeño reloj dorado, etc..

![Ejemplo](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/structural/composite.png)

En definitiva, el patrón *__'Composite'__* habla sobre cómo diseñar estructuras recursivas donde la composición homogénea de objetos recuerda a una estructura arbórea.

Naturalmente, los objetos compuestos suelen ofrecer también operaciones para añadir, eliminar y actualizar.

```java
class Item {
    void value() {
        // ...
    }

    void description() {
        // ...
    }
}

class Clock extends Item {
    @Override
    void value() {
        super.value();
    }

    @Override
    void description() {
        super.description();
    }
}

class Bag extends Item {
    private List<Item> bag = new ArrayList<>();

    void addItem(Item item) {
        bag.add(item);
    }

    boolean removeItem(Item item) {
        return bag.contains(item) && bag.remove(item);
    }
}
```

#### Consideraciones

* Los clientes pueden añadir nuevos tipos de componentes fácilmente.

#### Referencia

<https://es.wikipedia.org/wiki/Composite_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Facade__* -

**GoF**:  Proporcionar una interfaz unificada a un conjunto de interfaces en un sistema. Este patrón define una interfaz de nivel superior que facilita el uso del subsistema.

#### Concepto

El patrón *__'Facade'__* eleva el nivel de abstracción de un determinado sistema para ocultar ciertos detalles de implementación y hacer más sencillo su uso.

Este patrón se aplica para proveer de una interfaz unificada simple que permita acceder a una interfaz o grupo de interfaces de un sistema complejo o cuando se quiera estructurar varios subsistemas en capas ya que las fachadas serían el punto de entrada a cada nivel.

Otro escenario proclive para su aplicación surge de la necesidad de desacoplar un sistema de sus clientes y de otros subsistemas, haciéndolo más independiente, portable y reutilizable.

También es útil cuando haya que controlar el acceso y la forma en que se utiliza un sistema determinado.

Este patrón se relaciona con el patrón *__'Singleton'__** ya que normalmente las fachadas suelen ser instancias únicas.

#### Implementación

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/structural/facade.png)

* **Fachada** - conoce qué clases del subsistema son responsables de una determinada peticíón y delega esas peticiones de los clientes a los objetos apropiados del subsistema. Los clientes no acceden directamente a las subclases.

* **Subclases** (ModuleA, ModuleB, ModuleC...) - implementan la funcionalidad del subsistema. Realizan el trabajo solicitado por la fachada. No conocen la existencia de la fachada.

```java
class ModuleA {
    String getInfo() {
        return ModuleA.class.getSimpleName();
    }
}

class ModuleB {
    String getInfo() {
        return ModuleB.class.getSimpleName();
    }
}

class ModuleC {
    String getInfo() {
        return ModuleC.class.getSimpleName();
    }
}

class Facade {
    private ModuleA moduleA;
    private ModuleB moduleB;
    private ModuleC moduleC;

    Facade() {
        moduleA = new ModuleA();
        moduleB = new ModuleB();
        moduleC = new ModuleC();
    }

    String getInfoA() {
        return moduleA.getInfo();
    }

    String getInfoB() {
        return moduleB.getInfo();
    }

    String getInfoC() {
        return moduleC.getInfo();
    }
}
```

#### Consideraciones

* La principal ventaja al utilizar este patrón consiste en que para modificar las clases del subsistema sólo hay que realizar los cambios en la interfaz/fachada. Los clientes pueden permanecer ajenos a ello. Esto permite el desacople de los clientes y eleva el nivel de abstracción.

* Un problema derivado del uso de este patrón es que si no se dividen correctamente las responsabilidades se crean clases fachada con un tamaño desproporcionado al incluir demasiada funcionalidad.

#### Referencia

<https://es.wikipedia.org/wiki/Facade_%28patr%C3%B3n_de_dise%C3%B1o%29>

### - *__Proxy__* -

**GoF**: Proporcione un sustituto o marcador de posición para que otro objeto controle el acceso a él.

#### Concepto

El patrón *__'Proxy'__* tiene como propósito proporcionar un sustituto o intermediario de un objeto para controlar su acceso. Proporciona mecanismos de abstracción y control para acceder a un determinado objeto "simulando" que se trata del objeto real.

Muchos de los objetos que pueden integrar una aplicación pueden representar diferentes problemas a la hora de ser utilizados por la aplicación:

* **Coste computacional** - Es posible que un objeto sea costoso de manipular y cargar.

* **Acceso remoto** - el acceso por red es un componente cada vez más común.

* **Acceso seguro** - es posible que para usar determinados objetos se necesiten determinados privilegios.

* **Dobles de prueba** - a la hora de diseñar y probar el código se necesitan objetos *"dobles"* que simulen a los objetos reales.

#### Implementación

El coste de manipular y cargar una imagen puede ser importante según el sistema, tipo de manipulación, etc...Con el patrón *__'Proxy'__* se crea un objeto intermedio `'ImageProxy'` que represente al objeto real `'Image'` y que se utilice de la misma forma desde el punto de vista del cliente.

De esta forma, el objeto `'proxy'` puede cargar una única vez la imagen y mostrarla tantas veces como el cliente lo solicite.

![Implementación](https://raw.githubusercontent.com/alxgcrz/design-patterns-java/master/media/patterns/structural/proxy.png)

```java
class Graphic {
    String display() {
        return "Graphic";
    }
}

class Image extends Graphic {
    @Override
    String display() {
        return "Display image";
    }

    void load() {
        // ...
    }
}

class ImageProxy extends Graphic {
    private Image image;

    @Override
    String display() {
        if (image == null) {
            image = new Image();
            image.load();
        }
        return image.display();
    }
}
```

#### Consideraciones

* En los sistemas de autenticación, dependiendo de las credenciales presentadas por el cliente, se devuelve un proxy u otro que permiten realizar distintos tipos de operaciones, acceder a determinados recursos, etc...

#### Referencia

<https://es.wikipedia.org/wiki/Proxy_%28patr%C3%B3n_de_dise%C3%B1o%29>

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
