package com.androsor.prog_class.airline.view;

import com.androsor.prog_class.airline.entity.Airline;
import com.androsor.prog_class.airline.entity.DayOfWeek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ReadingFlightSchedule {

    public static ArrayList<Airline> readFlightSchedule() throws IOException, ParseException {

        ArrayList<Airline> flightSchedule = new ArrayList<>();

        FileReader fr = new FileReader("G:/EPAM Project/Programming_with_classes/The_simplest_classes_and_objects/src/com/androsor/prog_class/airline/view/FlightSchedule.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line;

        while ((line = reader.readLine()) != null) {

            Pattern pattern = Pattern.compile("\\|");
            String[] lines = pattern.split(line);
            String linesDay = lines[4];
            Pattern pattern1 = Pattern.compile("\\.");
            String[] linesDays = pattern1.split(linesDay);
//            ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(linesDays));
//            DayOfWeek[] dayOfWeeksss = new DayOfWeek[arrayList.size()];
//            for (int i = 0; i < arrayList.size(); i++) {
//                dayOfWeeksss[i] = DayOfWeek.valueOf(arrayList.get(i));
//            }


            flightSchedule.add(new Airline(lines[0], lines[1], lines[2], Airline.ft.parse(lines[3]), linesDays));

        }
        return flightSchedule;
    }




}
