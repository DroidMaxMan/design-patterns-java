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

package creational.abstractFactory.example;

import creational.abstractFactory.example.Archer;
import creational.abstractFactory.example.Rider;

/**
 * Project Learning_Design_Patterns_Java
 * @author alejandro
 * Date 19/09/15
 */
public interface SoldierFactory {

    //Abstract method
    Archer makeArcher();

    //Abstract method
    Rider makeRider();
}
