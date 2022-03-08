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
        Deque<Node> q = new LinkedList<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                Node curr = q.remove();
                /* if (curr.children != null) {
                    for (Node c : curr.children) {
                        q.add(c);
                    }
                } */
                if(curr.children != null) q.addAll(curr.children);
                level.add(curr.val);
            }
            res.add(level);
        }
        return res;
    }
}