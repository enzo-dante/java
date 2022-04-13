package crownhounds.learnjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Please refer to DataStructures class
 */
public class DataStructures_Utility {

}

class ReferencesAndValues {

    public static void values() {

        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("both variables have the same value,\n" +
                "but each independent variable is allocated to it's own single space in memory:\n" +
                "\tmyIntValue: " + myIntValue + "\n" +
                "\tantherIntValue: " + anotherIntValue + "\n");
    }

    public static void references() {

        // ! every time the 'new' keyword is used, an object is initialized in memory & referenced
        // * both array of strings below, are referencing the same object address stored in memory

        String[] referenceStrings = new String[3]; // [null, null, null]
        String[] moreReferenceStrings = referenceStrings;

        System.out.println("a reference holds a memory address to the object, but not to the object itself\n" +
                Arrays.toString(referenceStrings) + "\n" +
                Arrays.toString(moreReferenceStrings) + "\n");

        moreReferenceStrings[0] = "test";

        System.out.println("PROOF: only updating moreReferenceStrings,\n" +
                "updates both variables because they are BOTH referencing the same space in memory\n" +
                Arrays.toString(referenceStrings) + "\n" +
                Arrays.toString(moreReferenceStrings));


        String[] stringsToModify = modifyArray(referenceStrings);

        System.out.println("PROOF: stringsToModify is a 3rd additional reference to the same address in memory like referenceString & moreReferenceStrings\n" +
                Arrays.toString(referenceStrings) + "\n" +
                Arrays.toString(moreReferenceStrings) + "\n" +
                Arrays.toString(stringsToModify));

        int[] arrayToDereference = new int[5]; // originally = [0,0,0,0,0]
        int[] originalMemorySpace = arrayToDereference;

        arrayToDereference = new int[] {10, 20, 30};

        System.out.println("\nyou can dereference an array to point to another space in memory\n" +
                Arrays.toString(arrayToDereference) + "\n" +
                Arrays.toString(originalMemorySpace) + "\n" +
                Arrays.toString(arrayToDereference));
    }

    private static String[] modifyArray(String[] stringsToModify) {

        stringsToModify[stringsToModify.length - 1] = "final";

        System.out.println("\nReferencesAndValues.modifyArray(stringsToModify) was called\n");

        return stringsToModify;
    }
}


class Array{

    public static void createArray() {

        // defining an array in java
        String[] myDefinedArray = {"Steve", "Mark", "Mary"};

        System.out.println("\nuse 'Arrays' wrapper to access .toString method to print as an String array/String[] in console: \n" +
                Arrays.toString(myDefinedArray));

        // ! the 'new' keyword is used to create and initialize the array elements to their default values (0 or null)
            // Strings[3] = [null, null, null]
            // int[3] = [0, 0, 0]

        // a new array of 10 int elements
        int[] arrayOfIntegers = new int[10];

        /*
            ! all arrays start at index 0

               array.length of 5 = int[5] = [index_0, index_1, index_2, index_3, index_4]

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

// learnjava is a subfolder of crownhounds for organization

class PrimitiveDataTypes {

    public static void main(String[] args) {

        // CERTAIN DATA TYPES TAKE MORE SPACE IN MEMORY THAN OTHERS

        /*
        wrapper class for all Java 8 primitive data types
            byte, short, int, long, float, double, char, boolean
         */

        int myMinInt = Integer.MIN_VALUE;
        int myMaxInt = Integer.MAX_VALUE;

        /*
        overflow & underflow = value exceeds memory allocated by computer
            Integer is used to perform operations on an int
         */

        DataStructures.overAndUnderFlow();

    }

    public static void byteShortAndLongs() {

        System.out.println("\nbyte Short And Longs\n".toUpperCase());

        // a byte occupies 8 bits/ a width of 8
        byte myMinByte = Byte.MIN_VALUE;
        byte myMaxByte = Byte.MAX_VALUE;
        System.out.println("Byte min: " + myMinByte);
        System.out.println("Byte max: " + myMaxByte);

        // a short occupies 16 bits/ a width of 16
        short myMinShort = Short.MIN_VALUE;
        short myMaxShort = Short.MAX_VALUE;
        System.out.println("Short min: " + myMinShort);
        System.out.println("Short max: " + myMaxShort);

        // a long occupies 64 bits/ a width of 64
        // a long value is expressed with a capital L
        long myLongValue = 100L;
        long myMinLong = Long.MIN_VALUE;
        long myMaxLong = Long.MAX_VALUE;
        System.out.println("Long value: " + myLongValue);
        System.out.println("Long min: " + myMinLong);
        System.out.println("Long max: " + myMaxLong);
    }

    public static void booleansCharsAndStrings() {

        System.out.println("\nbooleans chars and strings\n".toUpperCase());

        // conventional to name booleans starting with verbs as a question
        boolean isCustomerOver21 = true;
        System.out.println("isCustomerOver21: " + isCustomerOver21);

        // 16-bit chars are single unicode character that uses single quotes
        // https://unicode-table.com/en/
        char myChar = 'D';
        char myUnicodeChar = '\u0044'; // 'D'
        char myUnicodeCopyright = '\u00A9';

        System.out.println("myChar: " + myChar);
        System.out.println("myUnicodeChar: " + myUnicodeChar);
        System.out.println("myUnicodeCopyright: " + myUnicodeCopyright);

        // Strings can store multiple characters that use double quotes
        // Strings are immutable and can only be recreated via re-assignment
        String myString = "This is an IMMUTABLE string of characters";
        System.out.println("sentence 1: ".toUpperCase() + myString);

        System.out.println("\nuse StringBuffer (mutable),\n\t'appending values'/re-creating an immutable string with additional data is inefficient");

        myString += "!!!! ";
        System.out.println("sentence 2: ".toUpperCase() + myString);

        myString += (myUnicodeCopyright + "2019");
        System.out.println("sentence 3: ".toUpperCase() + myString);

        // String that have numbers will NOT run calculations
        // but simply be joined as a single string with a plus operator
        String numString = "250.55";
        numString += numString + "49.95";
        System.out.println("numString error: " + numString);

        String lastString = "10";
        int myInt = 50;
        double myDouble = 120.45d;
        lastString += myInt;
        lastString += myDouble;
        System.out.println("lastString error: " + lastString);
    }

    public static void casting() {

        System.out.println("\ncasting\n".toUpperCase());

        // CASTING is converting one datatype to another by prefacing with parenthesis with desired data type
        // JAVA uses int data type by default

        byte myMinByte = Byte.MIN_VALUE;
        short myMinShort = Short.MIN_VALUE;

        // error because defined as byte but int provided
        byte myByteTotal = (byte) (myMinByte/2);
        short myShortTotal = (short) (myMinShort / 2);
        System.out.println("CASTING myByteTotal: " + myByteTotal);
        System.out.println("CASTING myShortTotal: " + myShortTotal);
    }

    public static void floatingPointNumbers() {

        System.out.println("\nfloating point numbers\n".toUpperCase());

        // FLOATING POINT NUMBERS are numbers with a fraction for precision that express a decimal point
        // precision = format & amount of spaced occupied by the space
        // 32 bits floats & 64 bits doubles

        // JAVA assumes all floating point numbers are DOUBLES
        // it's best practice specify by adding an 'f' or a 'd' to a floating point number for a float or double

        float myMinFloat = Float.MIN_VALUE; // 32 bit single precision number with a decimal
        float myMaxFloat = Float.MAX_VALUE; // 32 bit single precision number with a decimal
        System.out.println("myMinFloat: " + myMinFloat);
        System.out.println("myMaxFloat: " + myMaxFloat);

        double myMinDouble = Double.MIN_VALUE; // 64 bit single precision number with a decimal
        double myMaxDouble = Double.MAX_VALUE; // 64 bit single precision number with a decimal
        System.out.println("myMinDouble: " + myMinDouble);
        System.out.println("myMaxDouble: " + myMaxDouble);

        // ints don't handle remainders
        int myIntValue = 5/3;
        float myFloatValue = 5f/ 3f;

        // doubles can be specified with a 'd' or with a decimal point in java
//        double myDoubleValue = 5d / 3d;
        double myDoubleValue = 5.00 / 3.00;

        System.out.println("myIntValue " + myIntValue);
        System.out.println("myFloatValue " + myFloatValue);
        System.out.println("myDoubleValue " + myDoubleValue);
    }

    public static void integers() {

        System.out.println("\nintegers\n".toUpperCase());

        // an int occupies 32 bits/ a width of 32

        // ints can have underscores in them to denote size
        int myIntTest = 2_155_200;

        int myMinInt = Integer.MIN_VALUE;
        int myMaxInt = Integer.MAX_VALUE;
        System.out.println("INT MIN: " + myMinInt);
        System.out.println("INT MAX: " + myMaxInt);

        int myIntTotal = (myMinInt / 2);

    }
}
