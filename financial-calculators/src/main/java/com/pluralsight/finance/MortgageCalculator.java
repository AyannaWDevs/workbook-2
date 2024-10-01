package com.pluralsight.finance;
 import java.util.Scanner;
    public class MortgageCalculator {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            //accepts input
            System.out.println("Enter principal amount of loan in dollars");
            double principalAmount = scanner.nextDouble();
            System.out.println("Enter the percentage interest amount ");
            double interestPercent = scanner.nextDouble();
            System.out.println("Enter the loan length in years");
            double loanLengthinYears = scanner.nextDouble();
            //percent to decimal
            double monthlyInterest = (interestPercent/100)/12;
            int numberOfPayments = (int)(loanLengthinYears*12);
            // calculates future value including interest
            double amount = Math.pow(1+monthlyInterest,numberOfPayments);
            double monthlyPayment = principalAmount *(monthlyInterest*amount/(amount-1));
            //print result
            double totalInterest = ((interestPercent/100)*principalAmount)*loanLengthinYears;
            System.out.println("You will incur a total interest of " +totalInterest);
            System.out.print("Your monthly payment is: " + monthlyPayment);


        }
    }

