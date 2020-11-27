package com.androsor.prog_class.book;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookMain {

    public static void main(String[] args) throws IOException {

        BookStore bookList = new BookStore(readBookList());
        showBookStorage(bookList);

        String a1 = enterFromConsole("Автор -> ");
        System.out.printf(" Список книг автора: %s\n", a1);
        ArrayList<Book> authorsBook = bookList.creatingListOfAuthorBooks(a1);
        showBookList(authorsBook);

        String a2 = enterFromConsole(" Издание -> ");
        System.out.printf(" Список книг издания: %s\n", a2);
        ArrayList<Book> publisherBook = bookList.creatingListOfPublisherBooks(a2);
        showBookList(publisherBook);

        String a3 = enterFromConsole("Моложе года издания -> ");
        System.out.printf(" Список книг моложе издания: %s\n", a3);
        ArrayList<Book> releasedAfter = bookList.creatingListOfBooksReleasedAfter(Integer.parseInt(a3));
        showBookList(releasedAfter);
    }

    public static void showBookList(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void showBookStorage(BookStore bookStore) {
        for (int i = 0; i < bookStore.getBookList().size(); i++) {
            System.out.println(bookStore.getBookList().get(i));
        }
    }

    public static ArrayList<Book> readBookList() throws IOException {

        ArrayList<Book> list = new ArrayList<>();

        FileReader fr = new FileReader("G:/EPAM Project/Programming_with_classes/The_simplest_classes_and_objects/src/com/androsor/prog_class/book/BookList.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line;

        while ((line = reader.readLine()) != null) {

            Pattern pattern = Pattern.compile("/");
            String [] lines = pattern.split(line);
            list.add(new Book(lines[0], lines[1], lines[2], Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), Double.parseDouble(lines[5]), lines[6]));
        }
        return list;
    }

    public static String enterFromConsole(String massage) {

        System.out.print(massage);
        Scanner sc = new Scanner(System.in);
//        while (!sc.hasNextInt()) {
//            System.out.print("Введенное значение не является числом. Повторите ввод:\n-> ");
//
//            sc.next();
//        }
        return sc.nextLine();
    }
}















//    public static void showBookStorage(BookStore bookStores) {
//        for (int i = 0; i < bookStores.getBookList().size(); i++) {
//            System.out.print(bookStores.getBookList().get(i));
//        }
//    }




