package com.androsor.task4_2_4.main;

import java.util.Arrays;
import java.util.List;

public enum TypeCommand {

    OPEN_BANK_ACCOUNT(1),
    CLOSE_BANK_ACCOUNT(2),
    BLOCK_BANK_ACCOUNT(3),
    CHANGING_BANK_ACCOUNT_BALANCE(4),
    TRANSFER_OF_FUNDS_TO_THE_BANK_ACCOUNT(5),
    INFO_BANK_ACCOUNT_BALANCE(6),
    SORTING_BANK_ACCOUNT(7),
    SHOWING_ALL_BANK_ACCOUNT(8),
    EXIT_PROGRAM(0),

    CASE_BLOCK_BANK_ACCOUNT_BLOCKED(1),
    CASE_BLOCK_BANK_ACCOUNT_UNBLOCKED(2),

    CASE_CHANGING_BANK_ACCOUNT_BALANCE_PUT(2),
    CASE_CHANGING_BANK_ACCOUNT_BALANCE_TAKE(1),

    CASE_INFO_BANK_ACCOUNT_BALANCE_ALL(1),
    CASE_INFO_BANK_ACCOUNT_BALANCE_POSITIVE(2),
    CASE_INFO_BANK_ACCOUNT_BALANCE_NEGATIVE(3),

    CASE_SORTING_BANK_ACCOUNT_BALANCE(1),
    CASE_SORTING_BANK_ACCOUNT_BY_NUMBER(2),
    CASE_SORTING_BANK_ACCOUNT_DATE_CREATE(3);

    private final int code;

    public static List<TypeCommand> sortingCommands = Arrays.asList(
            OPEN_BANK_ACCOUNT,
            CLOSE_BANK_ACCOUNT,
            BLOCK_BANK_ACCOUNT,
            CHANGING_BANK_ACCOUNT_BALANCE,
            TRANSFER_OF_FUNDS_TO_THE_BANK_ACCOUNT,
            INFO_BANK_ACCOUNT_BALANCE,
            SORTING_BANK_ACCOUNT,
            SHOWING_ALL_BANK_ACCOUNT,
            EXIT_PROGRAM);

    TypeCommand(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TypeCommand getTypeCommandByCode(int code) {

        for (TypeCommand command : TypeCommand.values()) {
            if (command.getCode() == code) {
                return command;
            }
        }
        return null;
    }
}
