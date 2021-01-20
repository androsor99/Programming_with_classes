package com.androsor.task4_2_4.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String firstName;
    private String secondName;
    private String passportID;
    private List<BankAccount> bankAccounts;

    public Client() {
       super();
        this.bankAccounts = new ArrayList<>();
    }

    public Client(String firstName, String lastName, String passportID) {
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

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts.addAll(bankAccounts);
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
