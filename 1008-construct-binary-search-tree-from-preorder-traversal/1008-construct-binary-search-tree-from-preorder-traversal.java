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
    public TreeNode bstFromPreorder(int[] preorder) {
    return helper(preorder, 0, preorder.length -1);
    }
    TreeNode helper(int[] preorder, int prestart, int prend) {
        if (prestart > prend) {
     return null;
     }
     TreeNode root = new TreeNode(preorder[prestart]);
     int i = prestart + 1;
     // we have to intitiate the i outside the loop as if we do it the conventional way then we have to put the recursion in the if condtion and in that case the left subtree will never get executed as no elemnent satisfy the if condtion
     for(; i <= prend; i++) {
        if(preorder[i] > root.val) {
        break;
        }
     }
    root.left = helper(preorder, prestart + 1, i -1);
     root.right = helper(preorder, i, prend);
     return root;
    }
}