package com.crownhounds.challenges;

import com.crownhounds.masterjava.Util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengesMasterUtil {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    public static final String INVALID_INPUT = "Invalid input";
    public static final String INVALID_VALUE = "Invalid Value";
    public static final String ADDED = "Added: ";
    public static final String RESULT = "Result: ";

    public static void main(String[] args) {

        GroceryApp groceryApp = new GroceryApp();
        groceryApp.run();
    }
}

// ! INTERFACE: force a set of classes to implement publicly-shared signatures
interface IChallenge {

    // ! INTERFACE: define publicly-shared signatures without implementation
    void getName();
}

abstract class Challenge implements IChallenge {

    // ENCAPSULATION private class fields
    private String title;

    // constructor that initializes the class fields on class/object instantiation
    // ! ABSTRACT CLASSES cannot be instantiated, need an OOP INHERITANCE child subclass instance to extend it
    public Challenge(String title) {
        this.title = title;
        getName();
    }

    // ! OOP POLYMORPHISM + INHERITANCE
    @Override
    public void getName() {
        Util.printSeparator(this.title);
    }
}

class MergeSortDescending extends ChallengesMasterUtil {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String MERGE_SORT = "Merge Sort Descending";

    // OOP ENCAPSULATION private class fields

    public static int[] execute(int[] input) {

        if(input.length == 0) return null;

        System.out.println(Arrays.toString(input));

        int start = 0;
        int end = input.length;

        // ! RECURSION: an algorithm that calls itself & each call that is placed on the call stack is waiting for a return value until a breaking condition or overflow
        splitting(input, start, end);

        System.out.println(Arrays.toString(input));
        return input;
    }

    /*
        ! DIVIDE & CONQUER

             recursively divide the original problem into 2 or more sub-problems & repeat until the sub-problems become small enough to solve a base case

             after solving the base case/breaking condition, combine the solutions to construct the overall solution to the original problem

         ? PHASE 1: splitting

             logical splitting (in-place = no new arrays)

             1. divide the array into two sub-arrays (left & right partition)
             2. then recursively divide each subsequent array into two arrays
             3. UNTIL you have multiple sorted arrays of 1 length
     */
    private static void splitting(int[] input, int start, int end) {

        /*
            ! RECURSION BASE CASE: the upward propagating return values of an algorithm's that yields stack resolution or overflow
                a partition/array is sorted if length = 1
         */
        int partitionLength = end - start;
        boolean isBaseCase = partitionLength < 2;

        if(isBaseCase) return;

        /*
              ? PHASE 1: splitting

                 logical splitting (in-place = no new arrays)

                 1. divide the array into two sub-arrays (left & right partition)
                 2. then recursively divide each subsequent array into two arrays
                 3. UNTIL you have multiple sorted arrays of 1 length

                     split left side first, then right side last
                         each split results in 'sibling arrays'
         */

        int midpoint = (start + end) / 2;

        // [20, 35, -15, 7, 55, 1, -22]

        // ? LEFT partition + sub-partitions
        // [20, 35, -15] ->
        //      [20] [35, -15] ->
        //          [20] [35] [-15]
        splitting(input, start, midpoint);

        // ? MERGE SORT RIGHT partition + sub-partitions
        // [7, 55, 1, -22] ->
        //      [7, 55] [1,-22] ->
        //          [7] [55] [1] [-22]
        splitting(input, midpoint, end);

        /*
              ? PHASE 2: MERGING (not in-place)

                    sorting elements starting from bottom-to-up with temporary array

                        not in-place: uses new temporary arrays

                    handle left side first, then right side

                        merge all sibling arrays on left & right side before proceeding to higher level to recursively merge resulting sibling arrays
         */
        merging(input, start, midpoint, end);
    }

    /*
        ? PHASE 2: merging (not in-place)

            MERGING = sorting elements bottom-to-up with temporary array

                not in-place: uses new temporary arrays

            handle left side first, then right side

                merge all sibling arrays on left & right side before proceeding to higher level to recursively merge resulting sibling arrays
     */
    private static void merging(int[] input, int start, int midpoint, int end) {

        int leftPartitionEnd = input[midpoint - 1];
        int rightPartitionStart = input[midpoint];
        boolean isSortedPartition = leftPartitionEnd >= rightPartitionStart;

        if(isSortedPartition) return;

        // then, some RIGHT partition elements > some LEFT partition elements
        int i = start;
        int j = midpoint;
        int tempIndex = 0;
        int tempSize = end - start;

        int[] tempPartition = new int[tempSize];

        // i < mp = traverse left partition
        // j < end = traverse right partition
        while(i < midpoint && j < end) {

            int currentLeftElement = input[i];
            int currentRightElement = input[j];

            /*
                ! FOR DESCENDING ORDER:

                traverse through left & right array & get the BIGGEST value for temp: compare left[i] to right[j] sibling arrays

                repeat until temp array has merged all elements into temp array in sorted order

                ! STABLE ALGORITHM:

                if there are duplicate elements, the original order of these elements will be preserved

                    because only swap if element at index_i > (index_i + 1)

             */
            boolean isLeftBigger = currentLeftElement >= currentRightElement;

            if(isLeftBigger) {
                tempPartition[tempIndex++] = input[i++];
            } else {
                tempPartition[tempIndex++] = input[j++];
            }
        }

         /*
            ? MERGE SORT OPTIMIZATION

                LEFT partition remaining elements, must copy to temp array

                RIGHT partition remaining elements, no copying into temp array needed bc already will be in sorted order for input array
         */
        int copyEndIndex = start + tempIndex;
        int copyStartIndex = i;

        // no action, if no remainder left partition elements
        // else move to correct index
        int notCopiedCount = midpoint - i;

        // ? MERGE SORT: copying sorted tempArray elements back into inputArray
        int[] sourceArray = input;
        System.arraycopy(sourceArray, copyStartIndex, input, copyEndIndex, notCopiedCount);

        // ? MERGE SORT: then only copy numElements in tempArray into inputArray
        sourceArray = tempPartition;
        System.arraycopy(sourceArray, 0, input, start, tempIndex);
    }
}

class NumberToWords extends ChallengesMasterUtil{

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation

    // OOP ENCAPSULATION private class fields
    private static Map<Integer, String> nums = new HashMap<>();

    // ! STATIC: single class variable method shared in memory across application
    public static void numberToWords(int number) {

        // ? COLLECTION MAP hashMapInstance.put(key, value) = add key-value pair into map collection
        nums.put(0, "Zero");
        nums.put(1, "One");
        nums.put(2, "Two");
        nums.put(3, "Three");
        nums.put(4, "Four");
        nums.put(5, "Five");
        nums.put(6, "Six");
        nums.put(7, "Seven");
        nums.put(8, "Eight");
        nums.put(9, "Nine");

        if (number >= 0) {
            // reversing the number
            int reversed = reverse(number);
            // counts the number of digits of given number
            int originalNumberDigits = getDigitCount(number);
            // iterates till all digits will be printed
            for (int i = 0; i < originalNumberDigits; i ++) {
                // extracting digit of given number
                int digit = reversed % 10;
                // printing last digit in words
                switch (digit) {
                    case 0:
                        System.out.print(nums.get(0) + " ");
                        break;
                    case 1:
                        System.out.print(nums.get(1) + " ");
                        break;
                    case 2:
                        System.out.print(nums.get(2) + " ");
                        break;
                    case 3:
                        System.out.print(nums.get(3) + " ");
                        break;
                    case 4:
                        System.out.print(nums.get(4) + " ");
                        break;
                    case 5:
                        System.out.print(nums.get(5) + " ");
                        break;
                    case 6:
                        System.out.print(nums.get(6) + " ");
                        break;
                    case 7:
                        System.out.print(nums.get(7) + " ");
                        break;
                    case 8:
                        System.out.print(nums.get(8) + " ");
                        break;
                    case 9:
                        System.out.print(nums.get(9) + " ");
                        break;
                }
                // removing digit from a number
                reversed /= 10;
            }
        } else {
            // prints "Invalid Value" when it is less than zero
            System.out.println(INVALID_VALUE);
        }
        System.out.println();
    }

    /**
     * reverses the given number
     * @param number
     * @return reversed number
     */
    public static int reverse(int number) {
        int reversedNumber = 0;
        int lastDigit = 0;
        while (number != 0) {
            lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            number /= 10;
        }
        return reversedNumber;
    }

    /**
     * counts the number of digits
     * @param number
     * @return number of digits
     */
    public static int getDigitCount(int number) {
        int sumOfDigits = 0;
        if (number >= 0) {
            if (number == 0) {
                sumOfDigits = 1;
            }
            while (number > 0) {
                int lastDigit = number % 10;
                number /= 10;
                sumOfDigits++;
            }
            return sumOfDigits;
        }
        return -1;
    }
}

class AreaCalculator {

    public Double area(double radius) {

        if(radius < 0) {
            return -1D;
        }

        // implied else-statement
        // ! AUTOBOXING: converting primitive dataType to Wrapper Class dataType w/ greater functionality
        return (radius * radius) * Math.PI;
    }

    public Double area(double x, double y) {

        if((x < 0) || (y < 0)) {
            return -1D;
        }

        // ! AUTOBOXING: converting primitive dataType to Wrapper Class dataType w/ greater functionality
        return x * y;
    }
}

/**
 * ? Song & Album for Playlist
 * ! Object-Oriented Programming (OOP): create a class object/blueprint
 */
class PlayList extends Challenge {

    // CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
    private static final String NO_SONGS = "No songs in playlist";
    private static final String SONG_REMOVED = " - song in playlist has been removed";
    private static final String NOW_PLAYING = "Now playing: ";
    private static final String NOW_REPLAYING = "Now replaying: ";
    private static final String PLAYLIST_COMPLETE = "PlayList complete";
    private static final String PLAYLIST_BEGINNING = "PlayList beginning";
    private static final String SELECT_OPTION = "\nSelection: ";
    private static final String PLAYLIST_MENU = "\n\tPlayList Menu\n".toUpperCase() +
            "0 - quit\n" +
            "1 - to play next song\n" +
            "2 - to play previous song\n" +
            "3 - to replay current song\n" +
            "4 - list songs in the playlist\n" +
            "5 - print available actions\n" +
            "6 - delete current song from playList";

    // ENCAPSULATION private class fields

    // OOP constructor that initialize the class fields on class/object instantiation
    public PlayList() {
        super("PlayList Challenge");
    }

    // ! STATIC: methods or variables associated with the class blueprint and not any individual instance and saved in a single place in memory
    // ! GENERIC CLASS: improve ENCAPSULATION by enforcing specific dataType parameters
    public static void play(LinkedList<Song> playList) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean isForward = true;

        // ? define listIterator for navigating linkedList
        ListIterator<Song> songListIterator = playList.listIterator();

        if(playList.size() <= 0) {
            System.out.println(NO_SONGS);
            return;
        } else {
            // ? iterate to first node (currentValue, nextValuePointer)
            // ? .next() returns a Song object, so implement toString() for Song data
            System.out.println(
                    NOW_PLAYING + songListIterator.next().toString()
            );
        }

        printMenu();

        while(!quit) {

            System.out.println(SELECT_OPTION);

            if(scanner.hasNextInt()) {

                int choice = scanner.nextInt();

                // handle 'enter' keydown to proceed with captured user input
                scanner.nextLine();

                switch(choice) {
                    case 0:
                        System.out.println(PLAYLIST_COMPLETE);
                        quit = true;
                        break;

                    case 1: // move forward

                        // handle direction
                        // if direction not going forward, set direction to go forward as preparation to move to next node
                        if(!isForward) {
                            // validate linkedList current pointer is not null/end before moving to next node
                            if(songListIterator.hasNext()){
                                songListIterator.next();
                            }
                            isForward = true;
                        }

                        // move to next node in linkedList
                        if(songListIterator.hasNext()) {
                            System.out.println(
                                    NOW_PLAYING + songListIterator.next().toString()
                            );
                        } else {
                            System.out.println(PLAYLIST_COMPLETE);
                            isForward = false;
                        }
                        break;

                    case 2: // move backward

                        // handle direction
                        // if direction is not going backward, set direction to go backward as preparation to move to previous node
                        if(isForward) {
                            // validate linkedList currentPointer is not null/beginning before moving to previous node
                            if(songListIterator.hasPrevious()) {
                                songListIterator.previous();
                            }
                            isForward = false;
                        }

                        // move to previous node in linkedList
                        if(songListIterator.hasPrevious()) {
                            System.out.println(
                                    NOW_PLAYING + songListIterator.previous().toString()
                            );
                        } else {
                            System.out.println(PLAYLIST_BEGINNING);
                            isForward = true;
                        }
                        break;

                    case 3: // repeat

                        // handle direction
                        // if currently moving forward, validate previous record & show record if valid node
                        if(isForward) {

                            if(songListIterator.hasPrevious()) {
                                System.out.println(
                                        NOW_REPLAYING + songListIterator.previous().toString()
                                );

                            } else {
                                System.out.println(PLAYLIST_BEGINNING);
                            }
                            isForward = false;

                        } else if(!isForward) {
                            // if currently moving backward, validate next record & show record if valid node
                        } else if(!isForward) {
                            if(songListIterator.hasNext()) {
                                System.out.println(
                                        NOW_REPLAYING + songListIterator.next().toString()
                                );
                            } else {
                                System.out.println(PLAYLIST_COMPLETE);
                            }
                            isForward = true;
                        }
                        break;
                    case 4:
                        printList(playList);
                        break;
                    case 5:
                        printMenu();
                        break;
                    case 6: // delete current song from playList
                        // given ability to remove records, validate that there are records in linkedList
                        if(playList.size() > 0) {

                            if(isForward) {
                                System.out.println(songListIterator.previous().toString() + SONG_REMOVED);
                            } else {
                                System.out.println(songListIterator.next().toString() + SONG_REMOVED);
                            }

                            // ? each time you delete a record, MUST call .next() or .previous() to handle repeat error
                            songListIterator.remove();

                            // handle mandatory .next() or .previous()
                            if(songListIterator.hasNext()) {
                                System.out.println(
                                        NOW_PLAYING + songListIterator.next().toString()
                                );
                            } else if(songListIterator.hasPrevious()) {
                                System.out.println(
                                        NOW_PLAYING + songListIterator.previous().toString()
                                );
                            }
                        }
                        break;
                }

            } else {
                scanner = new Scanner(System.in);
                System.out.println(ChallengesMasterUtil.INVALID_INPUT);
                printMenu();
            }
        }
    }

    private static void printList(LinkedList<Song> playList) {

        ListIterator<Song> songIterator = playList.listIterator();

        Util.printSeparator();

        while(songIterator.hasNext()) {
            System.out.println(songIterator.next().toString());
        }

        Util.printSeparator();
    }

    private static void printMenu() {

        System.out.println(PLAYLIST_MENU);
    }

    /**
     * ! non-static INNER CLASSES: need a base class instance to execute functionality
     * ! OOP ENCAPSULATION: protect against improper use by limiting with access-modifier
     */
    public class Song {

        // OOP ENCAPSULATION: access modifier private class fields
        private String title;
        private Double duration;

        // OOP constructor that initialize the class fields on class/object instantiation
        public Song(String title, double duration) {
            this.title = title;

            // ! AUTOBOXING: convert primitive dataType -> Wrapper class dataType w/ greater functionality
            this.duration = duration;
        }

        // non-static unique object behaviors/class methods
        // ! OOP POLYMORPHISM: unique implementation of method for this object despite same signature shared by multiple objects via @Override
        @Override
        public String toString() {
            return this.title + ": " + this.duration;
        }

        // OOP getter & setters
        public String getTitle() {
            return title;
        }
    }

    /**
     * ! non-static INNER CLASSES: need a base class instance to execute functionality
     * ! OOP ENCAPSULATION: protect against improper use by limiting with access-modifier
     */
    public class Album {

        // CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
        private static final String NO_ALBUM_TRACK = " album does not have the track number ";
        private static final String NO_ALBUM_TITLE = " album does not have the title ";

        // OOP ENCAPSULATION: access modifier private class fields
        private String name;
        private String artist;
        // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
        private ArrayList<Song> songs;

        // OOP constructor that initialize the class fields on class/object instantiation
        public Album(String name, String artist) {
            this.name = name;
            this.artist = artist;

            // ! GENERICS: improve ENCAPSULATION by only allowing specific dataType parameter classes, interfaces, or methods
            this.songs = new ArrayList<Song>();
        }

        // non-static unique object behaviors/class methods
        public boolean addSong(String title, double duration) {

            // validate that song is not a duplicate
            if(findSong(title) == null) {

                Song newSong = new Song(title, duration);

                this.songs.add(newSong);
                return true;
            }

            // implied else-statement
            return false;

        }

        public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {

            int index = trackNumber - 1; // 0 index start

            if((index >= 0) && (index <= this.songs.size())) {

                Song newSong = this.songs.get(index);
                playlist.add(newSong);
                return true;
            }

            System.out.println(
                    getName() + NO_ALBUM_TRACK + trackNumber
            );
            return false;
        }

        // ! OVERLOADED METHOD: write method with same name, but different parameters to optimize readability & scalability of the codebase
        public boolean addToPlayList(String title, LinkedList<Song> playlist) {

            Song song = findSong(title);

            // validate song is not a duplicate in PlayList
            if(song != null) {
                playlist.add(song);
                return true;
            }

            System.out.println(
                    getName() + NO_ALBUM_TITLE + title
            );
            return false;
        }

        // ! OOP ENCAPSULATION: access modifier private for internal use only
        private Song findSong(String title) {

            // forEach = for(DataType instance in list)
            for(Song song: this.songs) {

                if(song.getTitle().equals(title)) {
                    return song;
                }
            }

            return null;
        }

        // OOP getters & setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

// ! ACCESS-MODIFIER package-private: default private limit visibility to scope of the package and class
class SpeedConverter {

    // CONSTANTS/static class variables assigned FINAL value before class compilation/instantiation
    private static final String INVALID_VALUE = "Invalid value";

    // ! OOP ENCAPSULATION + ACCESS-MODIFIER private: limit scope visibility for intended class use/protection
    // private class fields
    private String format = "XX km/h = YY mi/h";

    public Long toMilesPerHour(double kilometersPerHour) {

        if(kilometersPerHour < 0) {
            return -1L;
        }

        // implied else-statement
        return Math.round((1.609 * kilometersPerHour));
    }

    public void printConversion(double kilometersPerHour) {

        Long result;

        if(kilometersPerHour < 0) {
            System.out.println(INVALID_VALUE);
        } else {
            result = toMilesPerHour(kilometersPerHour);
            String formattedString = format.replace("XX", Double.toString(kilometersPerHour)).replace("YY", Long.toString(result));
            System.out.println(formattedString);
        }
    }
}

class MegaByteConverter {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String INVALID_VALUE = "Invalid Value";

    // OOP ENCAPSULATION private class field
    public static String format = "XX KB = YY MB and ZZ KB";

    public static String printMegaBytesAndKiloBytes(int kiloBytes) {

        if(kiloBytes < 0) {
            return INVALID_VALUE;
        }
        // ! CASTING: converting 1 dataType to another dataType
        // ! AUTOBOXING: casting primitive dataType -> Wrapper class dataType
        Integer megaBytes = kiloBytes / 1024;
        Integer remainder = (kiloBytes % 1024);

        format = format.replace("XX", Integer.toString(kiloBytes));
        format = format.replace("YY", Integer.toString(megaBytes));
        format = format.replace("ZZ", Integer.toString(remainder));

        return format;
    }
}

/**
 * create a for statement using any range of numbers
 * determine if the number is a prime number using the isPrime method
 * if it is a prime number, print it out
 * AND increment the count of the number of prime numbers found
 * if that count is 3: exit the loop
 *
 * HINT: use the break statement to exit
 */

class isPrime {

    public static boolean isPrime() {


        return false;
    }

}

class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if(barking && (hourOfDay >= 0) && (hourOfDay <= 23)) {

            if((hourOfDay < 8) || (hourOfDay > 22)) {
                return true;
            }
        }

        return false;
    }
}

/*
    create a program using arrays that sort a list of integers in descending order (highest-to-lowest)

    capture the values from console based on user input

    * will have to copy array elements from argument into a new array, sort them, and return new sorted array

    methods:
        getIntegers: returns an array
        printArray: print content of array
        sortIntegers: sort array and return a new array containing the sorted numbers
 */

class ArraySorter {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String INPUT_PROMPT = "\nPlease enter a number:\n";

    // OOP ENCAPSULATION private class fields
    private static Scanner scanner;

    private static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static int[] getIntegers() {

        scanner = new Scanner(System.in);
        int[] nums = new int[5];
        int count = 0;

        while(count < nums.length) {

            System.out.println(INPUT_PROMPT);

            // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
            if(scanner.hasNextInt()) {

                int userInput = scanner.nextInt();

                // handle enter key down
                scanner.nextLine();

                nums[count] = userInput;
                count++;

            } else {

                System.out.println(ChallengesMasterUtil.INVALID_INPUT);
                scanner = new Scanner(System.in);
            }
        }
        System.out.println("\nPRE-insertion sort:".toUpperCase());
        printArray(nums);
        scanner.close();
        return nums;
    }

    /**
     * sort array of integers via insertion sort algorithm
     *
     * ! INSERTION SORT: take elements in the unsorted partition (index 1), save it, and then "insert" it into the sorted partition via comp
     *      [[][unsortedPartition]] -> [[sortedPartition][unsortedPartition]]
     *
     * * O(n^2) quadratic time complexity: terrible bc of nested loops
     * * 0(1) constant space complexity: in-place algorithm
     *
     * @param input
     * @return array of sorted integers
     */
    public int[] sortIntegers(int[] input) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(input.length != 5) {
            return null;
        }

        int unsortedInsertElement;
        int sortedIndex;

        for(int unsortedIndex = 1; unsortedIndex < input.length; unsortedIndex++) {

            unsortedInsertElement = input[unsortedIndex];

            // continue to loop backwards the sorted partition
            for(sortedIndex = unsortedIndex;
                // while not at sorted partition beginning AND current sortedElement is greater than insertElement
                sortedIndex > 0 && input[sortedIndex - 1] > unsortedInsertElement;
                sortedIndex--) {

                // shift left-to-right current sortedElement
                input[sortedIndex] = input[sortedIndex - 1];
            }

            // insert unsortedPartition element at correct index in sortedPartition
            input[sortedIndex] = unsortedInsertElement;
        }

        System.out.println("\npost-insertion sort:".toUpperCase());
        printArray(input);
        return input;
    }
}

/*
    write a class MinElement

    write a method called readIntegers with int parameter named 'count'
       count represents number of integers user need to enter
       returns an array containing the numbers the user enters

    write a method called findMin with the user-generated array as a parameter
       returns minimum value in the array

    print the minimum element in the array

    * implementation uses selection sort algorithm
*/
class MinElement {

    // CONSTANTS/static class variables assigned FINAL value before
    private static final String INPUT_PROMPT = "Enter number:\n";

    // OOP ENCAPSULATION private class fields
    Scanner scanner;

    public int[] readIntegers(int count) {

        int[] nums = new int[count];
        scanner = new Scanner(System.in);

        int i = 0;

        while(nums[nums.length - 1] == 0) {

            System.out.println(INPUT_PROMPT);

            if(scanner.hasNextInt()) {
                nums[i++] = scanner.nextInt();
            } else {
                System.out.println(ChallengesMasterUtil.INVALID_INPUT);
                scanner = new Scanner(System.in);
            }
        }
        return nums;
    }

    public int findMin(int[] input) {

        if(input.length == 0) {
            return -1;
        }

        selectionSort(input);
        return input[0];
    }

    private int[] selectionSort(int[] input) {

        // last index in the given iteration of the unsorted partition (array starts as unsorted)
        //      [[unsortedPartition][]] -> [[unsortedPartition][sortedPartition]]
        int lastUnsortedIndex = input.length - 1;

        // largest value in the given iteration of the unsorted array
        int currentLargestIndex = 0;

        // ? UNSORTED partition
        for(int i = 0; i <= lastUnsortedIndex; i++) {

            // traverse array & track index w/ the largest element
            if(i != lastUnsortedIndex) {

                boolean foundLargerValue = input[currentLargestIndex] < input[i];

                if(foundLargerValue) {
                    currentLargestIndex = i;
                }

            } else {

                // when you reach end of unsortedPartition during traversal & found a largerValue than the currentLargestValue
                boolean needToReplaceLargestIndex = input[currentLargestIndex] < input[lastUnsortedIndex];

                if(needToReplaceLargestIndex) {
                    currentLargestIndex = lastUnsortedIndex;
                }

                // ? SORTED partition
                // swap the largest element with element at the end of the unsorted partition
                swap(input, currentLargestIndex, lastUnsortedIndex);

                // reset largest element index for next unsortedPartition traversal
                i = 0;
                currentLargestIndex = 0;

                // decrement length of unsorted partition meaning you are inversely incrementing length of sorted partition
                lastUnsortedIndex--;
            }
        }
        return input;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

/*
create an application that builds a grocery list

use a scanner to capture user input

write CRUD+ methods:
    create a grocery list
    read the grocery list
    update items on the grocery list
    delete items on the grocery list
    that can query the grocery list for specific items
    print instructions
*/
class GroceryApp {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String INVALID_VALUE = "Invalid Value";
    private static final String ADDED_CONFIRMATION = "Added item: ";
    private static final String UPDATED_CONFIRMATION = "Updated grocery list!";
    private static final String GROCERY_LIST = "\nGrocery list\n".toUpperCase();
    private static final String EMPTY_GROCERY_LIST = "There are currently no items on your grocery list";
    public static final String ITEM_NOT_FOUND = "Query for item failed";
    private static final String QUIT = "quit";
    private static final String INSTRUCTIONS = GROCERY_LIST + "0 - print instructions\n" +
            "1 - read grocery list\n" +
            "2 - add item\n" +
            "3 - delete item\n" +
            "4 - update item\n" +
            "5 - " + QUIT;
    private static final String ENTER_CHOICE = "Enter your choice:\n";
    private static final String ENTER_ITEM_NUMBER= "\nEnter item number:\n";
    private static final String ENTER_DELETE_CHOICE = "Enter your choice to be deleted:\n";
    private static final String ADD_NEW_ITEM = "Add new item:\n";
    private static final String ENTER_UPDATE_ITEM = "\nEnter new item for update:\n";
    private static final String SHUTDOWN = "Shutting down now....";
    private static final String RETURN_TO_MAIN = "Returning to main menu";
    private static final String ALREADY_ON_LIST = "Item is already on the list";
    private static final String REGEX_QUIT = "(?i)^quit|^[qQ]$|^(?)-\\d|^\\d";

    private Scanner scanner;

    public void run() {

        scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        boolean quit = false;

        while(!quit) {

            boolean exit = false;

            System.out.println(INSTRUCTIONS);
            System.out.println(ENTER_CHOICE);

            if(scanner.hasNextInt()) {

                int choice = scanner.nextInt();
                boolean notInListRange = choice <= 0 || choice > list.size();

                // handle enter key-down
                scanner.nextLine();

                switch(choice) {
                    case 0:
                        System.out.println(INSTRUCTIONS);
                        break;
                    case 1:
                        readGroceryList(list);
                        break;
                    case 2:
                        while(!exit) {

                            System.out.println(ADD_NEW_ITEM);

                            if(scanner.hasNextLine()) {

                                String input = scanner.nextLine();
                                input = formatInput(input);

                                if(isRegexMatch(input, REGEX_QUIT)) {

                                    System.out.println(RETURN_TO_MAIN);
                                    exit = true;
                                    break;

                                } else if(list.contains(input)) {

                                    System.out.println(ALREADY_ON_LIST);
                                    exit = true;
                                    break;

                                }
                                addItem(list, input);
                                exit = true;

                            } else {
                                scanner = handleInvalidValue();
                            }
                        }
                        break;
                    case 3:
                        while(!exit) {

                            if(list.isEmpty()) {
                                System.out.println(EMPTY_GROCERY_LIST);
                                exit = true;
                                break;
                            }

                            readGroceryList(list);
                            System.out.println(ENTER_DELETE_CHOICE);

                            if(scanner.hasNextInt()) {

                                choice = scanner.nextInt();

                                if(choice == -1) {

                                    System.out.println(RETURN_TO_MAIN);
                                    printInstructions();
                                    exit = true;
                                    break;

                                } else if(notInListRange) {
                                    scanner = handleInvalidValue();
                                }

                                choice -= 1;
                                deleteItem(list, choice);
                                exit = true;

                            } else {
                                scanner = handleInvalidValue();
                            }
                        }
                        break;
                    case 4:
                        while(!exit) {

                            if(list.isEmpty()) {
                                System.out.println(EMPTY_GROCERY_LIST);
                                exit = true;
                                break;
                            }

                            readGroceryList(list);
                            System.out.println(ENTER_UPDATE_ITEM);

                            if(scanner.hasNextLine()) {

                                String input = scanner.nextLine();
                                input = formatInput(input);

                                if(isRegexMatch(input, REGEX_QUIT)) {

                                    System.out.println(RETURN_TO_MAIN);
                                    exit = true;
                                    break;

                                } else if(list.contains(input)) {
                                    System.out.println(ALREADY_ON_LIST);
                                    exit = true;
                                    break;
                                }

                                while(!exit) {

                                    readGroceryList(list);
                                    System.out.println(ENTER_ITEM_NUMBER);

                                    if(scanner.hasNextInt()) {

                                        choice = scanner.nextInt();

                                        if(choice == -1) {

                                            System.out.println(RETURN_TO_MAIN);
                                            exit = true;
                                            break;

                                        } else if(notInListRange) {

                                            scanner = handleInvalidValue();

                                        } else {

                                            choice -= 1;
                                            updatedItem(list, choice, input);
                                            exit = true;
                                            break;
                                        }
                                    } else {
                                        scanner = handleInvalidValue();
                                    }
                                }
                            } else {
                                scanner = handleInvalidValue();
                            }
                        }
                        break;
                    case 5:
                        quit = true;
                        System.out.println(SHUTDOWN);
                        break;
                    default:
                        scanner = handleInvalidValue();
                        break;
                }
            } else {
                printInstructions();
                scanner = handleInvalidValue();
            }
        }
    }

    private Scanner handleInvalidValue() {
        System.out.println(INVALID_VALUE);
        return new Scanner(System.in);
    }

    private boolean isRegexMatch(String input, String regex) {
        Pattern regexPattern = Pattern.compile(regex);
        Matcher regexMatcher = regexPattern.matcher(input);
        return regexMatcher.find();
    }

    private String formatInput(String input) {
        return input.toLowerCase().trim();
    }

    public boolean addItem(List<String> list, String newItem) {

        String formatItem = formatInput(newItem);

        if(formatItem.isEmpty() ||
                list.contains(formatItem)
        ) {
            System.out.println(INVALID_VALUE);
            return false;
        }

        list.add(formatItem);
        System.out.println(ADDED_CONFIRMATION + formatItem);
        return true;
    }
    public boolean updatedItem(List<String> list, int index, String updateItem) {

        updateItem = formatInput(updateItem);

        if(list.isEmpty() || list.contains(updateItem) || index < 0 || index >= list.size()) {
            System.out.println(INVALID_VALUE);
            return false;
        }

        // ! O(1) constant TIME COMPLEXITY: array get() w/ index
        list.set(index, updateItem);
        System.out.println(UPDATED_CONFIRMATION);
        readGroceryList(list);
        return true;
    }

    public boolean deleteItem(List<String> list, int index) {

        if(list.isEmpty() || index < 0 || index >= list.size()) {
            System.out.println(INVALID_VALUE);
            return false;
        }

        // ! O(1) constant TIME COMPLEXITY: array get() w/ index
        list.remove(index);
        readGroceryList(list);
        return true;
    }

    public String queryForItem(List<String> list, String item) {

        if(list.isEmpty() || item.isEmpty()) return INVALID_VALUE;

        //! O(n) linear TIME COMPLEXITY: loop through worst-case entire array length
        if(list.contains(item.toLowerCase())) return item;

        return ITEM_NOT_FOUND;
    }

    // ! OVERLOADED METHOD: use same name for method to improve readability & scalability
     public String queryForItem(List<String> list, int index) {

        if(list.isEmpty() || index < 0 || index >= list.size()) return INVALID_VALUE;

        // ! O(1) constant TIME COMPLEXITY: array get() w/ index
        return list.get(index);
    }

    // ! OOP ENCAPSULATION: ensure functionality integrity by limiting access via access modifiers to methods & variables
    private void readGroceryList(List<String> list) {

        if(list.isEmpty()) {
            System.out.println(EMPTY_GROCERY_LIST);
            return;
        }

        System.out.println(GROCERY_LIST);
        for(int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ") " + list.get(i));
        }
    }

    private void printInstructions() {
        System.out.println("-----------");
        System.out.println(INSTRUCTIONS);
        System.out.println("-----------");
    }
}

/*
    NOTE: use int or long for num data types
    BONUS: for input 61 minutes = '01h 01m 00s' || '1h 1m 0s'

    1. create a SecondsAndMinutes class

        1. create a method called getDurationString that returns a String
            first parameter = minutes
            second parameter = seconds

        2. validate params:
            valid if minutes is greater than or equal to 0
            valid if seconds is greater than or equal to 0 and less than or equal to 59

        3. getDurationString returns 'Invalid value' if either param validation fails

        4. if params valid,
            calculate how many hours, minutes, and seconds equal the minutes and seconds passed to this method

                1 minute = 60 seconds
                1 hour = 60 minutes || 3600 seconds

            return that value as a string in format "XXh YYm ZZs"

    2. method overload getDurationString with only 1 param: seconds

        1. validate seconds is greater than or equal to 0 and return 'Invalid value' if it is not true

        2. if params valid,
            calculate how many minutes are in the seconds value

                1 minute = 60 seconds
                1 hour = 60 minutes || 3600 seconds

            then call the other overloaded method with the minutes and seconds parameters
 */
class SecondsAndMinutes extends ChallengesMasterUtil {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String XX = "XX";
    private static final String YY = "YY";
    private static final String ZZ = "ZZ";

    // OOP ENCAPSULATION private class fields

    // ! ACCESS MODIFIER PRIVATE: object visible only in declared class
    // ! STATIC FIELD: a single memory unique class-level shared variable that belongs to the class blueprint and NOT with any specific instances
    private static String getFormatInteger(int n) {
        String nString = Integer.toString(n);
        return n < 10 ? "0" + nString : nString;
    }

    // ! OVERLOADED METHODS: methods with the same name but unique parameters to optimize code readability & scalability
    public static String getDurationString(int minutes, int seconds) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(minutes < 0 ||
                (seconds < 0 || seconds > 59)) return INVALID_VALUE;

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

        String format = "XXh YYm ZZs";

        format = format.replaceAll(XX, getFormatInteger(hours));
        format = format.replaceAll(YY, getFormatInteger(remainingMinutes));
        return format.replaceAll(ZZ, getFormatInteger(seconds));
    }

    // ! ACCESS MODIFIER PUBLIC: member (class field or method) visible everywhere
    // ! STATIC FIELD: a single memory unique class-level shared variable that belongs to the class blueprint and NOT with any specific instances
    public static String getDurationString(int seconds) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(seconds < 0) return INVALID_VALUE;

        int minutes = (seconds / 60);
        int remainingSeconds = (seconds % 60);

        return getDurationString(minutes, remainingSeconds);
    }
}

/*
    write a class NumberPalindrome

    write the method isPalindrome with 1 int parameter called number
        returns a boolean based on if parameter is a palindrome
*/

class NumberPalindrome {

    public static boolean isPalindrome(int number) {

        if(number >= -9 && number <= 9) return true;

        String[] nums;

        if(number < 0) {
            number *= -1;
        }

        nums = Integer.toString(number).split("");

        int i = 0;
        int j = nums.length - 1;

        while(i < j) {

            String front = nums[i];
            String end = nums[j];

            if(!front.equals(end)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}

/*
    write a class EvenDigitSum

    write the method getEvenDigitSum with 1 int parameter called number
        returns -1 if param is negative

        use a loop and return the sum of all even digits in the number

    ? Interfaces vs Abstract Classes

        // ! ABSTRACT CLASSES cannot be instantiated and must rely on normal subclasses that use OOP INHERITANCE
        ABSTRACT CLASSES can have class fields/object instance members inherited AND define abstract publicly-shared signatures

        INTERFACES can ONLY define publicly-shared signatures

            interfaces can have essentially-constant variables defined as "public static final"
 */

// ! INTERFACE + OOP POLYMORPHISM: publicly-shared method signatures that must be uniquely implemented via @Override by designated classes
interface ISum {

    public boolean validateInput(int input);
}

/*
    ? ABSTRACT CLASSES

        force child subclass INHERITANCE of method, signatures, & parent super-class fields for a set of classes
        by mandating POLYMORPHISM method signatures to be defined in order to execute respectively-unique implementation
        ! CANNOT instantiate an ABSTRACT CLASS, must use a normal class that inherits from ABSTRACT CLASS for instantiation
 */
abstract class DigitSum implements ISum {

    public int sum = 0;

    public boolean validateInput(int input) {
        return input < 1;
    }
}

// ! INHERITANCE: child subclass inherits public fields + methods from extending parent super class
class EvenDigitSum extends DigitSum {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String SUM = "Sum: ";

    // OOP ENCAPSULATION private class fields
    private int sum = 0;

    // ! TIME COMPLEXITY O(1) linear: number of steps dependent on the length of the input
    public int getEvenDigitSum(int number) {

        // ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(validateInput(number)) return -1;

        for(int i = 0; i < number; i++) {
            if(i % 2 == 0) {
                System.out.print(i + " + ");
                sum += i;
            }
        }

        System.out.println("\n" + SUM + sum);
        return sum;
    }
}

/*
     write a class SharedDigit

     write the method hasSharedDigit with 2 int parameters
         each parameter should within 10-99 inclusive
         returns false if one of the parameters is out of range

     if both numbers share a common digit return true
         ex: 25 and 58 share a five
 */
class SharedDigit {

    // ! ACCESS-MODIFIER protected: object visible only in declared class & subclass (even in another package)
    // ! STATIC FIELD: a single memory-shared variable that only requires class reference & without an instance
    protected static boolean hasSharedDigit(int a, int b) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement
        boolean outOfRange = (a < 10 || a > 99) ||(b < 10 || b > 99);
        if(outOfRange) return false;

        int pointer = a % 10;

        if(pointer == b % 10 || pointer == b / 10) return true;

        pointer = a / 10;

        if(pointer == b % 10 || pointer == b / 10) return true;

        return false;
    }
}

/*
    sort algorithm with INSERTION SORT with RECURSIVE implementation
    sort algorithm with INSERTION SORT with ITERATIVE implementation

    * HINT: grow sorted partition with RECURSION

    ! RADIX SORT Big(O) TIME COMPLEXITY: O(n) linear

        RADIX SORT often runs slower at O(nlogn) LOGLINEAR time complexity

        ! BIG(O) + TIME COMPLEXITY: an algorithm's worst-case number of steps (performance) relative to the number of processed items, independent of hardware

    ! SPACE COMPLEXITY: in-place algorithm that doesnt use extra memory

    ! STABLE algorithm: if there are duplicates, original order of elements are preserved
 */
class DuelInsertionSort {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String BEFORE_SORT = "BEFORE SORT:";
    private static final String AFTER_SORT = "AFTER SORT:";

    // ! OOP ENCAPSULATION: protect object instance members/class fields from external access & direct inappropriate updates
    // ! ACCESS-MODIFIER private: access to variable exclusively limited to the scope of the class
    // private class fields
    private static int[] integers = {20, 35, -15, 7, 55, 1, -22};
    private static boolean isSorted = false;

    // ! ACCESS-MODIFIER protected: access to variable only allowed within scope of declared class and subclasses via INHERITANCE (even in another package)
    // ! INHERITANCE: a child subclass inherits public variables & methods from extending parent super classes
    protected static int[] execute(boolean isRecursive) {

        int[] numbers = getIntegers();

        if(isRecursive) {
            recursiveSorting(numbers, numbers.length);
        } else {
            iterativeSorting(numbers);
        }

        return getIntegers();
    }

    /**
     * sort input array with ITERATIVE implementation
     * ! ACCESS-MODIFIER private: access to method/variable limited to the scope of the defined class
     * ! STATIC: single class variable or method shared in memory across application
     * ! RECURSION: a self-calling algorithm that where each call on the call stack is waiting for a return value until a breaking condition resulting in a stack resolution or overflow
     * @param input
     * @param numElements
     */
    private static void recursiveSorting(int[] input, int numElements) {

        // ! RECURSIVE BASE CASE: breaking condition that starts upward propagation of call returns for stack resolution or overflow
        // partitions of 1 lengths are sorted
        boolean isBaseCase = numElements < 2;
        if(isBaseCase) return;

        // ! RECURSION: a self-calling algorithm that where each call on the call stack is waiting for a return value until a breaking condition resulting in a stack resolution or overflow
        // ? INSERTION SORT: use recursion to increase sorted partition size
        // decrement number of elements in unsorted partition since an element has been inserted into sorted partition
        recursiveSorting(input, numElements - 1);

        // ? INSERTION SORT + RECURSION: after getting to base case, traverse input & insert at correct index
        // save unsorted insertValue since element shifting & comparing might cause overwrite of value
        int insertValue = input[numElements - 1];

        // track index for insertion into sorted partition
        int i;

        // comparison traversal in sorted partition w/ unsorted insertValue is descending right-to-left
        // break when insertValue is less than the sortedValue
        for(i = numElements - 1; i > 0 && input[i - 1] > insertValue; i--) {

            // if unsorted insertValue < current sortedValue at the given index, shift up (left-to-right) current sorted Value & continue
            int newShiftedIndex = i - 1;
            int elementToShiftUp = input[newShiftedIndex];

            input[i] = elementToShiftUp;
        }

        // have found correct index for insertValue in sorted partition & insert value at said index in sorted partition
        input[i] = insertValue;
    }

    /**
     * sort input array with ITERATIVE implementation
     * ! ACCESS-MODIFIER private: access to method/variable limited to the scope of the defined class
     * ! STATIC: single class variable or method shared in memory across application
     * @param input
     */
    private static void iterativeSorting(int[] input) {
        // ! INSERTION SORT partitions: sorted & unsorted (starts w/ everything in unsorted and compares & moves into sorted)
        // ? SORTED PARTITION that's initialized w/ 1 element at index 0
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < input.length; firstUnsortedIndex++) {

            // save unsorted insertValue since element shifting & comparing might cause overwrite of value
            int insertValue = input[firstUnsortedIndex];

            // track index for insertion into sorted partition
            int i;

            // comparison traversal in sorted partition w/ unsorted insertValue is descending right-to-left
            // break when insertValue is less than the sortedValue
            for(i = firstUnsortedIndex; i > 0 && input[i - 1] > insertValue; i--) {

                // if unsorted insertValue < current sortedValue at the given index, shift up (left-to-right) current sorted Value & continue
                int newShiftedIndex = i - 1;
                int elementToShiftUp = input[newShiftedIndex];

                input[i] = elementToShiftUp;
            }

            // have found correct index for insertValue in sorted partition & insert value at said index in sorted partition
            input[i] = insertValue;
        }
    }

    // CLASS METHODS:
    private static void printResults() {

        if(!isSorted) {
            System.out.println(BEFORE_SORT);
        } else {
            System.out.println(AFTER_SORT);
        }
        isSorted = !isSorted;

        for(int i = 0; i < integers.length; i++) {
            System.out.print(integers[i] + ", ");
        }

        System.out.println();
    }

    // OOP GETTERS & SETTERS
    // ! ACCESS-MODIFIER public: access to variable available from any scope
    public static int[] getIntegers() {
        printResults();
        return integers;
    }
}

/*
    ? sort the following values (all lowercase) using RADIX SORT:

    "bcdef"
    "dbaqc"
    "abcde"
    "omadd"
    "bbbbb"

    ! RADIX SORT Big(O) TIME COMPLEXITY: O(1) constant

    ! SPACE COMPLEXITY: not in-place algorithm that does use extra memory

    ! STABLE algorithm: if there are duplicates, original order of elements are preserved
 */

class RadixSort {

    // CONSTANTS/static class variables assigned FINAL value before compilation
    private static final String PRE_SORT = "\n\tPRE-SORT:";
    private static final String POST_SORT = "\tPOST-SORT:";
    private static final char LETTER_A = 'a';

    // ! OOP ENCAPSULATION: protect object instance members/class fields from inappropriate external access
    // ! STATIC: single class variable/method shared in memory across application
    private static String[] strings = {
            "bcdef",
            "dbaqc",
            "abcde",
            "omadd",
            "bbbbb"
    };

    public static String[] execute() {

        // ? RADIX STABLE SORT: assumes data (consisting of only integers || Strings) has the same radix (shared set of characters) and width (shared element length)
        String[] input = getStrings(false);

        // ? RADIX SORT radix: 26 because english alphabet has 0-26 inclusive letters (array index)
        int radix = 26;
        // ? RADIX SORT width: each element in the array has 5 indices
        int width = 5;

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to avoid errors
        if(input.length == 0) return null;

        // traverse each index in each element of the given input array & sort
        int stringEnd = width - 1;
        for(int i = stringEnd; i >= 0; i--) {
            singleRadixStableSort(input, i, radix);
        }

        return getStrings(true);
    }

    private static void singleRadixStableSort(String[] input, int currentElementIndex, int radix) {

        int numElements = input.length;
        int[] radixTally = new int[radix]; // radix of 26 = integers 0-26

        // ? STEP 1: get raw count of each radix character occurrence
        // for each element in the input array, count how many elements have a SPECIFIC character at the current indexInElement
        for(String element : input) {
            int updatedTally = getRadixCharAtIndex(element, currentElementIndex);
            radixTally[updatedTally]++;
        }

        // ? STEP 2: adjust tally/count
        // sum indices to adjust the tally of each char to get numberOfElement that have char occurances at given index
        for(int i = 1; i < radix; i++) {
            int charIndex = i - 1;
            radixTally[i] += radixTally[charIndex];
        }

        // ? STEP 3: using char tally/count, write values into tempArray in sorted order
        String[] tempSorted = new String[numElements];

        // right-to-left to maintain stable algorithm
        for(int i = (numElements - 1); i >= 0; i--) {
            /*
                --array[i] = decrement value at index before it is used
                array[i]-- = decrement value at index after it is used
             */
            String element = input[i];
            int radixIndex = getRadixCharAtIndex(element, currentElementIndex);

            int decrementBeforeElementUse = --radixTally[radixIndex];

            tempSorted[decrementBeforeElementUse] = input[i];
        }

        // ? STEP 4: copy sorted elements back into input
        for(int i = 0; i < numElements; i++) {
            input[i] = tempSorted[i];
        }
    }

    private static int getRadixCharAtIndex(String element, int currentIndex) {

        char radixCharacter = element.charAt(currentIndex);
        int countingIndex = radixCharacter - LETTER_A;

        // char = numeric value
        // converting numeric value for character into index in counting array
        return countingIndex;
    }

    // OOP GETTERS & SETTERS
    public static String[] getStrings(boolean isSorted) {

        if(!isSorted) {
            System.out.println(PRE_SORT);
        } else {

            System.out.println(POST_SORT);
        }

        for(int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toLowerCase();
            System.out.println(strings[i]);
        }
        System.out.println();

        return strings;
    }
}