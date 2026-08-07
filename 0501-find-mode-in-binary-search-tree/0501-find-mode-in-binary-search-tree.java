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

    public int[] findMode(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(root, list);

        // Pass 1 -> Find max frequency
        int maxFreq = 1;
        int currFreq = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                currFreq++;
            } else {
                currFreq = 1;
            }

            maxFreq = Math.max(maxFreq, currFreq);
        }

        // Pass 2 -> Store all values having max frequency
        List<Integer> ansList = new ArrayList<>();
        currFreq = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                currFreq++;
            } else {
                if (currFreq == maxFreq) {
                    ansList.add(list.get(i - 1));
                } // we are writing the same thing again in 3rd pass because here the else block never get executed for the last group as there is no element after the last group ended and it always do currFreq++ and never add that into list
                currFreq = 1;
            }
        }

        // Last group
        if (currFreq == maxFreq) {
            ansList.add(list.get(list.size() - 1));
        }
     // now if the last group has the max freq and which is not added in the second pass will be added here in the if block above
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

    void helper(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}