package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

public class BigO {
    /*
        ! Big(O) Notation: independent of hardware, an algorithm's TIME COMPLEXITY relative to the number of processed items
            Always measures WORST-CASE scenario

        ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

        ! Big(O) SCALE MEASUREMENT: the algorithm's TIME COMPLEXITY performance as the number of processed items grows

        * Big(O) TYPES
        best-to-worst performance

            * O(1) = O of 1
               constant time complexity

            * O(logn) = O of log n to the base 2
               logarithmic time complexity

            * O(n) = O of n
               linear time complexity where n is the length of the given array

            * O(nlogn) = O of n log n
               loglinear time complexity

            * O(n^2) = O of n-squared
               quadratic time complexity
     */

    // OOP ENCAPSULATION private class fields
    // default instantiation values
    private static int index = -1;
    private static int[] intArray = {20, -20, 539, 0};

    public static void main(String[] args) {

        constantTimeComplexity();

        Util.printSeparator();

        linearTimeComplexity();
    }

    // ! STATIC: single instance shared in memory
    // ! ACCESS-MODIFIER private: visibility limited to the scope of this class & access restricted outside
    private static void constantTimeComplexity() {

        System.out.println("\nO(1) constant time complexity when GETTING an element with index in an array\n");

        index = 2;
        System.out.println("O(1) array[index]: " + intArray[index]);
    }

    private static void linearTimeComplexity() {
        System.out.println("\nO(n) linear time complexity when" +
                "\ngetting an element WITHOUT an index" +
                "\nworst-case is you have to search until the end of an array\n");

        for(int i = 0; i < intArray.length; i++) {
            if(i == (intArray.length - 1)) {
                index = i;
                System.out.println("O(n) array[index]: " + index);
                break;
            }
        }
    }
}