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
        return getSubTree(0, n-1);
    }
    
    private List<TreeNode> getSubTree(int left, int right) {
        List<TreeNode> allTrees = new ArrayList<>();
        if(left > right) {
            allTrees.add(null);
            return allTrees;
        }
        else if(left == right) {
            allTrees.add(new TreeNode(left+1));
            return allTrees;
        }
        
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = getSubTree(left, i-1);
            List<TreeNode> rightTrees = getSubTree(i+1, right);
            
            for(TreeNode lt : leftTrees) {
                for(TreeNode rt : rightTrees) {
                    TreeNode root = new TreeNode(i+1);
                    root.left = lt;
                    root.right = rt;
                    allTrees.add(root);
                }
            }
        }
            
        return allTrees;
            
    }
}