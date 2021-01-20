package com.androsor.task4_2_1.logic;

import com.androsor.task4_2_1.entity.Tank;

public class TankLogic {

    public TankLogic() {
    }

    public void refuel(Tank tank, double volumeFuel) {

        if ((tank.getVolumeFuel() + volumeFuel) > tank.getVolume()) {
            System.out.printf("Заправлено -> %.2f л. топлива. Бак полный -> %.2f л.",
                    (tank.getVolume() - tank.getVolumeFuel()), tank.getVolume());
            tank.setVolumeFuel(tank.getVolume());
            return;
        }
        System.out.printf("Заправлено -> %.2f л. топлива.\nТоплива в баке -> %.2f л.", volumeFuel,
                (tank.getVolumeFuel() + volumeFuel));
        tank.setVolumeFuel(tank.getVolumeFuel() + volumeFuel);
    }

    public void calculateVolumeFuel(Tank tank, double distance, double fuelConsumption) {

        double volumeFuel = tank.getVolumeFuel() - fuelConsumption / 100 * distance;
        if (volumeFuel < 0) {
            volumeFuel = 0;
        }
        tank.setVolumeFuel(volumeFuel);
    }
}
