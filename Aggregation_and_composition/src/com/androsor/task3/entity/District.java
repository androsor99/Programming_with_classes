package com.androsor.task3.entity;

import java.util.List;

public class District extends CompositeAdministrativeUnit<City> {

    public District() {
        super();
    }

    public District(String name,
                    City districtCenter) {
        super(name, districtCenter);
    }

    public District(String name,
                    double area,
                    double population,
                    City districtCenter) {
        super(name,  area, population, districtCenter);
    }

    @Override
    public void addAdministrativeUnit(City administrativeUnit) {
        this.administrativeUnits.add(administrativeUnit);
    }

    @Override
    public void addAdministrativeUnits(List<City> administrativeUnits) {
        this.administrativeUnits.addAll(administrativeUnits);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Район - ").append(this.name);
        stringBuilder.append("\nПдощадь - ").append(String.format("%.3f ", this.area)).append("км2");
        stringBuilder.append("\nНаселение - ").append(String.format("%.3f ", this.population)).append("тыс.человек");
        stringBuilder.append("\nРайонный центр - г. ").append(this.administrativeUnitCenter.getName());
        return stringBuilder.toString();
    }
}
