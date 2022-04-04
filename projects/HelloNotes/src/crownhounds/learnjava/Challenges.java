package crownhounds.learnjava;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenges {

    // CONSTANTS
    private static final String INVALID_VALUE = "Invalid Value";
    private static final String INVALID_NUMBER = "Invalid number";

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
//        challengeSixteen();
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
        challengeFortyEight();

        /*
            LeetCode Java Challenges
         */

//        LeetCode.challenge9();
//        LeetCode.challenge412();
//        LeetCode.challenge172();
//        LeetCode.challenge344();
//        LeetCode.challenge50();
//        LeetCode.challenge151();

        /*
           Amazon Challenges
         */

//        AmazonChallenges.arrays();



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

//        handleHighScore("gary", 900);
//        handleHighScore("lara", 50);
//        handleHighScore("susan", 400);
//        handleHighScore("ben", 1500);

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

    private static void challengeSeven() {
        /*
            0. Write a speed converter class

            1. Write a method called toMilesPerHour that has 1 parameter of type double with the name kilometersPerHour.
                This method needs to return the rounded value of the calculation of type long

                If the parameter kilometersPerHour is less than 0,
                    the method toMilesPerHour needs to return -1 to indicate an invalid value.

                Otherwise, if kilometersPerHour is positive,
                    calculate the value of miles per hour, round it and return it.

                    NOTE: 1.609 kilometers per hour is 1 mile per hour

                        milesPerHour = kilometersPerHour / 1.609

                    Use method Math.round to round the number of calculated miles per hour(double). The method round returns long.

                        The Math.round() is a built-in math method which returns the closest long to the argument.
                        The result is rounded to an integer by adding 1/2, taking the floor of the result after adding 1/2, and typecasting the result to type long.

                        The method returns the value of the argument rounded to the nearest int value.

            2. Write another method called printConversion with 1 parameter of type double with the name kilometersPerHour.

                This method should not return anything (void) and it needs to calculate milesPerHour from the kilometersPerHour parameter.
                    Then it needs to print a message in the format "XX km/h = YY mi/h".
                        XX represents the original value kilometersPerHour.
                        YY represents the rounded milesPerHour from the kilometersPerHour parameter.

                If the parameter kilometersPerHour is < 0 then print the text "Invalid Value"
         */

        // REFERENCE SpeedConverter class
        // Positive Success Test
        SpeedConverter.printConversion(20D);
        // 0 Success Test
        SpeedConverter.printConversion(0D);
        // Negative Fail Test
        SpeedConverter.printConversion(-20D);
    }

    private static void challengeEight() {
        /*
            0. Write a megabyte converter class

            1. Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type int with the name kiloBytes.
                The method should not return anything(void)

                it needs to calculate the megabytes and remaining kilobytes from the kilobytes parameter.

                    1 MB = 1024 KB

            2. Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
                XX represents the original value kiloBytes.
                YY represents the calculated megabytes.
                ZZ represents the calculated remaining kilobytes.
                
                If the parameter kiloBytes is less than 0 then print the text "Invalid Value".
         */

        // REFERENCE MegaBytesConverter class
        MegaBytesConverter.printMegaBytesAndKiloBytes(2500);
        MegaBytesConverter.printMegaBytesAndKiloBytes(-1024);
        MegaBytesConverter.printMegaBytesAndKiloBytes(5000);
    }

    private static void challengeNine() {
         /*
            1. Write a BarkingDog class

            2. We have a dog that likes to bark.
                We need to wake up if the dog is barking at night!

            3. Write a method shouldWakeUp that has 2 parameters.
                1st parameter should be of type boolean and be named barking
                    it represents if our dog is currently barking.

                2nd parameter represents the hour of the day
                    is of type int with the name hourOfDay and has a valid range of 0-23.
                    If the hourOfDay parameter is less than 0 or greater than 23 return false.

                We have to wake up if the dog is barking before 8 or after 22 hours so in that case return true.

                In all other cases return false.
         */

        // REFERENCE BarkingDog class
        boolean isBobAwake = BarkingDog.shouldWakeUp(true, 1);
        boolean isDaleAwake = BarkingDog.shouldWakeUp(false, 2);
        boolean isSallyAwake = BarkingDog.shouldWakeUp(true, 8);
        boolean isKateAwake = BarkingDog.shouldWakeUp(true, -1);

        System.out.println("isBobAwake: " + isBobAwake);
        System.out.println("isDaleAwake: " + isDaleAwake);
        System.out.println("isSallyAwake: " + isSallyAwake);
        System.out.println("isKateAwake: " + isKateAwake);

    }

    private static void challengeTen() {
         /*
            1. Write a LeapYearCalculator class

            2. Write a method isLeapYear with a parameter of type int named year.

                The parameter needs to be greater than or equal to 1 and less than or equal to 9999.
                    If the parameter is not in that range return false.

                Otherwise, if it is in the valid range,
                    calculate if the year is a leap year and return true if it is a leap year, otherwise return false.

                To determine whether a year is a leap year, follow these steps:
                    1. If the year is evenly divisible by 4, go to step 2.

                        Otherwise, go to step 5 if NOT evenly divisible by 4.

                    2. If the year is evenly divisible by 100, go to step 3.
                        Otherwise, go to step 4.

                    3. If the year is evenly divisible by 400, go to step 4.
                        Otherwise, go to step 5.

                    4. The year is a leap year (it has 366 days).
                        The method isLeapYear needs to return true.

                    5. The year is not a leap year (it has 365 days).
                        The method isLeapYear needs to return false.

            3. TEST divisibility by 100 BUT_NOT/AND 400

                1. The following years are NOT leap years:

                This is because they are evenly divisible by 100 but NOT by 400.
                    1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600

                2. The following years ARE leap years:

                This is because they are evenly divisible by both 100 AND 400.
                    1600, 2000, 2400

         */

//         REFERENCE LeapYearCalculator class
        boolean yearN1600 = LeapYearCalculator.isLeapYear(-1600);
        System.out.println("yearN1600: " + yearN1600);
        boolean year1600 = LeapYearCalculator.isLeapYear(1600);
        System.out.println("year1600: " + year1600);
        boolean year2017 = LeapYearCalculator.isLeapYear(2017);
        System.out.println("year2017: " + year2017);
        boolean year2000 = LeapYearCalculator.isLeapYear(2000);
        System.out.println("year2000: " + year2000);

        // TEST numbers in range(1,100)
        boolean year4 = LeapYearCalculator.isLeapYear(4);
        System.out.println("year4: " + year4);

        // TEST divisibility by 100 AND 4 BUT_NOT 400
        boolean year1800 = LeapYearCalculator.isLeapYear(1800);
        System.out.println("year1800: " + year1800);
        boolean year1900 = LeapYearCalculator.isLeapYear(1900);
        System.out.println("year1900: " + year1900);

        // TEST divisibility by 100 AND 400 AND 4
        boolean year1924 = LeapYearCalculator.isLeapYear(1924);
        System.out.println("year1924: " + year1924);

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

    private static void challengeFifteen() {
        /*
            NOTE: use int or long for num data types
            BONUS: for input 61 minutes = '01h 01m 00s' || '1h 1m 0s'

            1. create a SecondsAndMinutes class

                1. create a method called getDurationString that returns a String
                    first parameter = minutes
                    second parameter = seconds

                2. validate params:
                    valid if minutes is greater than or equal to 0
                    valid if seconds is greater than or equal to 0 and less than or equal to 59

                3. getDurationString returns 'Invalid value' if either param validation fails

                4. if params valid,
                    calculate how many hours, minutes, and seconds equal the minutes and seconds passed to this method

                        1 minute = 60 seconds
                        1 hour = 60 minutes || 3600 seconds

                    return that value as a string in format "XXh YYm ZZs"

            2. method overload getDurationString with only 1 param: seconds

                1. validate seconds is greater than or equal to 0 and return 'invalid value' if it is not true

                2. if params valid,
                    calculate how many minutes are in the seconds value

                        1 minute = 60 seconds
                        1 hour = 60 minutes || 3600 seconds

                    then call the other overloaded method with the minutes and seconds parameters
         */

        // TEST CASES

        String bonus = SecondsAndMinutes.getDurationString(61, 0);
        System.out.println(bonus + "\n");

        String ds0 = SecondsAndMinutes.getDurationString(126, 34);
        System.out.println(ds0 + "\n");

        String ds1 = SecondsAndMinutes.getDurationString(62, 3);
        System.out.println(ds1 + "\n");

        String ds2 = SecondsAndMinutes.getDurationString(44, 19);
        System.out.println(ds2 + "\n");

        String ds3 = SecondsAndMinutes.getDurationString(0, 25);
        System.out.println(ds3 + "\n");

        String ds4 = SecondsAndMinutes.getDurationString(11, 0);
        System.out.println(ds4 + "\n");

        String ds5 = SecondsAndMinutes.getDurationString(0, 0);
        System.out.println(ds5 + "\n");

        String ds6 = SecondsAndMinutes.getDurationString(-30, 18);
        System.out.println(ds6 + "\n");

        String ds7 = SecondsAndMinutes.getDurationString(40, -23);
        System.out.println(ds7 + "\n");

        String ds8 = SecondsAndMinutes.getDurationString(-20, -20);
        System.out.println(ds8 + "\n");

        String ds9 = SecondsAndMinutes.getDurationString(10, 88);
        System.out.println(ds9 + "\n");

        System.out.println("***overloaded method***\n".toUpperCase());

        String ds10 = SecondsAndMinutes.getDurationString(7594);
        System.out.println(ds10 + "\n");

        String ds11= SecondsAndMinutes.getDurationString(9);
        System.out.println(ds11 + "\n");

        String ds12 = SecondsAndMinutes.getDurationString(-15);
        System.out.println(ds12 + "\n");

    }

    private static void challengeSixteen() {

        /*
            Write a class called areaCalculator

            Write a method called area with 1 double parameter named radius
                return -1 if radius is negative

                return a double value that represents the area of a circle
                    area_circle = radius * radius * Math.PI


            Write an overloaded method with 2 parameters x & y (both doubles & a side of a rectangle)
                return -1 if either or both parameters are negative

                the method returns the area of a rectangle
                    area_rectangle = x * y

         */

        double circle1 = AreaCalculator.area(5.0); // 78.53975
        System.out.println("circle1 " + circle1);
        double circle2 = AreaCalculator.area(-22); // -1
        System.out.println("circle2 " + circle2);
        double rectangle1 = AreaCalculator.area(5, 4); // 20.0
        System.out.println("rectangle1 " + rectangle1);
        double rectangle2 = AreaCalculator.area(-4, 6); // -1
        System.out.println("rectangle2 " + rectangle2);
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

    private static void challengeTwentyThree() {
         /*
            1. Write a NumberOfDaysInMonth class

            2. Write a method isLeapYear with a parameter of type int named year.
                the method returns a boolean

                The parameter needs to be
                    greater than or equal to 1 and less than or equal to 9999.
                    If the parameter is not in that range return false.

                Otherwise, if it is in the valid range,
                    calculate if the year is a leap year
                    and return true if it is a leap year, otherwise return false.

                To determine whether a year is a leap year, follow these steps:
                    1. If the year is evenly divisible by 4, go to step 2.

                        Otherwise, go to step 5 if NOT evenly divisible by 4.

                    2. If the year is evenly divisible by 100, go to step 3.
                        Otherwise, go to step 4.

                    3. If the year is evenly divisible by 400, go to step 4.
                        Otherwise, go to step 5.

                    4. The year is a leap year (it has 366 days).
                        The method isLeapYear needs to return true.

                    5. The year is not a leap year (it has 365 days).
                        The method isLeapYear needs to return false.

            3. TEST divisibility by 100 BUT_NOT/AND 400

                1. The following years are NOT leap years:

                This is because they are evenly divisible by 100 but NOT by 400.
                    1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600

                2. The following years ARE leap years:

                This is because they are evenly divisible by both 100 AND 400.
                    1600, 2000, 2400

            4. write another method called getDaysInMonth with 2 int parameters
                month and year

                if month is < 1 || month > 12 return -1
                if year is < 1 || year > 9999 return -1

                the method needs to return the number of days in a month
                NOTE: leap years have 29 days in the second month (February)

            TIP: use a switch statement
         */

//         REFERENCE NumberOfDaysInMonth class
        boolean yearN1600 = LeapYearCalculator.isLeapYear(-1600);
        System.out.println("yearN1600: " + yearN1600);
        boolean year1600 = LeapYearCalculator.isLeapYear(1600);
        System.out.println("year1600: " + year1600);
        boolean year2017 = LeapYearCalculator.isLeapYear(2017);
        System.out.println("year2017: " + year2017);
        boolean year2000 = LeapYearCalculator.isLeapYear(2000);
        System.out.println("year2000: " + year2000);

        // TEST numbers in range(1,100)
        boolean year4 = LeapYearCalculator.isLeapYear(4);
        System.out.println("year4: " + year4);

        // TEST divisibility by 100 AND 4 BUT_NOT 400
        boolean year1800 = LeapYearCalculator.isLeapYear(1800);
        System.out.println("year1800: " + year1800);
        boolean year1900 = LeapYearCalculator.isLeapYear(1900);
        System.out.println("year1900: " + year1900);

        // TEST divisibility by 100 AND 400 AND 4
        boolean year1924 = LeapYearCalculator.isLeapYear(1924);
        System.out.println("year1924: " + year1924);

        System.out.println("\ngetDaysInMonth\n");

        int daysInMonth1 = NumberOfDaysInMonth.getDaysInMonth(1, 2020);
        System.out.println("should be 31 since leap year: " + daysInMonth1);
        int daysInMonth2 = NumberOfDaysInMonth.getDaysInMonth(2, 2020);
        System.out.println("should be 29 since leap year: " + daysInMonth2);
        int daysInMonth3 = NumberOfDaysInMonth.getDaysInMonth(2, 2018);
        System.out.println("should be 28 since not leap year: " + daysInMonth3);
        int daysInMonth4 = NumberOfDaysInMonth.getDaysInMonth(-1, 2020);
        System.out.println("should be -1 since invalid input: " + daysInMonth4);
        int daysInMonth5 = NumberOfDaysInMonth.getDaysInMonth(2, -2020);
        System.out.println("should be -1 since invalid input: " + daysInMonth5);
    }

    private static void challengeTwentyFour() {
        /**
         * using the for statement, call the calculateInterest method with
         * the amount of 10000 with an interest rate of 2,3,4,5,6,7, and 8
         * and print result to the console below
         */

        System.out.println("\n\t challenge 24\n");
        Loops.forLoops(10000, 9);
    }

    private static void challengeTwentyFive() {
        /**
         * using the for statement, call the calculateInterest method with
         * the amount of 10000 with an interest rate of 2,3,4,5,6,7, and 8
         * and print result BACKWARDS to the console below
         */

        System.out.println("\n\t challenge 25\n");
        Loops.forLoops(8);

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

            boolean isPrime = Loops.isPrime(i);

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

    private static void challengeTwentyEight() {
        /*
            Write a class SumOddRange

            Write a method called isOdd with an int parameter called number
                returns a boolean

            validate parameter is greater than 0, return false otherwise
                return true if num is odd, else return false

            Write sumOdd method that has 2 int params: start and end (range of numbers)
                use a for loop to sum all odd numbers in that range including the end
                    return the int sum
                sumOdd should call isOdd

                end >= start and both start and end need to be greater than 0
                if param validation false, return -1

            HINT: use modulo/remainder operator
         */

        System.out.println("\tChallenge 28".toUpperCase());

        SumOddRange.sumOdd(1, 100);
        SumOddRange.sumOdd(-1, 100);
        SumOddRange.sumOdd(100, 100);
        SumOddRange.sumOdd(13, 13);
        SumOddRange.sumOdd(100, -100);
        SumOddRange.sumOdd(100, 1000);
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

    private static void challengeThirty() {
        /*
            write a method called sumDigits with 1 int param

            validate param is >=10 and return -1 if fail

            return the sum of the all digits in the number.
                numbers 0-9 have 1 digit so don't have to process them
                negative number don't get processed so return -1

                ex:
                    sumDigits(125) returns 8
                        1 + 2 + 5 = 8

                    sumDigits(1) returns -1

            HINTS:
                use n % 10 to extract the least significant digit
                use n / 10 to discard the least significant digit

         */

        System.out.println("the sum: " + DigitalSum.sumDigits(125));
        System.out.println("the sum: " + DigitalSum.sumDigits(780));
        System.out.println("the sum: " + DigitalSum.sumDigits(9));
        System.out.println("the sum: " + DigitalSum.sumDigits(-1));
    }

    private static void challengeThirtyOne() {
        /*
            write a class NumberPalindrome
            write the method isPalindrome with 1 int parameter called number
                returns a boolean based on if parameter is a palindrome

         */

        NumberPalindrome.isPalindrome(125);
        NumberPalindrome.isPalindrome(101);
        NumberPalindrome.isPalindrome(-6);
        NumberPalindrome.isPalindrome(-303);
        NumberPalindrome.isPalindrome(-411);
        NumberPalindrome.isPalindrome(3);
    }

    private static void challengeThirtyTwo() {
        /*
            write a class FirstLastDigitSum
            write the method sumFirstAndLastDigit with 1 int parameter called number
                returns -1 if param is negative

                the method needs to find the first and last digit of the parameter number passed to the method
                use a loop and return the sum of the first and last digit
         */

        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(252));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(257));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(0));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(5));
        System.out.println(FirstLastDigitSum.sumFirstAndLastDigit(-10));

    }

    private static void challengeThirtyThree() {
        /*
            write a class EvenDigitSum

            write the method getEvenDigitSum with 1 int parameter called number
                returns -1 if param is negative

                use a loop and return the sum of all even digits in the number
         */

        System.out.println("\n\tchallengeThirtyThree\n");

        System.out.println(EvenDigitSum.getEvenDigitSum(123456789));
        System.out.println(EvenDigitSum.getEvenDigitSum(252));
        System.out.println(EvenDigitSum.getEvenDigitSum(-22));
    }

    private static void challengeThirtyFour() {
       /*
            write a class SharedDigit

            write the method hasSharedDigit with 2 int parameters
                each parameter should within 10-99 inclusive
                returns false if one of the parameters is out of range

            if both numbers share a common digit return true
                ex: 25 and 58 share a five
        */

        System.out.println(SharedDigit.hasSharedDigit(12, 23));
        System.out.println(SharedDigit.hasSharedDigit(9, 99));
        System.out.println(SharedDigit.hasSharedDigit(15, 55));

    }

    private static void challengeThirtyFive() {
        /*
             write a class LastDigitChecker

            write the method hasSameLastDigit with 3 int parameters
                each parameter should within 10-1000 inclusive
                returns false if one of the parameters is out of range

            if at least 2 of the 3 numbers share the rightmost digit,
                otherwise return false

                ex: 25 and 58 share a five
         */

        System.out.println(LastDigitChecker.hasSameLastDigit(41, 22, 71));
        System.out.println(LastDigitChecker.hasSameLastDigit(23, 32, 42));
        System.out.println(LastDigitChecker.hasSameLastDigit(9, 99, 999));

    }

    private static void challengeThirtySix() {
        /*
            write a class FlourPacker

            write the method canPack with 3 int parameters
                if params are negative, return false;

                    bigCount: big flour bags (5 kilos each)
                    smallCount: small flour bags (1 kilo each)
                    goal: goal amount of kilos of flour needed to assemble a package

                returns true
                    if bigCount + smallCount must at least equal to the value of the goal

                    if sum is greater than the goal, ensure only full bags are used toward the goal amount
                        okay, if there are additional bags left over

                        ex: goal = 9, bigCount = 2, smallCount = 0
                            should return false since each big bag is 5 kilos and cannot be divided

                        ex: goal = 9, bigCount = 1, smallCount = 5
                            should return true since each big bag is 1 full bigCount bag and 4 full smallCount bags = goal
         */

        System.out.println(FlourPacker.canPack(1,0,4));
        System.out.println(FlourPacker.canPack(1,0,5));

        System.out.println(FlourPacker.canPack(0,5,4));
        System.out.println(FlourPacker.canPack(2,2,11));
        System.out.println(FlourPacker.canPack(-3,2,12));

        System.out.println(FlourPacker.canPack(5,3,24));

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
                System.out.println(INVALID_NUMBER.toUpperCase());
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
        SimpleCalculator simpleCalculator = new SimpleCalculator();

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

    private static void challengeFortyOne() {
        /*
            create a bank account class
                with fields:
                    account number, balance, customer name, email and phone number

            create getters & setters for each field
            create deposit funds method that increments balance field
            create withdraw funds method that deducts from balance field
                only allow withdraws if there are sufficient funds
         */

        OOP_BankAccount testAccount = new OOP_BankAccount();
        double amount = testAccount.withdrawFunds(100d);
        testAccount.depositFunds(50d);
        amount = testAccount.withdrawFunds(100d);
        testAccount.depositFunds(51d);
        amount = testAccount.withdrawFunds(100d);

        testAccount.setBalance(400d);
        System.out.println(testAccount.getBalance());
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

    private static void challengeFortyFour() {
        /*
            write a method getGreatestCommonDivisor with two params of type int named first and second

                if one of the params < 10, return -1

                the method should return the greatest common divisor of the 2 numbers (int)

                HINT: greatest common divisor is the largest positive integer that can fully divide each of the integers (no remainder)

                    12 = [12, 1], [6, 2], [4,3]
                    GCF/GCD = 6

         */

        System.out.println(getGreatestCommonDivisor(2, 40));
        System.out.println(getGreatestCommonDivisor(35, -14));
        System.out.println(getGreatestCommonDivisor(12, 30));
    }

    public static int getGreatestCommonDivisor(int num1, int num2) {

        // divide by 2 to optimize performance
        int endLoop = Math.max(num1, num2) / 2;
        int gcf = 1;

        if(num1 >= 10 && num2 >= 10) {

            // loop from 1 => largest parameter
            for(int factor = 1; factor <= endLoop; factor++) {

                if((num1 % factor == 0) && (num2 % factor == 0)) {
                    gcf = factor;
                }
            }

            return gcf;
        }

        return -1;
    }

    private static void challengeFortyFive() {
        /*
            Create Vehicle class
            Create Car class that inherits from Vehicle class
            Create specific model class that inherits from Car class

            in conjunction with state, the shared vehicle behaviors have:

                hand steering,

                changing gears,
                    changing gears, increasing/decreasing speeding should be included

                moving with speed

            specific model class should have unique behavior
         */

        Inheritance_Ferrari ferrari = new Inheritance_Ferrari(36);
        ferrari.steer(45);
        ferrari.accelerate(30);
        ferrari.accelerate(20);
        ferrari.accelerate(-42);
    }

    private static void challengeFortySix() {
        /*
            write FactorPrinter class
            write the printFactors method with 1 int parameter called number

                that returns nothing, but prints all the factors of a number

            if number is less than 1, print 'Invalid Value'

            * HINT: a factor is an integer that divides that number wholly (no remainder)
         */

        FactorPrinter.printFactors(6);
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

    private static void challengeFortyEight() {
        /*
            create a Printer class that uses ENCAPSULATION: enables restricting access to certain components
                    !READ: protect object instance members/class fields from external access for direct inappropriate update

                Printer class fields: tonerLevel, numPages, isDuplexPrinter (capable of both-side printing)

                Printer methods:
                    set toner level up to a max 100%
                    printPage() which increases the number of pages printed
         */

//        Encapsulation_Printer printer = new Encapsulation_Printer(50, true);
        Encapsulation_Printer printer = new Encapsulation_Printer(50, false);
        System.out.println("initial page count: " + printer.getNumPagesPrinted());

        int pagesPrinted = printer.printPages(4);
        System.out.println("pages printed: " + pagesPrinted + "; new print total: " + printer.getNumPagesPrinted());

        pagesPrinted = printer.printPages(2);
        System.out.println("pages printed: " + pagesPrinted + "; new print total: " + printer.getNumPagesPrinted());
    }


}