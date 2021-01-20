package com.androsor.task4_2_5.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Client client;
    private List<Tour> tours;

    public Order() {
        super();
    }

    public Order(Client client, Tour tour) {
        super();
        this.client = client;
        this.tours = new ArrayList<Tour>();

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", tours=" + tours +
                '}';
    }
}
