package com.androsor.prog_class.book;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String parseFirstNameAuthorFromFullName(String fullName) {
        Pattern pattern = Pattern.compile("(^[А-Яа-я]*\\S)");
        Matcher matcher = pattern.matcher(fullName);
        String firstName = "";
        while (matcher.find()) {
            firstName = matcher.group();
        }
        return firstName;
    }
}
