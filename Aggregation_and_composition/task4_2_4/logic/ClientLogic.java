package com.androsor.task4_2_4.logic;

import com.androsor.task4_2_4.entity.BankAccount;
import com.androsor.task4_2_4.entity.Client;
import com.androsor.task4_2_4.error.BankAccountException;
import com.androsor.task4_2_4.utils.Scanner;

import java.util.Comparator;

public class ClientLogic {

    private Client client;

    public ClientLogic() {

    }

    public ClientLogic(Client client) {
        super();
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client createNewClient(Scanner consoleScanner) {

        String id = consoleScanner.getIdNewClient();
        String firstName = consoleScanner.getFirstNameNewClient();
        String secondName = consoleScanner.getSecondNameNewClient();
        client = new Client(firstName, secondName, id);
        return client;
    }

    public void openNewBankAccount(long number) throws BankAccountException {

        for (BankAccount bankAccount: client.getBankAccounts()) {
            if (bankAccount.getNumber() == number) {
                throw new BankAccountException(String.format("Счёт с номером \"%s\" уже существует!\n", number));
            }
        }
        BankAccount bankAccountNew = new BankAccount(number, client.getPassportID(), 0, true);
        client.getBankAccounts().add(bankAccountNew);
    }

    public BankAccount findBankAccountByNumber(long number) {

        for (BankAccount bankAccount : client.getBankAccounts()) {
            if (bankAccount.getNumber() == number) {
                return bankAccount;
            }
        }
        return null;
    }

    public void closeBankAccountByNumber(long number) {
        client.getBankAccounts().remove(findBankAccountByNumber(number));
    }

    public void blockBankAccount(BankAccount bankAccount) throws BankAccountException {

        if (!bankAccount.isActive()) {
            throw new BankAccountException(String.format("Счёт \"%s\" уже заблокирован!\n", bankAccount.getNumber()));
        }
        bankAccount.setActive(false);
    }

    public void unblockBankAccount(BankAccount bankAccount) throws BankAccountException {

        if (bankAccount.isActive()) {
            throw new BankAccountException(String.format("Счёт \"%s\" уже разблокирован!\n", bankAccount.getNumber()));
        }
        bankAccount.setActive(true);
    }

    public void addMoneyBankAccount(long amountsRecharged, BankAccount bankAccount) throws BankAccountException {

        if (!bankAccount.isActive()) {
            throw new BankAccountException("Счёт заблокирован!");
        }
        if (amountsRecharged <= 0) {
            throw new BankAccountException("Введённая сумма отрицательная. Баланс не изменён!");
        }
        bankAccount.setBalance(bankAccount.getBalance() + amountsRecharged);
    }

    public void removeMoneyBankAccount(long amountsRecharged, BankAccount bankAccount) throws BankAccountException {

        if (!bankAccount.isActive()) {
            throw new BankAccountException("Счёт заблокирован!");
        }
        if (amountsRecharged <= 0) {
            throw new BankAccountException("Введённая сумма отрицательная. Баланс не изменён!");
        }
        bankAccount.setBalance(bankAccount.getBalance() - amountsRecharged);
    }

    public void transferMoneyFromBankAccounts(long money, BankAccount bankAccountFrom, BankAccount bankAccountTo) throws BankAccountException {

        if (!bankAccountFrom.isActive()) {
            throw new BankAccountException(String.format("Счёт номер \"%s\", c которого Вы пытаетесь перевести средства - заблокирован!\n", bankAccountFrom.getNumber()));
        }
        if (!bankAccountTo.isActive()) {
            throw new BankAccountException(String.format("Счёт номер \"%s\", на который Вы пытаетесь перевести деньги - заблокирован!\n", bankAccountTo.getNumber()));
        }
        addMoneyBankAccount(money, bankAccountTo);
        removeMoneyBankAccount(money, bankAccountFrom);
    }

    public long calculateTotalBalanceAllBankAccounts() {

        long totalBalance = 0;
        for (BankAccount bankAccount : client.getBankAccounts()) {
            totalBalance = totalBalance + bankAccount.getBalance();
        }
        return totalBalance;
    }

    public long calculateTotalBalanceAllPositiveBankAccounts() {
        long totalBalancePositive = 0;
        for (BankAccount bankAccount : client.getBankAccounts()) {
            if (bankAccount.getBalance() > 0) {
                totalBalancePositive = totalBalancePositive + bankAccount.getBalance();
            }
        }
        return totalBalancePositive;
    }

    public long calculateTotalBalanceAllNegativeBankAccounts() {

        long totalBalanceNegative = 0;
        for (BankAccount bankAccount : client.getBankAccounts()) {
            if (bankAccount.getBalance() < 0) {
                totalBalanceNegative = totalBalanceNegative + bankAccount.getBalance();
            }
        }
        return totalBalanceNegative;
    }

    public void sortBankAccountsByBalance() {
        client.getBankAccounts().sort(Comparator.comparing(BankAccount::getBalance));
    }

    public void sortBankAccountsByNumber() {
        client.getBankAccounts().sort(Comparator.comparing(BankAccount::getNumber));
    }

    public void sortBankAccountsByDate() {
        client.getBankAccounts().sort(Comparator.comparing(BankAccount::getDateCreation));
    }

    @Override
    public String toString() {
        return "ClientLogic{" +
                "client=" + client +
                '}';
    }
}

//    public boolean checkTheClientIsBankAccount() {
//        if (client.getBankAccounts().size() == 0) {
//            System.out.print("У клиента нет ни одного счета!\n");
//            return true;
//
//
//        }
//        return false;
//    }
//
//    public boolean isActiveBankAccount (BankAccount bankAccount) {
//        if (!bankAccount.isActive()) {
//            System.out.println("Счёт заблокирован!");
//            return true;
//        }
//        return false;
//    }
//
//    public boolean checkNullBankAccount(BankAccount bankAccount) {
//        if (bankAccount == null) {
//            System.out.print("Невозможно выполнить операции с данным счетом!\n");
//            return true;
//        }
//        return false;
//    }