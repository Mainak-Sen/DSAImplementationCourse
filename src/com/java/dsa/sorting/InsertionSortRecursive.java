package com.java.dsa.sorting;

public class InsertionSortRecursive {

    //Recursive method
    private static void insertionSort(int[] input, int numItems) {
        //case when there is only one element ,we can consider that as sorted
        if (numItems < 2) {
            return;
        }
        insertionSort(input, numItems - 1);
        int newElement = input[numItems - 1];
        int i;
        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }
        input[i] = newElement;
    }

    public static void main(String[] args) {

        int[] input = {1, 15, 12, 0, -44, 32, 48, -72, 65, 12};
        insertionSort(input, input.length);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
