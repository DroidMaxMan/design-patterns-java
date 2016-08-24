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
 * Date: 4/10/15
 *
 * @author DroidMaxMan
 *
 * Se implementan los métodos de los estados que se pueden dar en este modo
 *
 * Estado: [QUIETO]
 */
public class CharacterStanding extends CharacterState {

    /** Referencia a la clase de contexto Character **/
    private Character character;

    /** Constructor **/
    public CharacterStanding(Character character) {
        this.character = character;
    }

    /**
     * Implementación de andando.
     * Si el personaje está parado, puede pasar a estado caminar
     */
    @Override
    public void walk() {
        super.walk();

        System.out.println("Transición: De pie -> Andar");

        // Se actualiza el estado en el personaje (contexto) con el nuevo estado
        character.setState(new CharacterWalk(character));
    }

    /**
     * Implementación de agacharse.
     * Si el personaje está parado, puede pasar a estado tumbado
     */
    @Override
    public void getDown() {
        super.getDown();

        System.out.println("Transición: De pie -> Agachado");

        // Se actualiza el estado en el personaje (contexto) con el nuevo estado
        character.setState(new CharacterLying(character));
    }

    /**
     * Implementación de saltar.
     * Si el personaje está parado, puede pasar a estado saltando
     */
    @Override
    public void jump() {
        super.jump();

        System.out.println("Transición: De pie -> Saltando");

        // Se actualiza el estado en el personaje (contexto) con el nuevo estado
        character.setState(new CharacterJump(character));
    }

    @Override
    public String toString() {
        return "De pie";
    }
}
