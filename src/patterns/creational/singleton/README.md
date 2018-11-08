# Singleton (patrón creacional)

Los patrones creacionales corresponden a patrones de diseño de software que solucionan problemas de creación de instancias. Nos ayudan a encapsular y abstraer dicha creación.

El patrón ***Singleton*** garantiza la existencia de una única instancia para una clase y la creación de un mecanismo de acceso global a dicha instancia. Restringe la instanciación de una clase o valor de un tipo a un solo objeto.

## Problema

Los objetos normalmente se crean con el operador **new**. Sin embargo, es posible que en un determinado momento es necesario que sólo exista una instancia de una clase concreta (prevención de errores, seguridad, etc..).

## Solución

Para garantizar que sólo existe una instancia de una clase es necesario que los clientes no puedan acceder directamente al constructor. Por ello, en un singleton el constructor es, por lo menos, *protected* o inferior. A cambio se debe proporcionar un único punto (controlado) por el cual se pide la instancia única.

La instrumentación del patrón puede ser delicada en programas con múltiples hilos de ejecución. Si dos hilos de ejecución intentan crear la instancia al mismo tiempo y esta no existe todavía, sólo uno de ellos debe lograr crear el objeto.

El patrón ***Singleton*** puede ser utilizado para modelar:

* Gestores de acceso a base de datos, sistemas de ficheros, render de gráficos, etc..
* Estructuras que representan la configuración del programa para que sea accesible por todos los elementos en  cualquier instante.

El patrón ***Singleton*** provee una única instancia global gracias a que:

* La propia clase es responsable de crear la única instancia.
* Permite el acceso global a dicha instancia mediante un método de clase.
* Declara el contructor de clase como privado para que no sea instanciable directamente.

El patrón **Singleton** es un caso particular de un patrón de diseño más general llamado *Object Pool*, que permite crear *n* instancias de objetos de forma controlada.

## Enlaces

* [Singleton (patrón de diseño)](https://es.wikipedia.org/wiki/Singleton#Java)

## License

[![Licencia de Creative Commons](https://i.creativecommons.org/l/by-sa/4.0/80x15.png)](http://creativecommons.org/licenses/by-sa/4.0/)  
Esta obra está bajo una [licencia de Creative Commons Reconocimiento-Compartir Igual 4.0 Internacional](http://creativecommons.org/licenses/by-sa/4.0/).
