package com.androsor.task4_2_5.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Relaxation extends Tour{

    private String hotel;

    public Relaxation() {
        super();
    }

    public Relaxation(String country, String id, Date date, int days, String transportation, boolean food, int price) {
        super(country, id, date, days, transportation, food, price);
        type = "Отдых";
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String receiveSpecificInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Страна отдыха - \"%s\"\nОтель - \"%s\".\n", country, hotel);
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
        Relaxation that = (Relaxation) o;
        return hotel.equals(that.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hotel);
    }

    @Override
    public String toString() {
        return "Relaxation{" +
                "hotel='" + hotel + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
