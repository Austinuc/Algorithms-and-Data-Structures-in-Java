package BST;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
public class Search {

    class Solution {

        /**
         * Time Complexity O(logn).
         * Space: O(1)
         * @param root given BST
         * @param val to be found
         * @return found subTree or null
         */
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            if (root.val > val)
                return searchBST(root.left, val);
            else
                return searchBST(root.right, val);
        }
    }
}
