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
                insertion sort partition grows the sorted partition from left-to-right
                    but the sorted partition compares elements right-to-left by looking for a value that is less than or equal to the inserted value

                NOTE: no swapping, we shift

                insertion sort starts with
                    sorted partition of 1 element array index 0
                    unsorted partition starting at index 1

                each iteration takes 1 element from unsorted partition insert it into the sorted partition
                after the comparison, the sorted partition is grown by 1 and the index in the unsorted partition is incremented by 1
                if the comparison finds a larger value in the sorted partition,
                you shift the larger value to the right until you arrive at the beginning of the sorted partition

                NOTE: each loop corresponds to n in Big-O notation, thus O(n^2)
         */

        int[] insertionArray = {20, 35, -15, 7, 55, 1, -22};
        int unsortedCompValue = 0;
        int i = 0;

        printResults(insertionArray);

        // outer loop is growing the sorted partition by 1
        for(int unsortedIndex = 1; unsortedIndex < insertionArray.length; unsortedIndex++) {
            unsortedCompValue = insertionArray[unsortedIndex];

            // inner loop looking for correct position to insert each element
            for(i = unsortedIndex; i > 0 && insertionArray[i-1] > unsortedCompValue; i--) {

                // shift left-to-right sorted partition value to the right because the sorted value is greater than the unsorted comp value
                insertionArray[i] = insertionArray[i-1];

            }

            // by the end, entire array is the sorted partition
            insertionArray[i] = unsortedCompValue;
        }

        printResults(insertionArray);
    }
}
