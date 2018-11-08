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

package patterns.structural.decorator;

import patterns.structural.decorator.example.Firearm;
import patterns.structural.decorator.example.Magazine;
import patterns.structural.decorator.example.Rifle;
import patterns.structural.decorator.example.Silencer;

public class Decorator {

    public static void main(String[] args) {
        Firearm rifle = new Rifle();
        System.out.println("Noise: " + rifle.noise());
        System.out.println("Bullets: " + rifle.bullets());

        Firearm rifleWithSilencer = new Silencer(rifle);
        System.out.println("\nSilencer (noise): " + rifleWithSilencer.noise());
        System.out.println("Silencer (bullets): " + rifleWithSilencer.bullets());

        Firearm rifleWithSilencerExtraCapacity = new Magazine(rifleWithSilencer);
        System.out.println("\nSilencer & Magazine (noise): " + rifleWithSilencerExtraCapacity.noise());
        System.out.println("Silencer & Magazine (bullets): " + rifleWithSilencerExtraCapacity.bullets());
    }

}
