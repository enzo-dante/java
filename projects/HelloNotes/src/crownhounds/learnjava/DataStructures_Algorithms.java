package crownhounds.learnjava;

import java.util.Arrays;

/**
 * Please refer to BigO class
 */
public class DataStructures_Algorithms {

    private static final String PRE_IMPLEMENTATION_RESULTS = "\n\tPRE_IMPLEMENTATION_RESULTS: ";
    private static final String POST_IMPLEMENTATION_RESULTS = "\n\tPOST_IMPLEMENTATION_RESULTS: ";

    private static void printResults(int[] arr, boolean isImplemented) {

        if(!isImplemented) {
            System.out.println(PRE_IMPLEMENTATION_RESULTS);
        } else {
            System.out.println(POST_IMPLEMENTATION_RESULTS);
        }

        System.out.println(Arrays.toString(arr));

        // enhanced for loop
//        for (int j : arr) {
//            System.out.println(j);
//        }

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
                        
                IMPLEMENTATION:""");

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
                        
                IMPLEMENTATION:""");

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
                        
                IMPLEMENTATION:""");

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
                        
                IMPLEMENTATION:""");

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
                                
                IMPLEMENTATION:""");

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

    public static void countingSort() {

        System.out.println("""
                
                TIME COMPLEXITY:
                
                    O(n) - constant time complexity
                    
                        counting array uses constant time complexity because we're making assumptions about the data we're sorting
                    
                SPACE COMPLEXITY:
                
                     NOT in-place algorithm
                        creates temporary counting array for incrementing frequency of value for sorting 

                UNSTABLE ALGORITHM:
                
                     if there are duplicate elements, no guarantee that their original order will be preserved,
                        since quick sort is predicated on moving elements around a pivotIndex for recursive partitions
                   
                COUNTING SORT LOGIC:
                    
                    counting sort makes assumptions about the elements it is sorting
                    
                    counting sort does NOT use comparisons
                    instead, it counts the number of occurrences of each value
                        thus, counting sort only works with non-negative discrete values (positive whole numbers in a specific range)
                
                    PHASE 1: traverse input array and count frequency of each value in a separate array
                    
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
                                
                    PHASE 2: use countingArray to update values back into inputArray in sorted order
                    
                        traverse the counts in the counting array, write the values in sorted order back into to the input array
                    
                                incrementedCountingArray = [0, 2, 1, 1, 1, 0, 1, 2, 1, 1]
                                
                                example: the incrementedCountingArray states there are two 2's,
                                            so we start the first two elements in the inputArray become two 2's
                                
                                inputArray = [2, 2, 3, 4, 5, 7, 8, 8, 9, 10]
                                
                IMPLEMENTATION:""");

        // assume we have non-negative discrete values between 1-10 inclusive
        int[] inputArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        // reasonable range of possible values (not too large of a range and only hold positives values)
        int min = 1;
        int max = 10;

        // * initialize default separate counting array that matches the discrete total number of possible values/elements of the traversal input array
        // for example, 1-10 inclusive (1 = min; 10 = max)
        int[] countingArray = new int[max - min + 1]; // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        printResults(inputArray, false);

        // ! PHASE 1: traverse input array and count frequency of each value in a separate array

        // * traverse inputArray
        for(int i = 0; i < inputArray.length; i++) {

            // * for each inputArray element, count frequency of each value by incrementing the element's respective index in countingArray by 1
            int inputElementCountIndex = inputArray[i] - min;
            countingArray[inputElementCountIndex]++;
        }

        // ! PHASE 2: use countingArray to update values back into inputArray in sorted order

        // j index will be used to write to the input array
        int j = 0;

        // i index will used to traverse the count array
        for(int i = min; i <= max; i++) {

            // * for values that have a greater frequency than 1, continue to write to input array at subsequent indices per frequency
            while(countingArray[i - min] > 0) {
                inputArray[j++] = i;
                countingArray[i-min]--; // decrement frequency of value in countingArray, until 0
            }
        }

        printResults(inputArray, true);
    }

    public static void radixSort() {

        System.out.println("""
                
                TIME COMPLEXITY:
                
                    O(n) - constant time complexity
                    
                        radix sort array uses constant time complexity because we're making assumptions about the data we're sorting: must be integers or Strings
                        
                    often runs slower than O(nlogn) algorithms because of the overhead involved
                    
                SPACE COMPLEXITY:
                
                    in-place algorithm that doesn't use extra memory
                        * depending on algorithm used
                        
                STABLE ALGORITHM:
                
                   if there are duplicate elements, the original order of these elements will be preserved
                       because only swap if element at index_i > (index_i + 1)
                       
                       radix sort = stable counting sort
                       
                RADIX SORT LOGIC:
                
                    recursive algorithm:
                        calls itself until reaching a base case and then feeds return values to itself to solve backwards
 
                    radix sort assumes data (consisting of only integers || Strings) has the same radix and width
                        sort is based on each element index that starts to the rightmost index  
                
                        radix = number of unique values in a numbering system
                        
                            ex: english alphabet has a radix is 26 because there are 26 letters in the english alphabet
                        
                        width = number of characters in the value
                        
                            ex: integer 1234 has a width of 4
                        
                    RECURSIVE PHASES: must use stable algorithm entire time
                    
                            ex: integer that have width of 4 (4-digit integers/ integers with 4 indices)
                                
                                radixSortArray = {4725, 4586, 1330, 8792, 1594, 5729};
                                
                        first, sort array based on 1's position (farthest index to the right in element value)
                        
                                radixSortArray = {1330, 8792, 1594, 4725, 4586, 5729};
                                
                        second, sort array based on 10's position (second farthest index to the right in element value)
                        
                                radixSortArray = {4725, 5729, 1330, 4586, 8792, 1594};
                                
                        third, sort array based on 100's position (third farthest index to the right)
                        
                                radixSortArray = {1330, 4586, 1594, 4725, 5729, 8792};
                                
                        final sort(for this example), sort array based on 1000's position (fourth farthest index to the right in element value)
                        
                                radixSortArray = {1330, 1594, 4586, 4725, 5729, 8792};
                                
                IMPLEMENTATION:""");

        // assume data has the same radix and width
        int[] radixSortArray = {4725, 4586, 1330, 8792, 1594, 5729};
        // each element in the array has 4 indices
        int width = 4;
        // radix is 10 because digits at the given index in an element can only be from 0-9 in an integer
        int radix = 10;

        printResults(radixSortArray, false);

        // for each index in the element's width in the given input array, sort
        for(int i = 0; i < width; i++) {
            radixSingleSort(radixSortArray, i, radix);
        }

        printResults(radixSortArray, true);
    }

    private static void radixSingleSort(int[] input, int currentIndexInElement, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix]; // radix of 10 = integers 0-9

        // STEP 1: getRawCount
        // for each element in the input array, count how many elements have a SPECIFIC character at the current indexInElement
        for(int element: input) {
            countArray[getCharacter(currentIndexInElement, element, radix)]++;
        }

        // STEP 2: adjust counts
        // sum indices to adjust the count array to get numberOfElements that have digit at given indexInElement instead of raw tally
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        // STEP 3: using count, write values into tempArray in sorted order
        // right-to-left array to maintain STABLE algorithm
        int[] tempArraySortedCopy = new int[numItems];

        for(int k = (numItems - 1); k >= 0; k--) {
            /*
                --array[i] = decrement value at index before it is used
                array[i]-- = decrement value at index after it is used
             */
            int character = getCharacter(currentIndexInElement, input[k], radix);
            int decrementBeforeElement = --countArray[character];
            tempArraySortedCopy[decrementBeforeElement] = input[k];
        }

        // STEP 4: copy sorted elements back into inputArray
        for(int k = 0; k < numItems; k++) {
            input[k] = tempArraySortedCopy[k];
        }

    }

    private static int getCharacter(int currentIndexInElement, int element, int radix) {
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

        int characterAtIndex = (element / (int) Math.pow(radix, currentIndexInElement) % radix);
        return characterAtIndex;
    }



}
