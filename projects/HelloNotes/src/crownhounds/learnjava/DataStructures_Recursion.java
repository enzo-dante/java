package crownhounds.learnjava;

public class DataStructures_Recursion {

    /*
        RECURSION is when an algorithm calls itself

            each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)

                after reaching the base case/breaking condition:
                    either the algorithm then starts to work backwards resolving each item on the que stack with the return of the recursive call
                    or a stack overflow has happened

                !3 = 1*2*3 = 6
                    each call on the call stack resoles in an upwards direction upon reaching the base case: recursiveFactorial(0)

                        recursiveFactorial(3) returns 3 * (2 * 1) = 6
                        recursiveFactorial(2) returns 2 * 1
                        recursiveFactorial(1) = returns 1 * 1
                        recursiveFactorial(0) = returns 1

        get factorials of a given number that showcases RECURSION

            !1 = !0 * 1 = 1
            !2 = 1*2 = !1 * 2
            !3 = 1*2*3 = !2 * 3
            !4 = 1*2*3*4 = !3 * 4
            !5 = 1*2*3*4*5 = !4 * 5

        simplified factorial equation for RECURSION

            !n = !(n-1) * n
     */

    /**
     * iterative factorial method that does NOT use recursion
     */
    public static int iterativeFactorial(int n) {

        int factorial = 1;

        if(n == 0) {
            return 1;
        }

        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    /**
     * recursive factorial method
     */
    public static int recursiveFactorial(int n) {

        // base case/breaking condition for unwinding
        if(n == 0) {
            return 1;
        }

        return recursiveFactorial(n - 1) * n;
    }
}
