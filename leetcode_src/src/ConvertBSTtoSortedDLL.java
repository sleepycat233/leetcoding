import java.util.ArrayDeque;
import java.util.Deque;

public class ConvertBSTtoSortedDLL {
    public TreeNode treeToDoublyList(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        inorder(root, queue);

        TreeNode first = (!queue.isEmpty()) ? queue.poll() : null;
        TreeNode last = null;
        TreeNode prev = first;

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            curr.left = prev;
            prev.right = curr;
            prev = curr;
        }
        last = prev;
        if(first != null && last != null) {
            first.left = last;
            last.right = first;
        }

        return first;
    }

    private void inorder(TreeNode root, Deque<TreeNode> queue) {
        if(root != null) {
            inorder(root.left, queue);
            queue.add(root);
            inorder(root.right, queue);
        }
    }

    public static void main(String[] args) {
        ConvertBSTtoSortedDLL sol = new ConvertBSTtoSortedDLL();
        TreeNode tree = BinaryTreeUtil.generateBinaryTree("4,2,5,1,3");
        tree = sol.treeToDoublyList(tree);
        System.out.println();
    }
}
