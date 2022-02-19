package crownhounds.learnjava;

public class TeenNumberChecker {

    public static boolean hasTeen(int num1, int num2, int num3) {

        // ! if one of params is "teen" (range 13 -19 (inclusive)), return true
        int minRange = 13;
        int maxRange = 19;
        boolean inRange = (num1 >= minRange && num1 <= maxRange) ||
                (num2 >= minRange && num2 <= maxRange) ||
                (num3 >= minRange && num3 <= maxRange);

        return inRange;
    }

    public static boolean isTeen(int num) {
        return (num >= 13) && (num <= 19);
    }
}
