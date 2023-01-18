package BST;

import java.util.ArrayList;
import java.util.List;

public class FindHeight {

    public int findHeightRecursively(TreeNode root) {
        if (root == null) return 0;

        return Math.max(findHeightRecursively(root.left), findHeightRecursively(root.right)) + 1;
    }

    /**
     * Strategy: use NULL as a marker for each level and count the number of NULL values in the queue while
     * performing a Level order traversal. (BFS)
     * We will use ArrayList to implement our Queue since it preserves insertion order and supports NULL insertion
     *
     * @param root tree
     * @return height of the tree
     */
    public int findHeightIteratively(TreeNode root) {
        if (root == null) return 0;

        int height = 0;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        queue.add(null); //Add maker for first level
        TreeNode temp;

        while(!queue.isEmpty()) {
            temp = queue.remove(0);

            //Completion of current level
            if (temp == null) {

                if (!queue.isEmpty()) { // Add another marker to indicate another level
                    queue.add(null);
                }
                height++;
            } else {
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }

        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(new int[] {1,2,3,4,5,7,8,10});
        System.out.println(new FindHeight().findHeightRecursively(root));
        System.out.println(new FindHeight().findHeightIteratively(root));
    }
}
