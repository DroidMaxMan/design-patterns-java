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

package behavioral.visitor;

import behavioral.visitor.example.ConcreteVisitor1;
import behavioral.visitor.example.ConcreteVisitor2;
import behavioral.visitor.example.ElementA;
import behavioral.visitor.example.ElementB;


/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
 *
 *
 * Patrones de COMPORTAMIENTO
 * --------------------
 * Son los patrones de diseño software que se centran en cómo diseñar los sistemas para obtener cierta funcioanlidad y,
 * al mismo tiempo, un diseño escalable.
 *
 *
 * Pattern [Visitor] (Visitante)
 *
 * Permite definir nuevas operaciones sobre una jerarquía de clases sin modificar las clases sobre las que opera.
 */
public class Visitor {

    public static void main( String[] args ) {

        // Visitantes
        ConcreteVisitor1 concreteVisitor1 = new ConcreteVisitor1();
        ConcreteVisitor2 concreteVisitor2 = new ConcreteVisitor2();

        // Visitables
        ElementA elementA = new ElementA();
        ElementB elementB = new ElementB();

        // Visitar elementos
        concreteVisitor1.visitElementA( elementA );
        concreteVisitor2.visitElementB( elementB );

    }
}
