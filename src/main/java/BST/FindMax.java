package BST;

import java.util.ArrayDeque;

/**
 * Problem: Give an algorithm for finding maximum element in binary tree.
 *
 * Solution: One simple way of solving this problem is: find the maximum element in left subtree,
 * find the maximum element in right sub tree, compare them with root data and select the one with
 * the maximum value.
 */
public class FindMax {

    /**
     * Recursive solution
     * @param root given tree
     * @return max value found
     */
    public int findMax(TreeNode root) {
        int max = Integer.MIN_VALUE, data = 0, left = 0, right = 0;

        if (root != null) {
            data = root.val;

            left = findMax(root.left);
            right = findMax(root.right);

            //Find the largest of the 3 values
            max = Math.max(left, right);
            max = Math.max(data, max);
        }

        return max;
    }

    //Level order traversal
    public int findMaxIter(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode ptr;
        int max = Integer.MIN_VALUE;

        queue.add(root);

        while (!queue.isEmpty()) {
            ptr = queue.pollFirst();
            System.out.println(ptr.val);
            max = Math.max(max, ptr.val);

            if (ptr.left != null)
                queue.add(ptr.left);
            if (ptr.right != null)
                queue.add(ptr.right);
        }

        return max;
    }

    public static void main(String[] args) {
        FindMax max = new FindMax();
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(new int[] {2,3,4,5,7,9,11,69});
        System.out.println(new FindMax().findMaxIter(root));
    }
}
