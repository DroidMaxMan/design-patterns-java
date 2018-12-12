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

public class Director {

    private Builder builder;

    private Director(final Builder builder) {
        this.builder = builder;
    }

    public static void main(final String ... arguments) {
        final Builder builder = new ConcreteBuilder();

        final Director director = new Director(builder);

        System.out.println(director.construct());
    }

    private Product construct() {
        return builder.setName("ProductA")
                .setColor("Red")
                .build();
    }

}
