package com.androsor.task4_2_2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class District extends AdministrativeUnit{

    private City districtCenter;
    private List<City> cites;

    public District() {
        super();
    }

    public District(String name) {
       super(name);
       this.cites = new ArrayList<>();
    }

    public District(String name, String parentStructuralUnit, double population, double area) {
        super(name, parentStructuralUnit, population, area);
        this.cites = new ArrayList<>();
    }

    public City getDistrictCenter() {
        return districtCenter;
    }

    public void setDistrictCenter(City districtCenter) {
        this.districtCenter = districtCenter;
    }

    public List<City> getCites() {
        return cites;
    }

    public void setCites(List<City> cites) {
        this.cites = cites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        District district = (District) o;
        return districtCenter.equals(district.districtCenter) &&
                cites.equals(district.cites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), districtCenter, cites);
    }

    @Override
    public String toString() {
        return "District{" +
                "districtCenter=" + districtCenter +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", cites=" + cites +
                '}';
    }
}
