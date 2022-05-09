package com.java.dsa.sorting;

public class RadixSort {

    private static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(int[] input, int position, int radix) {

        int[] countArray = new int[radix];
        int numItems = input.length;
        //get the conventional count of digits at a particular position
        for (int value : input) {
            countArray[getDigit(value, radix, position)]++;
        }
/*        adjust the countArray according to counts less than or equal to digits as per the position
        count of number of elements having 0 or less at a particular position is equivalent to count
        of number of elements having 0 at a particular position */
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }
        //making it stable by going from right to left of the values in array
        int[] tempArray = new int[numItems];
        for (int k = tempArray.length - 1; k >= 0; k--) {
            tempArray[--countArray[getDigit(input[k], radix, position)]] = input[k];
        }
/*        copy the contents of tempArray into input array for next iteration based on a different position
        until we sort it to the MSB*/
        System.arraycopy(tempArray, 0, input, 0, numItems);
    }

    private static int getDigit(int value, int radix, int position) {
        return value / (int) Math.pow(radix, position) % radix;
    }


    public static void main(String[] args) {

        int[] input = {4725, 4586, 1330, 8792, 1594, 5729};
        radixSort(input, 10, 4);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
