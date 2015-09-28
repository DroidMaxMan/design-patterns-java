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

package behavioral.observer.example;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author alejandro
 *
 * Un ejemplo de observador concreto de la clase contador.
 */
public class Medidor implements Observador {

    //El constructor de Medidor establece la asociacion entre Medidor-Contador
    public Medidor(Contador contador) {
        _contador = contador;
    }

    /*Tras ser notificado de un cambio, un observador Medidor accede
    *al estado del Contador utilizando la asociacion
    */

    public void actualizar() {
        int porcentaje = _contador.valor() * 100 / _contador.maximo();
        System.out.println("Porcentaje del contador es " + porcentaje + "%");
    }

    //Mantiene la asociacion con el contador
    private Contador _contador;

}
