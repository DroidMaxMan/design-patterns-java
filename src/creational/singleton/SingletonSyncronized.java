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
package creational.singleton;

/**
 * Project Learning_Design_Patterns_Java
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
 * Date 19/09/15
 * @see Singleton
 */
public class SingletonSyncronized {

    private static SingletonSyncronized INSTANCE = null;


    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase)
    private SingletonSyncronized() {
    }


    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple
    private synchronized static void createInstance() {
        if ( INSTANCE == null ) {
            INSTANCE = new SingletonSyncronized();
        }
    }


    public static SingletonSyncronized getInstance() {
        if ( INSTANCE == null ) createInstance();
        return INSTANCE;
    }


    //Así se podría clonar el objeto y no tendría unicidad.
    //Singleton clonedObject = (Singleton) new Singleton().clone();


    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
