package com.androsor.task4_2_5.view;

import com.androsor.task4_2_5.entity.Tour;
import com.androsor.task4_2_5.entity.TravelAgency;
import java.text.SimpleDateFormat;
import java.util.List;
import static com.androsor.task4_2_5.main.MenuCommand.*;

public class Viewer {

    public void showMenuCommand() {
        System.out.printf("\n---------------------------------------\n" +
                        "%d ->  Показать все туры\n%d ->  Выбрать тип тура\n" +
                        "%d ->  Выбрать тур по стране\n%d ->  Выбрать тур с питанием/без питания\n" +
                        "%d ->  Выбрать тип транспорта\n%d ->  Выбрать тур по стоимости\n" +
                        "%d ->  Выбрать тур по продолжительности в днях\n%d ->  Сортировать туры по стоимости\n%d ->  Сортировать туры по длительности\n" +
                        "%d ->  Выйти из программы\n"
                        + "---------------------------------------\n",
                ALL_TOUR.getCode(), TOURS_SELECT_BY_TYPE.getCode(), TOURS_SELECT_BY_COUNTRY.getCode(), TOURS_SELECT_BY_FOOD.getCode(),
                TOURS_SELECT_BY_TRANSPORT.getCode(), TOURS_SELECT_BY_PRICE.getCode(), TOURS_SELECT_BY_DAYS.getCode(),
                TOURS_SORT_BY_PRICE.getCode(), TOURS_SORT_BY_DAYS.getCode(), EXIT_PROGRAM.getCode());
    }

    public void showMessageAboutInvalidCommand() {
        System.err.println("Неверная команда!");
    }

    public void showAllTours(final List<Tour> tourCurrent,final TravelAgency travelAgency) {

        System.out.printf("\n\tВсе туры доступные в турагентстве \"%s\":\n", travelAgency.getName());
        System.out.println("----------------------------------");
        showInfoTours(tourCurrent);
    }

    public void showTypeTours(final List<Tour> tourCurrent,final TravelAgency travelAgency,final String type) {

        System.out.printf("\n\tВсе туры типа \"%s\" доступные в турагентстве \"%s\":\n",type, travelAgency.getName());
        System.out.println("----------------------------------");
        showInfoTours(tourCurrent);
    }

    public void showInfoTours(final List<Tour> tourCurrent) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int i = 1;
        for (Tour tour : tourCurrent) {
            System.out.printf("%d -> тур id = \"%s\": тип - \"%s\";\nДата - %s;\n%s", i, tour.getId(), tour.getType(), sdf.format(tour.getDate()), tour.receiveSpecificInfo());
            System.out.printf("Кол-во дней - %s | транспорт - %s |  %s | стоимость - %d euro.\n", tour.getDays(), tour.getTransportation(), (tour.isFood() ? "Питание включено" : "Без пттания"), tour.getPrice());
            i++;
            System.out.println("----------------------------------");
        }
    }

    public void showCommandSelectByFood() {
        System.out.print("Выберете действие:\n\t1 -> Питание включено\n\t2 -> Питание не включено\n\t другое значение ->  Веруться в предыдущее меню\n");
    }

    public void showCommandSortByPrice(TravelAgency travelAgency) {

        System.out.printf("Все туры доступные в турагентстве \"%s\" отсортированы по возрастанию стоимости:\n", travelAgency.getName());
        System.out.println("----------------------------------");
    }

    public void showCommandSortByDays(TravelAgency travelAgency) {

        System.out.printf("Все туры доступные в турагентстве \"%s\" отсортированы по возрастанию продолжительности:\n", travelAgency.getName());
        System.out.println("----------------------------------");
    }
}

