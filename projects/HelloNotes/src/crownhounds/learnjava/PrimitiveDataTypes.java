// learnjava is a subfolder of crownhounds for organization
package crownhounds.learnjava;

public class PrimitiveDataTypes {

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
