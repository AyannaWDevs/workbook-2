package com.pluralsight.library;


public class Book {
    private String title;
    private String isbn;
    private int id;
    private String checkedOutTo;
    private boolean isCheckedOut;
    public Book(String title, String isbn, int id){
        this.title = title;
        this.isbn = isbn;
        this.id = id;
        this.isCheckedOut = false;
        this.checkedOutTo = null;
    }
    public void printBookDetails() {
        System.out.println(title +" ISBN:" +isbn +" ID #"+ id);
        if (isCheckedOut){
            System.out.println("Checked out to: " + checkedOutTo);
        } else {
            System.out.println("Book is available for checkout.");
        }
    }
    public void returnBook(){
        if (isCheckedOut) {
            System.out.println(checkedOutTo + "returned" + title);
            this.isCheckedOut = false;
            this.checkedOutTo = null;
        } else {
            System.out.println(title + "is not checked out currently");
        }
}
        }

