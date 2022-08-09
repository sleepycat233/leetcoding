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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, root);

        return ans;
    }

    private int helper(List<List<Integer>> ans, TreeNode node) {
        if(node == null) {
            return -1;
        }
        else {
            int lh = helper(ans, node.left);
            int rh = helper(ans, node.right);
            int height = Math.max(lh, rh) + 1;

            if(ans.size() < height+1) {
                ans.add(new ArrayList<>());
            }

            ans.get(height).add(node.val);

            return height;
        }
    }
}