import java.time.*;
import java.util.*;

// ---------------- Card Class ----------------
class Card {
    String[] borrowers;
    LocalDate[] borrowDates;
    int count;
    static final int MAX_BORROWERS = 50;

    public Card() {
        borrowers = new String[MAX_BORROWERS];
        borrowDates = new LocalDate[MAX_BORROWERS];
        count = 0;
    }

    public void addBorrower(String studentName, LocalDate date) {
        if (count < MAX_BORROWERS) {
            borrowers[count] = studentName;
            borrowDates[count] = date;
            count++;
        }
    }

    public void showHistory() {
        System.out.println("Borrow history:");
        for (int i = 0; i < count; i++) {
            System.out.println(borrowers[i] + " on " + borrowDates[i]);
        }
    }
}

// ---------------- Book Class ----------------
class Book {
    String title;
    String author;
    Card card;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        card = new Card();
    }
}

// ---------------- Student Class ----------------
class Student {
    String name;
    Book[] borrowedBooks;
    LocalDate[] borrowDates;
    int bookCount;
    static final int MAX_BOOKS = 3;

    public Student(String name) {
        this.name = name;
        borrowedBooks = new Book[MAX_BOOKS];
        borrowDates = new LocalDate[MAX_BOOKS];
        bookCount = 0;
    }

    public void borrowBook(Book b, LocalDate date) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println(name + " cannot borrow more than " + MAX_BOOKS + " books.");
            return;
        }
        borrowedBooks[bookCount] = b;
        borrowDates[bookCount] = date;
        bookCount++;
        b.card.addBorrower(name, date);
        System.out.println(name + " borrowed " + b.title + " on " + date);
    }

    public void returnBook(Book b, LocalDate returnDate) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (borrowedBooks[i] == b) {
                found = true;
                long days = ChronoUnit.DAYS.between(borrowDates[i], returnDate);
                if (days > 5) {
                    long fine = (days - 5) * 50;
                    System.out.println(name + " returned " + b.title + " late! Fine: ₹" + fine);
                } else {
                    System.out.println(name + " returned " + b.title + " on time.");
                }
                // Remove the book from borrowedBooks array
                for (int j = i; j < bookCount - 1; j++) {
                    borrowedBooks[j] = borrowedBooks[j + 1];
                    borrowDates[j] = borrowDates[j + 1];
                }
                borrowedBooks[bookCount - 1] = null;
                borrowDates[bookCount - 1] = null;
                bookCount--;
                break;
            }
        }
        if (!found) {
            System.out.println(name + " did not borrow " + b.title);
        }
    }

    public void showBorrowedBooks() {
        System.out.println(name + " currently has:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(borrowedBooks[i].title + " borrowed on " + borrowDates[i]);
        }
    }
}

// ---------------- Library Class ----------------
class Library {
    Book[] books;
    int bookCount;
    static final int MAX_BOOKS = 100;

    public Library() {
        books = new Book[MAX_BOOKS];
        bookCount = 0;
    }

    public void addBook(Book b) {
        if (bookCount < MAX_BOOKS) {
            books[bookCount++] = b;
        }
    }

    public void showBooks() {
        System.out.println("Books in Library:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].title + " by " + books[i].author);
        }
    }
}

// ---------------- Main Class ----------------
public class LibrarySimulation {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("Java Programming", "Author A");
        Book b2 = new Book("Data Structures", "Author B");
        Book b3 = new Book("Algorithms", "Author C");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        Student s1 = new Student("Ram");
        Student s2 = new Student("Shyam");

        LocalDate today = LocalDate.now();

        // Students borrow books
        s1.borrowBook(b1, today);
        s1.borrowBook(b2, today.minusDays(6)); // borrowed 6 days ago
        s2.borrowBook(b3, today.minusDays(3));

        // Students return books
        s1.returnBook(b1, today.plusDays(2)); // on time
        s1.returnBook(b2, today); // late -> fine
        s2.returnBook(b3, today.plusDays(2)); // on time

        // Show history of a book
        b1.card.showHistory();
    }
}