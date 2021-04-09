package com.androsor.prog_class.counter;

import java.util.Scanner;

public class IOHelper {

    public static int enterFromConsole(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.print("Введенное значение не является числом. Повторите ввод:\n-> ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void printCounterTest(CounterDecimal count) {
        System.out.printf("Текущее значение счетчика - %d\n", count.getValue());
        System.out.printf("Верхняя граница диапазона - %d\n", count.getValueMax());
        System.out.printf("Нижняя граница диапазона - %d\n", count.getValueMin());
        System.out.println("--------------------------------------");
    }
}