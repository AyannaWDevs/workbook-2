package com.pluralsight.libraryapp;

import java.util.ArrayList;
import java.util.Scanner;

public class NeighborhoodLibraryApp2 {

    static ArrayList<Book> books = new ArrayList<Book>();
    static Scanner scanner;
    static boolean isRunning;

    public static void main(String[] args) {

        // Populate the ArrayList with books
        books.add(new Book("Atomic Habits", "0735211299", 1));
        books.add(new Book("The 7 Habits of Highly Effective People", "1982137274", 2));
        books.add(new Book("How to Win Friends and Influence People", "0671027034", 3));
        books.add(new Book("The Power of Positive Thinking", "0743234804", 4));
        books.add(new Book("Man's Search for Meaning", "080701429X", 5));
        books.add(new Book("The Power of Habit", "081298160X", 6));
        books.add(new Book("Essentialism: The Disciplined Pursuit of Less", "0804137382", 7));
        books.add(new Book("The Life-Changing Magic of Tidying Up", "1607747308", 8));
        books.add(new Book("Girl, Stop Apologizing", "1400209609", 9));
        books.add(new Book("Daring Greatly", "1592408419", 10));
        books.add(new Book("Rich Dad Poor Dad", "1612680194", 11));
        books.add(new Book("The Millionaire Next Door", "1589795474", 12));
        books.add(new Book("I Will Teach You to Be Rich", "0761147489", 13));
        books.add(new Book("The Total Money Makeover", "0785289089", 14));
        books.add(new Book("Broke Millennial", "0143130404", 15));
        books.add(new Book("The 4-Hour Workweek", "0307465357", 16));
        books.add(new Book("Outliers: The Story of Success", "0316017930", 17));
        books.add(new Book("The Power of Now", "1577314808", 18));
        books.add(new Book("Mindset: The New Psychology of Success", "0345472322", 19));
        books.add(new Book("The 5 Love Languages", "080241270X", 20));

        scanner = new Scanner(System.in);
        isRunning = true;

        while (isRunning) {
            System.out.println("""
                    Hello, Welcome to the Neighborhood Library!
                    Enter:
                    'C' to check out a book
                    'V' to view available books
                    'I' to check in a book
                    'S' to show checked out books
                    """);

            String input = scanner.nextLine().toUpperCase().trim();

            switch (input) {
                case "C": // Check out a book
                    System.out.println("Please Enter Your Name: ");
                    String nameInput = scanner.nextLine().trim();

                    boolean availableBooks = false;
                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.println("Title: " + book.getTitle() + " ISBN: " + book.getIsbn() + " Book ID: " + book.getId());
                            availableBooks = true;
                        }
                    }
                    if (!availableBooks) {
                        System.out.println("No available books to check out.");
                    } else {
                        System.out.println("Please Select a Book ID: ");
                        int bookIdInput = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer

                        boolean success = checkOut(nameInput, bookIdInput);

                        if (success) {
                            System.out.println("Awesome!! The book checkout was a success.");
                        }
                    }

                    // Prompt to return to the main menu
                    System.out.println("\nEnter 'X' to return to the main menu ");
                    String viewInput = scanner.nextLine().toUpperCase().trim();
                    if (viewInput.equals("X")) {
                        continue; // Go back to the main menu
                    }
                    break;

                case "S": // Show checked-out books
                    boolean anyBooksCheckedOut = false;
                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            System.out.println("Title: " + book.getTitle() + " ISBN: " + book.getIsbn() + " ID: " + book.getId());
                            anyBooksCheckedOut = true;
                        }
                    }
                    if (!anyBooksCheckedOut) {
                        System.out.println("No books are currently checked out.");
                    }

                    // Prompt to return to the main menu
                    System.out.println("Enter 'X' to return to the main menu: ");
                    String exitInput = scanner.nextLine().toUpperCase().trim();
                    if (exitInput.equals("X")) {
                        continue; // Go back to the main menu
                    }
                    break;

                case "I": // Check in a book
                    boolean anyBooksCheckedOutForCheckIn = false;

                    // Check if there are any books checked out
                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            anyBooksCheckedOutForCheckIn = true;
                            break;
                        }
                    }

                    // If no books are checked out, inform the user and exit this case
                    if (!anyBooksCheckedOutForCheckIn) {
                        System.out.println("There are no books currently checked out to check in.");
                    } else {
                        System.out.println("Please Enter Your Name: ");
                        String nameInput2 = scanner.nextLine().trim();

                        System.out.println("Enter the ID number of the book you want to check in: ");
                        int bookIdInput2 = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer

                        boolean success2 = checkIn(nameInput2, bookIdInput2);

                        if (success2) {
                            System.out.println("Awesome! The book check-in was a success.");
                        } else {
                            System.out.println("Check-in failed. Please ensure you entered the correct name and book ID.");
                        }
                    }

                    // Prompt to return to the main menu
                    System.out.println("\nEnter 'X' to return to the main menu ");
                    String viewInput2 = scanner.nextLine().toUpperCase().trim();
                    if (viewInput2.equals("X")) {
                        continue; // Go back to the main menu
                    }
                    break;

                case "V": // View available books
                    boolean anyAvailableBooks = false;
                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.println("Title: " + book.getTitle() + " ISBN: " + book.getIsbn() + " Book ID: " + book.getId());
                            anyAvailableBooks = true;
                        }
                    }
                    if (!anyAvailableBooks) {
                        System.out.println("No available books.");
                    }

                    // Prompt to return to the main menu
                    System.out.println("\nEnter 'X' to return to the main menu ");
                    String viewInput3 = scanner.nextLine().toUpperCase().trim();
                    if (viewInput3.equals("X")) {
                        continue; // Go back to the main menu
                    }
                    break;

                default:
                    System.out.println("Invalid input. Please enter a valid option.");
                    break;
            }
        }
    }

    static public boolean checkOut(String name, int bookId) {
        if (!name.isEmpty() && bookId != 0) {
            for (Book book : books) {
                if (book.getId() == bookId) {
                    if (book.isCheckedOut()) {
                        System.out.println("Sorry, " + book.getTitle() + " is unavailable.");
                        return false;
                    } else {
                        book.setCheckedOutTo(name);
                        book.setCheckedOut(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkIn(String name, int bookId) {
        if (!name.isEmpty() && bookId != 0) {
            for (Book book : books) {
                if (book.getId() == bookId && book.isCheckedOut() && book.getCheckedOutTo().equals(name)) {
                    book.setCheckedOutTo(null);
                    book.setCheckedOut(false);
                    return true;
                }
            }
        }
        return false;
    }
}
