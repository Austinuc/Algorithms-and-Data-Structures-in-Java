package Sorting_Algorithms;

import static Sorting_Algorithms.InsertionSort.insertionSort;
import static Sorting_Algorithms.MergeSort.mSort;

public class BinarySearch {
    public static int binarySearch(int a, int[] arr) {
        insertionSort(arr, arr.length);

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] == a) {
                return i;
            }
            if (arr[j] == a)
                return j;
            if (arr[(j+i)/2] == a) {
                return (j+i)/2;
            }
            if (arr[(j+i)/2] > a) {
                j = (j+1)/2 - 1;
            }
            if (arr[(j+i)/2] < a) {
                i = (j+i)/2 +1;
            }
        }
        return -1;
    }

    public static int binarySearchRec(int a, Integer[] arr, int i, int j) {
//        Integer[] arr = mSort(array, 0, array.length);
        if (arr[i] == a) {
            return i;
        }
        if (arr[j] == a)
            return j;
        if (i >= j)
            return -1;
        if (arr[(j + i) / 2] > a) {
            return binarySearchRec(a, arr, i, (j + 1) / 2 - 1);
        }
        if (arr[(j + i) / 2] < a) {
            return binarySearchRec(a, arr, (j + i) / 2 + 1, j);
        }
        return (j + i) / 2;
    }
}
