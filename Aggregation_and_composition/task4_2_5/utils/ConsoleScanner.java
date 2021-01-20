package com.androsor.task4_2_5.utils;

public class ConsoleScanner implements Scanner {

    public String getTypeTour() {
        return  IOUserCommandFromConsole.getStrFromConsole("Выберите тип тура:\n");
    }

    public String getCommandSelectByCountry() {
        return  IOUserCommandFromConsole.getStrFromConsole("Укажите желаемую страну для тура:\n");
    }

    public int getCommandNumberFromUser() {
        return IOUserCommandFromConsole.getIntFromConsole();
    }

    public int getCommandSelectByPrice() {
        return IOUserCommandFromConsole.getIntFromConsole("Введите желаемую стоимость тура (не более):\n");
    }

    public int getCommandSelectByDays() {
        return IOUserCommandFromConsole.getIntFromConsole("Введите желаемое количество дней (не более):\n");
    }

    public String getCommandSelectByTransport() {
        return IOUserCommandFromConsole.getStrFromConsole("Выберите желаемый вид транспорта:\n");
    }
}
