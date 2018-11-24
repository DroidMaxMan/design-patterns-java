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

package patterns.behavioral.strategy.example2;

public class FirstChoice implements IChoice {

    @Override
    public void myChoice(String s1, String s2) {
        System.out.println("You wanted to add the numbers.");
        int sum = Integer.parseInt(s1) + Integer.parseInt(s2);
        System.out.println(" The result of the addition is:" + sum);
    }

}
