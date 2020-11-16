package com.androsor.prog_class.test1;

import static com.androsor.prog_class.test1.EnterFromConsole.*;

/**
 * Create class Test1 with two variables. Add a display method and methods for modifying these variables.
 * Add a method that finds the sum of the values of these variables, and a method that finds the largest value of
 * these two variables.
 */

public class MainTest1 {

    public static void main(String[] args) {

        double num1 = enterFromConsole("Введите первое число = ");
        double num2 = enterFromConsole("Введите второе число = ");

        Test1 test1 = new Test1();

        test1.setNumber1(num1);
        test1.setNumber2(num2);

        System.out.println(test1.getNumber1());
        System.out.println(test1.getNumber2());

        test1.showNumber();

        test1.sumNumber();

        test1.maxNumber(num1, num2);

    }
}
