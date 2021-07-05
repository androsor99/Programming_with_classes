package com.androsor.task4.main;

import com.androsor.task4.entity.Client;
import com.androsor.task4.error.BankAccountException;
import com.androsor.task4.logic.ClientHandler;
import com.androsor.task4.utils.IOHelper;
import com.androsor.task4.view.Viewer;

import java.math.BigDecimal;

import static com.androsor.task4.logic.BankAccountStatus.*;
import static com.androsor.task4.logic.CalculatingType.*;
import static com.androsor.task4.logic.ProcessingMoneyType.*;
import static com.androsor.task4.logic.SortingType.*;

/**
 * Accounts. A customer can have several bank accounts. Consider the possibility of blocking / unblocking an account.
 * Implement invoice search and sorting. Calculation of the total amount of accounts. Calculation of the amount for all
 * accounts with positive and negative balances separately.
 */

public class Test {

    private static final Viewer viewer = new Viewer();

    public static void main(String[] args) {
        Client ivanov = new Client("Ким Чен", "Ынский", " МВ123456789");
        ClientHandler clientHandlerIvanov = new ClientHandler(ivanov);

        System.out.println("Создаем счета у клиента");
        try {
            IOHelper.createBankAccount(clientHandlerIvanov);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        viewer.showAllClientBankAccounts(ivanov);

        System.out.println("Закрываем счет");
        try {
            clientHandlerIvanov.closeBankAccountByNumber(1000);
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Блокируем счет");
        try {
            clientHandlerIvanov.processStatusBankAccount(1001, BLOCK);
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Разблокируем счет");
        try {
            clientHandlerIvanov.processStatusBankAccount(10020, UNBLOCK);
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Пополняем счет");
        try {
            clientHandlerIvanov.processMoney(new BigDecimal("100000"), 1003, ADD_MONEY);
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Снимаем со счета");
        try {
            clientHandlerIvanov.processMoney(new BigDecimal("10000000"), 1004, WITHDRAW_MONEY);
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Сумма по всем счетам");
        try {
            System.out.println(clientHandlerIvanov.calculateBalance(CALCULATE_TOTAL));
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Сумма по счетам с положительным балансом");
        try {
            System.out.println(clientHandlerIvanov.calculateBalance(CALCULATE_TOTAL_POSITIVE));
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Сумма по счетам с отрицательным балансом");
        try {
            System.out.println(clientHandlerIvanov.calculateBalance(CALCULATE_TOTAL_NEGATIVE));
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        viewer.showMessageSortBankAccountsByBalance();
        try {
            viewer.showBankAccounts(clientHandlerIvanov.sortBankAccounts(SORT_BY_BALANCE));
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        viewer.showMessageSortBankAccountsByNumber();
        try {
            viewer.showBankAccounts(clientHandlerIvanov.sortBankAccounts(SORT_BY_NUMBER));
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        viewer.showMessageSortBankAccountsByDate();
        try {
            viewer.showBankAccounts(clientHandlerIvanov.sortBankAccounts(SORT_BY_DATE));
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        viewer.showMessageSortBankAccountsByStatus();
        try {
            viewer.showBankAccounts(clientHandlerIvanov.sortBankAccounts(SORT_BY_STATUS));
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }
    }
}
