package collections;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {

        /**
         * Collection of objects
         * By explicitly stating the 'type' is called Generics (below)
         * Collection<Integer> values = new ArrayList<Integer>();
         */

        Collection values = new ArrayList();
        values.add(1);
        values.add(8.9f);
        values.add("Jesse");


        //Iterate using iterator or forEach
//        Iterator i = values.iterator();
//        while(i.hasNext()) {
//            System.out.println(i.next());
//        }

        System.out.println("List of objects in Collection:");
        for (Object val : values) {
            System.out.println(val);
        }

        /**
         * If you're wanting to specify an index to add an element or sort, use List
         */
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(212);
        list.add(0, 13);
        list.add(999);
        Collections.sort(list);

        System.out.println("\nValues in list(sorted): ");
//        for (int num : list) {
//            System.out.println(num);
//        }

        list.forEach(System.out::println); // Stream API, uses Lambda expression

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 55));
        students.add(new Student(2, 95));
        students.add(new Student(3, 85));
        students.add(new Student(4, 70));
        students.add(new Student(5, 85));

        //Using comparator to sort students, you can also implement Comparable
        Collections.sort(students, (s1, s2) -> {
            if (s1.grades > s2.grades) {
                return -1;
            }
            if (s1.grades < s2.grades) {
                return 1;
            }
            return 0;
        });

        System.out.println("\nList of students sorted by grades:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

class Student {
    int studID;
    int grades;

    public Student(int studID, int grades) {
        this.studID = studID;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studID=" + studID +
                ", grades=" + grades +
                '}';
    }
}

