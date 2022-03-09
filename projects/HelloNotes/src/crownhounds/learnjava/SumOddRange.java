package crownhounds.learnjava;

public class SumOddRange {

    public static final String INVALID_MSG = "-1";

    private static boolean isOdd(int number) {

        if(number < 0 || number % 2 == 0) {
            return false;
        }

        return true;
    }

    public static int sumOdd(int start, int end) {

        int sum = 0;

        if(start < 0 || end < start) {
            System.out.println(INVALID_MSG);
            return -1;
        }

        for(int i = start; i <= end; i++) {

            if(isOdd(i)) {
                sum += i;
            }
        }

        System.out.println("sum: " + sum);
        return sum;
    }
}
