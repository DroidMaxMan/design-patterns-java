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

package patterns.behavioral.chain.example2;

import java.util.Random;

class Handler {

    private static final Random RANDOM = new Random();
    private static int nextID = 1;
    private int id = nextID++;
    private Handler nextInChain;

    void add(Handler next) {
        if (nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    void wrapAround(Handler root) {
        if (nextInChain == null) {
            nextInChain = root;
        } else {
            nextInChain.wrapAround(root);
        }
    }

    void execute(int num) {
        if (RANDOM.nextInt(4) != 0) {
            System.out.println("   " + id + "-busy  ");
            nextInChain.execute(num);
        } else {
            System.out.println(id + "-handled-" + num);
        }
    }

}
