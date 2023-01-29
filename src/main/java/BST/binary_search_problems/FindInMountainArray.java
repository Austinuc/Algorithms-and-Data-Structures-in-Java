package BST.binary_search_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class FindInMountainArray {

    //From LeetCode 1095. Find in Mountain Array
    // This is MountainArray's API interface.
    // You should not implement it, or speculate about its implementation
    interface MountainArray {
        public int get(int index);
        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {

        //Because we are required to make minimum call on 'mountainArr.get()' method. We'll cache the values
        List<Integer> cache = new ArrayList<>(Collections.nCopies(mountainArr.length(), -1));

        int start = 0, end = mountainArr.length() - 1, ans = -1, peak = 1;

        //Find peak
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid == 0) break;
            if (mid == mountainArr.length() - 1) {
                peak = mountainArr.length() - 2;
                break;
            }

            cache.set(mid,mountainArr.get(mid));
            cache.set(mid+1,mountainArr.get(mid+1));
            cache.set(mid-1,mountainArr.get(mid-1));

            if (cache.get(mid) > cache.get(mid-1) && cache.get(mid) > cache.get(mid+1)) {
                peak = mid;
                break;
            }
            else if (cache.get(mid) > cache.get(mid-1)) start = mid + 1;
            else end = mid -1;
        }

        start = 0; end = peak;
        //Search left of mountain since minimum index is the priority
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (cache.get(mid) == -1) cache.set(mid,mountainArr.get(mid));
            if (cache.get(mid) == target) {
                ans = mid;
                end = mid - 1;
            } else if (cache.get(mid) > target) end = mid - 1;
            else start = mid + 1;
        }

        if (ans == -1) { //if not found, search the right side of the mountain
            start = peak; end = mountainArr.length() - 1;
            while (start <= end) {
                int mid = start + (end - start)/2;
                if (cache.get(mid) == -1) cache.set(mid,mountainArr.get(mid));
                if (cache.get(mid) == target) {
                    ans = mid;
                    end = mid - 1;
                } else if (cache.get(mid) > target) start = mid + 1;
                else end = mid - 1;
            }
        }

        return ans;
    }
}
