package crownhounds.learnjava;

/**
 * Please refer to BigO class
 */
public class Algorithms {

    private static final String PRE_IMPLEMENTATION_RESULTS = "\tPRE_IMPLEMENTATION_RESULTS: ";
    private static final String POST_IMPLEMENTATION_RESULTS = "\tPOST_IMPLEMENTATION_RESULTS: ";

    private static void printResults(int[] arr, boolean isImplemented) {

        if(!isImplemented) {
            System.out.println(PRE_IMPLEMENTATION_RESULTS);
        } else {
            System.out.println(POST_IMPLEMENTATION_RESULTS);
        }

        // enhanced for loop
        for (int j : arr) {
            System.out.println(j);
        }

        // standard for loop
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        if(isImplemented) System.out.println("---------");
    }

    /**
     * swap the element values at index i and index j in the given array
     */
    public static void swapValues(int[] array, int i, int j) {

        if(i == j) {
            return;
        }

        int tempArray = array[i];
        array[i] = array[j];
        array[j] = tempArray;
    }

    public static void bubbleSort() {

        System.out.println("""
                
                TIME COMPLEXITY:
                
                    each loop corresponds to n in Big-O notation, thus O(n^2)
                
                SPACE COMPLEXITY:
                
                    in-place algorithm that doesn't use extra memory

                STABLE ALGORITHM:
                
                    if there are duplicate elements, the original order of these elements will be preserved
                        because only swap if element at index_i > (index_i + 1)

                LOGIC:
                
                    bubble sort breaks the array into 2 partitions:

                        sorted and unsorted
                            bubble the largest element to the top/unsorted partition that grows with each loop

                IMPLEMENTATION:
                """);

        // in java, use {} to create new array with values
        int[] bubbleSortArray = {20, 35, -15, 7, 55, 1, -22};

        printResults(bubbleSortArray, false);

        // sorted partition
        for(int lastUnsortedIndex = bubbleSortArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            // unsorted partition
            for(int i = 0; i < lastUnsortedIndex; i++) {

                int j = i + 1;

                // right-to-left sorted partition growth
                if(bubbleSortArray[i] > bubbleSortArray[j]) {
                    swapValues(bubbleSortArray, i, j);
                }
            }
        }

        printResults(bubbleSortArray, true);
    }

    public static void selectionSort() {

        System.out.println("""
                
                TIME COMPLEXITY:
                
                    each loop corresponds to n in Big-O notation, thus O(n^2)
                
                SPACE COMPLEXITY:
                
                    in-place algorithm that doesn't use extra memory

                UNSTABLE ALGORITHM:
                
                    if there are duplicate elements, no guarantee that their original order will be preserved

                LOGIC:
                
                    selection sort breaks the array into 2 partitions:

                        sorted and unsorted
                            the unsorted partition shrinks from left to right

                    selection sort looks for the largest element in the unsorted partition
                        the entire array starts as unsorted
                        swap the largest element found with last element in the unsorted partition via respective index
                        then decrement the lastUnsortedIndex var by 1 and repeat the process
                        
                IMPLEMENTATION:
                """);

        // in java use {} to define array with elements
        int[] selectionSortArray = {20, 35, -15, 7, 55, 1, -22};

        // last index in the given iteration of the unsorted partition (array starts as unsorted)
        // ! [[unsortedPartition][]] -> [[unsortedPartition][sortedPartition]]
        int lastUnsortedIndex = selectionSortArray.length - 1;

        // largest value in the given iteration of the unsorted array
        int currentLargestIndex = 0;

        printResults(selectionSortArray, false);

        // unsorted partition
        for(int i = 0; i <= lastUnsortedIndex; i++) {

            if(i == lastUnsortedIndex) {

                if(selectionSortArray[currentLargestIndex] < selectionSortArray[lastUnsortedIndex]) {
                    currentLargestIndex = lastUnsortedIndex;
                }

                // swap the largest element with element at the end of the unsorted partition
                swapValues(selectionSortArray, currentLargestIndex, lastUnsortedIndex);

                // decrement length of unsorted partition/increment length of sorted partition
                // reset largest element traversal in unsortedPartition
                i = 0;
                currentLargestIndex = 0;
                lastUnsortedIndex--;

            } else {

                // traverse array and track index with the largest element
                if(selectionSortArray[currentLargestIndex] < selectionSortArray[i]) {
                    currentLargestIndex = i;
                }
            }
        }

        printResults(selectionSortArray, true);
    }

    public static void insertionSort() {

        System.out.println("""
                
                TIME COMPLEXITY:
                
                    each loop corresponds to n in Big-O notation, thus O(n^2)
                
                SPACE COMPLEXITY:
                
                    in-place algorithm that doesn't use extra memory

                STABLE ALGORITHM:
                
                    if there are duplicate elements, the original order of these elements will be preserved
                        because the search for insertion value position stops when you find a sorted value that is less than or equal

                LOGIC:
                    insertion sort breaks the array into 2 partitions:

                        sorted and unsorted
                        
                            sorted partition of 1 element array index 0
                                the inserting work is done in the SORTED partition where there is no swapping, the elements shift
                                
                            unsorted partition starting at index 1
 
                    on 1st iteration, take first element in the unsorted partition (index 1),
                    save it, and then "insert" it into the sorted partition

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
                        
                IMPLEMENTATION:
                """);

        int[] insertionSortArray = {20, 35, -15, 7, 55, 1, -22};
        int newElement;

        printResults(insertionSortArray, false);

        // outer for loop is growing sorted partition by 1
        // index 0 is in sorted partition; index 1 will be 1st element in unsorted partition
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < insertionSortArray.length; firstUnsortedIndex++) {

            // save unsorted inserting value since shifting of elements might cause overwritten value
            newElement = insertionSortArray[firstUnsortedIndex];

            // declare i for post-loop use
            int i;

            // inner for loop that traverses left-sorted partition and searches for correct index to insert newElement
            // continue search until loop has reached beginning of partition AND sortedElement is greater than newElement
            for(i = firstUnsortedIndex; i > 0 && insertionSortArray[i - 1] > newElement; i--) {
                // shift left-to-right currentSortedElement up to make room for newElement
                insertionSortArray[i] = insertionSortArray[i - 1];
            }

            // assign newElement to the searched correct index in sorted partition
            insertionSortArray[i] = newElement;
        }

        printResults(insertionSortArray, true);
    }

    public static void shellSort() {

        System.out.println("""
                
                TIME COMPLEXITY:
                
                    the varying gap value you decide on influences the time complexity
                    
                SPACE COMPLEXITY:
                
                    in-place algorithm that doesn't use extra memory

                UNSTABLE ALGORITHM:
                
                    if there are duplicate elements, the original order of these elements will NOT always be preserved
                    
                SHELL SORT LOGIC:
                
                    1. do preliminary work by starting with large gap value (larger than 1 like insertion sort) that gradually decreases with each iteration
                    
                                if majority array is mostly in correct order, no need to shift every element like insertion sort
                                
                    2. on the last iteration, when the gap value is 1
                    
                    3. the array has been partially sorted and no longer requires extensive shifting,
                    
                    4. then insertion sort is applied
                
                            shell sort is a VARIATION of insertion sort
                            
                    GAP VALUE STRATEGY #1:
        
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
                            on the next/last iteration, it will be 1 - insertion sort
        
                    GAP VALUE STRATEGY #2: Knuth Sequence
        
                        gap value is calculated using:
        
                            (3^k - 1) / 2
        
                        k = length of the array
                            we want the gap value to be as close to the length of array to be sorted without being greater than the length
                
                INSERTION SORT LOGIC:
                
                    insertion sort breaks the array into 2 partitions:

                        sorted and unsorted
                        
                            sorted partition of 1 element array index 0
                                the inserting work is done in the SORTED partition where there is no swapping, the elements shift
                                
                            unsorted partition starting at index 1
 
                    on 1st iteration, take first element in the unsorted partition (index 1),
                    save it, and then "insert" it into the sorted partition

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
                        
                IMPLEMENTATION:
                """);

        // using gap value strategy #1
        int[] shellSortArray = {20,35,-15,7,55,1,-22};
        int unsortedComparisonValue = 0;
        int sortedIndex = 0;
        int gapValue = shellSortArray.length / 2;

        printResults(shellSortArray, false);

        // unsorted partition
        for(int gapValueIndex = gapValue; gapValueIndex < shellSortArray.length; gapValueIndex++) {

            unsortedComparisonValue = shellSortArray[gapValueIndex];

            if(gapValue > 1) {
                sortedIndex = gapValueIndex - gapValue;

                // sorted partition (first shell sort PRELIMINARY work, then insertion sort)
                if(unsortedComparisonValue < shellSortArray[sortedIndex]) {

                    // if sorted partition value is greater, than swap that sorted partition value with the unsorted partition gap value index
                    swapValues(shellSortArray, sortedIndex, gapValueIndex);

                }

                // once you reach the end of the array, compare the sorted partition value at index 0 against the value at index gap value to complete the preliminary work
                if(gapValueIndex == shellSortArray.length - 1) {

                    // reset for loop to use INSERTION SORT logic
                    if(shellSortArray[0] > shellSortArray[gapValue]) {
                        swapValues(shellSortArray, 0, gapValue);
                    }

                    gapValue = 1;
                    gapValueIndex = 1;
                }
            } else {
                
                // INSERTION SORT on last iteration
                for(sortedIndex = gapValueIndex - 1; sortedIndex >= 0; sortedIndex--) {
                    if(unsortedComparisonValue <= shellSortArray[sortedIndex]) {
                        // shift up sorted value
                        shellSortArray[sortedIndex + 1] = shellSortArray[sortedIndex];
                        // shift down unsorted value
                        shellSortArray[sortedIndex] = unsortedComparisonValue;
                    }
                }
            }
        }

        printResults(shellSortArray, true);
    }

    public static void mergeSort() {

        System.out.println("""
                
                TIME COMPLEXITY:
                
                    O(nlogn) - base 2
                    
                    logarithmic algorithm because repeatedly dividing array in half during splitting
                    
                SPACE COMPLEXITY:
                
                    overall: not in-place
                
                    splitting phase = in-place algorithm that doesn't use extra memory
                        track splitting via indices
                        
                    merge phase = NOT in-place algorithm
                        creates temporary arrays for sorting siblings for merge

                STABLE ALGORITHM:
                
                    if there are duplicate elements, the original order of these elements will be preserved
                        because only swap if element at index_i > (index_i + 1)
                    
                MERGE SORT LOGIC:
                
                    divide & conquer algorithm:
                        splitting base problem into several mini-problems, solving mini-problems, and then merging mini-solutions to solve base problem
                    
                    recursive algorithm:
                        calls itself until reaching a base case and then feeds return values to itself to solve backwards
                    
                    PHASE 1: splitting
                    
                        logical splitting (in-place = no new arrays)
                        
                        1. divide the array into two sub-arrays (left & right partition)
                        2. then recursively divide each subsequent array into two arrays
                        3. UNTIL you have multiple sorted arrays of 1 length
                        
                            split left side first, than right side last
                                each split results in 'sibling arrays'
                    
                            EXAMPLE:
                            
                                         [20, 35, -15, 7, 55, 1, -22]
                        
                                [20, 35, -15]       &&            [7, 55, 1, -22]
                        
                            [20]    &&  [35, -15]            [7, 55]    &&      [1, -22]
                        
                                       [35] && [-15]       [7] && [55]        [1] && [-22]
                                       
                    PHASE 2: merging (not in-place)
                    
                        MERGING = sorting elements starting from bottom-to-up with temporary array
                    
                            not in-place: uses new temporary arrays
                        
                        handle left side first, than right side
                        
                            merge all sibling arrays on left & right side before proceeding to higher level to recursively merge resulting sibling arrays
                        
                        STEPS:
                        
                        1. create temp array that can hold all elements in the arrays we're merging
                        
                        2. set i to 1st index of left sibling array
                        
                        3. set j to 1st index of right sibling array
                        
                        4. step through left & right array & get smallest value for temp: compare left[i] to right[j] sibling arrays
                        
                            if left[i] is smaller, copy to temp array and increment i by 1
                            if right[j] is smaller, copy to temp array and increment j by 1
                            
                            repeat until temp array has merged all elements into temp array in sorted order
                        
                        5. copy temp array back into original input array at the correct position (making it a STABLE algorithm)
                        
                        6. repeat steps 4 & 5 until you have sorted original input array
                        
                IMPLEMENTATION:
                """);

        int[] mergeSortArray = {20, 35, -15, 7, 55, 1, -22};

        printResults(mergeSortArray, false);

        printResults(mergeSortArray, true);
    }

    public static void quickSort() {

        System.out.println("""
                
                TIME COMPLEXITY:
                
                    O(nlogn) - base 2
                    
                    logarithmic algorithm because repeatedly dividing array in half during splitting
                    
                SPACE COMPLEXITY:
                
                    in-place algorithm that doesn't use extra memory

                UNSTABLE ALGORITHM:
                
                    if there are duplicate elements, no guarantee that their original order will be preserved,
                        since quick sort is predicated on moving elements around a pivotIndex for recursive partitions
                   
                QUICK SORT LOGIC:
                
                    divide & conquer algorithm:
                        splitting base problem into several mini-problems, solving mini-problems, and then merging mini-solutions to solve base problem
                    
                    recursive algorithm:
                        calls itself until reaching a base case and then feeds return values to itself to solve backwards
                
                    PHASE 1: partitioning step/pivotIndex splitting
                    
                        identify pivotIndex for logical splitting (in-place = no new arrays)
                        
                            each element and it's respective index eventually serves as the pivotIndex
                            
                            CHECK: pivotIndex serves as boundary for 2 sibling sub-arrays that prevent crossover
                        
                        1. divide the array into two sub-arrays (left & right partitions)
                        2. then recursively divide each subsequent array into two arrays
                        3. UNTIL you have multiple sorted arrays of 1 length (each containing the pivotIndex element at it's correct position)
                        
                            in left sub-array, elements less than pivotIndex element are moved to the left during traversal
                            in right sub-array, elements greater than pivotIndex element are moved to the right during traversal
                            
                            AS A RESULT, element at pivotIndex will be in the middle AND in it's correct position
                    
                            EXAMPLE:
                            
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
                                
                                using 1st element and it's respective index in the array as the pivotIndex
                        
                                for left partition, search/traverse from left to right
                                for right partition, search/traverse from right to left
                                stop traversal when i and j cross each other to maintain partitions
                                
                                FOUND 1st element less than pivot during traversal of LEFT partition: so move elements at index j to index i (move to LEFT of pivotIndex)
                                FOUND 1st element greater than pivot during traversal of RIGHT partition: so move elements at index i to index j (move to RIGHT of pivotIndex)
                        
                                after correct index for pivotIndex element has been FOUND after each traversal, re-assign pivotIndex for subsequent sub-arrays/partitions
               
                    PHASE 2: merging
                    
                        MERGING = sorting elements/pivotIndex in respective 1-element array that are starting from bottom-to-up in-place
                        
                        handle left side first, than right side
                        
                            merge all sibling arrays on left & right side before proceeding to higher level to recursively merge resulting sibling arrays
                        
                            after correct index for pivotIndex element has been FOUND after each traversal, re-assign pivotIndex for subsequent sub-arrays/partitions
                                
                IMPLEMENTATION:
                """);

        int[] quickSortArray = {20, 35, -15, 7, 55, 1, -22};

        printResults(quickSortArray, false);

        quickSortRecursion(quickSortArray, 0, quickSortArray.length);

        printResults(quickSortArray, true);
    }

    private static void quickSortRecursion(int[] input, int start, int end) {

        // * BREAK CASE for recursive calls: handle 1 element arrays
        if(end - start < 2) {
            return;
        }

        // * STEP 1: identify pivotIndex for 2-or-more element arrays
        // pivotIndex is the correct position in the sorted array
        int pivotIndex = quickSortPartition(input, start, end);

        // * STEP 2: use recursion to subsequently partition the left & right partitioned arrays into more sub-arrays using the pivotIndex
        quickSortRecursion(input, start, pivotIndex); // recursive left sub-array calls until break on 1-element arrays, subsequently sort
        quickSortRecursion(input, pivotIndex + 1, end); // recursive right sub-array calls until break on 1-element arrays, subsequently sort
    }

    private static int quickSortPartition(int[] input, int start, int end) {

        // * using 1st element of the array as the pivot
        int pivot = input[start];

        int i = start; // * traverse from left to right
        int j = end; // * traverse from right to left

        // * stop traversal when i and j cross each other to maintain partitions
        // if j > i, the indices have crossed
        while(i < j) {

            // ! LEFT PARTITIONS
            // empty loop that simply decrements j / avoid out-of-bounds exception
            while(i < j && input[--j] >= pivot);

            // * FOUND 1st element less than pivot during traversal of respective partition: so move element at index j to index i (move to LEFT of pivotIndex)
            if(i < j) {
                input[i] = input[j];
            }

            // ! RIGHT PARTITIONS
            // empty loop that simply increments i / avoid out-of-bounds exception
            while(i < j && input[++i] <= pivot);

            // * FOUND 1st element greater than pivot during traversal of respective partition: so move element at index i to index j (move to RIGHT of pivotIndex)
            if(i < j) {
                input[j] = input[i];
            }
        }

        // * index j will become the new pivotIndex for subsequent sub-arrays/partitions
        input[j] = pivot;
        return j;
    }


}
