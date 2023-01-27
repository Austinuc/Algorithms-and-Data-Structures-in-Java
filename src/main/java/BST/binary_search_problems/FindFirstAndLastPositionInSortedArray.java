package BST.binary_search_problems;

public class FindFirstAndLastPositionInSortedArray {

    //Time Complexity = O(n)

    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[]{-1,-1};
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) {
                int i = mid;
                while (i > 0 && nums[i - 1] == target) --i;
                ans[0] = i;
                i = mid;
                while (i < (nums.length - 1) && nums[i+1] == target) i++;
                ans[1] = i;
                break;
            } else if (nums[mid] > target) high = mid -1;
            else low = mid + 1;
        }

        return ans;
    }

    //Time Complexity = O(logn)
    public int[] searchRange2(int[] nums, int target) {

        int[] ans = new int[]{-1,-1};
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) { // Search left for 1st occurrence
                ans[0] = mid;
                high = mid - 1;
            } else if (nums[mid] > target) high = mid -1;
            else low = mid + 1;
        }

        low = 0; high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target) { // Search right for last occurrence
                ans[1] = mid;
                low = mid + 1;
            } else if (nums[mid] > target) high = mid -1;
            else low = mid + 1;
        }

        return ans;
    }
}
