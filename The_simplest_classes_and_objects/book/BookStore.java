package com.androsor.prog_class.book;

import java.util.ArrayList;

public class BookStore {

    private ArrayList<Book> bookList;

    public BookStore(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(String title, String author, String publishingHouse, int yearOfPublishing, int numberOfPages,
                        double price, String bindingType) {
        this.bookList.add(new Book(title, author, publishingHouse, yearOfPublishing, numberOfPages, price, bindingType));
    }

    public ArrayList<Book> creatingListOfAuthorBooks(String author) {
        ArrayList<Book> authorList = new ArrayList<>();
        for (Book books: this.bookList) {
            if (books.getAuthor().equalsIgnoreCase(author)) {
                authorList.add(books);
            }
        }
        return authorList;
    }
// прочитать паттерн КОМАНДА!!!!!!!
    public ArrayList<Book> creatingListOfPublisherBooks(String publishingHouse) {
        ArrayList<Book> publishingHouseList = new ArrayList<>();
        for (Book books : this.bookList) {
            if (books.getPublishingHouse().equalsIgnoreCase(publishingHouse)) {
                publishingHouseList.add(books);
            }
        }
        return publishingHouseList;
    }

    public ArrayList<Book> creatingListOfBooksReleasedAfter(int yearPublishing) {
        ArrayList<Book> yearPublishingList = new ArrayList<>();
        for (Book books : this.bookList) {
            if (books.getYearOfPublishing() > yearPublishing) {
                yearPublishingList.add(books);
            }
        }
        return yearPublishingList;
    }
}
