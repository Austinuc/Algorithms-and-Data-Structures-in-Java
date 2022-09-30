package Sorting_Algorithms;

public class MergeSort {

    public static int[] divide(int[] arr, int n) {

        if ((n & 2) == 0) {

        }
        int[] left = divide(arr, n/2);
        int[] right = divide (arr, n%2);
        return new int[] {};
    }
}
