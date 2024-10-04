import java.util.Scanner;


public class fullNameParser {
public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    System.out.print("What is your name? ");
    String fullName = input.nextLine();
    String firstName;
    String middleName;
    String lastName;
    String[] nameParts = fullName.split(" ");
    System.out.println("First Name: "+ nameParts[0]);
    System.out.println("Middle Name: "+ nameParts[1]);
    System.out.println("Last Name: "+ nameParts[2]);
}
}
