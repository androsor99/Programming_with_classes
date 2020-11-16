package com.androsor.prog_class.test1;

import static java.lang.Double.max;

public class Test1 {

    private double number1;
    private double number2;

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public void showNumber() {

        System.out.printf("Исходные параметры: %.3f и %.3f \n", number1, number2);
    }

    public void sumNumber() {

        System.out.printf("Сумма исходных значений: %.3f \n", number1 + number2);
    }

    public void maxNumber(double number1, double number2) {

        if (number1 == number2) {

            System.out.println("Числа ровны между собой");

        } else {

            System.out.printf("Максимальное значение из двух чисел = %.3f", max(number1, number2));
        }
    }
}
