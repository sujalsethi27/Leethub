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
    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE ;
       List<Integer> list = new ArrayList<>();
        helper(root, list);
        for(int i = 0; i < list.size()-1; i++) {
         int next = list.get(i+1);
        int current = list.get(i);
        int difference = Math.abs(next - current);
        minDiff = Math.min(minDiff, difference);
        }
        return minDiff;
     
    }
    void helper(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}