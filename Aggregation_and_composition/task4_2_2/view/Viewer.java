package com.androsor.task4_2_2.view;

import com.androsor.task4_2_2.entity.City;
import com.androsor.task4_2_2.entity.District;
import com.androsor.task4_2_2.entity.Region;
import com.androsor.task4_2_2.entity.State;

import java.util.List;

public class Viewer {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printListCity(List<City> cities) {
        System.out.println("Список городов:");
        for (City city : cities) {
            System.out.printf("г. %s\n", city.getName());
        }
    }

    public void printListDistrict(List<District> districts) {
        System.out.println("Список районов:");
        for (District district : districts) {
            System.out.printf("%s р-н.,\n", district.getName());
        }
    }

    public void printListRegion(List<Region> regions) {
        System.out.println("Список областей:");
        for (Region region : regions) {
            System.out.printf("%s обл.,\n", region.getName());
        }
    }

    public void infoAboutCity(City city) {
        printMessage(String.format("\nГород: %s;\nГод основания: %s;\nНаселение: %.2f тыс. чел.", city.getName(), city.getYearFounded(), city.getPopulation()));
    }

    public void infoAboutDistrict(District district) {
        printMessage(String.format("\nРайон: %s;\nНаселение: %.2f тыс. чел.\nПлощадь: %.2f км.кв.\n", district.getName(), district.getPopulation(), district.getArea()));
    }

    public void infoAboutRegion(Region region) {
        printMessage(String.format("\n%s область:\nНаселение: %.2f тыс. чел.\nПлощадь: %.2f км.кв.\nОбластной центр: г. %s\nКоличество районов - %d\n", region.getName(),
                region.getPopulation(), region.getArea(), region.getRegionCenter().getName(), region.getQuantityDistricts()));
    }

    public void infoAboutState(State state) {
        printMessage(String.format("Страна: %s;\nСтолица: г. %s;\nНаселение: %.2f тыс. чел.\nПлощадь: %.2f км.кв.\nКоличество областей - %d\n", state.getName(),
                state.getCapital().getName(), state.getPopulation(), state.getArea(), state.getQuantityRegions()));
    }
}
