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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
             return true;
        }
        mirror(root.left , root.right);
       return    mirror(root.left , root.right);
    }
    boolean mirror(TreeNode left , TreeNode right) {
        if(left == null && right != null) {
            return false;
        }
         if(left == null && right == null) {
            return true;
        }
        if(left != null && right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }  
     boolean first =  mirror(left.left , right.right);
     boolean second = mirror(left.right , right.left);
        if(first == false || second == false) {
            return false;
        }
    return true;
    }
}