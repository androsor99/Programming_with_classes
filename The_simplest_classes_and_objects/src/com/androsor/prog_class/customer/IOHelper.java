package com.androsor.prog_class.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOHelper {

    public static List<Customer> readCustomerStorage() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/com/androsor/prog_class/customer/customers.txt"))) {
           String line;
            while ((line = reader.readLine()) != null) {
               String[] lines = line.split("\\s");
               customers.add(new Customer(Long.parseLong(lines[0]), lines[1], lines[2], lines[3], lines[4], Long.parseLong(lines[5]), Long.parseLong(lines[6])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void showCustomers(DataBank dataBank) {
        dataBank.getCustomers().forEach(System.out::print);
    }
}
