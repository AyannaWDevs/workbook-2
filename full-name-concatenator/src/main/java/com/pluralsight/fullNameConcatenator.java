package com.pluralsight;
import java.util.Scanner;
public class fullNameConcatenator {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        input = new Scanner(System.in);
        String firstName = getUserInput("Please enter your first name: ");
        String middleName = getUserInput("Please enter your middle name: ");
        String lastName = getUserInput("Please enter your last name: ");
        String suffix = getUserInput("What is your name suffix? ");
        String fullName =  firstName.trim() +
                (middleName.isBlank() ? "" : " " + middleName.trim()) +
                " " + lastName.trim() +(suffix.isBlank()?"": (", " + suffix.trim() )) ;
        {
            System.out.print("Your full name is: " + fullName);

        }
        }
    public static String getUserInput (String prompt){
        System.out.print(prompt);
        return input.nextLine();
    }
}