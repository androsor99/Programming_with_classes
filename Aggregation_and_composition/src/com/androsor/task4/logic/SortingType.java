package com.androsor.task4.logic;

import com.androsor.task4.entity.BankAccount;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;

public enum SortingType {

    SORT_BY_NUMBER(bankAccounts -> bankAccounts.sort(comparing(BankAccount::getNumber))),
    SORT_BY_BALANCE(bankAccounts -> bankAccounts.sort(comparing(BankAccount::getBalance))),
    SORT_BY_DATE(bankAccounts -> bankAccounts.sort(comparing(BankAccount::getDateCreation))),
    SORT_BY_STATUS(bankAccounts -> bankAccounts.sort(comparing(BankAccount::isActive).reversed()));

    private final Consumer<List<BankAccount>> sortingBankAccount;

    SortingType(Consumer<List<BankAccount>> sortingBankAccount) {
        this.sortingBankAccount = sortingBankAccount;
    }

    public Consumer<List<BankAccount>> getSortingBankAccount() {
        return sortingBankAccount;
    }
}
