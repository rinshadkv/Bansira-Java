package main;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> findBookByTitle();
                case 4 -> findBookByAuthor();
                case 5 -> listAllBooks();
                case 6 -> listAvailableBooks();
                case 7 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Is the book available (true/false): ");
        boolean isAvailable = scanner.nextBoolean();
        scanner.nextLine();

        Book book = new Book(title, author, ISBN, genre, publicationYear, department, isAvailable);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
        System.out.println("Book removed successfully!");
    }

    private static void findBookByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        List<Book> books = library.findBookByTitle(title);
        books.forEach(System.out::println);
    }

    private static void findBookByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();
        List<Book> books = library.findBookByAuthor(author);
        books.forEach(System.out::println);
    }

    private static void listAllBooks() {
        List<Book> books = library.listAllBooks();
        books.forEach(System.out::println);
    }

    private static void listAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        books.forEach(System.out::println);
    }
}
