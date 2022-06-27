import java.util.*;
public class TreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if(node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> s = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        TreeNode node = root;
        while(!s.isEmpty() || node != null) {
            while(node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            res.add(node.val);
            node = node.right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeInorderTraversal sol = new TreeInorderTraversal();
        TreeNode tree1 = BinaryTreeUtil.generatePerfectTree(3);
        tree1.printByLayer();
        System.out.println(sol.inorderTraversal(tree1));
        System.out.println(sol.inorderTraversal2(tree1));
    }
}
