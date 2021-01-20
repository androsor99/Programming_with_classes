package com.androsor.task4_2_2.util;

import com.androsor.task4_2_2.entity.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ReadingFromFile {

    private static final String NAME_PROPERTY_FILE = "src/com/androsor/task4_2_2/resource/config.properties";
    private static final String KEY_PROPERTY_CITY = "citesFile";
    private static final String KEY_PROPERTY_DISTRICT = "districtsFile";
    private static final String KEY_PROPERTY_REGION = "regionsFile";

    public static String[] getArrayFromFile(String key) throws IOException {

        int ch;
        StringBuilder sb = new StringBuilder();
        Properties prop = new Properties();
        prop.load(new FileInputStream(new File(NAME_PROPERTY_FILE)));
        String pass = prop.getProperty(key);
        File f = new File(pass);

        @SuppressWarnings("resource")
        FileReader reader = new FileReader(f);

        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        return sb.toString().split("\\n");
    }

    public static List<City> getCitesFromFile() throws IOException {

        String[] line_cites = getArrayFromFile(KEY_PROPERTY_CITY);

        List<City> cites = new ArrayList<>();

        for (String line : line_cites) {
            String[] data_city = line.trim().split("\\*");
            cites.add(new City(data_city[0].trim(), Integer.parseInt(data_city[1].trim()), data_city[2].trim(),
                    Double.parseDouble(data_city[3].trim().replaceAll(",", "."))));
        }
        return cites;
    }

    public static List<District> getDistrictsFromFile() throws IOException {

        String[] line_districts = getArrayFromFile(KEY_PROPERTY_DISTRICT);

        List<District> districts = new ArrayList<>();

        for (String line : line_districts) {
            String[] data_district = line.trim().split("\\*");
            districts.add(new District(data_district[0].trim(), data_district[1].trim(), Double.parseDouble(data_district[2].trim()),
                    Double.parseDouble(data_district[3].trim().replaceAll(",", "."))));

        }
        return districts;
    }


    public static List<Region> getRegionsFromFile() throws IOException {

        String[] line_regions = getArrayFromFile(KEY_PROPERTY_REGION);

        List<Region> regions = new ArrayList<>();

        for (String line : line_regions) {
            String[] data_region = line.trim().split("\\*");

            regions.add(new Region(data_region[0].trim(), Double.parseDouble(data_region[2].trim()),Double.parseDouble(data_region[4].trim()), new City(data_region[3].trim())));
        }
        return regions;
    }
}
