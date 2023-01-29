package TwoPointer_Algo;

import java.util.Arrays;

/**
 * Given an array of integers, nums, and an integer value, target,
 * determine if there are any three integers in nums whose sum equals the target.
 * Return TRUE if three such integers are found in the array. Otherwise, return FALSE.
 */
public class SumOfThree {

    public static boolean findSumOfThree(int[] nums, int target) {

        Arrays.sort(nums);

        //fix i and use two pointers to search from opp direction from i+1 to the end
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1, k = nums.length - 1; j<k; ) {
                if ((nums[i] + nums[j] + nums[k]) == target) return true;
                else if ((nums[i] + nums[j] + nums[k]) < target) j++; //move left pointer to higher value
                else k--; //move right pointer to lower value
            }
        }

        return false;
    }
}
