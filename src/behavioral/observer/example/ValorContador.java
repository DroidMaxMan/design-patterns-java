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
public class ValorContador implements Observador {

    //El constructor establece la asociacion entre ValorContador-Contador
    public ValorContador(Contador contador) {
        _contador = contador;
    }

    /*Tras ser notificado de un cambio, un observador ValorContador accede
    *al estado del Contador utilizando la asociacion
    */
    public void actualizar() {
        System.out.println("Valor del contador es " + _contador.valor() );
    }

    //Mantiene asociacion con el sujeto observable
    private Contador _contador;

}
