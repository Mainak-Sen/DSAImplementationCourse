package com.java.dsa.sorting;

public class SortStringsRadixSort {

    private static void radixSort(String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(String[] input, int position, int radix) {

        int[] countArray = new int[radix];
        int numItems = input.length;
        //get the conventional count of letters at a particular position
        for (String value : input) {
            countArray[getIndex(value, position)]++;
        }
/*        adjust the countArray according to counts less than or equal to letters as per the position
        count of number of elements having  character 'a' or less at a particular position is equivalent to count
        of number of elements having 'a' at a particular position */
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }
        //making it stable by going from right to left of the values in array
        String[] tempArray = new String[numItems];
        for (int k = tempArray.length - 1; k >= 0; k--) {
            tempArray[--countArray[getIndex(input[k], position)]] = input[k];
        }
/*        copy the contents of tempArray into input array for next iteration based on a different position
        until we sort it to the MSB*/
        System.arraycopy(tempArray, 0, input, 0, numItems);
    }

    private static int getIndex(String value, int position) {
        return value.charAt(position) - 'a';
    }

    public static void main(String[] args) {

        String[] input = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        radixSort(input, 26, 5);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

    }
}
