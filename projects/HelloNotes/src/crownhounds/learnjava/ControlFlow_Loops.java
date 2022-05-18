package crownhounds.learnjava;

// handled by ControlFlow class
public class ControlFlow_Loops {

    private static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate/100));

    }

    public static void whileLoops() {
       int count = 0;

       // while(isExpressionTrue) execute
       while(count != 5) {
//           System.out.println("count: " + count);
           count++;
       }

       // common infinite loop that exits on break
       while(true) {
           if(count == 5) {
               break;
           }
//           System.out.println("count: " + count);
           count++;
       }

       count = 6;
        // do while: always execute at least once
            // could create an infinite loop
       do {
           System.out.println("count: " + count);
           count++;

           if(count > 100) {
               break;
           }
       } while(count != 6);


       // while loop that uses continue
        int num = 4;
        int finNum = 20;

        while(num <= finNum) {
            num++;

            if(num % 2 != 0) {
                // bypass print statement
                continue;
            }

            System.out.println(num + " is even");
        }
    }
    public static void forLoops() {

        // (start; exit once condition is false; cycle increment)
        for(int i = 0; i < 9; i++) {
            double interestRate = (double) i + 1;
            double amount = calculateInterest(10000d, interestRate);
            System.out.println("10K at " + interestRate + "% interest: " + amount);
        }
    }

    // overloaded method for challenge 24
    public static void forLoops(double amount, int numLoops) {
        for(int i = 2; i < numLoops; i++) {
            double calcAmount = calculateInterest(amount, (double) i);
            // %.2f = only 2 decimal point precision
            String formatAmount = String.format("%.2f", calcAmount);
            System.out.println("10K at " + i + "% interest: " + formatAmount);
        }
    }

    // overloaded method for challenge 25
    public static void forLoops(int numLoops) {
        for(int i = numLoops; i > 1; i--) {
            double calcAmount = calculateInterest(10000, (double) i);
            String fAmount = String.format("%.2f", calcAmount);
            System.out.println("10K at " + i + "% interest: " + fAmount);
        }
    }

    // for challenge 26
    public static boolean isPrime(int n) {

        // prime numbers can only divide evenly by 1 or by itself

        if(n == 1) {
            return false;
        }

        // n/2 is optimization because only check 1st half of number up to n
            // 2nd half will not be evenly divisible for n
        for(int i = 2; i <= n/2; i++) {

            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }


}
