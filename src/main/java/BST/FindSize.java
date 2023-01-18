package BST;

import java.util.ArrayDeque;

/**
 * Give an algorithm for finding the size of binary tree.
 * Solution: Calculate the size of left and right subtrees recursively, add 1 (current node) and return
 * to its parent.
 */
public class FindSize {

    public int findSizeRecursively(TreeNode root) {
        if (root == null) return 0;

        return findSizeRecursively(root.left) + 1 + findSizeRecursively(root.right);
    }

    //Uses the level order traversal
    public int findSizeIteratively(TreeNode root) {
        if (root == null) return 0;
        int size = 0; TreeNode ptr;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ptr = queue.pollFirst();

            size++;
            if (ptr.left != null)
                queue.addLast(ptr.left);
            if (ptr.right != null)
                queue.addLast(ptr.right);
        }

        return size;
    }

    public static void main(String[] args) {
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(new int[] {2,3,4,5,7,9,11,69});
        System.out.println(new FindSize().findSizeRecursively(root));
        System.out.println(new FindSize().findSizeIteratively(root));
    }
}
