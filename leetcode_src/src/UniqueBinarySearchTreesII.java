import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return getSubtree(0, n - 1);
    }

    private List<TreeNode> getSubtree(int left, int right) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();

        if (left > right) {
            allTrees.add(null);
            return allTrees;
        }
        else if (left == right) {
            TreeNode n = new TreeNode(left+1);
            allTrees.add(n);
            return allTrees;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = getSubtree(left, i-1);
            List<TreeNode> rightTrees = getSubtree(i+1, right);

            for(TreeNode l : leftTrees) {
                for(TreeNode r : rightTrees) {
                    TreeNode root = new TreeNode(i+1);
                    root.left = l;
                    root.right = r;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII sol = new UniqueBinarySearchTreesII();
        List<TreeNode> res = sol.generateTrees(3);
        for(TreeNode root : res) {
            root.printByLayer();
        }
    }
}
