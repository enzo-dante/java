package com.crownhounds.datastructures_and_algorithms;

public class Helper {


    public static Employee[] getEmployees() {

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Jane", "Jones", 123);
        employees[1] = new Employee("John", "Doe", 456);
        employees[2] = new Employee("Mary", "Smith", 789);
        employees[3] = new Employee("Mike", "Wilson", 135);
        employees[4] = new Employee("Bill", "Elvin", 246);
        return employees;
    }
}

interface IDataStructure {

    // publicly-shared method signatures
    void push(Employee employee);
    Employee pop();
    Employee peek();

}