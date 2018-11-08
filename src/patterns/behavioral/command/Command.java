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

package patterns.behavioral.command;


import patterns.behavioral.command.example.*;
import patterns.behavioral.command.example.Character;

public class Command {

    public static void main(String[] args) {
        // Receiver
        Character character = new Character();

        // Commands
        patterns.behavioral.command.example.Command jump = new Jump(character);
        patterns.behavioral.command.example.Command run = new Run(character);
        patterns.behavioral.command.example.Command walk = new Walk(character);

        // Invoker
        Engine engine = new Engine(jump, walk, run);

        // Action invoke
        engine.jump();
        engine.walk();
        engine.run();
    }
}
