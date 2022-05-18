package com.crownhounds.learnjava;

public class ChallengesMaster {

    public static void main(String[] args) {

        playlistChallenge();
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

        PlayList playList = new PlayList();
        PlayList.Song song = playList.new Song();
        PlayList.Album album = playList.new Album();

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