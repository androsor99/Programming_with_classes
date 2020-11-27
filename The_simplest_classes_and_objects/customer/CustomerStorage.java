package com.androsor.prog_class.customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class CustomerStorage {

    private ArrayList<Customer> dataBase;

    public CustomerStorage() {
    }

    public CustomerStorage(ArrayList<Customer> dataBase) {
        this.dataBase = dataBase;
    }

    public ArrayList<Customer> getDataBase() {
        return dataBase;
    }

    public void setDataBase(ArrayList<Customer> base) {
        this.dataBase = base;
    }

    public void sortName() {
        dataBase.sort(Comparator.comparing(Customer::getLastName)
                .thenComparing(Customer::getName)
                .thenComparing(Customer::getSecondName));
    }

    public void sortCreditCardNumber(){
        dataBase.sort(Comparator.comparing(Customer::getCreditCardNum));

    }

    public ArrayList<Customer> creatingListCustomerByCreditCardRange(long min, long max) {
        ArrayList<Customer> list = new ArrayList<>();
        for (Customer customer : this.dataBase) {
            if (customer.getCreditCardNum() > min
                    && customer.getCreditCardNum() < max) {
                list.add(customer);
            }
        }
        return list;
    }

    void addCustomers (long id, String lastName, String Name, String secondName, String address, long creditCardNum, long bankAccountNum) {

        this.dataBase.add(new Customer(id, lastName, Name, secondName, address, creditCardNum, bankAccountNum));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerStorage that = (CustomerStorage) o;
        return Objects.equals(dataBase, that.dataBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataBase);
    }
}
