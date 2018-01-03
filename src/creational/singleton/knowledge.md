# Singleton Pattern

Garantiza la existencia de una única instancia para una clase y la creación de un mecanismo de acceso global
a dicha instancia. Restringe la instanciación de una clase o valor de un tipo a un solo objeto.


## Problema

Los objetos normalmente se crean con el operador **new**. Sin embargo, es posible que en un determinado momento es
necesario que sólo exista una instancia de una clase concreta (prevención de errores, seguridad, etc..)


## Solución

Para garantizar que sólo existe una instancia de una clase es necesario que los clientes no puedan acceder directamente
al constructor. Por ello, en un singleton el constructor es, por lo menos, *protected* o inferior. A cambio se
debe proporcionar un único punto (controlado) por el cual se pide la instancia única.

La instrumentación del patrón puede ser delicada en programas con múltiples hilos de ejecución. Si dos hilos de
ejecución intentan crear la instancia al mismo tiempo y esta no existe todavía, sólo uno de ellos debe lograr crear
el objeto.

El patrón *Singleton* puede ser utilizado para modelar:
- gestores de acceso a base de datos, sistemas de ficheros, render de gráficos, etc..
- estructuras que representan la configuración del programa para que sea accesible por todos los elementos en  cualquier instante.
 
El patrón *Singleton* provee una única instancia global gracias a que:
 - la propia clase es responsable de crear la única instancia
 - permite el acceso global a dicha instancia mediante un método de clase
 - declara el contructor de clase como privado para que no sea instanciable directamente.
 
 El patrón *Singleton* es un caso particular de un patrón de diseño más general llamado *Object Pool*,  que permite 
 crear *n* instancias de objetos de forma controlada.


## Enlaces
* [Singleton](https://es.wikipedia.org/wiki/Singleton#Java)


License
-------
    Copyright (c) 2018 @alxgcrz <alxgcrz@outlook.com>
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
