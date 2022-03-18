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
        TreeNode n = root;
        while(n != null) {
            if(n.left == null) {
                n = n.right;
                continue;
            }
            else {
                TreeNode pre = n.left;
                if(n.right != null) {
                    while(pre.left != null || pre.right != null) {
                        if(pre.right != null) {
                            pre = pre.right;
                        }
                        else if(pre.left != null) {
                            pre = pre.left;
                        }
                    }
                    pre.right = n.right;
                }
                n.right = n.left;
                n.left = null;
            }
        }
    }
}