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

package patterns.behavioral.iterator.example2;

import java.util.LinkedList;

class Science implements ISubject {

    private LinkedList<String> subjects;

    Science() {
        subjects = new LinkedList<>();
        subjects.addLast("Maths");
        subjects.addLast("Comp. Sc.");
        subjects.addLast("Physics");
    }

    @Override
    public IIterator createIterator() {
        return new ScienceIterator(subjects);
    }

    //Containing the ScienceIterator
    public class ScienceIterator implements IIterator {

        private LinkedList<String> subjects;
        private int position;

        ScienceIterator(LinkedList<String> subjects) {
            this.subjects = subjects;
            position = 0;
        }

        @Override
        public void first() {
            position = 0;
        }

        @Override
        public String next() {
            return subjects.get(position++);
        }

        @Override
        public Boolean isDone() {
            return position >= subjects.size();
        }

        @Override
        public String currentItem() {
            return subjects.get(position);
        }

    }

}
