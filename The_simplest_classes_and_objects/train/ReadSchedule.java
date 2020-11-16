package com.androsor.prog_class.train;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ReadSchedule {

    public static Train[] readSchedule() throws IOException {

        List<Train> trains = new ArrayList<>();
        Train[] temp = new Train[0];

        FileReader fr = new FileReader("G:/EPAM Project/Programming_with_classes/The_simplest_classes_and_objects/src/com/androsor/prog_class/train/Trine.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line;

         while ((line = reader.readLine()) != null) {
             String [] lines = line.split("\\s");
             trains.add(new Train(Integer.parseInt(lines[0]), lines[1], lines[2]));
        }

        return trains.toArray(temp);
    }
}
