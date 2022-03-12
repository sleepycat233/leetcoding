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

    public boolean isValidBST(TreeNode root) {
        return verify(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean verify(TreeNode root, long lower, long upper)
    {
        if (root == null) {
            return true;
        }
        // else if ((root.left != null && root.left.val > root.val)
        //         || (root.right != null && root.right.val < root.val)) {
        //     return false;
        // }
        else if (root.val >= upper || root.val <= lower) {
            return false;
        }

        // if (verify(root.left, lower, root.val) == false
        //     || verify(root.right, root.val, upper) == false) {
        //     return false;
        // }
        // return true; //* rewrite to
        return verify(root.left, lower, root.val) && verify(root.right, root.val, upper);
    }
}