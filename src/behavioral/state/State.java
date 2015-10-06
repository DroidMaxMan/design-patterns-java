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

package behavioral.state;

import behavioral.state.example.*;
import behavioral.state.example.Character;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author alejandro
 *
 *
 * Patrones de COMPORTAMIENTO
 * --------------------
 * Son los patrones de diseño software que se centran en cómo diseñar los sistemas para obtener cierta funcioanlidad y,
 * al mismo tiempo, un diseño escalable.
 *
 *
 * Pattern [State] (Estado)
 *
 * Permite que un objeto modifique su comportamiento cada vez que cambie su estado interno.
 */
public class State {

    public static void main( String[] args ) {

        // Personaje (Contexto)
        Character character = new Character();

        // Estado actual
        System.out.println(character.getState().toString());

        // El personaje se pone en marcha
        character.walk();

        // Estado actual
        System.out.println(character.getState().toString());

        // El personaje salta
        character.jump();

        // Estado actual
        System.out.println(character.getState().toString());

        /* Para el ejemplo se hace manual pero en el caso del salto, se comprueba que el character colisione con el suelo
        y el estado se cambia cuando se produzca ese circumstancia
         */
        character.getUp();

        // Estado actual
        System.out.println(character.getState().toString());

    }

}
