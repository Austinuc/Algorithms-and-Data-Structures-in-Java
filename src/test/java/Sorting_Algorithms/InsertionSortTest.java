package Sorting_Algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void insertionSort1() {
//        int[] arr
        assertEquals("[1, 2, 3, 4, 5]", InsertionSort.insertionSort(new int[]{3, 4, 2, 1, 5}, 5));
    }
}