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

package patterns.structural.composite.example2;

import java.util.ArrayList;
import java.util.List;

class Teacher implements ITeacher {

    private String teacherName;
    private String deptName;
    private List<ITeacher> controls;

    Teacher(String teacherName, String deptName) {
        this.teacherName = teacherName;
        this.deptName = deptName;
        controls = new ArrayList<>();
    }

    void add(Teacher teacher) {
        controls.add(teacher);
    }

    void remove(Teacher teacher) {
        controls.remove(teacher);
    }

    List<ITeacher> getControllingDepts() {
        return controls;
    }

    @Override
    public String getDetails() {
        return (teacherName + " is the " + deptName);
    }

}
