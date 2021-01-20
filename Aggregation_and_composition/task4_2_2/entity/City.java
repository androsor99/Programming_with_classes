package com.androsor.task4_2_2.entity;

import java.util.Objects;

public class City extends AdministrativeUnit {

    private int yearFounded;

    public City (){
        super();
    }

    public City (String name){
        super(name);
    }

    public City(String name, int yearFounded, String parentStructuralUnit, double population) {
        super(name, parentStructuralUnit, population);
        this.yearFounded = yearFounded;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return yearFounded == city.yearFounded;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearFounded);
    }

    @Override
    public String toString() {
        return "City{" +
                "yearFounded=" + yearFounded +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
