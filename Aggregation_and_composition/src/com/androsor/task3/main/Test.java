package com.androsor.task3.main;

import com.androsor.task3.entity.City;
import com.androsor.task3.entity.District;
import com.androsor.task3.entity.Region;
import com.androsor.task3.entity.State;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        City minsk = new City("Минск", 348.84, 2018.281, 1067);
        City brest = new City("Брест", 146.12, 339.7, 1017);
        City grodno = new City("Гродно", 142.11, 356.9, 1128);
        City vitebsk = new City("Витебск", 134.6, 364.8, 974);
        City gomel = new City("Гомель", 139.77, 510.3, 1142);
        City mogilev = new City("Могилев", 118.5, 357.1, 1267);

        List<City> cites = new ArrayList<>();
        cites.add(minsk);
        cites.add(brest);
        cites.add(grodno);
        cites.add(vitebsk);
        cites.add(gomel);
        cites.add(mogilev);

        District minskDistr = new District("Минский", 500, 3000,  minsk);
        minskDistr.addAdministrativeUnits(cites);
        District brestDistr = new District("Брестский", 600, 1000, brest);
        brestDistr.addAdministrativeUnits(cites);
        District grodnoDistr = new District("Гродненский", 700, 2000, grodno);
        grodnoDistr.addAdministrativeUnits(cites);
        District vitebskDistr = new District("Витебский", 800, 3000, vitebsk);
        vitebskDistr.addAdministrativeUnits(cites);
        District gomelDistr = new District("Гомельский", 900, 4000, gomel);
        gomelDistr.addAdministrativeUnits(cites);
        District mogilevDistr = new District("Могилёвский", 1000, 5000, mogilev);
        mogilevDistr.addAdministrativeUnits(cites);

        List<District> districts = new ArrayList<>();
        districts.add(minskDistr);
        districts.add(brestDistr);
        districts.add(grodnoDistr);
        districts.add(vitebskDistr);
        districts.add(gomelDistr);
        districts.add(mogilevDistr);

        Region minskRegion = new Region("Минская", minsk);
        minskRegion.addAdministrativeUnits(districts);
        Region brestRegion = new Region("Брестская", brest);
        brestRegion.addAdministrativeUnits(districts);
        Region grodnoRegion = new Region("Гродненская", grodno);
        grodnoRegion.addAdministrativeUnits(districts);
        Region vitebskRegion = new Region("Витебская", vitebsk);
        vitebskRegion.addAdministrativeUnits(districts);
        Region gomelRegion = new Region("Гомельская", gomel);
        gomelRegion.addAdministrativeUnits(districts);
        Region mogilevRegion = new Region("Могилёвская", mogilev);
        mogilevRegion.addAdministrativeUnits(districts);

        List<Region> regions = new ArrayList<>();
        regions.add(minskRegion);
        regions.add(brestRegion);
        regions.add(grodnoRegion);
        regions.add(vitebskRegion);
        regions.add(gomelRegion);
        regions.add(mogilevRegion);

        State belarus = new State("Беларусь", minsk);
        belarus.addAdministrativeUnits(regions);
        //belarus.addAdministrativeUnits(regions);
        //belarus.addAdministrativeUnit(minskRegion);
        System.out.println("Cтолица - " + belarus.getAdministrativeUnitCenter().getName());
        System.out.println("Количество областей - " + belarus.getNumberOfAdministrativeUnits());
        System.out.println("Площадь - " + belarus.getArea());
        System.out.println("____________________");
        System.out.println("Областные центры:");
        belarus.printCompositionOfState();
    }
}
