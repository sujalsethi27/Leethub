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
    public TreeNode searchBST(TreeNode root, int val) {
    return helper(root,val);
    }
    TreeNode helper(TreeNode root, int val) {
         if(root == null) {
            return null;
        }
        if(val == root.val) {
            return root; // as the root node we are returning already holds the value for the subtrees of it 
        }
       if(val > root.val){
        TreeNode rf = helper(root.right, val);
        return rf;
       }
          if(val < root.val){
        TreeNode lf = helper(root.left, val);
        return lf;
       }
       return null;
    }
}