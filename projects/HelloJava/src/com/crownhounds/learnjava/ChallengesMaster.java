package com.crownhounds.learnjava;

import java.util.ArrayList;
import java.util.LinkedList;

public class ChallengesMaster {

    public static void main(String[] args) {

//        areaCalculatorChallenge();
//        playlistChallenge();
//        speedConverterChallenge();
        numberToWordsChallenge();
    }

    /**
     * ? Write a class called AreaCalculator
     *
     * ? Write a method called area with 1 double parameter named radius
     *      return -1 if radius is negative
     *      return a double value that represents the area of a circle
     *
     * * area_circle = radius * radius * Math.PI
     *
     * ? Write an overloaded method with 2 parameters x & y (both doubles & a side of a rectangle)
     *      return -1 if either or both parameters are negative
     *      the method returns the area of a rectangle
     *
     * * area_rectangle = x * y
     */
    private static void areaCalculatorChallenge() {
        AreaCalculator areaCalculator = new AreaCalculator();

        // ! AUTOBOXING: converting primitive dataType -> Wrapper Class dataType functionality
        Double areaRadius = areaCalculator.area(10d);
        System.out.println("radius: " + areaRadius);

        Double areaRectangle = areaCalculator.area(7d, 2d);
        System.out.println("rectangle: " + areaRectangle);
    }

    /**
     * ? a program that implements a playlist of songs
     *
     * ? Album
     * has 3 fields: String name, String artist, Arraylist songs
     * constructor Album(String album, String artist) & instantiates songs
     * 3 methods:
     *      addSong(String title, double duration) returns true if successfully added song
     *      findSong(String title) returns Song or null
     *      addToPlaylist(int track, LinkedList<Song> playlist) returns true if exists and added via track number of song in album
     *      addToPlaylist(String title, LinkedList<Song> playlist) returns true if exists and added via track number of song in album
     *
     * ? Song
     * has 2 fields: String title, double duration
     * constructor Song(String title, double duration)
     * 2 methods:
     *      getTitle()
     *      toString() Song's overrides toString method returns
     *          "title: duration"
     *
     * * TIP: use method overloaded:
     * same-name method with unique parameters that optimize code readability/scalability
     *
     * * TIP: use OOP + Composition
     * start with Song since least common denominator
     *
     * * TIP: In Album, use the findSong() method in addSong() and addToPlayList(String, LinkedList) to check if a song exists before proceeding.
     *
     * * TIP: use ENCAPSULATION, protect object instance members/class fields from external access for direct inappropriate update
     * All fields are private.
     * All methods are public (except for findSong() which is private).
     * There are no static members.
     */
    private static void playlistChallenge() {

        // ! GENERICS CLASS: improve ENCAPSULATION by enforcing specific dataType parameter
        ArrayList<PlayList.Album> albums = new ArrayList<PlayList.Album>();

        PlayList playList = new PlayList();

        PlayList.Album album;

        album = playList.new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love Doesn't Mean a Thing", 4.22);
        album.addSong("Holy Man", 4.3);
        albums.add(album);

        album = playList.new Album("For Those About to Rock", "AC/DC");
        album.addSong("For Those About to Rock", 5.44);
        album.addSong("I Put the Finger on You", 3.25);
        album.addSong("Lets Go", 3.45);
        albums.add(album);

        LinkedList<PlayList.Song> songLinkedList = new LinkedList<PlayList.Song>();

        albums.get(0).addToPlayList("Holy Man", songLinkedList);
        albums.get(1).addToPlayList("Lets Go", songLinkedList);

        albums.get(0).addToPlayList(1, songLinkedList);
        albums.get(1).addToPlayList(2, songLinkedList);

        albums.get(0).addToPlayList("Speed King", songLinkedList); // does not exist
        albums.get(1).addToPlayList(7, songLinkedList); // does not exist

        Util.printSeparator();

        playList.play(songLinkedList);

    }
        /*
            0. Write a speed converter class

            1. Write a method called toMilesPerHour that has 1 parameter of type double with the name kilometersPerHour.
                This method needs to return the rounded value of the calculation of type long

                If the parameter kilometersPerHour is less than 0,
                    the method toMilesPerHour needs to return -1 to indicate an invalid value.

                Otherwise, if kilometersPerHour is positive,
                    calculate the value of miles per hour, round it and return it.

                    NOTE: 1.609 kilometers per hour is 1 mile per hour

                        milesPerHour = kilometersPerHour / 1.609

                    Use method Math.round to round the number of calculated miles per hour(double). The method round returns long.

                        The Math.round() is a built-in math method which returns the closest long to the argument.
                        The result is rounded to an integer by adding 1/2, taking the floor of the result after adding 1/2, and typecasting the result to type long.

                        The method returns the value of the argument rounded to the nearest int value.

            2. Write another method called printConversion with 1 parameter of type double with the name kilometersPerHour.

                This method should not return anything (void) and it needs to calculate milesPerHour from the kilometersPerHour parameter.
                    Then it needs to print a message in the format "XX km/h = YY mi/h".
                        XX represents the original value kilometersPerHour.
                        YY represents the rounded milesPerHour from the kilometersPerHour parameter.

                If the parameter kilometersPerHour is < 0 then print the text "Invalid Value"
         */

    /**
     * ? Write a speed converter class
     *
     * ? Write a method called toMilesPerHour that has 1 parameter of type double with the name kilometersPerHour.
     *     This method needs to return the rounded value of the calculation of type long
     *
     *     If the parameter kilometersPerHour is less than 0,
     *         the method toMilesPerHour needs to return -1 to indicate an invalid value.
     *
     *     Otherwise, if kilometersPerHour is positive,
     *         calculate the value of miles per hour, round it and return it.
     *
     *         NOTE: 1.609 kilometers per hour is 1 mile per hour
     *
     *             milesPerHour = kilometersPerHour / 1.609
     *
     *         Use method Math.round to round the number of calculated miles per hour(double). The method round returns long.
     *
     *             The Math.round() is a built-in math method which returns the closest long to the argument.
     *             The result is rounded to an integer by adding 1/2, taking the floor of the result after adding 1/2, and typecasting the result to type long.
     *
     *             The method returns the value of the argument rounded to the nearest int value.
     *
     * ? Write another method called printConversion with 1 parameter of type double with the name kilometersPerHour.
     *     This method should not return anything (void) and it needs to calculate milesPerHour from the kilometersPerHour parameter.
     *
     *         Then it needs to print a message in the format "XX km/h = YY mi/h".
     *             XX represents the original value kilometersPerHour.
     *             YY represents the rounded milesPerHour from the kilometersPerHour parameter.
     *
     *     If the parameter kilometersPerHour is < 0 then print the text "Invalid Value"
     */
    private static void speedConverterChallenge() {
        SpeedConverter speedConverter = new SpeedConverter();
        speedConverter.printConversion(8);
        speedConverter.printConversion(-44);
    }
    /**
     * ? Write a NumberToWords class
     *
     * ? Write a method called numberToWords that has 1 parameter of type int with the name number.
     *     This method should print out the passed number using words for the digits
     *          Extract the last digit of the given number using the remainder operator.
     *          Convert the value of the digit found in Step 1 into a word. There are 10 possible values for that digit, those being 0, 1, 2, 3, 4, 5, 6, 7, 8, 9. Print the corresponding word for each digit, e.g. print "Zero" if the digit is 0, "One" if the digit is 1, and so on.
     *          Remove the last digit from the number.
     *          Repeat Steps 2 through 4 until the number is 0.
     *
     *     if the number is negative, print "Invalid Value"
     *
     * ? Write a method called reverse that has 1 parameter of type int with the name number.
     *     This method should return the reversed number and any negatives
     *
     * ? Write a method called getDigitCount that has 1 parameter of type int with the name number.
     *     This method should return the count of the digits in that number
     *     if number is negative, return -1
     *
     * ? use reverse in numberToWords
     */
    private static void numberToWordsChallenge() {

        NumberToWords.numberToWords(123);
        NumberToWords.numberToWords(1010);
        NumberToWords.numberToWords(1000);
        NumberToWords.numberToWords(-12);
    }

    /**
     * ? Create an abstract class to define items that can be stored in a tree.
     *
     * ? ListItem (abstract class)
     * It has three protected fields. Two ListItems called rightLink and leftLink, and an Object called value.
     *      A constructor that takes an Object and initialises the field value with the parameter that was passed in.
     *
     * seven methods:
     *      next(), setNext(), previous(), setPrevious() and compareTo() which are package-private and abstract (see child class for declaration).
     *      getValue(), takes no parameters and returns its value.
     *      setValue(), takes an Object and assigns it to value.
     *
     * ? Node (concrete class)
     * It extends ListItem.
     *      It has a constructor that takes an Object, then calls its parent constructor with the parameter that was passed in.
     *
     * five methods which are package-private:
     *      next(), takes no parameters and returns the ListItem to its right.
     *      setNext(), takes a ListItem and sets it as its rightLink, then it returns rightLink.
     *      previous(), takes no parameters and returns the ListItem to its left.
     *      setPrevious(), takes a ListItem and sets it as its leftLink, then it returns leftLink.
     *      compareTo(), takes a ListItem and compares it to the ListItem that called this method. Use value from ListItem for comparison. If this value is greater than the value that was passed in, then it should return a number greater than zero. If vice versa, then it should return a number less than zero, and zero if equal.
     *
     * ? MyLinkedList (concrete class)
     * It implements NodeList.
     *      It has one field of type ListItem called root.
     *      A constructor that takes a ListItem and initialises the field root with the newly passed in parameter.
     *
     * And four methods:
     *     getRoot(), getter for root.
     *     addItem(), takes a ListItem and returns true if it was added successfully or false otherwise. If the item is already present, it doesn't get added. Use compareTo() to place the item in its proper order.
     *     removeItem(), takes a ListItem and returns true if it was removed successfully or false otherwise.
     *     traverse(), takes the root as an argument and does not return anything. If the root is null it prints out: The list is empty, otherwise print each value on a separate line.
     *
     * ? NodeList (interface)
     * It has four methods:
     *     getRoot(), addItem(), removeItem() and traverse() which are package-private and abstract (see child class for declaration).
     *
     * ? SearchTree (concrete class)
     * It implements NodeList.
     *      It has one field of type ListItem called root.
     *      A constructor that takes a ListItem and initialises the field root with the newly passed in parameter.
     *
     * And five methods:
     *      getRoot(), getter for root.
     *      addItem(), same as MyLinkedList.
     *      removeItem(), same as MyLinkedList.
     *      performRemoval(), takes two ListItems, the item to be removed and its parent. It doesn't return anything and is declared as private. Call this method from removeItem() when the item is found.
     *      traverse(), takes the root as an argument and does not return anything. It uses recursion to visit all the branches in the tree (Inorder). Print each value on a seperate line.
     *
     * * TIP: The rules for adding an item to the linked tree are:
     *      If the head of the tree is null, make the head refer to the item to be added.
     *      If the item to be added is less than the current item in the tree, add the item before the current item (i.e., make the previous item's "next" refer to the new item, and the new item's "next" refer to the current item).
     *      If the item to be added is greater than the current item, move onto the next item and compare again (if there is no next item, then that is where the new item belongs).
     *
     * * TIP: When adding items to a Binary Search Tree, if the item to be added is less than the current item - then move to the left.
     *     If it is greater than the current item - then move to the right.
     *     The new item is added when an attempt to move in the required direction would involve following a null reference.
     *     Once again, duplicates are not allowed.
     *
     * * TIP: Inorder = print the previous node, then the parent node, and then the next node (left -> node -> right).
     *
     * * TIP: Use ENCAPSULATION
     *      All fields are private (unless stated otherwise).
     *      All constructors are public.
     *      All methods are public (unless stated otherwise).
     */
    private static void abstractTreeClassChallenge() {


    }
}