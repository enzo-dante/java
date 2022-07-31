package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.ArrayList;
import java.util.List;

public class DS_ArrayLists {

    public static void main(String[] args) {

        Util.printSeparator("ArrayLists");

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
}