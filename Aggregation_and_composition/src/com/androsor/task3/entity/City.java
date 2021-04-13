package com.androsor.task3.entity;

import java.util.Objects;

public class City extends AdministrativeUnit {

    private int yearFounded;

    public City() {
        super();
        this.yearFounded = 0;
    }

    public City(String name) {
        super(name);
        this.yearFounded = 0;
    }

    public City(String name,
                double population,
                int yearFounded) {
        super(name, population);
        this.yearFounded = yearFounded;
    }

    public City(String name, double area, double population, int yearFounded) {
        super(name, area, population);
        this.yearFounded = yearFounded;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return yearFounded == city.yearFounded;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), yearFounded);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Город - ").append(this.name);
        stringBuilder.append("\nПдощадь - ").append(String.format("%.3f ", this.area)).append("км2");
        stringBuilder.append("\nНаселение - ").append(String.format("%.3f ", this.population)).append("тыс.человек");
        stringBuilder.append("\nГод снования - ").append(this.yearFounded).append(" г.");
        return stringBuilder.toString();
    }
}
