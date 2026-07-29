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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
           return false;
        }
        return helper(root , targetSum);
    }
      boolean helper(TreeNode root, int targetSum) {
        if(root == null) {
         return false;
        }
    targetSum = targetSum - root.val;
    boolean lf = helper(root.left , targetSum);
    boolean rf =  helper(root.right, targetSum);
    if(root.right ==  null && root.left == null) { // when we are at the leaf node
       if(targetSum != 0) {
        return false ;
      }else {
        return true;
      }
    }
     return lf || rf ;
    }
}