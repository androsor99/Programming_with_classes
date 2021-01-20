package com.androsor.task4_2_2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Region extends AdministrativeUnit {

    private City regionCenter;
    private List<District> districts;

    public Region() {
        super();
    }

    public Region(String name) {
        super(name);
        this.districts = new ArrayList<>();
    }

    public Region(String name, double population, double area, City regionCenter) {
        super(name, population, area);
        this.regionCenter = regionCenter;
        this.districts = new ArrayList<>();
    }

    public City getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(City regionCenter) {
        this.regionCenter = regionCenter;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public int getQuantityDistricts() {
        return districts.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Region region = (Region) o;
        return regionCenter.equals(region.regionCenter) &&
                districts.equals(region.districts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), regionCenter, districts);
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionCenter=" + regionCenter +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", districts=" + districts +
                '}';
    }
}
