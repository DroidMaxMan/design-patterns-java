/*
 * Copyright (c) 2016 @DroidMaxMan. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package behavioral.observer;

import behavioral.observer.example.Contador;
import behavioral.observer.example.Detector;
import behavioral.observer.example.Medidor;
import behavioral.observer.example.ValorContador;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author DroidMaxMan
 *
 *
 *  Patrones de COMPORTAMIENTO
 * --------------------
 * Son los patrones de diseño software que se centran en cómo diseñar los sistemas para obtener cierta funcioanlidad y,
 * al mismo tiempo, un diseño escalable.
 *
 *
 * Pattern [Observer] (Observador)
 *
 * Es un patrón que se utiliza para definir relaciones 1 a *n* de forma que un objeto pueda notificar y/o actualizar
 * el estado de otros automáticamente.
 *
 */
public class Observer {

    public static void main(String... argv) {

        Contador c = new Contador(0,255);

        Detector d = new Detector();
        c.agregarObservador(d);
        c.incrementarContador(5);

        ValorContador v = new ValorContador(c);
        c.agregarObservador(v);
        c.incrementarContador(5);

        Medidor m = new Medidor(c);
        c.agregarObservador(m);
        c.eliminarObservador(d);
        c.incrementarContador(19);
    }
}
