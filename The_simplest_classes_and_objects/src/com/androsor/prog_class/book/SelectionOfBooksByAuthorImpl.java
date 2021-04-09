package com.androsor.prog_class.book;

import java.util.List;
import java.util.stream.Collectors;

import static com.androsor.prog_class.book.Parser.parseFirstNameAuthorFromFullName;
import static com.androsor.prog_class.book.Validator.checkForBooks;

public class SelectionOfBooksByAuthorImpl implements SelectionOfBooks {

    private final String INPUT_MESSAGE = "Введите фамилию автора:\n";
    private final String OUTPUT_MESSAGE = "Список книг автора:\n";

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public String getOutputMessage() {
        return OUTPUT_MESSAGE;
    }

    @Override
    public List<Book> getSelectedBooks(List<Book> books, String author) {
        List<Book> result = books.stream()
                .filter(book -> parseFirstNameAuthorFromFullName(book.getAuthor()).equalsIgnoreCase(author))
                .collect(Collectors.toList());
        return checkForBooks(result);
    }
}
