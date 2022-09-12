package com.crownhounds.datastructures_and_algorithms;

import java.util.Objects;

// ! INNER CLASS
public class Employee {
    // OOP ENCAPSULATION private class fields
    private String firstName;
    private String lastName;
    private Employee next;
    private int id;

    // OOP constructor that initializes the class fields on class/object instantiation
    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;

        // default values
        this.next = null;
    }

    // OOP CLASS METHODS: unique object behavior
    // ! INTERFACE + INHERITANCE + OOP POLYMORPHISM: uniquely implement/@Override pre-existing method
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.crownhounds.datastructures_and_algorithms.Employee employee = (com.crownhounds.datastructures_and_algorithms.Employee) o;
        return id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    // OOP ENCAPSULATION getters & setters
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }
}