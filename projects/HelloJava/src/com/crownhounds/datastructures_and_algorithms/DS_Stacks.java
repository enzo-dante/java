package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

public class DS_Stacks {
    /*
        ! STACKS: (LIFO) last-in, first-out abstract class implemented by a LINKED LIST that uses push, pop, peek methods

            due to LIFO, no random access and can only access the top of a stack

        ! STACK O(1) CONSTANT TIME COMPLEXITY: for push(), pop(), & peek() via LINKED LIST backing

            O(n) LINEAR TIME COMPLEXITY for push(), pop(), & peek() via ARRAY backing
     */
    public static void main(String[] args) {

        Util.printSeparator("Array-Backed Stacks");

        ArrayStack arrayStack = new ArrayStack(10);

        System.out.println("\narray.push():\n");
        arrayStack.push(new Employee("Jane", "Jones", 123));
        arrayStack.push(new Employee("John", "Doe", 456));
        arrayStack.push(new Employee("Mary", "Smith", 789));
        arrayStack.push(new Employee("Mike", "Wilson", 135));
        arrayStack.push(new Employee("Bill", "Elvin", 246));

        arrayStack.getStack();

        Util.printSeparator();

        System.out.println("arrayStack.peek():\n" + arrayStack.peek());

        Util.printSeparator();

        System.out.println("arrayStack.pop():\n" + arrayStack.pop());
        System.out.println("arrayStack.peek():\n" + arrayStack.peek());

        Util.printSeparator("LinkedList-Backed Stacks");

        LinkedListStack linkedListStack = new LinkedListStack();

        System.out.println("\nlinkedListStack.push():\n");
        linkedListStack.push(new Employee("Jane", "Jones", 123));
        linkedListStack.push(new Employee("John", "Doe", 456));
        linkedListStack.push(new Employee("Mary", "Smith", 789));
        linkedListStack.push(new Employee("Mike", "Wilson", 135));
        linkedListStack.push(new Employee("Bill", "Elvin", 246));

        linkedListStack.getStack();

        Util.printSeparator();

        System.out.println("linkedListStack.peek():\n" + linkedListStack.peek());

        Util.printSeparator();

        System.out.println("linkedListStack.pop():\n" + linkedListStack.pop());
        System.out.println("linkedListStack.peek():\n" + linkedListStack.peek());
    }
}

// ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
class LinkedListStack implements IDataStructure {

    // OOP ENCAPSULATION private class fields
    private LinkedList<Employee> stack;

    // OOP constructor that initializes the class fields on class/object instantiation
    public LinkedListStack() {
        this.stack = new LinkedList<Employee>();
    }

    // OOP CLASS METHODS: unique object behavior
    @Override
    public void push(Employee employee) {
        this.stack.push(employee);
    }

    @Override
    public Employee pop() {
        return this.stack.pop();
    }

    @Override
    public Employee peek() {
        return this.stack.peek();
    }

    public boolean isEmptyStack() {
        return this.stack.isEmpty();
    }

    public void getStack() {

        ListIterator listIterator = this.stack.listIterator();

        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}

// ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
class ArrayStack implements IDataStructure {

    // OOP ENCAPSULATION private class fields
    private Employee[] stack;

    // ? STACKS: can only access the top of a stack
    // default value
    private int top = 0;

    // OOP constructor that initializes the class fields on class/object instantiation
    public ArrayStack(int capacity) {
        this.stack = new Employee[capacity];
    }

    // OOP CLASS METHODS: unique object behavior
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
    public void push(Employee employee) {

        // stack full validation
        if(top == stack.length) {
            // need to resize backing array of stack, double array size
            int doubleArraySize = stack.length * 2;
            Employee[] newArray = new Employee[doubleArraySize];

            // copy elements of stack's old array into new array
            System.arraycopy(stack, 0, newArray, 0, doubleArraySize);
            this.stack = newArray;
        }

        // add new object to top of stack
        this.stack[this.top++] = employee;
    }

    public Employee pop() {

        if(isEmptyStack()) {

            // ! THROW EXCEPTION: initiate specific exception with provided error msg
            throw new EmptyStackException();
        }

        // ? STACK top: the actual top of stack is the last index of the array
        int indexLIFO = --top;
        Employee employee = this.stack[indexLIFO];

        // ? STACK top: always null because its a placeholder for next potential item
        this.stack[this.top] = null;

        return employee;
    }

    @Override
    public Employee peek() {

        if(isEmptyStack()) {
            throw new EmptyStackException();
        }

        // get object at top but do not remove
        return this.stack[this.top - 1];
    }

    public boolean isEmptyStack() {
        return this.top == 0;
    }

    public int size() {
        return this.top;
    }

    public Employee[] getStack() {
        for(int i = 0; i < this.stack.length; i++) {
            System.out.println(this.stack[i]);
        }

        return this.stack;
    }
}