package com.java.dsa.binarySearch;

public class BinarySearchIterative {

    private static int binarySearch(int[] input, int value) {

        int start = 0;
        int end = input.length; //end should be 1 greater than the last index of the array

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (input[midpoint] == value) {
                return midpoint;
            } else if (input[midpoint] > value) {
                end = midpoint;
            } else {
                start = midpoint + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        int[] input = {-22, -15, 5, 7, 7, 34, 55};
        System.out.println(binarySearch(input, 55));

    }

}
