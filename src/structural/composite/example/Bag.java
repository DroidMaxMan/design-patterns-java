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

package structural.composite.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author alejandro
 */
public class Bag extends Item {

    /**
     * Lista que contiene otros items
     */
    private List<Item> bag = new ArrayList<>();

    @Override
    public void value() {
        super.value();
    }

    @Override
    public void description() {
        super.description();
    }

    /**
     * Añadir un item a la lista
     * @param item to add
     */
    public void addItem(Item item) {
        bag.add(item);
    }

    /**
     * Return true deleted item
     */
    public boolean removeItem(Item item) {
        return bag.contains(item) && bag.remove(item);
    }
}
