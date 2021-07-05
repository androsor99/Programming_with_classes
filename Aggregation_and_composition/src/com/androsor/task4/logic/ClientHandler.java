package com.androsor.task4.logic;

import com.androsor.task4.entity.BankAccount;
import com.androsor.task4.entity.Client;
import com.androsor.task4.error.BankAccountException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.androsor.task4.view.Viewer.*;

public class ClientHandler {

    private Client client;

    public ClientHandler() {
    }

    public ClientHandler(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void openNewBankAccount(long number) {
        if (isExistBankAccount(number)) {
        client.getBankAccounts().add(new BankAccount(number, new BigDecimal(0), true));
        showMessageAboutOpeningNewBankAccount(number);
        } else {
            showInvalidMessageAboutOpeningNewBankAccount(number);
        }
    }

    private boolean isExistBankAccount(long number) {
        return client.getBankAccounts().isEmpty() || client.getBankAccounts().stream().noneMatch(bankAccount -> bankAccount.getNumber() == number);
    }

    public BankAccount findBankAccountByNumber(long number) throws BankAccountException {
        return client.getBankAccounts().stream().filter(account -> account.getNumber() == number).findFirst()
                .orElseThrow(() -> new BankAccountException(String.format("Счет № %d не найден", number)));
    }

    public void closeBankAccountByNumber(long number) throws BankAccountException {
        client.removeBankAccount(findBankAccountByNumber(number));
        showMessageCloseBankAccount(number);
    }

    public void processStatusBankAccount(long number, BankAccountStatus status) throws BankAccountException {
        findBankAccountByNumber(number).setActive(status.isStatus());
        showMessageStatusBankAccount(number, status.isStatus());
    }

    public void processMoney(BigDecimal money, long number, ProcessingMoneyType type) throws BankAccountException {
        BankAccount bankAccount = findBankAccountByNumber(number);
        if (!bankAccount.isActive()) {
            showMessageStateBlockBankAccount(number);
        } else {
           type.getProcessingMoney().accept(bankAccount, money);
            showBalanceMessage(number, bankAccount);
        }
    }

    public BigDecimal calculateBalance(CalculatingType type) throws BankAccountException {
        return type.getCalculatingBalance().apply(client.getBankAccounts());
    }

    public List<BankAccount> sortBankAccounts(SortingType type) throws BankAccountException {
        List<BankAccount> accounts = new ArrayList<>(client.getBankAccounts());
        if (!accounts.isEmpty()) {
         type.getSortingBankAccount().accept(accounts);
         return accounts;
        }
        throw new BankAccountException("У клиента нет счетов");
    }
}