package BST.binary_search_problems;

import java.util.List;

public class BinarySearch {

    public int search(List<Integer> arr, int item) {
        int ans = -1, low = 0, high = arr.size() - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arr.get(mid) == item) {
                ans = mid;
                break;
            } else if (arr.get(mid) > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(20 / 15);
    }
}
