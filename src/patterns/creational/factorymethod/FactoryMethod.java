/*
 * ************************************************************************
 *  Copyright (c) 2018 @alxgcrz <alxgcrz@outlook.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ***********************************************************************
 */

package patterns.creational.factorymethod;

import patterns.creational.factorymethod.example.ConcreteCreatorA;
import patterns.creational.factorymethod.example.ConcreteCreatorB;
import patterns.creational.factorymethod.example.Creator;
import patterns.creational.factorymethod.example.Product;

public class FactoryMethod {

    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();

        productA.operacion();
        productB.operacion();
    }

}
