// learnjava is a subfolder of crownhounds for organization
package crownhounds.learnjava;

public class DataStructures {

    public static void main(String[] args) {

        // CERTAIN DATA TYPES TAKE MORE SPACE IN MEMORY THAN OTHERS

//        PrimitiveDataTypes.casting();

//        primitiveDataTypes();
//        arrayDataStructure();
        referencesAndValues();

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

//        DataStructures.overAndUnderFlow();

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

        PrimitiveDataTypes.booleansCharsAndStrings();
    }

    private static void arrayDataStructure() {

        Array.createArray();

        System.out.println("\n-------------\n");

        Array.getInputSum(5);

        System.out.println("\n-------------\n");

        Array.getInputAverage(5);

    }

    private static void referencesAndValues() {

        System.out.println("\nreferences vs values\n".toUpperCase());

        ReferencesAndValues.values();
        ReferencesAndValues.references();
    }

}