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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
          if(root == null) {
            return result;
        }
        helper(root, targetSum, list, result);
     return result;
    }
    void helper(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result){
        if(root == null) {
            return;
        }
         list.add(root.val);
         targetSum = targetSum - root.val;
          if(root.right ==  null && root.left == null) { // when we are at the leaf node
       if(targetSum == 0) {
       result.add(new ArrayList<>(list));
      }
    }
        helper(root.left, targetSum , list, result);
        helper(root.right, targetSum, list, result);
        list.remove(list.size()-1);
    }
}