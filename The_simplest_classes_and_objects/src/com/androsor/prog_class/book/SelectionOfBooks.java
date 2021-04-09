package com.androsor.prog_class.book;

import java.util.List;

public interface SelectionOfBooks {

    /**
     * Returns a list of books selected by the specified parameters.
     * @param books a list from which to select books.
     * @param parameter parameter by which the selection of books will be made.
     * @return list of books.
     */
    List<Book> getSelectedBooks(List<Book> books, String parameter);

    /**
     * Returns a string with a message for entering parameters
     * @return String with a message.
     */
    String getInputMessage();

    /**
     *Returns a string with a message for outputting parameters
     * @return string with a message.
     */
    String getOutputMessage();
}
