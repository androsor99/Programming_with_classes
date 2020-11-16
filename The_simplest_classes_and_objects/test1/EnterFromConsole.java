package com.androsor.prog_class.test1;

import java.util.Scanner;

public class EnterFromConsole {

    public static double enterFromConsole(String massage) {

        System.out.print(massage);

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextDouble()) {

            System.out.println("Введенное значение не является числом. Повторите ввод");

            sc.next();
        }
        return sc.nextDouble();
    }
}
