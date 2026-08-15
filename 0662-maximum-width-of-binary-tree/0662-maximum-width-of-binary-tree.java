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
    int ans = 0;
    public int widthOfBinaryTree(TreeNode root) {
       Queue<Pair> queue = new LinkedList<>();
       if(root == null) {
        return 0;
       }
       queue.offer(new Pair(root,0));
       while(!queue.isEmpty()) {
        int level = queue.size();
        int first = 0;
        int last = 0;
        for(int i = 0; i < level; i++) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int index = p.index;
            if(node.left != null) {
                queue.offer(new Pair(node.left, 2*index));
            }
            if(node.right != null) {
                queue.offer(new Pair(node.right, 2*index + 1));
            }
           if (i == 0) {
           first = index;
           }
          if (i == level - 1) {
          last = index;
             }
        }
         int width = last - first + 1;
         ans = Math.max(width, ans);
       }
       return ans;
    }
}

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}