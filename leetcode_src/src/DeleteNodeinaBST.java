public class DeleteNodeinaBST {
    private TreeNode minval(TreeNode root)
    {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    private TreeNode maxval(TreeNode root)
    {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;

        while(node != null && node.val != key) {
            if(key < node.val) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
        if(node == null) return root;

        

        return root;
    }
}
