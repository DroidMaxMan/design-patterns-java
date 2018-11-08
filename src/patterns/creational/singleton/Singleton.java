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

package patterns.creational.singleton;

public class Singleton {

    private static Singleton INSTANCE = null;

    // El constructor privado no permite que se genere un constructor por defecto.
    private Singleton() {
    }

    public static Singleton getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton singleton = getINSTANCE();
        System.out.println(singleton.toString());
        singleton = getINSTANCE();
        System.out.println(singleton.toString());
    }

    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
