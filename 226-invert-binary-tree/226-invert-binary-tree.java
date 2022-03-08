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
    public TreeNode invertTree(TreeNode root) {
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        if(root != null) prev.add(root);

        while(!prev.isEmpty()) {
            curr = new ArrayList<>();
            for(TreeNode n : prev) {
                TreeNode t = (n != null) ? n.left : null;
                n.left = n.right;
                n.right = t;
                if(n.left != null) curr.add(n.left);
                if(n.right != null) curr.add(n.right);
            }
            prev = curr;
        }

        return root;
    }
}