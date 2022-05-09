package com.java.dsa.sorting;

public class MergeSort {

    private static void mergeSort(int[] input) {

        int start = 0;
        int end = input.length;
        mergeSort(input, start, end);
    }

    private static void mergeSort(int[] input, int start, int end) {

        //one element array is already sorted
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, end, mid);
    }

    private static void merge(int[] input, int start, int end, int mid) {

/*        optimize the algorithm so that if start element of right subArray is greater
        than end element of left subArray ,then we need not do any merge*/
        if (input[mid - 1] <= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];//to accommodate all elements of original array
        while (i < mid && j < end) {
            //copy the smaller elements into the temp array
            tempArray[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
/*        handle the leftover elements in left subarray
        we need not handle left-over elements in right subarray
        because their relative positions are not going to change
        in the expected sorted array*/

        //handle left-over elements of left subArray,their positions are going to change in input array
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        //copy the temp array into input array
        System.arraycopy(tempArray, 0, input, start, tempIndex);

    }

    public static void main(String[] args) {

        int[] input = {1, 15, 12, 0, -44, 32, 48, -72, 65, 12};
        int[] input1 = {0, 1, 2, 2, 3, 4, 78};
        mergeSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
