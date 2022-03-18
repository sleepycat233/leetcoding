import java.util.*;

public class FlattenBinaryTreetoLinkedList {
    // recursive
    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();

        preorder(root, nodes);
        for(int i = 0; i < nodes.size()-1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i+1);
        }
    }

    private void preorder(TreeNode root, List<TreeNode> nodes) {
        if(root == null) return;
        nodes.add(root);
        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }

    // iterative solution
    public void flatten2(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();

        if(root != null) s.push(root);

        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            while(n!=null) {
                if(n.right != null) s.push(n.right);
                nodes.add(n);
                n = n.left;
            }
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }
    }

    // iteratively flatten
    public void flatten3(TreeNode root)
    {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode prev = null;

        if (root != null) s.push(root);

        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            while (curr != null) {
                TreeNode next = curr.left;
                if (curr.right != null) s.push(curr.right);
                if (prev != null) {
                    prev.left = null;
                    prev.right = curr;
                }
                prev = curr;
                curr = next;
            }
        }
    }

    // space O(1), flatten in-place
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
    // Memory Usage: 41.9 MB, less than 65.31% of Java online submissions for Flatten Binary Tree to Linked List.

    public void flatten4(TreeNode root)
    {
        TreeNode n = root;
        while(n != null) {
            if(n.left == null) {
                n = n.right;
                continue;
            }
            else {
                TreeNode pre = n.left;
                if(n.right != null) {
                    while(pre.left != null || pre.right != null) {
                        if(pre.right != null) {
                            pre = pre.right;
                        }
                        else if(pre.left != null) {
                            pre = pre.left;
                        }
                    }
                    pre.right = n.right;
                }
                n.right = n.left;
                n.left = null;
            }
        }
    }

    public static void main(String[] args) {
        // TreeNode t1 = BinaryTreeUtil.generateBinaryTree("1,2,5,3,4,null,6");
        TreeNode t2 = BinaryTreeUtil.generateBinaryTree("1,2,3,null,null,4,null,null,null,null,null,null,5");

        t2.printByLayer();
        FlattenBinaryTreetoLinkedList sol = new FlattenBinaryTreetoLinkedList();
        sol.flatten4(t2);
        t2.printByLayer();

        // TreePreorderTraversal obj = new TreePreorderTraversal();
        // System.out.println(obj.preorderTraversal(t2));
        // TreeInorderTraversal obj2 = new TreeInorderTraversal();
        // System.out.println(obj2.inorderTraversal(t2));
    }
}
