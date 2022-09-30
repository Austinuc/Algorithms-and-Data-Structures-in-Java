package Sorting_Algorithms;

import org.junit.Test;

import static Sorting_Algorithms.MergeSort.divide;
import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    void testMergeSort() {
        int[] arr = {2,3,1,5,9,4};
        int n = 6;
        divide(arr, n);
    }

}