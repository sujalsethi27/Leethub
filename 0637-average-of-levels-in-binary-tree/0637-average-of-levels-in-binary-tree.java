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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
        int level = queue.size();
        double sum = 0.0;
        for( int i = 0 ; i < level ; i++) {
         TreeNode node = queue.poll();
         if(node.left != null) {
            queue.offer(node.left);
         }
          if(node.right != null) {
            queue.offer(node.right);
         }
         sum += node.val;
        }
        double avg = (double) sum / level;
        result.add(avg);
        }
        return result;
    }
}