package com.androsor.task4_2_5.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Recovery extends Tour{

    private String sanatorium;
    private String illness = "болезнь не задана";

    public Recovery() {
        super();
    }

    public Recovery(String country, String id, Date date, int days, String transportation, boolean food, int price) {
        super(country, id, date, days, transportation, food, price);
        type = "Оздоровление";
    }

    public String getSanatorium() {
        return sanatorium;
    }

    public void setSanatorium(String sanatorium) {
        this.sanatorium = sanatorium;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String receiveSpecificInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Страна - \"%s\"\nСанаторий - \"%s\".\nДанный тур рекомендован при заболевании \"%s\"\n",country, sanatorium, illness);
    }

    @Override
    public boolean filterTourByCountry(String country) {
        return super.filterTourByCountry(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Recovery recovery = (Recovery) o;
        return sanatorium.equals(recovery.sanatorium) &&
                illness.equals(recovery.illness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sanatorium, illness);
    }

    @Override
    public String toString() {
        return "Recovery{" +
                "illness='" + illness + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
