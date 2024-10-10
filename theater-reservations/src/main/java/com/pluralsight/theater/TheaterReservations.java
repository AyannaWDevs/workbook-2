package com.pluralsight.theater;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[]args){
     Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your full name: ");
        String fullName = scanner.nextLine();
        //parse name
        String[] tokens = fullName.split(" ");
        System.out.println("What date will you be coming? (MM/dd/yyyy): ");
        String date = scanner.nextLine();
        System.out.println("How many tickets would you like?");
        int numOfTickets = scanner.nextInt();
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate formattedDate = LocalDate.parse(date,formatter);
        if (numOfTickets==1){
            System.out.println(numOfTickets + " ticket reserved for "+formattedDate +" under " +tokens[1]+", "+tokens[0]);
        }
        else {
            System.out.println(numOfTickets + " tickets reserved for "+formattedDate +" under " +tokens[1]+", "+tokens[0]);
        }

    }
}
