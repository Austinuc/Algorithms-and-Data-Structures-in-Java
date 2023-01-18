package BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the deepest node of a binary tree.
 *
 * Solution: uses Level order traversal.
 */
public class DeepestNode {

    public TreeNode findDeepestNode(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = null;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            temp = queue.remove(0);

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

        return temp;
    }
}
