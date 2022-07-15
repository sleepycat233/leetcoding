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
    Map<Integer, Integer> map = new HashMap<>();
    int preorderIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)       
            map.put(inorder[i], i);
        
        TreeNode root = findNode(preorder, 0, preorder.length-1);
        return root;
    }
    
    private TreeNode findNode(int[] preorder, int start, int end) {
        if(start > end) return null;
        
        int val = preorder[preorderIndex++];
        int rootIndex = map.get(val);
        TreeNode root = new TreeNode(val);
        
        root.left = findNode(preorder, start, rootIndex-1);
        root.right = findNode(preorder, rootIndex+1, end);
        
        return root;
    }
        
}