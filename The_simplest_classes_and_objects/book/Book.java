package com.androsor.prog_class.book;

import java.util.Objects;

public class Book {
    private static int startId = 0;
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int yearOfPublishing;
    private int numberOfPages;
    private double price;
    private String bindingType;


    public Book(String title, String author, String publishingHose, int yearOfPublishing, int numberOfPages,
                double price, String bindingType) {
        this.id = ++startId;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHose;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.bindingType = bindingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                yearOfPublishing == book.yearOfPublishing &&
                numberOfPages == book.numberOfPages &&
                Double.compare(book.price, price) == 0 &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                publishingHouse.equals(book.publishingHouse) &&
                bindingType.equals(book.bindingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publishingHouse, yearOfPublishing, numberOfPages, price, bindingType);
    }

    @Override
    public String toString() {
        return String.format("№%05d \"%s\", %s, %s; %d г.; %d стр.; $%.2f; переплёт: %s.",
                id, title, author, publishingHouse, yearOfPublishing, numberOfPages,
                price, bindingType);
    }
}
