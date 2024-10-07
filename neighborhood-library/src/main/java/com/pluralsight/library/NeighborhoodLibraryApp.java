package com.pluralsight.library;

public class NeighborhoodLibraryApp {
    public static void main(String[] args) {
        Book b;
        b = new Book("nameoftheBook", "22",0);
        System.out.println(b);
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

        for (Book book : books) {
                book.printBookDetails();
            System.out.println();
            }
        }
    }