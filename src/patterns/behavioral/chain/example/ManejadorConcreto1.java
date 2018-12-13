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

class ManejadorConcreto1 extends Manejador {

    @Override
    public void manejarPeticion(Peticion peticion) {
        if (peticion.getValue() < 0) {
            System.out.println("Los valores negativos son manejados por " + getClass().getSimpleName());
            System.out.println("Valores peticion : " + peticion.getDescripcion() + peticion.getValue());
        } else {
            sucesor.manejarPeticion(peticion);
        }
    }

}
