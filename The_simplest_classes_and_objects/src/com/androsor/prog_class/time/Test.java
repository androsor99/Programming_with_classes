package com.androsor.prog_class.time;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.androsor.prog_class.train.IOHelper.enterFromConsoleInt;

/**
 * Write a class description to represent time. Provide the ability to set the time and change its individual
 * fields (hour, minute, second) with checking the validity of entering values. In case of invalid field values,
 * the field is set to 0. Create methods for changing the time by the specified number of hours, minutes and seconds.
 */
public class Test implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        SimpleTime time = new SimpleTime(gregorianCalendar.get(Calendar.HOUR_OF_DAY), gregorianCalendar.get(Calendar.MINUTE), gregorianCalendar.get(Calendar.SECOND));
        System.out.printf("Текущее время: %s\n", time.toString());

        SimpleTime cloneTime = (SimpleTime) time.clone();

        int value = enterFromConsoleInt("Введите количество вверх/вниз часов:\n-> ");
        cloneTime.replaceHour(value);
        System.out.printf("Время после увеличения/уменьшения на %d - часов: %s\n",value, cloneTime.toString());

        value = enterFromConsoleInt("Введите количество вверх/вниз минут:\n-> ");
        cloneTime.replaceMinute(value);
        System.out.printf("Время после увеличения/уменьшения на %d - минут: %s\n",value, cloneTime.toString());

        value = enterFromConsoleInt("Введите количество вверх/вниз секунд:\n-> ");
        cloneTime.replaceSecond(value);
        System.out.printf("Время после увеличения/уменьшения на %d - секунд: %s\n",value, cloneTime.toString());

    }
}
