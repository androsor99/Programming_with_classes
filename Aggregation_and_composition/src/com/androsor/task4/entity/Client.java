package com.androsor.task4.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private String firstName;
    private String secondName;
    private String passportID;
    private final List<BankAccount> bankAccounts;

    public Client() {
        this.bankAccounts = new ArrayList<>();
    }

    public Client(String firstName,
                  String lastName,
                  String passportID) {
        this.firstName = firstName;
        this.secondName = lastName;
        this.passportID = passportID;
        this.bankAccounts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String lastName) {
        this.secondName = lastName;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

    public void removeBankAccount(BankAccount bankAccount) {this.bankAccounts.remove(bankAccount); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) && Objects.equals(secondName, client.secondName)
                && Objects.equals(passportID, client.passportID) && Objects.equals(bankAccounts, client.bankAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, passportID, bankAccounts);
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + secondName + '\'' +
                ", passportID='" + passportID + '\'' +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}
