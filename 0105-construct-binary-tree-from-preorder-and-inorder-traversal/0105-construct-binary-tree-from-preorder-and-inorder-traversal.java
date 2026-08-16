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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      return helper(preorder, inorder,0,0,inorder.length-1);
    }
    TreeNode helper(int[] preorder, int[] inorder, int prestart, int instart, int inend) {
        if(instart > inend) {
         return null;
         }
       TreeNode root = new TreeNode(preorder[prestart]);
        for(int j = instart; j <= inend; j++) {
         if(preorder[prestart] == inorder[j]) {
   root.left = helper(preorder, inorder, prestart + 1, instart, j -1);
   root.right = helper(preorder, inorder, prestart + (j - instart) + 1, j + 1, inend);
       }
        }
       return root;
    }
}