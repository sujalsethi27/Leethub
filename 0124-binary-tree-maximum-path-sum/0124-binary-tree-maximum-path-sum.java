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
    int path = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
     if(root == null) {
        return 0;
     }
      bestSum(root);
      return path;

    }
    int bestSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sumL = bestSum(root.left);
         if (sumL < 0)
         sumL = 0;
        int sumR = bestSum(root.right);
         if (sumR < 0)
         sumR = 0;
         path = Math.max(path , sumL + sumR + root.val);
        return root.val + Math.max(sumL , sumR);
    }
}