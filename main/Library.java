package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a book to the library's collection
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                if (!b.getDepartment().equals(book.getDepartment())) {
                    System.out.println("A book with the same ISBN already exists in another department.");
                    return;
                }
                System.out.println("Duplicate ISBN. main.Book already exists in the library.");
                return;
            }
        }
        books.add(book);
    }

    // Remove a book by ISBN
    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    // Find books by title (case-insensitive search)
    public List<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    // Find books by author (case-insensitive search)
    public List<Book> findBookByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // List all books in the library
    public List<Book> listAllBooks() {
        return new ArrayList<>(books);
    }

    // List all available books in the library
    public List<Book> listAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}
