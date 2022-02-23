package crownhounds.learnjava;

import java.util.ArrayList;

public class ChallengesLeetCode {

    private static final String INVALID_MESSAGE = "Invalid Value";

    public static void main(String[] args) {


//        leetCode412();
//        leetCode9();
//        leetCode172();
        leetCode50();
    }

//    private static void leetCodeTemplate() {
//        System.out.println("\n\tleet code NUMBER".toUpperCase());
//
//    }

    private static void leetCode412() {
        System.out.println("\n\tleet code 412".toUpperCase());
        fizzBuzz(5);
        fizzBuzz(-10);
        fizzBuzz(15);
    }

    private static ArrayList<String> fizzBuzz(long n) {
        /*
            write a program that outputs the string representation of number from 1 to n
                for multiples of:
                    3 it should print "Fizz" instead of the number
                    5 it should print "Buzz" instead of the number
                    5 AND 3 it should print "FizzBuzz" instead of the number
         */

        ArrayList<String> myArr = new ArrayList<String>();

        if(n < 0) {
            myArr.add(INVALID_MESSAGE);
            System.out.println(myArr.get(0));

            return myArr;
        }

        for (long i = 0; i < n; i++) {
            long num = i + 1;
            boolean multipleOf5 = num  % 5 == 0;
            boolean multipleOf3 = num % 3 == 0;

            if(multipleOf5 && multipleOf3) {
                myArr.add("FizzBuzz");
            } else if(multipleOf5) {
                myArr.add("Buzz");
            } else if(multipleOf3) {
                myArr.add("Fizz");
            } else {
                myArr.add(Long.toString(num));
            }
        }

        System.out.println(myArr);
        return myArr;
    }

    private static void leetCode9() {
        System.out.println("\n\tleet code 9".toUpperCase());
        palindromeNumber(121);
        palindromeNumber(123);
        palindromeNumber(-78);
    }

    private static boolean palindromeNumber(long n) {
        /*
            Determine whether an integer is a palindrome.
            An integer is a palindrome when it reads the same backward as forward
         */
        boolean isPal = false;

        String convertedNum = Long.toString(n);
        String reversedNum = "";
        char num;

        if(n < 0) {
            System.out.println(INVALID_MESSAGE);
            return isPal;
        }

        for(int i = 0; i < convertedNum.length(); i++) {
            num = convertedNum.charAt(i);
            reversedNum = num + reversedNum;
        }

        if(convertedNum.equals(reversedNum)) {
            isPal = true;
            System.out.println(n + " is a pal");
        } else {
            System.out.println(n + " is NOT a pal");
        }

        return isPal;
    }

    private static void leetCode172() {
        System.out.println("\n\tleet code 172".toUpperCase());
        int numZeroes1 = factorialTrailingZeroes(5);
        int numZeroes2 = factorialTrailingZeroes(-7);
        int numZeroes3 = factorialTrailingZeroes(15);

    }

    private static int factorialTrailingZeroes(int n) {
        /*
            given an integer n, return the number of trailing zeroes in n!

            must solve in logarithmic time complexity
                O(log(n))

            TIP:
                1. n would have a trailing 0 when multiplied by 10
                    each multiple of 10 would add a 0
                        7 * 10 = 1 trailing 0s
                        8 * 100 = 2 trailing 0s

                2. 10 = 2 * 5
                    if n has factorials 2 & 5, then there is at least 1 trailing 0

                        ex: n = !5

                        !5 = 1 * 2 * 3 * 4 * 5 = 120

                        !5 = 1 * 3 * (2 * 2) * (2 * 5) = 120

                        if you track the number of multiples of 5, you will get number of trailing 0s
                            given that there are multiple 2s,

                        !5 has 1 trailing 0
         */

        int numTrailingZeroes = 0;
        int factoredNum = n;

        // validate n is a positive number
        if(n < 0) {
            System.out.println(INVALID_MESSAGE);
            return -1;
        }

        // use loop to continuously divide n by 5
        while (factoredNum > 0) {
            factoredNum /= 5;
            // track number of times n is divisible by 5
            // multiples of 5 = num of trailing 0s
            numTrailingZeroes += factoredNum;
        }

        // time complexity: 0(log5(n))
        // constant time complexity 0(1) since we are just using 1 variable: count
        System.out.println("!" + n + " numTrailingZeroes: " + numTrailingZeroes);
        return numTrailingZeroes;
    }

    private static void leetCode50() {
        System.out.println("\n\tleet code 50".toUpperCase());
        power(2, 14);
        power(2, -2);

    }

    private static double power(double x, long n) {
        /*
            power(x,n) calculates x raised to the power of n
            x = double value
            n = long value to prevent overflow

                2.1^3 = 9.261

            TIP: use casting
         */

        double product = 1d;
        long exponent = n;
        double base = x;

        // if exponent is negative, get absolute value
        if(n < 0) {
            exponent *= -1;
        }

//        loop through exponents until exponent = 0
        while(exponent > 0) {
         /*
            check if exponent is even and split even exponents
                else subtract exponent by 1 and repeat until exponent is 0

                    2^14 = (2^2)^7 = 4^7
         */
            if(exponent % 2 == 0) {
                base *= base;
                exponent /= 2;
            } else {
                product = product * base;
                exponent = exponent - 1;
            }
        }

        if(n < 0) {
            // a number to a negative exponent is a fraction
            product = 1d / product;
        }

        // time complexity of log2(n)
        System.out.println("\n"+x + " to the power of " + n + ":\n" + product);
        return product;
    }

}
