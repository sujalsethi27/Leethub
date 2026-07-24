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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
       int diameter = 0;
       int lh = height(root.left);
       int rh = height(root.right);
      int currentdia = Math.max(diameter , lh + rh);
      int leftdia = diameterOfBinaryTree(root.left);
      int rightdia = diameterOfBinaryTree(root.right);
      return Math.max(currentdia, Math.max(leftdia, rightdia));
    }
    int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh , rh);
    }
}