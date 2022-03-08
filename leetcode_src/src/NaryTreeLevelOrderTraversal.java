import java.util.*;

public class NaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder2(Node root) {
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

    public static void main(String[] args)
    {
        String value = "1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14";

        Node tree1 = BinaryTreeUtil.generateNaryTree(value);
        NaryTreeLevelOrderTraversal sol = new NaryTreeLevelOrderTraversal();
        System.out.println(sol.levelOrder(tree1));
        System.out.println(sol.levelOrder2(tree1));
    }
}
