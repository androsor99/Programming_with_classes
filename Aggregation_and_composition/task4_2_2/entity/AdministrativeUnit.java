package com.androsor.task4_2_2.entity;


import java.util.Objects;

public abstract class AdministrativeUnit {

    protected String name;
    String parentStructuralUnit;
    protected double population;
    protected double area;

    public AdministrativeUnit() {}

    public AdministrativeUnit(String name) {
        this.name = name;
    }

    public AdministrativeUnit(String name, String parentStructuralUnit, double population) {
        this.parentStructuralUnit = parentStructuralUnit;
        this.name = name;
        this.population = population;
    }

    public AdministrativeUnit(String name, double population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public AdministrativeUnit(String name, String parentStructuralUnit, double population, double area) {
        this.name = name;
        this.parentStructuralUnit = parentStructuralUnit;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getParentStructuralUnit() {
        return parentStructuralUnit;
    }

    public void setParentStructuralUnit(String parentStructuralUnit) {
        this.parentStructuralUnit = parentStructuralUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministrativeUnit that = (AdministrativeUnit) o;
        return Double.compare(that.population, population) == 0 &&
                Double.compare(that.area, area) == 0 &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, area);
    }

    @Override
    public String toString() {
        return "AdministrativeUnit{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
