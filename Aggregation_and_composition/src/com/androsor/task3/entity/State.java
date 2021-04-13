package com.androsor.task3.entity;

import java.util.List;

public class State extends CompositeAdministrativeUnit<Region> {

    public State() {
        super();
    }

    public State(String name, City capital) {
        super(name, capital);
    }

    public State(String name, City capital, List<Region> regions) {
        super(name, capital, regions);
    }

    public void printCompositionOfState() {
        for (Region region : getAdministrativeUnits()) {
            System.out.println(region.getName() + " обл.");
            System.out.println("Областной центр г. " + region.getAdministrativeUnitCenter().getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Государство - ").append(this.name);
        stringBuilder.append("\nПдощадь - ").append(String.format("%.3f ", this.area)).append("км2");
        stringBuilder.append("\nНаселение - ").append(String.format("%.3f ", this.population)).append("тыс.человек");
        stringBuilder.append("\nСтолица - г. ").append(this.administrativeUnitCenter.getName());
        return stringBuilder.toString();
    }
}
