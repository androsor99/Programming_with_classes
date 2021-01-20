package com.androsor.task4_2_4.entity;

import java.util.Date;

public class BankAccount {

    private long number;
    private String clientId;
    private Date dateCreation;
    private long balance;
    private boolean active;

    public BankAccount() {
        super();
        this.dateCreation = new Date();
    }

    public BankAccount(long number, String clientId, long balance, boolean active) {
        this.number = Math.abs(number);
        this.clientId = clientId;
        this.balance = balance;
        this.active = active;
        this.dateCreation = new Date();
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        if (number < 0) {
            this.number = Math.abs(number);
        }
        this.number = number;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "number=" + number +
                ", clientId=" + clientId +
                ", dateCreation=" + dateCreation +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }
}


