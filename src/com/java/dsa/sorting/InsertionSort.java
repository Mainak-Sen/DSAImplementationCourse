package com.java.dsa.sorting;

public class InsertionSort {

    private static void insertionSort(int[] input) {

        /*traverse through each element of unsorted partition and insert it into correct position of sorted partition*/
        /*sorted array is growing from left to right */
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < input.length; firstUnsortedIndex++) {
            int newElement = input[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && input[i - 1] > newElement; i--) {
                //shift the elements to right of sorted partition to make room for new element
                input[i] = input[i - 1];
            }
            input[i] = newElement;
        }

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    //insertion sort is a stable sort algorithm
    public static void main(String[] args) {

        int[] input = {1, 15, 12, 0, -44, 32, 48, -72, 65, 12};
        insertionSort(input);
    }
}
