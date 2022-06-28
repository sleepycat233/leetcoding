import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new LinkedList<>();
        if(root != null) s.push(root);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            res.add(node.val);
            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }
        return res;
    }

    // recursive
    public List<Integer> preorderTraversal2(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if(node == null) return;
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }

    //iterative
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        if (root == null) return res;

        while(!s.isEmpty() || root != null) {
            while(root != null) {
                res.add(root.val);
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreePreorderTraversal obj = new TreePreorderTraversal();
        TreeNode tree1 = BinaryTreeUtil.generatePerfectTree(3);
        tree1.printByLayer();
        System.out.println(obj.preorderTraversal(tree1));
        System.out.println(obj.preorderTraversal2(tree1));
        System.out.println(obj.preorderTraversal3(tree1));
    }
}
