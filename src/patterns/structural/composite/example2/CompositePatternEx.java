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

import java.util.List;

class CompositePatternEx {

    public static void main(String[] args) {
        Teacher principal = new Teacher("Dr.S.Som", "Principal");
        Teacher hodMaths = new Teacher("Mrs.S.Das", "Hod-Math");
        Teacher hodCompSc = new Teacher("Mr. V.Sarcar", "Hod-ComputerSc.");
        Teacher mathTeacher1 = new Teacher("Math Teacher-1", "MathsTeacher");
        Teacher mathTeacher2 = new Teacher("Math Teacher-2", "MathsTeacher");
        Teacher cseTeacher1 = new Teacher("CSE Teacher-1", "CSETeacher");
        Teacher cseTeacher2 = new Teacher("CSE Teacher-2", "CSETeacher");
        Teacher cseTeacher3 = new Teacher("CSE Teacher-3", "CSETeacher");
        //Principal is on top of college
        /*HOD -Maths and Comp. Sc. directly reports to him*/
        principal.add(hodMaths);
        principal.add(hodCompSc);
        /*Teachers of Mathematics directly reports to HOD-Maths*/
        hodMaths.add(mathTeacher1);
        hodMaths.add(mathTeacher2);
        /*Teachers of Computer Sc. directly reports to HOD-Comp.Sc.*/
        hodCompSc.add(cseTeacher1);
        hodCompSc.add(cseTeacher2);
        hodCompSc.add(cseTeacher3);
        /*Leaf nodes. There is no department under Mathematics*/
        mathTeacher1.add(null);
        mathTeacher2.add(null);

        /*Leaf nodes. There is no department under CSE.*/
        cseTeacher1.add(null);
        cseTeacher2.add(null);
        cseTeacher3.add(null);
        //Printing the details
        System.out.println("***COMPOSITE PATTERN DEMO ***");
        System.out.println("\nThe college has following structure\n");
        System.out.println(principal.getDetails());
        List<ITeacher> hods = principal.getControllingDepts();
        for (ITeacher hod : hods) {
            System.out.println("\t" + hod.getDetails());
        }
        List<ITeacher> mathTeachers = hodMaths.getControllingDepts();
        for (ITeacher mathTeacher : mathTeachers) {
            System.out.println("\t\t" + mathTeacher.getDetails());
        }
        List<ITeacher> cseTeachers = hodCompSc.getControllingDepts();
        for (ITeacher cseTeacher : cseTeachers) {
            System.out.println("\t\t" + cseTeacher.getDetails());
        }
        //One computer teacher is leaving
        hodCompSc.remove(cseTeacher2);
        System.out.println("\n After CSE Teacher-2 leaving the organization- CSE department has following employees:");
        cseTeachers = hodCompSc.getControllingDepts();
        for (ITeacher cseTeacher : cseTeachers) {
            System.out.println("\t\t" + cseTeacher.getDetails());
        }
    }

}
