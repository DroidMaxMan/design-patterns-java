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

package creational.prototype;

import creational.prototype.example.FactoriaPrototipo;
import creational.prototype.example.Producto;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 20/09/15
 *
 * @author DroidMaxMan
 *
 *
 * Patrones de CREACIÓN
 * --------------------
 * Corrresponden a patrones de diseño que solucionan problemas de creación de instancias.
 *
 *
 * Pattern [PROTOTYPE] (prototipo)
 *
 * Proporciona abstracción a la hora de crear diferentes objetos en un contexto donde se desconoce cúantos y cuáles
 * deben ser creados a priori. La idea principal es que los objetos deben poder clonarse en tiempo de ejecución.
 * Por tanto, este patrón tiene como finalidad crear nuevos objetos duplicándolos, clonando una instancia creada previamente.
 *
 */
public class Prototype {

    public static void main(String[] args) {

        // Instancia de la factoría
        FactoriaPrototipo factoriaPrototipo = new FactoriaPrototipo();

        // Producto clonado
        Producto producto = (Producto) factoriaPrototipo.create();

        System.out.println(producto.toString());

    }

}
