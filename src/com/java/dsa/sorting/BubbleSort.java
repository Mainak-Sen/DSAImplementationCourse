package com.java.dsa.sorting;

import groovy.console.ui.SystemOutputInterceptor;

public class BubbleSort {

    private static void bubbleSort(int[] input) {

/*        As the sorted partition grows ,the unsorted partition doesnt cross over the sorted one and hence the
        solution is optimized*/
        for (int lastUnsortedIndex = input.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {

                if (input[i] > input[i + 1]) {
                    swap(input, i, i + 1);
                }
            }
        }

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
        bubbleSort(input);
    }
}
