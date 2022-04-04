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
    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        else return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        else if(Math.abs(getHeight(root.left)-getHeight(root.right)) > 1) {
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
}