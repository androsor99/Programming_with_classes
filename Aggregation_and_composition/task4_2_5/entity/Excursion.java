package com.androsor.task4_2_5.entity;

import java.text.SimpleDateFormat;
import java.util.*;

public class Excursion extends Tour{

    private List<String> showplaces = new ArrayList<>();
    private String guideLanguage = "язык не задан";

    public Excursion() {
        super();
    }

    public Excursion(String country, String id,  int days, Date date, String transportation, boolean food, int price) {
        super(country, id, date, days, transportation, food, price);
        type = "Экскурсия";
    }

    public List<String> getShowplaces() {
        return showplaces;
    }

    public void setShowplaces(List<String> showplaces) {
        this.showplaces = showplaces;
    }

    public String getGuide_language() {
        return guideLanguage;
    }

    public void setGuide_language(String guide_language) {
        this.guideLanguage = guide_language;
    }

    public String receiveSpecificInfo() {

        @SuppressWarnings("resource")
        Formatter ft = new Formatter();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ft.format("%s будет проходить в стране \"%s\".\nЯзык гида - \"%s\"\n Перечень достопримечательностей:\n",type, country, guideLanguage);
        for (String showplace : showplaces) {
            ft.format(" - %s\n", showplace);
        }
            return ft.toString();
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
        Excursion excursion = (Excursion) o;
        return showplaces.equals(excursion.showplaces) &&
                guideLanguage.equals(excursion.guideLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), showplaces, guideLanguage);
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "showplaces=" + showplaces +
                ", guideLanguage='" + guideLanguage + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
