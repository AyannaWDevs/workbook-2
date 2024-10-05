import java.util.Scanner;


public class fullNameParser {
public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    System.out.print("What is your name? ");
    String fullName = input.nextLine();
    String[] nameParts = fullName.split("\\s+");

    String firstName = nameParts[0];
    //last name condition to print
    String lastName = nameParts[nameParts.length - 1];
    //first name print
    System.out.println("First Name: "+ nameParts[0].trim());
    //middle name print
    if (nameParts.length > 2) {
        String middleName = nameParts[1];
        System.out.println("Middle Name: " + middleName.trim());
    }
    //last name print
    System.out.println("Last Name: " + lastName.trim());


}

}
