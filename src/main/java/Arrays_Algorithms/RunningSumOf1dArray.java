package Arrays_Algorithms;

/**
 * Running Sum Of 1d Array: Given an array nums. We define a running sum of
 *                         an array as runningSum[i] = sum(nums[0]…nums[i])
 */
public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += sum;
            sum = nums[i];
        }
        return nums;
    }
}
