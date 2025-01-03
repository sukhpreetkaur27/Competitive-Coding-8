// LC 114
public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Morris PreOrder Traversal == Threaded Model of Binary Trees
     * TC: O(n)
     * SC: O(1)
     * <p>
     * PreOrder == Root L R
     * <p>
     * Create threads from Right most node of the Left subtree to Root's Right
     * <p>
     * Change Root's Right == Root's Left
     * Root's Left = null
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            TreeNode left = curr.left;
            if (left != null) {
                TreeNode right = left;
                while (right.right != null) {
                    right = right.right;
                }
//                if (right.right == null) {
                right.right = curr.right;
                curr.right = left;
                curr.left = null;
                curr = left;
//                }
            } else {
                curr = curr.right;
            }
        }
    }
}
