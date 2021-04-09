package com.androsor.prog_class.book;

import java.util.List;
import java.util.stream.Collectors;

import static com.androsor.prog_class.book.Validator.checkForBooks;

public class SelectionOfBooksByPublisherImpl implements SelectionOfBooks {

    private final String INPUT_MESSAGE = "Введите издание:\n";
    private final String OUTPUT_MESSAGE = "Список книг издания:\n";

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public String getOutputMessage() {
        return OUTPUT_MESSAGE;
    }

    @Override
    public List<Book> getSelectedBooks(List<Book> books, String publishingHouse) {
        List<Book> result = books.stream()
                .filter(book -> book.getPublishingHouse().equalsIgnoreCase(publishingHouse))
                .collect(Collectors.toList());
        return checkForBooks(result);
    }
}
