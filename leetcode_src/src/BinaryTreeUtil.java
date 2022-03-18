import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode()
    {
    }
    TreeNode(int val)
    {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    void printByLayer()
    {
        Deque<TreeNode> q = new LinkedList<>();
        q.add(this);

        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            while (nodeCount-- > 0) {
                TreeNode node = q.getFirst();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

                System.out.format("%d ", node.val);
                q.removeFirst();
            }
            System.out.println();
        }
        System.out.println();
    }
}

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

public class BinaryTreeUtil {

    static private List<Integer> strToList(String s) {
        String[] values = s.split(",");
        List<Integer> arr = new ArrayList<>();
        for (String v : values) {
            if (v.equals("null")) {
                arr.add(null);
            }
            else {
                arr.add(Integer.valueOf(v));
            }
        }

        return arr;
    }

    static public TreeNode generateBinaryTree(String values)
    {
        List<Integer> nodes = strToList(values);
        if (nodes.size() == 0)
            return null;
        List<TreeNode> prev = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        Iterator<Integer> ite = nodes.iterator();
        TreeNode root = new TreeNode(ite.next());
        prev.add(root);

        while (ite.hasNext()) {
            // if(prev == null) break;
            for (TreeNode n : prev) {
                TreeNode ll = null, rl = null;
                Integer val = null;
                // if (ite.hasNext() && (val = ite.next()) != null) ll = new TreeNode(val);
                // if (ite.hasNext() && (val = ite.next()) != null) rl = new TreeNode(val);
                // if(ll != null) curr.add(ll);
                // if(rl != null) curr.add(rl);
                if (ite.hasNext()) {
                    val = ite.next();
                    ll = (val == null) ? null : new TreeNode(val);
                }
                if (ite.hasNext()) {
                    val = ite.next();
                    rl = (val == null) ? null : new TreeNode(val);
                }
                curr.add(ll);
                curr.add(rl);
                if(n != null) {
                    n.left = ll;
                    n.right = rl;
                }
            }
            prev = curr;
            curr = new ArrayList<>();
        }

        return root;
    }

    public static Node generateNaryTree(String values)
    {
        List<Integer> nodes = strToList(values);
        List<Node> prev = new ArrayList<>();
        List<Node> curr = new ArrayList<>();
        Node root = new Node(nodes.get(0));
        int n = nodes.size();

        prev.add(root);
        int i = 2;
        while (true) {
            curr = new LinkedList<>();

            for (Node node : prev) {
                node.children = new ArrayList<>();
                while (i < n && nodes.get(i) != null) {
                    Node newNode = new Node(nodes.get(i));
                    curr.add(newNode);
                    node.children.add(newNode);
                    i++;
                }
                i++;
            }
            prev = curr;
            if (i >= n)
                break;
        }

        return root;
    }
}
