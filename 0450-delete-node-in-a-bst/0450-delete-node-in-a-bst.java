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
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root, key);
    }
    TreeNode helper(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        TreeNode dummy = root;
        if(key > root.val) {
            root.right = helper(root.right, key);
        }
        if(key < root.val) {
            root.left = helper(root.left, key);
        }
        if(key == root.val) {
            dummy = Delete(root, key);
        }
        return dummy;
    }
    TreeNode Delete(TreeNode root, int key) {
        if(root.right == null) {
           return root.left;
        } else if(root.left == null) {
            return root.right;
        } else{
        TreeNode rightchild = root.right;
        TreeNode lastrightChild = FindLastRight(root.left);
        lastrightChild.right = rightchild;
        return root.left;
        }
    }
    TreeNode FindLastRight(TreeNode root) {
        if(root.right == null) {
            return root;
        }
      return FindLastRight(root.right);
    }
}