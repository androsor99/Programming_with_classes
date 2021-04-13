package com.androsor.task3.entity;

import java.util.List;

public class Region extends CompositeAdministrativeUnit<District> {

    public Region() {
        super();
    }

    public Region(String name,
                  City regionCenter) {
        super(name, regionCenter);
    }

    public Region(String name,
                  double area,
                  double population,
                  City regionCenter) {
        super(name,  area, population, regionCenter);
    }

    public Region(String name,
                  City regionCenter,
                  List<District> districts) {
        super(name, regionCenter, districts);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Область - ").append(this.name);
        stringBuilder.append("\nПдощадь - ").append(String.format("%.3f ", this.area)).append("км2");
        stringBuilder.append("\nНаселение - ").append(String.format("%.3f ", this.population)).append("тыс.человек");
        stringBuilder.append("\nОбластной центр - г. ").append(this.administrativeUnitCenter.getName());
        return stringBuilder.toString();
    }
}
