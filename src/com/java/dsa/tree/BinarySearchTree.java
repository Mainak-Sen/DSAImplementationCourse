package com.java.dsa.tree;

public class BinarySearchTree {

    private TreeNode root;

   /* treenode has only root ,so we are going to start from root ,so we are going to call TreeNode functions on the
    root here*/

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInorder() {
        if (root != null) {
            root.inorderTraversal();
        }
    }

    public void traversePreorder() {
        if (root != null) {
            root.preorderTraversal();
        }
    }

    public TreeNode getValue(int value) {

        if (root != null) {
            return root.getValue(value);
        } else {
            return null;
        }
    }

    public int getMin() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.getMin();
        }
    }

    public int getMax() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.getMax();
        }
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {

        if (subTreeRoot == null) {
            return subTreeRoot;
        }
        //finding phase
        //case when the value we want to delete is less than subtree root ,we need to recursively look for it in left
        if (value < subTreeRoot.getData()) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
            //case when the value we want to delete is greater than subtree root ,we need to recursively look for it in right
        } else if (value > subTreeRoot.getData()) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        }
        //case when value is equal to the subtree root we are currently at,i,e. we found the one to delete
        else {
            //there can be three cases
/*            1. Node is a leaf node
                2. Node has either left or right child
                3. Node has both left and right child*/

            //handling case 1 and 2 when the node to delete is a leaf node or has a child
            if (subTreeRoot.getLeftChild() == null) {
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild();
            }

            //we will land up here to handle the case when the node to be deleted has 2 children

            //replace the subtreeRoot(node to be deleted) data with min value from its right subtree
            //replacing with maximum value from left subtree would have served the purpose too
            subTreeRoot.setData(subTreeRoot.getRightChild().getMin());
            //next task is to knock off the min value of right subtree with which we replaced the node data
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
        }

        return subTreeRoot;
    }
}
