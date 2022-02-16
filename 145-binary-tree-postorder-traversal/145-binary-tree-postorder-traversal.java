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
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> s = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        TreeNode node = root;
        TreeNode prev = null;
        while(!s.isEmpty() || node != null) {
            while(node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if(node.right == null || node.right == prev) {
                res.add(node.val);
                prev = node;
                node = null;
            }
            else {
                s.push(node);
                node = node.right;
            }
        }

        return res;
    }
}