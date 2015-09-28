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

package structural.decorator;

import structural.decorator.example.Firearm;
import structural.decorator.example.Magazine;
import structural.decorator.example.Rifle;
import structural.decorator.example.Silencer;


/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author alejandro
 *
 *
 * Patrones ESTRUCTURALES
 * --------------------
 * Son los patrones de diseño software que solucionan problemas de composición (agregación) de clases y objetos.
 *
 *
 * Pattern [DECORATOR] (decorador)
 *
 * Sirve para añadir y/o modificar la responsabilidad, funcionalidad o propiedades de un objeto en tiempo de ejecución.
 *
 *
 */
public class Decorator {

    public static void main( String[] args ) {
        // Arma básica sin decorar
        Firearm gun = new Rifle();
        System.out.println("Noise: " + gun.noise());
        System.out.println("Bullets: " + gun.bullets());

        // char gets a silencer
        Firearm gun2 = new Silencer(gun);
        System.out.println("\nSilencer (noise): " + gun2.noise());
        System.out.println("Silencer (bullets): " + gun2.bullets());

        // char gets a magazine
        Firearm gun3 = new Magazine(gun2);
        System.out.println("\nSilencer & Magazine (noise): " + gun3.noise());
        System.out.println("Silencer & Magazine (bullets): " + gun3.bullets());
    }

}
