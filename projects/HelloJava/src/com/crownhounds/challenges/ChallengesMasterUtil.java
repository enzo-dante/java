package com.crownhounds.challenges;

import com.crownhounds.masterjava.Util;

import java.util.*;

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

class NumberToWords extends ChallengesMasterUtil{

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation

    // OOP ENCAPSULATION private class fields
    private static Map<Integer, String> nums = new HashMap<>();

    // ! STATIC: single class instance method shared in memory
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
    private static final String GROCERY_LIST = "\nGrocery list\n".toUpperCase();
    private static final String EMPTY_GROCERY_LIST = "There are currently no items on your grocery list";
    public static final String ITEM_NOT_FOUND = "Query for item failed";
    private static final String INSTRUCTIONS = GROCERY_LIST + "0 - print instructions\n" +
            "1 - read grocery list\n" +
            "2 - add item\n" +
            "3 - delete item\n" +
            "4 - update item\n" +
            "5 - quit";
    private static final String ENTER_CHOICE = "Enter your choice:\n";
    private static final String SHUTDOWN = "Shutting down now....";

    private Scanner scanner;

    public void run() {

        scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        boolean quit = false;
        boolean exit = false;

        System.out.println(INSTRUCTIONS);

        while(!quit) {

            exit = false;
            System.out.println(ENTER_CHOICE);

            if(scanner.hasNextInt()) {

                int choice = scanner.nextInt();

                // handle enter keydown
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
                            System.out.println(ENTER_CHOICE);

                            if(scanner.hasNextLine()) {

                                String input = scanner.nextLine();
                                input = input.trim().toLowerCase();

                                if(input.equals("-1") || input.equals("q")) {
                                    exit = true;
                                    break;
                                }
                                addItem(list, input);
                                exit = true;
                            } else {
                                System.out.println(INVALID_VALUE);
                                scanner = new Scanner(System.in);
                            }
                        }
                        printInstructions();
                        break;
                    case 3:
                        // delete
                        break;
                    case 4:
                        // update
                        System.out.println("\nPlease enter a valid value");
                        break;
                    case 5:
                        quit = true;
                        System.out.println(SHUTDOWN);
                        break;
                    default:
                        printInstructions();
                        break;
                }
            } else {
                printInstructions();
                System.out.println(INVALID_VALUE);
                scanner = new Scanner(System.in);
            }
        }
    }

    private String formatInput(String input) {
        return input.toLowerCase().trim();
    }

    public boolean addItem(List<String> list, String newItem) {

        String formatItem = newItem.toLowerCase().trim();

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

        if(invalidArgs(list, index)) return false;

        // ! O(1) constant TIME COMPLEXITY: array get() w/ index
        list.set(index, updateItem.toLowerCase());
        readGroceryList(list);
        return true;
    }

    public boolean deleteItem(List<String> list, int index) {

        if(invalidArgs(list, index)) {
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

        if(invalidArgs(list, index)) return INVALID_VALUE;

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

    private boolean invalidArgs(List<String> list, int index) {
        if(list.isEmpty() ||
                (index < 0 || index >= list.size())) {
            return true;
        }
        System.out.println(INVALID_VALUE);
        return false;
    }

    private void printInstructions() {
        System.out.println("-----------");
        System.out.println(INSTRUCTIONS);
        System.out.println("-----------");
    }

}