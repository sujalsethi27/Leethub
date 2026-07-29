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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return 0;
        }
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int currentLevel = 1;
        int ans = 1;
        while(!queue.isEmpty()) {
        int sum = 0;
        int level = queue.size();
         for(int i = 0; i < level; i++) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.offer(node.left);
            }
             if(node.right != null) {
                queue.offer(node.right);
            }
            sum += node.val;
         }
           if(sum > maxSum) {
                maxSum = sum;
                ans = currentLevel;
            }
             currentLevel++;
             maxSum = Math.max(maxSum , sum);
        }
        return ans;
    }
}