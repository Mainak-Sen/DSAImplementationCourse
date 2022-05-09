package com.java.dsa.sorting;

public class ShellSort {

/*    shell-sort is essentially insertion sort ,the difference is that we are having a gap value
    which is not 1 and that reduces yhe no of shifts eventually to reach the sorted expected output*/

    private static void shellSort(int[] input) {
        for (int gap = input.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < input.length; i++) {
                int newElement = input[i];
                int j = i;
                while (j >= gap && input[j - gap] > newElement) {
                    input[j] = input[j - gap];
                    j -= gap;
                }
                input[j] = newElement;
            }
        }

        //print the sorted array
        for (int k = 0; k < input.length; k++) {
            System.out.print(input[k] + " ");
        }
    }

    /*Shell-sort is an unstable sort algorithm*/
    public static void main(String[] args) {

        int[] input = {1, 15, 12, 0, -44, 32, 48, -72, 65, 12};
        shellSort(input);
    }
}
