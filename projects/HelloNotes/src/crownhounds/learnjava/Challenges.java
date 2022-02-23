package crownhounds.learnjava;


import java.util.Locale;

public class Challenges {

    public static void main(String[] args) {

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
        challengeSeventeen();

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

}
