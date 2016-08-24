# Design Patterns with Java

Teoría y ejemplos de patrones de diseño de software en Java.

## Creational Patterns

* [Singleton](src/creational/singleton) - garantiza la existencia de una única instancia para una clase 
y la creación de un mecanismo de acceso global a dicha instancia. Restringe la instanciación de una clase o valor de un 
tipo a un solo objeto. [Wikipedia](https://es.wikipedia.org/wiki/Singleton)

* [Abstract Factory](src/creational/abstractFactory) - permite trabajar con objetos de distintas familias 
de manera que las familias no se mezclen entre sí y haciendo transparente el tipo de familia concreta que se esté usando.
[Wikipedia](https://es.wikipedia.org/wiki/Abstract_Factory)

* [Factory Method](src/creational/factoryMethod) - consiste en utilizar una clase constructora (al estilo del Abstract Factory) 
abstracta con unos cuantos métodos definidos y otro(s) abstracto(s): el dedicado a la construcción de objetos de un 
subtipo de un tipo determinado. [Wikipedia](https://es.wikipedia.org/wiki/Factory_Method_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Prototype](src/creational/prototype) -  crea nuevos objetos clonándolos de una instancia ya existente. 
[Wikipedia](https://es.wikipedia.org/wiki/Prototype_%28patr%C3%B3n_de_dise%C3%B1o%29)


## Structural Patterns

* [Composite](src/structural/composite) - sirve para construir objetos 
complejos a partir de otros más simples y similares entre sí, gracias a la composición recursiva y a una estructura en 
forma de árbol. [Wikipedia](https://es.wikipedia.org/wiki/Composite_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Decorator](src/structural/decorator) - Añade funcionalidad a una 
clase dinámicamente. [Wikipedia](https://es.wikipedia.org/wiki/Decorator_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Facade](src/structural/facade) - Provee de una interfaz unificada 
simple para acceder a una interfaz o grupo de interfaces de un sistema. [Wikipedia](https://es.wikipedia.org/wiki/Facade_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [MVC](src/structural/mvc) - Separa los datos y la lógica de 
negocio de una aplicación de la interfaz de usuario y el módulo encargado de gestionar los eventos y las comunicaciones. 
[Wikipedia](https://es.wikipedia.org/wiki/Modelo%E2%80%93vista%E2%80%93controlador)

* [Adapter](src/structural/adapter) - Este patrón se utiliza para 
proporcionar una interfaz que, por un lado, cumpla con las demandas de los clientes y, por otra, haga compatible otra 
interfaz que, a priori, no lo es. [Wikipedia](https://es.wikipedia.org/wiki/Adapter_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Proxy](src/structural/proxy) - Proporciona mecanismos de abstracción y control para acceder a un determinado objeto
"simulando" que se trata del objeto real. [Wikipedia](https://es.wikipedia.org/wiki/Proxy_%28patr%C3%B3n_de_dise%C3%B1o%29)


## Behavioral Patterns

* [Observer](src/behavioral/observer) - Se utiliza para definir relaciones 1 a *n* de forma que un objeto pueda notificar
y/o actualizar el estado de otros automáticamente. [Wikipedia](https://es.wikipedia.org/wiki/Observer_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [State](src/behavioral/state) - Permite que un objeto modifique su comportamiento cada vez que cambie su estado interno. 
[Wikipedia](https://es.wikipedia.org/wiki/State_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Iterator](src/behavioral/iterator) - Permite realizar recorridos sobre objetos compuestos independientemente de la implementación de éstos. 
[Wikipedia](https://es.wikipedia.org/wiki/Iterador_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Template Method](src/behavioral/templateMethod) - Se puede utilizar cuando es necesario redefinir algunos pasos de un determinado algoritmo utilizando herencia. 
[Wikipedia](https://es.wikipedia.org/wiki/Template_Method_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Strategy](src/behavioral/strategy) - Se utiliza para encapsular el funcionamiento de una familia de algoritmos, de forma que
se pueda intercambiar su uso sin necesidad de modificar los clientes. [Wikipedia](https://es.wikipedia.org/wiki/Strategy_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Reactor](src/behavioral/reactor) - Es un patrón de programación concurrente para manejar los pedidos de servicio 
entregados de forma concurrente a un manejador de servicio desde una o más entradas. El manejador de servicio demultiplexa 
los pedidos entrantes y los entrega de forma sincrónica a los manejadores de pedidos asociados. [Wikipedia](https://es.wikipedia.org/wiki/Reactor_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Visitor](src/behavioral/visitor) - Proporciona un mecanismo para realizar diferentes operaciones sobre una jerarquía de
objetos de forma que añadir nuevas operaciones no haga necesario cambiar las clases de los objetos sobre los que se realizan
las operaciones. [Wikipedia](https://es.wikipedia.org/wiki/Visitor_%28patr%C3%B3n_de_dise%C3%B1o%29)

* [Command](src/behavioral/command) - Este patrón permite solicitar una operación a un objeto sin conocer realmente el 
contenido de esta operación, ni el receptor real de la misma. Para ello se encapsula la petición como un objeto, con lo 
que además facilita la parametrización de los métodos. [Wikipedia](https://es.wikipedia.org/wiki/Command_%28patr%C3%B3n_de_dise%C3%B1o%29)


## Copyright & License

Copyright (c) 2016 @DroidMaxMan. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
