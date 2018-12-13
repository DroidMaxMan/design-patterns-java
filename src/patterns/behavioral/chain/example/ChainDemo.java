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

package patterns.behavioral.chain.example;

public class ChainDemo {

    public static void main(String[] args) {

        Manejador m1 = new ManejadorConcreto1();
        Manejador m2 = new ManejadorConcreto2();

        m1.setSucesor(m2);
        m1.manejarPeticion(new Peticion("Negativo ", -1));
        m1.manejarPeticion(new Peticion("Positivo ", 0));
        m1.manejarPeticion(new Peticion("Positivo ", 5));
    }

}
