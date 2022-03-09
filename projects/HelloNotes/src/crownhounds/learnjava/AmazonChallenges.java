package crownhounds.learnjava;

import java.util.Arrays;
import java.util.OptionalInt;

public class AmazonChallenges {

    public static final String DIVIDE_AND_CONQUER = "Divide and Conquer";

    public static void arrays() {
        /*
            2D ARRAY EXPLANATION:

            Arrays that we have consider up to now are one dimensional arrays, a single line of elements.
                • You often need a two-dimensional array when data come naturally in the form of:
                    a table, e.g., spreadsheet, which need a two-dimensional array.

            • Example:
                • Movie ratings by multiple reviewers.
                    • Each row is a different reviewer
                    • Each column is a different movie

                    [[4,6,2,5],
                    [7,9,4,8],
                    [6,9,3,7]]

                    rating[0][2] = 2
                        [0] = row
                        [2] = column
         */

        // the minefield is a 2D array
        int[][] mineField = {
                {0,1,0,1},
                {0,1,1,1},
                {0,0,0,0},
                {0,1,0,0}
        };

        int numMineClusters1 = getMineClusterCount(mineField);
        System.out.println("\nNESTED FOR LOOPS total: " + numMineClusters1 + " mine clusters.");

        int[][] mineField2 = {
                {0,1,0,1},
                {0,1,1,1},
                {0,0,0,0},
                {0,1,0,0}
        };

        /*
            divide and conquer algorithm

                break base case into smaller sub problems,
                solve them independently,
                merge solutions to solve base case

         */
        int numMineClusters2 = getMineClusterCount(mineField2, DIVIDE_AND_CONQUER);
        System.out.println("\nDIVIDE & CONQUER total: " + numMineClusters2 + " mine clusters.");
    }

    private static int getMineClusterCount(int[][] array2D) {

        /*
            identify 2 separate mine clusters in a 4x4 grid below
                that uses nested loops and the divide and conquer method
                the method should return 2 since there are 2 separate clusters
                identify the time complexity

            the 4x4 mine grid:
                0 - no mine
                1 - mine

                    [[0,1,0,1],
                    [0,1,1,1],
                    [0,0,0,0],
                    [0,1,0,0]]

         */

        System.out.println("\n\tgetMineClusterCount()\n");

        int numClusters = 0;

        // time complexity of O(n^2) quadratic time complexity given nested for loops
        for(int i = 0; i < array2D.length; i++) {

            for(int column = 0; column < array2D[i].length; column++) {
                int[] row = array2D[i];
                int columnValue = row[column];

                // as soon as you find the first cluster of mines
                if(columnValue == 1) {
                    numClusters++;
                    System.out.println("found a cluster".toUpperCase());
                    array2D = zeroOutMineCluster(array2D, i);
                }
            }
        }

        return numClusters;
    }

    // overloaded method using DIVIDE & CONQUER algorithm
    private static int getMineClusterCount(int[][] array2D, String algorithm) {

        /*
            identify 2 separate mine clusters in a 4x4 grid below
                that uses nested loops and the divide and conquer method
                the method should return 2 since there are 2 separate clusters
                identify the time complexity

            the 4x4 mine grid:
                0 - no mine
                1 - mine

                    [[0,1,0,1],
                    [0,1,1,1],
                    [0,0,0,0],
                    [0,1,0,0]]

            HINT: use a recursive helper function that shows object-oriented programming
            HINT: zero-out
         */

        System.out.println("\n\toverloaded getMineClusterCount()\n");

        int separatorRowCount = 0;
        int separatorRowIndex = 0;
        int[] zeroRow = {0,0,0,0};
        int numMinClusters = 0;

        // iterate over 2D minefield array
        for(int i = 0; i < array2D.length; i++) {

            if (separatorRowCount > 1) {
                System.out.println("EXCEPTION: there were " + separatorRowCount + " separator rows");
                break;
            }

            // find and track the row that separates the 2 mine clusters
            if(Arrays.equals(array2D[i], zeroRow)) {
                separatorRowCount++;
                separatorRowIndex = i;

                OptionalInt beforeRowMax = Arrays.stream(array2D[separatorRowIndex-1]).max();
                OptionalInt afterRowMax = Arrays.stream(array2D[separatorRowIndex+1]).max();

                if((beforeRowMax.getAsInt() > 0) && (afterRowMax.getAsInt() > 0)) {
                    numMinClusters += 2;
                    System.out.println("found 2 clusters using ".toUpperCase() + algorithm.toUpperCase());
                }
            }
        }

        return numMinClusters;
    }

    private static int[][] zeroOutMineCluster(int[][] array2D, int rowIndex) {
        int[] zeroRow = {0,0,0,0};
        int adjacentRowIndex = rowIndex + 1;

        array2D[rowIndex] = zeroRow;

        // validate against out-of-bounds exception
        if(adjacentRowIndex < array2D.length) {
            // since clusters are separate you can zero out the adjacent row
            //      without fear of removing an unaccounted cluster
            array2D[adjacentRowIndex] = zeroRow;
        }

        return array2D;
    }
}