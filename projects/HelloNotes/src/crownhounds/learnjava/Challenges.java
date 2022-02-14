package crownhounds.learnjava;

import java.util.Locale;

public class Challenges {

    public static void main(String[] args) {

//        challengeOne();
//        challengeTwo();
//        challengeThree();
//        challengeFour();
        challengeFive();

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
            print out a second score on the screen with the following:
                gameOver = true;
                score set to 1000
                levelCompleted set to 8
                bonus set to 200

            but make sure a first score is still displayed on the screen too
         */
        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;
        int firstScore = 0;
        int secondScore = 0;

        if(firstScore <= 0) {
            firstScore = calculateScore(bonus, levelCompleted, score, gameOver);
            System.out.println("GAME OVER first score: " + firstScore);
        }

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if(firstScore > 0) {
            secondScore = calculateScore(bonus, levelCompleted, score, gameOver);
            System.out.println("GAME OVER second score: " + secondScore);
        }
    }

    private static int calculateScore(int bonus, int levelCompleted, int score, boolean gameOver) {

        if(gameOver) {
            return score + (levelCompleted * bonus);
        }

        return -1;
    }
}
