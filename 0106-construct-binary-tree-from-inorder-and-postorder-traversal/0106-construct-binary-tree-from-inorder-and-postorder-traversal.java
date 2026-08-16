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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length -1, 0, inorder.length -1 );
    }
    TreeNode helper(int[] inorder, int[] postorder,int postend, int instart, int inend) {
      if(instart > inend) {
        return null;
      }
      TreeNode root = new TreeNode(postorder[postend]);
      for(int j = instart; j <= inend; j++) {
        if(postorder[postend] == inorder[j]) {
          root.left = helper(inorder, postorder, postend - (inend - j) -1 ,instart, j-1 );
          root.right = helper(inorder, postorder, postend-1 ,j+1, inend );
        }
      }
      return root;
    }
}