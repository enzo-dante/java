package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.NoSuchElementException;

public class DS_Queues {
     /*
        ! QUEUE: (FIFO) first-in, first-out abstract class implemented by a LINKED LIST that uses enqueue(), dequeue(), peek()

            due to FIFO, no random access and can only access the top of a stack

            * add() or enqueue() = add value to end of the queue

                [10, 15, 4, 22]

                front = 10
                back = 22

                enqueue(20) = [10, 15, 4, 22, 20]

            * pop() or dequeue() = remove value from front of the queue

                [10, 15, 4, 22, 20]

                front = 10
                back = 20

               dequeue(20) = [10, 15, 4, 22, 20]

            * peek() = get item from front of queue


        ! STACK TIME COMPLEXITY:

            * O(1) CONSTANT TIME COMPLEXITY for push(), pop(), & peek() via LINKED LIST backing

            * O(n) LINEAR TIME COMPLEXITY for push(), pop(), & peek() via ARRAY backing

        ? CIRCULAR QUEUE: wrap back to front of the queue instead of resizing potentially front-empty queue

                ! The back field will always be pointing to the next available position in the queue.

                * adding to a full circular queue needs to be resized/doubled

                    1st iteration; back/nextAvailablePosition = index 5 for Bill

                        0 - jane - front
                        1 - john
                        2 - mary
                        3 - mike
                        4        - back

                    2nd iteration; back/nextAvailablePosition = index 7

                        0 - jane - front
                        1 - john
                        2 - mary
                        3 - mike
                        4 - bill
                        5
                        6
                        7         - back

                * wrap back to front & no need to resize array if removing & adding elements from a circular queue that's NOT full
                ! if circular queue is full, during 2x resize elements at the front of the queue assigned to back in order

                    1st iteration; back/nextAvailablePosition = index 2

                        0 - jane - front
                        1 - john
                        2        - back
                        3
                        4

                    2nd iteration; back/nextAvailablePosition = index 2 still after removing jane

                        0
                        1 - john - front
                        2        - back
                        3
                        4

                    3rd iteration; back/nextAvailablePosition = index 3 since adding

                        0
                        1 - john - front
                        2 - mary
                        3        - back
                        4

                    4th iteration; back/nextAvailablePosition = index 3 still after removing john

                        0
                        1
                        2 - mary - front
                        3        - back
                        4

                    5th iteration; back/nextAvailablePosition = index 4 still after adding mike

                        0
                        1
                        2 - mary - front
                        3 - mike
                        4        - back

                    6th iteration; back/nextAvailablePosition = index 4 still after removing mary

                        0
                        1
                        2
                        3 - mike - front
                        4        - back

                    7th iteration; back/nextAvailablePosition = index 4 still after adding bill

                        0        - back
                        1
                        2
                        3 - mike - front
                        4 - bill

                    nth iteration; back/nextAvailablePosition = index 2 but need unwrapping resize when adding gary

                        0 - jane
                        1 - john
                        2        - back
                        3 - mike - front
                        4 - bill

                    n+ iteration; back/nextAvailablePosition = index 5 but array has been doubled and elements in correct order

                        0 - mike - front
                        1 - bill
                        2 - jane
                        3 - john
                        4 - gary
                        5        - back
                        6
                        7

     */

    public static void main(String[] args) {

        Util.printSeparator("Queues");

        ArrayQueue queue = new ArrayQueue(Helper.getEmployees().length);

        System.out.println(".add()");
        queue.add(new Employee("Jane", "Jones", 123));
        queue.add(new Employee("John", "Doe", 456));
        queue.add(new Employee("Mary", "Smith", 789));
        queue.add(new Employee("Mike", "Wilson", 135));
        queue.add(new Employee("Bill", "Elvin", 246));
        queue.printQueue();

        Util.printSeparator();

        System.out.println(".remove()");
        queue.remove();
        queue.remove();
        queue.printQueue();

        Util.printSeparator();

        System.out.println(".peek()");

        System.out.println(queue.peek());

        queue.remove();
        queue.remove();
        queue.remove();
        queue.printQueue();

        Util.printSeparator();

        queue.add(new Employee("first", "last", 1234));
        queue.printQueue();
    }
}

class ArrayQueue {

    // OOP ENCAPSULATION private class fields
    private Employee[] queue;
    private int front;
    private int back;

    // OOP constructor that initializes the class fields on class/object instantiation
    public ArrayQueue(int capacity) {
        this.queue = new Employee[capacity];
    }

    // OOP CLASS METHODS: unique object behavior
    private int getSize() {

        boolean isWrapped = (this.front <= this.back);
        int wrappedSize = this.back - this.front;

        if(isWrapped) return wrappedSize;

        // ? CIRCULAR QUEUE: to handle negative number when wrapped circular queue size, to get numElements in wrapped queue simply add queueLength to previous calculation
        return wrappedSize + this.queue.length;
    }

    /**
     * add new Employee to the back of the queue
     */
    public void add(Employee employee) {

        // validate if queue is full & resize if full
        // ? CIRCULAR QUEUE: avoid resizing queue array if there is empty slots at the front of the array (size = back - front)
        if(this.getSize() == this.queue.length - 1) {

            Employee[] resizedArray = new Employee[2 * this.queue.length];

            // ? CIRCULAR QUEUE: when necessary to resize array, unwrap wrapped circular queue by copy elements at the front the end of the array
            int copyStart = 0;
            int copyEnd = this.queue.length - this.front;
            System.arraycopy(this.queue, this.front, resizedArray, copyStart, copyEnd);
            /*
                        0 - jane            ->      0 - mike
                        1 - john            ->      1 - bill
                        2        - back     ->      2        - back
                        3 - mike - front    ->      3 - mike - front
                        4 - bill            ->      4 - bill
             */

            System.arraycopy(this.queue, copyStart, resizedArray, this.queue.length - this.front, this.back);
             /*
                        0 - mike            ->      0 - mike - front
                        1 - bill            ->      1 - bill
                        2        - back     ->      2 - jane
                        3 - mike - front    ->      3 - john
                        4 - bill            ->      4 - addItem
                                                    5        - back
                                                    6
                                                    7
             */
            this.queue = resizedArray;
        }

        // add object to back of the queue
        this.queue[back] = employee;

        int lastQueueIndex = this.queue.length - 1;
        boolean isWrapped = this.back <= lastQueueIndex;

        this.back = isWrapped ? this.back + 1 : 0;
    }

    /**
     * remove first item that is at the front of the queue
     */
    public Employee remove() {

        // ! THROW EXCEPTION: initiate specific exception with provided error msg
        if(this.getSize() == 0) throw new NoSuchElementException();

        // FIFO: get employee at the front of the queue
        Employee employee = this.queue[this.front];

        // null-out first index and move front up by 1
        this.queue[this.front] = null;
        this.front++;

        boolean isEmptyQueue = this.getSize() == 0;
        boolean isFullyWrapped = this.front == this.queue.length;

        if(isEmptyQueue) {

            // if queue is empty after removal of front: reset queue
            this.back = 0;
            this.front = 0;

        } else if(isFullyWrapped) {

            // if queue fully wrapped, set front back to index 0 because no more unused space in queue
            this.front = 0;
        }

        return employee;
    }

    /**
     * preview only first item at the front of the queue
     * @return
     */
    public Employee peek() {

        // ! THROW EXCEPTION: initiate specific exception with provided error msg
        if(this.getSize() == 0) throw new NoSuchElementException();

        return this.queue[front];
    }

    public void printQueue() {
        // check if circular queue has wrapped
        if(this.front <= this.back) {

            // front index won't always be zero if added new object at zero
            for(int i = 0; i < this.back; i++) {
                System.out.println(this.queue[i]);
            }

        } else {
            /*
                start at index assigned front to end index
                * ex: forLoop will print: mike, bill

                        0 - jane
                        1 - john
                        2        - back
                        3 - mike - front
                        4 - bill
             */
            for(int i = 0; i < this.queue.length; i++) {
                System.out.println(this.queue[i]);
            }

            /*
                start at index 0 continue to assigned back index
                * ex: forLoop will print: jane, john

                        0 - jane
                        1 - john
                        2        - back
                        3 - mike - front
                        4 - bill
             */
            for(int i = 0; i < this.back; i++) {
                System.out.println(this.queue[i]);
            }
        }
    }
}