package com.crownhounds.masterjava;

import java.util.ArrayList;

public class Generics {

    public static void main(String[] args) {
        /*
            ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
                GENERICS make identifying bugs/code breaks faster throughout lifecycle (preferably before prod runtime & in compile time)
                    subsequently cheaper to fix due to less resources being exhausted

            * BAD ex:
                class:
                    * ArrayList myIntegers

            * GOOD ex:
                parameter data type:
                    Integer wrapper class

                class:
                    * ArrayList<Integer> myIntegers

            ? GENERIC CLASSES: when using dataType parameter, extend dataType parameter with bounded restriction to validate only usage of specific dataType via '<T extends dataType>'
                on class instantiation, Java will automatically replace 'T' with provided dataType

                class Team<T extends Player> {

                }

            ? GENERIC CLASSES can pass an Interface as a Type parameter
                can extend only a single class via INHERITANCE, but multiple INTERFACES

                ! GENERIC CLASSES + INHERITANCE: enforce parent super-class first, then multiple interfaces
                Company = parent class
                IOrganization = Interface
                ISports = Interface

                class Team<T extends Company & IOrganization & ISports> {

                }

            ? INTERFACES can also utilize Type parameters

         */

        GenericsClassNotes generics = new GenericsClassNotes();
    }
}

// ! ABSTRACT CLASS + OOP INHERITANCE: implementing child subclass instances inherits class fields & methods from extending abstract parent super-class
class GenericsClassNotes extends Notes {

    // CONSTANTS
    private final String RANKINGS = "Rankings";

    // ENCAPSULATION private class fields

    // OOP constructor initializes the class fields on class/object instantiation
    public GenericsClassNotes() {
        super("Generics Class");
        getNotes();
    }

    // unique object behavior/non-static class methods

    // ! INTERFACES & ABSTRACT CLASSES: must implement all publicly-shared signatures acquired via OOP INHERITANCE
    public void getNotes() {

        ArrayList items = new ArrayList<>();

        items.add(1);
        items.add(2);
        items.add(3);

        /*
            ? GENERICS make identifying bugs/code breaks faster throughout lifecycle (preferably before prod runtime & in compile time)
            subsequently cheaper to fix due to less resources being exhausted

            ! GENERICS: by simply using ArrayList, no error will be thrown for 'items.add("test")' until runtime
         */

//        items.add("test");
        items.add(4);
        items.add(5);

        printDouble(items);

        Util.printSeparator();

        // ? GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
        ArrayList<Integer> integerItems = new ArrayList<Integer>();

        integerItems.add(7);
        integerItems.add(8);
        integerItems.add(9);

        printDouble(integerItems, true);

        Util.printSeparator();

        FootballPlayer joeFootballPlayer = new FootballPlayer("Joe");
        BaseballPlayer patBaseballPlayer = new BaseballPlayer("Pat");
        SoccerPlayer beckhamSoccerPlayer = new SoccerPlayer("Beckham");
        BasketballPlayer chrisBasketballPlayer = new BasketballPlayer("Chris");

        // phx suns is a basketball team, so you should not be able to add a football, baseball, or soccer player
        Team phxSunsBasketBallTeam = new Team("Phoenix Suns Basketball Team");
        phxSunsBasketBallTeam.addPlayer(joeFootballPlayer);
        phxSunsBasketBallTeam.addPlayer(patBaseballPlayer);
        phxSunsBasketBallTeam.addPlayer(beckhamSoccerPlayer);

        System.out.println(phxSunsBasketBallTeam.getName() + ": " + phxSunsBasketBallTeam.getNumPlayers());

        Util.printSeparator();

        // ? GENERICS: improve OOP ENCAPSULATION by allowing us to create classes, interfaces, & methods that only take specific DATA TYPES as parameters
        Team<FootballPlayer> saintsFootballTeam = new Team<>("New Orleans Saints Football Team");
        saintsFootballTeam.addPlayer(joeFootballPlayer);

        // ? GENERICS: compile errors due to dataType incongruent
//        saintsFootballTeam.addPlayer(patBaseballPlayer);
//        saintsFootballTeam.addPlayer(beckhamSoccerPlayer);

        System.out.println(saintsFootballTeam.getName() + ": " + saintsFootballTeam.getNumPlayers());

        Team<BaseballPlayer> yankeeBaseballTeam = new Team<>("NY Yankees Baseball Team");
        yankeeBaseballTeam.addPlayer(patBaseballPlayer);
        System.out.println(yankeeBaseballTeam.getName() + ": " + yankeeBaseballTeam.getNumPlayers());

        Util.printSeparator();

        // ? GENERIC CLASSES: when using Type parameter, extend Type parameter with bounded restriction to validate only usage of specific dataType via '<T extends dataType>'
//        Team<String> brokenTeam = new Team<>("Team<String> brokenTeam");
//        brokenTeam.addPlayer("BROKEN: Not a Player Class, but a String Class");
//        System.out.println(brokenTeam.getName() + ": " + brokenTeam.getNumPlayers());

        Util.printSeparator();

        Team<FootballPlayer> patriotsFootballTeam = new Team<>("New England Patriots Football Team");
        FootballPlayer susanFootballPlayer = new FootballPlayer("Susan");
        patriotsFootballTeam.addPlayer(susanFootballPlayer);

        System.out.println(patriotsFootballTeam.getName() + ": " + patriotsFootballTeam.getNumPlayers());

        patriotsFootballTeam.matchResult(saintsFootballTeam, 7, 14);

        Util.printSeparator();

        Team<FootballPlayer> ramsFootballTeam = new Team<>("LA Rams Football Team");
        FootballPlayer mikeFootballPlayer = new FootballPlayer("Mike");
        ramsFootballTeam.addPlayer(mikeFootballPlayer);

        System.out.println(ramsFootballTeam.getName() + ": " + ramsFootballTeam.getNumPlayers());

        ramsFootballTeam.matchResult(saintsFootballTeam, 21, 0);
        ramsFootballTeam.matchResult(patriotsFootballTeam, 10, 35);
        saintsFootballTeam.matchResult(ramsFootballTeam, 9, 28);

        Util.printSeparator();

        System.out.println(RANKINGS);
        System.out.println(patriotsFootballTeam.getName() + ": " + patriotsFootballTeam.ranking());
        System.out.println(saintsFootballTeam.getName() + ": " + saintsFootballTeam.ranking());
        System.out.println(ramsFootballTeam.getName() + ": " + ramsFootballTeam.ranking());

        System.out.println(saintsFootballTeam.compareTo(patriotsFootballTeam));
        System.out.println(patriotsFootballTeam.compareTo(ramsFootballTeam));
        System.out.println(ramsFootballTeam.compareTo(saintsFootballTeam));

    }

    /*
        ! METHOD OVERLOADING: optimize codebase readability & scalability by using same-name but with different parameter class methods
        ? GENERICS: not including a parametrized data type undermines OOP ENCAPSULATION

            ArrayList n --> ArrayList<Integer> n
     */
    private void printDouble(ArrayList n) {

        System.out.println(getClass().getSimpleName() + ".printDouble() was called");

        for(Object i: n) {

            // ! AUTOBOXING: converting primitive datatype -> Wrapper Class datatype w/ greater functionality
            System.out.println(i + " -> " + ((Integer) i * 2));
        }
    }

    // ? GENERICS: improve OOP ENCAPSULATION by allowing us to create classes, interfaces, & methods that take dataType parameter
    private void printDouble(ArrayList<Integer> n, boolean isTypeProtected) {

        System.out.println(getClass().getSimpleName() + ".printDouble(parametrizedType) was called");

        // ! UNBOXING: converting Wrapper Class datatype -> primitive datatype
        for(int i: n) {
            System.out.println(i + " -> " + (i * 2));
        }
    }

    // ! INTERFACES: force implementation of publicly-shared method signatures for a set of classes
    interface IPlay {

        // !INTERFACES: publicly-shared signatures, WITHOUT implementation
        String getName();
    }

    /*
        ! ABSTRACT CLASSES: force child subclass INHERITANCE of method, signatures, & parent super-class fields for a set of classes
           by mandating POLYMORPHISM method signatures to be defined in order to execute respectively-unique implementation
           CANNOT instantiate an ABSTRACT CLASS, must use a normal class that inherits from ABSTRACT CLASS for instantiation
     */
    abstract class Player implements IPlay {

        // ENCAPSULATION private class fields
        private String name;

        // OOP constructor that initialized the class fields on class/object instantiation
        public Player(String name) {
            this.name = name;
        }

        // getters & setters
        public String getName() {
            return name;
        }
    }

    // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
    public class BaseballPlayer extends Player {

        // ENCAPSULATION private class fields

        // OOP constructor that initializes the class fields on class/object instantiation
        public BaseballPlayer(String name) {
            // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
            super(name);
        }
    }

    // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
    public class FootballPlayer extends Player {

        // ENCAPSULATION private class fields

        // OOP constructor that initializes the class fields on class/object instantiation
        public FootballPlayer(String name) {
            // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
            super(name);
        }
    }

    public class SoccerPlayer extends Player {

        // ENCAPSULATION private class fields

        // OOP constructor that initializes the class fields on class/object instantiation
        public SoccerPlayer(String name) {
            // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
            super(name);
        }
    }

    public class BasketballPlayer extends Player {

        // ENCAPSULATION private class fields

        // OOP constructor that initializes the class fields on class/object instantiation
        public BasketballPlayer(String name) {
            super(name);
        }
    }

    // ? GENERIC CLASSES: when using Type parameter, extend Type parameter with bounded restriction to validate only usage of specific dataType via '<T extends dataType>'
    // ! INTERFACES + GENERICS: interfaces can also utilize Type parameters & must implement method signatures
    // Comparable<Team<T>> = only compare the same-sport teams
    public class Team<T extends Player> implements Comparable<Team<T>> {

        // CONSTANTS
        private final String ALREADY_ON_TEAM = " already on team";
        private final String ADDED_TO_TEAM = " added to team";

        // ENCAPSULATION private class fields
        private String name;
        private int played;
        private int won;
        private int lost;
        private int tied;

        // ? GENERICS: specify datatype parameters when creating classes, interfaces, or methods thus improving ENCAPSULATION
        // ? GENERICS: Class<T> indicates that this class will only consist of a generic dataType
        private ArrayList<T> members;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Team(String name) {
            this.name = name;

            // default values
            this.members = new ArrayList<T>();

            this.played = 0;
            this.won = 0;
            this.lost = 0;
            this.tied = 0;
        }

        // getters & setters
        public String getName() {
            return name;
        }

        // non-static unique behavior/class methods
        public boolean addPlayer(T p) {

            if(members.contains(p)) {

                // ? GENERICS: since Java won't know until compile dataType for GENERIC CLASS parameter T, cast dataType to avoid any errors in this scenario
//                System.out.println(((Player) p).getName() + ALREADY_ON_TEAM);

                // ? since using GENERICS CLASS extends bound Type parameter, no need to cast dataType
                System.out.println(p.getName() + ALREADY_ON_TEAM);
                return false;
            }

            // implied else-statement
            members.add(p);

            // ? GENERICS: since Java won't know until compile dataType for GENERIC CLASS parameter T, cast dataType to avoid any errors in this scenario
//            System.out.println(((Player) p).getName() + ADDED_TO_TEAM);

            // ? since using GENERICS CLASS extends bound Type parameter, no need to cast dataType
            System.out.println(p.getName() + ADDED_TO_TEAM + " " + getName());
            return true;
        }

        public int getNumPlayers() {
            return this.members.size();
        }

        public void matchResult(Team<T> opponent, int ourScore, int opponentScore) {

            String msg;
            this.played++;

            if(ourScore > opponentScore) {
                this.won++;
                msg = " defeated ";
            } else if(ourScore < opponentScore) {
                this.lost++;
                msg = " lost to ";
            } else {
                this.tied++;
                msg = " drew with ";
            }

            // save results for opponent team in addition our results
            if(opponent != null) {
                System.out.println(this.getName() + msg + opponent.getName());
                opponent.matchResult(null, opponentScore, ourScore);
            }
        }

        /**
         *
         * @return
         */
        public int ranking() {
            return (this.won * 2) + this.tied;
        }

        // ! OOP POLYMORPHISM + INTERFACES: must implement publicly-shared method signatures via @Override
        @Override
        public int compareTo(Team<T> team) {

            if(this.ranking() > team.ranking()) {
                return -1;
            } else if(this.ranking() < team.ranking()){
                return 1;
            }

            // same ranking
            return 0;
        }
    }

}