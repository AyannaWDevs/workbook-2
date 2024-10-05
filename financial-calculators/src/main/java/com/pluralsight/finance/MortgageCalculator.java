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
            double loanLengthInYears = scanner.nextDouble();
            //percent to decimal
            double interestAmount = interestPercent/100;
            double monthlyInterest = (interestPercent/100)/12;
            int numberOfPayments = (int)(loanLengthInYears*12);
            // calculates future value including interest
            double amount = Math.pow(1+monthlyInterest,numberOfPayments);
            double monthlyPayment = principalAmount *(monthlyInterest*amount/(amount-1));
            //print result
            double total = (interestPercent/100)*principalAmount*loanLengthInYears;
            double paymentsnum= loanLengthInYears*12;
            double interest =(monthlyPayment*paymentsnum)-principalAmount;
            System.out.printf("The total interest incurred is: $%,.2f%n",interest);
            System.out.printf("Your monthly payment is: $%.2f%n",monthlyPayment);


        }
    }

