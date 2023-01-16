package BST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s)
 * (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 */
public class FindMode {

    int max = 1;
    Map<Integer, Integer> m = new HashMap();

    public List<Integer> findMode(TreeNode root) {

        traversePreOrder(root);
        List<Integer> mode = new ArrayList();


        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() == max) mode.add(e.getKey());
        }

        return mode;

    }

    /**
     * Traverses the BST storing each node in a key in a hash map with its frequency as the value.
     *  And calculates the highest frequency in return
     * @param root BST
     */
    public void traversePreOrder(TreeNode root) {
        if (root == null) return;

        if (m.containsKey(root.val)) {
            m.replace(root.val, m.get(root.val) + 1);
            max = Math.max(max, m.get(root.val));
        } else {
            m.put (root.val, 1);
        }

        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }
}
