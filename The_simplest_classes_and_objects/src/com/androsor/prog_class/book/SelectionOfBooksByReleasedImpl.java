package com.androsor.prog_class.book;

import java.util.List;
import java.util.stream.Collectors;

import static com.androsor.prog_class.book.Validator.checkForBooks;

public class SelectionOfBooksByReleasedImpl implements SelectionOfBooks {

    private final String INPUT_MESSAGE = "Введите год издания:\n";
    private final String OUTPUT_MESSAGE = "Список книг моложе издания(год)";

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public String getOutputMessage() {
        return OUTPUT_MESSAGE;
    }

    @Override
    public List<Book> getSelectedBooks(List<Book> books, String yearPublishing) {
        List<Book> result = books.stream()
                .filter(book -> book.getYearOfPublishing() > Integer.parseInt(yearPublishing))
                .collect(Collectors.toList());
        return checkForBooks(result);
    }
}
