package com.androsor.task4_2_5.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Shopping extends Tour{

    private String city = "город не задан";
    private String shop = "магазин не задан";

    public Shopping() {
        super();
    }

    public Shopping(String country, String id, Date date, int days, String transportation, boolean food, int price) {
        super(country, id, date, days, transportation, food, price);
        type = "Шоптур";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String receiveSpecificInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Страна - \"%s\"\nГород - \"%s\"\nСупермаркет - \"%s\"\n",country, city, shop);
    }

    @Override
    public boolean filterTourByCountry(String country) {
        return super.filterTourByCountry(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shopping shopping = (Shopping) o;
        return city.equals(shopping.city) &&
                shop.equals(shopping.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city, shop);
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "city='" + city + '\'' +
                ", shop='" + shop + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
