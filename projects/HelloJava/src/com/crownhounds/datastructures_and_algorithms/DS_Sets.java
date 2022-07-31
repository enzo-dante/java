package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.*;

public class DS_Sets {

    public static void main(String[] args) {

        SetNotes setNotes = new SetNotes();
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
class SetNotes {
    /*
       ? SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class

       ? SET UNION: a no-duplicate set that contains all the elements of 2 or more sets via hashSet.addAll()

       ? HASHSET equals() & .hashcode(): @Override both methods if using own object as map key or set element
    */

    // CONSTANTS/static class fields assigned FINAL value before compilation/instantiation
    private static final String SET = "Sets Interface";

    // OOP constructor that initializes the class fields on class/object instantiation
    public SetNotes() {
        getNotes();
    }

    // OOP getters & setters
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override publicly-shared signatures for designated methods
    public void getNotes() {

        HashSetNotes hashSetNotes = new HashSetNotes();

        Util.printSeparator();

        Symmetry symmetry = new Symmetry();

    }

    class HashSetNotes {
    /*
        ? SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class

        ? SET UNION hashSet.addAll(): a no-duplicate set that contains all the elements of 2 or more sets via hashSet.addAll()

        ? HASHSET element/ HASHMAP key custom CLASSES: @Override .equals() & .hashcode() methods - if 2 objects compare equal, then they must have same collection bucket hashcode

        ? LINKED HASHSET & LINKED HASHMAP = both have a maintained order

            * must @Override LOGIC:

                in hashset or hashmap, the collection has n number of buckets to store objects in

                hashcode determines which collection bucket the object is added to

                    ! any collection bucket objects that are equal should have the same hashcode
                    ! BUT any 2 objects don't necessarily have to have the same hashcode

         ? TREE MAPS: ordered collection of key-value implementation of MAP INTERFACE
     */

        // CONSTANTS/static class fields associated with the blueprint assigned FINAL single memory value before compilation
        private static final String HASH_SETS = "Hash Set Class Implementation";
        private static final String PLANETS_LABEL = "Planets: ";
        private static final String MOONS_LABEL = "Moons of ";
        private static final String MOONS_LIST = "All Moons";
        private static final String PLANET_MERCURY = "Mercury";
        private static final String PLANET_VENUS = "Venus";
        private static final String PLANET_EARTH = "Earth";
        private static final String PLANET_MARS = "Mars";
        private static final String PLANET_JUPITER = "Jupiter";
        private static final String PLANET_SATURN = "Saturn";
        private static final String PLANET_NEPTUNE = "Neptune";
        private static final String PLANET_URANUS = "Uranus";
        private static final String PLANET_PLUTO = "Pluto";
        private static final String MOON_DEIMOS = "Deimos";
        private static final String MOON_IO = "Io";
        private static final String MOON_PHOBOS = "Phobos";
        private static final String MOON_EUROPA = "Europa";
        private static final String MOON_GANYMEDE = "Ganymede";
        private static final String MOON_CALLISTO = "Callisto";
        private static final String MOON_NONE = "No moons listed yet";
        private static final String MOON = "Moon";

        // ? SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class
        private Set<HeavenlyBody> planets;
        private Set<HeavenlyBody> moons;

        // ! MAPS INTERFACE: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
        private Map<String, HeavenlyBody> solarSystem;

        // OOP constructor that initializes the class fields on class/object instantiation
        public HashSetNotes() {
            // ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class

            // ! HASHMAP: collection of key-value pairs implementation of MAPS INTERFACE with GENERIC CLASS dataStructures that take 2 parameters: key & value
            solarSystem = new HashMap<>();

            // ? SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class
            planets = new HashSet<>();

            getNotes();
        }

        // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
        public void getNotes() {

            Util.printSeparator(HASH_SETS);

            HeavenlyBody planet;
            HeavenlyBody moon;

            // ? SET UNION: a no-duplicate set that contains all the elements of 2 or more sets via hashSet.addAll()
            moons = new HashSet<>();

            planet = new HeavenlyBody(PLANET_MERCURY, 88);

            // ! HASHMAP: hashmapInstance.put(key, value) = add key-value pair into map collection
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            planet = new HeavenlyBody(PLANET_VENUS, 225);
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            planet = new HeavenlyBody(PLANET_EARTH, 365);
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            moon = new HeavenlyBody(MOON, 27);
            solarSystem.put(moon.getName(), moon);
            planet.addMoon(moon);

            planet = new HeavenlyBody(PLANET_MARS, 687);
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            moon = new HeavenlyBody(MOON_DEIMOS, 1.3);
            solarSystem.put(moon.getName(), moon);
            planet.addMoon(moon);

            moon = new HeavenlyBody(MOON_PHOBOS, 0.3);
            solarSystem.put(moon.getName(), moon);
            planet.addMoon(moon);

            planet = new HeavenlyBody(PLANET_JUPITER, 4332);
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            moon = new HeavenlyBody(MOON_IO, 1.5);
            solarSystem.put(moon.getName(), moon);
            planet.addMoon(moon);

            moon = new HeavenlyBody(MOON_EUROPA, 3.5);
            solarSystem.put(moon.getName(), moon);
            planet.addMoon(moon);

            moon = new HeavenlyBody(MOON_GANYMEDE, 7.1);
            solarSystem.put(moon.getName(), moon);
            planet.addMoon(moon);

            moon = new HeavenlyBody(MOON_CALLISTO, 16.7);
            solarSystem.put(moon.getName(), moon);
            planet.addMoon(moon);

            planet = new HeavenlyBody(PLANET_SATURN, 10759);
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            planet = new HeavenlyBody(PLANET_URANUS, 30660);
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            planet = new HeavenlyBody(PLANET_NEPTUNE, 165);
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            planet = new HeavenlyBody(PLANET_PLUTO, 248);
            solarSystem.put(planet.getName(), planet);
            planets.add(planet);

            getPlanets();
            addAllMoons();
        }

        public Set<HeavenlyBody> getPlanets() {
            System.out.println(PLANETS_LABEL);

            // ? HASHSET element/ HASHMAP key custom CLASSES: @Override .equals() & .hashcode() methods - if 2 objects compare equal, then they must have same collection bucket hashcode
            // ! comment out @Override .equals() & .hashcode to see duplicate
            HeavenlyBody plutoDuplicateTest = new HeavenlyBody(PLANET_PLUTO, 842);
            this.planets.add(plutoDuplicateTest);
            int plutoCount = 0;

            // for HeavenlyBody element in HeavenlyBodyList
            for (HeavenlyBody planet : this.planets) {
                System.out.println("\t" + planet.getName() + ": " + planet.getOrbitalPeriod());

                if(planet.getName().equals(PLANET_PLUTO)) {
                    plutoCount++;
                }

                getPlanetMoons(planet);
            }

            if(plutoCount == 1) {
                System.out.println("NO REFERENTIAL DUPLICATES for Pluto:" +
                        "\nHashSet @Override .equals() & .hashcode()");
            }

            return this.planets;
        }

        public Set<HeavenlyBody> getPlanetMoons(HeavenlyBody planet) {

            HeavenlyBody body = this.solarSystem.get(planet.getName());

            if(body.getSatellites().size() > 0) {

                System.out.println("\t\t" + MOONS_LABEL + body.getName());

                for(HeavenlyBody planetMoon : body.getSatellites()) {
                    System.out.println("\t\t\t" + planetMoon.getName());
                }

            } else {
                System.out.println("\t\t" + MOON_NONE);

            }

            return body.getSatellites();
        }

        public Set<HeavenlyBody> addAllMoons() {

            for(HeavenlyBody planet : this.planets) {

                // ? SET UNION: a no-duplicate set that contains all the elements of 2 or more sets via hashSet.addAll()
                this.moons.addAll(planet.getSatellites());
            }

            System.out.println(MOONS_LIST);

            for(HeavenlyBody moon : this.moons) {
                System.out.println("\t" + moon.getName());
            }

            return this.moons;
        }
    }

    // ! FINAL: assigned immutable value before compilation/instantiation
    final class HeavenlyBody {

        // ENCAPSULATION private class fields
        private final String name;
        private final Double orbitalPeriod;
        private final Set<HeavenlyBody> satellites;

        // OOP constructor that initializes the class fields on class/object instantiation
        public HeavenlyBody(String name, double orbitalPeriod) {
            this.name = name;
            // ! AUTOBOXING: converting primitive dataType -> Wrapper class dataType w/ greater functionality
            this.orbitalPeriod = orbitalPeriod;

            // default values
            this.satellites = new HashSet<>();
        }

        // OOP CLASS METHODS: non-static unique object behavior
        public boolean addMoon(HeavenlyBody moon) {
            return this.satellites.add(moon);
        }

        // OOP getter & setters
        public String getName() {
            return name;
        }

        public Double getOrbitalPeriod() {
            return orbitalPeriod;
        }

        public Set<HeavenlyBody> getSatellites() {
            // ! IMMUTABLE CLASSES: improve ENCAPSULATION because they cannot be changed once they are created from external modification
            return new HashSet<HeavenlyBody>(this.satellites);
        }

        /*
        // ? HASHSET element/ HASHMAP key custom CLASSES: @Override .equals() & .hashcode() methods - if 2 objects compare equal, then they must have same collection bucket hashcode
        // ! Why is it unnecessary to @Override the .equals() to return true if the HeavenlyBody class was compared to a subclass of itself?
            ANSWER:
                The HeavenlyBody class is declared FINAL, so it cannot be subclassed

                The java String class is also FINAL, which is why it can safely use the
                    instanceof() method without having to worry about comparisons with a subclass
         */
        @Override
        public boolean equals(Object object) {

            // check if self-comparison (return true if '==' is the same object in memory)
            if(this == object) {
                return true;
            }

            // check for null pointer exceptions
            if((object == null) ||
                    (object.getClass() != this.getClass())) {
                return false;
            }

            // ! CASTING: converting dataType to another specific dataType
            String objectName = ((HeavenlyBody) object ).getName();
            return this.name.equals(objectName);
        }

        // ? HASHSET element/ HASHMAP key custom CLASSES: @Override .equals() & .hashcode() methods - if 2 objects compare equal, then they must have same collection bucket hashcode
        @Override
        public int hashCode() {
//            System.out.println("HashSet @Override .hashCode() was called");
            return this.name.hashCode() + 57;
        }
    }

    // ! OOP INHERITANCE + package-private: child subclass inherits class fields & public methods from extending parent super class
    class Symmetry {
        /*

            ? VENN DIAGRAM ASYMMETRIC DIFF: remove all shared elements of 1 set found in another set via bulk operation hashSet.removeAll()
                ! ASYMMETRIC DIFFERENCE = set 1 takes set 2 NOT SAME as set 2 takes set 1

            ? VENN DIAGRAM SYMMETRIC DIFF: remove all shared elements found in both sets & return all non-shared elements of both sets (hashSetUnion - hashSetIntersection)
                ! SYMMETRIC DIFFERENCE (hashSetUnion - hashSetIntersection) = elements that appear in 1 set OR the other set BUT not both

            ? hashSet.containsAll() = test if 1 set is a superset of another

            ! if class is likely to be a SAME object: prevent subclassing & force composition
            ? to get congruent .equals() & .hashcode() return true for both parent superclass & child subclass
                assign FINAL to Dog @Override .equals()
                remove @Override .equals() in Labrador to resolve incongruent .equals in Dog & Labrador class

            ! if subclass is likely to be the DIFFERENT object
            ? HASHSET element/ HASHMAP key custom CLASSES: @Override .equals() & .hashcode() methods - if 2 objects compare equal, then they must have same collection bucket hashcode
         */

        // CONSTANTS/static class variables assigned FINAL value before class/object instantiation
        private static final String ROVER_NAME = "Rover";
        private static final String SYMMETRY_SETS = "Symmetrical & Asymmetrical Sets";

        // OOP constructor that initializes the class fields on class/object instantiation
        public Symmetry() {
            // ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super class
            getNotes();
        }

        // CLASS METHODS: non-static unique object behavior
        // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures
        public void getNotes() {

            Util.printSeparator(SYMMETRY_SETS);

            Symmetry.Labrador rover1 = new SetNotes.Symmetry.Labrador(ROVER_NAME);
            Symmetry.Dog rover2 = new Symmetry.Dog(ROVER_NAME);

            // ? remove @Override .equals() in Labrador to resolve incongruent .equals in Dog & Labrador class
            System.out.println("rover1.equals(rover2) = " + rover1.equals(rover2));
            System.out.println("rover2.equals(rover1) = " + rover2.equals(rover1));

            Util.printSeparator("Set Bulk Operations");

            // ! GENERIC CLASS: enforce parameter class dataType to improve ENCAPSULATION
            Set<Integer> squares = new HashSet<>();
            Set<Integer> cubes = new HashSet<>();

            for(int i = 1; i <= 100; i++) {
                squares.add(i * i);
                cubes.add(i * i * i);
            }

            System.out.println("squares.size(): " + squares.size());
            System.out.println("cubes.size(): " + cubes.size());

            // ! GENERIC CLASS: enforce parameter class dataType to improve ENCAPSULATION
            // ? initialize hashSet constructor w/ copy of square variable values
            Set<Integer> union = new HashSet<>(squares);

            // ? union.addAll(anotherHashSet) = add all elements of a hashSet to existing hashSet w/ no duplicates
            union.addAll(cubes);
            System.out.println("union.size() of squares + cubes (no duplicates in sets): " + union.size());

            // ! GENERIC CLASS: enforce parameter class dataType to improve ENCAPSULATION
            // ? hashSet.retainAll() = used to retain from this set all of its elements that are contained in the specified collection.
            // ? initialize hashSet constructor w/ copy of square variable values
            Set<Integer> intersection = new HashSet<>(squares);
            intersection.retainAll(cubes);
            System.out.println("intersection.size(): " + intersection.size());

            for(int element : intersection) {
                System.out.println("math.sqrt() of  " + element + " = " + Math.sqrt(element));
                System.out.println("math.cbrt() of  " + element + " = " + Math.cbrt(element));
                System.out.println("---");
            }

            Util.printSeparator();

            // ! GENERIC CLASS: enforce parameter class dataType to improve ENCAPSULATION
            Set<String> words = new HashSet<>();
            String sentence = "one day in the year of the fox";
            String[] arrayWords = sentence.split(" ");

            // ! Static + Wrapper class greater functionality
            // ? SETS: Arrays.asList() = convenient initialization for collection w/ list of values
            words.addAll(Arrays.asList(arrayWords));

            System.out.println("sentence: " + sentence);

            // for each element in collection
            for(String word : words) {
                System.out.println(word);
            }

            // ? VENN DIAGRAM ASYMMETRIC DIFF: remove all shared elements of 1 set found in another set via bulk operation hashSet.removeAll()
            Set<String> nature = new HashSet<>();
            Set<String> divine = new HashSet<>();
            String[] natureWords = {"all", "nature", "is", "art", "but", "unknown", "to", "thee"};
            nature.addAll(Arrays.asList(natureWords));
            String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "is", "divine"};
            divine.addAll(Arrays.asList(divineWords));

            Util.printSeparator();

            System.out.println("\nASYMMETRIC DIFF: HashSet<>(nature).removeAll(divine)");
            Set<String> asymmetricDiffOne = new HashSet<>(nature);
            asymmetricDiffOne.removeAll(divine);
            Util.printSet(asymmetricDiffOne);

            System.out.println("asymmetric difference removed shared 'is' and 'to' & kept other words in natureSet");

            System.out.println("\nASYMMETRIC DIFF: HashSet<>(divine).removeAll(nature)");
            Set<String> asymmetricDiffTwo = new HashSet<>(divine);
            asymmetricDiffTwo.removeAll(nature);
            Util.printSet(asymmetricDiffTwo);

            System.out.println("asymmetric difference removed shared 'is' and 'to' & kept other words in divineSet");

            Util.printSeparator();

            // ? VENN DIAGRAM SYMMETRIC DIFF: remove all shared elements found in both sets & return all non-shared elements of both sets (hashSetUnion - hashSetIntersection)
            // ? initialize hashSet constructor w/ copy of square variable values
            Util.printSeparator("Symmetric Difference");
            Set<String> unionTest = new HashSet<>(nature);
            System.out.print("ORIGINAL nature:");
            Util.printSet(unionTest);

            unionTest.addAll(divine);
            Set<String> intersectionTest = new HashSet<>(nature);
            intersectionTest.retainAll(divine);

            System.out.print("UNION minus INTERSECTION (is & to) nature:");
            unionTest.removeAll(intersectionTest);
            Util.printSet(unionTest);

            Util.printSeparator();

            if(nature.containsAll(divine)) {
                System.out.println("divine set is a subset of nature");
            }

            if (nature.containsAll(intersectionTest)) {
                System.out.println(".containsAll() = intersectionTest set is a subset of nature set");
            }

            if(divine.containsAll(intersectionTest)) {
                System.out.println(".containsAll() = intersectionTest set is a subset of divine set");
            }
        }

        // OOP getters & setters

        class Dog {

            // OOP ENCAPSULATION: private class fields
            private final String name;

            // OOP constructor that initializes the class fields on class/object instantiation
            public Dog(String name) {
                this.name = name;
            }

            // CLASS METHODS: non-static unique object behavior
            // ! OOP POLYMORPHISM: same-name method given unique implementation for this class & disregarding inherited logic
            // ? assign FINAL to Dog @Override .equals() & remove @Override .equals() in Labrador to resolve incongruent .equals in Dog & Labrador class
            @Override
            public final boolean equals(Object obj) {
                // test if object is being compared to itself, it's same object in memory
                if(this == obj) {
                    return true;
                }

                if(obj instanceof Symmetry.Dog) {
                    // ! CASTING: dataType conversion
                    String objectName = ((Symmetry.Dog) obj).getName();
                    return this.name.equals(objectName);
                }

                return false;
            }

            // OOP getters & setters
            public String getName() {
                return this.name;
            }
        }

        class Labrador extends Dog {

            // OOP constructor that initializes the class fields on class/object instantiation
            public Labrador(String name) {
                super(name);
            }

            // CLASS METHODS: non-static unique object behavior
            // ! OOP POLYMORPHISM: same-name method given unique implementation for this class & disregarding inherited logic
            // ? assign FINAL to Dog @Override .equals() & remove @Override .equals() in Labrador to resolve incongruent .equals in Dog & Labrador class
//            @Override
//            public boolean equals(Object obj) {
//                // test if object is being compared to itself, it's same object in memory
//                if(this == obj) {
//                    return true;
//                }
//
//                if(obj instanceof Labrador) {
//                    // ! CASTING: dataType conversion
//                    String objectName = ((Labrador) obj).getName();
//                    String labradorName = this.getName();
//                    return labradorName.equals(objectName);
//                }
//
//                return false;
//            }
        }
    }
}