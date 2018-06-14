# Design Patterns with Java

Los patrones de diseño son unas técnicas para resolver problemas comunes en el desarrollo de software y otros ámbitos referentes al diseño de interacción o interfaces.

## Creational Patterns

* [Singleton](https://es.wikipedia.org/wiki/Singleton) - garantiza la existencia de una única instancia para una clase y la creación de un mecanismo de acceso global a dicha instancia. Restringe la instanciación de una clase o valor de un tipo a un solo objeto.

* [Abstract Factory](https://es.wikipedia.org/wiki/Abstract_Factory) - permite trabajar con objetos de distintas familias de manera que las familias no se mezclen entre sí y haciendo transparente el tipo de familia concreta que se esté usando.

* [Factory Method](https://es.wikipedia.org/wiki/Factory_Method_%28patr%C3%B3n_de_dise%C3%B1o%29) - consiste en utilizar una clase constructora (al estilo del Abstract Factory) abstracta con unos cuantos métodos definidos y otro(s) abstracto(s): el dedicado a la construcción de objetos de un subtipo de un tipo determinado.

* [Prototype](https://es.wikipedia.org/wiki/Prototype_%28patr%C3%B3n_de_dise%C3%B1o%29) -  crea nuevos objetos clonándolos de una instancia ya existente.

## Structural Patterns

* [Composite](https://es.wikipedia.org/wiki/Composite_%28patr%C3%B3n_de_dise%C3%B1o%29) - sirve para construir objetos complejos a partir de otros más simples y similares entre sí, gracias a la composición recursiva y a una estructura en forma de árbol.

* [Decorator](https://es.wikipedia.org/wiki/Decorator_%28patr%C3%B3n_de_dise%C3%B1o%29) - Añade funcionalidad a una clase dinámicamente.

* [Facade](https://es.wikipedia.org/wiki/Facade_%28patr%C3%B3n_de_dise%C3%B1o%29) - Provee de una interfaz unificada simple para acceder a una interfaz o grupo de interfaces de un sistema.

* [MVC](https://es.wikipedia.org/wiki/Modelo%E2%80%93vista%E2%80%93controlador) - Separa los datos y la lógica de negocio de una aplicación de la interfaz de usuario y el módulo encargado de gestionar los eventos y las comunicaciones.

* [Adapter](https://es.wikipedia.org/wiki/Adapter_%28patr%C3%B3n_de_dise%C3%B1o%29) - Este patrón se utiliza para proporcionar una interfaz que, por un lado, cumpla con las demandas de los clientes y, por otra, haga compatible otra interfaz que, a priori, no lo es.

* [Proxy](https://es.wikipedia.org/wiki/Proxy_%28patr%C3%B3n_de_dise%C3%B1o%29) - Proporciona mecanismos de abstracción y control para acceder a un determinado objeto "simulando" que se trata del objeto real.

## Behavioral Patterns

* [Observer](https://es.wikipedia.org/wiki/Observer_%28patr%C3%B3n_de_dise%C3%B1o%29) - Se utiliza para definir relaciones 1 a *n* de forma que un objeto pueda notificar y/o actualizar el estado de otros automáticamente.

* [State](https://es.wikipedia.org/wiki/State_%28patr%C3%B3n_de_dise%C3%B1o%29) - Permite que un objeto modifique su comportamiento cada vez que cambie su estado interno.

* [Iterator](https://es.wikipedia.org/wiki/Iterador_%28patr%C3%B3n_de_dise%C3%B1o%29) - Permite realizar recorridos sobre objetos compuestos independientemente de la implementación de éstos.

* [Template Method](https://es.wikipedia.org/wiki/Template_Method_%28patr%C3%B3n_de_dise%C3%B1o%29) - Se puede utilizar cuando es necesario redefinir algunos pasos de un determinado algoritmo utilizando herencia.

* [Strategy](https://es.wikipedia.org/wiki/Strategy_%28patr%C3%B3n_de_dise%C3%B1o%29) - Se utiliza para encapsular el funcionamiento de una familia de algoritmos, de forma que se pueda intercambiar su uso sin necesidad de modificar los clientes.

* [Reactor](https://es.wikipedia.org/wiki/Reactor_%28patr%C3%B3n_de_dise%C3%B1o%29) - Es un patrón de programación concurrente para manejar los pedidos de servicio entregados de forma concurrente a un manejador de servicio desde una o más entradas. El manejador de servicio demultiplexa los pedidos entrantes y los entrega de forma sincrónica a los manejadores de pedidos asociados.

* [Visitor](https://es.wikipedia.org/wiki/Visitor_%28patr%C3%B3n_de_dise%C3%B1o%29) - Proporciona un mecanismo para realizar diferentes operaciones sobre una jerarquía de objetos de forma que añadir nuevas operaciones no haga necesario cambiar las clases de los objetos sobre los que se realizan las operaciones.

* [Command](https://es.wikipedia.org/wiki/Command_%28patr%C3%B3n_de_dise%C3%B1o%29) - Este patrón permite solicitar una operación a un objeto sin conocer realmente el contenido de esta operación, ni el receptor real de la misma. Para ello se encapsula la petición como un objeto, con lo que además facilita la parametrización de los métodos.

## Principios SOLID

* [Principio de Responsabilidad Única (Single responsability principle - SRP)](https://es.wikipedia.org/wiki/Principio_de_responsabilidad_%C3%BAnica)

El principio de responsabilidad única u SRP (siglas del inglés (Single Responsibility Principle) en ingeniería de software establece que cada módulo o clase debe tener responsabilidad sobre una sola parte de la funcionalidad proporcionada por el software y esta responsabilidad debe estar encapsulada en su totalidad por la clase. Todos sus servicios deben estar estrechamente alineados con esa responsabilidad.

* [Principio de Abierto/Cerrado (Open/closed principle - OCP)](https://es.wikipedia.org/wiki/Principio_de_abierto/cerrado)

Dentro de la programación orientada a objetos, el principio de abierto/cerrado u OCP (siglas del inglés Open/Closed Principle) establece que «una entidad de software (clase, módulo, función, etc.) debe quedarse abierta para su extensión, pero cerrada para su modificación». Es decir, se debe poder extender el comportamiento de tal entidad pero sin modificar su código fuente.

* [Principio de Substitución de Liskov (Liskov substitution principle - LSP)](https://es.wikipedia.org/wiki/Principio_de_sustituci%C3%B3n_de_Liskov)

Principio de sustitución de Liskov o LSP (Liskov Substitution Principle) es un principio de la programación orientada a objetos. y puede definirse como: Cada clase que hereda de otra puede usarse como su padre sin necesidad de conocer las diferencias entre ellas.

* [Principio de Segregración de la Interfaz (Interface segregation principle - ISP)](https://es.wikipedia.org/wiki/Principio_de_segregaci%C3%B3n_de_la_interfaz)

El principio de segregación de la interfaz (ISP, por sus siglas del inglés «Interface Segregation Principle») establece que los clientes de un programa dado sólo deberían conocer de éste aquellos métodos que realmente usan, y no aquellos que no necesitan usar.

* [Principio de Inversión de Dependencias (Dependency inversion principle - DIP)](https://es.wikipedia.org/wiki/Inyecci%C3%B3n_de_dependencias)

El principio de inversión de dependencias (DIP, por sus siglas en inglés «Dependency Inversion Principle») consta de dos partes:

  1. Módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones.

  2. Abstracciones no deberían depender de detalles. Los detalles debieran depender de abstracciones.

## License

[![Licencia de Creative Commons](https://i.creativecommons.org/l/by-sa/4.0/80x15.png)](http://creativecommons.org/licenses/by-sa/4.0/)  
Esta obra está bajo una [licencia de Creative Commons Reconocimiento-Compartir Igual 4.0 Internacional](http://creativecommons.org/licenses/by-sa/4.0/).
