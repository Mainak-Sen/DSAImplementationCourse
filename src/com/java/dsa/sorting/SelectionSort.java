package com.java.dsa.sorting;

public class SelectionSort {

    private static void selectionSort(int[] input) {

        /*On each traversal we are selecting the largest element and adding it to the sorted partition*/
        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {

                if (input[i] > input[largest]) {
                    largest = i;
                }
            }
            swap(input, largest, lastUnsortedIndex);
        }

        /*Selection sort is  not a stable sorting algorithm but bubble sort is*/
        //printing the sorted array
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

    }

    private static void swap(int[] input, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

    public static void main(String[] args) {

        int[] input = {1, 15, 12, 0, -44, 32, 48, -72, 65, 12};
        selectionSort(input);
    }
}
