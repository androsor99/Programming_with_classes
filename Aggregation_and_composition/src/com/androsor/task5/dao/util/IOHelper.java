package com.androsor.task5.dao.util;

import com.androsor.task5.entity.TourType;
import com.androsor.task5.entity.TransportType;
import com.androsor.task5.entity.TypeOfFood;
import com.androsor.task5.entity.Tour;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.androsor.task5.entity.TourType.*;
import static com.androsor.task5.entity.TransportType.*;
import static com.androsor.task5.entity.TypeOfFood.*;
import static java.util.Arrays.asList;

public class IOHelper {

    private static final List<String> countries = asList("Турция", "Италия", "Испания", "Греция", "Египет");
    private static final List<TypeOfFood> typeOfFood = asList(NOT_INCLUDED, BREAKFAST, ALL_INCLUSIVE);
    private static final List<TourType> tourType  = asList(CRUISE, RECREATION, SHOPPING, TREATMENT, EXCURSION);
    private static final List<TransportType> transportType = asList(BUS, SHIP, PLANE, TRAIN);

    public static  List<Tour> generateTour() {
        List<Tour> randomTours = new ArrayList<>(25);
        Random random = new Random();
        for (int i = 0; i <= 25; i++ ) {
            Tour tour = new Tour.Builder()
                    .withTourType(tourType.get(random.nextInt(5)))
                    .withCountry(countries.get(random.nextInt(5)))
                    .withTransportType(transportType.get(random.nextInt(4)))
                    .withNumbersOfDays(random.nextInt(21) + 7)
                    .withFoodType(typeOfFood.get(random.nextInt(3)))
                    .withPrice(new BigDecimal(String.valueOf(random.nextInt(50) * 100 + 100)))
                    .build();
            randomTours.add(tour);
        }
        return randomTours;
    }
}
