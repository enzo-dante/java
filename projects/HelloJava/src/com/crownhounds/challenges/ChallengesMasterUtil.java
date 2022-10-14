package com.crownhounds.challenges;

import com.crownhounds.datastructures_and_algorithms.Employee;
import com.crownhounds.masterjava.Util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengesMasterUtil {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    public static final String INVALID_INPUT = "Invalid input";
    public static final String INVALID_VALUE = "Invalid Value";

    public static void main(String[] args) {
//        GroceryApp groceryApp = new GroceryApp();
//        groceryApp.run();

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

class MethodHelper {

    /*
       create a method isEvenNumber with int param
           return true if even, else return false

       implement isEvenNumber in getEvens() in while loop that prints only even numbers
           check edge case: infinite loop

       record total number of even numbers found
           break out of loop on 5 and print the five even numbers

       HINT: use modulo/remainder operator
     */
    // ! ACCESS-MODIFIER public: accessibility to the public variable available from any scope
    // ! STATIC: class variable saved in a single space in memory used across entire application
    public static int getEvens(int end, int current, int total) {

        // ! RECURSIVE BASE CASE: breaking condition for RECURSIVE FUNCTIONS that initiates an upward propagates that return values for waiting calls resulting in a stack resolution or overflow
        boolean isBaseCase = (current > end);
        if(isBaseCase) return total;

        if(isEvenNumber(current)) total++;

        // ! RECURSIVE FUNCTIONS: a continuously self-calling algorithm & each call on the call stack waits for the algorithm to reach a base case/breaking condition for a return value.
        return getEvens(end,current + 1, total);
    }

    // ! ACCESS-MODIFIER private: accessibility to the public variable or method is limited to the scope of the defining class
    private static boolean isEvenNumber(int n) {
        return (n % 2 == 0);
    }

    /*
        write a method called sumDigits with 1 int param

        validate param is >=10 and return -1 if fail
            numbers 0-9 have 1 digit so don't have to process them
            negative number don't get processed so return -1

        return the sum of the all digits in the number
            ex:
                sumDigits(125) returns 8
                    1 + 2 + 5 = 8

                sumDigits(1) returns -1

        HINTS:
            use n % 10 to extract the least significant digit
            use n / 10 to discard the least significant digit
     */
    // ! ACCESS-MODIFIER protected: accessibility to the public variable or method is limited to the scope of the defining class and its inheriting subclasses within the package
    protected static int sumDigits(int n) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle potential errors
        if(n < 10) return -1;

        int sum = 0;

        // loop to get leastSignificantDigit and continuously add to sum
        while(n > 10) {

            // use (n % 10) to extract the least significant digit
            int leastSignificantNumber = n % 10;
            sum += (leastSignificantNumber);

            // use (n / 10) to discard the least significant digit
            n /= 10;
        }
        sum += n;
        return sum;
    }
}

/*
   Write a class SumOddRange

   Write a method called isOdd with an int parameter called number
       returns a boolean

   validate parameter is greater than 0, return false otherwise
       return true if num is odd, else return false

   Write sumOdd method that has 2 int params: start and end (range of numbers)
       use a for loop to sum all odd numbers in that range including the end
           return the int sum
       sumOdd should call isOdd

       end >= start and both start and end need to be greater than 0
       if param validation false, return -1

   HINT: use modulo/remainder operator
*/
// ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all public signatures for designated set of standardized classes
interface IOddRange {

    boolean isOdd(int number);
    boolean isValidParam(int number);
    int sumOdd(int start, int end);
}
class SumOddRange implements IOddRange {

    // ! CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String INVALID_INPUT = "Invalid input";

    // ! OOP ENCAPSULATION private class fields: use access-modifiers to guard the class/object from inappropriate external access
    private int error;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public SumOddRange() {
        // default values
        this.error = -1;
    }

    // CLASS METHODS: unique object behavior
    @Override
    public boolean isOdd(int number) {
        return number % 2 == 1;
    }

    @Override
    public boolean isValidParam(int number) {
        return number > 0;
    }

    @Override
    public int sumOdd(int start, int end) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exceptions
        if(!isValidParam(start) && !isValidParam(end)) return getError();

        int sum = 0;

        for(int i = start; i < end; i++) {

            if(isOdd(i)) {
                sum += i;
            }
        }
        return sum;
    }

    // OOP GETTERS & SETTERS
    public int getError() {
        return error;
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

/*
    ! use INTERFACES & ABSTRACT classes

        INTERFACE: abstract collection of public signatures that designated classes must uniquely implement/@Override for standardization
        ABSTRACT CLASSES: force INHERITANCE of NECESSARY extending child/subclasses instances with standardized method implementations with potential POLYMORPHISM

            ! Interfaces vs Abstract Classes

                ABSTRACT CLASSES can have class fields/object instance members inherited AND define abstract publicly-shared signatures

                INTERFACES can ONLY define publicly-shared signatures

                    interfaces can have essentially-constant variables defined as "public static final"

    ? create a bank account class
        with fields:
            account number, balance, customer name, email and phone number

    ? create getters & setters for each field
    ? create deposit funds method that increments balance field
    ? create withdraw funds method that deducts from balance field
        only allow withdraws if there are sufficient funds
 */

interface IAccounts {

    // abstract collection of publicly-shared method signatures (for object standardization) that designated classes must uniquely implement/@Override
    int deposit(int amount);
    int withdraw(int amount);
}

abstract class AbstractAccount implements IAccounts {

    // private class fields
    private int accountNumber;
    private int balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    // ! INTERFACE + POLYMOPRHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    // OOP constructor that initializes the class fields on class object instantiation
    public AbstractAccount(int accountNumber, int balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int deposit(int amount) {
        if(!hasEnoughFunds(amount) || !validAmount(amount)) return -1;
        return this.balance += amount;
    }

    public int withdraw(int amount) {
        if(!hasEnoughFunds(amount) || !validAmount(amount)) return -1;
        return this.balance -= amount;
    }

    private boolean validAmount(int amount) {
        return amount > 0;
    }

    private boolean hasEnoughFunds(int withdraw) {
        // ! AUTOBOXING: casting primitive dataType -> greater functionality Wrapper class
        Integer newBalance = (this.balance - withdraw);
        return newBalance >= 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

class BankAccount extends AbstractAccount {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String NOT_ENOUGH_FUNDS = "Not enough funds.";

    // OOP constructor that initializes the class fields on class/object instantiation
    public BankAccount(int accountNumber, int balance, String customerName, String email, String phoneNumber) {
        // ! INHERITANCE: child subclass inherits the class fields & public methods from an extending parent super class
        super(accountNumber, balance, customerName, email, phoneNumber);
    }

    @Override
    public int deposit(int amount) {
        int response = super.deposit(amount);
        if(response == -1) {
            System.out.println(NOT_ENOUGH_FUNDS + this.toString());
            return response;
        }

        System.out.println("New balance: " + response);
        return response;
    }

    @Override
    public int withdraw(int amount) {
        int response = super.withdraw(amount);
        if(response == -1) {
            System.out.println(NOT_ENOUGH_FUNDS + this.toString());
            return response;
        }

        System.out.println("New balance: " + response);
        return response;
    }
}

/*
    ? write a class called GSD

    ? write a method getGreatestCommonDivisor with two params of type int named first and second

        if one of the params < 10, return -1

        the method should return the greatest common divisor of the 2 numbers (int)

    ! use INTERFACES, ABSTRACTION, EXCEPTION HANDLING, TDD, GENERICS, AUTOBOXING/UNBOXING

    * HINT: greatest common divisor is the largest positive integer that can fully divide each of the integers (no remainder)

            12 = [12, 1], [6, 2], [4,3]
            GCF/GCD = 6

    ! INTERFACES vs ABSTRACTION

        ABSTRACT CLASSES can have class fields/object instance members inherited AND define abstract publicly-shared signatures

        INTERFACES can ONLY define publicly-shared signatures

            interfaces can have essentially-constant variables defined as "public static final"
 */

interface IDivisor {

    // ! INTERFACES + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared defined signatures for designated classes
    Integer getGreatestCommonDivisor(int first, int second);
}

// ! ABSTRACT CLASSES: enforce child subclass INHERITANCE of methods, method signatures, & class fields of an extending parent super class by mandating POLYMORPHISM for prerequisite instances of designated classes
abstract class AbstractGreatest implements IDivisor {

    // ! OOP ENCAPSULATION: use access-modifiers to protect public class fields & methods from external inappropriate use
    // ! ACCESS-MODIFIER private: method or variable w/ accessability limited to scope of defining class
    private int limit;

    // ! OOP: constructor that initializes the class fields on class/object instantiation
    public AbstractGreatest(int limit) {
        this.limit = limit;
    }
}

class GSD extends AbstractGreatest {

    // ! OOP: constructor that initializes the class fields on class/object instantiation
    // ! ACCESS-MODIFIER public: method or variable accessible from any scope
    public GSD(int limit) {
        super(limit);
    }

    @Override
    public Integer getGreatestCommonDivisor(int first, int second) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to prevent code breaks
        if(validateParms(first, second)) return -1;

        int gsd = 1;
        int length = Math.max(first, second) / 2;

        // option 1
        for(int i = 1; i < length; i++) {

            if((first % i == 0) &&
                    (second % i == 0)) gsd = i;
        }

        return gsd;
    }

    private boolean validateParms(int first, int second) {
        return (first < 10) || (second < 10);
    }
}

/*
    write FactorPrinter class
    write the printFactors method with 1 int parameter called number

        that returns nothing, but prints all the factors of a number

    if number is less than 1, print 'Invalid Value'

    * HINT: a factor is an integer that divides that number wholly (no remainder)
 */
class FactorPrinter {

    // CONSTANTS/static class variables assigned final value before compilation/instantiation
    private static final String INVALID_VALUE = "Invalid Value";
    private static final String ALL_FACTORS_PRINTED = "All factors printed";

    // ! STATIC: single class variables saved in memory associated with class and not instances shared across entire app
    // ! GENERICS: enforce parameter dataType and improve OOP ENCAPSULATION
    static String printFactors(int number) {

        if(number < 1) return INVALID_VALUE;

        int midpoint = number / 2;
        for(int factor = 1; factor < midpoint; factor++) {

            if(number % factor == 0) {
                System.out.println(factor);
                number /= factor;
            }
        }

        return ALL_FACTORS_PRINTED;
    }
}

/*
    ? write a class called PerfectNumber

    ? write a method called isPerfectNumber with int parameter(s) called number

        if number < 1
            returns false

        if number is perfect
            return true

    perfect number:
        ! A perfect number is a positive integer which is equal to the sum of its proper positive divisors.
    Proper positive divisors:
        ! positive integers that fully divide the perfect number without leaving a remainder and exclude the perfect number itself.

        * For example, take the number 6:

            * Its proper divisors are 1, 2, and 3
                (since 6 is the value of the perfect number, it is excluded)

            * the sum of its proper divisors is 1 + 2 + 3 = 6.
 */

class PerfectNumber {

    public static boolean isPerfectNumber(int number) {

        if(number < 1) return false;

        int sum = 0;
        boolean isProperPositiveDivisor;

        for(int i = 1; i < number; i++) {

            isProperPositiveDivisor = (number % i == 0);

            if(isProperPositiveDivisor) {
                sum += i;
            }
        }
        return sum == number;
    }
}

/*
   1. Write a LeapYearCalculator class

   2. Write a method isLeapYear with a parameter of type int named year.

       The parameter needs to be greater than or equal to 1 and less than or equal to 9999.
           If the parameter is not in that range return false.

       Otherwise, if it is in the valid range,
           calculate if the year is a leap year and return true if it is a leap year, otherwise return false.

       To determine whether a year is a leap year, follow these steps:
           1. If the year is evenly divisible by 4, go to step 2.

               Otherwise, go to step 5 if NOT evenly divisible by 4 go step 5

           2. If the year is evenly divisible by 100, go to step 3.
               Otherwise, go to step 4.

           3. If the year is evenly divisible by 400, go to step 4.
               Otherwise, go to step 5.

           4. The year is a leap year (it has 366 days).
               The method isLeapYear needs to return true.

           5. The year is not a leap year (it has 365 days).
               The method isLeapYear needs to return false.

   3. TEST divisibility by 100 BUT_NOT/AND 400

       1. The following years are NOT leap years:

       This is because they are evenly divisible by 100 but NOT by 400.
           1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600

       2. The following years ARE leap years:

       This is because they are evenly divisible by both 100 AND 400.
           1600, 2000, 2400

*/
class LeapYearCalculator {

    // ! CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    // ! STATIC: single instance variables saved in memory associated with class and not any single subclass instance
    // ! ACCESS-MODIFIER private: accessibility to variable and method limited to the scope of the defining class
    private static final String IS_VALID_YEAR = " is a valid year!";

    // ! ACCESS-MODIFIER public: accessible from any scope
    public static boolean isLeapYear(int year) {

        boolean isDivBy4 = (year % 4 == 0);
        boolean isDivBy100 = (year % 100 == 0);
        boolean isDivBy400 = (year % 400 == 0);

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to prevent any exceptions
        if(!inRangeParameter(year) || !isDivBy4) return false;
        System.out.println(year + IS_VALID_YEAR);

        if(!isDivBy100) return true;

        return isDivBy400;
    }

    // ! ACCESS-MODIFIER protected: accessibility to variable and method limited to the scope of the defining class and child subclasses
    protected static boolean inRangeParameter(int year) {
        return (year >= 1) && (year < 10000);
    }
}

/*
    ? Define EmployeeDoublyLinkedList class that has all the functionality of a doubly linkedList

    ? implement addBefore(Employee e1, Employee e2) for EmployeeDoublyLinkedList class that will insert new employee immediately before existing employee
        return true if you were able to successfully add the employee
        into the list before the existing employee. Return false
        if the existing employee doesn't exist in the list

    ! INTERFACE & ABSTRACT CLASSES

        ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures

        * CANNOT instantiate an ABSTRACT CLASS, must use a normal class that inherits from ABSTRACT CLASS for instantiation

        INTERFACES can ONLY define publicly-shared signatures
 */

// ! INTERFACE + OOP POLYMORPHISM: publicly-shared method signatures that must be uniquely implemented/@Override by all implementing classes
interface IDoubly {

    boolean addBefore(Employee e1, Employee e2);
    boolean isEmpty();
    int getSize();
}

// ! ABSTRACT CLASSES: enforce required child subclass INHERITANCE of methods, signatures, parent super class-fields by mandating OOP POLYMORPHISM of method signatures
abstract class AbstractDoubly implements IDoubly {

    // ! CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    // ! STATIC: variable stored in a single place in memory that is shared by entire application and associated w/ the defining class and not any single subclass
    // ! ACCESS-MODIFIER protected: accessibility of variable or method limited to the scope of the defining class and it's subclasses within the package
    protected static final String NO_EMPLOYEES = "There are no employees in this doubly linkedList.";
    private static final String HEAD = "HEAD => ";
    private static final String TAIL = "NULL TAIL";
    private static final String DIVIDER = "\n\t <=> ";

    // ! OOP ENCAPSULATION: access-modifier protected variables & methods from inappropriate external use
    // ! ACCESS-MODIFIER private: accessibility of variable or method limited to the scope of the defining class
    // private class fields
    private Employee head;
    private Employee tail;

    // ! OOP constructor that initializes the class fields on class/object instantiation
    public AbstractDoubly() {
        // default values
        this.head = null;
        this.tail = null;
    }

    // OOP CLASS METHODS
    // ! ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures
    abstract boolean addToFront(Employee e);
    abstract boolean addToEnd(Employee e);
    abstract Employee removeFromFront();
    abstract Employee removeFromEnd();

    // ! ACCESS-MODIFIER public: variable or method is accessible from any scope
    public void printList() {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to avoid exceptions
        if(this.isEmpty()) System.out.println(NO_EMPLOYEES);
        Employee current = this.head;

        System.out.print(HEAD);

        while(current != null) {
            System.out.print(current);
            System.out.print(DIVIDER);

            current = current.getNext();
        }
        System.out.println(TAIL);
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }
    // OOP ENCAPSULATION GETTERS & SETTERS
    public Employee getHead() {
        return this.head;
    }

    public Employee getTail() {
        return this.tail;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public void setTail(Employee tail) {
        this.tail = tail;
    }
}

class EmployeeDoublyLinkedList extends AbstractDoubly {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String NOT_FOUND = "Employee not found";

    // private class fields
    private int size;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public EmployeeDoublyLinkedList() {
        this.size = 0;
    }

    @Override
    public boolean addBefore(Employee insertingNode, Employee existingNode) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exceptions
        if(this.isEmpty() || insertingNode == null || existingNode == null ) return false;

        if(this.getHead().getId() == existingNode.getId()) {
            this.addToFront(insertingNode);
            return true;
        }

        Employee current = this.getHead();

        while(current != null && current.getNext() != null) {

            Employee currentTail = current.getNext();

            if(currentTail.getId() == existingNode.getId()){
                this.size++;

                insertingNode.setNext(currentTail);
                current.setNext(insertingNode);

                return true;
            }
            current = currentTail;
        }
        System.out.println(NO_EMPLOYEES);
        return false;
    }

    @Override
    boolean addToFront(Employee e) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exceptions
        if(e == null) return false;

        this.size++;

        if(this.isEmpty()) {
            this.setHead(e);
            return true;
        }

        e.setNext(this.getHead());
        this.setHead(e);
        return true;
    }

    @Override
    boolean addToEnd(Employee e) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exceptions
        if(e == null) return false;

        this.size++;

        if(this.isEmpty()) {
            addToFront(e);
        } else {

            Employee current = this.getHead();

            while(current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(e);
            this.setTail(e);
        }
        return true;
    }

    @Override
    Employee removeFromFront() {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exceptions
        if(this.isEmpty()) return null;

        this.size--;

        Employee poppedEmployee = this.getHead();
        this.setHead(poppedEmployee.getNext());

        return poppedEmployee;
    }

    @Override
    Employee removeFromEnd() {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exceptions
        if(this.isEmpty()) return null;

        this.size--;

        Employee current = this.getHead();
        Employee removed = null;

        while(current.getNext() != null) {
            removed = current.getNext().getNext();
            if(removed == null) break;

            current = current.getNext();
        }

        removed = current.getNext();
        current.setNext(null);
        this.setTail(current);

        return removed;
    }

    @Override
    public int getSize() {

        if(this.isEmpty()) return -1;

        // implied else-statement
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

/*
    ? Create Vehicle class

        in conjunction with state, the shared vehicle behaviors have:

            hand steering

            changing gears

            moving with speed
                accelerating: increasing/decreasing speeding should be included

    ? Create Car class that inherits from Vehicle class

    ? Create specific model class that inherits from Car class

        specific model class should have unique behavior

    * use INNER CLASS, OOP INHERITANCE, INTERFACE, ABSTRACTION

    ! INTERFACES VS ABSTRACT CLASSES

        ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures

        * CANNOT instantiate an ABSTRACT CLASS, must use a normal class that inherits from ABSTRACT CLASS for instantiation

        INTERFACES can ONLY define publicly-shared signatures
 */

// ! INTERFACE + OOP POLYMORPHISM: for standardization, publicly-shared method signatures that must be uniquely implemented/@Override for designated classes
interface IVehicle {

    boolean changingGears(int gear);
    Integer accelerating(int speed);
    boolean isMoving();
}

// ! ABSTRACT CLASSES: enforce OOP INHERITANCE by mandating POLYMORPHISM for MANDATORY subclasses
// ! INHERITANCE: child subclass inherits public class fields & methods from an extending parent super class
abstract class AbstractVehicle implements IVehicle {

    protected static final String CURRENT_DIRECTION = "Vehicle currently moving direction is at angle ";

    // ! OOP ENCAPSULATION: use access-modifiers to protect class functionality and attributes from inappropriate external access
    // ! ACCESS-MODIFIER private: accessibility of variable or method limited to the scope of the defining class
    // private class fields
    private int speed;
    private int direction;
    private Gearbox gearbox;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public AbstractVehicle(int speed, int numGears) {

        // ! AUTOBOXING: casting primitive dataType -> greater functionality Wrapper class dataType
        this.speed = speed;

        // default values on instantiation
        this.direction = 0;
        this.gearbox = new Gearbox(numGears);
    }

    // ! ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures
    abstract int handSteering(int direction);

    @Override
    public boolean isMoving() {
        return this.speed > 0;
    }

    // ! OOP GETTERS & SETTERS
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        System.out.println(CURRENT_DIRECTION + this.direction);
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public int getCurrentGear() {
        return this.gearbox.currentGear.gearNumber;
    }

    // ! ACCESS-MODIFIER protected: accessibility of public variable or method limited to the scope of defining class and it's subclasses
    // ! INNER CLASS: logically grouped class components within a parent class
    protected class Gearbox {

        // ! CONSTANTS/static class variables assigned FINAl value before compilation/instantiation
        // ! STATIC: class-associated (not any subclass instance) variable stored in single space in memory and shared accross entire applicaiton
        protected static final String GRINDING = "Gears are grinding because speed is too high for gear range";

        // ! OOP ENCAPSULATION: use access-modifiers to protect class functionality and attributes from inappropriate external access
        // ! GENERICS: enforce parameter dataType on object definition to improve OOP ENCAPSULATION
        // private class fields
        private final ArrayList<Gear> gears;
        private Gear currentGear;

        // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
        public Gearbox(int numGears) {

            // default values on class instantiation
            this.gears = new ArrayList<>();

            for(int i = 1; i <= numGears; i++) {
                Gear gear = new Gear(i);
                this.gears.add(gear);
            }

            this.currentGear = this.gears.get(0);
        }

        @Override
        public String toString() {
            return "\n\tGearbox{" +
                    "gears=" + gears.toString() +
                    "}\n";
        }

        // OOP GETTERS & SETTERS
        public ArrayList<Gear> getGears() {
            return gears;
        }

        public Gear getCurrentGear() {
            return currentGear;
        }

        public void setCurrentGear(Gear currentGear) {
            this.currentGear = currentGear;
        }

        protected class Gear {

            // ! OOP ENCAPSULATION: use access-modifiers to protect class functionality and attributes from inappropriate external access
            // private class fields
            private final int gearNumber;

            // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
            public Gear(int gearNumber) {
                this.gearNumber = gearNumber;
            }

            // CLASS METHODS: unique object behavior
            @Override
            public String toString() {
                return "\n\t\tGear{" +
                        "gearNumber=" + getGearNumber() +
                        '}';
            }

            // OOP GETTERS & SETTERS
            public int getGearNumber() {
                return gearNumber;
            }
        }
    }
}

class Vehicle extends AbstractVehicle {

    // ! CONSTANTS/static class variables assigned FINAL values before compilation/instantiation
    private static final String NOW_MOVING_AT = " now moving at ";
    protected static final String COMPLETE_STOP = " is at a complete stop";
    protected static final String INVALID_GEAR = "Invalid Gear";
    protected static final String SAME_GEAR = "Same Gear";
    protected static final String CURRENT_GEAR = "Current Gear: ";

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public Vehicle(int numGears) {
        // ! OOP INHERITANCE: child subclass inherits public class fields & methods from an extending parent super class
        super(0, numGears);
    }

    @Override
    public boolean changingGears(int gear) {

        Gearbox gearbox = this.getGearbox();
        int oldGearNumber = this.getCurrentGear();

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(gear > gearbox.getGears().size()) {
            System.out.println(INVALID_GEAR);
            return false;
        } else if(gear == oldGearNumber) {
            System.out.println(SAME_GEAR);
            return false;
        }

        int currentSpeed = this.getSpeed();
        Gearbox.Gear newGear = gearbox.getGears().get(gear);

        switch(gear) {
            case 1:
                if(currentSpeed > 0 && currentSpeed < 10) gearbox.setCurrentGear(newGear);
                break;
            case 2:
                 if(currentSpeed >= 10 && currentSpeed < 30) gearbox.setCurrentGear(newGear);
                break;
            case 3:
                if(currentSpeed >= 30 && currentSpeed < 45) gearbox.setCurrentGear(newGear);
                break;
            case 4:
                if(currentSpeed >= 45 && currentSpeed < 70) gearbox.setCurrentGear(newGear);
                break;
            case 5:
                if(currentSpeed >= 70 && currentSpeed < 90) gearbox.setCurrentGear(newGear);
                break;
            case 6:
                if(currentSpeed >= 90) gearbox.setCurrentGear(newGear);
                break;
            default:
                System.out.println(INVALID_GEAR);
                break;
        }

        if(getCurrentGear() != oldGearNumber) {
            System.out.println(CURRENT_GEAR + this.getCurrentGear());
            return true;
        }

        System.out.println(INVALID_GEAR);
        return false;
    }

    @Override
    public Integer accelerating(int speed) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(speed == 0) return -1;

        int newSpeed = this.getSpeed() + speed;

        if(newSpeed <= 0) {
            this.setSpeed(0);
            System.out.println(getClass().getSimpleName() + COMPLETE_STOP);
            return this.getSpeed();
        }

        this.setSpeed(newSpeed);
        System.out.println(getClass().getSimpleName() + NOW_MOVING_AT + this.getSpeed());
        return this.getSpeed();
    }

    @Override
    int handSteering(int direction) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(!inRangeDirection(direction)) return -1;

        int newDirection = this.getDirection() + direction;

        if(newDirection == 0) return this.getDirection();

        if(newDirection < -360) {
            newDirection += 360;
        } else if(newDirection > 360) {
            newDirection -= 360;
        }

        this.setDirection(newDirection);
        return getDirection();
    }

    private boolean inRangeDirection(int direction) {
        return direction != 0 && direction < 360 && direction > -360;
    }
}

class Car extends Vehicle {

    // ! OOP ENCAPSULATION: use access-modifiers to protect class functionality and attributes from inappropriate external access
    // private class fields
    private int numWheels;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public Car(int numWheels, int numGears) {
        super(numGears);
        this.numWheels = numWheels;
    }

    // CLASS METHODS
    // ! OOP POLYMORPHISM: @Override inherited public method for class to have unique implementation

    // OOP GETTERS & SETTERS
    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }
}

class Ferrari extends Car {

    // private class fields
    private String model;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public Ferrari(String model, int numGears) {
        super(4, numGears);
        this.model = model;

    }

    // CLASS METHODS: unique object behavior
    @Override
    public String toString() {
        return "Ferrari{" +
                "model='" + getModel() + '\'' +
                ", gearbox=" + getGearbox() +
                '}';
    }

    @Override
    public boolean isMoving() {

        if(!super.isMoving()) System.out.println(this + COMPLETE_STOP);

        return super.isMoving();
    }

    public String getModel() {
        return this.getClass().getSimpleName() + " " + model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

/*
    ? define class CentimeterCalculator

    ? 1. create a method: calcFeetAndInchesToCentimeters
        2 parameters: double feet, double inches

    validate feet is greater than or equal to 0
    validate inches is greater than or equal to 0, validate inches is less than or equal to 12
    if any false, return -1

    if params valid, calculate number of centimeters passes to method based on params
        1 foot = 12 inches
        1 in = 2.54cm

    ? 2. create 2nd method with same name but only 1 param: double inches

    validate that inches >= 0
        return -1 if false
        calculate how many feet are in the inches param
            1 foot = 12 inches

    CALLING another overloaded method just requires you to use the right number of parameters

    * USE OOP, GENERICS, ABSTRACTION, INTERFACES, AUTOBOXING/UNBOXING, METHOD OVERLOADING, EXCEPTION HANDLING

    ! INTERFACES VS ABSTRACT CLASSES

        ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures

        * CANNOT instantiate an ABSTRACT CLASS, must use a normal class that inherits from ABSTRACT CLASS for instantiation

        INTERFACES can ONLY define publicly-shared signatures
 */

// ! INTERFACES + OOP POLYMORPHISM: publicly-shared method signatures that must be uniquely implemented/@Override by for designated standardized classes
interface ICentimeter {

    // ! METHOD OVERLOADING: using same name for multiple associated methods to help with scaleability & code readabiliuty
    double calcFeetAndInchesToCentimeters(double feet, double inches);
    double calcFeetAndInchesToCentimeters(Double inches);
}

// ! ABSTRACT CLASSES: enforce OOP INHERITANCE & POLYMORPHISM of abstract method signatures, methods, class fields for MANDATORY child subclasses that help with standardization
abstract class AbstractCentimeter implements ICentimeter {

    // ! CONSTANTS/static class variables assigned FINAL value before compilation/instantion
    // ! STATIC: class-associated variable saved in a single space in memory that is used across entire applicaiton
    // ! ACCESS-MODIFIER protected: OOP ENCAPSULATION access to variable or method is limited to the scope of defining class and it's subclasses via OOP INHERITANCE
    // ! OOP ENCAPSULATION: use access-modifiers to manage accessibility of variables and methods in order to guard against inappropriate external use
    protected static final Integer ERROR = -1;

    // private class fields
    private boolean isOn;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public AbstractCentimeter(boolean isOn) {
        this.isOn = isOn;
    }

    // ! ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures
    abstract protected boolean validateParams(double feet, double inches);

    @Override
    public double calcFeetAndInchesToCentimeters(double feet, double inches) {

        if(!validateParams(feet, inches)) return -1;

        // ! AUTOBOXING: casting primitive dataType -> greater functionality Wrapper class dataType
        Double feetToInches = feet * 12D;

        Double totalInches = feetToInches + inches;

        return calcFeetAndInchesToCentimeters(totalInches);
    }


    @Override
    public double calcFeetAndInchesToCentimeters(Double inches) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        // ! CASTING: converting one dataType to another compatible dataType
        if(inches < 0) return -1;

        // ! UNBOXING: casting greater functionality Wrapper class dataType -> primitive dataType
        return inches * 2.54;
    }
}

class CentimeterCalculator extends AbstractCentimeter {

    // ! CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    // ! STATIC: class-associated variable saved in a single space in memory that is used across entire app
    // ! ACCESS-MODIFIER private: OOP ENCAPSULATION access to variable or method is limited ONLY to the scope of defining class and cannot be access externally
    private static final String INVALID_INPUT = "Invalid Input";

    // ! OOP COMPOSITION: organize class/object functionality by having components that themselves are classes that handle specific functionality
    // private class fields
    private PowerButton powerButton;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public CentimeterCalculator(boolean isOn) {
        // ! OOP INHERITANCE: child subclass inherits access to public class fields & methods from extending parent super class
        super(isOn);

        this.powerButton = new PowerButton();
        if(isOn) this.powerButton.pressButton();
    }

    @Override
    protected boolean validateParams(double feet, double inches) {
        return (inches >= 0 && inches <= 12) && (feet >= 0);
    }
}

class PowerButton {

    // ! CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String ON = "Power On";
    private static final String OFF = "Power Off";
    // private class fields
    private boolean isPressed;

    public PowerButton() {
        // default values
        this.isPressed = false;
    }

    // CLASS METHOD: unique object behavior
    public void pressButton() {

        this.isPressed = !this.isPressed;

        if(!this.isPressed) {
            System.out.println(ON);
        } else {
            System.out.println(OFF);
        }
    }
}

/*
    ? define BankThread to create and start 2 threads

    2 people using a joint bank account instance at the same time
        initial balance of a thousand dollars.

        one will deposit 300 into the bank account and then withdraw 50.
        second is going to deposit 203.75 and then withdraw 100.

    ? due to thread interference, use the synchronized keyword to make BankAccount class threadsafe
 */
class BankThread {

    // ! CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    // ! STATIC: class variable saved in single space in memory and accessed across app
    private static final String CURRENT_BALANCE = " Account Balance: ";

    // ! ACCESS-MODIFIER protected: accessibility to class variable or method is limited to the scope of the defining class and subclasses
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_CYAN = "\u001B[36m";

    // ! ACCESS-MODIFIER public: class variable or method is accessible from anywhere
    public Double getBalance() {

        BankAccount bankAccount = new BankAccount("007");

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(bankAccount.getBalance() < 0) return null;

        // ! THREAD: a unit of execution within a process, each process can have multiple threads, a process is a method for a program to "split" itself into two or more simultaneously running tasks.
        // ! THREADS: always call .start() and never call .run() because JVM handles .run() for threads which always requires a new instance
        // ! THREADS + ANONYMOUS CLASSES/LAMBDA: when using anonymous classes, the Thread must be executed immediately
        new Thread() {
            @Override
            public void run() {
                bankAccount.deposit(300D);
                bankAccount.withdraw(50D);
                System.out.println(BankThread.ANSI_CYAN + bankAccount.getAccountNumber() + CURRENT_BALANCE + bankAccount.getBalance());
            }
        }.start();

        // ! THREADS + ANONYMOUS CLASSES: use instance of Thread class w/ Thread anonymous subclass that implements Runnable interface as parameter to execute Thread.start() on its own thread
        Thread anotherThread = new Thread(new MyRunnable(bankAccount));
        anotherThread.start();

        // ! AUTOBOXING: casting primitive dataType -> greater functionality Wrapper class dataType
        return bankAccount.getBalance();
    }

    // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
    private class MyRunnable implements Runnable {

        // ! OOP ENCAPSULATION: use access-modifiers to protect the class from inappropriate external access & use
        // ! ACCESS-MODIFIER private: accessibility to class variable or method is limited to the scope of the defining class
        // private class fields
        private BankAccount bankAccount;

        // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
        public MyRunnable(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
        }

        @Override
        public void run() {
            bankAccount.deposit(203.75D);
            bankAccount.withdraw(100D);
            System.out.println(BankThread.ANSI_RED + bankAccount.getAccountNumber() + CURRENT_BALANCE + bankAccount.getBalance());
        }
    }

    private static class BankAccount {

        // ! OOP ENCAPSULATION: use access-modifiers to protect the class from inappropriate external access & use
        // ! ACCESS-MODIFIER private: accessibility to class variable or method is limited to the scope of the defining class
        // private class fields
        private double balance;
        private String accountNumber;

        // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
        public BankAccount(String accountNumber) {
            this.accountNumber = accountNumber;

            // default values
            this.balance = 1000;
        }

        // ! THREAD + CONCURRENCY synchronization: use synchronized keyword on only essential code to minimize impact to avoid thread interference & ensure BankThread is threadsafe
        public synchronized void deposit(double amount) {
            this.balance += amount;
        }

        public void withdraw(double amount) {
            // ! THREAD + CONCURRENCY synchronization: use synchronized code block on only essential code to minimize impact to avoid thread interference & ensure BankThread is threadsafe
            synchronized (this) {
                this.balance -= amount;
            }
        }

        // OOP GETTERS & SETTERS
        public double getBalance() {
            return balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }
    }
}

/*
     ! OOP: Implement the following classes:

      ? Bank

        It has two fields:
            String called name
            ArrayList that holds objects of type Branch called branches.

        A constructor that takes a String (name of the bank).
            It initialises name and instantiates branches.

        And five methods, they are (their functions are in their names):

            addBranch()
                has one parameter of type String (name of the branch) and returns a boolean.
                It returns true if the branch was added successfully or false otherwise.

            addCustomer()
                has three parameters:
                    String (name of the branch),
                    String (name of the customer),
                    double (initial transaction)
                It returns true if the customer was added successfully or false otherwise.

            addCustomerTransaction()
                has three parameters:
                    String (name of the branch),
                    String (name of the customer),
                    double (transaction)
                It returns true if the customers' transaction was added successfully or false otherwise.

            findBranch()
                has one parameter of type String (name of the Branch) and returns a Branch.
                Return the Branch if it exists or null otherwise.

            listCustomers()
                This method prints out a list of customers.
                has two parameters
                    String (name of the Branch),
                    boolean (print transactions)
                Return true if the branch exists or false otherwise.

            * TIP:  In Bank, use the findBranch() method in each of the other four methods to validate a branch.
                              * Do the same thing in Branch with findCustomer() except for the two getters.

      ?  Branch

            It has two fields:
                String called name
                ArrayList that holds objects of type Customer called customers.

            A constructor that takes a String (name of the branch)
                It initialises name and instantiates customers.

            And five methods, they are (their functions are in their names):

                getName()
                    getter for name.

                getCustomers()
                    getter for customers.

                newCustomer()
                    has two parameters of type String (name of customer), double (initial transaction) and returns a boolean.
                    Returns true if the customer was added successfully or false otherwise.

                addCustomerTransaction()
                    has two parameters of type String (name of customer), double (transaction) and returns a boolean.
                    Returns true if the customers' transaction was added successfully or false otherwise.

                findCustomer()
                    has one parameter of type String (name of customer) and returns a Customer.
                    Return the Customer if they exist, null otherwise.

      ?  Customer

            It has two fields:
                String called name
                ArrayList that holds objects of type Double called transactions.

            A constructor that takes a  String (name of customer) and a double (initial transaction).
                It initialises name and instantiates transactions.

            And three methods, they are (their functions are in their names):

                getName()
                    getter for name.

                getTransactions()
                    getter for transactions.

                addCustomerTransaction()
                    has one parameter of type double (transaction)
                    doesn't return anything.

     ! INNER CLASSES, ABSTRACTION, INTERFACES, GENERICS

     ! MUST USE AUTOBOXING and UNBOXING
        transactions an ideal place for implementation requirement

      Your job is to create a simple banking application.

      ! COMPOSITION
            TIP:  In Customer, think about what else you need to do in the constructor when you instantiate a Customer object.
            TIP:  Think about what methods you need to call from another class when implementing a method.

      NOTE:  All transactions are deposits (no withdraws/balances).

      ! ENCAPSULATION
            NOTE:  All fields are private.
            NOTE:  All constructors are public.

            * NOTE:  All methods are public (except for findBranch() and findCustomer() which are private).

      NOTE:  Be extremely careful with the spelling of the names of the fields, constructors and methods.
      NOTE:  Be extremely careful about spaces and spelling in the printed output.
      NOTE:  There are no static members.
      NOTE:  Do not add a main method to the solution code.

     ! INTERFACES VS ABSTRACT CLASSES

        ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures

        * CANNOT instantiate an ABSTRACT CLASS, must use a normal class that inherits from ABSTRACT CLASS for instantiation

        INTERFACES can ONLY define publicly-shared signatures
 */

// ! INTERFACES: force implementation of publicly-shared method signatures for a set of classes
interface IFinancial {
    String getName();
}

// !ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures
abstract class AbstractPerson implements IFinancial {

    private String name;

    public AbstractPerson(String name) {
        this.name = name;
    }

    // ! ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures
    abstract public void addCustomerTransaction(double amount);

    @Override
    public String getName() {
        return name;
    }
}

class FinancialCustomer extends AbstractPerson {

    // ! OOP ENCAPSULATION: use access-modifiers to guard class functionality from inappropriate external access & use
    // ! ACCESS-MODIFIER private: accessibility to the variable or method is limited to the scope of the defining class
    // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
    // private class fields
    private ArrayList<Double> transactions;

    // ! OOP CONSTRUCTOR that initializes the class fields on class object instantiation
    public FinancialCustomer(String name) {
        // ! OOP INHERITANCE: child subclass inherits access to public class fields & methods from an extending parent super class
        super(name);

        // default values
        this.transactions = new ArrayList<>();
    }

    // ! ACCESS-MODIFIER public: variable or method is accessible from any scope
    public void addCustomerTransaction(double amount) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(amount < 0) return;

        // ! AUTOBOXING: casting primitive dataType to compatible higher functionality Wrapper class dataType
        this.transactions.add(amount);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}

// ! GENERIC CLASSES + INHERITANCE: enforce parent super-class first, then multiple interfaces
class FinancialBranch<T extends FinancialCustomer> implements IFinancial {

    private String name;
    // ! GENERICS: Class<T> indicates that this class will only consist of a generic dataType
    private ArrayList<T> customers;

    // ! OOP CONSTRUCTOR that initializes the class fields on class object instantiation
    public FinancialBranch(String name) {
        this.name = name;

        // default values
        this.customers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "FinancialBranch{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    // ! ACCESS-MODIFIER private: accessibility to the variable or method is limited to the scope of the defining class and subclasses within a package
    protected boolean newCustomer(String name, double initialTransaction) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(name.isEmpty() || initialTransaction < 0 || findCustomer(name.trim()) != null) return false;

        // implied else-statement
        int totalCustomers = this.customers.size() + 1;
        FinancialCustomer customer = new FinancialCustomer(name.trim());
        customer.addCustomerTransaction(initialTransaction);

        // ? GENERICS: since Java won't know until compile dataType for GENERIC CLASS parameter T, cast dataType to avoid any errors in this scenario
        this.customers.add((T) customer);

        return this.customers.size() == totalCustomers;
    }

    public boolean addCustomerTransaction(String name, double amount) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(name.isEmpty() || amount < 0) return false;

        T customer = findCustomer(name.trim());
        if(customer == null) return false;

        int totalTransactions = customer.getTransactions().size() + 1;
        customer.addCustomerTransaction(amount);

        return totalTransactions == customer.getTransactions().size();
    }

    private T findCustomer(String name) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(name.isEmpty()) return null;

        for(int i = 0; i < this.customers.size(); i++) {
            T customer = this.customers.get(i);
            if(name.trim().equals(customer.getName())) return customer;
        }
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public ArrayList<T> getCustomers() {
        return customers;
    }
}

class FinancialBank {

    private String name;
    private ArrayList<FinancialBranch> branches;

    public FinancialBank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }


    public boolean addBranch(String branchName) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(branchName.isEmpty() || findBranch(branchName.trim()) != null) return false;

        int expectedSize = this.branches.size() + 1;
        this.branches.add(new FinancialBranch(branchName.trim()));
        return this.branches.size() == expectedSize;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(branchName.isEmpty()) return false;

        FinancialBranch branch = findBranch(branchName.trim());

        if(branch == null) return false;

        ArrayList<FinancialCustomer> customers = branch.getCustomers();

        for (FinancialCustomer c : customers) {
            if(printTransactions) {
                System.out.println(c.getName() + c.getTransactions());
            }
            System.out.println(c.getName());
        }
        return true;
    }

    private FinancialBranch findBranch(String name) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(name.isEmpty()) return null;

        for(int i = 0; i < this.branches.size(); i++) {

            FinancialBranch branch = this.branches.get(i);
            if(name.equals(branch.getName())) return branch;

        }
        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<FinancialBranch> getBranches() {
        return branches;
    }
}

/*
    create LargestPrime class

    define getLargestPrime() with int parameter named 'number'

        should calculate the largest prime factor of a given number and return it

        return -1 if number is negative or does NOT have any prime numbers

    * HINT: since 0 and 1 are not considered prime numbers, they cannot contain prime numbers
 */

// ! INTERFACE + OOP POLYMORPHISM: for standardization, must uniquely implement/@Override all publicly-shared method signatures for designated classes
interface IPrime {
    Integer getLargestPrime(int number);
}

// ! ABSTRACT CLASSES: enforce OOP INHERITANCE of class fields & OOP POLYMORPHISM public methods
abstract class AbstractPrime implements IPrime {

    // ! OOP ENCAPSULATION: use access-modifiers to guard class functionally against inappropriate external access
    private String errorMsg;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public AbstractPrime(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    abstract public boolean validateArgs(int n);
}

class LargestPrime extends AbstractPrime {

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public LargestPrime(String errorMsg) {
        // ! OOP INHERITANCE: child subclass that inherits public class fields & methods from an extending parent super class
        super(errorMsg);
    }

    // CLASS METHODS: unique object behavior
    @Override
    public boolean validateArgs(int n) {
        return n < 0;
    }

    @Override
    public Integer getLargestPrime(int number) {

        if(validateArgs(number)) return -1;

        int largestPrimeFactor = 2;

        while(largestPrimeFactor < (number/2)) {

            boolean isDivisibleFactor = number % largestPrimeFactor == 0;

            if(isDivisibleFactor) {
                number /= largestPrimeFactor;
            } else {
                largestPrimeFactor++;
            }
        }
        return number;
    }
}

/*
    ? create a base class called Car that has attributes:
        engine, cylinder, name, wheels

    ? define a constructor that only has 2 passed parameters
        initialize cylinders(number of), name, set wheels to 4, and engine to true

    ? define getters & setters

    ? create methods: show a msg for each in the base class

        startEngine, accelerate, and brake

    ? create 3 subclasses for your favorite vehicles

    * use INTERFACES, ABSTRACTION, OOP, GENERICS, BOXING

    ! INTERFACES VS ABSTRACT CLASSES

        ABSTRACT CLASSES can have class fields/object instance members AND define abstract publicly-shared signatures

        * CANNOT instantiate an ABSTRACT CLASS, must use a normal class that inherits from ABSTRACT CLASS for instantiation

        INTERFACES can ONLY define publicly-shared signatures
 */

// ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared method signatures for designated standardized set of classes
interface IDrive {

    boolean accelerate(Integer speed);
    boolean brake(Integer speed);
}

// ! ABSTRACTION: enforce standardization via OOP INHERITANCE via OOP POLYMORPHISM for designated classes
abstract class AbstractTransportation implements IDrive {

    private static final String CURRENT_SPEED = "Current speed: ";

    // private class fields
    private int speed;
    private int wheels;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public AbstractTransportation(int wheels) {
        this.speed = 0;
        this.wheels = wheels;
    }

    // CLASS METHODS: unique object behavior
    abstract boolean startEngine();

    @Override
    public boolean accelerate(Integer speed) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(speed <= 0) return false;

        int currentSpeed = this.speed;

        // ! UNBOXING: casting higher functional Wrapper class dataType -> primitive dataType
        this.speed += speed;
        System.out.println(CURRENT_SPEED + getSpeed());
        return this.speed > currentSpeed;
    }

    @Override
    public boolean brake(Integer speed) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(speed <= 0 || this.speed <= 0) return false;

        int currentSpeed = this.speed;

        if(currentSpeed - speed < 0) {
            this.speed = 0;
        } else {
            // ! UNBOXING: casting higher functional Wrapper class dataType -> primitive dataType
            this.speed -= speed;
        }

        System.out.println(CURRENT_SPEED + getSpeed());
        return true;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWheels() {
        return wheels;
    }

    // ! INNER CLASS + OOP COMPOSITION: logically grouped class components with a parent super class
    // ! ACCESS-MODIFIER protected: accessibility to class variables & methods are limited to scope of the defining class and it's subclasses with a package
    protected class Engine {

        // OOP ENCAPSULATION class fields
        private boolean isOn;

        public Engine() {
            this.isOn = false;
        }

        public void setPower(boolean isOn) {
            this.isOn = isOn;
        }

        public boolean isOn() {
            return isOn;
        }
    }
}

class TransportationCar extends AbstractTransportation {

    // ! CONSTANTS/static class fields assigned FINAL value before compilation/instantiation
    // ! STATIC: class variable saved in a single space in memory and used across entire app
    // ! ACCESS-MODIFIER private: accessibility to class variables and methods limited to the SCOPE of the defining class
    private static final String STOPPED = "The vehicle is at a complete stop";

    // ! OOP ENCAPSULATION: use access-modifiers to guard the class from inappropriate external access & use
    // private class fields
    private final int cylinders;
    // ! INNER CLASS + OOP COMPOSITION: logically grouped class components with a parent super class
    private Engine engine;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public TransportationCar(int wheels, int cylinders) {
        // ! OOP INHERITANCE: child subclass is given access to public class fields & methods from an extending parent super class
        super(wheels);

        this.cylinders = cylinders;

        // default values
        this.engine = new Engine();
    }

    // CLASS METHODS: unique class behavior
    @Override
    public boolean startEngine() {
        this.engine.setPower(true);
        return this.engine.isOn();
    }

    // OOP GETTERS & SETTERS
    public int getCylinders() {
        return cylinders;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}

/*
    create a Printer class that uses ENCAPSULATION: enables restricting accessing components
            !READ: protect object instance members/class fields from external access for direct inappropriate update

        Printer class fields: tonerLevel, numPages, isDuplexPrinter (cap both-side printing)

        Printer methods:
                    set toner level up to a max 100%
                    printPage() which increases the number of pages printed

    ! Big(O) Notation: independent of hardware, an algorithm's TIME COMPLEXITY (the worst-case number of steps required to execute successfully) and SPACE COMPLEXITY (the total memory space required by the algorithm's input size plus the extra space or temporary space used by an algorithm -- AUXILIARY SPACE).

    * Big(O) best-to-west Types

        O(1) CONSTANT time complexity: O of 1

        O(logn) LOGARITHMIC time complexity: O of log n w/ a base of 2

        O(n) LINEAR time complexity: O of n

        O(nlogn) LOGLINEAR time complexity: O of n log n

        O(n^2) QUADRATIC time complexity: O of n-squared

    ! RECURSION: a continuously self-calling algorithm & each call on the call-stack waits for the algorithm to reach the base case/breaking condition for a return value.

    * RECURSIVE BASE CASE: reaching the breaking condition that initiates an upward propagation of return values for the waiting calls that results in a call-stack resolution or overflow

    * RECURSION + DIVIDE & CONQUER:

        recursively divide the original problem into 2 or more sub-problems & repeat until the sub-problems become small enough to solve a base case

        after solving the base case/breaking condition, combine the solutions to construct the overall solution to the original problem
*/

// ! INTERFACE + OOP POLYMORPHISM: all publicly-shared method signatures must be uniquely implemented/@Override by designated standardized classes
interface IPrint {
    int printPage();
}

// ! ABSTRACT CLASSES: enforce OOP INHERITANCE of super class fields & public methods & OOP POLYMORPHISM for MANDATORY designated standardized classes
abstract class AbstractEquipment implements IPrint {

    // ! OOP ENCAPSULATION: use access-modifiers to guard class from inappropriate external access
    // private class fields
    private int numPages;

    // ! OOP CONSTRUCTOR that initializes the class fields on class/object instantiation
    public AbstractEquipment() {
        this.numPages = 0;
    }

    // CLASS METHODS: unique object behavior
    abstract void setTonerLevel(int amount);

    // OOP GETTERS & SETTERS
    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}

class Printer extends AbstractEquipment {

    // ! CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String TONER_LEVEL = "The current toner level: ";

    // private class fields
    private final boolean isDuplexPrinter;
    private int tonerLevel;

    public Printer(boolean isDuplexPrinter) {
        this.isDuplexPrinter = isDuplexPrinter;
        this.tonerLevel = 0;
    }

    void setTonerLevel(int amount) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exception
        if(amount <= 0) return;

        int newAmount = this.getTonerLevel() + amount;

        this.tonerLevel = Math.min(newAmount, 100);
        System.out.println(TONER_LEVEL + this.getTonerLevel());
    }

    @Override
    public int printPage() {

        // ! AUTOBOXING: casting primitive dataType -> greater functionality Wrapper class dataType
        Integer updatedPageCount = this.isDuplexPrinter ?
                this.getNumPages() + 2 : this.getNumPages() + 1;

        this.setNumPages(updatedPageCount);
        return this.getNumPages();
    }

    public boolean isDuplexPrinter() {
        return isDuplexPrinter;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }
}

/*
    ? define a SinglyIntegerNode class

    ? define a SinglyIntegerLinkedList class

    ? in a singly linkedList, implement insertSorted() method in the SinglyIntegerLinkedList class that inserts a value in sorted order

        HEAD -> lowest-to-highest -> TAIL

    * ex)
        input values 4, 2, 1, 5
        output: HEAD -> 1 -> 2 -> 4 -> 5 -> null

    ? define a DoublyIntegerNode class

    ? define a DoublyIntegerLinkedList class

    ? in a doubly linkedList, implement insertSorted() method in the DoublyIntegerLinkedList class that inserts a value in sorted order

    ! use a SORT ALGORITHM, OOP, INTERFACES, ABSTRACTION, GENERICS, BOXING
 */

// ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared method signatures for standardized set of classes
interface ILinkedList {

    void add(Integer n);
}

// ! ABSTRACT CLASSES: enforce standardization of class fields, public methods, & method signatures via OOP INHERITANCE & OOP POLYMORPHISM for MANDATORY set of subclasses
abstract class AbstractLinkedList implements ILinkedList {

    // ! OOP ENCAPSULATION: use access-modifiers to guard class from inappropriate external access
    // ! ACCESS-MODIFIER private: accessibility of class fields & methods limited to the SCOPE of the defining class
    // private class fields
    private SinglyIntegerNode head;
    private int size;
    private String type;

    // ! OOP CONSTRUCTOR that initializes the class fields & INTRINSIC LOCK on class/object instantiation
    public AbstractLinkedList(String type) {
        this.type = type;

        // default values
        this.head = null;
        this.size = 0;
    }

    // CLASS METHODS: unique object behavior
    abstract SinglyIntegerNode pop();

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SinglyIntegerNode getHead() {
        return head;
    }

    public void setHead(SinglyIntegerNode head) {
        this.head = head;
    }

    // ! INNER CLASS: logically grouped class components within a parent class
    // ! ACCESS-MODIFIER protected: accessibility of class fields & methods limited to the SCOPE of the defining class and it's subclasses within the package
    protected class SinglyIntegerNode {

        private Integer data;
        private SinglyIntegerNode next;

        public SinglyIntegerNode(Integer data) {
            // ! UNBOXING: casting higher functionality Wrapper class dataType to primitive dataType
            this.data = data;

            // default values
            this.next = null;
        }

        // CLASS METHODS: unique object behavior
        @Override
        public String toString() {
            return "SinglyIntegerNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        // OOP GETTERS & SETTERS
        public Integer getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public SinglyIntegerNode getNext() {
            return next;
        }

        public void setNext(SinglyIntegerNode next) {
            this.next = next;
        }
    }
}

class SinglyLinkedList extends AbstractLinkedList {

    public SinglyLinkedList(String type) {
        // ! OOP INHERITANCE: child subclass inherits public class fields & public methods from an extending parent super class
        super(type);
    }

    /*
        ! Big(O) Notation: independent of hardware, an algorithm's worst-case performance (TIME & SPACE COMPLEXITY)

        ! TIME COMPLEXITY: independent of hardware, the wost case number of steps required for an algorithm to successfully complete
            * O(n^2) quadratic time complexity = O of n-squared = worst
        ! SPACE COMPLEXITY: the total memory space required by the algorithm's input size plus the extra space or temporary space used by an algorithm (AUXILIARY SPACE)
            * in-place algorithm that doesn't use extra memory
        ! STABLE ALGORITHM: if there are duplicates, the original order will be preserved
            * the search for insertion value position stops when you find a sorted value that is less than or equal

        ! INSERTION SORT LOGIC:

            break the array into 2 partitions: sorted & unsorted

                sorted partition of 1 element array index 0

                unsorted partition starting at index 1

            the inserting work is done in the SORTED partition where there is no swapping, the elements shift

                ? STEP 1
                take first element in the unsorted partition (index 1) and save it,
                and then "insert" it into the sorted partition via comp

                ? STEP 2
                by comparing if it is greater than or equal to the value in the sorted partition

                if sorted partition value is less than or equal to the unsorted inserting value,
                    than the inserting value is inserted at the index above the sorted partition value

                if the sorted partition value is greater than the unsorted inserting value,
                    than you shift the sorted partition value up 1
                    next, compare unsorted inserting value to the next decremented index value

                you repeat this process until you find the correct index for the unsorted inserting value, or you reach the beginning of the array (index 0)

               ? STEP 3
                after the comparison(s) & inserting of the unsorted inserting value,
                    GAP VALUE 1 = the sorted partition is grown by 1 and the index in the unsorted partition is incremented by 1

                repeat this process until the entire array is sorted
     */
    public void insertSorted(Integer value) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to catch exceptions
        if(value == null) {
            return;
        }

        // assuming the list is sorted, add value to front if it is empty
        if(this.isEmpty() || this.getHead().getData() >= value) {
            add(value);
            return;
        }

        // find the insertion point
        SinglyIntegerNode currentNode = this.getHead().getNext();
        SinglyIntegerNode previousNode = this.getHead();

        while(currentNode != null && currentNode.getData() < value) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        SinglyIntegerNode newNode = new SinglyIntegerNode(value);

        // set newNode BEFORE currentNode
        newNode.setNext(currentNode);

        // set newNode as previousNode's next
        previousNode.setNext(newNode);

        int incrementedSize = this.getSize() + 1;
        this.setSize(incrementedSize);
    }

    @Override
    public void add(Integer n) {

        if(n == null) return;

        SinglyIntegerNode node = new SinglyIntegerNode(n);

        node.setNext(this.getHead());

        this.setHead(node);
        this.setSize(this.getSize() + 1);
    }

    @Override
    SinglyIntegerNode pop() {

        if(this.isEmpty()) return null;

        SinglyIntegerNode removedNode = this.getHead();

        this.setHead(this.getHead().getNext());

        removedNode.setNext(null);
        this.setSize(this.getSize() - 1);

        return removedNode;
    }
}

/*
    write a class FirstLastDigitSum
    write the method sumFirstAndLastDigit with 1 int parameter called number
        returns -1 if param is negative

        the method needs to find the first and last digit of the parameter number passed to the method
        use a loop and return the sum of the first and last digit
 */
class FirstLastDigitSum {

    // ! STATIC: class variable saved in a single space in memory and used across entire applicaiton
    public static int sumFirstAndLastDigit(int number) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exceptions
        if(number < 0) return -1;

        int lastDigit = number % 10;

        while(number > 10) {
            number /= 10;
        }

        return number + lastDigit;
    }
}

/*
    write a class LastDigitChecker
    write the method hasSameLastDigit with 3 int parameters
        each parameter should within 10-1000 inclusive
        returns false if one of the parameters is out of range

    if at least 2 of the 3 numbers share the rightmost digit,
        otherwise return false
 */
class LastDigitChecker {
    public static boolean hasSameLastDigit(int a, int b, int c) {

        // ! EXCEPTION HANDLING look before you leap: use if-else statement to handle exceptions
        if(!inRange(a) || !inRange(b) || !inRange(c)) return false;

        int counter = 0;
        counter = checker(a, b, counter);
        counter = checker(a, c, counter);
        counter = checker(b, c, counter);

        return counter >= 1;
    }

    private static int checker(int a, int b, int counter) {
        if(a % 10 == b % 10) counter++;
        return counter;
    }

    private static boolean inRange(int n) {
        return n >= 10 && n <= 1000;
    }
}

/*
    write a class FlourPacker

    write the method canPack with 3 int parameters
        if params are negative, return false;

            bigCount: big flour bags (5 kilos each)
            smallCount: small flour bags (1 kilo each)
            goal: goal amount of kilos of flour needed to assemble a package

        returns true
            if bigCount + smallCount must at least equal to the value of the goal

            if sum is greater than the goal, ensure only full bags are used toward the goal amount
                okay, if there are additional bags left over

                ex: goal = 9, bigCount = 2, smallCount = 0
                    should return false since each big bag is 5 kilos and cannot be divided

                ex: goal = 9, bigCount = 1, smallCount = 5
                    should return true since each big bag is 1 full bigCount bag and 4 full smallCount bags = goal

         ? Interfaces vs Abstract Classes

            ABSTRACT CLASSES can have class fields/object instance members inherited AND define abstract publicly-shared signatures

            INTERFACES can ONLY define publicly-shared signatures

                interfaces can have essentially-constant variables defined as "public static final"
 */
// ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared method signatures for designated set of classes for standardization
interface IPacker {
    boolean canPack(int a, int b, int c);
}

// ! ABSTRACT CLASSES: enforce child subclass via OOP INHERITANCE + OOP POLYMORPHISM for mandatory class instances
abstract class AbstractPacker implements IPacker {

    @Override
    public boolean canPack(int bigCount, int smallCount, int goal) {

        if(!validParameter(bigCount) || !validParameter(smallCount) || !validParameter(goal)) return false;

        boolean hasFullBag;
        int sum;

        boolean bigCountNotApplicable = goal < 5;
        int convertedBigCount = bigCount * 5;
        int convertedBigRemainder = convertedBigCount % 5;

        boolean bigCountDivisibleBy5 = convertedBigCount % 5 == 0;

        if(bigCountNotApplicable) {

            hasFullBag = (smallCount >= goal);

        } else if(bigCountDivisibleBy5) {

            boolean bigGreaterThanGoal = convertedBigCount > goal;

            if(bigGreaterThanGoal) {
                convertedBigCount = (goal / 5) * 5;
            }

            sum = convertedBigCount + smallCount;
            hasFullBag = sum >= goal;

        } else {

            // divBy5 convertedBigCount with remainder
            sum = (convertedBigCount - convertedBigRemainder) + smallCount;
            hasFullBag = (sum >= goal);
        }
        return hasFullBag;
    }

    // ! ACCESS-MODIFIER protected: accessibility to the public class variables or methods limited to the scope of the defining class & subclasses within the package
    protected boolean validParameter(int a) {
        return a >= 0;
    }
}

class FlourPacker extends AbstractPacker {
    public FlourPacker() {}
}
