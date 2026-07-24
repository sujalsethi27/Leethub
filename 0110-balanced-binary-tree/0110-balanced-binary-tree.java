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
    public boolean isBalanced(TreeNode root) {
    if(root == null) {
        return true;
    }
    int lh = DFSheight(root.left);
    int rh = DFSheight(root.right);
    if (Math.abs(lh - rh) > 1){
        return false;
    }
       boolean left = isBalanced(root.left);
       if(left == false) {
        return false;
       }
       boolean right = isBalanced(root.right);
        if(right == false) {
        return false;
       }
      return true;
    }
     int DFSheight(TreeNode root) {
        if(root == null) {
            return 1;
        }
        int lh = DFSheight(root.left);
        int rh = DFSheight(root.right);
        return 1 + Math.max(lh, rh);
    }
}