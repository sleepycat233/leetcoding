/*
// Definition for a Node.
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
*/

class Solution {

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
}