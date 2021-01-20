package com.androsor.task4_2_1.main;

public enum TypeCommand {

    CAR_SELECTION(1),
    ENGINE_START(2),
    ENGINE_STOP(3),
    FUELING(4),
    DRIVING(5),
    REPLACING_WHEELS(6),
    INFO_WHEELS(7),
    INFO_ENGINE(8),
    INFO_TANK(9),
    INFO_BRAND_CAR(10),
    INFO_CAR(11),
    EXIT_PROGRAM(0);

    private final int code;

    TypeCommand(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TypeCommand getTypeCommandByCode(int code) {

        for (TypeCommand command : TypeCommand.values()) {
            if (command.getCode() == code) {
                return command;
            }
        }
        return null;
    }
}

