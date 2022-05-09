package com.java.dsa.heap;

public class Main {

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

        //print the heap
//        heap.printHeap();
/*        heap.delete(0);
        heap.printHeap();
        System.out.println();
        System.out.println(heap.peek());*/

        //sort the heap
        System.out.println("Sort the heap");
        System.out.println("*****************************************");
        heap.sort();
        heap.printHeap();


    }
}
