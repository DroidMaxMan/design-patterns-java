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

package behavioral.observer.example;

import java.util.ArrayList;


/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
 *
 * Esta clase abstracta representa los objetos susceptibles de ser
 * observados. Incorpora metodos para agregar y eliminar observadores
 * y un metodo de notificacion. La asociacion Observable-Observadores
 * se implementa mediante un vector de observadores
 */
public class Observable {

    //El constructor crea el vector con la asociacion Observable-Observador
    public Observable() {
        _observadores = new ArrayList<Observador>();
    }


    //Agregar y eliminar sencillamente operan sobre vector _observadores...
    public void agregarObservador( Observador o ) {
        _observadores.add( o );
    }


    public void eliminarObservador( Observador o ) {
        _observadores.remove( o );
    }


    //Notificacion: Para cada observador se invoca el método actualizar().
    public void notificarObservadores() {
        for ( Observador o : _observadores ) {
            o.actualizar();
        }
    }


    //Este atributo privado mantiene el vector con los observadores
    private ArrayList<Observador> _observadores;
}
