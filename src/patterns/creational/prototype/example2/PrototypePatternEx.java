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

package patterns.creational.prototype.example2;

public class PrototypePatternEx {

    public static void main(String[] args) throws CloneNotSupportedException {
        BasicCar chevrolet = new Nano("Green Nano");
        chevrolet.price = 100000;

        BasicCar ford = new Ford("Ford Yellow");
        ford.price = 500000;

        BasicCar bc1;
        //Clone Nano Object
        bc1 = chevrolet.clone();
        //Price will be more than 100000 for sure
        bc1.price = chevrolet.price + BasicCar.setPrice();
        System.out.println("Car is: " + bc1.modelname + " and it's price is Rs." + bc1.price);

        //Clone Ford Object
        bc1 = ford.clone();
        //Price will be more than 500000 for sure
        bc1.price = ford.price + BasicCar.setPrice();
        System.out.println("Car is: " + bc1.modelname + " and it's price is Rs." + bc1.price);
    }

}
