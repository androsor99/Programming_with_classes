package com.androsor.task4_2_1.logic;

import com.androsor.task4_2_1.entity.Car;
import com.androsor.task4_2_1.entity.Engine;
import com.androsor.task4_2_1.entity.Wheel;
import com.androsor.task4_2_1.utils.ConsoleScanner;
import com.androsor.task4_2_1.view.Viewer;

public class CarLogic {

    private Car car;
    private final EngineLogic engineLogic = new EngineLogic();
    private final TankLogic tankLogic = new TankLogic();
    private final WheelLogic wheelLogic = new WheelLogic();
    private final ConsoleScanner consoleScanner = new ConsoleScanner();
    private final Viewer viewer = new Viewer();

    public CarLogic(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car createCar() {
        System.out.print("Марка автомобиля -> \n");
        String carBrand = consoleScanner.getStrFromConsol();

        System.out.print("Модель -> \n");
        String model = consoleScanner.getStrFromConsol();

        System.out.print("Мощность двигателя л.с.-> \n");
        double power = consoleScanner.getDoubleFromConsol();

        System.out.print("Расход топлива л./100 км. -> \n");
        double fuelConsumption = consoleScanner.getDoubleFromConsol();

        Engine engine = new Engine(power, fuelConsumption);
        car = new Car(carBrand, model, engine);
        return car;
    }

    public void drive () {

        if (!checkBeforeStart()) {
            return;
        }

        System.out.print("Расстояние поездки км. ->\n");
        int distance = consoleScanner.getIntFromConsol();

        for (int i = 1; i <= distance; i++) {

            if (!chekAfterStart()) {
                viewer.showMessageInConsole(String.format("Пройдено %d км. пути из запланированных %d км.", i -1, distance));
                return;
            }
            car.setMileage(car.getMileage() + 1);
            wheelLogic.calculationTireLife(car.getFrontLeft(), Math.random()*10);
            wheelLogic.calculationTireLife(car.getFrontRight(), Math.random()*10);
            wheelLogic.calculationTireLife(car.getBackLeft(), Math.random()*10);
            wheelLogic.calculationTireLife(car.getBackRight(), 1);
            engineLogic.calculateResourceOil(car.getEngine(), 1);
            tankLogic.calculateVolumeFuel(car.getTank(), 1, car.getEngine().getFuelConsumption());
        }
        viewer.showMessageInConsole(String.format("Запланированный путь в %d км. пройден.", distance));
    }

    public boolean checkBeforeStart() {
        if (car.getFrontLeft().getResource() * car.getFrontRight().getResource() * car.getBackLeft().getResource() * car.getBackRight().getResource() == 0) {
            viewer.showMessageInConsole("Одна или несколько шин изношены. Замените!");
            return false;
        }

        if (!car.getEngine().isStarted()) {
            viewer.showMessageInConsole("Двигатель не запущен! Запустите двигатель!");
            return false;
        }
        return true;
    }

    public boolean chekAfterStart() {

        if (car.getFrontLeft().getResource() <= 0) {
            viewer.showMessageInConsole("Вышла из строя передняя левая шина! Замените шину!");
            engineLogic.stop(car.getEngine());
            return false;
        }
        if (car.getFrontRight().getResource() <= 0) {
            viewer.showMessageInConsole("Вышла из строя передняя правая шина! Замените шину!");
            engineLogic.stop(car.getEngine());
            return false;
        }
        if (car.getBackLeft().getResource() <= 0) {
            viewer.showMessageInConsole("Вышла из строя задняя левая шина! Замените шину!");
            engineLogic.stop(car.getEngine());
            return false;
        }
        if (car.getBackRight().getResource() <= 0) {
            viewer.showMessageInConsole("Вышла из строя задняя правая шина! Замените шину!");
            engineLogic.stop(car.getEngine());
            return false;
        }
        if (car.getEngine().getResourceOil() <= 0) {
            viewer.showMessageInConsole("Моторное масло выработало свой ресурс. Замените масло!");
            engineLogic.stop(car.getEngine());
            return false;
        }
        if (car.getTank().getVolumeFuel() <= 0) {
            viewer.showMessageInConsole("Топливо закончилось. Заправьте автомобиль!");
            engineLogic.stop(car.getEngine());
            return false;
        }
        return true;
    }

    public void replaceWheel() {
        System.out.println("Выберите заменяемое колесо:\n\t1 -> переднее левое\n\t2 -> переднее правое\n\t3 -> заднее левое\n\t4 -> заднее правое\n\tдругое -> Колёсико еще поедит.");
        int numWheel = consoleScanner.getIntFromConsol();

        if (numWheel >= 1 && numWheel <= 4) {

            viewer.showMessageInConsole("Марка шины -> ");
            String brand = consoleScanner.getStrFromConsol();
            viewer.showMessageInConsole("Радиус шин -> ");
            int radius = consoleScanner.getIntFromConsol();
            while (radius < 16 || radius > 20) {
                System.out.println("Не тот компот! Обычно от R16 до R20!");
                viewer.showMessageInConsole("Радиус шин -> ");
                radius = consoleScanner.getIntFromConsol();
            }
            Wheel newWheel = new Wheel(brand, radius);

            switch (numWheel) {
                case (1) -> car.setFrontLeft(newWheel);
                case (2) -> car.setFrontRight(newWheel);
                case (3) -> car.setBackLeft(newWheel);
                case (4) -> car.setBackRight(newWheel);
            }
            System.out.println("Колесо замено");
        }
    }

    public void addFuel() {
        System.out.print("Объём заправляемого топлива л. ->\n");
        double volumeFuel = consoleScanner.getIntFromConsol();
        tankLogic.refuel(car.getTank(), volumeFuel);
    }

    public void startEngine() {
        if (car.getTank().getVolumeFuel() == 0) {
            viewer.showMessageInConsole("Топливо на нуле! Заправьте машину!");
            return;
        }
        engineLogic.start(car.getEngine());
    }

    public void stopEngine() {
        engineLogic.stop(car.getEngine());
    }

    public void infoAboutWheels() {

        System.out.printf("Состояние колёс:\n\t-Переднее левое-\n%s\n\t-Переднее правое-\n%s\n\t-Заднее левое-\n%s\n\t-Заднее правое-\n%s\n",
                car.getFrontLeft().infoTire(), car.getFrontRight().infoTire(), car.getBackLeft().infoTire(), car.getBackRight().infoTire());
    }

    public String InfoAboutEngine() {
        return car.getEngine().infoEngine();
    }

    public String InfoAboutTank() {
        return car.getTank().infoTank();
    }

    public String ifoBrandCar() {
        return String.format("Марка авто: %s\nМодель: %s", car.getCarBrand(), car.getModel());
    }

    public String infoCar() {
        return String.format("Марка автомобиля: %s\nМодель: %s\nПробег: %d\n\nИнформация по двигателю:\n%s\nИнформация по топливу:\n%s\n",car.getCarBrand(), car.getModel(),
                car.getMileage(), car.getEngine().infoEngine(), car.getTank().infoTank());
    }

    @Override
    public String toString() {
        return "CarLogic [car=" + car + "]";
    }
}

