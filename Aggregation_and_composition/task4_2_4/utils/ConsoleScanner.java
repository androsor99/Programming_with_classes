package com.androsor.task4_2_4.utils;

public class ConsoleScanner implements Scanner {

    public String getIdNewClient() {
        return  IOUserCommandFromConsole.getStrFromConsole("Введите id клиента:\n");
    }

    public String getFirstNameNewClient() {
        return  IOUserCommandFromConsole.getStrFromConsole("Введите имя клиента:\n");
    }

    public String getSecondNameNewClient() {
        return  IOUserCommandFromConsole.getStrFromConsole("Введите фамилию клиента:\n");
    }

    public long getNumberNewBankAccount() {
        return  IOUserCommandFromConsole.getLongFromConsole("Введите номер нового счёта:\n");
    }

    public long getNumberCloseBankAccount() {
        return  IOUserCommandFromConsole.getLongFromConsole("Введите номер закрываемого счёта:\n");
    }

    public long getNumberBlockBankAccount() {
        return  IOUserCommandFromConsole.getLongFromConsole("Введите номер счёта, который вы хотите блокировать/разблокировать:\n");
    }

    public long getNumberPutTakeBankAccount() {
        return  IOUserCommandFromConsole.getLongFromConsole("Введите номер счёта, с которого/который Вы хотите снять/пополнить средства:\n");
    }
    public long getBankAccountAmountsRecharged(long number) {
        return  IOUserCommandFromConsole.getLongFromConsole(String.format("Введите сумму средств, которую вы хотите снять/пополнить на счёт номер \"%s\"\n",
                number));
    }

    public long getNumberTransferStartBankAccount() {
        return  IOUserCommandFromConsole.getLongFromConsole("Введите номер счёта, с которого вы хотите перевести средства:\n");
    }

    public long getNumberTransferEndBankAccount() {
        return  IOUserCommandFromConsole.getLongFromConsole("Введите номер счёта, на который вы хотите перевести средства:\n");
    }

    public long getBankAccountAmountsRechargedTransfer(long numberOne, long numberTwo) {
        return  IOUserCommandFromConsole.getLongFromConsole(String.format("Введите сумму средств, которую вы хотите перевести со счёта номер \"%s\" на счёт номер \"%s\"\n",
                numberOne, numberTwo));
    }

    public int getCommandNumberFromUser() {
        return IOUserCommandFromConsole.getIntFromConsole();
    }

}
