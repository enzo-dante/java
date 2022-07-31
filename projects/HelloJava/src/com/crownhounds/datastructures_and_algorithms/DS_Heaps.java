package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.PriorityQueue;

public class DS_Heaps {

    /*
        ! HEAPS: a complete binary tree w/ array-backing, only interested in  min & max at ROOT of tree O(1) time complexity that functions left-to-right

            node at array[i]

                leftChild_index = 2i + 1

                rightChild_index = 2i + 2

                parent_index = floor((i-1) / 2)

            * ex: 15 at index_3 in [22, 19, 18, 15, 3, 14, 4, 12]

                leftChild_index = 2(3) + 1 = index_7 = 12

                rightChild_index = 2(3) + 2 = index_8 = out-of-bounds, so no child

                parent_index = floor((3-1) / 2) = index_1 = 19

        ! PRIORITY QUEUES HEAPS: max HEAP implementation w/ array backing always want the highest priority item first at O(1) constant time complexity
            insert() = add()
            poll() = remove()
            peak() = getRoot

        ! Java class PRIORITY QUEUE is a MIN HEAP = lower the number, the higher the priority
            FOR MAX HEAP: you'd need a comparator that will look at the two values and whenever you have one value greater than the other you in fact want to return that that value's less.

        ? HEAPIFY: the process of converting a binary tree into a heap after inserting or deleting a node

        ? HEAP peek(): O(1) constant time complexity to fix by swap replacement item up to root
            get root

        ? HEAP insert(): O(logn) logarithmic time complexity to fix by swap new item up to root

            step 1: always add to end

            step 2: heapify()

            step 3: compare new item against parent

            step 4: if greater than parent, then swap

            step 5: repeat

                * ex: add 20 as child to 15 parent

                                    22

                               19       18

                       15     3             14     4

                   12

                * since 20 is greater than 15 parent, swap

                                    22

                               19       18

                       20     3             14     4

                 12   15

                * since 20 is greater than 19 parent, swap, afterwards the complete tree has been HEAPIFIED()

                                    22

                               20       18

                       19     3             14     4

                 12   15

        ? HEAP delete(): O(logn) logarithmic time complexity to fix by swap replacement item up to root

            step 1: find replacementValue

            step 2: always take rightmost value to keep tree complete

            * only need to 3A or 3B, but not both
            step 3A heapify(): if replacementValue greater than parent, then fixHeapAbove, swap replacementValue w/ parent

            step 3B heapify(): if replacementValue lesser than parent, then fixHeapBelow, swap replacementValue w/ larger of two children

            step 5: repeat until replacementValue in correct index

                ! ex) delete 75; replacementValue 67

                                    80

                               75       60

                        68    55          40  52

                    67

                * deleted 75

                                    80

                               67       60

                        68    55          40  52

                * heapify() = fixHeapBelow

                                    80

                               68       60

                        67    55          40  52

                ! ex) delete 40; replacementValue 67

                                    80

                               75       60

                        68    55          40  52

                    67

                * deleted 40

                                    80

                               75       60

                        68    55          67  52

                * heapify() = fixHeapAbove

                                    80

                               75       67

                        68    55          60  52

        ? MAX HEAP: every parent has to have a value greater than or equal to its children in a complete binary tree

                Traversing down to every leaf, all the values along each path should be in descending order.

                                    22

                               19       18

                       15     3             14     4

                   12

        ? MAX HEAP SORT: sort nodes in a max heap

                step 1: root has the largest value

                step 2: swap root w/ last element in the array

                step 3: heapify(), excluding last node

                step 4: after heapify(), the second largest element is at the root

                step 5: repeat

                ! ex) max heap sort

                                    80

                               75       60

                        68    55          40  52

                    67
                                    67

                               75       60

                        68    55          40  52

                    80

                    * must heapify() index 0 - index 6

                                    75

                               68       60

                        67    55          40  52

                    80

                                     52

                               68       60

                        67    55          40  75

                    80

                    * repeat: must heapify() index 0 - index 5 until root index is left after heapify()

        ? MIN HEAP: every parent has to have a value that is less than or equal to its children in a complete binary tree

                Travelling from the root down to the leaves, all the paths would be in ascending order

                if you start at a leaf and travel up to the root, all the paths would be in descending order
     */

    public static void main(String[] args) {

        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        Util.printSeparator("Heap");

        System.out.println("original:");
        heap.printHeap();

        Util.printSeparator("Heap Peak");
        System.out.println("heap root: " + heap.peek());


        Util.printSeparator("Heap Delete");

        heap.printHeap();
//        heap.delete(1);
//        heap.delete(5);
        heap.delete(0);
        heap.printHeap();

        Util.printSeparator("Priority Queue (Java class MIN HEAP)");
        PriorityQueue pq = new PriorityQueue();
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        Object[] pqToArray = pq.toArray();
        for(Object e : pqToArray) {
            System.out.print(e + ", ");
        }

        Util.printSeparator();

        // ! Java class PRIORITY QUEUE is a MIN HEAP = lower the number, the higher the priority
        System.out.println("peak(): " + pq.peek());
        System.out.println("remove(): " + pq.remove());
        System.out.println("peak(): " + pq.peek());

        Util.printSeparator();

        // ? poll() & remove() are the same
        System.out.println("poll(): " + pq.poll());
        System.out.println("peak(): " + pq.peek());

        Util.printSeparator();

        System.out.println("remove(54): " + pq.remove(54));
        System.out.println("peak(): " + pq.peek());

        Util.printSeparator();

        System.out.println("add(-1): " + pq.add(-1));
        System.out.println("peak(): " + pq.peek());

        Util.printSeparator();
        pq = new PriorityQueue();
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        System.out.println("PRE-maxHeap.sort()");

        Heap heap2 = new Heap(10);
        heap2.insert(80);
        heap2.insert(75);
        heap2.insert(60);
        heap2.insert(68);
        heap2.insert(55);
        heap2.insert(40);
        heap2.insert(52);
        heap2.insert(67);

        heap2.printHeap();
        heap2.sort();

        System.out.println("WRONG: POST-maxHeap.sort()");
        heap2.printHeap();

    }
}

class Heap {

    // CONSTANTS/static class variables assigned FINAL value before compilation
    private static final String HEAP_FULL = "Heap is full";
    private static final String HEAP_EMPTY = "Heap is empty";

    // OOP ENCAPSULATION private class fields
    private int[] heap;
    private int size;

    public Heap(int capacity) {
        this.heap = new int[capacity];
    }

    // OOP CLASS METHODS: unique object behavior

    public void sort() {

        int lastHeapIndex = this.size - 1;

        for(int i = 0; i < lastHeapIndex; i++) {

            // the heap root = largest value in heap
            int tempRootValue = this.heap[0];

            // ? swap root for last node in heap
            this.heap[0] = this.heap[lastHeapIndex - i];
            this.heap[lastHeapIndex - i] = tempRootValue;

            // ? heapify() & reduce heap by 1 (exclude swapped value) on every root-last index swap
            int adjustedLastIndex = lastHeapIndex - i - 1;
            fixHeapBelow(0, adjustedLastIndex);
        }
    }

    public boolean isEmtpy() {
        return this.size == 0;
    }

    public int getChild(int parentIndex, boolean isLeftChild) {
        return 2 * parentIndex + (isLeftChild ? 1 : 2);
    }

    public void printHeap() {

        for(int i = 0; i < this.size; i++) {
            System.out.print(heap[i] + ", ");
        }

        Util.printSeparator();
    }

    public int peek() {

        if(isEmtpy()) {
            throw new IndexOutOfBoundsException(HEAP_EMPTY);
        }

        return this.heap[0];
    }

    public int delete(int index) {
        // ! HEAP: always take the root

        if(this.isEmtpy()) {
            // ! THROW EXCEPTION: initiate specific exception with provided error msg
            throw new IndexOutOfBoundsException(HEAP_EMPTY);
        }

        // ? HEAP step 1: find replacementValue
        int parentIndex = getParent(index);
        int deleteValue = this.heap[index];

        // ? HEAP step 2: always take rightmost value to keep tree complete
        this.heap[index] = this.heap[this.size - 1];

        // ? HEAP step 3: heapify()
        boolean isRoot = index == 0;
        boolean isReplacementLessThanParent = this.heap[index] < this.heap[parentIndex];

        if(isRoot || isReplacementLessThanParent) {
            fixHeapBelow(index, this.size -1);
        } else {
            fixHeapAbove(index);
        }

        this.size--;
        return deleteValue;
    }

    public void insert(int value) {
        if(isFull()) {
            throw new IndexOutOfBoundsException(HEAP_FULL);
        }
        this.heap[this.size] = value;

        // pass index where we have placed the newValue
        fixHeapAbove(this.size);
        this.size++;
    }

    /**
     * heapify()
     * @param index the index of the deleted element
     * @param lastHeapIndex last position of the heap in the array
     */
    private void fixHeapBelow(int index, int lastHeapIndex) {

        int childToSwap;

        while(index >= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            boolean hasLeftChild = leftChild <= lastHeapIndex;
            boolean hasRightChild = rightChild < lastHeapIndex;

            // ? HEAPS: must be a compelete tree (NOT ALLOWED: no left child but has a right child)
            if(hasLeftChild) {
                if(!hasRightChild) {
                    childToSwap = leftChild;

                } else {
                    int greatestChildValue = this.heap[leftChild] > this.heap[rightChild] ? leftChild : rightChild;
                    childToSwap = greatestChildValue;
                }

                int replacementValue = this.heap[index];

                if(replacementValue < this.heap[childToSwap]) {

                    // ? HEAP: swap replacementValue with largest child
                    this.heap[index] = this.heap[childToSwap];
                    this.heap[childToSwap] = replacementValue;

                } else {
                    break;
                }

                index = childToSwap;

            } else {
                break;
            }
        }
    }

    /**
     * heapify()
     * @param index child index
     */
    public void fixHeapAbove(int index) {
        int newValue = this.heap[index];

        // ? HEAPIFY: compare new item against parent, if greater than parent, then shift parent down, repeat
        while(index > 0 && newValue > heap[getParent(index)]) {

            this.heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        // on discovering correct index for newValue, then insert
        this.heap[index] = newValue;
    }

    public boolean isFull() {
        return this.size == this.heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

}