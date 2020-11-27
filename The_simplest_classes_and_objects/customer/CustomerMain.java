package com.androsor.prog_class.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

public class CustomerMain {

    private static final long UPPER_LIMIT = 2000;
    private static final long LOWER_LIMIT = 6000;

    public static void main(String[] args) throws IOException {

        ArrayList<Customer> customers = readCustomerStorage();

        CustomerStorage customerStorage = new CustomerStorage(customers);

        System.out.println("Список покупателей в алфавитном порядке:\n--------------------------------");
        customerStorage.sortName();
        showCustomerStorage(customerStorage);

        System.out.printf("\nСписок покупателей, у которых номер кредитной карты находится в интервале от %d до %d:\n--------------------------------\n", UPPER_LIMIT, LOWER_LIMIT);
        ArrayList<Customer> customersCreditCardNumRange = customerStorage.creatingListCustomerByCreditCardRange(UPPER_LIMIT, LOWER_LIMIT);
        if (customersCreditCardNumRange.size() == 0) {
            System.out.print("\nБанковские карты не найдены");
        } else {
            CustomerStorage customerStorageCreditCardNumRange = new CustomerStorage(customersCreditCardNumRange);
            customerStorageCreditCardNumRange.sortCreditCardNumber();
            showCustomerStorage(customerStorageCreditCardNumRange);
        }
    }

    public static void showCustomerStorage(CustomerStorage customerStorages) {
        for (int i = 0; i < customerStorages.getDataBase().size(); i++) {
            System.out.print(customerStorages.getDataBase().get(i));
        }
    }

    public static ArrayList<Customer> readCustomerStorage() throws IOException {

        ArrayList<Customer> list = new ArrayList<>();

        FileReader fr = new FileReader("G:/EPAM Project/Programming_with_classes/The_simplest_classes_and_objects/src/com/androsor/prog_class/customer/list.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line;

        while ((line = reader.readLine()) != null) {
            String [] lines = line.split("\\s");
            list.add(new Customer(Long.parseLong(lines[0]), lines[1], lines[2], lines[3], lines[4], Long.parseLong(lines[5]), Long.parseLong(lines[6])));
        }

        return list;
    }
}

