package com.java.dsa.sorting;

public class CountingSort {

    private static void countingSort(int[] input, int min, int max) {
/*        in this algorithm we will count and copy  the number of times the given elements are present
        in the array and copy its contents into a final array
        This algorithm should only be sued when the range of values to be used is within a limited specified range*/
        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }
        int k = 0;
        for (int j = min; j <= max; j++) {
            while (countArray[j - min] > 0) {
                input[k++] = j;
                countArray[j - min]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 6, 8, 7, 2, 3, 3, 5, 4, 9};
        //int[] input = {0, 1, 2, 2, 3, 4, 78};
        countingSort(input, 1, 10);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
