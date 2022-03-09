package crownhounds.learnjava;

public class EvenDigitSum {

    public static int getEvenDigitSum(int number) {

        int sum = 0;
        int remainder = 0;
        int numLastIndex = Integer.toString(number).length() -1;

        if (number < 0) {
            return -1;
        }

        for(int i = numLastIndex; i >= 0; i--) {

            remainder = number % 10;
            number /= 10;

            if(remainder % 2 == 0) {
                sum += remainder;
            }
        }

        return sum;

    }
}
