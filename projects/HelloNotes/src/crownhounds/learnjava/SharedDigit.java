package crownhounds.learnjava;

public class SharedDigit {

    public static boolean hasSharedDigit(int num1, int num2) {

        boolean hasShared = true;
        int digit0 = 0;
        int digit1 = 0;
        int digit2 = 0;
        int digit3 = 0;

        if((num1 < 10 || num1 > 99) ||
                (num2 < 10 || num2 > 99)) {

            hasShared = false;

        } else {

            digit0 = num1 % 10;
            digit1 = num1 / 10;
            digit2 = num2 % 10;
            digit3 = num2 / 10;

            if(digit0 != digit2 &&
                    digit0 != digit3 &&
                    digit1 != digit2 &&
                    digit1 != digit3) {

                hasShared = false;

            }
        }

        return hasShared;
    }
}
