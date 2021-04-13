package com.androsor.task3.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class CompositeAdministrativeUnit<T extends AdministrativeUnit> extends AdministrativeUnit {

    protected City administrativeUnitCenter;
    protected List<T> administrativeUnits;

    public CompositeAdministrativeUnit() {
        super();
        this.administrativeUnitCenter = new City();
        this.administrativeUnits = new ArrayList<>();
    }

    public CompositeAdministrativeUnit(String name) {
        super(name);
        this.administrativeUnitCenter = new City();
        this.administrativeUnits = new ArrayList<>();
    }

    public CompositeAdministrativeUnit(String name,
                                       City administrativeUnitCenter) {
        super(name);
        this.administrativeUnitCenter = administrativeUnitCenter;
        this.administrativeUnits = new ArrayList<>();
    }

    public CompositeAdministrativeUnit(String name,
                                       double area,
                                       double population) {
        super(name, area, population);
        this.administrativeUnitCenter = new City();
        this.administrativeUnits = new ArrayList<>();
    }

    public CompositeAdministrativeUnit(String name,
                                       List<T> units) {
        super(name);
        this.administrativeUnitCenter = new City();
        this.administrativeUnits = units;
        calculateAreaAndPopulation(units);
    }

    public CompositeAdministrativeUnit(String name,
                                       double area,
                                       double population,
                                       City administrativeUnitCenter) {
        super(name, area, population);
        this.administrativeUnitCenter = administrativeUnitCenter;
        this.administrativeUnits = new ArrayList<>();
    }

    public CompositeAdministrativeUnit(String name,
                                       City administrativeUnitCenter,
                                       List<T> units) {
        super(name);
        this.administrativeUnitCenter = administrativeUnitCenter;
        this.administrativeUnits = units;
        calculateAreaAndPopulation(units);
    }

    private void calculateAreaAndPopulation(List<T> units) {
        for (T administrativeUnit : units) {
            this.area += administrativeUnit.getArea();
            this.population += administrativeUnit.getArea();
        }
    }

    public City getAdministrativeUnitCenter() { return administrativeUnitCenter;
    }

    public void setAdministrativeUnitCenter(City administrativeUnitCenter) {
        this.administrativeUnitCenter = administrativeUnitCenter;
    }

    public List<T> getAdministrativeUnits() {
        return administrativeUnits;
    }


    public void addAdministrativeUnit(T unit) {
        this.administrativeUnits.add(unit);
        this.population += unit.getPopulation();
        this.area += unit.getArea();
    }

    public void addAdministrativeUnits(List<T> units) {
        this.administrativeUnits.addAll(units);
        calculateAreaAndPopulation(units);
    }

    public void removeAdministrativeUnit(T unit) {
            this.administrativeUnits.remove(unit);
    }

    public void removeAdministrativeUnits(List<T> units) {
            this.administrativeUnits.removeAll(units);
    }

    public int getNumberOfAdministrativeUnits() {
        return this.administrativeUnits.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompositeAdministrativeUnit<?> that = (CompositeAdministrativeUnit<?>) o;
        return Objects.equals(administrativeUnitCenter, that.administrativeUnitCenter) && Objects.equals(administrativeUnits, that.administrativeUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), administrativeUnitCenter, administrativeUnits);
    }
}