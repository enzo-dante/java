package crownhounds.learnjava;

public class IntEqualityPrinter {

    public static final String INVALID_MESSAGE = "Invalid Value";
    public static final String EQUAL_MESSAGE = "All numbers are equal";
    public static final String DIFFERENT_MESSAGE = "All numbers are different";
    public static final String NEITHER_MESSAGE = "Neither all are equal or different";

    public static void printEqual(int num1, int num2, int num3) {

        if(num1 < 0 || num2 < 0 || num3 < 0) {
            System.out.println(INVALID_MESSAGE);
            return;
        }

        if(num1 == num2 && num1 == num3) {
            System.out.println(EQUAL_MESSAGE);
        } else if((num1 != num2 && num1 != num3) &&
                (num2 != num3)) {
            System.out.println(DIFFERENT_MESSAGE);
        } else {
            System.out.println(NEITHER_MESSAGE);
        }
    }
}
