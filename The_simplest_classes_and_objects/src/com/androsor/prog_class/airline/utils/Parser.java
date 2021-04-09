package com.androsor.prog_class.airline.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String parseDayAndTimeFromString(String line, String matcherGroupName) {
        Pattern pattern = Pattern.compile("(?<Day>^[А-Яа-я]*)\s(?<Time>\\d{2}:\\d{2})");
        Matcher matcher = pattern.matcher(line);
        String temp = "";
        while (matcher.find()) {
            temp = matcher.group(matcherGroupName);
        }
        return temp;
    }
}
