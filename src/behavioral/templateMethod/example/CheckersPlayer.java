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

package behavioral.templateMethod.example;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 7/10/15
 *
 * @author DroidMaxMan
 */
public class CheckersPlayer extends GamePlayer {

    private static int movements = 0;

    /**
     * Cada juego mueve las fichas de distinta forma
     */
    @Override
    void doBestMove() {
        System.out.println("Moviendo ficha - Movimiento " + movements);
        // Aumentamos el contador de movimientos
        movements++;
    }

    /**
     * Como ejemplo, daremos por hecho que en las damas movemos primero
     * @return true
     */
    @Override
    boolean moveFirst() {
        System.out.println("Movemos primero");
        return true;
    }

    /**
     * Como convención para el ejemplo, la partida acaba al alcanzar 25 movimientos
     * @return true if game is over
     */
    @Override
    boolean isOver() {
        if(movements < 25) {
            return false;
        } else {
            System.out.println("Fin de la partida - Alcanzado los " + movements + " como máximo");
            return true;
        }
    }

}
