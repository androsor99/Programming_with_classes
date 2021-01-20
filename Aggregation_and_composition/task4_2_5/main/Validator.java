package com.androsor.task4_2_5.main;

import com.androsor.task4_2_5.entity.Tour;
import com.androsor.task4_2_5.error.TourException;

import java.util.List;

public class Validator {

    public static void chekEnteredParameters (List<Tour> tour) throws TourException {
        if (tour.size() == 0) {
            throw new TourException("C данными параметрами туров не найдено!");
        }
    }
}
