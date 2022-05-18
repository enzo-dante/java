package com.crownhounds.learnjava;

import java.util.*;

/**
 * ! class = defined blueprint that can be used to create object/class instances (oop)
 * ! public = access modifier that enables method to be used outside the class blueprint (encapsulation)
 */
public class DataStructures {

    // CONSTANTS

    public static void main(String[] args) {

        LinkedListNotes linkedListNotes = new LinkedListNotes();

        ArrayListNotes arrayListNotes = new ArrayListNotes();

        VectorNotes vectorNotes = new VectorNotes();

        TreeNotes treeNotes = new TreeNotes();

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

    // getters & setters


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

class TreeNotes extends Notes {

    // ENCAPSULATION private class fields

    // OOP constructor that initializes the class fields on class/object instantiation
    public TreeNotes() {
        super("Tree");
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