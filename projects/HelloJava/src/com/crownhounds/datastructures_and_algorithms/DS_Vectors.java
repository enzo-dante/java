package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.List;
import java.util.Vector;

public class DS_Vectors {
    /*
        ! VECTORS are thread-safe ArrayList
            thread-safe = no conflict when using on different threads with manually having to synchronize the code (synchronization has overhead performance issue)

        ? use Vectors, if 1 or more threads are writing (CRUD) to an ArrayList there could be thread conflicts
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String VECTORS = "Vectors";

    public static void main(String[] args) {

        Util.printSeparator(VECTORS);

        // ! INTERFACE: an abstract collection of public signatures that designated classes MUST uniquely implement/@Override for standardization
        // ! GENERIC CLASS: enforce Class dataType & improve OOP ENCAPSULATION
        List<Employee> employeeList = new Vector<>();

        // ? Vector.add(value) = SYNCHRONIZED add given value to vector
        employeeList.add(new Employee("First 1", "Last 1", 124));
        employeeList.add(new Employee("First 2", "Last 2", 22));

        Employee[] employees = employeeList.toArray(new Employee[employeeList.size()]);

        for(Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}