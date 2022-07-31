package com.crownhounds.masterjava;

import java.util.ArrayList;
import java.util.Set;

public class Util<T> {

    /**
     * ! METHOD OVERLOADING: when you use the same method name but with unique set of parameters
     * @param title
     */
    public static void printSeparator(String title) {
        System.out.println("\n\t" + title + "\n");
    }

    public static void printSeparator() {
        System.out.println("\n====================\n");
    }

    // ! GENERICS: use of ArrayList without defining element datatype to make it adaptable but unsafe
    public static void printArrayList(ArrayList arrayList) {

        // arrayList.size() = total int length of arrayList
        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println((i + ": " + arrayList.get(i)));
        }
    }

    public static void printSet(Set set){
        System.out.println();

        // forEach element in collection interface implementation
        for(Object o : set) {
            System.out.print("\t" + o + " ");
        }

        System.out.println();
    }
}

// ! INTERFACE: define publicly-shared signatures for set of class that must implement all of them
interface INotes {

    // ! inherited defined signatures, without implementation
    void getNotes();
}

abstract class Notes implements INotes {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String INVALID_INPUT = "Invalid Input";

    // ENCAPSULATION private class fields
    private String title;

    // OOP constructor that initializes the class fields on class/object instantiation
    // ! ABSTRACT CLASSES cannot be instantiated and must rely on normal subclasses that use OOP INHERITANCE
    public Notes(String title) {
        this.title = title;
        Util.printSeparator(this.title);
    }
}