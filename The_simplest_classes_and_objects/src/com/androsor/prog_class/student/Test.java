package com.androsor.prog_class.student;

import static com.androsor.prog_class.student.CreateHelper.getAcademicPerformance;
import static com.androsor.prog_class.student.IOHelper.printListStudents;

/**
 * Create a class named Student that contains the following fields: last name and initials, group number,
 * grade (five-element array). Create an array of ten elements of this type. Add the ability to display
 * the names and numbers of groups of students with grades of only 9 or 10.
 */
public class Test {

    public static void main(String[] args) {

        Student[] students = new Student[10];

        students[0] = new Student("Первый А.А.", 1,  getAcademicPerformance(5));
        students[1] = new Student("Второй Б.Б.", 2, getAcademicPerformance(5));
        students[2] = new Student("Третий В.В.", 3, getAcademicPerformance(5));
        students[3] = new Student("Четвертый Г.Г.", 4, getAcademicPerformance(5));
        students[4] = new Student("Пятый Д.Д.", 5, getAcademicPerformance(5));
        students[5] = new Student("Шестой И.И.", 6, getAcademicPerformance(5));
        students[6] = new Student("Седьмой М.М.", 7, getAcademicPerformance(5));
        students[7] = new Student("Восьмой К.К.", 8, getAcademicPerformance(5));
        students[8] = new Student("Девятый Л.Л.", 9, getAcademicPerformance(5));
        students[9] = new Student("Горбатый Ж.Ж.", 10, new int[]{10, 9, 9, 10, 9});
        printListStudents(students);

        printExcellentStudent(students, 9);
    }

    public static void printExcellentStudent(Student[] students, int minProgress) {
        for (Student student : students) {
            boolean isBestStudent = true;
            for (int progress : student.getProgress()) {
                if (progress < minProgress) {
                    isBestStudent = false;
                    break;
                }
            }
            if (isBestStudent) {
                System.out.println(student.toString());
            }
        }
    }
}
