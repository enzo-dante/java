package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;

public class DS_Trees {

    /*
        ! TREES: a collection of 1 parent nodes & their respective children connected by edges

            every item in a tree is a node

            * Red-Black Tree: self-balancing tree will validate balanced nodes after each traversal w/ insert(), delete(), & get() of O(n) linear time complexity

            ? singleton tree: a tree with only one child node
                ex: node 22 below

            ? edge: each of the single descending connections

            ? subtree: if you start at any given node & it's the node and all of its descendants.
                ex: node 4 below

            ? path: a no-cycle sequence of nodes required to go from one node to another, for example,
                ex: node 4 -> node 9 -> node 7 below

            ? node depth: number of edges to a node from the root node
                how many edges does it take me to get up to the root from the start node

                ex: node 14 has a depth of 3

                ex: node 18 has a depth of 2

            ? node height: the number of edges on the longest path from the node to a leaf.
                ex: node 4 has a depth of 2

                ex: leaf nodes has a height of 0

                ex: the rode/tree has a height of 3

            ? ancestor: child nodes in the given node's path
                ex: node 4 is an ancestor of 15

            * Tree example:
                            15 (root node) LEVEL ZERO

                22          4                17 LEVEL ONE

           19         9    18    3         11  0    LEVEL TWO

                  25   7          14           (leaf: a node that doesn't have any children) LEVEL THREE

        ! BINARY TREE TRAVERSAL: move between nodes in a tree data structure left-to-right

            ? LEVEL TRAVERSAL: visit nodes on each level left-to-right

            * level order: 25, 20, 27, 15, 22, 26, 30, 29, 32

                                    25

                               20       27

                          15    22        26  30

                                                29 32

            ? PRE-ORDER TRAVERSAL: visit the root of the subtree first left-to-right
                PRE = visit root first

            * pre-order traversal: 25, 20, 15, 22, 27, 26, 30, 29, 32

                                    25

                               20       27

                          15    22        26  30

                                                29 32

            ? POST-ORDER TRAVERSAL: visit the root of every subtree last left-to-right

            * post-order traversal: 15, 22, 20, 26, 29, 32, 30, 27, 25

                                    25

                               20       27

                          15    22        26  30

                                                29 32

            ? IN-ORDER TRAVERSAL: visit the left-child, then root, then right-child (repeat process for subtrees)

             * in-order traversal: 15, 20, 22, 25, 26, 27, 29, 30, 32

                                    25

                               20       27

                          15    22        26  30

                                                29 32

        ! TREE DELETE TRAVERSAL:

            * original:
                                     25

                               20       27

                          15    22        26  30

                          17                     29 32

            ? delete node is a leaf: null out parent node's left or right child

            * null out 17
                                     25

                               20       27

                          15    22        26  30

                                                29 32

            ? delete node has one child: save leaf value, delete leaf &  replace it's value at the respective parent node

            * deleted 17 and replaced parent node value 15 with 17

                                     25

                               20       27

                          17    22        26  30

                                              29 32

            ? delete node has two children: get the largest value in left-subtree or the smallest value in right-subtree

            step 1: look for replacement node for minimal disruption from EITHER (NOT both) left or right subtree

            step 2a: if left subtree selected, take the largest value from the left subtree

                    * deleteTargetNode: 20
                    * subTreeRoot: 15
                    * look for replacementNode starting at the root of the subtree of the deleteTargetNode (the max in leftSubtree)
                    * max: completely traverse left edges of a left subtree until discovering a node without a right child
                    * max: 17
                        if 17 had a left child, 17 replaces 20 & the left child replaces 17 node value

                    * null out node15 child

                                             25

                                       20       27

                                  15    22        26  30

                                  17                     29 32

                    * post-delete
                                             25

                                       17       27

                                  15    22        26  30

                                                         29 32

            step 2b: if right subtree selected, take the largest value from the right subtree

                    * deleteTargetNode: 27
                    * subTreeRoot: 30
                    * look for replacementNode starting at the root of the subtree of the deleteTargetNode (the min in leftSubtree)
                    * min: completely traverse right edges of a right subtree until discovering a node without a left child
                    * min: 29
                        if 29 had a right child, 29 replaces 27 & the right child replaces 29 node value

                    * null out node15 child

                                             25

                                       20       27

                                  15    22        26  30

                                  17                     29 32

                    * post-delete

                                             25

                                       17       29

                                  15    22        26  30

                                                          32
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String NULL = "null";

    public static void main(String[] args) {

        Tree intTree = buildTree();
        intTree.traverseInOrder();

        Util.printSeparator();

        System.out.println(intTree.get(27).getData());

        try {
            System.out.println(intTree.get(17).getData());
        } catch(NullPointerException e) {
            System.out.println(NULL);
        }

        try {
            System.out.println(intTree.get(8888).getData());
        } catch(NullPointerException e) {
            System.out.println(NULL);
        }

        Util.printSeparator();

        System.out.println("min: " + intTree.min());
        System.out.println("max: " + intTree.max());

        Util.printSeparator();

        Tree tree15 = buildTree();
        Tree tree27 = buildTree();
        Tree tree25 = buildTree();

        tree15.traverseInOrder();

        Util.printSeparator();

        System.out.println("deleteNodeValue: 15");
        tree15.delete(15);
        tree15.traverseInOrder();

        Util.printSeparator();

        System.out.println("deleteNodeValue: 27");
        tree27.delete(27);
        tree27.traverseInOrder();

        Util.printSeparator();

        System.out.println("deleteNodeValue: 25");
        tree25.delete(25);
        tree25.traverseInOrder();

        Util.printSeparator();

        System.out.println("deleteNodeValue: 8888");
        intTree.delete(8888);
        intTree.traverseInOrder();

    }

    public static Tree buildTree() {

        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        return intTree;
    }
}

class Tree {

    // OOP ENCAPSULATION private class fields
    private TreeNode root;

    public void insert(int value) {

        // insert at first possible node
        if(this.root == null) {
            this.root = new TreeNode(value);

        } else {
            this.root.insert(value);
        }
    }

    public int min() {
        if(this.root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.getMin();
        }
    }

    public int max() {
        if(this.root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.getMax();
        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {

        // ? RECURSION base case/breaking condition: the algorithm either upward propagates recursive call return for stack resolution or experiences a stack overflow
        if(subtreeRoot == null) {
            return subtreeRoot;
        }

        // ? TREE NODE DELETE: traverse left side + replace subtreeRoot value onDelete
        if(value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(
                    delete(subtreeRoot.getLeftChild(), value)
            );

            // ? TREE NODE DELETE: traverse right side + replace subtreeRoot value onDelete
        } else if(value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(
                    delete(subtreeRoot.getRightChild(), value)
            );

            // ? TREE NODE DELETE case 0 & 1: located treeNode to delete in recursive traversal
        } else {

            // ? TREE NODE DELETE: node to delete has 0 or 1 children by always returning replacement node or same node
            if(subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();

            } else if(subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }

            // ? TREE NODE DELETE case 2: subtreeRoot/deleteTargetNode has 2 children & find min in rightSubtree or max in leftSubtree for replacement & deletion
            // traverse & replace the value in the subtreeRoot node w/ the smallest value from rightSubtree
            int min = subtreeRoot.getRightChild().getMin();
            subtreeRoot.setData(min);

            // delete the node that has the smallest value from rightSubtree
            int deleteSmallestNode = subtreeRoot.getData();
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), deleteSmallestNode));
        }

        return subtreeRoot;

    }

    public TreeNode get(int value) {

        System.out.print("get(" + value + "): ");

        if(this.root != null) {
            return this.root.get(value);
        }

        return null;
    }

    public void traverseInOrder() {

        System.out.println("In-order Traversal");

        if(root != null) {
            root.traverseInOrder();
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    // ! INNER CLASS: logically grouped components within an extending parent super class
    class TreeNode {

        // OOP ENCAPSULATION private class fields
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        // OOP constructor that initializes the class fields on class/object instantiation
        public TreeNode(int data) {
            this.data = data;
        }

        // OOP CLASS METHODS: unique object behavior
        public int getMin() {

            if(this.leftChild == null) {
                return this.data;
            } else {
                return this.leftChild.getMin();
            }
        }
        public int getMax() {

            if(this.rightChild == null) {
                return this.data;
            } else {
                return this.rightChild.getMax();
            }
        }

        public TreeNode get(int value) {

            if(value == data) {
                return this;
            }

            if(value < data) {
                if(leftChild != null) {
                    return this.leftChild.get(value);
                }

            } else {
                if(rightChild != null) {
                    return this.rightChild.get(value);
                }
            }

            return null;
        }

        public void traverseInOrder() {
            if(leftChild != null) {
                leftChild.traverseInOrder();
            }

            System.out.print(data + ", ");

            if(rightChild != null) {
                rightChild.traverseInOrder();
            }
        }

        public void insert(int value) {

            // No duplicate values allowed in implementation
            if(value == data) {
                return;
            }

            if(value < data) {

                if(this.leftChild == null) {

                    // found leaf node for insertion
                    this.leftChild = new TreeNode(value);

                } else {

                    // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
                    leftChild.insert(value);
                }

            } else {

                if(this.rightChild == null) {

                    // found leaf node for insertion
                    this.rightChild = new TreeNode(value);

                } else {

                    // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
                    rightChild.insert(value);
                }
            }
        }

        // OOP getters & setters
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }
}