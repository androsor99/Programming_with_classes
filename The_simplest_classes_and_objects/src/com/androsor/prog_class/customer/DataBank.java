package com.androsor.prog_class.customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataBank {

    private List<Customer> customers;

    public DataBank() {
        this.customers = new ArrayList<>();
    }

    public DataBank(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> base) {
        this.customers = base;
    }

    public void sortName() {
        customers.sort(Comparator.comparing(Customer::getLastName)
                .thenComparing(Customer::getName)
                .thenComparing(Customer::getSecondName));
    }

    public void sortCardNumber(){
        customers.sort(Comparator.comparing(Customer::getCreditCardNum));
    }

    public List<Customer> getCustomersByNumberCard(long min, long max) {
        List<Customer> result = this.customers.stream()
                .filter(customer -> customer.getCreditCardNum() > min && customer.getCreditCardNum() < max)
                .collect(Collectors.toList());
        if (!result.isEmpty()) {
            return result;
        } else {
            throw new IllegalArgumentException("Клиенты не найдены.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataBank that = (DataBank) o;
        return Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers);
    }

    @Override
    public String toString() {
        return "DataBank{" +
                "customers=" + customers +
                '}';
    }
}
