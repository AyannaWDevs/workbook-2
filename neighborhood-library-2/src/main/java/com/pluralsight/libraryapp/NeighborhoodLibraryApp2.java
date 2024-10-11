package com.pluralsight.libraryapp;
import java.util.ArrayList;
import java.util.Scanner;

public class NeighborhoodLibraryApp2 {

  static ArrayList<Book> books = new ArrayList<Book>();
  static Scanner scanner ;
  static boolean isRunning;
  static boolean inViewMode=true;
  static boolean isAnyBookCheckedOut = false;

    public static void main (String[]args){

        //here we are populating out arraylist
        //we use the .add() method and pass in new Book Objects

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


        //Start the App!!
        //We need something to let us know if we the app is running or now.
        isRunning = true;

        while(isRunning) {

            System.out.println(""" 
                    Hello, Welcome to the Neighborhood Library!
                    Enter:
                    'C' to check out a book
                    'V' to view available books
                    'I' to check in a book
                    'S' to show checked out books
                    'X' to exit the application
                    """);
            // once there are more than 2 options to choose from it is better to use a
            //switch statement if not there will be too many nested in-else statements
            //no good!

            //we need the users response
            String input = scanner.nextLine().toUpperCase().trim();


            switch (input) {
                case "C":
                    //if a user selects c or types in C - they want to checkout a book.
                    // that means we want to call the checkout method we created

                    System.out.println(" Please Enter Your name \n");

                    String nameInput = scanner.nextLine().trim();

                    displayLibrary(); // here we call the helper method we created that prints
                    //out all the books in our Arraylist
                    System.out.println(" Please Select a Book Id: ");

                    int bookIdInput = scanner.nextInt();

                    scanner.nextLine();//clears the buffer or close the scanner.

                    // now we have our values we are ready to check out the book or at least

                    boolean success = checkOut(nameInput, bookIdInput);

                    if (success) {
                        System.out.println("Awesome!! The book checkout was a success");
                    } else {
                        System.out.println("Returning to Main Menu");
                    }

                    break; // breaking takes us to the main menu
               
                    case "S": //Show checked out books
                    while(inViewMode){
                        for(Book book : books){ // loop through each book
                        if(book.isCheckedOut()){//if book IS checked out print the book information
                            System.out.println(book.getTitle()+ book.getIsbn()+book.getId());
                            isAnyBookCheckedOut = true;
                            } 
                        }
                        // if no book prints 
                        if(!isAnyBookCheckedOut)
                        System.out.println("No books are currently checked out");
                        System.out.println("Enter 'X' to return to the main menu: ");
                        String exitInput = scanner.nextLine().toUpperCase().trim();
                        if (exitInput.equals("X")) {
                            inViewMode = false;  
                        }
                        break;
                    
     }
                    case "I": // to check in a book
                   while(inViewMode){ System.out.println(" Please Enter Your name \n");
                    String nameInput2 = scanner.nextLine().trim();

                    System.out.println(" Enter the ID number of the book you want to check in: ");
                    int bookIdInput2 = scanner.nextInt();
                    boolean success2 = checkIn(nameInput2, bookIdInput2);
                    if (success2) {
                        System.out.println("Awesome!! The book check in was a success");
                    } 
                        System.out.println("\n Enter 'X' to return to the main menu ");
                        String viewInput = scanner.nextLine().toUpperCase().trim();
                
                        if (viewInput.equals("X")){
                         inViewMode = false;
                }
                break; 
                }
                    case"X":
                    System.out.println("\n Now exiting the application,Bai Bai!\n");
                    System.exit(0);

                    case "V":

                    while(inViewMode){
                    // we want to show books that are not checkout out
                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.println("Title: " + book.getTitle() +" ISBN: "+ book.getIsbn() + " Book ID: " + book.getId() );
                        }
                    }
                    System.out.println("\n Enter 'X' to return to the main menu ");
                        String viewInput = scanner.nextLine().toUpperCase().trim();
                
                        if (viewInput.equals("X")){
                         inViewMode = false;
                }
                break; 
                }
            }
            //out the switch statement the while loop
            // while isRunning is true logic can still be excecuted outside the switch
            // statement but within the while loop

        }
       //outside the while loop
        //when isRunning is made == to false meaning they exited the program this logic can
        //still be executed until the end of the main method

    }

   static public boolean checkOut(String name, int bookId){
        // first we can check to make sure that the name is not empty.
        if(!name.isEmpty() && bookId != 0){
            //then we want to check to see if the book is available or not

            for(Book book: books){

                if(book.getId() == bookId){

                    if(book.isCheckedOut()){
                        System.out.println("Sorry " + book.getTitle() + " is unavailable.");
                    } else {
                        //if the book is available, we want to update the 'checkedOutTo' field
                       // this.checkedOutTo = name;
                        book.setCheckedOutTo(name);
                       // this.isCheckedOut = true;
                        book.setCheckedOut(true);
                        // we also want to change the isCheckedOut field to true;
                        return true;
                    }
                }
            }

        }

        return false;

    }

    public static boolean checkIn(String name, int bookId) {
        if(!name.isEmpty() && bookId != 0){
            //then we want to check in the book
            for (Book book : books) {
                if (book.getId() == bookId && book.isCheckedOut() && book.getCheckedOutTo().equals(name)) {
                        book.setCheckedOutTo(null);
                       // this.isCheckedOut = true;
                        book.setCheckedOut(false);
                        // we also want to change the isCheckedOut field to false; 
                    }
                }
            }
            return true;
    }

    static void displayLibrary(){
        for(Book book: books){
            System.out.println(book);
        }
    }
}