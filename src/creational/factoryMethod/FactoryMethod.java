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

package creational.factoryMethod;

import creational.factoryMethod.example.ConcreteCreatorA;
import creational.factoryMethod.example.ConcreteCreatorB;
import creational.factoryMethod.example.Creator;
import creational.factoryMethod.example.Product;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 20/09/15
 *
 * @author alejandro
 *
 * Patrones de CREACIÓN
 * --------------------
 * Corrresponden a patrones de diseño que solucionan problemas de creación de instancias.
 *
 *
 * Pattern [FACTORY METHOD] (método de fabricación)
 *
 * Centraliza en una clase constructora la creación de objetos de un subtipo de un un tipo determinado, ocultando al
 * usuario la diversidad de casos particulares que se pueden prever en la elección del subtipo.
 *
 * El patrón <i>Factory Method</i> consiste en utilizar una clase constructora abstracta (al estilo <i>Abstract Factory</i>
 * con métodos definidos y otro(s) abstracto(s) dedicado(s) a la construcción de objetos de un subtipo de un tipo determinado.
 * Es una simplificación del <i>Abstract Factory</i> en la que la clase abstracta tiene métodos concretos.
 *
 * Este patrón tiene las siguientes características:
 *  - No es necesario tener una factoría o una jerarquía de factorías para la creación de objetos. Permite diseños más
 *  adaptados a la realidad.
 *   - El método factoría o <i>Factory Method</i> al estar integrado en una clase, hace posible conectar dos jerarquías
 *   de objetos distintas.
 *
 * Nótese que el patrón <i>Factory Method</i> se utiliza para implementar el patrón <i>Abstract Factory</i> ya que la
 * factoría abstracta define una interfaz con métodos de construcción de objetos que son implementados por las subclases.
 *
 * Links:
 * https://es.wikipedia.org/wiki/Factory_Method_%28patr%C3%B3n_de_dise%C3%B1o%29
 */
public class FactoryMethod {

    public static void main (String[] args){
        // Creator A
        Creator creatorA = new ConcreteCreatorA();
        // Product A
        Product productA = creatorA.factoryMethod();

        // Creator B
        Creator creatorB = new ConcreteCreatorB();
        // Product B
        Product productB = creatorB.factoryMethod();

        productA.operacion();
        productB.operacion();
    }
}
