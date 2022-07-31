package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

import java.util.*;

import static com.crownhounds.datastructures_and_algorithms.AlgorithmNotes.intArray;
import static com.crownhounds.datastructures_and_algorithms.AlgorithmNotes.prepareData;

public class Algorithms_Search {
    /*
        ! SEARCH ALGORITHM: find a value in a data structure via LINEAR SEARCH or BINARY SEARCH

        ! LINEAR SEARCH: O(n) linear time complexity traversal beginning-end by incrementing index by 1 until searched item found

            * O(n) LINEAR TIME COMPLEXITY: loop through array 1 index at a time

        ! BINARY SEARCH: O(logn) logarithmic time complexity traversal in already SORTED array & is recursively LEFT/RIGHT partitioned until respective middle element equals search value else null

            * O(logn) LOGARITHMIC TIME COMPLEXITY: keep dividing sorted array in half

            ? BINARY SEARCH LOGIC

                * data being searching MUST ALREADY be sorted

                searchValue = 55

                            [-22, -15, 1, 7, 20, 35, 55] where midpoint: 7

                                            [7, 20, 35, 55] where midpoint: 35

                                                [35, 55] where midpoint == searchValue (55)

                                                    return 55

            STEP 1: divide the array down the middle into 2 partitions

                * similar to MERGE sort

                LEFT half = lesser values respective to parent node midpoint

                RIGHT half = greater values respective to parent node midpoint

            STEP 2: compare middle element against searchValue

                2A: if equal we've finished search traversal

                2B: else if less than focus on the LEFT side, and recursively repeat STEP 1 partitioning

                2C: else if greater than focus on the RIGHT side, and recursively repeat STEP 1 partitioning

            STEP 3: recursive calls will gradually traverse down to a sorted one-element partition and either return found searchValue or null
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String NOT_FOUND = " searchValue not found";
    private static final String BINARY_SEARCH_RESULT = "\nbinarySearch():\n\t";
    private static final String LINEAR_SEARCH_RESULT = "\nlinearSearch():\n\t";
    private static final String FOUND_AT = " found at index ";

    public static void main(String[] args) {

        int result;
        int searchValue;

        Util.printSeparator("AlgorithmsSearch Algorithms");

        System.out.println("Binary AlgorithmsSearch" +
                "\n\tdata must already be sorted before being processed\n");

        int[] mergeSortArray = MergeSort.runAlgorithm();

        searchValue = 55;
        result = binarySearch(mergeSortArray, searchValue);
        System.out.println(BINARY_SEARCH_RESULT + mergeSortArray[result] + FOUND_AT + result);

        Util.printSeparator();

        searchValue = 88;
        result = binarySearch(mergeSortArray, searchValue);

//        ! EXCEPTION HANDLING: EASY TO ASK FOR FORGIVENESS THAN PERMISSION (EAFTP) = use try-catch block
        try {

            System.out.println(BINARY_SEARCH_RESULT + mergeSortArray[result] + FOUND_AT + result);

        } catch(ArrayIndexOutOfBoundsException e) {

            System.out.println(BINARY_SEARCH_RESULT + searchValue + NOT_FOUND);
            System.out.println(e.getMessage());
        }

        Util.printSeparator();

        prepareData("Linear AlgorithmsSearch", intArray);

        searchValue = -15;
        result = linearSearch(intArray, searchValue);
        System.out.println(LINEAR_SEARCH_RESULT + intArray[result] + FOUND_AT + result);

        Util.printSeparator();

        searchValue = 13;
        result = linearSearch(intArray, searchValue);

//        ! EXCEPTION HANDLING: LOOK BEFORE YOU LEAP (LBYL) = use conditional if-else block
        if(result > 0) {
            System.out.println(LINEAR_SEARCH_RESULT + intArray[result] + FOUND_AT + result);
        } else {
            System.out.println(LINEAR_SEARCH_RESULT + searchValue + NOT_FOUND);
        }

        Util.printSeparator();

        Util.printSeparator("Depth First Search a GRAPH of nodes");

        GraphDFS depthFirstSearch = new GraphDFS();
        depthFirstSearch.addEdge(0, 1);
        depthFirstSearch.addEdge(1, 2);
        depthFirstSearch.addEdge(2, 3);
        depthFirstSearch.printGraph();

        Util.printSeparator("Breath First Search a GRAPH of nodes");

        GraphBFS breathFirstSearch = new GraphBFS();
        breathFirstSearch.addEdge(0, 1);
        breathFirstSearch.addEdge(1, 2);
        breathFirstSearch.addEdge(2, 3);
        breathFirstSearch.printGraph();

    }

    private static int linearSearch(int[] intArray, int searchValue) {

        for(int index = 0; index < intArray.length; index++ ) {

            if(intArray[index] == searchValue) {
                return index;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] intArray, int searchValue) {

        prepareData("Binary AlgorithmsSearch", intArray);

        // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        // ? STEP 1: divide the array down the middle into 2 partitions

        return recursivePartition(intArray, 0, intArray.length, searchValue);
    }

    private static int recursivePartition(int[] intArray, int start, int end, int searchValue) {

        // ! RECURSION base case/breaking condition: the algorithm either upward propagates recursive call return for stack resolution or experiences a stack overflow
        boolean breakingCondition = start >= end;

        // ? STEP 3: recursive calls will gradually traverse down to a sorted one-element partition and either return found searchValue or null
        if(breakingCondition) {
            return -1;
        }

        // ? STEP 2: compare middle element against searchValue
        int midpoint = (start + end) / 2;

        // ! GENERIC CLASS: improve ENCAPSULATION by enforcing element dataType with parameter
        ArrayList<Integer> partition = new ArrayList<>();

        if(intArray[midpoint] == searchValue) {

//        ! EXCEPTION HANDLING: EASY TO ASK FOR FORGIVENESS THAN PERMISSION (EAFTP) = use try-catch block
            try {
                System.out.println("\nsearchValue " + searchValue + " == midpoint " + intArray[midpoint]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

            return midpoint;

        } else if(intArray[midpoint] < searchValue) {

            int rightIndex = midpoint + 1;

            viewPartition(rightIndex, end, midpoint, intArray, false);

            return recursivePartition(intArray, rightIndex, end, searchValue);

        } else {

            int leftIndex = midpoint - 1;

            viewPartition(leftIndex, end, midpoint, intArray, true);

            return recursivePartition(intArray, 0, leftIndex, searchValue);
        }
    }

    private static void viewPartition(int start, int end, int midpoint, int[] intArray, boolean isLeftSide) {

        ArrayList<Integer> partition = new ArrayList<>();

        if(isLeftSide) {
            for(int i = end; i > start; i--) {
                partition.add(intArray[i]);
            }

        } else {
            for(int i = start; i < end; i++) {
                partition.add(intArray[i]);
            }
        }
//        System.out.println("\nnew partition (post-midpoint split):\n\t" + partition + " - midpoint: " + midpoint + ", elementValue: " + intArray[midpoint]);
        System.out.println("\n\t"+ partition + " - indexMidpoint: " + midpoint + ", elementValue: " + intArray[midpoint] + ", isLeftSide: " + isLeftSide);
    }
}

class GraphDFS {
    /*
        ! DEPTH FIRST SEARCH: recursively, check if the currentNode has any children (left-to-right) that has the search path for the target node
            hasPath(s, t): recursively, nodeS do you have a path to nodeT?
            nodeS asks (left-to-right) it's child if it has a path to nodeT, repeat until reached nodeT or null
     */

    // OOP ENCAPSULATION private class fields
    // ! MAPS INTERFACE: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
    // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
    private HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();

    // ! INNER CLASSES: logically grouped subclass that needs a base class instance to execute functionality
    // ! STATIC FIELD: a single memory unique class-level shared variable belong to class blueprint and NOT with any specific instances
    public static class Node {

        // OOP ENCAPSULATION private & public class fields
        private int id;
        // ! LINKED LISTS: default doubly dataStructure that imposes order by storing the currentElement value as well as the pointer/link to the nextElement
        public LinkedList<Node> adjacent = new LinkedList<>();

        // OOP constructor that initializes the class field on class/object instantiation
        private Node(int id) {
            this.id = id;
        }

        public String toString() {
            return "NodeId=" + id +
                    "\n\tadjacentNodes=" + adjacent;
        }
    }

    // OOP CLASS METHODS: unique object behavior
    public void printGraph() {

        // ! MAP use hashmapInstance.keySet() + hashmapInstance.get(key) = loop through map & return all key-value pairs
        for(Integer nodeId : nodeLookUp.keySet()) {
            System.out.println(nodeLookUp.get(nodeId).toString());
        }
    }

    private Node getNode(int id) {

        if(nodeLookUp.containsKey(id)) {
            return nodeLookUp.get(id);
        }
        // ! MAPS hashmapInstance.get(key) = retrieve record via key in map collection
        return new Node(id);
    }

    public void addEdge(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);

        // ! linkedList.add(index, newElement) = add new element at index of a linkedList by handling pointers
        sourceNode.adjacent.add(destinationNode);
        nodeLookUp.put(sourceNode.id, sourceNode);
        nodeLookUp.put(destinationNode.id, destinationNode);
    }

    public boolean hasPathDepthFirstSearch(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);

        // ! SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class
        HashSet<Integer> visited = new HashSet<>();

        return hasPathDepthFirstSearch(sourceNode, destinationNode, visited);
    }

    // ! METHOD OVERLOADING: when you use the same method name but with unique set of parameters
    private boolean hasPathDepthFirstSearch(Node source, Node destination, Set<Integer> visited) {

        boolean hasVisitedNode = visited.contains(source.id);
        boolean reachedDestination = source == destination;
        boolean hasPathToDestination;

        // ! RECURSION baseCase: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        if(hasVisitedNode) {
            hasPathToDestination = false;
            return hasPathToDestination;
        }

        // flag node as visited
        visited.add(source.id);

        if(reachedDestination) {

            hasPathToDestination = true;
            return hasPathToDestination;
        }

        // search for possible paths from children
        for(Node childNode : source.adjacent) {

            // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
            if(hasPathDepthFirstSearch(childNode, destination, visited)) {

                hasPathToDestination = true;
                return hasPathToDestination;
            }
        }
        hasPathToDestination = false;
        return hasPathToDestination;
    }
}

class GraphBFS {
    /*
        hasPath(s, t): recursively, does nodeS do you have a path to nodeT?

            nodeS checks if any of it's children are nodeT, if no edges to first level children, then check next level and repeat
     */

    // OOP ENCAPSULATION private class fields
    // ! MAPS INTERFACE: collection of key-value pair HASHMAP implementations that use GENERIC CLASS dataStructures w/ 2 parameters: UNIQUE key & value
    // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take a specific dataType parameter
    private HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();

    // ! INNER CLASSES: logically grouped subclass that needs a base class instance to execute functionality
    // ! STATIC FIELD: a single memory unique class-level shared variable belong to class blueprint and NOT with any specific instances
    public static class Node {

        // OOP ENCAPSULATION private & public class fields
        private int id;
        // ! LINKED LISTS: default doubly dataStructure that imposes order by storing the currentElement value as well as the pointer/link to the nextElement
        public LinkedList<Node> adjacent = new LinkedList<>();

        // OOP constructor that initializes the class field on class/object instantiation
        private Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "NodeId=" + id +
                    "\n\tadjacentNodes=" + adjacent;
        }
    }

    // OOP CLASS METHODS: unique object behavior

    public void printGraph() {
        // ! MAP use hashmapInstance.keySet() + hashmapInstance.get(key) = loop through map & return all key-value pairs
        for(Integer nodeId : nodeLookUp.keySet()) {
            System.out.println(nodeLookUp.get(nodeId).toString());
        }
    }

    private Node getNode(int id) {
        if(nodeLookUp.containsKey(id)) {
            return nodeLookUp.get(id);
        }
        // ! MAPS hashmapInstance.get(key) = retrieve record via key in map collection
        return new Node(id);
    }

    public void addEdge(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);

        // ! linkedList.add(index, newElement) = add new element at index of a linkedList by handling pointers
        sourceNode.adjacent.add(destinationNode);
        nodeLookUp.put(sourceNode.id, sourceNode);
        nodeLookUp.put(destinationNode.id, destinationNode);
    }

    public boolean hasPathBreadthFirstSearch(int sourceId, int destinationId) {

        // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
        return hasPathBreadthFirstSearch(getNode(sourceId), getNode(destinationId));
    }

    // ! METHOD OVERLOADING: when you use the same method name but with unique set of parameters
    private boolean hasPathBreadthFirstSearch(Node source, Node destination) {

        // ! LINKED LISTS: default doubly dataStructure that imposes order by storing the currentElement value as well as the pointer/link to the nextElement
        LinkedList<Node> nextToVisit = new LinkedList<>();
        // ! SETS INTERFACE: a computationally fast unordered collection without any duplicates implemented via HASHSET class
        HashSet<Integer> visited = new HashSet<>();
        boolean hasPathToDestination;

        // start at sourceNode
        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()) {

            // ! linkedList.remove(element) = remove element at index of a linkedList by handling pointers
            Node node = nextToVisit.remove();
            boolean reachedDestination = (node == destination);
            boolean hasVisitedNode = visited.contains(node.id);

            // ! RECURSION baseCase: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
            if(reachedDestination) {
                hasPathToDestination = true;
                return hasPathToDestination;
            }

            if(hasVisitedNode) {
                continue;
            }

            // flag node as visited
            visited.add(node.id);

            // add children nodes to build graph for traversal level by level
            for(Node childNode : node.adjacent) {
                nextToVisit.add(childNode);
            }
        }

        hasPathToDestination = false;
        return hasPathToDestination;
    }
}