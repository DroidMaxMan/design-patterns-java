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

package structural.composite;

import structural.composite.example.Bag;
import structural.composite.example.Clock;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 22/09/15
 *
 * @author DroidMaxMan
 *
 *
 * Patrones ESTRUCTURALES
 * --------------------
 * Son los patrones de diseño software que solucionan problemas de composición (agregación) de clases y objetos.
 *
 *
 * Pattern [COMPOSITE] (objeto compuesto)
 *
 * Este patrón sirve para construir objetos complejos a partir de otros más simples y similares entre sí gracias a la
 * composición recursiva y a una estructura en forma de árbol.
 *
 */
public class Composite {

    public static void main( String[] args ) {
        // Objetos
        Clock relojBolsillo = new Clock();
        Clock reloj = new Clock();

        // Bolsa
        Bag bolsa = new Bag();

        // Guardar objetos
        bolsa.addItem(reloj);
        bolsa.addItem(relojBolsillo);
    }

}
