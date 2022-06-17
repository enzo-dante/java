package com.crownhounds.learnjava;

import java.util.*;

/**
 * ! class = defined blueprint that can be used to create object/class instances (oop)
 * ! public = access modifier that enables method to be used outside the class blueprint (encapsulation)
 */
public class DataStructures {

    // CONSTANTS

    public static void main(String[] args) {

//        LinkedListNotes linkedListNotes = new LinkedListNotes();
//
//        ArrayListNotes arrayListNotes = new ArrayListNotes();
//
//        VectorNotes vectorNotes = new VectorNotes();
//
//        TreeNotes treeNotes = new TreeNotes();

//        Array2DNotes array2DNotes = new Array2DNotes();

//        MapNotes mapNotes = new MapNotes();

        SetNotes setNotes = new SetNotes();

    }

}

// ! ACCESS MODIFIER package-private: only visible within the scope of this package
// ! OOP INHERITANCE: child subclass that inherits class fields & public methods from extending parent super-class
class Array2DNotes extends Notes {

    // OOP constructor that initializes class fields on class/object instantiation
    public Array2DNotes() {
        // ! OOP INHERITANCE: child subclass that inherits class fields & public methods from extending parent super-class
        super("2D Array");

        getNotes();
    }

    // ! INTERFACE + OOP POLYMORPHISM: must implement all publicly-shared methods for set of classes via @Override
    @Override
    public void getNotes() {
        /*
            ? 2D ARRAYS
            Two Dimensional arrays are needed when data is formatted as TABLE or SPREADSHEET

            * Example:
                movie ratings by multiple reviewers
                    Each row is a different reviewer
                    Each column is a different movie

                    ratings = [
                        [4,6,2,5],
                        [7,9,4,8],
                        [6,9,3,7]
                    ];

                    ratings[1][3] = 8
                        [1] = row
                        [3] = column
         */

    }
}

/**
 * ? ArrayList is a type of Abstract List interface that is 0 based and automatically resized unlike an Array
 * ! reading an ArrayList is thread-safe, but if 1 or more threads are writing (CRUD) to an ArrayList there could be thread conflicts
 */
class ArrayListNotes extends Notes {

    // private class fields/object instance members

    // constructor that initializes the fields/object attributes on instantiation
    public ArrayListNotes() {
        super("ArrayLists");
        getNotes();

    }

    // unique behaviors/class methods
    // ! POLYMORPHISM: OOP mechanism for class methods to function differently based on the type of object that is executing the method
    public void getNotes() {

        // ? new ArrayList<>() = instantiate new instance of ArrayList class
        List<Employee> employeeList = new ArrayList<>();

        // ? ArrayList.add(dataType) = add value as element in ArrayList
        // ? ArrayList.add(new Class(fields)) = shortcut for adding an instance of a class to an arrayList
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Wilson", 3245));

        // forEach(lambda/anonymousFunction) = shortcut that does not return anything
        employeeList.forEach(employee -> System.out.println(employee));

        Util.printSeparator();

        // ? ArrayList.get(index) = get value of element at given index
        // ! ArrayList.get(index) = O(1) aka constant time complexity
        System.out.println(employeeList.get(1));

        Util.printSeparator();

        // ? ArrayList.isEmpty() = validate if the arrayList is empty
        System.out.println(employeeList.isEmpty());

        Util.printSeparator();

        // ? ArrayList.set(index, dataType) = update the current value of the given index with the given value
        // ! ArrayList.set(index, dataType) = O(1) aka constant time complexity
        employeeList.set(1, new Employee("Silver", "Adams", 4568));
        employeeList.forEach(employee -> System.out.println(employee));

        Util.printSeparator();

        // ? ArrayList.size() = get length of used capacity of arrayList
        System.out.println(employeeList.size());

        Util.printSeparator();

        // ? ArrayList.add(index, value) = add given value at given index
        // ! ArrayList.add(index, value) = O(n) aka linear time complexity
        employeeList.add(2, new Employee("Fin", "Doe", 4567));
        employeeList.forEach(employee -> System.out.println(employee));

        Util.printSeparator();

        System.out.println("ArrayList.toArray(dataType[size])");

        // ? ArrayList.toArray(dataType) = ensure dataType for Object array that is of length arrayList.size()
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);

        for(Employee employee: employeeArray) {
            System.out.println(employee);
        }

        Util.printSeparator();

        // ? ArrayList.contains(dataType) = validate if given instance is the EXACT same as an element value in ArrayList
        // true if override .equal() else false bc 2 different instances
        System.out.println(employeeList.contains(new Employee("Fin", "Doe", 4567)));

        Util.printSeparator();

        // ? ArrayList.indexOf(dataType) = get index of given value if arrayList contains it
        // return index if override .equal() else -1 bc 2 different instances or null
        System.out.println(employeeList.indexOf(new Employee("Yellow", "King", 4567))); // -1
        System.out.println(employeeList.indexOf(new Employee("Fin", "Doe", 4567))); // 2

        Util.printSeparator();

        // ? ArrayList.remove(index) = remove element in ArrayList given the index
        // ! given shifting, O(n) aka linear time complexity
        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));

    }

    // ! ENCAPSULATION + non-static INNER CLASS
    private class Employee {

        // private class fields/object instance members
        private String firstName;
        private String lastName;
        private int id;

        // constructor that initializes the class fields on class instantiation
        public Employee(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        // unique behaviors/class methods
        // ! @Override the appropriate methods in the subclasses to demonstrate POLYMORPHISM with INHERITANCE
        @Override
        public String toString() {
            return "ArrayListEmployee{" +
                    "firstName='" + getFirstName() + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", id=" + id +
                    '}';
        }

        // ! @Override the appropriate methods in the subclasses to demonstrate POLYMORPHISM with INHERITANCE
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee that = (Employee) o;
            return id == that.id && firstName.equals(that.firstName) && lastName.equals(that.lastName);
        }

        // ! @Override the appropriate methods in the subclasses to demonstrate POLYMORPHISM with INHERITANCE
        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, id);
        }

        // getters & setters
        public String getFirstName() {
            return firstName;
        }
    }
}

/**
 * ? linkedLists store the currentElement value as well as the link to the nextElement
 * ? Java linkedLists are doubly by default and NOT singly
 *      linked lists are great for imposing order (i.e. alphabetical order)

 *      * [value, referencePointer] = node
 *      beginning of the list is called the head

 * ! doubly TIME COMPLEXITY: if inserting/deleting from the head or tail of the list, O(1), else O(n)

 [nullPointer, valueMem1034, mem1037] -> [mem1034, valueMem1037, mem1046] -> [mem1037, valueMem1046, nullPointer]

 * ! singly/circular TIME COMPLEXITY: if inserting/deleting from the head of the list, O(1), else O(n)

 mem1034 -> [valueMem1034, mem1037] -> [valueMem1037, mem1046] -> [valueMem1046, nullPointer]

 * ! circular linkedList is just a looping singly linked List that can start a traversal at any node

 mem1034 -> [valueMem1034, mem1037] -> [valueMem1037, mem1046] -> [valueMem1046, mem1034]

 */
class LinkedListNotes extends Notes {

    // class fields/object instance members

    // constructor that initializes the class fields/object instance members on instantiation
    public LinkedListNotes() {
        super("LinkedLists");
        getNotes();
    }

    public void getNotes() {

        updateMemory();

        readPlacesToVisit();

        readAlphabeticalPlacesToVisit();

        visitDoubleLinkedCities();

    }

    // ! static = independent, doesn't need an instance
    // ! private = access modifier that restricts method to be used outside the class blueprint (encapsulation)
    private void updateMemory() {

        Util.printSeparator("updateMemory() was called");

        /*
            * java doesn't create another class, it simply saved/updated the memory address for the below

                anotherCustomer = customer;
                anotherCustomer.setBalance(12.18);

         */
        Customer customer = new Customer("Katlyn", 54.96);
        Customer anotherCustomer;
        System.out.println("BEFORE anotherCustomer.setBalance() for " + customer.getName() + " customer.getBalance():\n" + customer.getBalance());

        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("AFTER anotherCustomer.setBalance() for " + customer.getName() + " customer.getBalance():\n" + customer.getBalance());

        // an arrayList with elements of Integer wrapper class data type
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        // arrayList.add(newElement) = add new element to an arrayList data type
        integerArrayList.add(1);
        integerArrayList.add(3);
        integerArrayList.add(4);

        Util.printSeparator("set 1");
        Util.printArrayList(integerArrayList);

        /*
            * shifting elements does NOT scale well
            shift every element after index 1 in arrayList to insert element 2 at index 1
         */
        integerArrayList.add(1, 2);

        Util.printSeparator("set 2");
        Util.printArrayList(integerArrayList);
    }

    // ! private = access modifier that restricts use outside of class blueprint (encapsulation)
    // ! static = independent class method, does not require an instance
    // ! void = return nothing
    private static void readPlacesToVisit() {

        Util.printSeparator("readPlacesToVisit() was called");

        LinkedList<String> placesToVisit = new LinkedList<>();

        // ? linkedList.add(newElement) = add new element to end of a linkedList
        placesToVisit.add("memory 1");
        placesToVisit.add("memory 2");
        placesToVisit.add("memory 3");
        placesToVisit.add("memory 4");
        placesToVisit.add("memory 5");
        placesToVisit.add("memory 6");

        // ? linkedList.add(index, newElement) = add new element at index of a linkedList by handling pointers
        placesToVisit.add(1, "memory 1.5");

        // ? linkedList.remove(element) = remove element at index of a linkedList by handling pointers
        placesToVisit.remove(5);

        // ? iterator = index tracker to loop through a linkedList (alternative to a for loop)
        Iterator<String> stringIterator = placesToVisit.iterator();

        // ? linkedListIterator.hasNext(): validates pointer at currentElement is not null
        while(stringIterator.hasNext()) {

            // ? linkedListIterator.next(): get currentElementValue and iterate to nextElement via currentElementPointer
            System.out.println("now visiting:\n\t" + stringIterator.next());
        }

    }

    private static LinkedList<String> readAlphabeticalPlacesToVisit() {

        Util.printSeparator("readAlphabeticalPlacesToVisit() was called");

        LinkedList<String> placesToVisit = new LinkedList<>();
        boolean isAdded;

        isAdded = addToAlphabeticalPlacesToVisit(placesToVisit, "Miami");
        isAdded = addToAlphabeticalPlacesToVisit(placesToVisit, "Dallas");
        isAdded = addToAlphabeticalPlacesToVisit(placesToVisit, "San Antonio");
        isAdded = addToAlphabeticalPlacesToVisit(placesToVisit, "NYC");
        isAdded = addToAlphabeticalPlacesToVisit(placesToVisit, "Phoenix");
        isAdded = addToAlphabeticalPlacesToVisit(placesToVisit, "NYC");
        isAdded = addToAlphabeticalPlacesToVisit(placesToVisit, "LA");
        isAdded = addToAlphabeticalPlacesToVisit(placesToVisit, "Memphis");

        Util.printSeparator("addToAlphabeticalPlacesToVisit() was called");

        if(isAdded) {
            ListIterator<String> stringListIterator = placesToVisit.listIterator();

            // ? linkedListIterator.hasNext(): validates pointer at currentElement is not null
            while(stringListIterator.hasNext()) {

                // ? linkedListIterator.next(): get currentElementValue and iterate to nextElement via currentElementPointer
                System.out.println("now visiting:\n\t" + stringListIterator.next());
            }
        }

        return placesToVisit;
    }

    private static boolean addToAlphabeticalPlacesToVisit(LinkedList<String> placesToVisit, String newCity) {

        // ? linkedList.listIterator() = enables moving forward and backward direction in a linkedList
        ListIterator<String> stringListIterator = placesToVisit.listIterator();

        // ? linkedList.listIterator.hasNext() = validates pointer at currentElement is not null
        while(stringListIterator.hasNext()) {

            // ? to INITIALIZE compareTo with linkedList.listIterator
            //      0 = currentElement & comparisonValue are equal/match
            //      (comp > 0) = currentElement & comparisonValue are equal/match
            //      (comp < 0) = currentElement & comparisonValue are equal/match
            int comparison = stringListIterator.next().compareTo(newCity);

            // in-place: sort list of elements without creating new data structures & return nothing
            if(comparison == 0) {

                System.out.println("\ndo not add " + newCity + " comparisonValue/duplicate place\n");
                return false;

            } else if(comparison > 0) {

                // ? linkedList.listIterator.previous() enables moving back to the already readElement via a pointer
                stringListIterator.previous();
                stringListIterator.add(newCity);
                System.out.println(newCity + " added before currentElement");
                return true;

            } else if(comparison < 0) {
                System.out.println("must add " + newCity + " after currentElementValue");
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visitDoubleLinkedCities() {

        Util.printSeparator("visitDoubleLinkedCities() was called");

        // ? linkedLists are doubled by default
        LinkedList<String> cities = readAlphabeticalPlacesToVisit();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> stringListIterator = cities.listIterator();

        // ? linkedList.listIterator().getFirst().isEmpty() = validate that linkedList has valid elements
        if(cities.getFirst().isEmpty()) {
            System.out.println("no cities in linkedList");
        } else {

            System.out.println("now visiting: " + stringListIterator.next());
            printVisitMenu();
        }

        while(!quit) {

            System.out.println("\nselect: ");

            if(scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice) {
                    case 0:
                        System.out.println("vacation over");
                        quit = true;
                        break;
                    case 1:
                        // forward

                        // ? linkedLists must handle direction to avoid returning double of currentElement after direction change
                        if(!goingForward) {
                            if(stringListIterator.hasNext()) {
                                stringListIterator.next();
                            }
                            goingForward = true;
                        }

                        if(stringListIterator.hasNext()) {
                            System.out.println("now visiting: " + stringListIterator.next());
                        } else {
                            System.out.println("reached end of linkedList");
                            goingForward = false;
                        }
                        break;
                    case 2:
                        // backward

                        // ? linkedLists must handle direction to avoid returning double of currentElement after direction change
                        if(goingForward) {
                            if(stringListIterator.hasPrevious()) {
                                stringListIterator.previous();
                            }
                            goingForward = false;
                        }

                        if(stringListIterator.hasPrevious()) {
                            System.out.println("now visiting: " + stringListIterator.previous());
                        } else {
                            System.out.println("reached beginning of linkedList");
                            goingForward = true;
                        }
                        break;
                    case 3:
                        printVisitMenu();
                        break;
                    default:
                        System.out.println("INVALID INPUT");
                        break;
                }
            } else {
                System.out.println("INVALID INPUT");
                scanner = new Scanner(System.in);
            }
        }
    }

    private static void printVisitMenu() {

        System.out.println("\navailable actions:\n" +
                "0 - quit\n" +
                "1 - next city\n" +
                "2 - previous\n" +
                "3 - print menu options\n");

    }

    private class Customer {

        // private class fields/object instance members
        private String name;
        private double balance;

        // constructor that initializes the class fields on class/object instantiation
        public Customer(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        // non-static (must have instance) unique class methods/behaviors

        // non-static (must have instance) getters & setters

        public String getName() {
            return this.name;
        }

        public double getBalance() {
            return this.balance;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }

}

/**
 * ? Vectors are thread-safe ArrayList
 * ! thread-safe = no conflict when using on different threads with manually having to synchronize the code (synchronization has overhead performance issue)
 * ? use Vectors if 1 or more threads are writing (CRUD) to an ArrayList there could be thread conflicts
 * ! reading an ArrayList is thread-safe
 */
class VectorNotes extends Notes {

    // private class fields/object instance members


    // constructor that initializes the class fields on class/object instantiation
    public VectorNotes() {
        super("Vectors");
        getNotes();
    }

    // unique behaviors/class methods
    public void getNotes() {

        List<Employee> employeeList = new Vector<>();

        // ? Vector.add(value) = SYNCHRONIZED add given value to vector
        employeeList.add(new Employee("First 1", "Last 1", 124));
        employeeList.add(new Employee("First 2", "Last 2", 22));
        employeeList.add(new Employee("First 3", "Last 3", 987));
        employeeList.add(new Employee("First 4", "Last 4", 345));

        Employee[] employees = employeeList.toArray(
                employeeList.toArray(new Employee[employeeList.size()]
                ));

        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // OOP ENCAPSULATION getters & setters

    // ! ENCAPSULATION + non-static INNER CLASS
    private class Employee {

        // private class fields/object instance members
        private String firstName;
        private String lastName;
        private int id;

        // constructor that initializes the class fields on class instantiation
        public Employee(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        // unique behaviors/class methods
        // ! @Override the appropriate methods in the subclasses to demonstrate POLYMORPHISM with INHERITANCE
        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + getFirstName() + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", id=" + id +
                    '}';
        }

        // ! @Override the appropriate methods in the subclasses to demonstrate POLYMORPHISM with INHERITANCE
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
        }

        // ! @Override the appropriate methods in the subclasses to demonstrate POLYMORPHISM with INHERITANCE
        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, id);
        }

        // getters & setters
        public String getFirstName() {
            return firstName;
        }

    }
}

// ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
class MapNotes extends Notes {
    /*
        ? MAPS INTERFACE: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
            GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter

        ? no-order HASHMAPS & LINKED HASHMAPS classes are the main implementations of the MAPS INTERFACE

            Map<dataType, dataType> instance = new HashMap<>()

        ? hashmapInstance.put(key, value) = add unique_key-value generics class pair into map collection

            ! if you add the key again, the oldValue will be overridden in the map since map keys are unique
                before overriding the value, .put() will return the previous value of the key-value pair
                a value being added for the 1st time will initially return null before adding to the map collection

        ? hashmapInstance.get(key) = retrieve record via key in map collection

        ? hashmapInstance.containsKey(key) = validate key existence in map before adding/update key in map

        ? hashmapInstance.putIfAbsent(key, value) = for CONCURRENCY, if key is not already present in map, than add key-value pair

        ? use hashmapInstance.keySet() + hashmapInstance.get(key) = loop through map & return all key-value pairs

        ? use hashmapInstance.remove(key) = remove key-value pair from map

        ? use hashmapInstance.remove(key, specificValue) = ONLY IF key has specific value, THAN remove key-value pair from map

        ? use hashmapInstance.replace(key, replaceValue) = IF key already exists, replace the key's value in the map

        ? use hashmapInstance.replace(key, validationValue, replacingValue) = ONLY IF key has specific value, THAN replace key's value in map

        ? HASHSET element/ HASHMAP key custom CLASSES: @Override .equals() & .hashcode() methods - if 2 objects compare equal, then they must have same collection bucket hashcode
     */

    // CONSTANTS/static class variables assigned FINAL values before compilation/instantiation
    private static final String MAPS = "Maps";

    // OOP constructor that initializes the class fields on class/object instantiation
    public MapNotes() {
        // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
        super(MAPS);
        getNotes();
    }

    // non-static unique object behavior/class methods
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely-implement/@Override all publicly-shared signatures for a set of classes
    @Override
    public void getNotes() {

        // ? HASHMAP: collection of key-value pairs implementation of MAPS INTERFACE with GENERIC CLASS dataStructures that take 2 parameters: key & value
        // <String, String> = key, value GENERIC CLASS parameters
        Map<String, String> languages = new HashMap<>();

        // ? COLLECTION MAP: hashmapInstance.put(key, value) = add key-value pair into map collection
        languages.put("Java", "OOP independent compilation language");
        languages.put("Python", "OOP independent interpreted language w/ dynamic semantics");
        languages.put("BASIC", "Beginners All-purpose Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        // ? COLLECTION MAP: hashmapInstance.get(key) = retrieve record via key in map collection
        System.out.println(
                languages.get("Java")
        );

        // ! MAP KEY OVERRIDING: if you add the key again, the oldValue will be overridden in the map since map keys are unique
        // before overriding the value, .put() will return the previous value of the key-value pair
        // a value being added for the 1st time will initially return null before adding to the map collection
        languages.put("Java", "The value associated with the 'Java' key has been overridden");

        System.out.println(
                languages.get("Java")
        );

        Util.printSeparator();

        // ? COLLECTION MAP: hashmapInstance.containsKey(key) = validate key existence in map before adding/update key in map
        if(languages.containsKey("Javascript")) {
            System.out.println("'Javascript' key already in map");
        } else {
            languages.put("Javascript", "OOP independent compilation language w/ dynamic semantics");
            System.out.println("'Javascript' keyword added successfully");
        }

        if(languages.containsKey("Javascript")) {
            System.out.println("'Javascript' key already in map");
        }

        // ? COLLECTION MAP: hashmapInstance.putIfAbsent(key, value) = for CONCURRENCY, if key is not already present in map, than add key-value pair
        languages.putIfAbsent("SQL", "Database query language");

        Util.printSeparator();

        // ? use hashmapInstance.keySet() + hashmapInstance.get(key) = loop through map & return all key-value pairs
        for(String key: languages.keySet()) {
            System.out.println(key + ":\n\t" + languages.get(key));
        }

        Util.printSeparator();

        // ? use hashmapInstance.remove(key) = remove key-value pair from map
        languages.remove("Lisp");
        System.out.println("hashmapInstance.containsKey('Lisp'):\n" + languages.containsKey("Lisp"));

        Util.printSeparator();

        // ? use hashmapInstance.remove(key, specificValue) = ONLY IF key has specific value, THAN remove key-value pair from map
        if(languages.remove("Java", "This should NOT be removed")) {
            System.out.println("Java key-value pair was INCORRECTLY removed");
        } else {
            System.out.println("Java key-value pair was preserved");
        }

        for(String key: languages.keySet()) {
            System.out.println(key + ":\n\t" + languages.get(key));
        }

        Util.printSeparator();

        // ? use hashmapInstance.replace(key, replaceValue) = IF key already exists, replace the key's value in the map

        languages.replace("SQL", "replace String value for pre-existing 'SQL' key in map");

        languages.replace("Scala", "will NOT be added since 'Scala' key in not already in map");

        for(String key: languages.keySet()) {
            System.out.println(key + ":\n\t" + languages.get(key));
        }

        Util.printSeparator();

        // ? use hashmapInstance.replace(key, validationValue, replacingValue) = ONLY IF key has specific value, THAN replace key's value in map
        if(languages.replace("Java", "This should NOT be removed", "Validated String oldValue & replaced with newValue")) {
            System.out.println(languages.get("Java"));
        } else {
            System.out.println("Java key-value pair was CORRECTLY preserved");
        }

        String oldValue = "The value associated with the 'Java' key has been overridden";

        if(languages.replace("Java", oldValue, "Validated String oldValue & replaced with newValue")) {
            System.out.println(languages.get("Java"));
        } else {
            System.out.println("Java key-value pair was CORRECTLY preserved");
        }
    }

    // ! INNER CLASS + PACKAGE PRIVATE: a parent object has logically-grouped components within itself whose default visibility is limited to the package class SCOPE

}

// ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
class SetNotes extends Notes {
    /*
       ? SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class

       ? SET UNION: a no-duplicate set that contains all the elements of 2 or more sets via hashSet.addAll()

       ? HASHSET equals() & .hashcode(): @Override both methods if using own object as map key or set element
    */

    // CONSTANTS/static class fields assigned FINAL value before compilation/instantiation
    private static final String SET = "Sets Interface";

    // OOP constructor that initializes the class fields on class/object instantiation
    public SetNotes() {
        super(SET);
        getNotes();
    }

    // OOP getters & setters
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override publicly-shared signatures for designated methods
    public void getNotes() {

        HashSetNotes hashSetNotes = new HashSetNotes();
//        Symmetry symmetry = new Symmetry();

    }

    class HashSetNotes extends Notes {
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
        private StockList stockList = new StockList();

        // OOP constructor that initializes the class fields on class/object instantiation
        public HashSetNotes() {
            // ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class
            super(HASH_SETS);

            // ! HASHMAP: collection of key-value pairs implementation of MAPS INTERFACE with GENERIC CLASS dataStructures that take 2 parameters: key & value
            solarSystem = new HashMap<>();

            // ? SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class
            planets = new HashSet<>();

            getNotes();
        }

        // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
        @Override
        public void getNotes() {

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

            Util.printSeparator();

            StockItem temp = new StockItem("bread", 0.86, 100);
            stockList.addStock(temp);

            temp = new StockItem("cake", 1.10, 7);
            stockList.addStock(temp);

            temp = new StockItem("chair", 62D, 10);
            stockList.addStock(temp);

            temp = new StockItem("cup", 0.50, 200);
            stockList.addStock(temp);
            temp = new StockItem("cup", 0.45, 7);
            stockList.addStock(temp);

            temp = new StockItem("door", 72.95, 4);
            stockList.addStock(temp);

            System.out.print(StockList.STOCK_LIST_TITLE);

            // ! use hashMapInstance.keySet() + hashmapInstance.get(key) = loop through map & return all key-value pairs
            for(String s : stockList.getStockItems().keySet()) {
                System.out.println(s);
            }

            System.out.println(stockList);
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

    class Basket {

        // OOP ENCAPSULATION + FINAL: private class fields assigned FINAL value before compilation/instantiation
        private final String name;
        // ! MAP INTERFACE: collection of key-value pair (2 GENERIC CLASS parameters)
        private final Map<StockItem, Integer> list;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Basket(String name) {
            this.name = name;

            // ? TREE MAPS: ordered collection of key-value implementation of MAP INTERFACE
            this.list = new TreeMap<>();
        }

        // CLASS METHODS: non-static unique object behavior
        public int addToBasket(StockItem item, int quantity) {

            if((item != null) && (quantity > 0)) {

                // ! hashMap.getOrDefault(queryResult, defaultResult) = get item in map if exists, else use defaultResult
                int inBasket = list.getOrDefault(item, 0);

                // ! hashmapInstance.put(key, value) = add unique_key-value generics class pair into map collection
                this.list.put(item, inBasket + quantity);

                return inBasket;
            }

            return 0;
        }

        public Map<StockItem, Integer> getStockItems() {
            // ? Collections.unmodifiableMap(list) = map that cannot be modified
            return Collections.unmodifiableMap(this.list);
        }

        // ! OOP POLYMORPHISM: uniquely implement/@Override method shared by multiple classes
        @Override
        public String toString() {
            String s = "\nShopping Basket " + this.name + " contains " + this.list.size() + " items\n";
            double totalCost = 0D;

            // hashMap.entrySet() = all elements
            for(Map.Entry<StockItem, Integer> item: this.list.entrySet()) {
                s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
                totalCost += item.getKey().getPrice() * item.getValue();
            }

            return s + " Total Cost: " + totalCost;
        }
    }

    class StockList {

        // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
        private static final String STOCK_LIST_TITLE = "\n\tStock List\n";

        // ! OOP ENCAPSULATION + FINAL: private class fields assigned final value before compilation/instantiation
        // ! MAP INTERFACE + ENCAPSULATION: collection of key-value pair (2 GENERIC CLASS dataStructure parameters)
        private final Map<String, StockItem> list;

        // OOP constructor that initializes the class fields on class/object instantiation
        public StockList() {

            // ! HASH MAPS: collection of key-value pair HASHMAP implementation of MAP INTERFACE
//            this.list = new HashMap<>();

            // ! LINKED HASH MAPS: ordered collection of key-value pair HASHMAP implementation of MAP INTERFACE
            this.list = new LinkedHashMap<>();
        }

        // CLASS METHODS: non-static unique object behavior
        public int addStock(StockItem stockItem) {

            if(stockItem != null) {

                // check if already have quantities of this item
                // ! hashMap.getOrDefault(queryResult, defaultResult) = get item in map if exists, else use defaultResult
                StockItem inStock = list.getOrDefault(stockItem.getName(), stockItem);

                // check if already have quantities of this item, adjust quantity
                if(inStock != stockItem) {
                    stockItem.setQuantityStock(inStock.getQuantityStock());
                }

                // ! hashmapInstance.put(key, value) = add unique_key-value generics class pair into map collection
                list.put(stockItem.getName(), stockItem);
                return stockItem.getQuantityStock();
            }
            return 0;
        }

        public int sellStock(String item, int quantity) {
            // check if already have quantities of this item
            // ! hashMap.getOrDefault(queryResult, defaultResult) = get item in map if exists, else use defaultResult
            StockItem inStock = list.getOrDefault(item, null);
            if((inStock != null) &&
                    (inStock.getQuantityStock() >= quantity) &&
                    (quantity > 0)) {

                // adjust stock
                inStock.setQuantityStock(-quantity);
                return quantity;
            }

            // handle nothing taken out of stock
            return 0;
        }

        public StockItem getStockItem(String key) {
            return this.list.get(key);
        }

        public Map<String, StockItem> getStockItems() {

            // ? Collections.unmodifiableMap(list) = MAP that cannot be modified
            return Collections.unmodifiableMap(this.list);
        }

        // ! OOP POLYMORPHISM: uniquely implement/@Override method shared by multiple classes
        @Override
        public String toString() {
            String s = STOCK_LIST_TITLE;
            double totalCost = 0D;

            // ! HASH MAP: iterate though entire HASH MAP implementation of key-value pairs
            for(Map.Entry<String, StockItem> item: list.entrySet()) {

                StockItem stockItem = item.getValue();
                double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();

                s = s + stockItem + "\n\tThere are " + stockItem.getQuantityStock() + " in stock";
                // %.2f = two decimal place floating number
                s = s + "\n\tTotal Stock Value: " + String.format("%.2f", itemValue) + "\n";
                totalCost += itemValue;
            }

            return s +  "Total stock value: " + totalCost;
        }
    }

    // ! INTERFACE: must uniquely implement/@Override signature for designated classes
    class StockItem implements Comparable {

        // OOP ENCAPSULATION private class fields
        // ! FINAL: variable assign final value before compilation/instantiation
        private final String name;
        private Double price;
        private Integer quantityStock;

        // OOP constructor that initializes the class fields on class/object instantiation
        public StockItem(String name, double price) {
            this.name = name;

            // ! AUTOBOXING: convert primitive dataType -> Wrapper Class dataType
            this.price = price;

            // default values
            this.quantityStock = 0;
        }

        // ! OVERLOADED constructor: same name method w/ unique parameters w/ unique implementation that helps with scalability & readability
        public StockItem(String name, double price, int quantityStock) {
            this.name = name;

            // ! AUTOBOXING: convert primitive dataType -> Wrapper Class dataType
            this.price = price;
            this.quantityStock = quantityStock;
        }

        // CLASS METHODS: non-static unique object behavior
        // ? OOP POLYMORPHISM + HASHSET element/ HASHMAP key custom CLASSES: @Override .equals() & .hashcode() methods - if 2 objects compare equal, then they must have same collection bucket hashcode
        @Override
        public boolean equals(Object obj) {
            System.out.println("Entering StockItem.equals():");

            // check if the same instance in memory
            if(obj == this) {
                return true;
            }

            // check if null OR the objects are of different class dataTypes
            if((obj == null) || (obj.getClass() != this.getClass())) {
                return false;
            }

            // do comparison of instance names after validation
            // ! CASTING: convert 1 dataType object to another specific & compatible dataType
            String objectName = ((StockItem) obj).getName();
            return this.name.equals(objectName);
        }

        @Override
        public int hashCode() {
            // 31 is an arbitrary number
            return this.name.hashCode() + 31;
        }

        @Override
        public int compareTo(Object o) {
            System.out.println("Entering StockItem.compareTo():");

            if(this == o) {
                return 0;
            }

            if(o != null) {
                StockItem stock = (StockItem) o;
                return this.name.compareTo(stock.getName());
            }

            throw new NullPointerException();
        }

        @Override
        public String toString() {
            return this.name + "\n\tprice: $" + this.price;
        }

        // OOP getters & setters
        public String getName() {
            return name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            if(price > 0D) {
                this.price = price;
            }
        }

        public Integer getQuantityStock() {
            return quantityStock;
        }

        public void setQuantityStock(int quantity) {
            int newQuantity = this.quantityStock + quantity;
            if(newQuantity >= 0) {
                this.quantityStock = newQuantity;
            }
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
    class Symmetry extends Notes {
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
            super(SYMMETRY_SETS);

            getNotes();
        }

        // CLASS METHODS: non-static unique object behavior
        // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures
        @Override
        public void getNotes() {

            Labrador rover1 = new Labrador(ROVER_NAME);
            Dog rover2 = new Dog(ROVER_NAME);

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

                if(obj instanceof Dog) {
                    // ! CASTING: dataType conversion
                    String objectName = ((Dog) obj).getName();
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

class TreeNotes extends Notes {

    // CONSTANTS/static class fields assigned FINAL value before compilation/instantiation
    private static final String TREE = "Tree";

    // ENCAPSULATION private class fields

    // OOP constructor that initializes the class fields on class/object instantiation
    public TreeNotes() {
        super(TREE);
        getNotes();

    }

    public void getNotes() {

        BinarySearchTreeNotes binarySearchTreeNotes = new BinarySearchTreeNotes();
    }

    // ! OOP ENCAPSULATION: protect against improper by limiting with access-modifier
    // ! non-static INNER CLASS: need a base class instance to execute functionality
    private class BinarySearchTreeNotes extends Notes {

        // ENCAPSULATION private class fields

        public BinarySearchTreeNotes() {
            super("Binary Search Tree");
            getNotes();
        }

        public void getNotes() {

        }
    }
}