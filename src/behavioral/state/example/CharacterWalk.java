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

package behavioral.state.example;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 6/10/15
 *
 * @author alejandro
 *
 * Estado: [CAMINANDO]
 */
public class CharacterWalk extends CharacterState {

    /** Referencia a la clase de contexto Character **/
    private Character character;

    /** Constructor **/
    public CharacterWalk(Character character) {
        this.character = character;
    }

    /**
     * Implementación de quedarse quieto.
     * Si el personaje está andando, puede pasar a estado quieto
     */
    @Override
    public void getUp() {
        super.getUp();

        System.out.println("Transición: Andando -> Quieto");

        // Se actualiza el estado en el personaje (contexto) con el nuevo estado
        character.setState(new CharacterStanding(character));
    }

    /**
     * Implementación de saltar.
     * Si el personaje está andando, puede pasar a estado saltando
     */
    @Override
    public void jump() {
        super.jump();

        System.out.println("Transición: Andando -> Saltando");

        // Se actualiza el estado en el personaje (contexto) con el nuevo estado
        character.setState(new CharacterJump(character));
    }

    @Override
    public String toString() {
        return "Andando";
    }
}
