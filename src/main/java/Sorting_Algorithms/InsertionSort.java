package Sorting_Algorithms;

import java.util.Arrays;

public class InsertionSort {

    public static String insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            //hold the current element in a temp variable
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                //shift elements from the left to the right that are greater than the current element
                arr[j+1] = arr[j];
                j = j - 1;
            }
            //insert the current value in its sorted position
            arr[j+1] = key;
        }
        return Arrays.toString(arr);
    }
}
