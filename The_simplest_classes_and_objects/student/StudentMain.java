package com.androsor.prog_class.student;

import static com.androsor.prog_class.student.Student.printExcellentStudent;

/**
 * Create a class named Student that contains the following fields: last name and initials, group number,
 * grade (five-element array). Create an array of ten elements of this type. Add the ability to display
 * the names and numbers of groups of students with grades of only 9 or 10.
 */

public class StudentMain {

    public static void main(String[] args) {

        Student [] students = new Student[10];

        students[0] = new Student("Первый А.А.", 1,  new int[]{9, 9, 8, 10, 9});
        students[1] = new Student("Второй Б.Б.", 2, new int[]{9, 8, 8, 10, 9});
        students[2] = new Student("Третий В.В.", 3, new int[]{4, 5, 7, 10, 6});
        students[3] = new Student("Четвертый Г.Г.", 4, new int[]{10, 10, 10, 10, 10});
        students[4] = new Student("Пятый Д.Д.", 5, new int[]{7, 6, 8, 7, 9});
        students[5] = new Student("Шестой И.И.", 6, new int[]{9, 9, 10, 10, 9});
        students[6] = new Student("Седьмой М.М.", 7, new int[]{9, 9, 8, 10, 9});
        students[7] = new Student("Восьмой К.К.", 8, new int[]{3, 6, 5, 7, 4});
        students[8] = new Student("Девятый Л.Л.", 9, new int[]{7, 9, 8, 7, 9});
        students[9] = new Student("Горбатый Ж.Ж.", 10, new int[]{10, 9, 9, 10, 9});

        printExcellentStudent(students);
    }
}
