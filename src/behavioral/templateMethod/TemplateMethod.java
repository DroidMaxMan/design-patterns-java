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

package behavioral.templateMethod;

import behavioral.templateMethod.example.CheckersPlayer;
import behavioral.templateMethod.example.ChessPlayer;
import behavioral.templateMethod.example.GamePlayer;

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
 * Pattern [Template Method] (Método plantilla)
 *
 * Define en una operación el esqueleto de un algoritmo, delegando en las subclases algunos de sus pasos. Esto permite
 * que las subclases redefinan ciertos pasos de un algoritmo sin cambiar su estructura.
 */
public class TemplateMethod {

    public static void main( String[] args ) {
        // Ajedrez
        GamePlayer gamePlayer = new ChessPlayer();
        System.out.println("[CHESS]");

        // Jugar al juego
        gamePlayer.play();

        // Damas
        gamePlayer = new CheckersPlayer();
        System.out.println("[CHECKERS]");

        // Jugar
        gamePlayer.play();
    }

}
