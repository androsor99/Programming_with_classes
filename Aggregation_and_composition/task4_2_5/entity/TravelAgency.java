package com.androsor.task4_2_5.entity;

import java.util.ArrayList;
import java.util.List;

public class TravelAgency {

    private String name;
    private List<Tour> allTours = new ArrayList<>();
    private List<Client> allClients = new ArrayList<>();

    public TravelAgency() {
        super();
    }

    public TravelAgency(String name) {
        super();
        this.name = name;
    }

    public TravelAgency(String name, List<Tour> allTours, List<Client> allClients) {
        super();
        this.name = name;
        this.allTours = allTours;
        this.allClients = allClients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tour> getAllTours() {
        return allTours;
    }

    public void setAllTours(List<Tour> allTours) {
        this.allTours = allTours;
    }

    public List<Client> getAllClients() {
        return allClients;
    }

    public void setAllOrders(List<Client> allClients) {
        this.allClients = allClients;
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
                ", allTours=" + allTours +
                ", allClients=" + allClients +
                '}';
    }
}
