import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
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

    public static void main(String[] args) {
        // TreeNode t1 = BinaryTreeUtil.generateBinaryTree("")

        ConstructBinaryTreeFromInorderAndPostorderTraversal sol =
                new ConstructBinaryTreeFromInorderAndPostorderTraversal();

        // int[] inorder = new int[] {9, 3, 15, 20, 7};
        // int[] postorder = new int[] {9, 15, 7, 20, 3};
        int[] inorder = new int[] {3,2,1};
        int[] postorder = new int[] {3, 2, 1};

        TreeNode res = sol.buildTree(inorder, postorder);
        res.printByLayer();
    }

}
