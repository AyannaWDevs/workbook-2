import java.util.Scanner;


public class fullNameParser {
public static void main(String[]args) { // Main method
    Scanner input = new Scanner(System.in); //accept input
    System.out.print("What is your name? ");
    String fullName = input.nextLine();     //full name to parse
    String[] nameParts = fullName.split("\\s+"); // creates a string array of nameParts and splits the fullName variable

    String firstName = nameParts[0];                    //first part of array assigned firstName
    String lastName = nameParts[nameParts.length - 1]; // declares lastName as the last part of the array -1, which is the last
    //first name print                                 //name's position
    System.out.println("First Name: "+ nameParts[0].trim());
    //middle name print
    if (nameParts.length > 2) { //if array length is >2 (we know there is a middle name and therefore prints all three)
        String middleName = nameParts[1]; //middle name location and declaration
        System.out.println("Middle Name: " + middleName.trim()); //print middle name
    }
    //last name print
    System.out.println("Last Name: " + lastName.trim()); //print last name


}

}
