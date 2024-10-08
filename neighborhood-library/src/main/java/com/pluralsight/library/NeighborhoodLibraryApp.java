package com.pluralsight.library;

import java.util.Scanner;

public class NeighborhoodLibraryApp {

    public static void main(String[] args) {
        Book[] books = new Book[20];

        books[0] = new Book("Atomic Habits", "0735211299", 1);
        books[1] = new Book("The 7 Habits of Highly Effective People", "1982137274", 2);
        books[2] = new Book("How to Win Friends and Influence People", "0671027034", 3);
        books[3] = new Book("The Power of Positive Thinking", "0743234804", 4);
        books[4] = new Book("Man's Search for Meaning", "080701429X", 5);
        books[5] = new Book("The Power of Habit", "081298160X", 6);
        books[6] = new Book("Essentialism: The Disciplined Pursuit of Less", "0804137382", 7);
        books[7] = new Book("The Life-Changing Magic of Tidying Up", "1607747308", 8);
        books[8] = new Book("Girl, Stop Apologizing", "1400209609", 9);
        books[9] = new Book("Daring Greatly", "1592408419", 10);
        books[10] = new Book("Rich Dad Poor Dad", "1612680194", 11);
        books[11] = new Book("The Millionaire Next Door", "1589795474", 12);
        books[12] = new Book("I Will Teach You to Be Rich", "0761147489", 13);
        books[13] = new Book("The Total Money Makeover", "0785289089", 14);
        books[14] = new Book("Broke Millennial", "0143130404", 15);
        books[15] = new Book("The 4-Hour Workweek", "0307465357", 16);
        books[16] = new Book("Outliers: The Story of Success", "0316017930", 17);
        books[17] = new Book("The Power of Now", "1577314808", 18);
        books[18] = new Book("Mindset: The New Psychology of Success", "0345472322", 19);
        books[19] = new Book("The 5 Love Languages", "080241270X", 20);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Hello, Welcome to the Neighborhood Library!
                    Enter:
                    'C' to check out a book
                    'V' to view available books
                    'I' to check in a book
                    'S' to show checked out books
                    'X' to exit
                    """);

            String action = scanner.nextLine().trim().toUpperCase();

            switch (action) {
                case "V" -> showAvailableBooks(books, scanner);
                case "C" -> checkOutBook(books, scanner);
                case "I" -> checkInBook(books, scanner);
                case "S" -> showCheckedOutBooks(books);
                case "X" -> {
                    System.out.println("Exiting the library system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid input. Please enter 'C', 'V', 'I', 'S', or 'X'.");
            }
        }
    }

    public static void showAvailableBooks(Book[] books, Scanner scanner) {
        System.out.println("Available books:");
        boolean availableBooksFound = false;
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                book.printBookDetails();
                availableBooksFound = true;
            }
        }

        if (!availableBooksFound) {
            System.out.println("No available books at the moment.");
        } else {
            System.out.println("Enter the book ID to check out or 'B' to return to the home screen:");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("B")) {
                System.out.println("Returning to the home screen.");
            } else {
                try {
                    int bookId = Integer.parseInt(input);
                    if (bookId >= 1 && bookId <= books.length && !books[bookId - 1].isCheckedOut()) {
                        checkOutBookById(books, bookId - 1, scanner);
                    } else {
                        System.out.println("Invalid book ID or the book is already checked out. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid book ID or 'B' to return.");
                }
            }
        }
    }

    public static void checkOutBookById(Book[] books, int bookIndex, Scanner scanner) {
        System.out.print("Enter your name: ");
        String personName = scanner.nextLine().trim();
        books[bookIndex].checkOutBook(personName);
    }

    public static void checkOutBook(Book[] books, Scanner scanner) {
        System.out.print("Enter the book ID to check out: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        if (bookId >= 1 && bookId <= books.length) {
            System.out.print("Enter your name: ");
            String personName = scanner.nextLine().trim();
            books[bookId - 1].checkOutBook(personName);
        } else {
            System.out.println("Invalid book ID. Please try again.");
        }
    }

    public static void checkInBook(Book[] books, Scanner scanner) {
        System.out.print("Enter the book ID to check in: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        if (bookId >= 1 && bookId <= books.length && books[bookId - 1].isCheckedOut()) {
            books[bookId - 1].checkInBook();
            System.out.println("Book ID " + bookId + " has been successfully checked in.");
        } else {
            System.out.println("Invalid book ID or the book is not checked out. Please try again.");
        }
    }

    public static void showCheckedOutBooks(Book[] books) {
        System.out.println("Checked out books:");
        boolean checkedOutBooksFound = false;
        for (Book book : books) {
            if (book.isCheckedOut()) {
                book.printBookDetails();
                checkedOutBooksFound = true;
            }
        }
        if (!checkedOutBooksFound) {
            System.out.println("No books are currently checked out.");
        }
    }
}
