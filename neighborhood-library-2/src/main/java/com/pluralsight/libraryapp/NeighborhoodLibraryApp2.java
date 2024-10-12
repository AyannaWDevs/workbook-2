package com.pluralsight.libraryapp;

import java.util.ArrayList;
import java.util.Scanner;

public class NeighborhoodLibraryApp2 {
    static ArrayList<Book> books = new ArrayList<Book>(); // created an array of Book objects accessible to the entire class
    static Scanner scanner;     // used to capture input
    static boolean isRunning;   // declares isRunning variable to return boolean type across entire class

    public static void main(String[] args) {

        // Populate the ArrayList of book objects
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

        scanner = new Scanner(System.in); //initialize scanner
        isRunning = true;   //sets default value of isRunning to true so that we can break when isRunning is false

        while (isRunning) { //while isRunning is true, print the following
            System.out.println("""
                    Hello, Welcome to the Neighborhood Library!
                    Enter:
                    'C' to check out a book
                    'V' to view available books
                    'I' to check in a book
                    'S' to show checked out books
                    """);

            String input = scanner.nextLine().toUpperCase().trim(); //take user input

            switch (input) {
                case "C": // Check out a book

                    boolean availableBooks = false; //initializes availableBooks to false
                    for (Book book : books) { //loops through book array
                        if (!book.isCheckedOut()) {     //if book is available, print the book information
                            System.out.println("Title: " + book.getTitle() + " ISBN: " + book.getIsbn() + " Book ID: " + book.getId());
                            availableBooks = true; //set available books as available as long as they are not checked out
                        }
                    }
                    if (!availableBooks) { //if there are no available Books print the following
                        System.out.println("No available books to check out.");
                    } else { //otherwise, prompt the user to check out a book based on the id

                        System.out.println("Please Enter Your Name: ");
                        String nameInput = scanner.nextLine().trim();
                        System.out.println("Please Select a Book ID: ");
                        int bookIdInput = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer

                        boolean success = checkOut(nameInput, bookIdInput);

                        if (success) {
                            System.out.println("Awesome!! The book checkout was a success.");
                        }
                        // Prompt to return to the main menu
                        System.out.println("\nEnter 'X' to return to the main menu ");
                        String viewInput = scanner.nextLine().toUpperCase().trim();
                        if (viewInput.equals("X")) {
                            continue; // Go back to the main menu
                        }
                        break;
                    }


                case "S": // Show checked-out books
                    boolean anyBooksCheckedOut = false; // initializes to false
                    for (Book book : books) {
                        if (book.isCheckedOut()) { //calls isCheckedOut getter method;iterates through checked out books
                            //if book is checked out print the book
                            System.out.println("Title: " + book.getTitle() + " ISBN: " + book.getIsbn() + " ID: " + book.getId());
                            anyBooksCheckedOut = true; //if a book is checked out set anyBooksCheckedOut to true
                        }
                    }
                    if (!anyBooksCheckedOut) { //if there are no books checked out print the following
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
                    boolean anyBooksForCheckIn = false; //initialized to false

                    // Check if there are any books checked out and sets anyBooksForCheckIn to true if so
                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            anyBooksForCheckIn = true;
                            break;
                        }
                    }
                    if (!anyBooksForCheckIn) { //if there are no books for check in display the following
                                                //and exit the case
                        System.out.println("There are no books currently checked out to check in.");

                    } else {
                        System.out.println("Please Enter Your Name: ");
                        String nameInput2 = scanner.nextLine().trim();

                        System.out.println("Enter the ID number of the book you want to check in: ");
                        int bookIdInput2 = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer

                        boolean success2 = checkIn(nameInput2, bookIdInput2); //input is entered as parameters in CheckIn method

                        if (success2) { //if success2 is true
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
                    break; //don't remember what this is for..?

                case "V": // View available books
                    boolean anyAvailableBooks = false; //initialize to false so that we can check if it is true
                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.println("Title: " + book.getTitle() + " ISBN: " + book.getIsbn() + " Book ID: " + book.getId());
                            anyAvailableBooks = true; //there are available books if there are books that are not checked out
                        }
                    }
                    if (!anyAvailableBooks) {//if there are not any available books print the following
                        System.out.println("No available books.");
                    }

                    // Prompt to return to the main menu
                    System.out.println("\nEnter 'X' to return to the main menu ");
                    String viewInput3 = scanner.nextLine().toUpperCase().trim();
                    if (viewInput3.equals("X")) {
                        continue; // Go back to the main menu
                    }
                    break;

                default: //input validation as default
                    System.out.println("Invalid input. Please enter a valid option.");
                    break;
            }
        }
    }

    static public boolean checkOut(String name, int bookId) { //checkout method accepts parameters
        if (!name.isEmpty() && bookId != 0) {   //if both are filled iterate through books and get book associated with the id
            for (Book book : books) {
                if (book.getId() == bookId) {
                    if (book.isCheckedOut()) { //self explanatory
                        System.out.println("Sorry, " + book.getTitle() + " is unavailable.");
                        return false; // return false to checkOut method because it was unsuccessful
                    } else {
                        book.setCheckedOutTo(name);
                        book.setCheckedOut(true);
                        return true; //sets the name and checkedOut to true and returns true because
                                    //it was successful and has values to set here
                    }
                }
            }
        }
        return false;// don't know ; in other exceptions print false
    }

    public static boolean checkIn(String name, int bookId) {    //takes name and bookId as parameters
        if (!name.isEmpty() && bookId != 0) { //if both are filled out, iterate through books
                                                //if the book id and the name equals the name of the person its  checked out to
            for (Book book : books) {           //checkout will return true and set default values to CheckedOutTo and setCheckedOut methods
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
