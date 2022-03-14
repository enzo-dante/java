package crownhounds.learnjava;

public class Algorithms {

    private static void printResults(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("---------");
    }

    public static void swapValues(int[] array, int i, int j) {

        if(i == j) {
            return;
        }

        int tempArray = array[i];
        array[i] = array[j];
        array[j] = tempArray;
    }

    public static void bubbleSort() {
        /*
            in-place algorithm that doesn't use extra memory
            stable algorithm: if there are duplicate elements, the original order of these elements will be preserved
                bc only swap if element at index_i > (index_i + 1)

            bubble sort with O(N^2) breaks the array into 2 partitions: sorted and unsorted
                bubble the largest element to the top/unsorted partition that grows with each loop

                NOTE: each loop corresponds to n in Big-O notation, thus O(n^2)
         */

        System.out.println("BUBBLE SORT with O(n^2)" +
                "\n\tbreaks the array into 2 partitions: sorted and unsorted" +
                "\n\tbubble the largest element to the top which grows the sorted partition with each loop right-to-left" +
                "\n\tNOTE: each loop corresponds to n in Big-O notation, thus O(n^2)");

        // in java, use {} to create new array with values
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        printResults(intArray);

        // sorted partition
        for(int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            // unsorted partition
            for(int i = 0; i < lastUnsortedIndex; i++) {

                int j = i + 1;

                // right-to-left sorted partition growth
                if(intArray[i] > intArray[j]) {
                    swapValues(intArray, i, j);
                }
            }
        }

        printResults(intArray);
    }

    public static void selectionSort() {
        /*
            in-place algorithm that doesn't use extra memory
            unstable algorithm: if there are duplicate elements, no guarantee that their original order will be preserved

            selection sort with O(N^2) breaks the array into 2 partitions:

                sorted and unsorted
                    unsorted partition shrinks from left to right

                selection sort looks for the largest element in the unsorted partition
                    the entire array starts as unsorted
                    swap the largest element found with last element in the unsorted partition via respective index
                    then decrement the lastUnsortedIndex var by 1 and repeat the process

                NOTE: each loop corresponds to n in Big-O notation, thus O(n^2)
         */

        System.out.println("SELECTION SORT with O(n^2)" +
                "\n\tbreaks the array into 2 partitions: " +
                "\n\t\tsorted and unsorted (the entire array starts as unsorted)" +
                "\n\tselection sort looks for the largest element in the unsorted partition " +
                "\n\tselect the largest element found and swap it with last element in the unsorted partition via respective index " +
                "\n\tthen decrement the lastUnsortedIndex var by 1 and repeat the process " +

                "\nNOTE: each loop corresponds to n in Big-O notation, thus O(n^2)\n");


        // in java use {} to define array with elements
        int[] selectionSortArray = {20, 35, -15, 7, 55, 1, -22};

        // last index in the given iteration of the unsorted array (array starts as unsorted)
        int lastSortedIndex = selectionSortArray.length - 1;

        // largest value in the given iteration of the unsorted array
        int currentLargestIndex = 0;

        printResults(selectionSortArray);

        // unsorted partition
        for(int i = 0; i <= lastSortedIndex; i++) {

            if(i == lastSortedIndex) {

                if(selectionSortArray[currentLargestIndex] < selectionSortArray[lastSortedIndex]) {
                    currentLargestIndex = lastSortedIndex;
                }

                // swap largest element with element at the end of the unsorted partition
                swapValues(selectionSortArray, currentLargestIndex, lastSortedIndex);

                // decrement length of unsorted partition/increment length of sorted partition
                // recursion
                i = 0;
                currentLargestIndex = 0;
                lastSortedIndex--;

            } else {

                if(selectionSortArray[currentLargestIndex] < selectionSortArray[i]) {
                    currentLargestIndex = i;
                }
            }
        }

        printResults(selectionSortArray);
    }

    public static void insertionSort() {
        /*
             in-place algorithm that doesn't use extra memory

            stable algorithm: if there are duplicate elements, the original order of these elements will be preserved
                bc the search for insertion value position stops when you find a sorted value that is less than or equal

            insertion sort with O(N^2) breaks the array into 2 partitions:
                sorted and unsorted
                NOTE: each loop corresponds to n in Big-O notation, thus O(n^2)

                NOTE: no swapping, we shift
                NOTE: the inserting work is done in the SORTED partition

                insertion sort starts with
                    sorted partition of 1 element array index 0
                    unsorted partition starting at index 1

                on 1st iteration, take first element in the unsorted partition (index 1), save it, and then "insert" it into the sorted partition
                    by comparing if it is greater than or equal to the value in the sorted partition
                    if sorted partition value is less than or equal to the unsorted inserting value, than the inserting value is inserted at the index above the sorted partition value
                    if the sorted partition value is greater than the unsorted inserting value, than you shift the sorted partition value up 1 and then compare unsorted inserting value to the next decremented index value
                    you repeat this process until you find the correct index for the unsorted inserting value or you reach the beginning of the array, index 0
                after the comparison(s) & inserting of the unsorted inserting value, the sorted partition is grown by 1 and the index in the unsorted partition is incremented by 1
                repeat this process until the entire array is sorted
         */

        System.out.println("on 1st iteration, take first element in the unsorted partition (index 1), save it, and then insert it into the sorted partition\n" +
                "                    by comparing if it is greater than or equal to the value in the sorted partition\n" +
                "                    if sorted partition value is less than or equal to the unsorted inserting value, than the inserting value is inserted at the index above the sorted partition value\n" +
                "                    if the sorted partition value is greater than the unsorted inserting value, than you shift the sorted partition value up 1 and then compare unsorted inserting value to the next decremented index value\n" +
                "                    you repeat this process until you find the correct index for the unsorted inserting value or you reach the beginning of the array, index 0\n" +
                "                after the comparison(s) & inserting of the unsorted inserting value, the sorted partition is grown by 1 and the index in the unsorted partition is incremented by 1\n" +
                "                repeat this process until the entire array is sorted" +
                "\nNOTE: each loop corresponds to n in Big-O notation, thus O(n^2)\n");

        int[] insertionArray = {20, 35, -15, 7, 55, 1, -22};
        int unsortedInsertingValue = 0;

        printResults(insertionArray);

        // unsorted partition
        for(int unsortedIndex = 1; unsortedIndex < insertionArray.length; unsortedIndex++) {

            // save unsorted inserting value
            unsortedInsertingValue = insertionArray[unsortedIndex];

            // sorted partition
            for(int sortedIndex = unsortedIndex - 1; sortedIndex >= 0; sortedIndex--) {

                if(unsortedInsertingValue <= insertionArray[sortedIndex]) {
                    // shift up sorted value
                    insertionArray[sortedIndex + 1] = insertionArray[sortedIndex];
                    // shift down unsorted value
                    insertionArray[sortedIndex] = unsortedInsertingValue;
                }
            }
        }

        printResults(insertionArray);
    }

    public static void shellSort() {
         /*
            in-place algorithm that doesn't use extra memory

            unstable algorithm: if there are duplicate elements, the original order of these elements will NOT always be preserved


            gap value influences time complexity

            Shell sort is a variation of insertion sort
                if majority array is mostly in correct order, no need to shift every element like insertion sort

                the goal of shell sort:
                    continuously reduce the gap value of shifting by
                        starting with a larger gap value than 1 (insertion sort uses a gap of 1)

                    do preliminary work by starting with large gap value
                    when the gap value is 1 (the last iteration),
                    the array has been partially sorted and no longer requires extensive shifting,
                    then insertion sort is applied

            Gap Value Strategy #1:

                 gap value is calculated using:

                    array.length / 2

                 each iteration, we will divide the gap value by 2 to get the next gap value

                 for our array, the gap will be initialized to 3

                    [20,35,-15,7,55,1,-22]

                 on the next iteration, it will be 1 - insertion sort

            Gap Value Strategy #2: Knuth Sequence

                gap value is calculated using:

                    (3^k - 1) / 2

                k = length of the array
                    we want the gap value to be as close to the length of array to be sorted without being greater than the length
         */

        System.out.println("SHELL SORT with O(n^2)" +
                "\n\tbreaks the array into 2 partitions: " +
                "\n\t\tsorted and unsorted (the entire array starts as unsorted)" +
                "\n\tselection sort looks for the largest element in the unsorted partition " +
                "\n\tselect the largest element found and swap it with last element in the unsorted partition via respective index " +
                "\n\tthen decrement the lastUnsortedIndex var by 1 and repeat the process " +

                "\nNOTE: each loop corresponds to n in Big-O notation, thus O(n^2)\n");


        int[] shellSortArray = {20,35,-15,7,55,1,-22};

        int gapValue = 3;
        int comparedValue = 0;
        int insertingElement = 0;

    }
}
