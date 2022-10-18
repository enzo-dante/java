package com.crownhounds.datastructures_and_algorithms;

import com.crownhounds.masterjava.Util;
import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class DS_Trees {

    /*
        ! BINARY TREES: a collection of 1 parent node to respective 2 children nodes with parent child connection edges and left-to-right node movement depends on child value comparisons

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

            * level order: [25, 20, 27, 15, 22, 26, 30, 29, 32]

                                    25

                               20       27

                          15    22        26  30

                                                29 32

            ? PRE-ORDER TRAVERSAL: visit the main root first, next the root of the subtree, children left-to-right, and repeat
                PRE = visit root first

            * pre-order: [25, 20, 15, 22, 27, 26, 30, 29, 32]

                                    25

                               20       27

                          15    22        26  30

                                                29 32

            ? POST-ORDER TRAVERSAL: visit the root of every subtree last left-to-right

            * post-order: [15, 22, 20, 26, 29, 32, 30, 27, 25]

                                    25

                               20       27

                          15    22        26  30

                                                29 32

            ? IN-ORDER TRAVERSAL: visit the left-child, then root, then right-child (repeat process for subtrees)

             * in-order: [15, 20, 22, 25, 26, 27, 29, 30, 32]

                                    25

                               20       27

                          15    22        26  30

                                                29 32
     */

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String NULL = "null";

    public static void main(String[] args) {

        BinaryTree intTree = buildTree();
        intTree.traverseInOrder();

        Util.printSeparator();

        System.out.println(intTree.getNode(27).getData());

        try {
            System.out.println(intTree.getNode(17).getData());
        } catch(NullPointerException e) {
            System.out.println(NULL);
        }

        try {
            System.out.println(intTree.getNode(8888).getData());
        } catch(NullPointerException e) {
            System.out.println(NULL);
        }

        Util.printSeparator();

        System.out.println("min: " + intTree.getMin());
        System.out.println("max: " + intTree.getMax());

        Util.printSeparator();

        BinaryTree tree15 = buildTree();
        BinaryTree tree27 = buildTree();
        BinaryTree tree25 = buildTree();

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

    public static BinaryTree buildTree() {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insertNode(25);
        binaryTree.insertNode(20);
        binaryTree.insertNode(15);
        binaryTree.insertNode(27);
        binaryTree.insertNode(30);
        binaryTree.insertNode(29);
        binaryTree.insertNode(26);
        binaryTree.insertNode(22);
        binaryTree.insertNode(32);

        return binaryTree;
    }
}

class BinaryTree {

    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String EMPTY_TREE = "This binary tree is empty";
    private static final String IN_ORDER_TRAVERSAL = "In-order Traversal";

    // OOP ENCAPSULATION private class fields
    private TreeNode root;

    // OOP CONSTRUCTOR that initializes the class fields & INTRINSIC LOCK on class/object instantiation
    public BinaryTree() {
        this.root = null;
    }

    // CLASS METHODS: unique object behavior
    // ACCESS-MODIFIER protected: accessibility the variable or method is limited to the scope of the defining class & it's OOP INHERITANCE subclasses within the package
    public boolean isEmpty() {
        return this.root == null;
    }

    public void traverseInOrder() {

        if(isEmpty()) return;

        System.out.println(IN_ORDER_TRAVERSAL);
        this.root.traverseInOrder();
    }

    public void insertNode(int value) {
        if(isEmpty()) {
            this.root = new TreeNode(value);
        } else {
            this.root.insertNode(value);
        }
    }

    // METHOD OVERLOADING: use same name, but with unique parameters, for related methods to reduce tech debt and optimize readability & scalability
    public void delete(int value) {
        this.root = delete(this.root, value);
    }

    /*
       ! BINARY TREE DELETE TRAVERSAL: recursively traverse binary tree for position of node to delete, delete node, and shift replacement node into position to maintain sorted order & maintain tree integrity

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

           ? delete node has one child: save leaf value, delete leaf &  replace its value at the respective parent node

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
    private TreeNode delete(TreeNode subtreeRoot, int value) {

        // ! RECURSION BASE CASE: the breaking condition that initiates an upward propagation of return values for the waiting calls resulting in call-stack resolution or overflow
        boolean isBaseCase = (subtreeRoot == null);
        if(isBaseCase) return subtreeRoot;

        boolean inLeftChild = (value < subtreeRoot.getData());
        boolean inRightChild = (value > subtreeRoot.getData());

        if(inLeftChild) {

            // ! TREE NODE DELETE: traverse left side + replace subtreeRoot value on delete
            subtreeRoot.setLeftChild(
                    // ! RECURSION: continuously self-calling algorithm & each call waits for a return value until reaching a base case or experiences a stack overflow
                    delete(subtreeRoot.getLeftChild(), value)
            );

        } else if(inRightChild) {

            // ! TREE NODE DELETE: traverse right side + replace subtreeRoot value onDelete
            subtreeRoot.setRightChild(
                    // ! RECURSION: continuously self-calling algorithm & each call waits for a return value until reaching a base case or experiences a stack overflow
                    delete(subtreeRoot.getRightChild(), value)
            );

        } else {

            boolean isEmptyLeftChild = (subtreeRoot.getLeftChild() == null);
            boolean isEmptyRightChild = (subtreeRoot.getRightChild() == null);

            // TREE NODE DELETE: node to delete has 0 or 1 children by always returning replacement node or same node
            if(isEmptyLeftChild) {

                return subtreeRoot.getRightChild();

            } else if(isEmptyRightChild) {

                return subtreeRoot.getLeftChild();
            }

            // ? TREE NODE DELETE case 2: subtreeRoot/deleteTargetNode has 2 children & find min in rightSubtree or max in leftSubtree for replacement & deletion
            int minimumRightLeaf = subtreeRoot.getRightChild().getMin();
            subtreeRoot.setData(minimumRightLeaf);

            // delete the node that has the smallest value from rightSubtree
            int deleteSmallestNode = subtreeRoot.getData();
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), deleteSmallestNode));
        }
        return subtreeRoot;
    }

    public int getMin() {
        if(isEmpty()) {
            System.out.println(EMPTY_TREE);
            return Integer.MIN_VALUE;
        } else {
            return this.root.getMin();
        }
    }

    public int getMax() {
        if(isEmpty()) {
            System.out.println(EMPTY_TREE);
            return Integer.MIN_VALUE;
        } else {
            return this.root.getMax();
        }
    }

    public TreeNode getNode(int value) {
        // EXCEPTION HANDLING look before you leap: use if-else statement to handle errors
        if(isEmpty()) return null;

        return this.root.getNode(value);
    }

    // OOP GETTERS & SETTERS
    public TreeNode getRoot() {
        return this.root;
    }

    // INNER CLASS: logically grouped components within an extending parent super class
    protected class TreeNode {

        // OOP ENCAPSULATION private class fields
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        // OOP constructor that initializes the class fields on class/object instantiation
        public TreeNode(int data) {
            this.data = data;
        }

        // OOP CLASS METHODS: unique object behavior
        /**
         * get values lowest-to-highest by traversing the left-child, then root, then right-child, and repeat
         */
        public void traverseInOrder() {

            boolean hasLeftChild = (this.leftChild != null);

            if(hasLeftChild) {
                this.leftChild.traverseInOrder();
            }

            System.out.print(this.data + ", ");

            boolean hasRightChild = (this.rightChild != null);

            if(hasRightChild) {
                this.rightChild.traverseInOrder();
            }
        }

        /**
         * recursively traverse down binary tree left-to-right for insertion node position by comparing the current node's left & right child values
         * @return searched node or null
         */
        public void insertNode(int value) {

            // No duplicate values allowed in implementation
            boolean isDuplicateValue = (value == this.data);

            if(isDuplicateValue) return;

            boolean inLeftChild = (value < this.data);

            if(inLeftChild) {

                boolean foundInsertionLeftNode = (this.leftChild == null);

                if(foundInsertionLeftNode) {

                    this.leftChild = new TreeNode(value);

                } else {

                    // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
                    this.leftChild.insertNode(value);
                }
            } else {

                boolean foundInsertionRightNode = (this.rightChild == null);

                if(foundInsertionRightNode) {

                    this.rightChild = new TreeNode(value);

                } else {

                    // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
                    this.rightChild.insertNode(value);
                }
            }
        }

        /**
         * left-to-right recursively traverse down binary tree for node value by comparing the current node's 2 child values
         *
         * @return searched node or null
         */
        public TreeNode getNode(int value) {

            // ! RECURSION BASE CASE: the breaking condition that initiates an upward propagation of return values for the waiting calls resulting in call-stack resolution or overflow
            boolean isBaseCase = (value == this.data);

            if(isBaseCase) return this;

            boolean inLeftChild = (value < this.data);

            if(inLeftChild) {

                boolean hasLeftChild = (this.leftChild != null);

                if(hasLeftChild) {
                    // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
                    return this.leftChild.getNode(value);
                }

            } else {

                boolean hasRightChild = (this.rightChild != null);

                if(hasRightChild) {
                    // ! RECURSION: an algorithm calls itself & each call is placed on the call stack waiting for a return value until the algorithm can no longer call itself (the base case/breaking condition)
                    return this.rightChild.getNode(value);
                }
            }
            return null;
        }

        /**
         * left-to-right recursively traverse down binary tree for LEFT-MOST node with min value
         * @return min value
         */
        public int getMin() {

            // ! RECURSION BASE CASE: the breaking condition that initiates an upward propagation of return values for the waiting calls resulting in call-stack resolution or overflow
            boolean isBaseCase = (this.leftChild == null);

            if(isBaseCase) {
                return this.data;
            }

            // ! RECURSION: continuously self-calling algorithm & each call waits for a return value until reaching a base case or experiences a stack overflow
            return this.leftChild.getMin();
        }

        /**
         * left-to-right recursively traverse down binary tree for RIGHT-MOST node with max value
         * @return max value
         */
        public int getMax() {

            // ! RECURSION BASE CASE: the breaking condition that initiates an upward propagation of return values for the waiting calls resulting in a call-stack resolution or overflow
            boolean isBaseCase = (this.rightChild == null);

            if(isBaseCase) {
                return this.data;
            }

            // ! RECURSION: continuously self-calling algorithm & each call waits for a return value until reaching a base case or experiences a stack overflow
            return this.rightChild.getMax();
        }

        // OOP GETTERS & SETTERS
        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }
}