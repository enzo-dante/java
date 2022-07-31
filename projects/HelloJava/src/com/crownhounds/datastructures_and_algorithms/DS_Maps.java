package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.HashMap;
import java.util.Map;

public class DS_Maps {
     /*
        ? MAPS INTERFACE: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
            GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter;

        ? no-order HASHMAPS & LINKED HASHMAPS classes are the main implementations of the MAPS INTERFACE

            Map<dataType, dataType> instance = new HashMap<>()

        ? hashmapInstance.put(key, value) = add unique_key-value generics class pair into map collection

            ! if you add the key again, the oldValue will be overridden in the map since map keys are unique
                before overriding the value, .put() will return the previous value of the key-value pair
                a value being added for the 1st time will initially return null before adding to the map collection

        ? hashmapInstance.get(key) = retrieve record via key in map collection

        ? hashmapInstance.getOrDefault(key, defaultValue) = get the value mapped with specified key. If no value is mapped with the provided key then the default value is returned.

        ? hashmapInstance.containsKey(key) = validate key existence in map before adding/update key in map

        ? hashmapInstance.putIfAbsent(key, value) = for CONCURRENCY, if key is not already present in map, than add key-value pair

        ? Map.entrySet(): create a set out of the same elements contained in the hash map
        ? use hashmapInstance.keySet() + hashmapInstance.get(key) = loop through map & return all key-value pairs

        ? use hashmapInstance.remove(key) = remove key-value pair from map

        ? use hashmapInstance.remove(key, specificValue) = ONLY IF key has specific value, THAN remove key-value pair from map

        ? use hashmapInstance.replace(key, replaceValue) = IF key already exists, replace the key's value in the map

        ? use hashmapInstance.replace(key, validationValue, replacingValue) = ONLY IF key has specific value, THAN replace key's value in map

        ? HASHSET element/ HASHMAP key custom CLASSES: @Override .equals() & .hashcode() methods - if 2 objects compare equal, then they must have same collection bucket hashcode
     */

    public static void main(String[] args) {

        Util.printSeparator("Maps Interface");

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
}