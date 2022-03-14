package crownhounds.learnjava;

import java.util.ArrayList;
import java.util.Arrays;

public class BigO {

    public static void main(String[] args) {

//        timeComplexity("array");

        /*
            unstable algorithm: if there are duplicate elements, no guarantee that their original order will be preserved
            stable algorithm: if there are duplicate elements, the original order of these elements will be preserved
         */
//        timeComplexity("bubble sort algorithm");
//        timeComplexity("selection sort algorithm");
        timeComplexity("insertion sort algorithm");
//        timeComplexity("shell sort algorithm");

    }

    public static void timeComplexity(String dataStructure) {
        /*
            Big O Notation = O(n)

                algorithm TIME COMPLEXITY relative to the number of items
                being processed in a hardware-independent manner

                (best-to-worst performance)

                O(1) = O of 1
                    constant time complexity

                O(logn) = O of log to the base 2 n
                    logarithmic time complexity

                 O(n) = O of n
                    linear time complexity

                O(nlogn) = O of n log n
                    n log-star n

                O(n^2) = O of n-squared
                    quadratic time complexity

           time complexity:

            1. the WORST CASE SCENARIO for the NUMBER OF STEPS that it takes
                to execute an algorithm

            2. SCALE MEASUREMENT: the time complexity is a measurement of how
                an algorithm will perform as the number of items it has to process grows;
                does it degrade over time?
         */

        System.out.println("\ttime complexity: ".toUpperCase() + dataStructure + "\n");

        switch (dataStructure.toUpperCase()) {
            case "ARRAY":
                arrays();
                break;
            case "BUBBLE SORT ALGORITHM":
                Algorithms.bubbleSort();
                break;
            case "SELECTION SORT ALGORITHM":
                Algorithms.selectionSort();
                break;
            case "INSERTION SORT ALGORITHM":
                Algorithms.insertionSort();
                break;
            case "SHELL SORT ALGORITHM":
                Algorithms.shellSort();
                break;
        }

    }

    public static void spaceComplexity() {
        /*
            space complexity:

            the WORST CASE SCENARIO for the amount of memory it takes
            to execute an algorithm

         */
    }

    private static void arrays() {
        /*
            arrays are efficient:
                when you know the index of the value you want to get
                    step 1: multiply size of the element by its index
                    step 2: get the start address of the array
                    step 3: add the start address to the result of the multiplication

                memory efficient because you don't have to store extra info with each element in the array

         */

        /*
            ! O(1) constant time complexity when getting an element with index in an array
                    step 1: multiply size of the element by its index
                    step 2: get the start address of the array
                    step 3: add the start address to the result of the multiplication
         */

        int index = -1;

        System.out.println("\nO(1) constant time complexity when getting an element with index in an array");

        int[] intArray = new int[4];
        intArray[0] = 20;
        intArray[1] = -20;
        intArray[2] = 539;
        intArray[3] = 0;

        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] == 539) {
                index = i;
                System.out.println("index: " + index);
                break;
            }
        }

        System.out.println("\nO(n) linear time complexity when " +
                "getting an element WITHOUT an index and worst-case is you have to search until the end of an array");

        index = -1;

        for(int i = 0; i < intArray.length; i++) {
            if(i == (intArray.length - 1)) {
                index = i;
                System.out.println("index: " + index);
                break;
            }
        }

        System.out.println("\nO(n) linear time complexity (1 loop = n)" +
                "\n\twhen adding an element to a full array" +
                "\n\twhen deleting an element by shifting elements in a new array");

        int[] fullArray = new int[intArray.length + 1];
        for(int i = 0; i < fullArray.length; i++) {
            if(i != fullArray.length - 1) {
                fullArray[i] = intArray[i];
            } else {
                fullArray[i] = 799;
            }
            System.out.println(fullArray[i]);
        }

        System.out.println("\nO(1) constant time complexity " +
                "\n\twhen adding an element to an array with space " +
                "\n\twhen inserting/updating an element at specific index " +
                "\n\twhen deleting an element at specific index by setting it to null");


        intArray[1] = -1000;
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

}
