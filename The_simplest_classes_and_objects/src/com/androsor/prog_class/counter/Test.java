package com.androsor.prog_class.counter;

import static com.androsor.prog_class.counter.IOHelper.enterFromConsole;
import static com.androsor.prog_class.counter.IOHelper.printCounterTest;

/**
 * Describe a class that implements a decimal counter that can increment or decrement its value by one within a specified range.
 * Provide for initialization of the counter with default values and arbitrary values.
 * The counter has methods for increasing and decreasing state, and a method for getting its current state.
 * Write code that demonstrates all the capabilities of the class.
 */
public class Test {

    public static void main(String [] args) {
        CounterDecimal countDefault = new CounterDecimal();
        CounterDecimal countFirst = new CounterDecimal(100, 3, 1000);

        printCounterTest(countDefault);
        printCounterTest(countFirst);

        int iteration = enterFromConsole("Введите число проходов для проверки: \n-> ");
        testCountDecimal(countDefault, iteration, true);
        testCountDecimal(countFirst, iteration, true);

        testCountDecimal(countDefault, iteration, false);
        testCountDecimal(countFirst, iteration, false);
    }

    private static void testCountDecimal(CounterDecimal count, int iteration, boolean selector) {
        try {
            for (int i = 0; i < iteration; i++) {
                if (selector) {
                    count.decrease();
                } else {
                    count.increase();
                }
            }
            printCounterTest(count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
