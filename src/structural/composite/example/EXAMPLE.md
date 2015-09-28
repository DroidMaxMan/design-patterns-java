# Composite

## Problema

Para ilustrar el problema supóngase un juego de estrategia en el que los jugadores
pueden recoger objetos o items, los cuales tienen una serie de propiedades como «pre-
cio», «descripción», etc. Cada item, a su vez, puede contener otros items. Por ejemplo,
un bolso de cuero puede contener una pequeña caja de madera que, a su vez, contiene
un pequeño reloj dorado.
En definitiva, el patrón Composite habla sobre cómo diseñar este tipo de estructu-
ras recursivas donde la composición homogénea de objetos recuerda a una estructura
arbórea.

![Composite](imgs/Composite.png)


## Solución

Como se puede ver, todos los objetos del ejemplo son de la clase *Items* que implementan una serie de métodos comunes.
En la jerarquia existen objetos compuestos, como *Bag*, que mantienen una lista de *items* donde residen los objetos
que contiene. 

Naturalmente, los objetos compuestos suelen ofrecer también operaciones para añadir, eliminar y actualizar.

Por otro lado, hay *objetos hoja* que no contienen más objetos, como es el caso de *Clock*
