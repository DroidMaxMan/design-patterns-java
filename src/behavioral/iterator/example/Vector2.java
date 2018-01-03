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

package behavioral.iterator.example;

import java.util.Random;


/**
 * Project: Learning_Design_Patterns_Java
 * Date: 1/10/15
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
 */
public class Vector2 {

    public int[] _datos;


    public Vector2( int valores ) {
        _datos = new int[valores];
        for ( int i = 0; i < _datos.length; i++ ) {
            _datos[i] = new Random().nextInt( 500 );
        }
    }


    public int getValor( int pos ) {
        return _datos[pos];
    }


    public void setValor( int pos, int valor ) {
        _datos[pos] = valor;
    }


    public int dimension() {
        return _datos.length;
    }


    /**
     * Devuelve un iterador que permite recorrer esta estructura.
     * Como parámetro se le pasa una referencia de si mismo
     *
     * @return Iterador para recorrer esta estructura
     */
    public IteradorVector iterador() {
        return new IteradorVector( this );
    }
}
