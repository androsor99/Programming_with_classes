package com.androsor.task5.entity;

public enum TourType {

    RECREATION("Отдых"),
    EXCURSION("Экскурсия"),
    TREATMENT("Лечение"),
    SHOPPING("Закупки"),
    CRUISE("Круиз");

    private final String type;

    TourType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
