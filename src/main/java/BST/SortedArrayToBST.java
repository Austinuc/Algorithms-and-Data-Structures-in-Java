package BST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Since array is sorted, Recursively split the array into left and right child adding the middle element as the root node.
 */
public class SortedArrayToBST {

    //Best solution Time complexity = O(n), Space = O(1)
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }

    /**
     * Traverses the middle element of the array in a PreOrder pattern
     * @param val given array
     * @param l start index
     * @param r end index
     * @return root
     */
    public TreeNode createBST(int[] val, int l, int r) {
        if (l > r) return null;

        int mid = (l+r)/2;
        TreeNode root = new TreeNode(val[mid]);
        root.right = createBST(val, mid + 1, r);
        root.left = createBST(val, l, mid - 1);

        return root;
    }

    //Second solution. unoptimized (Time complexity = O(nlogn), Space = O(n))
    public TreeNode sortedArrayToBST2(int[] nums) {

        return pickMiddle(null, nums);
    }

    public TreeNode pickMiddle(TreeNode root, int[] arr) {
        if (arr.length == 1) return addNode(root, arr[0]);
        if (arr.length == 0) return null;

        root = addNode(root, arr[arr.length / 2]);
        pickMiddle(root, Arrays.copyOfRange(arr, 0, arr.length / 2));
        pickMiddle(root, Arrays.copyOfRange(arr, arr.length / 2 + 1, arr.length));


        return root;
    }

    public TreeNode addNode(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val > root.val) {
            root.right = addNode(root.right, val);
        }
        else {
            root.left = addNode(root.left, val);
        }

        return root;
    }
}
