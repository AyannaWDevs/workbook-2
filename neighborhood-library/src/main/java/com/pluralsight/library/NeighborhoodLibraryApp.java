package com.pluralsight.library;

import java.util.Scanner; // Import scanner for input

public class NeighborhoodLibraryApp {

    public static void main(String[] args) { //Main class declaration

        // we created an array of Book - notes that Book is a class that we created ..  specifically a model
        Book[] books = new Book[20];

        //here we are populating our array
        // we use the new keyword to create an object from the class (blueprint) we created;

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


        Scanner scanner = new Scanner(System.in); //Created a scanner object to accept input

        while (true) { // Not sure what this while loop does
            //Prints the options of user input
            System.out.println(""" 
                    Hello, Welcome to the Neighborhood Library!
                    Enter:
                    'C' to check out a book
                    'V' to view available books
                    'I' to check in a book
                    'S' to show checked out books
                    'X' to exit
                    """);

            String action = scanner.nextLine().trim().toUpperCase(); // accepts input and declares response as 'action',
                                                                        //also trims the spaces and converts to uppercase

            switch (action) { // based on the 'action' input, decides which switch case is ran
                            // -> is shortened switch statement
                case "V" -> showAvailableBooks(books, scanner); // books collection is passed to the method, scanner?
                case "C" -> checkOutBook(books, scanner);       // is needed to accept input
                case "I" -> checkInBook(books, scanner);
                case "S" -> showCheckedOutBooks(books);
                case "X" -> {
                    System.out.println("Exiting the library system. Goodbye!");
                    return; //?
                }
                default -> System.out.println("Invalid input. Please enter 'C', 'V', 'I', 'S', or 'X'."); //if switch case is not met
            }                                                                                              // default runs
        }
    }

    public static void showAvailableBooks(Book[] books, Scanner scanner) {
        System.out.println("Available books:");
        boolean availableBooksFound = false; // this is a variable - a boolean that is being assigned to false
        for (Book book : books) {           //?
            if (!book.isCheckedOut()) { //if book is not cecked out show in availablbleBooksFound and printBookDetails method runs
                book.printBookDetails();
                availableBooksFound = true;
            }
        }

        if (!availableBooksFound) { //? if it is false, print the message below
            System.out.println("No available books at the moment.");
        } else {
            System.out.println("Enter the book ID to check out or 'B' to return to the home screen:");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("B")) {
                System.out.println("Returning to the home screen.");
            } else {
                try {   //input validation, not sure how this makes sense?
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
        books[bookIndex].checkOutBook(personName); //?
    }

    public static void checkOutBook(Book[] books, Scanner scanner) { //create checkoutbook method and passed the Book array
        System.out.print("Enter the book ID to check out: ");          //and scanner as parameters; how is this different than passing the
        int bookIdInput = scanner.nextInt();    // takes bookIdInput as input                         //parameters in the use case section
        scanner.nextLine();             // clears buffer

        if (bookIdInput >= 1 && bookIdInput <= books.length) { // dont understand what bookIdInput <= books.length does
            System.out.print("Enter your name: ");             //does it check if bookIdInput is <= books array length?
            String personName = scanner.nextLine().trim();          //why does this matter?
            books[bookIdInput - 1].checkOutBook(personName); //keeps personName associated with the book ID?
        } else {
            System.out.println("Invalid book ID. Please try again.");
        }
    }

    public static void checkInBook(Book[] books, Scanner scanner) {
        System.out.print("Enter the book ID to check in: ");
        int bookId = scanner.nextInt();     // accepts bookId as input
        scanner.nextLine();

        if (bookId >= 1 && bookId <= books.length && books[bookId - 1].isCheckedOut()) { // not sure?
            books[bookId - 1].checkInBook();
            System.out.println("Book ID " + bookId + " has been successfully checked in.");
        } else {
            System.out.println("Invalid book ID or the book is not checked out. Please try again.");
        }
    }

    public static void showCheckedOutBooks(Book[] books) { //sees if checkOutBooks is false or true somehow..?
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
