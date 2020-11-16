package com.androsor.prog_class.time;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Write a class description to represent time. Provide the ability to set the time and change its individual
 * fields (hour, minute, second) with checking the validity of entering values. In case of invalid field values,
 * the field is set to 0. Create methods for changing the time by the specified number of hours, minutes and seconds.
 */

public class TimeMain implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {

        GregorianCalendar timeD = new GregorianCalendar();

        SimpleTime time = new SimpleTime(timeD.get(Calendar.HOUR_OF_DAY), timeD.get(Calendar.MINUTE), timeD.get(Calendar.SECOND));
        System.out.printf("Текущее время: %s\n", time.toString());

        SimpleTime cloneTime1 = (SimpleTime) time.clone();
        SimpleTime cloneTime2 = (SimpleTime) time.clone();
        SimpleTime cloneTime3 = (SimpleTime) time.clone();

        int value = enterFromConsole("Введите количество вверх/вниз часов:\n-> ");
        cloneTime1.replaceHour(value);
        System.out.printf("Время после увеличения/уменьшения на %d-часов: %s\n",value, cloneTime1.toString());

        value = enterFromConsole("Введите количество вверх/вниз минут:\n-> ");
        cloneTime2.replaceMinute(value);
        System.out.printf("Время после увеличения/уменьшения на %d-минут: %s\n",value, cloneTime2.toString());

        value = enterFromConsole("Введите количество вверх/вниз секунд:\n-> ");
        cloneTime3.replaceSecond(value);
        System.out.printf("Время после увеличения/уменьшения на %d-секунд: %s\n",value, cloneTime3.toString());

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
