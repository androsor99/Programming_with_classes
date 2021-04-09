package com.androsor.prog_class.student;

public class IOHelper {

    public static void printListStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
