package com.androsor.task5.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Tour {

    private TourType tourType;
    private String country;
    private int numberOfDays;
    private TransportType transport;
    private TypeOfFood typeOfFood;
    private BigDecimal price;

    public Tour() {
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public TransportType getTransport() {
        return transport;
    }

    public void setTransport(TransportType transport) {
        this.transport = transport;
    }

    public TypeOfFood getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(TypeOfFood typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return numberOfDays == tour.numberOfDays && tourType == tour.tourType && Objects.equals(country, tour.country)
                && transport == tour.transport && typeOfFood == tour.typeOfFood && Objects.equals(price, tour.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourType, country, numberOfDays, transport, typeOfFood, price);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourType=" + tourType +
                ", country='" + country + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", transport=" + transport +
                ", food=" + typeOfFood +
                ", price=" + price +
                '}';
    }

    public static class Builder {

        private final Tour newTour;

        public Builder() {
            this.newTour = new Tour();
        }

        public Builder withTourType(TourType tourType) {
            newTour.tourType = tourType;
            return this;
        }

        public Builder withCountry(String  country) {
            newTour.country = country;
            return this;
        }

        public Builder withNumbersOfDays(int numbersOfDays) {
            newTour.numberOfDays = numbersOfDays;
            return this;
        }
        public Builder withTransportType(TransportType transportType) {
            newTour.transport = transportType;
            return this;
        }

        public Builder withFoodType(TypeOfFood typeOfFood) {
            newTour.typeOfFood = typeOfFood;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            newTour.price = price;
            return this;
        }

        public Tour build(){
            return newTour;
        }
    }
}
