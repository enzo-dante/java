package com.crownhounds.masterjava;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CallStackExceptions {
    /*
        ! CALL STACK: a list of all the method calls at any given point during a program's execution up to a completion or crash
            each thread of execution has its own call stack

        ? CALL STACK TRACE upwards propagation: every new called method is placed onto the CALL STACK; on a method's return removes it from the CALL STACK.
     */

    public static void main(String[] args) {

//        ExceptionHandling exceptionHandling = new ExceptionHandling();
        CatchThrowException catchThrowException = new CatchThrowException();

    }
}

class ExceptionHandling extends Notes {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String LOOK_BEFORE_YOU_LEAP = "LOOK BEFORE YOU LEAP (LBYL):\n";
    private static final String EASY_ASK_FORGIVENESS_THAN_PERMISSION = "EASY_ASK_FORGIVENESS_THAN_PERMISSION (EAFTP):\n";
    private static final String USER_INPUT = "Scanner USER INPUT:\n";
    private static final String USER_PROMPT = "\nPlease enter an integer:";

    // OOP constructor that initializes the class fields on class object instantiation

    public ExceptionHandling() {
        super("Exception Handling");
        getNotes();
    }

    // OOP CLASS METHODS: non-static unique object behavior
    // ! OOP POLYMORPHISM + INTERFACE: must uniquely-implement/@Override all publicly-shared signatures for designated classes
    @Override
    public void getNotes() {
        int x = 98;
        int y = 0;
        int result;

//        ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
//        result = divideLBYL(x, y);
//        System.out.println(LOOK_BEFORE_YOU_LEAP + result);
//
//        ! EXCEPTION HANDLING: EASY TO ASK FOR FORGIVENESS THAN PERMISSION (EAFTP) = use try-catch block
//        result = divideEAFTP(x, y);
//        System.out.println(EASY_ASK_FORGIVENESS_THAN_PERMISSION + result);
//
//        // ? NO EXCEPTION HANDLING will crash app
////        result = divide(x, y);
////        System.out.println(result);
//
//        Util.printSeparator();
//
//        // ? user input LOOK BEFORE YOU LEAP exception handling
//        result = getIntLBYL();
//        System.out.println(LOOK_BEFORE_YOU_LEAP + USER_INPUT + result);
//
//        // ? user input EASY TO ASK FOR FORGIVENESS THAN PERMISSION exception handling
//        result = getIntEAFTP();
//        System.out.println(EASY_ASK_FORGIVENESS_THAN_PERMISSION + USER_INPUT + result);
//
//        // ? user input NO EXCEPTION HANDLING will crash app
//        result = getInt();
//        System.out.println(USER_INPUT + result);
//
//        Util.printSeparator();

        // ? CALL STACK TRACE: upwards review, every time a new method is called, it's placed onto the CALL STACK; when a method returns, it's then removed from the CALL STACK.
        result = divide();
        System.out.println(result);
    }

    private static int getInt() {
        System.out.println(USER_PROMPT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int getIntEAFTP() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(USER_PROMPT);

        try {

            return scanner.nextInt();

        } catch(InputMismatchException e) {
            return -1;

        }
    }

    private static int getIntLBYL() {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;

        System.out.println(USER_PROMPT);
        String input = scanner.next();

        for(int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if(!Character.isDigit(currentCharacter)) {
                isValid = false;
                break;
            }
        }

        if(isValid) {
            return Integer.parseInt(input);
        }

        return -1;
    }

    private static int divideLBYL(int x, int y) {

        if(y != 0) {
            return x / y;
        }

        // implied else statement
        return 0;
    }

    private static int divideEAFTP(int x, int y) {

        try {

            return x / y;

        } catch(ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        return x / y;
    }

    // ! OVERLOADED METHOD: use same name for a function w/ unique parameters which improves scalability & readability
    private static int divide() {
        int x = getInt();
        int y = getInt();

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println(x + " / " + y + ":");

        return x / y;
    }
}

class CatchThrowException extends Notes {

    /*
        ! EXCEPTION TRY-CATCH-THROW: keep try-catch blocks as simple as possible & avoid nesting

        ? THROW EXCEPTION: initiate specific exception with provided error msg
     */

    // OOP constructor that initializes the class fields on class/object instantiation
    public CatchThrowException() {
        super("Try - Catch - Throw Exceptions");
        getNotes();
    }

    // OOP CLASS METHODS: non-static unique object behavior
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely-implement/@Override all publicly shared signatures for designated classes
    @Override
    public void getNotes() {

        // ? EASY TO ASK FOR FORGIVENESS THAN PERMISSION (EAFTP) = use try-catch block
        try {
            int result = divide();
            System.out.println(result);
        } catch(ArithmeticException e) {
            System.out.println(e.getMessage() +
                    "\nUnable to perform division, autopilot shutting down"
            );
        }
    }

    private static int divide() {
        int x;
        int y;

        // ! EXCEPTION HANDLING (EAFTP): try-catch block
        try {

            x = getInt();
            y = getInt();

            System.out.println("x: " + x + ", y: " + y +
                    "\n" + x + "/" + y + ":"
            );

            return x / y;

            // ? CATCH THROW EXCEPTION: a try-catch block can have multiple catch exceptions
        } catch(NoSuchElementException | ArithmeticException e) {

            // ? THROW EXCEPTION: initiate specific exception with provided error msg
            throw new ArithmeticException("No suitable input: attempted to divide by 0");

        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer:");

        while(true) {

            // ! EXCEPTION HANDLING (EAFTP): try-catch block
            try {

                return scanner.nextInt();

            } catch(InputMismatchException e) {
                // handle 'enter' key down
                scanner.nextLine();
                System.out.println("Please only enter a number using 0-9\n" +
                        e.getMessage()
                );
            }
        }
    }
}