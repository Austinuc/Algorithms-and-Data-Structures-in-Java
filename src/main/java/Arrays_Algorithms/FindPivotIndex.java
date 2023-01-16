package Arrays_Algorithms;

/**
 * pivotIndex - Finds the pivot index of a given array
 * @nums: input arrays of integers
 * Description: The pivot index is the index where the sum of all the numbers strictly
 *             to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * Return: Return the leftmost pivot index. If no such index exists, return -1.
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalArraySum = 0, leftSum = 0;

        if (nums.length == 1)
            return 0;
        for(int i = 0; i < nums.length; i++) {
            totalArraySum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {

            if (totalArraySum - nums[i] == leftSum) //check if leftsum equals rightsum removing the current element
                return i;
            totalArraySum -=nums[i];
            leftSum += nums[i];
        }
        return -1;

    }
}
