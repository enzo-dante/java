package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

public class DS_Stacks {
    /*
        ! STACKS: (LIFO) last-in, first-out abstract class implemented by a LINKED LIST that uses push, pop, peek methods

            due to LIFO, no random access and can only access the top of a stack

            ? STACK top: always null because it's a placeholder for next potential item; actual top of stack is the last index of the array

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
    // ? STACK top: always null because it's a placeholder for next potential item; actual top of stack is the last index of the array
    private int top;

    // OOP constructor that initializes the class fields on class/object instantiation
    public ArrayStack(int capacity) {
        this.stack = new Employee[capacity];
        this.top = 0;
    }

    // OOP CLASS METHODS: unique object behavior
    // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement/@Override all publicly-shared signatures for designated classes
    public void push(Employee employee) {

        boolean isFullforResize = this.top == this.stack.length;

        if(isFullforResize) {

            // double array size
            int doubleArraySize = this.stack.length * 2;
            Employee[] resizedArray = new Employee[doubleArraySize];

            // copy elements of stack's old array into new resized array
            int startIndex = 0;
            System.arraycopy(this.stack, startIndex, resizedArray, startIndex, doubleArraySize);

            // set stack's backing array to resized array
            this.stack = resizedArray;
        }

        // add new object to top of stack
        this.stack[this.top++] = employee;
    }

    public Employee pop() {

        // ! THROW EXCEPTION: initiate specific exception with provided error msg
        if(this.isEmptyStack()) throw new EmptyStackException();

        // ? STACK top: the actual top of stack is the last index of the array
        int indexLIFO = --top;
        Employee poppedEmployee = this.stack[indexLIFO];

        // ? STACK top: always null because it's a placeholder for next potential item
        this.stack[this.top] = null;

        return poppedEmployee;
    }

    @Override
    public Employee peek() {

        // EXCEPTION HANDLING look before you leap: use if-else statement to handle errors
        if(isEmptyStack()) throw new EmptyStackException();

        // get object at top but do not remove
        int firstIndex = this.top - 1;
        return this.stack[firstIndex];
    }

    public boolean isEmptyStack() {
        return this.top == 0;
    }

    public Employee[] getStack() {
        for(int i = 0; i < this.stack.length; i++) {
            System.out.println(this.stack[i]);
        }

        return this.stack;
    }
}