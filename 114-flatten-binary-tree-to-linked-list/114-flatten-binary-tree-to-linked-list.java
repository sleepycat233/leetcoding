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
    public void flatten(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode prev = null;

        if (root != null) s.push(root);

        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            while (curr != null) {
                TreeNode next = curr.left;
                if (curr.right != null) s.push(curr.right);
                if (prev != null) {
                    prev.left = null;
                    prev.right = curr;
                }
                prev = curr;
                curr = next;
            }
        }
    }
}