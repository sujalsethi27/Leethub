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
    public TreeNode insertIntoBST(TreeNode root, int val) {
    return helper(root, val);
    }

    TreeNode helper(TreeNode root, int val) {
      if(root == null) {
            return new TreeNode(val);
        }
       if(val > root.val) {
        TreeNode rf = helper(root.right, val);
        root.right = rf;
         return root;
       }
          if(val < root.val) {
        TreeNode lf = helper(root.left, val);
        root.left = lf;
         return root;
       }
       return root;
    }
}