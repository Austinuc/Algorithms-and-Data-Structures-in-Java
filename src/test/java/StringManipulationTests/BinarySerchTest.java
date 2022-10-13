package StringManipulationTests;

import org.junit.Test;

import static Sorting_Algorithms.BinarySearch.binarySearch;
import static Sorting_Algorithms.BinarySearch.binarySearchRec;
import static Sorting_Algorithms.MergeSort.mSort;
import static org.junit.Assert.assertEquals;

public class BinarySerchTest {

    @Test
    public void testingBinarySearchIteratingAlgorithm() {
        assertEquals(0,(binarySearch(-1, new int[] {6,3,2,10, 1,8,0,-1})));
        Integer[] sortedArray = mSort(new Integer[] {6,3,2,10, 1,8,0,-1}, 0, 8);
        assertEquals(2,(binarySearchRec(1, sortedArray,0,7)));
    }
}
