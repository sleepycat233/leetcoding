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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
                if(root == null) return res;

        List<Integer> level = List.of(root.val);
        List<Node> prev = List.of(root);
        List<Node> curr = null;
        res.add(level);

        while(true) {
            curr = new ArrayList<>();
            level = new ArrayList<>();
            for(Node n : prev) {
                if(n.children != null) {
                    for(Node c : n.children) {
                        level.add(c.val);
                        curr.add(c);
                    }
                }
            }
            if(level.isEmpty()) break;
            res.add(level);
            prev = curr;
        }

        return res;
    }
}