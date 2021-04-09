package com.androsor.prog_class.customer;

import java.util.Objects;
import java.util.UUID;

public class Customer {

    private String ID;
    private String lastName;
    private String name;
    private String secondName;
    private String address;
    private long creditCardNum;
    private long bankAccountNum;

    public Customer(long ID, String lastName, String name, String secondName, String address, long creditCardNum, long bankAccountNum) {
        this.ID = UUID.randomUUID().toString();
        this.lastName = lastName;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.creditCardNum = creditCardNum;
        this.bankAccountNum = bankAccountNum;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(long creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public long getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(long bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return creditCardNum == customer.creditCardNum && bankAccountNum == customer.bankAccountNum && Objects.equals(ID, customer.ID)
                && Objects.equals(lastName, customer.lastName) && Objects.equals(name, customer.name)
                && Objects.equals(secondName, customer.secondName) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, lastName, name, secondName, address, creditCardNum, bankAccountNum);
    }

    @Override
    public String toString() {
        return String.format("Клиент: id = %s,\t%s %s %s, \"%s\",\t\tНомер карты - %d;\t\tНомер счета - %d;\n",
                ID, lastName, name, secondName,address, creditCardNum, bankAccountNum);
    }
}
