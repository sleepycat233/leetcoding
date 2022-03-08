import java.util.*;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        preo_rec(root, res);
        return res;
    }

    private void preo_rec(Node node, List<Integer> res) {
        res.add(node.val);
        if(node.children == null) return;

        for(Node n : node.children) {
            preo_rec(n, res);
        }
    }


    public static void main(String[] args) {
        // String value = "1,null,3,2,4,null,5,6";
        String value = "1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14";

        Node tree1 = BinaryTreeUtil.generateNaryTree(value);
        NaryTreePreorderTraversal sol = new NaryTreePreorderTraversal();
        System.out.println(sol.preorder(tree1));
    }
}
