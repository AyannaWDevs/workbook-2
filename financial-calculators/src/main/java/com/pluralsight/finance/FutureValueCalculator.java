package com.pluralsight.finance;
import java.util.Scanner;
public class FutureValueCalculator {
    public static void main (String [] args){
        int selection =0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Which calculator would you like to use?
                Select by number:
                1.Mortgage Calculator
                2.Future Value Calculator
                
                """
        );

        selection = scanner.nextInt();

        if (selection ==1){
            MortgageCalculator.main(args);
        }
        if (selection ==2){
            FutureValueCalculator.main(args);
        }

    }
}
