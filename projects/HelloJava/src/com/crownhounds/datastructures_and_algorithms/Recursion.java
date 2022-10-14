package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

public class Recursion {
    /*
        ! RECURSION: self-calling algorithm & each call-stack call waits for a return until reaching base case or overflow
            an algorithm is a repeatable sequence of steps

        ? RECURSION base case/breaking condition: the algorithm either upward propagates recursive call return for stack resolution or experiences a stack overflow

        * factorial example:
            after the downward recursive calls, the app stops the recursive calls upon reaching the base case:

                recursiveFactorial(0)

            then, each stack call resolves in an upwards direction from the return values

                !3 = 1*2*3 = 6

                    recursiveFactorial(3)
                            returns 3 * (2 * 1) = 6

                    recursiveFactorial(2)
                            returns 2 * 1

                    recursiveFactorial(1)
                            returns 1 * 1

                    recursiveFactorial(0)
                            returns 1

        * RECURSION factorial logic:

            !1 = !0 * 1 = 1

            !2 = 1*2 = !1 * 2

            !3 = 1*2*3 = !2 * 3

            !4 = 1*2*3*4 = !3 * 4

            !5 = 1*2*3*4*5 = !4 * 5

        * simplified factorial equation for RECURSION

            !n = !(n-1) * n

        ? DIVIDE & CONQUER

            recursively divide the original problem into 2 or more sub-problems & repeat until the sub-problems become small enough to solve a base case

            after solving the base case/breaking condition, combine the solutions to construct the overall solution to the original problem
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String RECURSION = "Recursion";

    public static void main(String[] args) {

        Util.printSeparator(RECURSION);

        System.out.println("Downward recursive arguments:");
        int recursiveResult = recursiveFactorial(5);

        System.out.println("\nrecursiveFactorial(n): " + recursiveResult);
    }
    /**
     * recursive factorial method
     * @param n
     * @return
     */
    private static int recursiveFactorial(int n) {

        // RECURSIVE BASE CASE: the breaking condition that initiates an upward propagation of return of values for the waiting calls that results in a call-stack resolution or overflow
        if(n == 0) {
            return 1;
        }

        System.out.println(n);
        return recursiveFactorial(n - 1) * n;
    }

    /**
     * iterative factorial method WITHOUT RECURSION
     * @param n
     * @return factorial product
     */
    private static int iterativeFactorial(int n) {

        int factorial = 1;

        if(n == 0) {
            return 1;
        }

        for(int i = 1; i < n; i++) {
            factorial *= i;
        }

        return factorial;
    }
}