package com.androsor.task4_2_2.main;

/**
 * Create an object of the State class using the classes Region, District, City. Methods: display the capital,
 * number of regions, area, regional centers on the console.
 */

import com.androsor.task4_2_2.entity.City;
import com.androsor.task4_2_2.entity.District;
import com.androsor.task4_2_2.entity.Region;
import com.androsor.task4_2_2.entity.State;
import com.androsor.task4_2_2.logic.StateLogic;
import com.androsor.task4_2_2.view.Viewer;

import java.io.IOException;

public class StateMain {

    public  static void main(String [] args) {

        StateLogic stateLogic = new StateLogic();
        Viewer viewer = new Viewer();

        try {
            State belarus = stateLogic.createState();
            viewer.infoAboutState(belarus);
            viewer.printListRegion(belarus.getRegions());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Region region = stateLogic.createRegion("брестская");
            viewer.infoAboutRegion(region);
           viewer.printListDistrict(region.getDistricts());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            District district = stateLogic.createDistrict("минский");
            viewer.infoAboutDistrict(district);
            viewer.printListCity(district.getCites());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            City city = stateLogic.createCity("пружаны");
            viewer.infoAboutCity(city);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}