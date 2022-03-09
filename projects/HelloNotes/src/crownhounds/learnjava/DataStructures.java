package crownhounds.learnjava;

public class DataStructures {

    public static void main(String[] args) {
        // CERTAIN DATA TYPES TAKE MORE SPACE IN MEMORY THAN OTHERS

//        primitiveDataTypes();
//        algorithms();

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

    private static void algorithms() {

    }


}
