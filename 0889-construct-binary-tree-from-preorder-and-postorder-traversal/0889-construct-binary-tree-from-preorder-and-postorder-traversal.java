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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder, 0, 0, postorder.length -1);
    }
 TreeNode helper(int[] preorder, int[] postorder, int prestart, int poststart, int postend) {
     if(poststart > postend) {
        return null;
     }
     TreeNode root = new TreeNode(preorder[prestart]);
       if (poststart == postend) {
    return root;
} // as if there is only element then  have to return it otherwise prestart + 1 makes it out of bound
     for(int i = poststart; i <= postend; i++) {
        if(postorder[i] == preorder[prestart + 1]) {
         root.left = helper(preorder, postorder, prestart +1, poststart, i);
         root.right = helper(preorder, postorder, prestart + 1 + (i - poststart + 1), i + 1, postend-1);
         // prestart + 1 is leftsubtree
        }
     }
     return root;
    }
}