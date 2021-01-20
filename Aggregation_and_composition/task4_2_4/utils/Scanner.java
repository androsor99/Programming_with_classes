package com.androsor.task4_2_4.utils;

public interface Scanner {

    String getIdNewClient();
    String getFirstNameNewClient();
    String getSecondNameNewClient();
    long getNumberNewBankAccount();
    long getNumberCloseBankAccount();
    long getNumberBlockBankAccount();
    long getNumberPutTakeBankAccount();
    long getBankAccountAmountsRecharged(long number);
    long getNumberTransferStartBankAccount();
    long getNumberTransferEndBankAccount();
    long getBankAccountAmountsRechargedTransfer(long numberOne, long numberTwo);
    int getCommandNumberFromUser();

}
