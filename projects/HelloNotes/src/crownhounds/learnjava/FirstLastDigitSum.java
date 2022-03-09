package crownhounds.learnjava;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {
        String numStr = Integer.toString(number);
        int firstDigit = 0;
        int lastDigit = 0;

        if(number < 0) {
            return -1;
        } else if(numStr.length() == 1) {
            firstDigit = number;
            lastDigit = number;
        } else {
            for(int i = numStr.length() - 1; i >= 0; i--) {

                if(i == numStr.length() - 1) {
                    lastDigit = number % 10;
                } else if(i == 0) {
                    firstDigit = number % 10;
                }

                // pop off smallest digit
                number /= 10;
            }
        }

        return firstDigit + lastDigit;
    }
}
