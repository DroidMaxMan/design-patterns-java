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

package behavioral.command.example;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 29/09/15
 *
 * @author DroidMaxMan
 *
 * Receiver
 */
public class Character {

    /** Constructor **/
    public Character() {}

    /**
     * Action: Walk
     */
    public void walk() {
        System.out.println("WALKING");
    }

    /**
     * Action: Run
     */
    public void run() {
        System.out.println("RUNNING");
    }

    /**
     * Action: Walk
     */
    public void jump() {
        System.out.println("JUMPING");
    }

}
