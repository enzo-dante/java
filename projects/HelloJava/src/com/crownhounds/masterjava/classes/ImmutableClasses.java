package com.crownhounds.masterjava.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ImmutableClasses {
    /*
        ? Immutable classes and their instances improve ENCAPSULATION because they cannot be changed once they are created from external modification
            once a class instance has been created; it cannot be changed

        use:
            getters: modifiable copies & not main copy
            private access-modifier
            final keyword
            only use setters when necessary

     */

    public static void main(String[] args) {

        AdventureMapGame adventureMapGame = new AdventureMapGame();
        adventureMapGame.play();

    }

}

class AdventureMapGame {

    /*
    O = open direction
    X = closed direction

                      NORTH

             --------O FOREST
             |           O
             |           |
             |           |
             |           |
             O           O
            HILL O-----X ROAD O-----O BUILDING
             O           O
             |           |
             |           |
             |           |
             |           O
             --------X VALLEY
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String CANNOT_GO_DIRECTION = "You cannot go in that direction\n";
    private static final String AVAILABLE_EXITS = "\nAvailable exits: ";
    private static final String CHOICE = "\nChoice:";

    private static final int LOCATION_ID_0 = 0;
    private static final int LOCATION_ID_1 = 1;
    private static final int LOCATION_ID_2 = 2;
    private static final int LOCATION_ID_3 = 3;
    private static final int LOCATION_ID_4 = 4;
    private static final int LOCATION_ID_5 = 5;

    private static final String LOCATION_DESCRIPTION_0 = "In front of computer learning Java";
    private static final String LOCATION_DESCRIPTION_1 = "At the end of a road";
    private static final String LOCATION_DESCRIPTION_2 = "On top of a hill";
    private static final String LOCATION_DESCRIPTION_3 = "Somewhere inside a building";
    private static final String LOCATION_DESCRIPTION_4 = "In a valley beside a stream";
    private static final String LOCATION_DESCRIPTION_5 = "In the middle of a forest";

    private static final String DIRECTION_WEST = "W";
    private static final String DIRECTION_SOUTH = "S";
    private static final String DIRECTION_EAST = "E";
    private static final String DIRECTION_NORTH = "N";
    private static final String DIRECTION_QUIT = "Q";

    private static final String VOCAB_QUIT = "quit".toUpperCase();
    private static final String VOCAB_NORTH = "north".toUpperCase();
    private static final String VOCAB_SOUTH = "south".toUpperCase();
    private static final String VOCAB_WEST = "west".toUpperCase();
    private static final String VOCAB_EAST = "east".toUpperCase();

    // OOP ENCAPSULATION secure private class fields
    // ! MAP INTERFACE: collection of key-value pair implementations with 2 parameter GENERIC CLASS dataStructures: UNIQUE key & value
    // ! STATIC: single variable reference (blueprint associated) shared across memory
    private Map<Integer, Location> locations;
    private Map<String, String> vocabulary;

    // OOP constructor that initializes the class fields on class/object instantiation
    public AdventureMapGame() {
        // hashMap locations key-value = (Integer, LocationClass)
        this.locations = new HashMap<Integer, Location>();

        // add respective exits to each location
        Map<String, Integer> locationExits = new HashMap<String, Integer>();
//        this.locations.put(LOCATION_ID_0, new Location(LOCATION_ID_0, LOCATION_DESCRIPTION_0, locationExits));
        this.locations.put(LOCATION_ID_0, new Location(LOCATION_ID_0, LOCATION_DESCRIPTION_0, null));

        // road
        locationExits.put(DIRECTION_WEST, LOCATION_ID_2);
        locationExits.put(DIRECTION_EAST, LOCATION_ID_3);
        locationExits.put(DIRECTION_SOUTH, LOCATION_ID_4);
        locationExits.put(DIRECTION_NORTH, LOCATION_ID_5);
        this.locations.put(LOCATION_ID_1, new Location(LOCATION_ID_1, LOCATION_DESCRIPTION_1, locationExits));

        // hill
        locationExits = new HashMap<String, Integer>();
        locationExits.put(DIRECTION_NORTH, LOCATION_ID_5);
        this.locations.put(LOCATION_ID_2, new Location(LOCATION_ID_2, LOCATION_DESCRIPTION_2, locationExits));

        // building
        locationExits = new HashMap<String, Integer>();
        locationExits.put(DIRECTION_WEST, LOCATION_ID_1);
        this.locations.put(LOCATION_ID_3, new Location(LOCATION_ID_3, LOCATION_DESCRIPTION_3, locationExits));

        // valley
        locationExits = new HashMap<String, Integer>();
        locationExits.put(DIRECTION_WEST, LOCATION_ID_2);
        locationExits.put(DIRECTION_NORTH, LOCATION_ID_1);
        this.locations.put(LOCATION_ID_4, new Location(LOCATION_ID_4, LOCATION_DESCRIPTION_4, locationExits));

        // forest
        locationExits = new HashMap<String, Integer>();
        locationExits.put(DIRECTION_WEST, LOCATION_ID_2);
        locationExits.put(DIRECTION_SOUTH, LOCATION_ID_1);
        this.locations.put(LOCATION_ID_5, new Location(LOCATION_ID_5, LOCATION_DESCRIPTION_5, locationExits));

        // ! MAP INTERFACE: collection of key-value implementations w/ 2 parameter GENERIC CLASS dataStructures: unique_key & value
        vocabulary = new HashMap<String, String>();
        vocabulary.put(VOCAB_QUIT, DIRECTION_QUIT);
        vocabulary.put(VOCAB_NORTH, DIRECTION_NORTH);
        vocabulary.put(VOCAB_SOUTH, DIRECTION_SOUTH);
        vocabulary.put(VOCAB_EAST, DIRECTION_EAST);
        vocabulary.put(VOCAB_WEST, DIRECTION_WEST);
    }

    public void play() {

        Scanner scanner = new Scanner(System.in);
        int locationKey = LOCATION_ID_1;

        while(true) {

            String currentLocation = this.locations.get(locationKey).getDescription();
            System.out.println(currentLocation);

            if(locationKey == LOCATION_ID_0) {
                break;
            }

            // ! MAP INTERFACE: collection of key-value pair implementations with 2 parameter GENERIC CLASS dataStructures: UNIQUE key & value
            Map<String, Integer> exits = this.locations.get(locationKey).getExits();
            System.out.println(AVAILABLE_EXITS);

            StringBuilder options = new StringBuilder();

            for(String exit: exits.keySet()) {
                options.append(exit + ", ");
            }

            System.out.println(options.substring(0, options.length() - 2));

            System.out.println(CHOICE);

            String direction = scanner.nextLine().toUpperCase();

            if(direction.length() > 1) {
                String[] words = direction.split(" ");

                for(String word : words) {
                    if(this.vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                locationKey = exits.get(direction);

            } else {
                System.out.println(CANNOT_GO_DIRECTION);
                scanner = new Scanner(System.in);
            }
        }
    }

    // ! INNER CLASS + OOP COMPOSITION: default package-private parent class has logically grouped components within itself
    class Location {

        // OOP ENCAPSULATION: secure private class fields
        // ! FINAL: variable assigned a final value before compilation/instantiation
        private final Integer locationId;
        private final String description;

        // ! MAP INTERFACE: collection of key-value pair implementations with 2 parameter GENERIC CLASS dataStructures: UNIQUE key & value
        // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
        private final Map<String, Integer> exits;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Location(int locationId, String description, Map<String, Integer> exits) {
            this.description = description;

            // ! AUTOBOXING: converting primitive dataType -> Wrapper class dataType
            this.locationId = locationId;

            // handle null pointer exceptions
            if(exits != null) {
                // ! HASHMAP: collection of key-value pair implementations with 2 parameter GENERIC CLASS dataStructures: UNIQUE key & value
                // ? IMMUTABLE CLASSES & their instances improve ENCAPSULATION because they cannot be changed once they are created from external modification
                //      no need for addExit() since add all exits when Location is constructed on instantiation
                //      using a hashMap copy for the exits & not risking modifying the internal main map improves ENCAPSULATION
                this.exits = new HashMap<>(exits);
            } else {
                this.exits = new HashMap<>();
            }

            // ! MAP hashmapInstance.put(key, value) = add unique_key-value generics class pair into map collection
            // since every location will have this option to quit, add to constructor
            this.exits.put(DIRECTION_QUIT, LOCATION_ID_0);
        }

        // OOP CLASS METHODS: non-static unique object behavior

//        public void addExit(String direction, int locationId) {
//            this.exits.put(direction, locationId);
//        }

        // OOP GETTER & SETTERS
        public String getDescription() {
            return description;
        }

        public Map<String, Integer> getExits() {
            // ! GENERIC CLASS: enforce ENCAPSULATION by mandating specific dataType class parameters
            // ! MAP INTERFACE hashMap implementation: copy unique_key-value collection instance by pass into constructor of new hashMap instance
            // ? IMMUTABLE CLASSES & their instances improve ENCAPSULATION because they cannot be changed once they are created from external modification
            // using a hashMap copy for the exits & not risking modifying the internal main map improves ENCAPSULATION
            return new HashMap<String, Integer>(this.exits);
        }
    }
}