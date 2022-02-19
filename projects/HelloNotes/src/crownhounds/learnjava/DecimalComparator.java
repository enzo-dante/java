package crownhounds.learnjava;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {

        // multiply both params by 1000 to move comparison numbers for int casting
        int int1 = (int) (num1 * 1000);
        int int2 = (int) (num2 * 1000);

        return int1 == int2;
    }
}
