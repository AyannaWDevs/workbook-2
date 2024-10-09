package com.pluralsight.library;

// this class is a blueprint for out Book Objects
public class Book {
    //these are our fields they can also be called arguments when used in the contructors
    private String title;
    private String isbn;
    private int id;
    private String checkedOutTo;
    private boolean isCheckedOut;

    //default constructor
    public Book(){

    }


    //this is our 'some args' constructor
    public Book(String title, String isbn, int id) {
        this.title = title;
        this.isbn = isbn;
        this.id = id;
        this.isCheckedOut = false;
        this.checkedOutTo = null;
    }

    //methods assign values to book objects depending on what is input on the NeighborhoodLibraryApp class
    //methods print the information gathered from the main class

    public boolean isCheckedOut() {
        return isCheckedOut; // Returns the current status of the book
    }

    public void printBookDetails() {
        System.out.println(title + " ISBN:" + isbn + " ID #" + id);
        if (isCheckedOut) {
            System.out.println("Checked out to: " + checkedOutTo);
        } else {
            System.out.println("is available for checkout.");
        }
    }

    public void checkOutBook(String personName) {
        if (!isCheckedOut) {
            this.checkedOutTo = personName;
            this.isCheckedOut = true;
            System.out.println(title + " has been checked out to " + personName);
        } else {
            System.out.println(title + " is already checked out to " + checkedOutTo);
        }
    }

    public void returnBook() {
        if (isCheckedOut) {
            System.out.println(checkedOutTo + "returned" + title);
            this.isCheckedOut = false; //?
            this.checkedOutTo = null;
        } else {
            System.out.println(title + "is not checked out currently");
        }
    }

    public void checkInBook() {
        if (isCheckedOut) {
            System.out.println(title + " is now checked in.");
            this.isCheckedOut = false;
            this.checkedOutTo = null;
        } else {
            System.out.println(title + " is not checked out currently.");
        }
    }
}