package com.androsor.task4_2_1.view;

import static com.androsor.task4_2_1.main.TypeCommand.*;

public class Viewer {

    public void showMessageInConsole(String message) {
        System.out.println(message);
    }

    public static void showStartTypeCommand() {
        System.out.printf("%d -> Выбрать автомобиль\n%d -> Выйти из программы\n", CAR_SELECTION.getCode(), EXIT_PROGRAM.getCode());
    }

    public static void showTypeCommand() {
        System.out.printf("\n---------------------------------------\n" +
                "%d -> Выбрать автомобиль\n%d ->  Завести двигатель\n" +
                "%d ->  Заглушить двигатель\n%d ->  Заправить топливом\n%d ->  Поехать на заданное расстояие \n" +
                "%d ->  Заменить колесо\n%d ->  Показать информацию по колёсам \n%d ->  Показать информацию по двигателю\n" +
                "%d -> Показать информацию по топливому баку \n%d -> Показать маркуи модель автомобиля \n" +
                "%d -> Показать всю информацию по автомобилю\n%d ->  Выйти из программы\n"
                + "---------------------------------------\n",
                CAR_SELECTION.getCode(), ENGINE_START.getCode(), ENGINE_STOP.getCode(),
                FUELING.getCode(), DRIVING.getCode(), REPLACING_WHEELS.getCode(),INFO_WHEELS.getCode(),
                INFO_ENGINE.getCode(), INFO_TANK.getCode(), INFO_BRAND_CAR.getCode(), INFO_CAR.getCode(), EXIT_PROGRAM.getCode());
    }
}
