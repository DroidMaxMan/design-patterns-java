/*
 * Copyright (c) 2016 @DroidMaxMan. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package structural.facade.example;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author DroidMaxMan
 *
 * Clase que se comunica con los módulos o clases de ejemplo
 */
public class Facade {

    /** MODULE_A **/
    private ModuleA moduleA;

    /** MODULE_B **/
    private ModuleB moduleB;

    /** MODULE_C **/
    private ModuleC moduleC;

    /**
     * Constructor
     */
    public Facade() {
        moduleA = new ModuleA();
        moduleB = new ModuleB();
        moduleC = new ModuleC();
    }

    /**
     * Get Info From Module A
     * @return Info
     */
    public String getInfoA() {
        return moduleA.getInfo();
    }

    /**
     * Get Info From Module B
     * @return Info
     */
    public String getInfoB() {
        return moduleB.getInfo();
    }

    /**
     * Get Info From Module C
     * @return Info
     */
    public String getInfoC() {
        return moduleC.getInfo();
    }
}
