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

package patterns.behavioral.observer.example4;

import java.util.ArrayList;
import java.util.List;

class Subject1 implements ISubject {

    List<IObserver> observersList = new ArrayList<>();
    private int myValue;

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
        //Notify observers
        notifyObservers(myValue);
    }

    @Override
    public void register(IObserver o) {
        observersList.add(o);
    }

    @Override
    public void unregister(IObserver o) {
        observersList.remove(o);
    }

    @Override
    public void notifyObservers(int updatedValue) {
        for (IObserver iObserver : observersList) {
            iObserver.update(this.getClass().getSimpleName(),
                    updatedValue);
        }
    }

}
