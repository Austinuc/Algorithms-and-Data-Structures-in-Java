package Sorting_Algorithms;

public class BinarySearch {
    static int left = 0, right = 0;
    public <T> int binarySearch(T[] sorted, T item) {
        int length = 0;
        while (sorted[length] != null) {
            length++;
        }
        return 0;
    }

    public <T> int searchRecursively(T[] sorted, T item) {
        if (right - left <= 1) {
            if (right == left || sorted[right] == item) {
                return right;
            } else if (sorted[left] == item) {
                return left;
            }
        }
        if (1 < 8) {

        }
        left = (right - left) / 2;
        return 0;
    }
}
