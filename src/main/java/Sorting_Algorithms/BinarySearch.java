package Sorting_Algorithms;

import static Sorting_Algorithms.InsertionSort.insertionSort;
import static Sorting_Algorithms.MergeSort.mSort;

public class BinarySearch {

    /**
     * Uses binary search iterative algorithm to search for a term in a given unsorted array
     *
     * @param searchTerm: search term
     * @param array: an unsorted array
     * @return: index of found element. If searchTerm occurred more than once, the first occurrence is returned
     */
    public static int binarySearch(int searchTerm, int[] array) {
        insertionSort(array, array.length);

        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] == searchTerm) {//Found
                return i;
            }
            if (array[j] == searchTerm) //Found
                return j;
            if (array[(j+i)/2] == searchTerm) { //Found
                return (j+i)/2;
            }
            if (array[(j+i)/2] > searchTerm) { //Move j to left
                j = (j+1)/2 - 1;
            }
            if (array[(j+i)/2] < searchTerm) { //Move i to right
                i = (j+i)/2 +1;
            }
        }
        return -1;
    }

    /**
     * Uses binary search recursive algorithm to search for a term in a given unsorted array
     *
     * @param searchTerm
     * @param sortedArray
     * @param i: left pointer
     * @param j: right pointer
     * @return: index of found element. If searchTerm occurred more than once, the first occurrence is returned
     */
    public static int binarySearchRec(int searchTerm, Integer[] sortedArray, int i, int j) {
//        Integer[] sortedArray = mSort(array, 0, array.length);
        if (sortedArray[i] == searchTerm) {
            return i;
        }
        if (sortedArray[j] == searchTerm)
            return j;
        if (i >= j)
            return -1;
        if (sortedArray[(j + i) / 2] > searchTerm) {
            return binarySearchRec(searchTerm, sortedArray, i, (j + 1) / 2 - 1);
        }
        if (sortedArray[(j + i) / 2] < searchTerm) {
            return binarySearchRec(searchTerm, sortedArray, (j + i) / 2 + 1, j);
        }
        return (j + i) / 2;
    }
}
