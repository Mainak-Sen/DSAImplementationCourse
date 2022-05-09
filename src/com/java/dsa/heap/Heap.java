package com.java.dsa.heap;

/*Max-Heap backed by Array implementation*/
public class Heap {

    private int[] heap;
    private int size; // to track the index

    //constructor
    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public void insert(int value) {
        //check if the array is full
        if (isFull()) {
            throw new IndexOutOfBoundsException("Sorry !! the array is already full...");
        }
        heap[size] = value;
        fixHeapAbove(size); // calling fixHeapAbove method to fix the heap due to the new recent insertion
        size++;
    }

    public int delete(int index) {
        //first check if heap is empty
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Sorry!! Heap is empty...");
        }
        int valueToBeDeleted = heap[index];
        //replace the value at index with value at rightmost leaf to preserve the property of complete binary tree
        heap[index] = heap[size - 1]; //replaced

        //now comes the point of heapifying the heap on account of recent deletion
        if (index == 0 || heap[index] < heap[getParentIndex(index)]) {
            //fixHeapBelow
            fixheapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        //decrement the size since a node has been deleted
        size--;
        return valueToBeDeleted;
    }

    private void fixheapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int leftChildIndex = getChild(index, true);
            int rightChildIndex = getChild(index, false);
            if (leftChildIndex <= lastHeapIndex) {
                if (rightChildIndex > lastHeapIndex) {
                    childToSwap = leftChildIndex;
                } else {
                    childToSwap = heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
                }

                //we have found the child to swap here
                if (heap[index] < heap[childToSwap]) {
                    //swap method
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break; //we should break out of the loop in this condition
                }
                index = childToSwap; //update index for next iteration
            } else {
                break;//we should break out of the loop in this condition when theres is no left child
            }
        }
    }

    private void fixHeapAbove(int index) {
        int newVelue = heap[index];
        while (index > 0 && newVelue > heap[getParentIndex(index)]) {
            heap[index] = heap[getParentIndex(index)];
            index = getParentIndex(index);
        }
        //assign the newValue to its actual position so that the max heap characteristic is preserved
        heap[index] = newVelue;
    }

    //getParent index value
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getChild(int index, boolean left) {
        return left ? 2 * index + 1 : 2 * index + 2;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) System.out.print(heap[i] + " ");
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Sorry!! nothing to peek at ! Heap is empty");
        }
        return heap[0]; //we always peek at the root
    }

    //heap sort implementation
    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            //swap root with the last element
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;

            //fix heap below
            //-1 to exclude last element in every iteration
            fixheapBelow(0, lastHeapIndex - i - 1);
        }
    }
}
