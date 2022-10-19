package Arrays_Algorithms;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a
 * contiguous subsequence in an array or list of integers:
 */
public class MaximumSubArraySum {
    //Uses the Kadane's Algorithm
    public static int sequence(int[] arr) {
        int sum_start_here = 0;
        int sum_so_far = 0;

        for (int val : arr) {
            sum_start_here = Math.max(0, sum_start_here + val);
            sum_so_far = Math.max(sum_so_far, sum_start_here);
        }

        return sum_so_far;
    }

    public static int sequence2(int[] arr) {
        boolean isAllNegative = true;
        boolean isAllPositive = true;
        int sum = 0;

        for (int i = 0, tmp = 0, j = 0; i < arr.length; i++) {

            if (j == 0 && isAllNegative || j == 0 && isAllPositive) {
                if (arr[i] > 0) isAllNegative = false;
                if (arr[i] < 0) isAllPositive = false;
            }

            tmp += arr[i];
            if (tmp > sum) sum = tmp;

            if ((i == arr.length-1 && isAllNegative) || (i == arr.length-1 && isAllPositive)) {
                return sum;
            }

            if (i == arr.length-1){
                i = j++;
                tmp = 0;
            }
        }
        return sum;
    }
}
