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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return result;
        }
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < level ; i++) {
                if(queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                 if(queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
            if(leftToRight) {
                list.add(queue.poll().val);
            }else{
                list.add(0,queue.poll().val);
            }
            }
            result.add(list);
            leftToRight = !leftToRight;
        }
        return result;
    }
}