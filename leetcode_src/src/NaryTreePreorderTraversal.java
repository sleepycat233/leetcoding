import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

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

    public static Node generateNaryTree(List<Integer> nodes) {
        Deque<Node> prev = new LinkedList<>();
        Deque<Node> curr = new LinkedList<>();
        Node root = new Node(nodes.get(0));
        int n = nodes.size();

        prev.add(root);
        int i = 2;
        while(true) {
            curr = new LinkedList<>();

            for(Node node : prev) {
                node.children = new ArrayList<>();
                while(i < n && nodes.get(i) != null) {
                    Node newNode = new Node(nodes.get(i));
                    curr.add(newNode);
                    node.children.add(newNode);
                    i++;
                }
                i++;
            }
            prev = curr;
            if(i >= n) break;
        }

        return root;
    }

    public static void main(String[] args) {
        // String value = "1,null,3,2,4,null,5,6";
        String value = "1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14";
        String[] strs = value.split(",");
        List<Integer> arr = new ArrayList<>();
        for(String s : strs) {
            if(s.equals("null")) {
                arr.add(null);
            }
            else {
                arr.add(Integer.valueOf(s));
            }
        }

        Node tree1 = NaryTreePreorderTraversal.generateNaryTree(arr);
        NaryTreePreorderTraversal sol = new NaryTreePreorderTraversal();
        System.out.println(sol.preorder(tree1));
    }
}
