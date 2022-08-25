package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.Arrays;

public class Algorithms_Sort {

    // OOP ENCAPSULATION private class fields

    public static void main(String[] args) {

//        BubbleSort.runAlgorithm();
//        SelectionSort.runAlgorithm();
        InsertionSort.runAlgorithm();
//        ShellSort.runAlgorithm();
//        MergeSort.runAlgorithm();
//        QuickSort.runAlgorithm();
//        CountingSort.runAlgorithm();
//        RadixStableSort.runAlgorithm();

    }

}

// ! ABSTRACT CLASSES: force child subclass INHERITANCE of method, signatures, & parent super-class fields for a set of classes
abstract class AlgorithmNotes {

    // CONSTANTS/private static variables assigned FINAL value before compilation/instantiation
    public static final String BUBBLE_SORT = "\tBubble Sort";
    public static final String SELECTION_SORT = "\tSelection Sort";
    public static final String INSERTION_SORT = "\tInsertion Sort";
    public static final String SHELL_SORT = "\tShell Sort";
    public static final String MERGE_SORT = "\tMerge Sort";
    public static final String QUICK_SORT = "\tQuick Sort";
    public static final String COUNTING_SORT = "\tCounting Sort";
    public static final String RADIX_STABLE_SORT = "\tRadix Stable Sort";

    private static final String PRE_IMPLEMENTATION_RESULTS = "\nPRE_IMPLEMENTATION_RESULTS:";
    private static final String POST_IMPLEMENTATION_RESULTS = "\nPOST_IMPLEMENTATION_RESULTS:";

    // OOP ENCAPSULATION private class fields
    public static int i;
    public static int j;
    public static int[] intArray = {20, 35, -15, 7, 55, 1, -22};

    // OOP CLASS METHODS: static (single memory shared instance) unique object behavior
    public static void printResults(int[] intArray, boolean isImplemented) {

        if(!isImplemented) {
            System.out.println(PRE_IMPLEMENTATION_RESULTS);

            System.out.println(Arrays.toString(intArray));

        } else {
            System.out.println(POST_IMPLEMENTATION_RESULTS);

            System.out.println(Arrays.toString(intArray));

            Util.printSeparator();
        }
    }

    /**
     * swap the element values at index i and index j in the given array
     * @param intArray
     * @param i index 1
     * @param j index 2
     */
    public static void swapValues(int[] intArray, int i, int j) {

        // ! STACK EXCEPTION HANDLING: look before your leap (LBYL) validation
        if(i == j) {
            return;
        }

        int placeholder = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = placeholder;
    }

    public static void prepareData(String title, int[] intArray) {

        System.out.println(title);
        printResults(intArray, false);
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent superclass
class BubbleSort extends AlgorithmNotes {
    /*
        ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

            * QUADRATIC TIME COMPLEXITY = O(n^2) = O of n-squared

                    WORST: each loop corresponds to n in Big-O notation, thus O(n^2)

        ! SPACE COMPLEXITY:

              in-place algorithm that doesn't use extra memory

        ! STABLE ALGORITHM:

              if there are duplicate elements, the original order of these elements will be preserved

                  only swap if element at index_i > (index_i + 1)

        ! LOGIC:

              bubble sort breaks the array into 2 partitions:

                  sorted and unsorted

                      bubble the largest element to the top/unsorted partition that grows with each loop

                      right-to-left sorted partition growth
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation

    // OOP CLASS METHODS: static unique object behavior
    // ! STATIC: memory-shared variable only requires class reference without an instance
    public static void runAlgorithm() {

        System.out.println(BUBBLE_SORT);
        printResults(intArray, false);

        // last index in the given iteration of the unsorted partition (array starts as unsorted)
        //      [[unsortedPartition][]] -> [[unsortedPartition][sortedPartition]]

        // ? SORTED PARTITION
        for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            // ? UNSORTED PARTITION
            for(i = 0; i < lastUnsortedIndex; i++) {

                j = i + 1;

                // right-to-left sorted partition growth
                if(intArray[i] > intArray[j]) {
                    swapValues(intArray, i, j);
                }
            }
        }

        printResults(intArray, true);
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent super class
class SelectionSort extends AlgorithmNotes {

    /*
        ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

            * QUADRATIC TIME COMPLEXITY = O(n^2) = O of n-squared

                    WORST: each loop corresponds to n in Big-O notation, thus O(n^2)

        ! SPACE COMPLEXITY:

            in-place algorithm that doesn't use extra memory

        ! UNSTABLE ALGORITHM:

            if there are duplicate elements, no guarantee that their original order will be preserved

        ! LOGIC:

            selection sort breaks the array into 2 partitions:

                sorted and unsorted
                    the unsorted partition shrinks from left to right

                        [[unsortedPartition][]] -> [[unsortedPartition][sortedPartition]]

            selection sort looks for the largest element in the unsorted partition
                the entire array starts as unsorted
                swap the largest element found with last element in the unsorted partition via respective index
                then decrement the lastUnsortedIndex var by 1 and repeat the process
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation

    // OOP CLASS METHODS: unique object behavior
    // ! STATIC: unique memory shared variable that only requires the class without an instance
    public static void runAlgorithm() {

        System.out.println(SELECTION_SORT);
        printResults(intArray, false);

        // last index in the given iteration of the unsorted partition (array starts as unsorted)
        //      [[unsortedPartition][]] -> [[unsortedPartition][sortedPartition]]
        int lastUnsortedIndex = intArray.length - 1;

        // largest value in the given iteration of the unsorted array
        int currentLargestIndex = 0;

        // ? UNSORTED PARTITION
        for(i = 0; i <= lastUnsortedIndex; i++) {

            // traverse array and track index with the largest element
            if(i != lastUnsortedIndex) {

                if(intArray[currentLargestIndex] < intArray[i]) {
                    currentLargestIndex = i;
                }

            } else {
                // when you reach end of unsortedPartition during traversal

                // if you find a larger value during unsortedPartition traversal, replace currentValue
                if(intArray[currentLargestIndex] < intArray[lastUnsortedIndex]) {
                    currentLargestIndex = lastUnsortedIndex;
                }

                // ? SORTED PARTITION
                // swap the largest element with element at the end of the unsorted partition
                swapValues(intArray, currentLargestIndex, lastUnsortedIndex);

                // reset largest element index for next unsortedPartition traversal
                // decrement length of unsorted partition AKA increment length of sorted partition
                i = 0;
                currentLargestIndex = 0;
                lastUnsortedIndex--;
            }
        }

        printResults(intArray, true);
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields + public methods from extending parent super class
class InsertionSort extends AlgorithmNotes {

    /*
        ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

            * QUADRATIC TIME COMPLEXITY = O(n^2) = O of n-squared

                    WORST: each loop corresponds to n in Big-O notation, thus O(n^2)

        ! SPACE COMPLEXITY:

            in-place algorithm that doesn't use extra memory

        ! STABLE ALGORITHM:

            if there are duplicate elements, the original order of these elements will be preserved
                because the search for insertion value position stops when you find a sorted value that is less than or equal

        ! LOGIC:

            insertion sort breaks the array into 2 partitions:

                sorted and unsorted

                        [[][unsortedPartition]] -> [[sortedPartition][unsortedPartition]]

                    sorted partition of 1 element array index 0

                        the inserting work is done in the SORTED partition where there is no swapping, the elements shift

                    unsorted partition starting at index 1

            on 1st iteration, take first element in the unsorted partition (index 1),
            save it, and then "insert" it into the sorted partition via comp

                by comparing if it is greater than or equal to the value in the sorted partition

                if sorted partition value is less than or equal to the unsorted inserting value,
                    than the inserting value is inserted at the index above the sorted partition value

                if the sorted partition value is greater than the unsorted inserting value,
                    than you shift the sorted partition value up 1
                    next, compare unsorted inserting value to the next decremented index value

                you repeat this process until you find the correct index for the unsorted inserting value, or you reach the beginning of the array (index 0)

            after the comparison(s) & inserting of the unsorted inserting value,
                GAP VALUE 1 = the sorted partition is grown by 1 and the index in the unsorted partition is incremented by 1

            repeat this process until the entire array is sorted
     */

    // OOP CLASS METHODS: unique object behavior
    // ! STATIC: unique memory shared variable that only requires the class without an instance
    public static void runAlgorithm() {

        System.out.println(INSERTION_SORT);
        printResults(intArray, false);
        int insertValue;

        // ? SORTED PARTITION
        // outer for loop is growing sorted partition by 1
        // index 0 is in sorted partition; index 1 will be 1st element in unsorted partition
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            // save unsorted inserting value since shifting of elements might cause overwritten value
            insertValue = intArray[firstUnsortedIndex];

            // traverse sorted partition for correct index of insertValue
            // while not at beginning of partition AND sortedArrayElement is greater than insertElement
            for(i = firstUnsortedIndex; i > 0 && intArray[i - 1] > insertValue; i--) {

                // if unsortedPartition insertValue less than currentSortedValue, shift left-to-right currentSortedValue up
                intArray[i] = intArray[i - 1];
            }

            // on finding correct index, assign insertValue to index in sorted partition
            intArray[i] = insertValue;
        }

        printResults(intArray, true);
    }
}

class ShellSort extends AlgorithmNotes {

    /*
        ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

            the varying gap value you decide on influences the time complexity

        ! SPACE COMPLEXITY:

            in-place algorithm that doesn't use extra memory

        ! UNSTABLE ALGORITHM:

            if there are duplicate elements, the original order of these elements will NOT always be preserved

        ! SHELL SORT LOGIC:

            PRELIMINARY WORK

            0. if majority array is mostly in correct order, no need to shift every element like insertion sort

            1. do preliminary work by starting with large gap value that gradually decreases with each iteration & shift elements (no swapping)

                        shell sort uses larger than 1 gapValue unlike insertion sort which has gapValue of 1

                        after initial iteration w/ large gap value, increment index of both gapValue and compValue & repeat until gapValue index is greater than array length

                        * compare array[j-gapValue] with insertingElement

            INSERTION SORT

            2. on the last iteration, when the gap value is 1

            3. the array has been partially sorted and no longer requires extensive shifting,

            4. then insertion sort is applied

                    * SHELL SORT is a VARIATION of INSERTION SORT

            ? GAP VALUE STRATEGY #1:

                 gap value is calculated using array's length:

                    gap value = array.length / 2

                 on each iteration, we will divide the gap value by 2 to get the next gap value

                 for the array below, there will only be 2 iterations

                        [20,35,-15,7,55,1,-22]

                    the (i) initialized gapValue = 3
                    the (j) sorted partitionValue = i = 3
                    gap value = array.length / 2
                    unsortedPreliminaryElement = array[gapValue]

                        compare array[j-gapValue] against unsortedPreliminaryElement

                    once you reach the end of the array on the 1st iteration, compare the first element again using the gap value
                    on the next/last iteration, the gapValue will be 1 for this array
                    if the gapValue is 1, then execute insertion sort

            ? GAP VALUE STRATEGY #2: Knuth Sequence

                gap value is calculated using:

                    (3^k - 1) / 2

                k = length of the array
                    we want the gap value to be as close to the length of array to be sorted without being greater than the length
     */

    // OOP CLASS METHODS: unique object behavior
    // ! STATIC: unique memory shared variable that only requires the class without an instance
    public static void runAlgorithm() {

        System.out.println(SHELL_SORT);
        printResults(intArray, false);

        // ? GAP VALUE STRATEGY # 1
        int insertValue;

        /*
            ? PRELIMINARY WORK

            gap = midpoint index of array (7 at index 3)
            continue loop while gap is greater than 0
            after each iteration divide gap by 2
         */
        for(int gap = (intArray.length / 2); gap > 0; gap /= 2) {

            // ? INSERTION SORT when gap = 1
            for(i = gap; i < intArray.length; i++) {

                // preserve value during shifting
                insertValue = intArray[i];

                // use j to traverse
                j = i;

                // if index j is less than gap, reached front
                while(j >= gap && (intArray[j-gap] > insertValue)) {
                    intArray[j] = intArray[j - gap];

                    // decrement to repeat until reaching beginning
                    j -= gap;
                }

                // shift insertingValue to approximated correct index
                intArray[j] = insertValue;
            }

        }

        printResults(intArray, true);
    }
}

class MergeSort extends AlgorithmNotes {
     /*
         ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

             * LOGARITHMIC TIME COMPLEXITY = O(logn) = O of log to the base 2 n
                     repeatedly dividing array in half during splitting

         ! SPACE COMPLEXITY:

             * overall: NOT in-place

             splitting phase = in-place algorithm that doesn't use extra memory
                 track splitting via indices

             merge phase = NOT in-place algorithm
                 creates temporary arrays for sorting siblings for merge

         ! STABLE ALGORITHM:

             if there are duplicate elements, the original order of these elements will be preserved

                 because only swap if element at index_i > (index_i + 1)

         ! MERGE SORT LOGIC:

             * divide & conquer algorithm:

                 splitting base problem into several mini-problems, solving mini-problems, and then merging mini-solutions to solve base problem

             * recursive algorithm:

                 calls itself until reaching a base case and then feeds return values to itself to solve backwards

             ? PHASE 1: splitting

                 logical splitting (in-place = no new arrays)

                 1. divide the array into two sub-arrays (left & right partition)
                 2. then recursively divide each subsequent array into two arrays
                 3. UNTIL you have multiple sorted arrays of 1 length

                     split left side first, then right side last
                         each split results in 'sibling arrays'

                     EXAMPLE:

                                  [20, 35, -15, 7, 55, 1, -22]

                         [20, 35, -15]       &&            [7, 55, 1, -22]

                     [20]    &&  [35, -15]            [7, 55]    &&      [1, -22]

                                [35] && [-15]       [7] && [55]        [1] && [-22]

             ? PHASE 2: merging (not in-place)

                 MERGING = sorting elements starting from bottom-to-up with temporary array

                     not in-place: uses new temporary arrays

                 handle left side first, then right side

                     merge all sibling arrays on left & right side before proceeding to higher level to recursively merge resulting sibling arrays

                 STEPS:

                 1. create temp array that can hold all elements in the arrays we're merging

                 2. set i to 1st index of left sibling array

                 3. set j to 1st index of right sibling array

                 4. traverse through left & right array & get the smallest value for temp: compare left[i] to right[j] sibling arrays

                     if left[i] is smaller, copy to temp array and increment i by 1
                     if right[j] is smaller, copy to temp array and increment j by 1

                     repeat until temp array has merged all elements into temp array in sorted order

                 5. copy temp array back into original input array at the correct position (making it a STABLE algorithm)

                 6. repeat steps 4 & 5 until you have sorted original input array
     */

    public static int[] runAlgorithm() {

        System.out.println(MERGE_SORT);
        printResults(intArray, false);

        // since using recursion, handle left side first, then right side
        mergeSort(intArray, 0, intArray.length);

        printResults(intArray, true);

        return intArray;
    }

    // ! ACCESS-MODIFIER private: restrict visibility of code to the scope of this class
    private static void mergeSort(int[] inputArray, int start, int end) {

        recursivePartition(intArray, start, end);
    }

    // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
    private static void recursivePartition(int[] inputArray, int start, int end) {

        // inputArray = [20, 35, -15, 7, 55, 1, -22]

        // ! RECURSION: an algorithm calls itself & each call waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        // RECURSIVE BASE CASE: 1 element PARTITIONS are sorted and don't require recursive calls
        boolean isBaseCase = (end - start) < 2;

        if(isBaseCase) {
            return;
        }

        // ! RECURSION + DIVIDE & CONQUER: partition LEFT side FIRST, THEN RIGHT side with midpoint via start & end sub-array
        int midpoint = (start + end) / 2;

        // inputArray = [20, 35, -15, 7, 55, 1, -22]

        // ? MERGE SORT LEFT partition + sub-partitions
        // [20, 35, -15] ->
        //      [20] [35, -15] ->
        //          [20] [35] [-15]

        recursivePartition(inputArray, start, midpoint);

        // ? MERGE SORT RIGHT partition + sub-partitions
        // [7, 55, 1, -22] ->
        //      [7, 55] [1,-22] ->
        //          [7] [55] [1] [-22]

        recursivePartition(inputArray, midpoint, end);

        // ? MERGE SORT left & right RECURSIVE returns arrays w/ sorted elements
        merge(inputArray, start, midpoint, end);

    }

    private static void merge(int[] inputArray, int start, int midpoint, int end) {

        int leftPartitionEnd = inputArray[midpoint - 1];
        int rightPartitionStart = inputArray[midpoint];
        boolean isAlreadySorted = leftPartitionEnd <= rightPartitionStart;

        // do nothing if already sorted
        if(isAlreadySorted) {
            return;
        }

        // then, some RIGHT partition elements > some LEFT partition elements
        i = start;
        j = midpoint;
        int tempIndex = 0;

        int[] tempArray = new int[end - start];

//        isTraversingLeft = i < midpoint;
//        isTraversingRight = j < end;
        while(i < midpoint && j < end) {

            // preserve partitions with equality
            int currentLeftElement = inputArray[i];
            int currentRightElement = inputArray[j];

            // ? MERGE SORT: write smaller of 2 comparison elements to temp array for left-to-right sorted order
            // ! STABLE ALGORITHM: if equal, write left first to preserve original order
            tempArray[tempIndex++] = currentLeftElement <= currentRightElement ? inputArray[i++] : inputArray[j++];
        }

        /*
            ? MERGE SORT OPTIMIZATION

                LEFT partition remaining elements, must copy to temp array

                RIGHT partition remaining elements, no copying into temp array needed bc already will be in sorted order for input array
         */

        int[] srcArray;

        int destinationIndex = start + tempIndex;
        int remainingElementIndex = i;

        // no action, if no remainder left partition elements
        // else move to correct index
        int notCopiedCount = midpoint - i;

        // ? MERGE SORT: copying sorted tempArray elements back into inputArray
        srcArray = inputArray;
        System.arraycopy(srcArray, remainingElementIndex, inputArray, destinationIndex, notCopiedCount);

        // only copy numElements in tempArray into inputArray
        srcArray = tempArray;
        System.arraycopy(srcArray, 0, inputArray, start, tempIndex);
    }
}

class QuickSort extends AlgorithmNotes {
    /*
         ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution

             * LOGARITHMIC TIME COMPLEXITY = O(logn) = O of log to the base 2 n
                     repeatedly dividing array in half during splitting

         ! SPACE COMPLEXITY:

             in-place algorithm that doesn't use extra memory

         ! UNSTABLE ALGORITHM:

             if there are duplicate elements, no guarantee that their original order will be preserved,
                 since quick sort is predicated on moving elements around a pivotIndex for recursive partitions

         ! QUICK SORT LOGIC:

             * divide & conquer algorithm:
                 splitting base problem into several mini-problems, solving mini-problems, and then merging mini-solutions to solve base problem

             * recursive algorithm:
                 calls itself until reaching a base case and then feeds return values to itself to solve backwards

             ? PHASE 1: partitioning step/pivotIndex splitting

                 identify pivotIndex for logical splitting (in-place = no new arrays)

                     each element and it's respective index eventually serves as the pivotIndex

                     CHECK: pivotIndex serves as boundary for 2 sibling sub-arrays that prevent crossover

                 1. divide the array into two sub-arrays (left & right partitions)
                 2. then recursively divide each subsequent array into two arrays
                 3. UNTIL you have multiple sorted arrays of 1 length (each containing the pivotIndex element at it's correct position)

                     in left sub-array, elements less than pivotIndex element are moved to the left during traversal
                     in right sub-array, elements greater than pivotIndex element are moved to the right during traversal

                     AS A RESULT, element at pivotIndex will be in the middle AND in its correct position

                     EXAMPLE:

                        right-to-left first
                        left-to-right second
                                                      [20, 35, -15, 7, 55, 1, -22]

                                     [-15, 7, 20, 35]       pivotIndex = 7            [-22, 1, 7, 55]

                     [-15, 7]    pivotIndex = 7  [7, 20, 35]            [-22, 1]    pivotIndex = 1      [1, 7, 55]

             [-15] && [7]     [7, 20] pivotIndex = 20 [20, 35]       [-22] && [1]        [1, 7] pivotIndex = 7 [7, 55]

                             [7] && [20] && [35]                                     [1] && [7] && [55]

                 STEPS:

                     STEP 1: identify pivotIndex for 2-or-more element arrays
                         pivotIndex is the correct position in the sorted array

                     STEP 2: use recursion to subsequently partition the left & right partitioned arrays into more sub-arrays using the pivotIndex
                         BREAK CASE for recursive calls: handle 1 element arrays

                         using the first element respective index in the array as the pivotIndex

                         for left partition, search/traverse from left to right
                         for right partition, search/traverse from right to left
                         stop traversal when i and j cross each other to maintain partitions

                         FOUND 1st element less than pivot during traversal of LEFT partition: so move elements at index j to index i (move to LEFT of pivotIndex)
                         FOUND 1st element greater than pivot during traversal of RIGHT partition: so move elements at index i to index j (move to RIGHT of pivotIndex)

                         after correct index for pivotIndex element has been FOUND after each traversal, re-assign pivotIndex for subsequent sub-arrays/partitions

             ? PHASE 2: merging

                 MERGING = sorting elements/pivotIndex in respective 1-element array that are starting from bottom-to-up in-place

                 handle left side first, then right side

                     merge all sibling arrays on left & right side before proceeding to higher level to recursively merge resulting sibling arrays

                     after correct index for pivotIndex element has been FOUND after each traversal, re-assign pivotIndex for subsequent sub-arrays/partitions
     */

    public static void runAlgorithm() {

        prepareData(QUICK_SORT, intArray);

        quickSort(intArray, 0, intArray.length);

        printResults(intArray, true);
    }

    private static void quickSort(int[] inputArray, int start, int end) {

        // ! RECURSION: an algorithm calls itself & each call waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        // 1-element arrays are sorted and don't require a recursive call
        boolean isBaseCase = (end - start) < 2;

        if(isBaseCase) {
            return;
        }

        // ? QUICK SORT: use pivotIndex to move smaller elements left & larger elements right
        int pivotIndex = partition(inputArray, start, end);

        // * STEP 2: use recursion to subsequently partition the left & right partitioned arrays into more sub-arrays using the pivotIndex
        // ! RECURSION + DIVIDE & CONQUER: partition LEFT side FIRST, THEN RIGHT side with midpoint via start & end sub-array
        // LEFT partition
        quickSort(inputArray, start, pivotIndex);

        // RIGHT partition
        quickSort(inputArray, pivotIndex + 1, end);
    }

    private static int partition(int[] inputArray, int start, int end) {
        // use first element in the inputArray OR sub-array as the pivot
        int pivot = inputArray[start];

        i = start; // * traverse from left to right
        j = end; // * traverse from right to left

        // define partitions by ensuring no crossover between traversing index
        while(i < j) {

            // ? QUICK SORT in-place: alternate between traversing right-to-left & left-to-right & shift relative to pivot

            // ! LEFT PARTITIONS
            // decrement j to traverse array right-to-left for an element less than the pivot
            while(i < j && inputArray[--j] >= pivot);

            // * stop traversal when i and j cross each other to maintain partitions
            // if i > j, the indices have crossed
            if(i < j) {

                // * FOUND 1st element less than pivot during traversal of respective partition: so move element at index j to index i (move to LEFT of pivotIndex)
                inputArray[i] = inputArray[j];
            }

            // ! RIGHT PARTITIONS
            // decrement i before execution to traverse array left-to-right for an element greater than the pivot
            while(i < j && inputArray[++i] <= pivot);

            // ensure partition limits
            if(i < j) {

                // * FOUND 1st element greater than pivot during traversal of respective partition: so move element at index i to index j (move to RIGHT of pivotIndex)
                inputArray[j] = inputArray[i];
            }
        }

        // * index j will become the new pivotIndex for subsequent sub-arrays/partitions
        inputArray[j] = pivot;
        return j;
    }
}

class CountingSort extends AlgorithmNotes {
    /*

         ! Big(O) TIME COMPLEXITY: the worst case scenario for the number of steps in an algorithm's execution
              * CONSTANT TIME COMPLEXITY - O(n)

                  counting array uses constant time complexity because we're making assumptions about the data we're sorting

         ! SPACE COMPLEXITY:

              NOT in-place algorithm
                 creates temporary counting array for incrementing frequency of value for sorting

         ! UNSTABLE ALGORITHM:

              if there are duplicate elements, no guarantee that their original order will be preserved,
                 since quick sort is predicated on moving elements around a pivotIndex for recursive partitions

         ! COUNTING SORT LOGIC:

             * ONLY USE counting sort when one can assume dataset size AND known range of values not too large

             counting sort makes assumptions about the elements it is sorting

             counting sort does NOT use comparisons
             instead, it counts the number of occurrences of each value
                 thus, counting sort only works with non-negative discrete values (positive whole numbers in a specific range)

             ? PHASE 1: traverse input array and count frequency of each value in a separate array

                 initialize default separate counting array that matches the discrete total number of possible values/elements of the traversal input array

                 traverse the input array from left to right

                 use the counting array to track (via incrementation) how many of each value are in the input array
                     for each inputArray element, count frequency of each value by incrementing the element's respective index in countingArray by 1

                     ex:

                         inputArray = [2, 5, 9, 8, 2, 8, 7, 10, 4, 3]

                     i = starts at 0 for input array, but first element in the counting array is the minValue

                         initializedCountingArray = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

                     on traversal, each 0 is incremented by 1 for each respective value found in the inputArray

                         incrementedCountingArray = [0, 2, 1, 1, 1, 0, 1, 2, 1, 1]

             ? PHASE 2: use countingArray to update values back into inputArray in sorted order

                 traverse the counts in the counting array, write the values in sorted order back into to the input array

                         incrementedCountingArray = [0, 2, 1, 1, 1, 0, 1, 2, 1, 1]

                         example: the incrementedCountingArray states there are two 2's,
                                     so we start the first two elements in the inputArray become two 2's

                         inputArray = [2, 2, 3, 4, 5, 7, 8, 8, 9, 10]
     */

    public static void runAlgorithm() {

        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        prepareData(COUNTING_SORT, intArray);

        // ? COUNTING SORT discrete: assumes knowing range of values inclusively within MIN - MAX
        countingSort(intArray, 1, 10);

        printResults(intArray, true);
    }

    private static void countingSort(int[] inputArray, int min, int max) {

        // ? COUNTING SORT discrete: assumes knowing range of values inclusively within MIN - MAX
        //      ex) 10-1 inclusive = max(10) - min(1) + 1 = 10
        int discreteLength = max - min + 1;
        int[] countingArray = new int[discreteLength];

        // ? COUNTING SORT: build countingArray by traversing through each element in the inputArray
        for(int i = 0; i < inputArray.length; i++) {

            /*
                ? COUNTING SORT: for each element, identify the element's respective index in countArray

                ex)
                    i = 5;
                    5 - min(1);
                    countIndex = 4;
             */
            int countIndex = inputArray[i] - min;

            // ? COUNTING SORT: increment inputElement in countArray at respective index
            countingArray[countIndex]++;
        }

        // inputArray index
        int j = 0;

        // ? COUNTING SORT: write elements back into inputArray in sorted order via countingArray tally
        // ! first iteration = 1
        for(int i = min; i <= max; i++) {

            int currentTallyIndex = i - min;

            // while countingArray currentElement (value tally) > 0
            while(countingArray[currentTallyIndex] > 0) {

                // keep writing countingArray currentElement to the inputArray
                int inputIndex = j++;
                inputArray[inputIndex] = i;

                // decrement tally since instance of that value has already been written back into inputArray
                countingArray[currentTallyIndex]--;
            }
        }
    }
}

class RadixStableSort extends AlgorithmNotes {
    /*
        ! Big(O) Notation / O(n): independent of hardware, an algorithm's TIME COMPLEXITY relative to the number of processed items

             * CONSTANT TIME COMPLEXITY - O(n)

                 radix sort array uses constant time complexity because we're making assumptions about the data we're sorting: must be integers or Strings
                 
             often runs slower than O(nlogn) algorithms because of the overhead involved
             
         ! SPACE COMPLEXITY:
         
             in-place algorithm that doesn't use extra memory
                 * depending on algorithm used
                 
         ! STABLE ALGORITHM:
         
            if there are duplicate elements, the original order of these elements will be preserved
                because only swap if element at index_i > (index_i + 1)
                
                radix sort = stable counting sort
                
         ! RADIX SORT LOGIC:

            ! MUST use STABLE SORT algorithm
         
            ? RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)

                calls itself until reaching a base case and then feeds return values to itself to solve backwards

                * radix stable sort assumes data (consisting of only integers || Strings) has the same radix and width

                sort is based on each element index that starts to the right most index
         
                * radix = number of all possibly shared characters in a numbering system

                    ex: english alphabet has a radix is 26 because there are 26 letters in the english alphabet

                * width = length of value

                    ex: integer 1234 has a width of 4

            ? RECURSIVE PHASES: must use stable algorithm entire time

                    ex: integer that have width of 4 (4-digit integers/ integers with 4 indices)

                        radixSortArray = {4725, 4586, 1330, 8792, 1594, 5729};

                first, sort array based on 1's position (the farthest index to the right in element value)

                        radixSortArray = {1330, 8792, 1594, 4725, 4586, 5729};

                second, sort array based on 10's position (the second-farthest index to the right in element value)

                        radixSortArray = {4725, 5729, 1330, 4586, 8792, 1594};

                third, sort array based on 100's position (the third-farthest index to the right)

                        radixSortArray = {1330, 4586, 1594, 4725, 5729, 8792};

                final sort(for this example), sort array based on 1000's position (the fourth-farthest index to the right in element value)

                        radixSortArray = {1330, 1594, 4586, 4725, 5729, 8792};
     */

    public static void runAlgorithm() {

        // ? RADIX STABLE SORT: assumes data (consisting of only integers || Strings) has the same radix (shared set of characters) and width (element length)
        int[] intArray = {4725, 4586, 1330, 8792, 1594, 5729};

        // radix: 10 because digits at the given index in an element can only be from 0-9 inclusive in an integer
        int radix = 10;

        // width: each element in the array has 4 indices
        int width = 4;

        System.out.println(RADIX_STABLE_SORT);
        printResults(intArray, false);

        // ? RADIX STABLE SORT: for each index in the element's width in the given input array, sort
        for(int i = 0; i < width; i++) {
            singleRadixStableSort(intArray, i, radix);
        }

        printResults(intArray, true);
    }

    private static void singleRadixStableSort(int[] intArray, int currentIndexInElement, int radix) {
        int numItems = intArray.length;
        int[] countArray = new int[radix]; // radix of 10 = integers 0-9

        // ? STEP 1: getRawCount
        // for each element in the input array, count how many elements have a SPECIFIC character at the current indexInElement
        for(int element: intArray) {
            countArray[getRadixCharacterAtIndex(element, currentIndexInElement, radix)]++;
        }

        // ? STEP 2: adjust counts
        // sum indices to adjust the count array to get numberOfElements that have digit at given indexInElement instead of raw tally
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        // ? STEP 3: using count, write values into tempArray in sorted order
        int[] tempArraySortedCopy = new int[numItems];

        // right-to-left array to maintain STABLE algorithm
        for(int k = (numItems - 1); k >= 0; k--) {
            /*
                --array[i] = decrement value at index before it is used
                array[i]-- = decrement value at index after it is used
             */
            int element = intArray[k];
            int character = getRadixCharacterAtIndex(element, currentIndexInElement, radix);
            int decrementBeforeElement = --countArray[character];
            tempArraySortedCopy[decrementBeforeElement] = intArray[k];
        }

        // ? STEP 4: copy sorted elements back into inputArray
        for(int i = 0; i < numItems; i++) {
            intArray[i] = tempArraySortedCopy[i];
        }
    }

    private static int getRadixCharacterAtIndex(int element, int currentIndex, int radix) {
        /*
            Math.pow(10, index) takes the index and raises it to the index parameter

                * ex: integer 4725

                        Math.pow(10, 0) = 10^0 = 1
                        element = 4725

                    4725 / 1 = 4725

                        radix = 10

                    4725 % 10 = (4725 / 10) = 472 with remainder 5

                    ! return the remainder/currentIndexInElement (starting farthest to the right)
         */
        return element / (int) Math.pow(radix, currentIndex) % radix;
    }

}