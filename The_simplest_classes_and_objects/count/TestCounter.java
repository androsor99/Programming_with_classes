package com.androsor.prog_class.count;

public class TestCounter {

    private static int numberOfCycle;

    public TestCounter() {
    }

    public static int getNumberOfCycle() {
        return Math.abs(numberOfCycle);
    }

    public static void setNumberOfCycle(int numberOfCycle) {
        TestCounter.numberOfCycle = numberOfCycle;
    }

    public static void testingIncrease(CounterDecimal count) {
        for (int i= 0; i < getNumberOfCycle(); i++) {
            if (count.getValue() == count.getValueMax()) {
                System.out.printf("Внимание. Произошло переполнение счетчика! Число проходов = %d\n", i);
                break;
            } else {
                count.increase();
            }
        }
    }

    public static void testingDecrease(CounterDecimal count) {
        for (int i= 0; i < getNumberOfCycle(); i++) {
            if (count.getValue() <= count.getValueMin()) {
                System.out.printf("Внимание! Достигнута нижняя граница дипазона! Число проходов = %d\n", i);
                break;
            } else {
                count.decrease();
            }
        }
    }
}
