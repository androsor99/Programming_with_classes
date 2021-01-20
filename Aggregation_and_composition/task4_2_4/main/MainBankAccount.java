package com.androsor.task4_2_4.main;

import com.androsor.task4_2_4.entity.Client;
import com.androsor.task4_2_4.error.BankAccountException;
import com.androsor.task4_2_4.logic.ClientLogic;
import com.androsor.task4_2_4.utils.ConsoleScanner;
import com.androsor.task4_2_4.utils.Scanner;
import com.androsor.task4_2_4.view.Viewer;
import static com.androsor.task4_2_4.main.TypeCommand.*;

/**
 * Accounts. A customer can have several bank accounts. Consider the possibility of blocking / unblocking an account.
 * Implement invoice search and sorting. Calculation of the total amount of accounts. Calculation of the amount for all
 * accounts with positive and negative balances separately.
 */

public class MainBankAccount {

    private static final Scanner consoleScanner = new ConsoleScanner();
    private static final Viewer viewer = new Viewer();
    private static Client client = null;
    private static ClientLogic clientLogic = new ClientLogic();

    public static void main(String[] args) {

        TypeCommand typeUserCommand;

        while (client == null) {
            viewer.showMessageCreateNewClient();
            client = clientLogic.createNewClient(consoleScanner);
            clientLogic = new ClientLogic(client);
            viewer.showMessageAddingNewClient(client);
        }

        do {
            viewer.showTypeCommand();
            typeUserCommand = selectTypeUserCommand();

            if (!sortingCommands.contains(typeUserCommand)) {
                viewer.showMessageAboutInvalidCommand();
            } else {
                try {
                    processUserCommand(typeUserCommand);
                } catch (BankAccountException ex) {
                    System.err.print(ex.getMessage());
                }
            }
        } while (typeUserCommand != EXIT_PROGRAM);
    }

    public static TypeCommand selectTypeUserCommand() {
        return getTypeCommandByCode(consoleScanner.getCommandNumberFromUser());
    }

    public static void processUserCommand(final TypeCommand typeCommand) throws BankAccountException {

        if (typeCommand != OPEN_BANK_ACCOUNT) {
            Validator.checkTheClientIsBankAccounts(client);
        }

        switch (typeCommand) {

            case OPEN_BANK_ACCOUNT -> {

                long numberOpen = consoleScanner.getNumberNewBankAccount();
                clientLogic.openNewBankAccount(numberOpen);
                viewer.showMessageOpenNewBankAccount(numberOpen);
            }

            case CLOSE_BANK_ACCOUNT -> {

                long numberClose = consoleScanner.getNumberCloseBankAccount();
                Validator.checkTheExistenceOfABankAccountWithTheGivenNumber(numberClose, clientLogic);
                clientLogic.closeBankAccountByNumber(numberClose);
                viewer.showMessageCloseBankAccount(numberClose);
            }

            case BLOCK_BANK_ACCOUNT -> {

                long numberBlockOrUnblock = consoleScanner.getNumberBlockBankAccount();
                Validator.checkTheExistenceOfABankAccountWithTheGivenNumber(numberBlockOrUnblock, clientLogic);
                viewer.showTypeCommandForBlockBankAccount(numberBlockOrUnblock);
                processUserCommandBlockBankAccount(numberBlockOrUnblock);
            }

            case CHANGING_BANK_ACCOUNT_BALANCE -> {

                long numberPutTake = consoleScanner.getNumberPutTakeBankAccount();
                Validator.checkTheExistenceOfABankAccountWithTheGivenNumber(numberPutTake, clientLogic);
                long sumPutTake = consoleScanner.getBankAccountAmountsRecharged(numberPutTake);
                viewer.showTypeCommandForChangBankAccountBalance(sumPutTake, clientLogic.findBankAccountByNumber(numberPutTake));
                processUserCommandChangingBankAccount(numberPutTake, sumPutTake);
            }

            case TRANSFER_OF_FUNDS_TO_THE_BANK_ACCOUNT -> {

                long numberTransferStart = consoleScanner.getNumberTransferStartBankAccount();
                Validator.checkTheExistenceOfABankAccountWithTheGivenNumber(numberTransferStart, clientLogic);
                long numberTransferEnd = consoleScanner.getNumberTransferEndBankAccount();
                Validator.checkTheExistenceOfABankAccountWithTheGivenNumber(numberTransferEnd, clientLogic);
                long sumTransfer = consoleScanner.getBankAccountAmountsRechargedTransfer(numberTransferStart, numberTransferEnd);
                clientLogic.transferMoneyFromBankAccounts(sumTransfer, clientLogic.findBankAccountByNumber(numberTransferStart),
                        clientLogic.findBankAccountByNumber(numberTransferEnd));
                viewer.showMessageTransferBankAccount();
            }

            case INFO_BANK_ACCOUNT_BALANCE -> {

                viewer.showTypeCommandForShowingBankAccountBalance();
                processUserCommandShowInfoBankAccount();
            }

            case SORTING_BANK_ACCOUNT -> {

                viewer.showTypeCommandForSortingBankAccount();
                processUserCommandSortingInfoBankAccount();
                viewer.showAllClientsBankAccounts(client);
            }
            case SHOWING_ALL_BANK_ACCOUNT -> viewer.showAllClientsBankAccounts(client);
        }
    }

    public static void processUserCommandBlockBankAccount(final long number) throws BankAccountException {

        int userCommandCase = consoleScanner.getCommandNumberFromUser();
        if (userCommandCase == CASE_BLOCK_BANK_ACCOUNT_BLOCKED.getCode()) {
            clientLogic.blockBankAccount(clientLogic.findBankAccountByNumber(number));
            viewer.showMessageStateBlockBankAccount(number);
        } else {
            if (userCommandCase == CASE_BLOCK_BANK_ACCOUNT_UNBLOCKED.getCode()) {
                clientLogic.unblockBankAccount(clientLogic.findBankAccountByNumber(number));
                viewer.showMessageStateUnBlockBankAccount(number);
            }
        }
    }

    public static void processUserCommandChangingBankAccount(final long number, final long sum) throws BankAccountException {

        int userCommandCase = consoleScanner.getCommandNumberFromUser();
        if (userCommandCase == CASE_CHANGING_BANK_ACCOUNT_BALANCE_PUT.getCode()) {
            clientLogic.addMoneyBankAccount(sum, clientLogic.findBankAccountByNumber(number));
            viewer.showMessageAddMoneyBankAccount(clientLogic.findBankAccountByNumber(number), sum);
        } else {
            if (userCommandCase == CASE_CHANGING_BANK_ACCOUNT_BALANCE_TAKE.getCode()) {
                clientLogic.removeMoneyBankAccount(sum, clientLogic.findBankAccountByNumber(number));
                viewer.showMessageRemoveMoneyBankAccount(clientLogic.findBankAccountByNumber(number), sum);
            }
        }
    }

    public static void processUserCommandShowInfoBankAccount() {

        int userCommandCase = consoleScanner.getCommandNumberFromUser();
        if (userCommandCase == CASE_INFO_BANK_ACCOUNT_BALANCE_ALL.getCode()) {
            viewer.showTotalBalanceBankAccount(clientLogic.calculateTotalBalanceAllBankAccounts());
        }
        if (userCommandCase == CASE_INFO_BANK_ACCOUNT_BALANCE_POSITIVE.getCode()) {
            viewer.showPositiveBalanceBankAccount(clientLogic.calculateTotalBalanceAllPositiveBankAccounts());
        } else {
            if (userCommandCase == CASE_INFO_BANK_ACCOUNT_BALANCE_NEGATIVE.getCode()) {
                viewer.showNegativeBalanceBankAccount(clientLogic.calculateTotalBalanceAllNegativeBankAccounts());
            }
        }
    }

    public static void processUserCommandSortingInfoBankAccount() {

        int userCommandCase = consoleScanner.getCommandNumberFromUser();
        if (userCommandCase == CASE_SORTING_BANK_ACCOUNT_BALANCE.getCode()) {
            clientLogic.sortBankAccountsByBalance();
            viewer.showMessageSortBankAccountsByBalance();
        }
        if (userCommandCase == CASE_SORTING_BANK_ACCOUNT_BY_NUMBER.getCode()) {
            clientLogic.sortBankAccountsByNumber();
            viewer.showMessageSortBankAccountsByNumber();
        } else {
            if (userCommandCase == CASE_SORTING_BANK_ACCOUNT_DATE_CREATE.getCode()) {
                clientLogic.sortBankAccountsByDate();
                viewer.showMessageSortBankAccountsByDate();
            }
        }
    }
}