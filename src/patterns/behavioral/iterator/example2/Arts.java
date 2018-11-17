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

class Arts implements ISubject {

    private String[] subjects;

    Arts() {
        subjects = new String[2];
        subjects[0] = "Bengali";
        subjects[1] = "English";
    }

    @Override
    public IIterator createIterator() {
        return new ArtsIterator(subjects);
    }

    //Containing the ArtsIterator
    public class ArtsIterator implements IIterator {

        private String[] subjects;
        private int position;

        ArtsIterator(String[] subjects) {
            this.subjects = subjects;
            position = 0;
        }

        @Override
        public void first() {
            position = 0;
        }

        @Override
        public String next() {
            return subjects[position++];
        }

        @Override
        public Boolean isDone() {
            return position >= subjects.length;
        }

        @Override
        public String currentItem() {
            return subjects[position];
        }

    }

}
