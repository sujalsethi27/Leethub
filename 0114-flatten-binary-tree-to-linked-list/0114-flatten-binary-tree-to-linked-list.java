/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
    helper(root);
    }

    void helper(TreeNode root) {

        if (root == null) {
            return;
        }

        helper(root.left);
        helper(root.right);

        if (root.left != null) {

            TreeNode temp = root.left;

            while (temp.right != null) {
                temp = temp.right;
            }

            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}