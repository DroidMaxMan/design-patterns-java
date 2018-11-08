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

package patterns.behavioral.observer;

import patterns.behavioral.observer.example.ConcreteObserver;
import patterns.behavioral.observer.example.Observable;

public class Observer {

    public static void main(String[] args) {

        Observable observable = new Observable();

        ConcreteObserver concreteObserver = new ConcreteObserver("UA4844");
        ConcreteObserver concreteObserver2 = new ConcreteObserver("CG9840");
        ConcreteObserver concreteObserver3 = new ConcreteObserver("YR3089");

        observable.agregarObservador(concreteObserver);
        observable.agregarObservador(concreteObserver2);
        observable.agregarObservador(concreteObserver3);

        observable.notificarObservadores();

        observable.eliminarObservador(concreteObserver);

        observable.notificarObservadores();

    }
}
