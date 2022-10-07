package Sorting_Algorithms;

import org.junit.Test;

import java.util.Arrays;

import static Sorting_Algorithms.MergeSort.mSort;
import static org.junit.Assert.assertEquals;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        Integer[] arr = {11,9,2,3,1,5,9,4,0};
        int n = 9;
        double start = System.nanoTime();
        assertEquals("[0, 1, 2, 3, 4, 5, 9, 9, 11]", Arrays.toString(mSort(arr, 0, n)));
        double end = System.nanoTime();
        System.out.println(end - start);

    }
    @Test
    public void systemSortTest() {
        int[] arr = {11,9,2,3,1,5,9,4,0};
        int n = 9;
        double start = System.nanoTime();
        Arrays.sort(arr);
        double end = System.nanoTime();
        System.out.println(end - start);
    }

}