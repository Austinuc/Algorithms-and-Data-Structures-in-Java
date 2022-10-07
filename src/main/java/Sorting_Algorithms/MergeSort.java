package Sorting_Algorithms;
import java.util.*;
public class MergeSort {

    /**
     *
     * @param array: input unsorted array
     * @param fromIndex: starting index for sorting in the give array
     * @param toIndex: last index of the array to be sorted
     * @return: the sorted array
     */
    public static Integer[] mSort(Integer[] array, Integer fromIndex, Integer toIndex) {
        //base case for the recursive call
        if (toIndex == 1) {
            return array;
        }
        Integer[] leftHalf = Arrays.copyOfRange(array, fromIndex, toIndex/2);
        Integer[] rightHalf = Arrays.copyOfRange(array, toIndex/2, toIndex);
        return mMerge(mSort(leftHalf,fromIndex, toIndex/2),
                mSort(rightHalf,fromIndex, toIndex = (toIndex % 2 == 0) ? toIndex/2 : toIndex/2 + 1));
    }

    /**
     * mMeger: merges two sorted arrays of Integers in a sorted order
     *
     * @param left: left-half of the array
     * @param right: right-half of the array
     * @return: an array formed by merging left and right in a sorted order
     */
    private static Integer[] mMerge(Integer[] left, Integer[] right) {
        Integer[] merged = new Integer[left.length + right.length];
        /**
         * Compare the two arrays and ensure they are sorted before merging
         */
        for (int pl = 0; pl < left.length; pl++) {
            int pr = 0;
            if (left[pl].compareTo(right[pr]) > 0) {
                Integer tmp = left[pl];
                left[pl] = right[pr];
                //get the right sorted position for tmp in the left array
                while (pr < right.length - 1) {
                    if (tmp.compareTo(right[pr + 1]) > 0) {
                        //shift element leftwards
                        right[pr] = right[pr + 1];
                        pr++;
                    } else {
                        break;
                    }
                }
                //insert tmp into the right sorted position
                right[pr] = tmp;
            }
        }
        /**
         * Merge the two arrays into a new array
         */
        for (int i = 0, j = 0, len = left.length; (i < left.length) || (j < right.length); i++, j++) {
            if (i < left.length)
                merged[i] = left[i];
            merged[len++] = right[j];
        }
        return merged;
    }
}
