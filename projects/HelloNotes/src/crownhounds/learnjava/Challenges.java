package crownhounds.learnjava;

import java.util.*;

public class Challenges {

    /*
            ? write a class called CLASS_NAME

            ? write a method called METHOD_NAME with DATATYPE parameter(s) called PARAM_NAME

                returns

     */

    public static void main(String[] args) {

        /*
            Java Programming Masterclass
         */

//        challengeOne();
//        challengeTwo();
//        challengeThree();
//        challengeFour();
//        challengeFive();
//        challengeSix();
//        challengeSeven();
//        challengeEight();
//        challengeNine();
//        challengeTen();
//        challengeEleven();
//        challengeTwelve();
//        challengeThirteen();
//        challengeFourteen();
//        challengeFifteen();
//        challengeSeventeen();
//        challengeEighteen();
//        challengeNineteen();
//        challengeTwenty();
//        challengeTwentyOne();
//        challengeTwentyTwo();
//        challengeTwentyThree();
//        challengeTwentyFour();
//        challengeTwentyFive();
//        challengeTwentySix();
//        challengeTwentySeven();
//        challengeTwentyEight();
//        challengeTwentyNine();
//        challengeThirty();
//        challengeThirtyOne();
//        challengeThirtyTwo();
//        challengeThirtyThree();
//        challengeThirtyFour();
//        challengeThirtyFive();
//        challengeThirtySix();
//        challengeThirtySeven();
//        challengeThirtyEight();
//        challengeThirtyNine();
//        challengeForty();
//        challengeFortyOne();
//        challengeFortyTwo();
//        challengeFortyThree();
//        challengeFortyFour();
//        challengeFortyFive();
//        challengeFortySix();
//        challengeFortySeven();
//        challengeFortyEight();
//        challengeFortyNine();
//        challengeFifty();
//        challengeFiftyOne();
//        challengeFiftyTwo();
//        challengeFiftyThree();
        challengeFiftyFour();
//        challengeFiftyFive();

        /*
            LeetCode Java Challenges
         */

//        ChallengesLeetCode.challenge9();
//        ChallengesLeetCode.challenge412();
//        ChallengesLeetCode.challenge172();
//        ChallengesLeetCode.challenge344();
//        ChallengesLeetCode.challenge50();
//        ChallengesLeetCode.challenge151();

        /*
           Amazon Challenges
         */

        Challenges_Amazon.arrays();



    }

    public static void challengeOne() {
         /*
            create a byte variable and set it to a valid byte number
            create a short variable and set it to a valid short number
            create an int variable and set it to a valid int number

            create a long variable and set it to:
            50k plus 10 times sum of the byte plus the short plus the integer values
         */

        byte myByte = 10; // byte = 8 bits
        short myShort = 20; // short = 16 bits
        int myInt = 50; // int = 32 bits

        // long = 64 bits
        long myLong = 50000L;
        long mySum = myByte + myShort + myInt;
        long myLongTotal = (long) (myLong + mySum * 10L);

        System.out.println("CHALLENGE ONE \nmyLongTotal: " + myLongTotal);
    }

    public static void challengeTwo() {
         /*
             how do you resolve the double error below?

                 float myFloatValue = 5.25;
          */

        // solution 1: cast
        float myFloatValue1 = (float) 5.25;

        // solution 2: specify 'f'
        float myFloatValue2 = 5.25f;

        System.out.println("CHALLENGE TWO \nmyFloatValue1: " + myFloatValue1);
    }

    private static void challengeThree() {
        /*
            create a variable with the appropriate type to store the number of pounds to be converted to kilograms
            calculate the result: the number of kilograms based on the contents of the variable above
            store the results in a 2nd appropriate variable
            print result

            HINT: 1 pound = 0.45359237 of a kilogram
         */

        double numPounds = 200d;
        double poundsToKiloRatio = 0.45359237d;

        double calculatedKilos = numPounds * poundsToKiloRatio;
        System.out.println("CHALLENGE 3 \ncalculatedKilos: " + calculatedKilos);
    }

    private static void challengeFour() {
        /*
            1. create a double var w/ a value of 20.00
            2. create a double var w/ a value of 80.00
            3. add both numbers together & multiply by 100.00
            4. get remainder value from the division of step 3 value and 40.00
            5. create a boolean variable that assigns the value true if the remainder in step 4 is 0, or false if it's not zero
            6. output the boolean variable
            7. write if-else statement that displays 'Got some remainder' if the boolean in step 5 is not true.
         */

        // step 1
        double var1 = 20.00d;
        // step 2
        double var2 = 80.00d;
        // step 3: use parenthesis to handle operator precedence
        double var3 = (var1 + var2) * 100d;
        System.out.println("var3: " + var3);
        // step 4
        double remainder = var3 % 40.00d;
        // step 5: use ternary operator
        boolean isZeroRemainder = remainder == 0d;
        // step 7: don't expect remainder msg
        if (!isZeroRemainder) {
            System.out.println("got some remainder...".toUpperCase());
            System.out.println("Remainder: " + remainder);
        } else {
            // step 6
            System.out.println("isZeroRemainder: " + isZeroRemainder);
        }
    }

    private static void challengeFive() {
        /*
            using a reusable method, print out a second score on the screen with the following:
                gameOver = true;
                score set to 1000
                levelCompleted set to 8
                bonus set to 200

            but make sure a first score is still displayed on the screen too
         */
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        int firstScore = 0;
        int secondScore = 0;

        firstScore = calculateScore(bonus, levelCompleted, score, gameOver);
        System.out.println("game over ".toUpperCase() + "score: " + firstScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        secondScore = calculateScore(bonus, levelCompleted, score, gameOver);
        System.out.println("game over ".toUpperCase() + "score: " + secondScore);
    }

    private static int calculateScore(int bonus, int levelCompleted, int score, boolean gameOver) {

        if(gameOver) {
            int finalScore = (score + (levelCompleted * bonus)) + 1000;
            return finalScore;
        }

        return -1;
    }

    private static void challengeSix() {
        /*
            create a method called displayHighScorePosition with parameters:
                playerName, position in a high score table

                display the player's name along with a message like "managed to get into position"
                    and the position they got and a further message " on the high score table."

            create a 2nd method called calculateHighScorePosition
                it should be sent one argument only, the playerScore
                it should return an int
                the return data should be
                    1 if the score is > 1000
                    2 if the score is > 500 and < 1000
                    3 if the score is > 100 and < 500
                    4 in all other cases

             call both methods and display the results with a 3rd method with the following
                a score of 1500, 900, 400, and 50
         */

        // test all numbers, including if-else limits , are covered by logic
        handleHighScore("gary", 1000);
        handleHighScore("lara", 500);
        handleHighScore("susan", 100);
        handleHighScore("ben", 10);
    }

    // if the method returned void, it can be called a 'procedure'
    private static void handleHighScore(String playerName, int playerScore) {
        int position = calculateHighScore(playerScore);
        displayHighScorePosition(playerName, position);
    }

    private static void displayHighScorePosition(String playerName, int position) {
        System.out.println(
                playerName + " managed to get into position " +
                        position + " on the high score table."
        );
    }

    private static int calculateHighScore(int playerScore) {

        // INFERIOR OPTION 1: with multiple return statements
//        if(playerScore >= 1000) {
//            return 1;
//        } else if(playerScore >= 500) {
//            return 2;
//        } else if(playerScore >= 100) {
//            return 3;
//        }
//
//        return 4;

        // SUPERIOR OPTION 2: with a single return
        int position = 4; // assuming position 4 will be returned

        if(playerScore >= 1000) {
            position = 1;
        } else if(playerScore >= 500) {
            position = 2;
        } else if(playerScore >= 100) {
            position = 3;
        }

        return position;
    }

    private static void challengeEleven() {

        /*
            1. Write a DecimalComparator class

            2. Write a method areEqualByThreeDecimalPlaces with two parameters of type  double.
                use CASTING

            3.  The method should return boolean, and it needs to return true if two double numbers are the same up to three decimal places.
                Otherwise, return false .
         */

        boolean test1 = DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.175); // true
        System.out.println(test1);
        boolean test2 = DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.176); // false
        System.out.println(test2);
        boolean test3 = DecimalComparator.areEqualByThreeDecimalPlaces(3.0, 3.0); // true
        System.out.println(test3);
        boolean test4 = DecimalComparator.areEqualByThreeDecimalPlaces(-3.123, 3.123); // false
        System.out.println(test4);

    }

    private static void challengeTwelve() {
        /*
            1. Write EqualSumChecker class

            2. Write a method hasEqualSum with 3 parameters of type int.

                The method should return boolean, and it needs to return true

            3. if the sum of the first and second parameter is equal to the third parameter.
                    Otherwise, return false.
            
         */

        boolean check1 = EqualSumChecker.hasEqualSum(1,1,1); // false
        System.out.println("eCheck1: " + check1);
        boolean check2 = EqualSumChecker.hasEqualSum(1,1,2); // true
        System.out.println("eCheck2: " + check2);
        boolean check3 = EqualSumChecker.hasEqualSum(1,-1,0); // true
        System.out.println("eCheck3: " + check3);
    }

    private static void challengeThirteen() {
        /*
            We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).

                1. Write a method named hasTeen with 3 parameters of type int.

                    The method should return boolean
                        it needs to return true if one of the parameters is in range 13(inclusive) - 19 (inclusive).
                        Otherwise return false.

                2. Write another method named isTeen with 1 parameter of type int.
                    The method should return boolean
                        it needs to return true if the parameter is in range 13(inclusive) - 19 (inclusive).
                            Otherwise return false.
         */

        System.out.println("\nhasTeen");
        boolean teenCheck1 = TeenNumberChecker.hasTeen(9, 99, 19); // true
        System.out.println("teenCheck1: " + teenCheck1);
        boolean teenCheck2 = TeenNumberChecker.hasTeen(23, 15, 42); // true
        System.out.println("teenCheck2: " + teenCheck2);
        boolean teenCheck3 = TeenNumberChecker.hasTeen(22, 23, 34); // false
        System.out.println("teenCheck3: " + teenCheck3);

        System.out.println("\nisTeen");
        boolean teenCheck4 = TeenNumberChecker.isTeen(9); // false
        System.out.println("teenCheck4: " + teenCheck4);
        boolean teenCheck5 = TeenNumberChecker.isTeen(13); // true
        System.out.println("teenCheck5: " + teenCheck5);
    }

    private static void challengeFourteen() {
        /*
            1. create a method: calcFeetAndInchesToCentimeters
                2 parameters: double feet, double inches

            validate feet is greater than or equal to 0
            validate inches is greater than or equal to 0, validate inches is less than or equal to 12
            if any false, return -1

            if params valid, calculate number of centimeters passes to method based on params
                1 foot = 12 inches
                1 in = 2.54cm

            2. create 2nd method with same name but only 1 param: double inches

            validate that inches >= 0
                return -1 if false
                calculate how many feet are in the inches param
                    1 foot = 12 inches

            CALLING another overloaded method just requires you to use the right number of parameters

         */

        double twoParams = calcFeetAndInchesToCentimeters(6, 0);
        System.out.println("calcFeetAndInchesToCentimeters(2 params): " + twoParams + "cm");
        double twoParams1 = calcFeetAndInchesToCentimeters(0, 9);
        System.out.println("calcFeetAndInchesToCentimeters(2 params): " + twoParams1 + "cm");
        double twoParams2 = calcFeetAndInchesToCentimeters(7, 5);
        System.out.println("calcFeetAndInchesToCentimeters(2 params): " + twoParams2 + "cm");
        double twoParams3 = calcFeetAndInchesToCentimeters(-20, 1);
        System.out.println("calcFeetAndInchesToCentimeters(2 params): " + twoParams3 + "cm");
        double twoParams4 = calcFeetAndInchesToCentimeters(20, -4);
        System.out.println("calcFeetAndInchesToCentimeters(2 params): " + twoParams4 + "cm");
        double twoParams5 = calcFeetAndInchesToCentimeters(-9, -4);
        System.out.println("calcFeetAndInchesToCentimeters(2 params): " + twoParams5 + "cm");

        System.out.println("\n***\n");
        double oneParam = calcFeetAndInchesToCentimeters(100);
        System.out.println("calcFeetAndInchesToCentimeters(1 params): " + oneParam + "cm");
        double oneParam2 = calcFeetAndInchesToCentimeters(-3);
        System.out.println("calcFeetAndInchesToCentimeters(1 params): " + oneParam2 + "cm");

    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {

        if(feet >= 0 && (inches >= 0 && inches <= 12)) {
            return (feet * 12 * 2.54) + (inches * 2.54);
        }

        System.out.println("\ninvalid feet or inches". toUpperCase());
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {

        if(inches < 0) {
            System.out.println("\ninvalid inches". toUpperCase());
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        
        // the return statement will return the calculated double from the 1st overloaded method
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }

    private static void challengeSeventeen() {

        /*
            Write a class called MinutesToYearsDaysCalculator

            Write a method called printYearsAndDays with 1 long parameter named minutes
                the method should return void

                print "Invalid Value" if radius is negative

                the method needs to calculate years and days from the minutes
                    "XX min = YY y and ZZ d";
                    XX = minutes
                    YY = years
                    ZZ = days

                    TIP: use remainder/modulus operator
                    1 hour = 60 min
                    1 day = 24 hours
                    1 year = 365 days
         */

        MinutesToYearsDaysCalculator.printYearsAndDays(525600);
        MinutesToYearsDaysCalculator.printYearsAndDays(-12);
        MinutesToYearsDaysCalculator.printYearsAndDays(1051200);
        MinutesToYearsDaysCalculator.printYearsAndDays(561600);
    }

    private static void challengeEighteen() {
        /*
            Write a class called IntEqualityPrinter

            Write a method called printEqual with 3 parameters of type int
                the method should return void

                print "Invalid Value" if one of the parameters is less than 0

                if all numbers are equal, the method should print
                    "All numbers are equal"
                 if all numbers are different, the method should print
                    "All numbers are different"
                otherwise, print
                    "Neither all are equal or different"
         */

        IntEqualityPrinter.printEqual(1,1,1);
        IntEqualityPrinter.printEqual(1,1,2);
        IntEqualityPrinter.printEqual(-1,-1,-1);
        IntEqualityPrinter.printEqual(1,2,3);
    }

    private static void challengeNineteen() {
        /*
            Write a class called PlayingCat

            Write a method called isCatPlaying with 2 parameters:
                boolean (if it is summer): summer
                int: temperature

                if !summer, cats play if temperature >= 25 AND temperature <= 35
                if summer, cats play if temperature >= 25 AND temperature <= 45

                the method should return a boolean depending on if cat is playing
         */

        boolean cat1 = PlayingCat.isCatPlaying(true, 10);
        System.out.println(cat1);
        boolean cat2 = PlayingCat.isCatPlaying(false, 36);
        System.out.println(cat2);
        boolean cat3 = PlayingCat.isCatPlaying(false, 35);
        System.out.println(cat3);

    }

    private static void challengeTwenty() {
        /*
            Write a new switch statement use char instead of int
            create a new char variable
            create a new switch statement testing for
                a, b, c, d, e
            display a msg if any of these letters are found & then break
            default to msg 'not found'
         */

        char letter = 'c';
        String msg = " was found";

        switch (letter) {
            case 'a': case 'b': case 'c': case 'd': case 'e':
                System.out.println(letter + msg);
                break;
            default:
                System.out.println("not found");
                break;
        }

        String month = "Nov";

        switch (month.toLowerCase()) {
            case "dec":
                System.out.println("the month was " + month);
                break;
            case "nov":
                System.out.println("the month was " + month);
                break;
            default:
                System.out.println("the default");
                break;
        }
    }

    private static void challengeTwentyOne() {
        /*
            1. write the method printDayOfTheWeek has 1 parameter name 'day' of type int
                returns void
            use a switch statement to represent the string of the day of the week
                0 - "Sunday"
            else print "Invalid Day"

            2. write a separate method that uses if-else instead of switch statement

            TIP: overload the method
         */

        printDayOfTheWeek(3);
        printDayOfTheWeek(9);
        printDayOfTheWeek(6, true);
        printDayOfTheWeek(10, false);

    }

    private static void printDayOfTheWeek(int day) {
        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
            default:
                System.out.println("Invalid day");
                break;
        }
    }

    private static void printDayOfTheWeek(int day, boolean hasIf) {
        if(day == 0) {
            System.out.println("Sunday");
        } else if(day == 1) {
            System.out.println("Monday");
        } else if(day == 2) {
            System.out.println("Tuesday");
        } else if(day == 3) {
            System.out.println("Wednesday");
        } else if(day == 4) {
            System.out.println("Thursday");
        } else if(day == 5) {
            System.out.println("Friday");
        } else if(day == 6) {
            System.out.println("Saturday");
        } else {
            System.out.println("Invalid value");
        }
    }

    private static void challengeTwentyTwo() {
        /*
            0. write a class called NumberInWord

            1. write the method printNumberInWord
                has 1 parameter name 'num' of type int
                returns void because it uses print extensively

            use a switch statement to print the string of the spelled out num parameter
            only numbers 0-9 are printed
            note capitalization
                0 - "ZERO"
            else print "OTHER" for nums outside of range including negative numbers

            2. write a separate method that uses if-else instead of switch statement

            TIP: overload the method
         */

        NumberInWord.printNumberInWord(0);
        NumberInWord.printNumberInWord(-14);
        NumberInWord.printNumberInWord(6);
        NumberInWord.printNumberInWord(100);

        System.out.println("\n*** OVERLOADED ***\n".toLowerCase());

        ArrayList<String> wordNums = new ArrayList<String>();
        wordNums.add("zero".toUpperCase());
        wordNums.add("one".toUpperCase());
        wordNums.add("two".toUpperCase());
        wordNums.add("three".toUpperCase());
        wordNums.add("four".toUpperCase());
        wordNums.add("five".toUpperCase());
        wordNums.add("six".toUpperCase());
        wordNums.add("seven".toUpperCase());
        wordNums.add("eight".toUpperCase());
        wordNums.add("nine".toUpperCase());

        NumberInWord.printNumberInWord(0, wordNums);
        NumberInWord.printNumberInWord(-14, wordNums);
        NumberInWord.printNumberInWord(6, wordNums);
        NumberInWord.printNumberInWord(100, wordNums);


    }

    private static void challengeTwentySix() {
        /**
         * create a for statement using any range of numbers
         * determine if the number is a prime number using the isPrime method
         * if it is a prime number, print it out
         * AND increment the count of the number of prime numbers found
         * if that count is 3: exit the loop
         *
         * HINT: use the break statement to exit
         */

        int startIndex = 10;
        int numLoops = 50;
        int maxPrimeNums = 10;
        int totalPrimeFound = 0;

        for(int i = startIndex; i < numLoops; i++) {

            boolean isPrime = ControlFlow_Loops.isPrime(i);

            if(isPrime) {
                totalPrimeFound++;
                System.out.println(i + " is a prime number");
            } else if(totalPrimeFound == maxPrimeNums) {
                System.out.println("\nmax prime nums found: " + totalPrimeFound + "\nexiting for loop");
                // break out of the for loop
                break;
            }
        }
    }

    private static void challengeTwentySeven() {
        /*
            create a for statement using a range of numbers from 1 to 1000 inclusive

            sum all numbers that can be divided by 3 and 5, also print the number

            break out of loop once you have found a total of 5 numbers
                print sum after breaking out of loop
         */

        System.out.println("\tChallenge 27".toUpperCase());

        int count = 0;
        int sum = 0;

        for(int i = 1; i <= 1000; i++) {

            if(count >= 5) {
                break;
            } else if((i % 3 == 0) && (i % 5 == 0)) {
                sum += i;
                count ++;

                System.out.println(i);
            }
        }

        System.out.println("sum: " + sum);
    }

    public static void challengeTwentyNine() {
        /*
            create a method isEvenNumber with int param
                return true if even, else return false

            implement isEvenNumber in while loop that prints only even numbers
                check edge case: infinite loop

            record total number of even numbers found
                break out of loop on 5 and print the five even numbers

            HINT: use modulo/remainder operator
         */

        int count = 0;
        int num = 4;
        int finNum = 20;

        while(num <= finNum) {
            num++;

            if(count >= 5) {
                break;
            }

            if(!isEvenNumber(num)) {
                // bypass print statement
                continue;
            }

            count++;
            System.out.println(num + " is even");
        }

        System.out.println("evenNum count: " + count);
    }

    private static boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }

    private static void challengeThirtySeven() {
        /*
            read 10 numbers from the console entered by the user and print the sum of those 10 numbers

            use input validation, if the input is not a number print the message 'Invalid Number'
                continue reading until you have read 10 numbers
         */

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        int userInput = 0;
        boolean validInput = false;

        while(true) {

            System.out.println("Enter a number: ");
            validInput = scanner.hasNextInt();

            if(validInput) {

                userInput = scanner.nextInt();
                scanner.nextLine();

                sum += userInput;
                count++;

                if(count >= 10) {
                    System.out.println("\nsum: " + sum);
                    scanner.close();
                    break;
                }

            } else {
                System.out.println(Challenges_Utility.INVALID_VALUE.toUpperCase());
            }

            System.out.println("\nvalid count: " + count);
            scanner = new Scanner(System.in);
        }
    }

    private static void challengeThirtyEight() {
        /*
            read the numbers from console entered by the user and print the min and max
            prompt: "Enter number: "

            if user input is an invalid number break out of the loop and print the min and max
         */

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long userInput = 0L;

        while(true) {

            System.out.println("\nEnter number: ");
            validInput = scanner.hasNextLong();

            if(validInput) {
                // capture valid user input, handle next line issue
                userInput = scanner.nextLong();
                scanner.nextLine();

                if(min == Long.MAX_VALUE || max == Long.MIN_VALUE) {

                    min = userInput;
                    max = userInput;

                    System.out.println("initialized min & max: " + userInput);

                } else if(userInput > max) {

                    max = userInput;
                    System.out.println("new max: " + max);

                } else if(userInput < min) {

                    min = userInput;
                    System.out.println("new min: " + min);

                }

            } else {

                scanner.close();
                System.out.println("min: " + min);
                System.out.println("max: " + max);
                break;

            }
        }
    }

    private static void challengeThirtyNine() {
        /*

            ? write a class SimpleCalculator
                it has 2 double member variables/fields:
                    firstNumber & secondNumber

            ? 8 total methods

            write the class method getFirstNumber
                that returns class current field state for firstNumber

            write the class method getSecondNumber
                that returns class current field state for secondNumber

            write the class method setFirstNumber with 1 double parameter:
                set class field state for firstNumber

            write the class method setSecondNumber with 1 double parameter:
                set class field state for secondNumber

            write the class method getAdditionResult
                that returns firstNumber + secondNumber

            write the class method getSubtractionResult
                that returns firstNumber - secondNumber

            write the class method getMultiplicationResult
                that returns firstNumber * secondNumber

            write the class method getDivisionResult
                that returns firstNumber / secondNumber
                if secondNumber is 0, return 0

            ? instantiate and test methods
         */

        // need to initialize instance of class object into unique place in memory
        OOP_SimpleCalculator simpleCalculator = new OOP_SimpleCalculator();

        simpleCalculator.setFirstNumber(5d);
        simpleCalculator.setSecondNumber(4d);

//        System.out.println(simpleCalculator.getFirstNumber());
//        System.out.println(simpleCalculator.getSecondNumber());

        System.out.println(simpleCalculator.getAdditionResult());
        System.out.println(simpleCalculator.getSubtractionResult());

        simpleCalculator.setFirstNumber(5.25d);
        simpleCalculator.setSecondNumber(0);

        System.out.println(simpleCalculator.getMultiplicationResult());
        System.out.println(simpleCalculator.getDivisionResult());
    }

    private static void challengeForty() {
        /*
             ? write a class Person
                it has 3 double member variables/fields:
                   firstName & lastName = String
                   age = int

             ? 8 total methods

            write the class method getFirstName
                that returns class current field state for firstName

            write the class method getLastName
                that returns class current field state for lastName

            write the class method getAge
                that returns class current field state for age

            write the class method setFirstName with 1 String parameter:
                set class field state for firstName

            write the class method setLastName with 1 String parameter:
                set class field state for lastName

            write the class method setAge with 1 int parameter:
                set class field state for age
                    if parameter is less than 0 or greater than 100, it needs to set field to 0

            write the class method isTeen
                returns true if age is greater than 12 or less than 20, else false

            write the class method getFullName
                returns firstName + lastName of the person,
                    if firstName & lastName are empty, return empty string
                    if one of the fields are empty, only return the field that has a value
                        * HINT: use .isEmpty() that returns

            ? instantiate and test methods

         */

        OOP_Person person = new OOP_Person();
        person.setFirstName("");
        person.setLastName("");
        person.setAge(10);
        System.out.println(person.getFullName());
        System.out.println(person.isTeen());

        person.setFirstName("John");
        person.setAge(18);
        System.out.println(person.getFullName());
        System.out.println(person.isTeen());

        person.setLastName("Smith");
        System.out.println(person.getFullName());
    }

    private static void challengeFortyTwo() {

        /*
            create a new class VipCustomer

            it should have 3 fields: name, credit limit, and email address

            create 3 constructors

                1st: empty constructor should call the constructor with 3 params with default values
                2nd: constructor should pass on the 2 values it receives and add a default value for the 3rd
                3rd: constructor should save all fields

            create getters only for this using code generation of intellij as setters won't be needed
            test and confirm it works
         */

        OOP_VipCustomer vip1 = new OOP_VipCustomer();
        System.out.println(vip1.getName());

        OOP_VipCustomer vip2 = new OOP_VipCustomer("Test", 50000L);
        System.out.println(vip2.getName());

        OOP_VipCustomer vip3 = new OOP_VipCustomer("Tim", 100L, "tim@gmail.com");
        System.out.println(vip3.getName());
    }

    private static void challengeFortyThree() {
        /*
            create a new class Wall

            it should have 2 instance members/fields of type double: width and height

            create 2 constructors

                1st: empty constructor should call the constructor with 2 params with default values
                2nd: constructor should pass on the 2 values it receives and initialize the fields

                    if width < 0, set to 0
                    if height < 0, set to 0

            create getters & setters only for this using code generation of intellij as setters won't be needed

            write method getArea() without any parameters that returns the area

            test and confirm it works
         */

        OOP_Wall w1 = new OOP_Wall();
        System.out.println(w1.getArea());

        OOP_Wall w2 = new OOP_Wall(6d, 7d);
        System.out.println(w2.getArea());
    }

    private static void challengeFortySeven() {
        /*
            create a bedroom that 'has' stuff using COMPOSITION

            add at least one method to access an object via a getter and then that objects public method

            add at least one method to hide the object e.g. not using a getter
                but to access the object used in composition within the main class
         */

        Composition_Wall wall1 = new Composition_Wall("West");
        Composition_Wall wall2 = new Composition_Wall("East");
        Composition_Wall wall3 = new Composition_Wall("South");
        Composition_Wall wall4 = new Composition_Wall("North");

        Composition_Ceiling ceiling = new Composition_Ceiling(12, 55);

        Composition_Bed bed = new Composition_Bed("Modern", 4, 3, 2, 1);
        Composition_Lamp lamp = new Composition_Lamp("classic", false, 75);

        Composition_Bedroom bedroom = new Composition_Bedroom("Enzo's", wall1, wall2, wall3, wall4, ceiling, bed, lamp);

        bedroom.makeBed();
        bedroom.getLamp().turningOn();
    }

    private static void challengeFiftyThree() {
        /*
            create an application that builds a grocery list

            use a scanner to capture user input

            write CRUD+ methods:
                create a grocery list
                read the grocery list
                update items on the grocery list
                delete items on the grocery list

                that can query the grocery list for specific items
         */

        Scanner scanner = new Scanner(System.in);
        GroceryList groceryList = new GroceryList();
        boolean quit = false;

        groceryList.printGroceryListInstructions();

        while(!quit) {

            System.out.println(GroceryList.PLEASE_ENTER_VALID_CHOICE);

            if(scanner.hasNextInt()) {

                int userInput = scanner.nextInt();

                // to handle 'enter' key down
                scanner.nextLine();

                switch(userInput) {
                    case 0:
                        groceryList.printGroceryListInstructions();
                        break;
                    case 1:
                        System.out.println("\nREAD:");
                        groceryList.readGroceryList();
                        break;
                    case 2:
                        System.out.println("\nCREATE: " + GroceryList.PLEASE_ENTER_ITEM_NAME);
                        String addItem = scanner.nextLine();
                        groceryList.addItemToGroceryList(addItem);
                        break;
                    case 3:
                        if(groceryList.validateGroceryListSize()) {
                            groceryList.readGroceryList();
                            boolean isUpdating = true;

                            while(isUpdating) {
                                System.out.println("\nUPDATE: " + GroceryList.PLEASE_ENTER_ITEM_NUMBER);
                                if(scanner.hasNextInt()) {

                                    int updateIndex = scanner.nextInt() - 1;

                                    if(updateIndex < 0) {
                                        System.out.println(GroceryList.QUIT_UPDATE);
                                        isUpdating = false;
                                        break;

                                    } else if(groceryList.validateGroceryListSize(updateIndex)) {
                                        // handle 'enter' key down event
                                        scanner.nextLine();

                                        System.out.println(GroceryList.PLEASE_ENTER_ITEM_NAME +
                                                "\ttype 'exit' to quit");
                                        String newItem = scanner.nextLine().toLowerCase().strip();

                                        if(Objects.equals(newItem, Challenges_Utility.EXIT)) {
                                            System.out.println(GroceryList.QUIT_UPDATE);
                                            isUpdating = false;
                                            break;
                                        } else {
                                            groceryList.updateItemInGroceryList(updateIndex, newItem);
                                            isUpdating = false;
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println(Challenges_Utility.INVALID_INPUT + ": item number");
                                    groceryList.readGroceryList();
                                    scanner = new Scanner(System.in);
                                }
                            }
                        }
                        break;
                    case 4:
                        if(groceryList.validateGroceryListSize()) {
                            groceryList.readGroceryList();
                            boolean isDeleting = true;

                            while(isDeleting) {
                                System.out.println("\nDELETE: "+ GroceryList.PLEASE_ENTER_ITEM_NUMBER);
                                if(scanner.hasNextInt()) {

                                    int removeIndex = scanner.nextInt() - 1;
                                    // handle 'enter' key down event
                                    scanner.nextLine();

                                    if(removeIndex < 0) {
                                        System.out.println(GroceryList.QUIT_DELETE);
                                        isDeleting = false;
                                    } else if(groceryList.validateGroceryListSize(removeIndex, true)) {
                                        System.out.println(Challenges_Utility.INVALID_INPUT + ": item number");
                                    } else {
                                        groceryList.removeItemFromGroceryList(removeIndex);
                                        isDeleting = false;
                                    }
                                } else {
                                    System.out.println(Challenges_Utility.INVALID_INPUT + ": item number");
                                    groceryList.readGroceryList();
                                    scanner = new Scanner(System.in);
                                }
                            }
                        }
                        break;
                    case 5:
                        if(groceryList.validateGroceryListSize()) {
                            System.out.println("\nQUERY: " + GroceryList.PLEASE_ENTER_ITEM_NAME);
                            String queryItem = scanner.nextLine();
                            String result = groceryList.queryGroceryList(queryItem);
                            System.out.println(result + " was found");
                        }
                        break;
                    case 6:
                        quit = groceryList.quitGroceryListApp();
                        break;
                }
            }
            scanner = new Scanner(System.in);
        }
        // release resource in memory
        scanner.close();
    }

    private static void challengeFiftyFour() {

        /*
             ! MUST USE AUTOBOXING and UNBOXING
                transactions an ideal place for implementation requirement

              Your job is to create a simple banking application.

             ! OOP: Implement the following classes:
              
              ? Bank

                It has two fields:
                    String called name
                    ArrayList that holds objects of type Branch called branches.

                A constructor that takes a String (name of the bank).
                    It initialises name and instantiates branches.

                And five methods, they are (their functions are in their names):

                    addBranch()
                        has one parameter of type String (name of the branch) and returns a boolean.
                        It returns true if the branch was added successfully or false otherwise.

                    addCustomer()
                        has three parameters:
                            String (name of the branch),
                            String (name of the customer),
                            double (initial transaction)
                        It returns true if the customer was added successfully or false otherwise.

                    addCustomerTransaction()
                        has three parameters:
                            String (name of the branch),
                            String (name of the customer),
                            double (transaction)
                        It returns true if the customers' transaction was added successfully or false otherwise.

                    findBranch()
                        has one parameter of type String (name of the Branch) and returns a Branch.
                        Return the Branch if it exists or null otherwise.

                    listCustomers()
                        This method prints out a list of customers.
                        has two parameters
                            String (name of the Branch),
                            boolean (print transactions)
                        Return true if the branch exists or false otherwise.

                    * TIP:  In Bank, use the findBranch() method in each of the other four methods to validate a branch.
                                      * Do the same thing in Branch with findCustomer() except for the two getters.
              ?  Branch

                    It has two fields:
                        String called name
                        ArrayList that holds objects of type Customer called customers.

                    A constructor that takes a String (name of the branch)
                        It initialises name and instantiates customers.

                    And five methods, they are (their functions are in their names):

                        getName()
                            getter for name.

                        getCustomers()
                            getter for customers.

                        newCustomer()
                            has two parameters of type String (name of customer), double (initial transaction) and returns a boolean.
                            Returns true if the customer was added successfully or false otherwise.

                        addCustomerTransaction()
                            has two parameters of type String (name of customer), double (transaction) and returns a boolean.
                            Returns true if the customers' transaction was added successfully or false otherwise.

                        findCustomer()
                            has one parameter of type String (name of customer) and returns a Customer.
                            Return the Customer if they exist, null otherwise.

              ?  Customer

                    It has two fields:
                        String called name
                        ArrayList that holds objects of type Double called transactions.

                    A constructor that takes a  String (name of customer) and a double (initial transaction).
                        It initialises name and instantiates transactions.

                    And three methods, they are (their functions are in their names):

                        getName()
                            getter for name.

                        getTransactions()
                            getter for transactions.

                        addTransaction()
                            has one parameter of type double (transaction)
                            doesn't return anything.

              ! COMPOSITION
                    TIP:  In Customer, think about what else you need to do in the constructor when you instantiate a Customer object.
                    TIP:  Think about what methods you need to call from another class when implementing a method.

              NOTE:  All transactions are deposits (no withdraws/balances).

              ! ENCAPSULATION
                    NOTE:  All fields are private.
                    NOTE:  All constructors are public.

                    * NOTE:  All methods are public (except for findBranch() and findCustomer() which are private).


              NOTE:  Be extremely careful with the spelling of the names of the fields, constructors and methods.
              NOTE:  Be extremely careful about spaces and spelling in the printed output.
              NOTE:  There are no static members.
              NOTE:  Do not add a main method to the solution code.
         */

        Bank testBank = new Bank("testBank");
        boolean hasTestBranch = testBank.addBranch("testBranch");
        System.out.println(testBank.addCustomer("testBranch", "gary", 200));

        System.out.println(testBank.addCustomerTransaction("testBranch", "gary", 500));
        System.out.println(testBank.listCustomers("testBranch", true));

    }
}