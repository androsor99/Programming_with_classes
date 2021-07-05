package com.androsor.task5.view;

import com.androsor.task5.entity.Tour;

import java.util.List;


public class Viewer {

    public void showTours(final List<Tour> tours) {
        if(!tours.isEmpty()){
            System.out.printf("\n%-10s%-15s%-15s%-15s%-15s%-8s\n", "Страна", "К-во дней", "Питание", "Транспорт", "Тип путёвки", "Стоимость");
            System.out.println("-----------------------------------------------------------------------------------------");
            for (Tour tour : tours) {
                System.out.printf("%-13s%-10d%-18s%-16s%-15s%-1s$\n", tour.getCountry(), tour.getNumberOfDays(), tour.getTypeOfFood().getType(),
                        tour.getTransport().getType(), tour.getTourType().getType(), tour.getPrice().toString());
            }
        } else {
            System.out.println("\nПодходящих путевок не найдено.");
        }
    }
}
