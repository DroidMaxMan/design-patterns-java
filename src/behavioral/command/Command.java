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

package behavioral.command;

import behavioral.command.example.*;
import behavioral.command.example.Character;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author alejandro
 *
 *
 * Patrones de COMPORTAMIENTO
 * --------------------
 * Son los patrones de diseño software que se centran en cómo diseñar los sistemas para obtener cierta funcionalidad y,
 * al mismo tiempo, un diseño escalable.
 *
 *
 * Pattern [Command] (Orden)
 *
 * Encapsula una operación en un objeto, permitiendo ejecutar dicha operación sin necesidad de conocer el contenido de la misma.
 *
 */
public class Command {

    public static void main( String[] args ) {

        // Receiver
        Character character = new Character();

        // Commands
        behavioral.command.example.Command jump = new Jump(character);
        behavioral.command.example.Command run = new Run(character);
        behavioral.command.example.Command walk = new Walk(character);

        // Invoker
        Engine engine = new Engine(jump, walk, run);

        // Call to jump
        engine.jump();

        // Call to walk
        engine.walk();

        // Call to run
        engine.run();
    }
}
