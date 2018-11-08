/*
 * ************************************************************************
 *  Copyright (c) 2018 @alxgcrz <alxgcrz@outlook.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ***********************************************************************
 */

package patterns.behavioral.state.example;

public class CharacterJump implements CharacterState {

    private Character character;


    public CharacterJump(Character character) {
        this.character = character;
    }


    @Override
    public void walk() {
        throw new UnsupportedOperationException();
    }


    /**
     * Si el personaje está saltando, puede pasar a estado quieto
     */
    @Override
    public void getUp() {
        System.out.println("Transición: Saltando -> Quieto");

        character.setState(new CharacterStanding(character));
    }


    @Override
    public void getDown() {
        throw new UnsupportedOperationException();
    }


    @Override
    public void jump() {
        throw new UnsupportedOperationException();
    }


    @Override
    public String toString() {
        return CharacterJump.class.getSimpleName();
    }
}
