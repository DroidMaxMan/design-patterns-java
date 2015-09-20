# Prototype

# Implementación

Para implementar este patrón se declara una clase base abstracta que tiene un método *clone()*. Cualquier clase que
necesite un constructor deriva de la clase abstracta e implementa el método *clone()*

![Prototype](imgs/Prototype.png)

El cliente, en vez de escribir código que hace uso del generador *new* sobre una clase específica, llama al método
*clone()* de la clase prototipo, o llama a un método factoría con un parámetro que especifíca la clase deseada, o invoca el 
método *clone()* de la clase de alguna otra forma.

Por ejemplo, es posible usar un *gestor de prototipos* que permita cargar y descargar los prototipos disponibles en 
tiempo de ejecución.

Aunque en un principio este patrón parece que entra en conflicto con *Abstract Factory* es posible utilizar ambas
aproximaciones en una *Prototype Abstract Factory* de forma que la factoría se configura con los prototipos concretos
que puede crear y ésta sólo invoca al método *clone()*
