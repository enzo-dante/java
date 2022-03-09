package crownhounds.learnjava;

public class LastDigitChecker {

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {

        boolean hasSameLastFor2 = false;

        if(isValid(num1) && isValid(num2) && isValid(num3)) {

            if(getLastDigit(num1) == getLastDigit(num2) ||
                    getLastDigit(num1) == getLastDigit(num3) ||
                    getLastDigit(num2) == getLastDigit(num3)) {

                hasSameLastFor2 = true;
            }
        }

        return hasSameLastFor2;
    }

    private static boolean isValid(int number) {

        return number >= 10 && number <= 1000;

    }

    private static int getLastDigit(int number) {

        return number % 10;

    }
}
