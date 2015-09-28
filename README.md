# Design Patterns with Java

Examples of design patterns made with Java.

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



## Copyright & License

Copyright 2015 Codessus. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
