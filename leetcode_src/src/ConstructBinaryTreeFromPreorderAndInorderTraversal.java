import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToNode(preorder, 0, preorder.length-1);
    }

    private TreeNode arrayToNode(int[] preorder, int left, int right) {
        if(left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInorder = inorderIndexMap.get(rootValue);
        root.left = arrayToNode(preorder, left, rootIndexInorder-1);
        root.right = arrayToNode(preorder, rootIndexInorder+1, right);
        return root;
    }

    public static void main(String[] args) {
        // TreeNode t1 = BinaryTreeUtil.generateBinaryTree("")

        ConstructBinaryTreeFromPreorderAndInorderTraversal sol = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        TreeNode res = sol.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        res.printByLayer();
    }
}
