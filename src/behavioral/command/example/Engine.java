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

package behavioral.command.example;

import java.util.Random;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 29/09/15
 *
 * @author alejandro
 *
 * Invoker
 */
public class Engine {

    /** Commands **/
    private Command jump;
    private Command walk;
    private Command run;

    /** Delay **/
    long time;

    /** Constructor **/
    public Engine() {}

    public Engine(Command jump, Command walk, Command run) {
        this.jump = jump;
        this.walk = walk;
        this.run = run;

        // Time
        time = System.currentTimeMillis();
    }

    /** Jump **/
    public void jump() {
        // Delay
        while(true){
            if(System.currentTimeMillis() >= time + 2000) {
                jump.execute();
                break;
            }
        }
    }

    /** Walk **/
    public void walk() {
        // Delay
        while(true){
            if(System.currentTimeMillis() >= time + 8000) {
                walk.execute();
                break;
            }
        }
    }

    /** Run **/
    public void run() {
        // Delay
        while(true){
            if(System.currentTimeMillis() >= time + 12000) {
                run.execute();
                break;
            }
        }
    }

}
