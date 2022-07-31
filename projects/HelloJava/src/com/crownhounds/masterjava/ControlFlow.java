package com.crownhounds.masterjava;

public class ControlFlow {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String BLOCK_1 = "Block 1";
    private static final String BLOCK_2 = "Block 2";
    private static final String BLOCK_3 = "Block 3";

    // OOP ENCAPSULATION private class fields
    private static String title = "\tControl Flow";

    public static void main(String[] args) {

        Util.printSeparator(title);

//        ifStatements();
//        operatorsAndExpressions();
//        ternaryOperator();
//        switchStatement();

//        LoopNotes loopNotes = new LoopNotes();

        MethodOverloading.getNotes();
    }

    private static void operatorsAndExpressions() {
        /*
            Java Operator Precedence Table
                https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html

            operators are special symbols that perform specific operations on 1 or multiple operands (manipulated obj)
                = equals
                + addition
                - subtraction
                * multiplication
                / division
                % remainder of 2 operands

                ++ add 1
                -- subtract 1
                ** power of

            expressions are the combination of values and operators
                == evaluates
                != does not evaluate
                > greater than
                < less than
                >= greater than or equal to
                <= less than or equal to
                && and
                || or

            statements are the entire line including the datatype and semicolon
            which means that statements includes expressions
               int result = 15 + 12;
         */

        Util.printSeparator("Operators & expressions");

        // 15 & 12 operands
        // + and = symbols are operators
        // 15 + 12 is the expression
        int result = 15 + 12;
        System.out.println("15 + 12 = " + result);

        Util.printSeparator();

        int previousResult = result;
        result -= 3;
        System.out.println("previousResult: " + previousResult);
        System.out.println("Result: " + result);

        Util.printSeparator();

        result *= 10;
        System.out.println("24 * 10 = " + result);

        Util.printSeparator();

        result /= 5;
        System.out.println("240/5 = " + result);

        Util.printSeparator();

        result %= 5;
        System.out.println("48 % 5 has a remainder of " + result);

        Util.printSeparator();

        int myNum = 1;
        myNum++;
        System.out.println("1 + 1 = " + myNum);

        Util.printSeparator();

        myNum--;
        System.out.println("2 - 1 = " + myNum);

        Util.printSeparator();
    }

    private static void ifStatements() {
        /*
            ? if-else statements

                if expression evaluates true, only execute a specific code block

                expressions use double equal signs to evaluate
         */

        Util.printSeparator("IF-ELSE statements");

        int a = 1;
        int b = 2;
        boolean gameOver = false;

        if((a > b) && !gameOver) {
            System.out.println(BLOCK_1);
        } else if(gameOver) {
            System.out.println(BLOCK_2);
        } else {
            System.out.println(BLOCK_3);
        }

        Util.printSeparator();

        // ? validating for equality

        if(a == b) {
            System.out.println("is equal");
        } else {
            System.out.println("not equal");
        }

        Util.printSeparator();

        // ? validating a statement is true

        boolean hasCar = true;

        if(hasCar) {
            System.out.println("You have a car");
        } else {
            System.out.println("no car!");
        }

        Util.printSeparator();

        boolean isAlien = false;

        // ? validating a statement is false

        if(!isAlien) {
            System.out.println("!isAlien = (isAlien == false)");
        } else {
            System.out.println("is an alien");
        }

        Util.printSeparator();

        // ? greater than, less than comparisons
        if(1 <= 2) {
            System.out.println("a <= b");
        } else {
            System.out.println("a > b");
        }

        Util.printSeparator();

        // ? && operator (and) requires the left AND right operands to be true
        if((1 < 3) && (2 == 4)) {
            System.out.println("both statements returned true");
        } else {
            System.out.println("either one or both statements returned false");
        }

        Util.printSeparator();

        // ? || operator (or) where either one or both are operands are true
        if((1 < 2) || (3 > 4)) {
            System.out.println("at least one statement returned true");
        } else {
            System.out.println("neither statement returned true");
        }

        Util.printSeparator();
    }

    private static void ternaryOperator() {

        /*
            ! CONTROL FLOW ternary operator: if condition evaluates true (?) than return true else (:) return false;
                single line if-else statement
         */

        Util.printSeparator("Ternary Operator");

        int a = 1;
        int b = 2;

       String result = a > b ? "a greater than b" : "a less than b";

       System.out.println(result);

       Util.printSeparator();
    }

    private static void switchStatement() {

        /*
            ! CONTROL FLOW switch statement: handle multiple cases
                superior alternative to using a lot of if-else statements

                * case
                    handle if: test against the provided expression to return true

                * break
                    handle else-if: exit a switch code block and continue on

                * default
                    to handle else
         */

        Util.printSeparator("Switch Statement");

        int myValue = 2;

        switch (myValue) {
            case 1:
                System.out.println(BLOCK_1);
                break;
            case 2:
                System.out.println(BLOCK_2);
                break;
            default:
                System.out.println(BLOCK_3);
                break;
        }

        Util.printSeparator();
    }
}

class LoopNotes extends Notes {

    // CONSTANTS/static class fields assigned FINAL value before compilation/instantiation
    private static final String COUNT = "Count: ";

    // OOP ENCAPSULATION private class fields
    private static String title = "Loop Notes";

    // OOP constructor that initializes the class fields on class/object instantiation
    public LoopNotes() {
        // ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent superclass
        super(title);
        getNotes();

    }

    // ! INTERFACE + OOP Polymorphism: must uniquely implement/@Override all publicly shared signatures for designated classes
    @Override
    public void getNotes() {

        forLoops();
        whileLoops();
    }

    private static double calculateInterest(Double amount, Double interestRate) {
        // ! UNBOXING: convert Wrapper class dataType -> primitive
        return (amount * (interestRate/ 100));
    }

    private static void forLoops() {
        /*
            ! FOR Loop structure
                start;
                exit once condition is false;
                cycle increment
         */

        Util.printSeparator("For Loops");

        int exitValue = 3;

        for(int i = 0; i < exitValue; i++) {

            // ! CASTING: dataType conversion
            double interestRate = (double) i + 1;

            double amount = calculateInterest(10000d, interestRate);

            System.out.println("\n10K at " + interestRate + "% interest:\n" + amount);
        }

        Util.printSeparator();
    }

    // STATIC CLASS METHODS
    // ! STATIC: single memory-shared variable associated with class and not any instances
    private static void whileLoops() {

        Util.printSeparator("While Loop");

        int i = 0;

        // ? while(expression = true) continue
        while(i != 5) {
            System.out.println(COUNT + i);
            i++;
        }

        Util.printSeparator();

        i = 0;

        while(true) {
            if(i == 5) {
                break;
            }

            System.out.println(COUNT + i);
            i++;
        }

        Util.printSeparator();

        // do while: always execute at least once
        // could create an infinite loop
        i = 6;

        do {
            System.out.println(COUNT + i);
            i++;

            if(i > 10) {
                break;
            }
        } while(i != 6);

        Util.printSeparator();

        // while loop that uses continue
        int n = 1;
        int end = 10;

        while(n <= end) {
            n++;

            if(n % 2 != 0) {
                // bypass print statement while n is odd
                continue;
            }

            System.out.println(n + " is even");
        }

        Util.printSeparator();
    }
}

class MethodOverloading {
    /*
         ! METHOD OVERLOADING: when you use the same method name but with unique set of parameters to scalability & readability

            NOTE: not java specific concept
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String NO_PARAMS = "getResult():\n";
    private static final String ONE_PARAM = "getResult(a):\n";
    private static final String TWO_PARAMS = "getResult(a,b):\n";

    public static void getNotes() {

        Util.printSeparator("Method Overloading");

        int result;

        result = getResult();
        System.out.println(NO_PARAMS + result);

        Util.printSeparator();

        result = getResult(53);
        System.out.println(ONE_PARAM + result);

        Util.printSeparator();

        result = getResult(2, 8);
        System.out.println(TWO_PARAMS + result);

        Util.printSeparator();
    }

    private static int getResult() {
        return 100;
    }

    private static int getResult(int a) {
        return a;
    }

    private static int getResult(int a, int b) {
        return a * b;
    }
}