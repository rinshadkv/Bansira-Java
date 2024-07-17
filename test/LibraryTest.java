package test;

import main.Book;
import main.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Effective Java", "Joshua Bloch", "123456789", "Programming", 2008, "Computer Science", true);
        book2 = new Book("Java Concurrency in Practice", "Brian Goetz", "987654321", "Concurrency", 2006, "Software Engineering", true);
        library.addBook(book1);
        library.addBook(book2);
        System.out.println("Library added successfully");
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("Clean Code", "Robert C. Martin", "111111111", "Programming", 2008, "Computer Science", true);
        library.addBook(book3);
        Assertions.assertEquals(3, library.listAllBooks().size());
        System.out.println("book added successfully");
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("123456789");
        Assertions.assertEquals(1, library.listAllBooks().size());
        System.out.println("book removed successfully");
    }

    @Test
    public void testFindBookByTitle() {
        List<Book> books = library.findBookByTitle("Effective Java");
        assertEquals(1, books.size());
        Assertions.assertEquals("Joshua Bloch", books.get(0).getAuthor());
        System.out.println("book found successfully");
    }

    @Test
    public void testFindBookByAuthor() {
        List<Book> books = library.findBookByAuthor("Brian Goetz");
        assertEquals(1, books.size());
        Assertions.assertEquals("Java Concurrency in Practice", books.get(0).getTitle());
        System.out.println("book found successfully");
    }

    @Test
    public void testListAllBooks() {
        List<Book> books = library.listAllBooks();
        assertEquals(2, books.size());
        Assertions.assertEquals("Effective Java", books.get(0).getTitle());
    }


    @Test
    public void testListAvailableBooks() {
        book1.setAvailable(false);
        List<Book> availableBooks = library.listAvailableBooks();
        assertEquals(1, availableBooks.size());
        Assertions.assertEquals("Java Concurrency in Practice", availableBooks.get(0).getTitle());
    }

    @Test
    public void testAddBookToDifferentDepartment() {
        Book book3 = new Book("Effective Java", "Joshua Bloch", "123456789", "Programming", 2008, "Software Engineering", true);
        library.addBook(book3);
        Assertions.assertEquals(2, library.listAllBooks().size(), "main.Book with same ISBN in different department should not be added.");
    }
}
