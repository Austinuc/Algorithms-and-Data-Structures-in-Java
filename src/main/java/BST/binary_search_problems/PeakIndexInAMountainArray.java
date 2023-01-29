package BST.binary_search_problems;

//852. Peak Index in a Mountain Array
public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;


        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid == 0) return 1;
            if (mid == arr.length - 1) return arr.length - 2;

            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if (arr[mid] > arr[mid-1]) start = mid + 1; // if uphill, move the start index upwards towards the peak
            else end = mid -1; // if downhill, move the end index upwards towards the peak
        }
        return 1;

    }
}
