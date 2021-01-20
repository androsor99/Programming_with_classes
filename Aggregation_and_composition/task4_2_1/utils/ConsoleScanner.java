package com.androsor.task4_2_1.utils;


import java.util.Scanner;

public class ConsoleScanner {

    public String getStrFromConsol() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public int getIntFromConsol() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("введите число!");
            sc.next();
        }
        return sc.nextInt();
    }


    public double getDoubleFromConsol() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            System.out.println("введите число!");
            sc.next();
        }
        return sc.nextDouble();
    }

}

//
//import java.util.Scanner;
//
//public class ScannerConsole {
//
//    public String getStrFromConsole() {
//        @SuppressWarnings("resource")
//        Scanner sc = new Scanner(System.in);
//        return sc.nextLine();
//    }
//
//    public int getIntFromConsole() {
//        @SuppressWarnings("resource")
//        Scanner sc = new Scanner(System.in);
//        while (!sc.hasNextInt()) {
//            System.out.println("Введенное значение не является числом. Повторите ввод.");
//            sc.next();
//        }
//        return sc.nextInt();
//    }
//
//    public double getDoubleFromConsole() {
//        @SuppressWarnings("resource")
//        Scanner sc = new Scanner(System.in);
//        while (!sc.hasNextDouble()) {
//            System.out.println("Введенное значение не является числом. Повторите ввод.");
//            sc.next();
//        }
//        return sc.nextDouble();
//    }
//}
