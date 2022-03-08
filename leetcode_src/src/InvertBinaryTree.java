import java.util.*;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        else {
            TreeNode l = invertTree(root.left);
            TreeNode r = invertTree(root.right);
            root.left = r;
            root.right = l;
            return root;
        }
    }

    public TreeNode invertTree2(TreeNode root) {
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        if(root != null) prev.add(root);

        while(!prev.isEmpty()) {
            curr = new ArrayList<>();
            for(TreeNode n : prev) {
                TreeNode t = n.left;
                n.left = n.right;
                n.right = t;
                if(n.left != null) curr.add(n.left);
                if(n.right != null) curr.add(n.right);
            }
            prev = curr;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree1 = BinaryTreeUtil.generateBinaryTree("4,2,7,1,3,null,9");
        tree1.printByLayer();
        InvertBinaryTree sol = new InvertBinaryTree();
        tree1 = sol.invertTree2(tree1);
        tree1.printByLayer();
    }
}
