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

package patterns.behavioral.observer.example2;

class ObserverPatternEx {

    public static void main(String[] args) {
        Observer o1 = new Observer();
        Subject sub1 = new Subject();
        sub1.register(o1);

        System.out.println("Setting Flag = 5 ");
        sub1.setFlag(5);

        System.out.println("Setting Flag = 25 ");
        sub1.setFlag(25);

        sub1.unregister(o1);
        //No notification this time to o1 .Since it is unregistered.

        System.out.println("Setting Flag = 50 ");
        sub1.setFlag(50);
    }

}
