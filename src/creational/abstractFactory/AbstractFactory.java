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

package creational.abstractFactory;

import creational.abstractFactory.example.ManFactory;
import creational.abstractFactory.example.OrcFactory;
import creational.abstractFactory.example.Soldier;
import creational.abstractFactory.example.SoldierFactory;

/**
 *
 * Project Learning_Design_Patterns_Java
 * @author DroidMaxMan
 * Date 19/09/15
 *
 * Patrones de CREACIÓN
 * --------------------
 * Corrresponden a patrones de diseño que solucionan problemas de creación de instancias.
 *
 * Pattern [ABSTRACT FACTORY] (fábrica abstracta)
 *
 * Permite crear diferentes tipos o familias de instancias, aislando al cliente sobre cómo se debe crear cada una de ellas.
 *
 */
public class AbstractFactory {

    public static void main(String[] args) {

        // Factory
        SoldierFactory factory;

        // Men
        factory = new ManFactory();

        Soldier mArcher = factory.makeArcher();
        Soldier mRider = factory.makeRider();


        // Orcs
        factory = new OrcFactory();
        Soldier oArcher = factory.makeArcher();
        Soldier oRider = factory.makeRider();

    }

}
