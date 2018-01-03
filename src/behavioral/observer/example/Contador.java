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

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
 *
 * Ejemplo de sujeto observable. Es una clase que mantiene un valor entero en
 * el rango 0..maximo, donde maximo se establece en la construccion. La clase
 * dispone de metodos para modificar el valor y para acceder al estado
 * (valor, maximo). Extiende la clase observable heredando su
 */
public class Contador extends Observable {

    /*El constructor inicializa el estado del objeto: el maximo y el
     *valor inicial, siempre en el rango 0..maximo. Adicionalmente,
     *inicializa la parte de Observable que tiene un Contador...
     */
    public Contador( int valor, int maximo ) {
        super();
        _maximo = maximo;
        _valor = enRango( valor );
    }


    //Este metodo privado asegura que un valor n esta entre 0..maximo
    private int enRango( int n ) {
        if ( n < 0 ) {
            return 0;
        } else if ( n > _maximo ) {
            return _maximo;
        } else {
            return n;
        }
    }


    //Estos dos metodos permiten el acceso al estado del contador
    public int valor() {
        return _valor;
    }


    public int maximo() {
        return _maximo;
    }


    /*Este metodo afecta al estado: primero se modifica de forma consistente
     *el estado y despues se notifica a los observadores del cambio
     */
    public void incrementarContador( int n ) {
        _valor = enRango( _valor + n );
        notificarObservadores();
    }


    //Atributos privados que mantienen el estado del contador
    private int _valor, _maximo;
}
