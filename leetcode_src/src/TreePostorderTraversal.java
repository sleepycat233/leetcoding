import java.util.*;
public class TreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root)
    {
        Deque<TreeNode> s = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        TreeNode node = root;
        TreeNode prev = null;
        while(!s.isEmpty() || node != null) {
            while(node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if(node.right == null || node.right == prev) {
                res.add(node.val);
                prev = node;
                node = null;
            }
            else {
                s.push(node);
                node = node.right;
            }
        }

        return res;
    }
    public static void main(String[] args)
    {
        TreePostorderTraversal sol = new TreePostorderTraversal();
        TreeNode tree1 = BinaryTreeUtil.generatePerfectTree(3);
        tree1.printByLayer();
        System.out.println(sol.postorderTraversal(tree1));
        System.out.println(sol.postorderTraversal(null));
    }
}
