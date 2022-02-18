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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        preo_rec(root, res);
        return res;
    }

    private void preo_rec(Node node, List<Integer> res) {
        // if(node == null) return;
        res.add(node.val);
        if(node.children == null) return;

        for(Node n : node.children) {
            preo_rec(n, res);
        }
    }

}