package crownhounds.learnjava;

public class Challenges {

    public static void main(String[] args) {

//        challengeOne();
//        challengeTwo();
        challengeThree();




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
}
