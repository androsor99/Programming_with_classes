package com.androsor.task4_2_5.resource;

import com.androsor.task4_2_5.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LoadListTour {

    public  List<Tour> createTheListOfTours() throws ParseException {

        List<Tour> allTors = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Cruise tour1 = new Cruise("1", 14, sdf.parse("2020-12-31"), "Теплоход", true, 10000);
        List<String> countries = new ArrayList<>();
        countries.add("Беларусь");
        countries.add("Шчучыншчына-2");
        countries.add("Шчучыншчына-3");
        countries.add("Шчучыншчына-4");
        countries.add("Шчучыншчына-5");
        tour1.setCountries(countries);
        allTors.add(tour1);

        Excursion tour2 = new Excursion("Родина усатого","2", 14, sdf.parse("2021-01-01"), "Автобус", false, 30000);
        tour2.setGuide_language("Трасянка");
        List<String> showplaces = new ArrayList<>();
        showplaces.add("Базар");
        showplaces.add("Свалка");
        showplaces.add("Кладбище");
        tour2.setShowplaces(showplaces);
        allTors.add(tour2);

        Recovery tour3 = new Recovery("Мазамбик", "3", sdf.parse("2021-02-01"), 21, "На перекладных", true, 5000);
        tour3.setSanatorium("Задница африканца");
        tour3.setIllness("служба в МВД");
        allTors.add(tour3);

        Relaxation tour4 = new Relaxation("Левый берег Свислочи","4", sdf.parse("2021-03-01"), 14, "На оленях", false, 100);
        tour4.setHotel("Карачун");
        allTors.add(tour4);

        Shopping tour5 = new Shopping("Беларусь","5", sdf.parse("2021-04-01"), 1, "На телеге", false, 1000);
        tour5.setCity("Минск");
        tour5.setShop("Комаровка");
        allTors.add(tour5);

       return allTors;
    }
}
