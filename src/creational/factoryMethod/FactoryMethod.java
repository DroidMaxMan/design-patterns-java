/*
 * Copyright (c) 2018 @alxgcrz <alxgcrz@outlook.com>
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

package creational.factoryMethod;

import creational.factoryMethod.example.ConcreteCreatorA;
import creational.factoryMethod.example.ConcreteCreatorB;
import creational.factoryMethod.example.Creator;
import creational.factoryMethod.example.Product;


/**
 * Project: Learning_Design_Patterns_Java
 * Date: 20/09/15
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
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
 */
public class FactoryMethod {

    public static void main( String[] args ) {
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
