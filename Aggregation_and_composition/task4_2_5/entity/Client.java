package com.androsor.task4_2_5.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String firstName;
    private String lastName;
    private String idPassport;
    private List<Tour> tours = new ArrayList<>();

    public Client() {

    }

    public Client(String firstName, String lastName, String idPassport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idPassport = idPassport;
        this.tours = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(String idPassport) {
        this.idPassport = idPassport;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idPassport='" + idPassport + '\'' +
                ", tours=" + tours +
                '}';
    }
}
