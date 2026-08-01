/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }
    void helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
           return;
        }
     if(p.val < root.val && q.val < root.val) {
        helper(root.left, p, q);
     }
      if(p.val > root.val && q.val > root.val) {
        helper(root.right, p, q);
     }
      if(p.val < root.val && q.val > root.val) {
         ans = root;
     }
       if(p.val > root.val && q.val < root.val) {
         ans = root;
     }
       if(p == root ) {
        ans = p;
     }
      if(q == root) {
        ans = q;
     }
    }
}