package com.androsor.prog_class.count;

import java.util.Scanner;

import static com.androsor.prog_class.count.PrintCounter.*;
import static com.androsor.prog_class.count.TestCounter.*;


/**
 * Describe a class that implements a decimal counter that can increment or decrement its value by one within a specified range.
 * Provide for initialization of the counter with default values and arbitrary values.
 * The counter has methods for increasing and decreasing state, and a method for getting its current state.
 * Write code that demonstrates all the capabilities of the class.
 */

public class CountMain {

    public static void main(String [] args){

        CounterDecimal countDefault = new CounterDecimal();
        System.out.print("Тест счетчика со значениями по умолчанию.\n-------------------------------\n");
        int i = enterFromConsole("Введите число проходов для проверки: \n-> ");
        setNumberOfCycle(i);
        testingCount(countDefault);

        System.out.print("Тест счетчика с заданными значениями.\n-------------------------------\n");
        System.out.println("Введите значение счетчика и его диапазона работы (последовательность не важна)");
        int temp1 = enterFromConsole("-> ");
        int temp2 = enterFromConsole("-> ");
        int temp3 = enterFromConsole("-> ");
        CounterDecimal countFirst = new CounterDecimal(temp1,temp2,temp3);
        i = enterFromConsole("Введите число проходов для проверки: \n-> ");
        setNumberOfCycle(i);
        testingCount(countFirst);
    }

    public static void testingCount(CounterDecimal count){

        printCount(count);
        printCountTop(count);
        printCountBottom(count);

        testingIncrease(count);
        printCountIncrement(count);

        testingDecrease(count);
        printCountDecrement(count);
        System.out.println("--------------------------------------");
    }

    public static int enterFromConsole(String message) {

        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.print("Введенное значение не является числом. Повторите ввод:\n-> ");

            sc.next();
        }
        return sc.nextInt();
    }
}
