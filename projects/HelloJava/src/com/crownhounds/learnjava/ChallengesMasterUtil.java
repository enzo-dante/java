package com.crownhounds.learnjava;

public class ChallengesMasterUtil {

    // CONSTANTS
    public static final String INVALID_INPUT = "Invalid input";

    public static void main(String[] args) {

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

/*
    ? Song & Album for Playlist
    ! Object-Oriented Programming (OOP): create a class object/blueprint
 */

class PlayList extends Challenge {

    // ENCAPSULATION private class fields

    // OOP constructor that initialize the class fields on class/object instantiation
    public PlayList() {
        super("PlayList Challenge");
    }

    /*
        ! non-static INNER CLASSES: need a base class instance to execute functionality

        ! OOP ENCAPSULATION: protect against improper use by limiting with access-modifier
     */
    public class Song {

        // OOP constructor that initialize the class fields on class/object instantiation
        public Song() {

        }
    }

    public class Album {

        // OOP constructor that initialize the class fields on class/object instantiation
        public Album() {

        }
    }
}