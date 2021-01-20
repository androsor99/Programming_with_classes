package com.androsor.task4_2_5.utils;

import java.util.Scanner;

public class IOUserCommandFromConsole {

    public static String getStrFromConsole(String message) {

        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int getIntFromConsole() {

        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("введите число!");
            sc.next();
        }
        return sc.nextInt();
    }

    public static int getIntFromConsole(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("введите число!");
            sc.next();
        }
        return sc.nextInt();
    }

    public static long getLongFromConsole(String message) {

        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextLong()) {
            System.out.println("введите число!");
            sc.next();
        }
        return sc.nextLong();
    }
}
