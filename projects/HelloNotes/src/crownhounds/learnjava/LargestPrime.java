package crownhounds.learnjava;

public class LargestPrime {

    public static int getLargestPrime(int number) {

        int largestPrimeFactor = 2;
        boolean isDivisibleFactor;

        if(number <= 1) {
            return -1;
        }

        // continue loop until you get to largestPrimeFactor
        while(largestPrimeFactor < number) {

            isDivisibleFactor = number % largestPrimeFactor == 0;

            if(isDivisibleFactor) {

                // decrement number by factor to get to prime factors
                number /= largestPrimeFactor;

            } else {
                largestPrimeFactor++;
            }
        }

        return number;
    }
}