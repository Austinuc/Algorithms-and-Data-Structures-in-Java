package Sorting_Algorithms;

import org.junit.Test;

import java.util.Arrays;

import static Sorting_Algorithms.MergeSort.mSort;
import static org.junit.Assert.assertEquals;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        Integer[] arr = {94 ,9 ,75 ,83 ,62 ,25 ,14 ,3};
        double start = System.nanoTime();
        assertEquals("[3, 9, 14, 25, 62, 75, 83, 94]", Arrays.toString(mSort(arr, 0, arr.length)));
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