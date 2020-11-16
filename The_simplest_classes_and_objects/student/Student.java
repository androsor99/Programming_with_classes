package com.androsor.prog_class.student;

import java.util.Arrays;

public class Student {

    private final String fullName;
    private final int group;
    private final int [] progress;



    public Student(String fullName, int group, int[] progress) {
        this.fullName = fullName;
        this.group = group;
        this.progress = progress;
    }



    public static void printExcellentStudent(Student [] students) {

        for (Student student : students) {
            int minProgress = 10;

            for (int progress : student.progress) {

                if (progress < minProgress) {
                    minProgress = progress;
                }
            }

            if (minProgress >= 9) {

                System.out.printf("Студент отличник: %s, группа - №%d; успеваемость: %s \n", student.fullName, student.group, Arrays.toString(student.progress));
            }
        }
    }
}
