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
  long minAllowed = Long.MIN_VALUE;
  long maxAllowed = Long.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
           return true;
        }
        return helper(root, minAllowed, maxAllowed);
    }
    boolean helper(TreeNode root, long minAllowed, long maxAllowed) {
        if(root == null) {
           return true;
        }
    if(minAllowed < root.val && root.val < maxAllowed) {
    boolean lf = helper(root.left, minAllowed, root.val);
    boolean rf = helper(root.right, root.val, maxAllowed);
    if(lf == true && rf == true) {
        return true;
    }
    }
    return false;
    }
}