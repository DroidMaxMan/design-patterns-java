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

package structural.proxy.example;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author alejandro
 *
 *  Proxy
 */
public class ImageProxy extends Graphic {

    /** Image **/
    private Image image;

    /**
     * Muestra una imagen. Sólo se carga una vez
     *
     * @return String
     */
    @Override
    public String display() {
        if (image == null) {
            image = new Image();
            image.load();
        }
        return image.display();
    }
}
