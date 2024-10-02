package com.pluralsight.finance;
import java.util.Scanner;
public class FutureValueCalculator {
    public static void main (String [] args){
// get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter initial deposit");
        double initialDeposit = scanner.nextDouble();
        System.out.println("Enter interest rate as in percent");
        double interestRate = scanner.nextDouble();
        System.out.println("Enter the number of years");
        int numOfYears = scanner.nextInt();

        //interest rate to decimal
       double interestDecimal = interestRate/100;
        double totalAmount = (initialDeposit *Math.pow(1+(interestDecimal/365),(numOfYears*365)));
        double  interest = totalAmount-initialDeposit;
        //Print calculations
        System.out.printf("The total ending amount is: $%.2f%n",totalAmount);
        System.out.printf("The total interest incurred is: $%.2f%n", (interest));

    }
}
