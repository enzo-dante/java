package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

public class DS_Arrays {
        /*
            ! ARRAYS: memory efficient because you don't have to store extra info with each element in the array

            ! TIME COMPLEXITY O(1) constant: when getting an element with index in an array
                    step 1: multiply size of the element by its index
                    step 2: get the start address of the array
                    step 3: add the start address to the result of the multiplication
         */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String ARRAYS = "Arrays";
    private static final String AT_INDEX = " at index ";

    // OOP ENCAPSULATION private class fields
    // ! STATIC: single memory-shared value associated w/ class & not any specific class instance
    static int arrayLength = 4;

    public static void main(String[] args) {

        int[] intArray = new int[arrayLength];
        intArray[0] = 100;
        intArray[1] = 200;
        intArray[2] = 300;
        intArray[3] = 400;

        Util.printSeparator(ARRAYS);

        // ! Big(O) Notation / O(n): independent of hardware, an algorithm's TIME COMPLEXITY relative to the number of processed items
        // ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

        // ? O(1) constant time complexity when getting an element with index in an array
        for(int i = 0; i < intArray.length; i++) {

            if(intArray[i] == 300) {
                System.out.println(intArray[i] + AT_INDEX + i);
                break;
            }
        }

        Util.printSeparator();

        // ? O(n) linear time complexity when getting an element WITHOUT an index and worst-case is you have to search until the end of an array

        for(int i = 0; i < intArray.length; i++) {

            int endIndex = intArray.length - 1;
            if(intArray[i] == intArray[endIndex]) {
                System.out.println(intArray[i] + AT_INDEX + i);
            }
        }

        Util.printSeparator();

        /*
            ? O(n) linear time complexity (1 loop = n)
                when adding an element to a full array
                when deleting an element by shifting elements in a new array
         */

        int[] fullArray = new int[arrayLength + 1];
        for(int i = 0; i < fullArray.length; i++) {

            int endIndex = fullArray.length - 1;
            if(i != endIndex) {
                fullArray[i] = intArray[i];
            } else {
                fullArray[i] = 888;
            }
            System.out.println(fullArray[i]);
        }

        Util.printSeparator();

        int[] copy = {0, 0, 0, 0};
        System.arraycopy(intArray, 0, copy, 0, intArray.length);

        for (int e: copy) {
            System.out.println(e);
        }

        Util.printSeparator();

        /*
            ? O(1) constant time complexity
                when adding an element to an array with space
                when inserting/updating an element at specific index
                when deleting an element at specific index by setting it to null
         */

        for(int i = 0; i < intArray.length; i++) {
            intArray[2] = 999;
            System.out.println(intArray[i]);
        }

        Util.printSeparator();
    }
}