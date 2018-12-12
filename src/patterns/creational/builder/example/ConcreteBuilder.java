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

package patterns.creational.builder.example;

class ConcreteBuilder implements Builder {

    private Product product;

    ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public Product build() {
        Product product = new Product();
        product.setColor(this.product.getColor());
        product.setName(this.product.getName());
        return product;
    }

    @Override
    public ConcreteBuilder setColor(final String color) {
        product.setColor(color);
        return this;
    }

    @Override
    public ConcreteBuilder setName(final String name) {
        product.setName(name);
        return this;
    }

}
