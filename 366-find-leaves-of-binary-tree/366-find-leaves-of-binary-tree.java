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
        TreeNode dummy = new TreeNode(-1, root, null);

        while (dummy.left != null) {
            List<Integer> values = new ArrayList<>();
            helper(values, dummy, root);
            ans.add(new ArrayList<>(values));
        }

        return ans;
    }

    private void helper(List<Integer> values, TreeNode parent, TreeNode node) {
        if (node == null) {
            return;
        }
        else if(node.left == null && node.right == null) {
            values.add(node.val);

            if(parent.left == node) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
        else {
            helper(values, node, node.left);
            helper(values, node, node.right);
        }
    }

}