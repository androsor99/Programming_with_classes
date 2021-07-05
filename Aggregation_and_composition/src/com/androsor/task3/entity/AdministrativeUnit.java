package com.androsor.task3.entity;

import java.util.Objects;

public abstract class AdministrativeUnit {

    protected String name;
    protected double area;
    protected double population;

    public AdministrativeUnit() {
        this.name = "default";
        this.area = 0;
        this.population = 0;
    }

    public AdministrativeUnit(String name) {
        this.name = name;
        this.area = 0;
        this.population = 0;
    }

    public AdministrativeUnit(String name,
                              double population) {
        this.name = name;
        this.population = population;
        this.area = 0;
    }

    public AdministrativeUnit(String name,
                              double area,
                              double population) {
        this.name = name;
        this.area = area;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministrativeUnit that = (AdministrativeUnit) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.population, population) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, population);
    }

}
