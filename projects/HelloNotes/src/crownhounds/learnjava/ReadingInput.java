package crownhounds.learnjava;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class ReadingInput {

    private static final String INVALID_YEAR_OF_BIRTH = "Invalid year of birth";
    private static final String INVALID_YEAR_PARSE = "Unable to parse year of birth";


    public static void ParseValues() {
        /*
            parsing is simply converting one datatype to another datatype

            many data types have an associated Datatype Wrapper classes that have parsing methods

                for example, the Integer wrapper class
                    parseInt will try to convert a string to an int
         */

        String numberAsString = "2018";
        System.out.println("numberAsString: " + numberAsString);

        int numberAsInt = Integer.parseInt(numberAsString);
        System.out.println("numberAsInt: " + numberAsInt);

        // TEST string contamination vs int increment
        numberAsString += 1;
        numberAsInt += 1;
        System.out.println("numberAsString + 1: " + numberAsString);
        System.out.println("numberAsInt + 1: " + numberAsInt);
    }

    public static void scanConsoleForUserString() {

        /*
            Scanner = class that reads user input
            new = create instance of Scanner object

            System.out dumps text to the console
            System.in captures text typed into the console and returned to the program
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your name: ");
        // scan console for inputted text from user on next line
        String name = scanner.nextLine();
        // to avoid exceptions, close scanner to release Scanner-utilized memory
        scanner.close();

        System.out.println("Your name is " + name);
    }

    public static void scanConsoleAndParseUserNumber() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth: ");
        // number input validation
        boolean hasNextInt = scanner.hasNextInt();

        if(hasNextInt) {
            // scanner object has nextInt method that will cast string number from console into int variables
            // use scanner.nextLine after nextInt to handle enter key (line separator) input error
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            int currentYear = LocalDateTime.now().getYear();
            int age = currentYear - yearOfBirth;

            // age input validation
            if(age >= 0 && age <= 100) {
                System.out.println(name + "'s age: " + age);
            } else {
                System.out.println(INVALID_YEAR_OF_BIRTH);
            }
        } else {
            System.out.println(INVALID_YEAR_PARSE);
        }

        scanner.close();
    }
}
