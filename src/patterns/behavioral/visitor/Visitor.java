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

package patterns.behavioral.visitor;

import patterns.behavioral.visitor.example.ConcreteVisitor1;
import patterns.behavioral.visitor.example.ConcreteVisitor2;
import patterns.behavioral.visitor.example.ElementA;
import patterns.behavioral.visitor.example.ElementB;

public class Visitor {

    public static void main(String[] args) {
        // Visitantes
        ConcreteVisitor1 concreteVisitor1 = new ConcreteVisitor1();
        ConcreteVisitor2 concreteVisitor2 = new ConcreteVisitor2();

        // Visitables
        ElementA elementA = new ElementA();
        ElementB elementB = new ElementB();

        // Visitar elementos
        concreteVisitor1.visitElementA(elementA);
        concreteVisitor2.visitElementB(elementB);
    }

}
