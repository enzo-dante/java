package com.crownhounds.learnjava;

import java.util.*;

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