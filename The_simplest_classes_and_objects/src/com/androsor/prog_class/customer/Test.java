package com.androsor.prog_class.customer;

import java.util.List;

import static com.androsor.prog_class.customer.IOHelper.readCustomerStorage;
import static com.androsor.prog_class.customer.IOHelper.showCustomers;

/**
 * Create a Customer class whose specification is given below. Define constructors, set and get methods,
 * and the toString () method. Create a second class that aggregates an array of type Customer,
 * with appropriate constructors and methods. Set the criteria for selecting data and display this data on the console.
 *
 * Customer class: id, last name, first name, middle name, address, credit card number, bank account number.
 *
 * Find and withdraw:
 *
 * a) list of buyers in alphabetical order;
 *
 * b) a list of customers whose credit card number is in the specified interval
 */
public class Test {

    private static final long UPPER_LIMIT = 2000;
    private static final long LOWER_LIMIT = 6000;

    public static void main(String[] args) {
        List<Customer> customers = readCustomerStorage();

        DataBank dataBank = new DataBank(customers);

        System.out.println("Список клиентов в алфавитном порядке:\n--------------------------------");
        dataBank.sortName();
        showCustomers(dataBank);

        System.out.printf("""
                Список клиентов, у которых номер кредитной карты находится в интервале от %d до %d:
                --------------------------------
                """, UPPER_LIMIT, LOWER_LIMIT);
        try {
            List<Customer> customersWithCardsInRange = dataBank.getCustomersByNumberCard(UPPER_LIMIT, LOWER_LIMIT);
            DataBank dataBankWithCardsInRange = new DataBank(customersWithCardsInRange);
            showCustomers(dataBankWithCardsInRange);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
