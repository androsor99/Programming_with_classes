package com.androsor.task4_2_5.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Tour {

    protected String type;
    protected String country;
    private String id;
    protected Date date;
    private int days;
    private String transportation;
    private boolean food;
    private int price;

    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse("0000-00-00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Tour() {
        super();
    }

    public Tour(String country, String id, Date date, int days, String transportation, boolean food, int price) {
        super();
        this.country = country;
        this.id = id;
        this.date = date;
        this.days = days;
        this.transportation = transportation;
        this.food = food;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String receiveSpecificInfo() {
        return "Специфической информации нет";
    }

    public boolean filterTourByCountry(String country) {
        return this.country.equalsIgnoreCase(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return days == tour.days &&
                food == tour.food &&
                price == tour.price &&
                Objects.equals(type, tour.type) &&
                Objects.equals(country, tour.country) &&
                Objects.equals(id, tour.id) &&
                Objects.equals(date, tour.date) &&
                Objects.equals(transportation, tour.transportation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, country, id, date, days, transportation, food, price);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", id='" + id + '\'' +
                ", date=" + date +
                ", days=" + days +
                ", transportation='" + transportation + '\'' +
                ", food=" + food +
                ", price=" + price +
                '}';
    }
}
