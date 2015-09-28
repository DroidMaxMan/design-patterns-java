# Factory Method

Centraliza en una clase constructora la creación de objetos de un subtipo de un un tipo determinado, ocultando al 
usuario la diversidad de casos particulares que se pueden prever en la elección del subtipo.

## Problema

Al igual que ocurre con el patrón *Abstract Factory* el problema que se pretende resolver es la creación de diferentes
instancias de objetos abstrayendo la forma en que realmente se crean.

## Solución

El patrón *Factory Method* consiste en utilizar una clase constructora abstracta (al estilo *Abstract Factory*
con métodos definidos y otro(s) abstracto(s) dedicado(s) a la construcción de objetos de un subtipo de un tipo determinado.
Es una simplificación del *Abstract Factory* en la que la clase abstracta tiene métodos concretos.

Este patrón tiene las siguientes características:
* No es necesario tener una factoría o una jerarquía de factorías para la creación de objetos. Permite diseños más 
adaptados a la realidad. 
* El método factoría o *Factory Method* al estar integrado en una clase, hace posible conectar dos jerarquías 
de objetos distintas. 

Nótese que el patrón *Factory Method* se utiliza para implementar el patrón *Abstract Factory* ya que la
factoría abstracta define una interfaz con métodos de construcción de objetos que son implementados por las subclases.

## Implementación

Las clases principales de este patrón son el **creador** y el **producto**. El creador necesita crear instancias de productos,
pero el tipo concreto de producto no debe ser forzado en las subclases del creador porque las posibles subclases del 
creador deber poder especificar subclases del producto para utilizar.

![Factory Method](example/imgs/Factory_Method.png)

La solución para esto es hacer un método abstracto (el método de la fábrica) que se define en el creador. Este método abstracto
se define para que devuelva un producto. Las subclases del creador pueden sobreescribir este método para devolver subclases 
apropiadas del producto.

## Enlaces
* [Factory Method](https://es.wikipedia.org/wiki/Factory_Method_%28patr%C3%B3n_de_dise%C3%B1o%29)
