package com.java.dsa.tree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree intTree = new BinarySearchTree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        //print inorder traversal
        System.out.println("Before any deletion");
        System.out.println("Inorder Traversal");
        intTree.traverseInorder();
        System.out.println("Preorder Traversal");
        intTree.traversePreorder();
/*        System.out.println(intTree.getValue(27));
        System.out.println(intTree.getValue(45));*/

/*        System.out.println(intTree.getMin());
        System.out.println(intTree.getMax());*/
        //deleting node with one child
//        intTree.delete(15);
//        System.out.println("After deleting 15");
//        intTree.traverseInorder();
//
//        //deleting leaf
//        intTree.delete(17);
//        System.out.println("After deleting 17");
//        intTree.traverseInorder();

        //deleting node with two children i.e. the root
/*        intTree.delete(84);
        System.out.println("After deleting 84");
        intTree.traverseInorder();*/

    }
}
