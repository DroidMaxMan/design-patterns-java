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

package structural.proxy;

import structural.proxy.example.Graphic;
import structural.proxy.example.ImageProxy;


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
 * Pattern [Proxy]
 *
 * Es un patrón estructural que tiene como propósito proporcionar un subrogado o intermediario de un objeto para controlar su acceso.
 */
public class Proxy {

    public static void main( String[] args ) {

        // Client
        Graphic image = new ImageProxy();

        // Display
        System.out.println( image.display() ); // loading and display
        System.out.println( image.display() ); // display
        System.out.println( image.display() ); // display
    }
}
