/*
 * Copyright (c) 2016 @DroidMaxMan. All rights reserved.
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

package structural.facade;


/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author DroidMaxMan
 *
 *
 * Patrones ESTRUCTURALES
 * --------------------
 * Son los patrones de diseño software que solucionan problemas de composición (agregación) de clases y objetos.
 *
 *
 * Pattern [FACADE] (fachada)
 *
 * Provee de una interfaz unificada simple para acceder a una interfaz o grupo de interfaces de un subsistema.
 */
public class Facade {

    public static void main( String[] args) {

        // Crear la fachada
        structural.facade.example.Facade facade = new structural.facade.example.Facade();

        // Llamar a los métodos
        System.out.println( facade.getInfoA() );
        System.out.println( facade.getInfoB() );
        System.out.println( facade.getInfoC() );
    }
}
