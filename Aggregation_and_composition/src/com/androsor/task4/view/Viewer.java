package com.androsor.task4.view;

import com.androsor.task4.entity.BankAccount;
import com.androsor.task4.entity.Client;

import java.util.List;

public class Viewer {

    public static void showMessageAboutOpeningNewBankAccount(long number) {
        System.out.printf("Счёт номер \"%d\" открыт!\n", number);
    }
    public static void showInvalidMessageAboutOpeningNewBankAccount(long number) {
        System.out.printf("Счёт с номером \"%s\" уже существует!\n", number);
    }

    public void showAllClientBankAccounts(Client client) {
        System.out.printf("Список всех счетов клиента \"%s %s\", id = \"%s\":\n",client.getSecondName(), client.getFirstName(), client.getPassportID());
        client.getBankAccounts().forEach(this::showBankAccount);
    }

    public static void showMessageCloseBankAccount(long number) {
        System.out.printf("Счёт номер № \"%d\" успешно закрыт!\n", number);
    }

    public static void showMessageStateBlockBankAccount(long number) {
        System.out.printf("Счёт № \"%d\" заблокирован!\n", number);
    }

    public static void showMessageStatusBankAccount(long number, boolean status) {
        System.out.printf("Счёт № \"%d\" %s\n", number, (status ? "разблокирован" : "заблокирован"));
    }

    public static void showBalanceMessage(long number, BankAccount bankAccount) {
        System.out.printf("Актуальный баланс счёта № \"%d\" = %s руб.\n", number, bankAccount.getBalance().toString());
    }

    public void showBankAccount(BankAccount bankAccount) {
        System.out.printf("Номер счёта: #%s; баланс: %s руб.; статус: %s, открыт: %s\n", bankAccount.getNumber(), bankAccount.getBalance().toString(),
                (bankAccount.isActive() ? "активен" : "заблокирован"), bankAccount.getDateCreation().toLocaleString());
    }

    public void showBankAccounts(List<BankAccount> bankAccounts) {
        bankAccounts.forEach(this::showBankAccount);
    }

    public void showMessageSortBankAccountsByBalance() {
        System.out.print("Счёта отсортированы по возростанию баланса средств.\n");
    }

    public void showMessageSortBankAccountsByNumber() {
        System.out.print("Счёта отсортированы по возростанию номера.\n");
    }

    public void showMessageSortBankAccountsByDate() {
        System.out.print("Счёта отсортированы по возростанию даты открытия.\n");
    }

    public void showMessageSortBankAccountsByStatus() {
        System.out.print("Счёта отсортированы по состоянию.\n");
    }
}
