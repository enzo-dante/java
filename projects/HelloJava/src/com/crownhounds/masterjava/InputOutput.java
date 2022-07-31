package com.crownhounds.masterjava;

import java.time.LocalDateTime;
import java.util.Scanner;

public class InputOutput {

    /*
        ? Sequential Access: a stream of data from/for your program in a defined order with each piece of data following in sequence.

        ? Random Access: allows you to jump about the file or within the file retrieving or overwriting any data in any location within that file that you choose.
     */

    public static void main(String[] args) {

//        ReadingUserInput.scanConsole();
//        ReadingUserInput.scanUserNumber();
        ReadingUserInput.parseValues();
    }

}

class ReadingUserInput {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String PROMPT_NAME = "Enter your name:";
    private static final String PROMPT_BIRTHDATE = "Enter year you were born: ";
    private static final String INPUT = "Input: ";
    private static final String INVALID_INPUT = "Invalid input";

    // OOP CLASS METHODS: static unique object behavior
    // ! STATIC: single variable in-memory shared & associated with class not any single instance
    public static void scanConsole() {
         /*
            ! USER INPUT: create new instance of Scanner class that reads user input

            System.out dumps text to the console
            System.in captures text typed into the console and returned to the program
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println(PROMPT_NAME);

        // ! USER INPUT: scan console for inputted text from user on next line
        String name = scanner.nextLine();

        // ! USER INPUT: close scanner to release Scanner-utilized memory to avoid exceptions
        scanner.close();

        System.out.println(INPUT + name);
    }

    public static void scanUserNumber() {

        /*
            ! USER INPUT numbers: use scanner instance to validate & capture user input numbers

            ? scanner.hasNextInt() = number input validation

            ? scanner.nextInt() = capture & cast string number from console into int variables

            ? scanner.nextLine() = after .nextInt(), handle enter key (line separator) input error
         */
        // ! USER INPUT: create new instance of Scanner class that reads user input
        Scanner scanner = new Scanner(System.in);
        String name;
        int birthYear;
        int currentYear;
        int age;

        System.out.println(PROMPT_BIRTHDATE);

        // number input validation
        if(scanner.hasNextInt()) {

            // ? scanner.nextInt() = capture & cast string number from console into int variables
            birthYear = scanner.nextInt();

            // ? scanner.nextLine() = after .nextInt(), handle enter key (line separator) input error
            scanner.nextLine();

            System.out.println(PROMPT_NAME);
            name = scanner.nextLine();

            currentYear = LocalDateTime.now().getYear();
            age = currentYear - birthYear;

            // age input validation
            if((age > 0) && (age < 100)) {
                System.out.println(name + "'s age: " + age);
            } else {
                System.out.println(INVALID_INPUT);
            }
        } else {
            System.out.println(INVALID_INPUT + ", shutting down...");

            // ! USER INPUT: close scanner to release Scanner-utilized memory to avoid exceptions
            scanner.close();
        }
    }

    public static void parseValues() {
         /*
            ! USER INPUT PARSING/CASTING: converting one datatype to another datatype

                ex) Integer wrapper class
                    parseInt will try to convert a string to an int

            ? USER INPUT string concatenation != int increment
         */

        String birthYear = "1991";

        System.out.println("String birthYear: " + birthYear);

        // ? Datatype Wrapper classes to convert one datatype to another datatype
        System.out.println("Integer birthYear: " + Integer.parseInt(birthYear));

        Util.printSeparator();

        // ? USER INPUT string concatenation != int increment
        int myInt = 100;
        String myString = "100";
        int integerSuffix = 777;

        System.out.println("string concatenation:\n" + (myString + integerSuffix));
        System.out.println("integer addition:\n" + (myInt + integerSuffix));
    }
}