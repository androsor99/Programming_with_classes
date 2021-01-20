package com.androsor.task4_2_2.logic;

import com.androsor.task4_2_2.entity.City;
import com.androsor.task4_2_2.entity.District;
import com.androsor.task4_2_2.entity.Region;
import com.androsor.task4_2_2.entity.State;
import com.androsor.task4_2_2.util.ReadingFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateLogic {

    public StateLogic() {
    }

    public City createCity (String nameCity) throws IOException {
        List<City> cities = ReadingFromFile.getCitesFromFile();
        for (City cit : cities) {
            if(cit.getName().equalsIgnoreCase(nameCity)) {
                return cit;
            }
        }
        throw new NullPointerException("Город не найден");
    }

    public District createDistrict(String nameDistrict) throws IOException {

        List<District> districts = ReadingFromFile.getDistrictsFromFile();
        for (District distr : districts) {
            if (distr.getName().equalsIgnoreCase(nameDistrict)) {
                District district = new District(distr.getName());
                district.setPopulation(distr.getPopulation());
                district.setArea(distr.getArea());
                district.setCites(createCitesByDistrict(nameDistrict));
                return district;
            }
        }
        throw new NullPointerException("Район не найден");
    }

    private List<City> createCitesByDistrict(String nameDistrict) throws IOException {

        List<City> cities = ReadingFromFile.getCitesFromFile();
        List<City> citiesByDistrict =  new ArrayList<>();
        for (City city : cities) {
            if(city.getParentStructuralUnit().equalsIgnoreCase(nameDistrict)) {
                citiesByDistrict.add(city);
            }
        }
        return citiesByDistrict;
    }

    public Region createRegion(String nameRegion) throws IOException {

        List<Region> regions = ReadingFromFile.getRegionsFromFile();
        for (Region reg : regions) {
            if (reg.getName().equalsIgnoreCase(nameRegion)) {
                Region region = new Region(reg.getName());
                region.setRegionCenter(reg.getRegionCenter());
                region.setPopulation(reg.getPopulation());
                region.setArea(reg.getArea());
                region.setDistricts(createDistrictsByRegion(nameRegion));
                return region;
            }
        }
        throw new NullPointerException("Область не найдена");
    }

    private List<District> createDistrictsByRegion(String nameRegion) throws IOException {

        List<District> districts = ReadingFromFile.getDistrictsFromFile();
        List<District> districtByRegion = new ArrayList<>();
        for (District district : districts) {
            if(district.getParentStructuralUnit().equalsIgnoreCase(nameRegion)) {
                districtByRegion.add(district);
            }
        }
        return districtByRegion;
    }

    public State createState() throws IOException {
        State state = new State("Беларусь", new City("Минск"), ReadingFromFile.getRegionsFromFile());
        state.setPopulation(state.calculatePopulation());
        state.setArea(state.calculateArea());
        return state;
    }
}

