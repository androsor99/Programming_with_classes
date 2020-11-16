package com.androsor.prog_class.count;

public class PrintCounter {

    public static void printCount(CounterDecimal count) {
        System.out.printf("Текущее значение счетчика - %d\n", count.getValue());
    }

    public static void printCountTop(CounterDecimal count) {
        System.out.printf("Верхняя граница диапазона - %d\n", count.getValueMax());
    }

    public static void printCountBottom(CounterDecimal count) {
        System.out.printf("Нижняя граница диапазона - %d\n", count.getValueMin());
    }
    public static void printCountIncrement (CounterDecimal count) {
        System.out.printf("Значение счетчика-вверх - %d\n", count.getValue());
    }
    public static void printCountDecrement (CounterDecimal count) {
        System.out.printf("Значение счетчика-вниз - %d\n", count.getValue());
    }

}
