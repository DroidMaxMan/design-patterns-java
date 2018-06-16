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

package creational.singleton;

public class SingletonSyncronized {

    private static SingletonSyncronized INSTANCE = null;

    // El constructor privado no permite que se genere un constructor por defecto.
    private SingletonSyncronized() {
    }

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple
    private static synchronized void createInstance() {
        if ( INSTANCE == null ) {
            INSTANCE = new SingletonSyncronized();
        }
    }

    public static SingletonSyncronized getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
