package com.androsor.task5.main;

import com.androsor.task5.entity.TravelAgency;
import com.androsor.task5.service.TourHandler;
import com.androsor.task5.view.Viewer;

import static com.androsor.task5.dao.util.IOHelper.generateTour;
import static com.androsor.task5.service.TypeOfTourSelection.*;
import static com.androsor.task5.service.TypeOfTourSorting.*;

/**
 * Tourist vouchers. To form a set of proposals for the client on the choice of a tourist voucher of various types
 * (rest, excursions, treatment, shopping, cruise, etc.) for the optimal choice. Consider the choice of transport,
 * food and the number of days. Implement the selection and sorting of tours.
 */
public class Test {
    private static final Viewer viewer = new Viewer();

    public static void main(String[] args) {
        TravelAgency travelAgency = new TravelAgency("В последний путь");
        TourHandler tourHandler = new TourHandler(travelAgency);
        travelAgency.addTours(generateTour());
        viewer.showTours(travelAgency.getTours());

        System.out.println("\nВыбираем путевку по стране");
        viewer.showTours(tourHandler.selectTour("Италия", SELECT_BY_COUNTRY));

        System.out.println("\nВыбираем путевку по количеству дней");
        viewer.showTours(tourHandler.selectTour("20", SELECT_BY_NUMBER_DAYS));

        System.out.println("\nВыбираем путевку по питанию");
        viewer.showTours(tourHandler.selectTour("Все включено", SELECT_BY_TYPE_OF_FOOD));

        System.out.println("\nВыбираем путевку по типу путевки");
        viewer.showTours(tourHandler.selectTour("Лечение", SELECT_BY_TYPE));

        System.out.println("\nВыбираем путевку по стимости");
        viewer.showTours(tourHandler.selectTour("2000", SELECT_BY_PRICE));

        System.out.println("\nСортируем путевки по стране");
        viewer.showTours(tourHandler.sortTour(SORT_BY_COUNTRY));

        System.out.println("\nСортируем путевки по длительности");
        viewer.showTours(tourHandler.sortTour(SORT_BY_DAYS));

        System.out.println("\nСортируем путевки по стоимости");
        viewer.showTours(tourHandler.sortTour(SORT_BY_PRICE));
    }
}
