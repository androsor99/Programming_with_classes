package com.androsor.prog_class.book;

import java.util.List;

import static com.androsor.prog_class.book.IOHelper.enterParameterFromConsole;
import static com.androsor.prog_class.book.IOHelper.printBookList;

public class Library {

    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void selectBooks(int code) {
        try {
            SelectionOfBooks selectionOfBooks = SelectionType.getSelectionTypeByCode(code).getSelectionOfBooks();
            String inputMessage = selectionOfBooks.getInputMessage();
            String parameter = enterParameterFromConsole(inputMessage);
            String outputMessage = selectionOfBooks.getOutputMessage();
            System.out.println(outputMessage);
            List<Book> selectedBooks = selectionOfBooks.getSelectedBooks(this.books, parameter);
            printBookList(selectedBooks);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
