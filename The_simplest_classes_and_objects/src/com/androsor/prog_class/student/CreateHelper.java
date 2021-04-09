package com.androsor.prog_class.student;

import java.util.Random;

public class CreateHelper {

    public static int[]  getAcademicPerformance(int length) {
        int[] grades = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            grades[i] = (random.nextInt(9) + 2);
        }
        return grades;
    }
}
