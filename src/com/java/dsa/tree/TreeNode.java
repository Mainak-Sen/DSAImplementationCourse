package com.java.dsa.tree;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    //inserting
    public void insert(int value) {
        if (value == data) {
            return;
        } else if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    //inorder Traversal
    public void inorderTraversal() {

        if (leftChild != null) {
            leftChild.inorderTraversal();
        }
        //print the node
        System.out.print(data + " ");
        //rightTraversal
        if (rightChild != null) {
            rightChild.inorderTraversal();
        }
    }

    //oreorder Traversal
    public void preorderTraversal() {

        //print root
        System.out.print(data + " ");

        //left traversal
        if (leftChild != null) {
            leftChild.preorderTraversal();
        }
        //rightTraversal
        if (rightChild != null) {
            rightChild.preorderTraversal();
        }
    }

    //search for a value in the tree
    public TreeNode getValue(int value) {
        if (value == data) {
            return this;
        } else if (value < data) {
            if (leftChild != null) {
                return leftChild.getValue(value);
            } else {
                return null;//no way we can find the value if we reach here ,hence returning null
            }
        } else {
            if (rightChild != null) {
                return rightChild.getValue(value);
            } else {
                return null;//no way we can find the value if we reach here ,hence returning null
            }
        }
    }

    public int getMin() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.getMin();
        }
    }

    public int getMax() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.getMax();
        }
    }

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

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
