package com.pluralsight.highscore;
import java.util.Scanner;
public class HighScoreWins {
    public static void main(String[] args) {
        System.out.println("Enter the game score in the format: Home:Visitor|21:9");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] givenInfo = input.split("[:|]");
        int firstTeamPoints = Integer.parseInt(givenInfo[2]);
        int secondTeamPoints = Integer.parseInt(givenInfo[3]);
        if (firstTeamPoints > secondTeamPoints) {
            System.out.println("Winner: " + givenInfo[0]);
        } else {
            System.out.println("Winner: " + givenInfo[1]);
        }
    }
}
