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
    int postorderIndex;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length-1;

        for(int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        TreeNode root = getRootOfSubtree(postorder, 0, postorder.length-1);
        return root;
    }

    private TreeNode getRootOfSubtree(int[] postorder, int left, int right) {
        if(left > right) return null;

        int rootValue = postorder[postorderIndex--];
        int rootIndex = inorderIndexMap.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.right = getRootOfSubtree(postorder, rootIndex+1, right);
        root.left = getRootOfSubtree(postorder, left, rootIndex-1);
        return root;
    }
}