package crownhounds.learnjava;


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
        boolean isZeroRemainder = (remainder == 0d) ? true : false;
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


         */

        // REFERENCE LeapYearCalculator class

    }
}
