package com.androsor.prog_class.book;

import java.util.List;

public class Validator {

    public static List<Book> checkForBooks(List<Book> books) {
        if (!books.isEmpty()) {
            return books;
        } else {
            throw new IllegalArgumentException("Ничего не найдено.");
        }
    }
}
