package com.androsor.task4_2_2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class State extends AdministrativeUnit{

    private City capital;
    private List<Region> regions;

    public State(String name) {
        super(name);
        this.regions = new ArrayList<>();
    }

    public State(String name, City capital) {
        super(name);
        this.capital = capital;
    }

    public State(String name, City capital, List<Region> regions) {
        super(name);
        this.capital = capital;
        this.regions = regions;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }


    public double calculatePopulation() {
        double population = 0;
        for (Region region : regions) {
            population += region.getPopulation();
        }
        return population;
    }


    public double calculateArea() {
        double area = 0;
        for (Region region : regions) {
            area += region.getArea();
        }
        return area;
    }

    public int getQuantityRegions() {
        return regions.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        State state = (State) o;
        return capital.equals(state.capital) &&
                regions.equals(state.regions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capital, regions);
    }

    @Override
    public String toString() {
        return "State{" +
                "capital=" + capital +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", regions=" + regions +
                '}';
    }


}
