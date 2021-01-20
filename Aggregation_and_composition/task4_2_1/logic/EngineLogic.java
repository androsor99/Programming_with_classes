package com.androsor.task4_2_1.logic;

import com.androsor.task4_2_1.entity.Engine;

public class EngineLogic {

    public EngineLogic() {
    }

    public void start(Engine engine) {
        String START = "Двигатель запущен!";
        if (!engine.isStarted()) {
            engine.setStarted(true);
            System.out.print(START);
        } else {
            System.err.print(START);
        }
    }

    public void stop(Engine engine) {
        String STOP = "Двигатель заглушен!";
        if (engine.isStarted()) {
            engine.setStarted(false);
            System.out.println(STOP);
        } else {
            System.err.print(STOP);
        }
    }

    public void calculateResourceOil (Engine engine, double distance) {
        double resourceNew = engine.getResourceOil() - distance;
        engine.setResourceOil(resourceNew);
    }
}
