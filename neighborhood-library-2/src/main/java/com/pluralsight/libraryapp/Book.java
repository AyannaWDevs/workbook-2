package com.pluralsight.libraryapp;

public class Book {
    // this class is a blueprint for out library Book Objects
    //these are our fields
        private String title;
        private String isbn;
        private int id;
        private String checkedOutTo; //the person that the book is checked out to
        private boolean isCheckedOut; // lets us know if the book is available or not


        public Book(){

        }

    //this is a constructor that assigns certain attributes to Book objects?
    public Book (String title, String isbn, int id){
        this.title = title;
        this.isbn = isbn;
        this.id = id;
        this.checkedOutTo = null; // Default - book is not checked out to anyone
        this.isCheckedOut = false ;// the default value of a book should be that it not checked out
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", id=" + id +
                ", checkedOutTo='" + checkedOutTo + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                '}';
    }
}
