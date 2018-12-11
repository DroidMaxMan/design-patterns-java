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

package patterns.structural.adapter.example2;

/*Calculate the area of a Triangle using CalculatorAdapter. */
class CalculatorAdapter {

    double getArea(Triangle t) {
        Calculator calculator = new Calculator();
        Rect rect = new Rect();
        //Area of Triangle=0.5*base*height
        rect.height = t.base;
        rect.width = 0.5 * t.height;
        return calculator.getArea(rect);
    }

}
