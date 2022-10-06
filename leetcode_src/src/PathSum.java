
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return helper(root, 0, targetSum);
    }

    private boolean helper(TreeNode node, int curr, int targetSum) {
        if (node == null) return false;
        else if(node.left == null && node.right == null) {
            return curr+node.val == targetSum;
        }
        else {
            if(helper(node.left, curr+node.val, targetSum) ||
             helper(node.right, curr+node.val, targetSum)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode t1 = BinaryTreeUtil.generateBinaryTree("5,4,8,11,null,13,4,7,2,null,null,null,1");
        // TreeNode t1 = BinaryTreeUtil.generateBinaryTree("1,2");

        // t1.printByLayer();
        PathSum sol = new PathSum();
        System.out.println(sol.hasPathSum(t1, 22));
    }
}
