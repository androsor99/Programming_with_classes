package com.androsor.prog_class.book;

import static com.androsor.prog_class.book.IOHelper.enterOptions;
import static com.androsor.prog_class.book.IOHelper.enterUserCommandFromConsole;
import static com.androsor.prog_class.book.IOHelper.printBookList;
import static com.androsor.prog_class.book.IOHelper.readBookList;

public class Runner {

    public static void main(String[] args) {
        Library myBooks = new Library(readBookList());
        printBookList(myBooks.getBooks());
        enterOptions();

        while (true) {
            int userCommand = enterUserCommandFromConsole();
            myBooks.selectBooks(userCommand);
        }
    }
}
