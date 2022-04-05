public class BalancedBinaryTree {
    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        else return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    // time O(n^2)
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        else if(Math.abs(getHeight(root.left)-getHeight(root.right)) > 1) {
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // time O(n^2)
    public boolean isBalanced2(TreeNode root) {
        if(root == null) {
            return true;
        }
        else {
            boolean res = isBalanced(root.left) && isBalanced(root.right)
                        && Math.abs(getHeight(root.left)-getHeight(root.right)) <= 1;
            return res;
        }
    }

    // bottom-up
    public boolean isBalanced3(TreeNode root) {
        return (isb(root) != -1);
    }

    private int isb(TreeNode root) {
        if(root == null) return 0;
        else {
            int lheight = isb(root.left);
            int rheight = isb(root.right);
            if(lheight == -1 || rheight == -1 || Math.abs(lheight - rheight) > 1) return -1;
            else return 1 + Math.max(lheight, rheight);
        }
    }

    public static void main(String[] args) {
        // TreeNode t1 = BinaryTreeUtil.generateBinaryTree("3,9,20,null,null,15,7");
        TreeNode t1 = BinaryTreeUtil.generateBinaryTree("1,2,2,3,3,null,null,4,4");
        t1.printByLayer();

        BalancedBinaryTree sol = new BalancedBinaryTree();
        System.out.println(sol.getHeight(t1));
        System.out.println(sol.isBalanced3(t1));
    }
}
