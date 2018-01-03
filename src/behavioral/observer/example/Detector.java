/*
 * Copyright (c) 2018 @alxgcrz <alxgcrz@outlook.com>
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

package behavioral.observer.example;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
 *
 * Observador muy simple que ni siquiera consulta el estado del sujeto...
 */
public class Detector implements Observador {

    public void actualizar() {
        System.out.println( "Detector recibe actualizar!" );
    }

}
