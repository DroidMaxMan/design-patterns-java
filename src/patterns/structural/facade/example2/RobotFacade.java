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

package patterns.structural.facade.example2;

class RobotFacade {

    private RobotColor rc;
    private RobotMetal rm;
    private RobotBody rb;

    RobotFacade() {
        rc = new RobotColor();
        rm = new RobotMetal();
        rb = new RobotBody();
    }

    void robotBuilder(String color, String metal) {
        System.out.println("\nCreation of the Robot Start");
        rc.setColor(color);
        rm.setMetal(metal);
        rb.createBody();
        System.out.println("Robot Creation End");
        System.out.println();
    }

}
