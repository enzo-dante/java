package crownhounds.learnjava;

import java.util.Arrays;
import java.util.Scanner;

public class DataStructures {

    public static void main(String[] args) {
        // CERTAIN DATA TYPES TAKE MORE SPACE IN MEMORY THAN OTHERS

//        primitiveDataTypes();
        arrayDataStructure();

    }

    public static void overAndUnderFlow() {
         /*
        overflow & underflow = value exceeds memory allocated by computer
            Integer is used to perform operations on an int
         */

        int myMinInt = Integer.MIN_VALUE;
        int myMaxInt = Integer.MAX_VALUE;
        System.out.println("BUSTED UNDERFLOW MIN: " + (myMinInt - 1));
        System.out.println("BUSTED OVERFLOW MAX: " + (myMaxInt + 1));

    }

    private static void primitiveDataTypes() {
        PrimitiveDataTypes.integers();

        PrimitiveDataTypes.byteShortAndLongs();

        PrimitiveDataTypes.floatingPointNumbers();

        PrimitiveDataTypes.casting();

        PrimitiveDataTypes.booleansCharsAndStrings();
    }

    private static void arrayDataStructure() {

        Array.createArray();

        System.out.println("\n-------------\n");

        Array.getInputSum(5);

        System.out.println("\n-------------\n");

        Array.getInputAverage(5);

    }
}

class Array{

    public static void createArray() {

        // defining an array in java
        String[] myDefinedArray = {"Steve", "Mark", "Mary"};

        System.out.println("\nuse 'Arrays' wrapper to access .toString method to print as an String array/String[] in console: \n" +
                Arrays.toString(myDefinedArray));

        // a new array of 10 int elements
        int[] arrayOfIntegers = new int[10];

        /*
            ! all arrays start at index 0

            * to access & set an element of an array with a newValue

                array[at index] = newValue
         */

        arrayOfIntegers[0] = 50;

        System.out.println("\naccess the 1st element at index 0 in new int[10] array & set the element of arrayOfIntegers[0]: \n" +
                arrayOfIntegers[0]);

        // array works with other data types
        double[] arrayOfDoubles = new double[23];
        arrayOfDoubles[21] = 1000;

        System.out.println("\naccess new double[23] array & set an element at arrayOfDoubles[21]: \n" +
                arrayOfDoubles[21]);

        System.out.println("\n------------\n");

        float[] floatArray = new float[5];

        for(int i = 0; i < floatArray.length; i++) {
            floatArray[i] = i * 10;
            System.out.println("index " + i + " = " + floatArray[i]);
        }

        System.out.println("\nuse for loop to access each index in new float[5] array given floatArray.length & set the element: \n" +
                Arrays.toString(floatArray));
    }

    public static int getInputSum(int numElements) {

        int inputSum = 0;

        /**
         * getUserInput() takes an int for the number of elements of an array and captures user input scanned from the console to set as the array's element values
         */
        int[] userInput = getUserInput(numElements);

        for(int i = 0; i < userInput.length; i++) {
            inputSum += userInput[i];
            System.out.println("Element value: " + userInput[i] + " at index: " + i);
        }

        System.out.println("\nuse a while loop to build an userInputArray of n elements\n" +
                "then use a for loop to getInputSum(n): " + inputSum);

        return inputSum;
    }

    public static void getInputAverage(int numElements) {

        // use a double since the average might not be a whole number/integer
        double inputAvg;

        int sum = getInputSum(numElements);

        inputAvg = (double) sum / (numElements + 1);

        System.out.println("\nuse a while loop to build an userInputArray of n elements\n" +
                "then use a for loop to getInputSum(n): " + sum +
                "\nthen use a for loop to getInputAverage(n): " + inputAvg);

    }

    private static int[] getUserInput(int numElements) {

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        int[] userInputArray = new int[numElements];

        while(index < userInputArray.length) {

            System.out.println("Enter a number: ");

            if(scanner.hasNextInt()) {
                // scanner object has nextInt method that will cast automatic string number from console into int variables
                int capturedUserInput = scanner.nextInt();
                userInputArray[index] = capturedUserInput;

                // increment index for next element in array assignment
                index++;

                // use scanner.nextLine after nextInt to handle enter key (line separator) input error
                scanner.nextLine();

            }

        }

        return userInputArray;
    }
}
