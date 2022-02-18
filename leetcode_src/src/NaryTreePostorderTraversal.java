import java.util.*;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root)
    {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        posto_rec(root, res);
        res.add(root.val);
        return res;
    }

    private void posto_rec(Node node, List<Integer> res)
    {
        if (node.children == null) {
            return;
        }

        for (Node n : node.children) {
            posto_rec(n, res);
            res.add(n.val);
        }
    }

    public static void main(String[] args)
    {
        String value = "1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14";
        // String value = "1,null,3,2,4,null,5,6";
        String[] strs = value.split(",");
        List<Integer> arr = new ArrayList<>();
        for (String s : strs) {
            if (s.equals("null")) {
                arr.add(null);
            }
            else {
                arr.add(Integer.valueOf(s));
            }
        }

        Node tree1 = NaryTreePreorderTraversal.generateNaryTree(arr);
        NaryTreePostorderTraversal sol = new NaryTreePostorderTraversal();
        System.out.println(sol.postorder(tree1));
    }
}
