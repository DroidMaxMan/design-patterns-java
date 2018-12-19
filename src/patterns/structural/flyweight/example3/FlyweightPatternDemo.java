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

package patterns.structural.flyweight.example3;

public class FlyweightPatternDemo {

    private static final String colors[] = {"Red", "Orange", "Blue", "Yellow", "Pink"};

    public static void main(String[] args) {

        for (int i = 0; i < 20; ++i) {
            AngryBird angrybird = (AngryBird) BirdFactory.getAngryBird(getRandomColor());

            angrybird.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

}
