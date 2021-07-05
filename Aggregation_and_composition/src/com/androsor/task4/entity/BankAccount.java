package com.androsor.task4.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import static java.lang.Math.abs;

public class BankAccount {

    private long number;
    private Date dateCreation;
    private BigDecimal balance;
    private boolean active;

    public BankAccount(long number,
                       BigDecimal balance,
                       boolean active) {
        this.number = abs(number);
        this.balance = balance;
        this.active = active;
        this.dateCreation = new Date();
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        if (number < 0) {
            this.number = abs(number);
        }
        this.number = number;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void add(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void subtract(BigDecimal amount) {
//        if (this.balance.compareTo(amount) < 0) {
//            this.balance = new BigDecimal("0");
//        } else {
            this.balance = this.balance.subtract(amount);
//        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return number == that.number && active == that.active && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, dateCreation, balance, active);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "number=" + number +
                ", dateCreation=" + dateCreation +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }
}
