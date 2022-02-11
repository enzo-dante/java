// learnjava is a subfolder of crownhounds for organization
package crownhounds.learnjava;

public class DataTypes {

    public static void main(String[] args) {

        // CERTAIN DATA TYPES TAKE MORE SPACE IN MEMORY THAN OTHERS

        /*
        wrapper class for all 8 primitive data types
            Integer is used to perform operations on an int
         */
        int myMinInt = Integer.MIN_VALUE;
        int myMaxInt = Integer.MAX_VALUE;
        System.out.println("INT MIN: " + myMinInt);
        System.out.println("INT MAX: " + myMaxInt);

        /*
        overflow & underflow = value exceeds memory allocated by computer
         */
        System.out.println("BUSTED UNDERFLOW MIN: " + (myMinInt - 1));
        System.out.println("BUSTED OVERFLOW MAX: " + (myMaxInt + 1));

        // ints can have underscores in them to denote size
        // an int occupies 32 bits/ a width of 32
        int myIntTest = 2_155_200;

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

        int myIntTotal = (myMinInt / 2);

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

        // error because defined as byte but int provided
//        byte myByteTotal = (myMinByte / 2);

        // JAVA uses int data type by default
        // CASTING is converting one datatype to another by prefacing with parenthesis with desired data type
        byte myByteTotal = (byte) (myMinByte/2);
        short myShortTotal = (short) (myMinShort / 2);

    }
}
