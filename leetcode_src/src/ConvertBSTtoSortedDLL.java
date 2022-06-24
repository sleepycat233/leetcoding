import java.util.ArrayDeque;
import java.util.Deque;

public class ConvertBSTtoSortedDLL {
    public Node treeToDoublyList(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        inorder(root, queue);

        Node first = (!queue.isEmpty()) ? queue.poll() : null;
        Node last = null;
        Node prev = first;

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
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

    private void inorder(Node root, Deque<Node> queue) {
        if(root != null) {
            inorder(root.left, queue);
            queue.add(root);
            inorder(root.right, queue);
        }
    }

    public static void main(String[] args) {
        ConvertBSTtoSortedDLL sol = new ConvertBSTtoSortedDLL();
        Node tree = BinaryTreeUtil.generateBinaryTree("4,2,5,1,3");
        tree = sol.treeToDoublyList(tree);
        System.out.println();
    }
}
