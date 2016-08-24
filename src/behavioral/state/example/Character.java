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
 * Date: 6/10/15
 *
 * @author DroidMaxMan
 *
 * Clase de contexto que almacena el estado actual junto al resto de atributos que se considere oportuno.
 */
public class Character {

    // Estado actual
    private CharacterState cState;

    // Other var
    // ......

    /** Constructor **/
    public Character() {
        // Estado actual que por defecto puede ser de pie y quieto
        cState = new CharacterStanding(this);
    }

    /**
     * Set current state
     * @param cState to set
     */
    public void setState( CharacterState cState ) {
        this.cState = cState;
    }

    /**
     * Get current state
     * @return cState
     */
    public CharacterState getState() {
        return cState;
    }

    /**
     * Se invoca al método de la interfaz CharacterState y que se codificará
     * por las clases que implementen dicha interfaz
     */
    public void walk() {
        cState.walk();
    }

    /**
     * Se invoca al método de la interfaz CharacterState y que se codificará
     * por las clases que implementen dicha interfaz
     */
    public void getUp() {
        cState.getUp();
    }

    /**
     * Se invoca al método de la interfaz CharacterState y que se codificará
     * por las clases que implementen dicha interfaz
     */
    public void getDown() {
        cState.getDown();
    }

    /**
     * Se invoca al método de la interfaz CharacterState y que se codificará
     * por las clases que implementen dicha interfaz
     */
    public void jump() {
        cState.jump();
    }

}
