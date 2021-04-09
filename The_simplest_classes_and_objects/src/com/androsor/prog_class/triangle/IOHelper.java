package com.androsor.prog_class.triangle;

import java.util.Random;

public class IOHelper {

    public static double[] getRandomCoordinates() {
        return new Random().doubles(-100, 100).distinct().limit(2).toArray();
    }
}
