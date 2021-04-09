package com.androsor.prog_class.book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IOHelper {

    public static String enterParameterFromConsole(String massage) {
        System.out.print(massage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int enterUserCommandFromConsole() {
        int userCommand = Integer.parseInt(enterParameterFromConsole("Введите команду:\n-> "));
        if (userCommand == 9) {
            System.exit(9);
        }
        return userCommand;
    }

    public static void enterOptions() {
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("Введите -%d- чтобы вывести книги автора\n", SelectionType.AUTHOR.getTypeCode());
        System.out.printf("Введите -%d- чтобы вывести книги издания\n", SelectionType.PUBLISHER.getTypeCode());
        System.out.printf("Введите -%d- чтобы вывести книги моложе года издания\n", SelectionType.RELEASE_DATE.getTypeCode());
        System.out.print("Введите -9- чтобы выйти из программы\n");
        System.out.println("-----------------------------------------------------------------");
    }

    public static List<Book> readBookList() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/androsor/prog_class/book/BookList.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Pattern pattern = Pattern.compile("/");
                String[] lines = pattern.split(line);
                books.add(new Book(lines[0], lines[1], lines[2], Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), Double.parseDouble(lines[5]), lines[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void printBookList(List<Book> books) {
        books.forEach(System.out::println);
    }
}
