package com.androsor.prog_class.test1;

import static com.androsor.prog_class.test1.IOUtils.printToConsole;

/**
 * Create class Test1 with two variables. Add a display method and methods for modifying these variables.
 * Add a method that finds the sum of the values of these variables, and a method that finds the largest value of
 * these two variables.
 */
public class Runner {

    private static final String NUMBER_ONE_MESSAGE = "Первое число = ";
    private static final String NUMBER_TWO_MESSAGE = "Второе число = ";
    private static final String SUM_OF_NUMBERS_MESSAGE = "Сумма чисел = ";
    private static final String LARGEST_OF_NUMBERS_MESSAGE= "Наибольшее из чисел = ";

    public static void main(String[] args) {

        Test1 test1 = new Test1(9.78, 45.23);

        printToConsole(NUMBER_ONE_MESSAGE, test1.getNumberOne());
        printToConsole(NUMBER_TWO_MESSAGE, test1.getNumberTwo());
        printToConsole(SUM_OF_NUMBERS_MESSAGE, test1.getSumNumber());
        printToConsole(LARGEST_OF_NUMBERS_MESSAGE, test1.getMaxNumber());
    }
}
