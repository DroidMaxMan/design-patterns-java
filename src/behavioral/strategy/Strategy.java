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

package behavioral.strategy;

import behavioral.strategy.example.GamePlayer;
import behavioral.strategy.example.Movement;
import behavioral.strategy.example.RandomMovement;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author DroidMaxMan
 *
 *
 * Patrones de COMPORTAMIENTO
 * --------------------
 * Son los patrones de diseño software que se centran en cómo diseñar los sistemas para obtener cierta funcioanlidad y,
 * al mismo tiempo, un diseño escalable.
 *
 *
 * Pattern [Strategy] (Estrategia)
 *
 * Permite disponer de varios métodos para resolver un problema y elegir cuál utilizar en tiempo de ejecución.
 */
public class Strategy {

    public static void main( String[] args ) {
        // Movimiento aleatorio
        Movement movement = new RandomMovement();

        // Asignar la estrategia
        GamePlayer player = new GamePlayer();
        player.setMovement(movement);

        player.doBestMove();
    }

}
