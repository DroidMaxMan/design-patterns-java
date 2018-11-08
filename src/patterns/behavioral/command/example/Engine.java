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

package patterns.behavioral.command.example;

public class Engine {

    private Command jump;
    private Command walk;
    private Command run;

    private long shortDelay = 2000;
    private long mediumDelay = shortDelay * 4;
    private long longDelay = shortDelay * 6;
    private long savedTime;

    public Engine(Command jump, Command walk, Command run) {
        this.jump = jump;
        this.walk = walk;
        this.run = run;

        savedTime = System.currentTimeMillis();
    }

    public void jump() {
        while (true) {
            if (System.currentTimeMillis() >= savedTime + shortDelay) {
                jump.execute();
                break;
            }
        }
    }

    public void walk() {
        while (true) {
            if (System.currentTimeMillis() >= savedTime + mediumDelay) {
                walk.execute();
                break;
            }
        }
    }

    public void run() {
        while (true) {
            if (System.currentTimeMillis() >= savedTime + longDelay) {
                run.execute();
                break;
            }
        }
    }

}
