/*
 *    Copyright 2015 Codessus. All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License
 *
 */

package creational.prototype;

import creational.prototype.example.FactoriaPrototipo;
import creational.prototype.example.Producto;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 20/09/15
 *
 * @author alejandro
 *
 *
 * Patrones de CREACIÓN
 * --------------------
 * Corrresponden a patrones de diseño que solucionan problemas de creación de instancias.
 *
 *
 * Pattern [PROTOTYPE] (prototipo)
 *
 * Proporciona abstracción a la hora de crear diferentes objetos en un contexto donde se desconoce cúantos y cuáles
 * deben ser creados a priori. La idea principal es que los objetos deben poder clonarse en tiempo de ejecución.
 * Por tanto, este patrón tiene como finalidad crear nuevos objetos duplicándolos, clonando una instancia creada previamente.
 *
 * La clase de los objetos que servirán de prototipo para la copia deberán incluir en su interfaz la manera de solicitar
 * esa copia, que será desarrollada luego por las clases concretas de prototipos.
 *
 * Este patrón se utiliza en casos como:
 *  - Evitar las subclases de un objeto creador como hace el patrón <i>Abstract Factory</i>
 *  - Evitar el costo inherente a la creación de un objeto nuevo mediante el operador <b>new</b> cuando esto es demasiado
 *  costoso para la aplicación.
 *  -  La decisión del tipo de objeto necesario se decide en tiempo de ejecución en función de determinados parámetros,
 *  configuraciones o condiciones en un momento dado.
 *
 * Este patrón es útil para implementar <i>plugins</i> o cuando se cargan en tiempo de ejecución liberías dinámicas
 *
 * Este patrón, dicho de otro modo, propone la creación de distintas variantes de objetos que la aplicación necesite en el
 * momento y contexto adecuados. Toda la lógica necesaria para la decisión sobre el tipo de objetos que usará la aplicación
 * es su ejecución se hace independiente, de manera que el código que utiliza estos objetos solicitará una copia del objeto
 * que necesite. En este contexto, una copia significa otra instancia del objeto. El único requisito que debe cumplir
 * este objeto es suministrar la funcionalidad de clonarse.
 */
public class Prototype {

    public static void main(String[] args) {

        // Instancia de la factoría
        FactoriaPrototipo factoriaPrototipo = new FactoriaPrototipo();

        // Producto clonado
        Producto producto = (Producto) factoriaPrototipo.create();

        System.out.println(producto.toString());

    }

}
