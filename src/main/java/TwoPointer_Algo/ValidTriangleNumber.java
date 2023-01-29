package TwoPointer_Algo;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of triplets chosen from the
 * array that can make triangles if we take them as side lengths of a triangle.
 */
public class ValidTriangleNumber {

    //Similar to 3 sum problem
    public int triangleNumber(int[] nums) {
        int count = 0, n = nums.length;
        Arrays.sort(nums);

        /*
         * 3 numbers (a,b,c) are valid triangle numbers if a + b > c, a+c > b, && b+c > a.
         *
         * Choose k to be the highest of the 3 pointers and fix it.
         *
         * Then set j = k - 1, and i always = 0 for all iterations.
         *
         * If a valid triangle is found, then because the array is sorted in acs order, all combinations btw i & j are valid
         *
         */
        for (int k = 2; k < n; k++) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) { //if valid
                    count += j - i; //no need to scan btw i & j
                    j--; //decrease j and continue searching
                } else i++; //if invalid move i forward and continue searching
            }
        }

        return count;

    }
}
