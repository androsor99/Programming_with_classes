package com.androsor.task4_2_5.main;

import com.androsor.task4_2_5.entity.TravelAgency;
import com.androsor.task4_2_5.error.TourException;
import com.androsor.task4_2_5.logic.TravelAgencyLogic;
import com.androsor.task4_2_5.resource.LoadListTour;
import com.androsor.task4_2_5.utils.ConsoleScanner;
import com.androsor.task4_2_5.utils.Scanner;
import com.androsor.task4_2_5.view.Viewer;
import java.text.ParseException;
import static com.androsor.task4_2_5.main.MenuCommand.*;

/**
 * Tourist vouchers. To form a set of proposals for the client on the choice of a tourist voucher of various types
 * (rest, excursions, treatment, shopping, cruise, etc.) for the optimal choice. Consider the choice of transport,
 * food and the number of days. Implement the selection and sorting of tours.
 */

public class TourMain {
    private static final Scanner scanner = new ConsoleScanner();
    private static final Viewer viewer = new Viewer();
    private static final LoadListTour loadListTour = new LoadListTour();
    private static  TravelAgencyLogic travelAgencyLogic;

    public static void main(String[] args) throws ParseException {

        TravelAgency travelAgency = new TravelAgency("В последний путь");
        travelAgencyLogic = new TravelAgencyLogic(travelAgency);
        travelAgency.setAllTours(loadListTour.createTheListOfTours());

        MenuCommand userCommand;

        do {
            viewer.showMenuCommand();
            userCommand = selectUserCommand();

            if (!sortingCommands.contains(userCommand)) {
                viewer.showMessageAboutInvalidCommand();
            } else {
                try {
                    processMenuCommand(userCommand, travelAgency);
                } catch (TourException ex) {
                    System.err.print(ex.getMessage());
                }
            }
        } while (userCommand != EXIT_PROGRAM);
    }

    public static MenuCommand selectUserCommand() {
        return getCommandByCode(scanner.getCommandNumberFromUser());
    }

    public static void processMenuCommand(MenuCommand menuCommand, TravelAgency travelAgency) throws TourException {
        
        switch (menuCommand) {

            case ALL_TOUR -> viewer.showAllTours(travelAgency.getAllTours(), travelAgency);

            case TOURS_SELECT_BY_TYPE -> {
                String type = scanner.getTypeTour();
                viewer.showTypeTours(travelAgencyLogic.selectByToursType(type), travelAgency, type);
            }

            case TOURS_SELECT_BY_COUNTRY -> {
                String country = scanner.getCommandSelectByCountry();
                viewer.showInfoTours(travelAgencyLogic.selectByToursCountry(country));
            }

            case TOURS_SELECT_BY_FOOD -> {
                viewer.showCommandSelectByFood();
                processUserCommandSelectByFood(travelAgency);
            }

            case TOURS_SELECT_BY_TRANSPORT -> {
                String transport = scanner.getCommandSelectByTransport();
                viewer.showInfoTours(travelAgencyLogic.selectByToursTransportation(transport));
            }

            case TOURS_SELECT_BY_PRICE -> {
                int price = scanner.getCommandSelectByPrice();
                viewer.showInfoTours(travelAgencyLogic.selectByToursPrice(price));
            }

            case TOURS_SELECT_BY_DAYS -> {
                int days = scanner.getCommandSelectByDays();
                viewer.showInfoTours(travelAgencyLogic.selectByToursDays(days));
            }

            case TOURS_SORT_BY_PRICE -> {
                viewer.showCommandSortByPrice(travelAgency);
                viewer.showInfoTours(travelAgencyLogic.sortByPrice(travelAgency.getAllTours()));
            }

            case TOURS_SORT_BY_DAYS -> {
                viewer.showCommandSortByDays(travelAgency);
                viewer.showInfoTours(travelAgencyLogic.sortByDays(travelAgency.getAllTours()));
            }
        }
    }

    public static void processUserCommandSelectByFood(TravelAgency travelAgency) {
        int userCommand = scanner.getCommandNumberFromUser();
        if (userCommand == IS_FOOD_INCLUDED.getCode()) {
            viewer.showInfoTours(travelAgencyLogic.selectByToursFoodIncluded(travelAgency, true));
        } else {
            if (userCommand == IS_FOOD_NOT_INCLUDED.getCode()) {
                viewer.showInfoTours(travelAgencyLogic.selectByToursFoodIncluded(travelAgency, false));
            }
        }
    }
}
