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
    public List<TreeNode> generateTrees(int n) {
        return getSubtree(0, n - 1);
    }

    private List<TreeNode> getSubtree(int left, int right) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();

        if (left > right) {
            allTrees.add(null);
            return allTrees;
        }
        else if (left == right) {
            TreeNode n = new TreeNode(left+1);
            allTrees.add(n);
            return allTrees;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = getSubtree(left, i-1);
            List<TreeNode> rightTrees = getSubtree(i+1, right);

            for(TreeNode l : leftTrees) {
                for(TreeNode r : rightTrees) {
                    TreeNode root = new TreeNode(i+1);
                    root.left = l;
                    root.right = r;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}