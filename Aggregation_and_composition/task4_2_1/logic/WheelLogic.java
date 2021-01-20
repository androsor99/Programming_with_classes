package com.androsor.task4_2_1.logic;

import com.androsor.task4_2_1.entity.Wheel;

public class WheelLogic {

    public WheelLogic() {
    }

    public void calculationTireLife  (Wheel wheel, double distance) {
        double resource = wheel.getResource() - distance;
        if (resource < 0) {
            resource = 0;
        }
        wheel.setResource(resource);
    }
}
