package crownhounds.learnjava;

public class DigitalSum {

    public static int sumDigits(int number) {

        System.out.println("\n\tsum digits challenge\n".toUpperCase());

        int sum = 0;
        int numberLength = Integer.toString(number).length();

        if(number <= 10) {
            return -1;
        }

        // for loop solution
//        for(int i = 0; i < numberLength; i++) {
//            sum += number % 10;
//            number /= 10;
//        }

        // while loop solution
        while(number > 0) {
            // extract the least significant digit
            int digit = number % 10;
            sum += digit;

            // drop least significant digit
            number /= 10;
        }

        return sum;
    }
}
