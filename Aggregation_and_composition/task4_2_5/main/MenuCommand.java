package com.androsor.task4_2_5.main;

import java.util.Arrays;
import java.util.List;

public enum MenuCommand {

    ALL_TOUR(1),
    TOURS_SELECT_BY_TYPE(2),
    TOURS_SELECT_BY_COUNTRY(3),
    TOURS_SELECT_BY_FOOD(4),
    TOURS_SELECT_BY_TRANSPORT(5),
    TOURS_SELECT_BY_PRICE(6),
    TOURS_SELECT_BY_DAYS(7),
    TOURS_SORT_BY_PRICE(8),
    TOURS_SORT_BY_DAYS(9),
    EXIT_PROGRAM(0),

    IS_FOOD_INCLUDED(1),
    IS_FOOD_NOT_INCLUDED(2);


    private final int code;

    MenuCommand(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static List<MenuCommand> sortingCommands = Arrays.asList(
            ALL_TOUR, TOURS_SELECT_BY_TYPE, TOURS_SELECT_BY_COUNTRY,
            TOURS_SELECT_BY_FOOD, TOURS_SELECT_BY_TRANSPORT, TOURS_SELECT_BY_PRICE,
            TOURS_SELECT_BY_DAYS, TOURS_SORT_BY_PRICE, TOURS_SORT_BY_DAYS,
            EXIT_PROGRAM);

    public static MenuCommand getCommandByCode(int code) {

        for (MenuCommand command : MenuCommand.values()) {
            if (command.getCode() == code) {
                return command;
            }
        }
        return null;
    }
}
