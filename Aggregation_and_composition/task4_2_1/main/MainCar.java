package com.androsor.task4_2_1.main;

import com.androsor.task4_2_1.entity.Car;
import com.androsor.task4_2_1.logic.CarLogic;
import com.androsor.task4_2_1.utils.ConsoleScanner;
import java.util.Objects;

import static com.androsor.task4_2_1.main.TypeCommand.*;
import static com.androsor.task4_2_1.view.Viewer.*;

/**
 * Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться, менять колесо,
 * вывести на консоль марку автомобиля.
 */

public class MainCar {

    private static final CarLogic carLogic = new CarLogic(null);
    private static final ConsoleScanner consoleScanner = new ConsoleScanner();

    public static void main(String[] args) {

        Car car = null;
        TypeCommand typeUserCommand;

        do {
            showTypeUserCommand(car);

            typeUserCommand = selectTypeUserCommand();

            if (isCheckSetCar(car, typeUserCommand)) {
                continue;
            }

            car = processUserCommand(car, typeUserCommand);
            System.out.println("GAME OVER!");
        } while (typeUserCommand != EXIT_PROGRAM);
    }

    public static Car processUserCommand(final Car car, final TypeCommand typeCommand) {

        Car newCar = car;

        switch (Objects.requireNonNull(typeCommand)) {

            case CAR_SELECTION -> newCar = carLogic.createCar();
            case ENGINE_START -> carLogic.startEngine();
            case ENGINE_STOP -> carLogic.stopEngine();
            case FUELING -> carLogic.addFuel();
            case DRIVING -> carLogic.drive();
            case REPLACING_WHEELS -> carLogic.replaceWheel();
            case INFO_WHEELS -> carLogic.infoAboutWheels();
            case INFO_ENGINE -> System.out.println(carLogic.InfoAboutEngine());
            case INFO_TANK -> System.out.println(carLogic.InfoAboutTank());
            case INFO_BRAND_CAR -> System.out.println(carLogic.ifoBrandCar());
            case INFO_CAR -> System.out.println(carLogic.infoCar());
        }
        return newCar;
    }

    public static TypeCommand selectTypeUserCommand() {
        return getTypeCommandByCode(consoleScanner.getIntFromConsol());
    }

    public static void showTypeUserCommand(final Car car) {
        if (car == null) {
            showStartTypeCommand();

        } else {
            showTypeCommand();
        }
    }

    public static boolean isCheckSetCar(final Car car, final TypeCommand typeCommand) {
        return car == null && (!(typeCommand == EXIT_PROGRAM || typeCommand == CAR_SELECTION));
    }


}

