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

package behavioral.state.example;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 7/10/15
 *
 * @author DroidMaxMan
 *
 * Estado: [TUMBADO]
 */
public class CharacterLying extends CharacterState {

    /** Referencia a la clase de contexto Character **/
    private Character character;

    /** Constructor **/
    public CharacterLying(Character character) {
        this.character = character;
    }

    /**
     * Implementación de levantarse.
     * Si el personaje está tumbado, puede pasar a estado de pie
     */
    @Override
    public void getUp() {
        super.getUp();

        System.out.println("Transición: Tumbado -> De pie");

        // Se actualiza el estado en el personaje (contexto) con el nuevo estado
        character.setState(new CharacterStanding(character));
    }


    @Override
    public String toString() {
        return "Tumbado";
    }
}
