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

package structural.adapter;

import structural.adapter.example.Target;


/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
 *
 *
 * Patrones ESTRUCTURALES
 * --------------------
 * Son los patrones de diseño software que solucionan problemas de composición (agregación) de clases y objetos.
 *
 *
 * Pattern [Adapter] (Adaptador)
 *
 * Se utiliza para transformar una interfaz en otra, de tal modo que una clase que no pudiera utilizar la primera,
 * haga uso de ella a través de la segunda.
 */
public class Adapter {

    public static void main( String[] args ) {

        // El Cliente llama al método adaptado
        Target target = new structural.adapter.example.Adapter();

        // Llamada al método
        System.out.println( "Método adaptado: " + target.method() );
    }
}
