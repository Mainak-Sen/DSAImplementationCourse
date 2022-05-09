package com.java.dsa.sorting;

public class QuickSort {

    private static void quickSort(int[] input) {
        int start = 0;
        int end = input.length;
        quickSort(input, start, end);
    }

    private static void quickSort(int[] input, int start, int end) {

        //case when 1 element array,its already sorted
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);//sort left subArray
        quickSort(input, pivotIndex + 1, end);

    }

    private static int partition(int[] input, int start, int end) {

        //starting with pivot at the start of the array
        int pivot = input[start];
        int i = start;
        int j = end;

/*        i is pointer to elements to be searched from left to right greater than pivot
          j is pointer to elements to be searched from right to left smaller than pivot
          alternatively we look for the same and make sure we dont lose any data while assigning
 */

        while (i < j) {
            //No body loop
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                //case when we get an element less than pivot while moving j backwards
                input[i] = input[j];
            }

            //No body loop
            while (i < j && input[++i] <= pivot) ;
            if (i < j) {
                //case when we get an element greater than pivot while moving i forward
                input[j] = input[i];
            }
        }
/*      finally after coming out of the while loop we will get to a point where i and j are
        at the point of crossing each other and that position of i or j is the actual expected position
        of the pivot in the sorted  array */
        input[j] = pivot;
        return j;
    }

    public static void main(String[] args) {

        int[] input = {1, 15, 12, 0, -44, 32, 48, -72, 65, 12};
        //int[] input = {0, 1, 2, 2, 3, 4, 78};
        quickSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
