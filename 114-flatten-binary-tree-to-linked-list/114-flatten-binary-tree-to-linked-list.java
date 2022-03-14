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
        List<TreeNode> nodes = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();

        if(root != null) s.push(root);
        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            while(n!=null) {
                if(n.right != null) s.push(n.right);
                nodes.add(n);
                n = n.left;
            }
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }
    }
}