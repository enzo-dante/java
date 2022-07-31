package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class DS_LinkedLists {
    /*
        ? LINKED LISTS: default doubly dataStructure that imposes order by storing the currentElement value as well as the pointer/link to the nextElement

            Java linkedLists are doubly by default and NOT singly

        * [value, referencePointer] = node

        beginning of the list is called the head

        * ! doubly TIME COMPLEXITY: if inserting/deleting from the head or tail of the list, O(1), else O(n)

        [nullPointer, valueMem1034, mem1037] -> [mem1034, valueMem1037, mem1046] -> [mem1037, valueMem1046, nullPointer]

        * ! singly/circular TIME COMPLEXITY: if inserting/deleting from the head of the list, O(1), else O(n)

        mem1034 -> [valueMem1034, mem1037] -> [valueMem1037, mem1046] -> [valueMem1046, nullPointer]

        * ! circular linkedList is just a looping singly linked List that can start a traversal at any node

        mem1034 -> [valueMem1034, mem1037] -> [valueMem1037, mem1046] -> [valueMem1046, mem1034]
     */

    public static void main(String[] args) {

        Util.printSeparator("Linked Lists");

        readPlacesToVisit();

        readAlphabeticalPlacesToVisit();

        visitDoubleLinkedCities();

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
}