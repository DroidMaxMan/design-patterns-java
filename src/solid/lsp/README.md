# LSP (Liskov Substitution Principle)

El **_Liskov Substitution Principle_** extiendel el **_Open/Closed Principle_** pero focalizando en el comportamiento de una superclase y sus subtipos de forma que si aplicamos este principio en nuestras clases e interfaces estaremos evitando todo tipo de efectos secundarios.

Este principio define que los objetos de una superclase deben ser reemplazables por objetos de sus subclases sin "romper" la aplicación o sistema. Eso requiere que los objetos de las subclases se comporten de la misma manera que los objetos de la superclase.

Para conseguir esto las subclases deberían seguir estas reglas:

* No implementar reglas de validación más estrictas en los parámetros de entrada que las implementadas por la clase base.

* Aplicar al menos las mismas reglas a todos los parámetros de salida aplicados por la clase base.

### Clases de ejemplo

En el ejemplo tenemos las clases [Car](violation/Car.java) y [Airplane](violation/Airplane.java) que heredan de la clase [Vehicle](violation/Vehicle.java)   
![Diagram](lsp_violation_diagram.png)

Según el **_Liskov Substitution Principle_** deberíamos poder utilizar las clases _Car_ o _Airplane_ en lugar de la superclase _Vehicle_. La realidad es que no se podría hacer sin generar errores en la aplicación ya que la subclase _Car_ tiene unas restricciones superiores a la clase base. En concreto y siguiendo el ejemplo si se cambia a la marcha atrás (R) circulando el vehículo hacia adelante se genera una RuntimeException. Esta excepción no se genera ni en la subclase _Airplane_ ni en la superclase _Vehicle_.

Si refactorizamos el método _changeGear_ en la subclase _Car_ de forma que no se lancen excepciones de modo que ni los parámetros de entrada ni los parámetros de salida sean más restrictivos que la superclase conseguimos que se aplique el **_Liskov Substitution Principle_**   
![Diagram](lsp_solution_diagram.png)
