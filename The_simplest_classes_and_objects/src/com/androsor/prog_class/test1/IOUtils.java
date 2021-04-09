package com.androsor.prog_class.test1;

/**
 * Reads data from the console and prints to the console.
 */
public class IOUtils {

    public static void printToConsole(String string, double value) {
        System.out.print(string);
        System.out.printf("%.3f;\n", value);
    }
}
