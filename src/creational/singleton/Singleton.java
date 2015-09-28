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
package creational.singleton;

/**
 *
 * Project Learning_Design_Patterns_Java
 * @author alejandro
 * Date 19/09/15
 *
 *
 * Patrones de CREACIÓN
 * --------------------
 * Corrresponden a patrones de diseño que solucionan problemas de creación de instancias.
 *
 *
 * Pattern [SINGLETON] (instancia única)
 *
 * Garantiza la existencia de una única instancia para una clase y la creación de un mecanismo de acceso global
 * a dicha instancia. Restringe la instanciación de una clase o valor de un tipo a un solo objeto.
 *
 */
public class Singleton {

    private static Singleton INSTANCE = null;

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase)
    private Singleton() {}


    public Singleton getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }


    //Así se podría clonar el objeto y no tendría unicidad.
    //Singleton clonedObject = (Singleton) new Singleton().clone();

    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
