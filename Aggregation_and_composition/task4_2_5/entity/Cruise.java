package com.androsor.task4_2_5.entity;

import java.text.SimpleDateFormat;
import java.util.*;

public class Cruise extends Tour{


    private List<String>countries = new ArrayList<>();

    public Cruise() {
        super();
    }

    public Cruise(String id, int days, Date date, String transportation, boolean food, int price) {
        super(null, id, date, days,  transportation, food, price);
        type = "Круиз";
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String receiveSpecificInfo() {

        @SuppressWarnings("resource")
        Formatter ft = new Formatter();
        ft.format("Маршрут круиза:\n");
        for (String s : countries) {
            ft.format(" - %s\n", s);
        }
        return ft.toString();
    }

    @Override
    public boolean filterTourByCountry(String country) {
        return this.countries.contains(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cruise cruise = (Cruise) o;
        return countries.equals(cruise.countries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countries);
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "countries=" + countries +
                ", type='" + type + '\'' +
                '}';
    }
}
