import java.util.ArrayList;
import java.util.List;

class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    }

    private int helper(List<List<Integer>> ans, TreeNode node) {
        if(node == null) {
            return -1;
        }
        else {
            int lh = helper(ans, node.left);
            int rh = helper(ans, node.right);
            int height = Math.max(lh, rh) + 1;

            if(ans.size() < height+1) {
                ans.add(new ArrayList<>());
            }

            ans.get(height).add(node.val);

            return height;
        }
    }


    // O(nlogn)
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeNode dummy = new TreeNode(-1, root, null);

        while (dummy.left != null) {
            List<Integer> values = new ArrayList<>();
            helper(values, dummy, root);
            ans.add(new ArrayList<>(values));
        }

        return ans;
    }

    private void helper(List<Integer> values, TreeNode parent, TreeNode node) {
        if (node == null) {
            return;
        }
        else if(node.left == null && node.right == null) {
            values.add(node.val);

            if(parent.left == node) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
        else {
            helper(values, node, node.left);
            helper(values, node, node.right);
        }
    }

    public static void main(String[] args) {
        FindLeavesOfBinaryTree sol = new FindLeavesOfBinaryTree();
        TreeNode t1 = BinaryTreeUtil.generateBinaryTree("1,2,3,4,5");
        TreeNode t2 = BinaryTreeUtil.generateBinaryTree("1");

        sol.findLeaves2(t1)
            .forEach(System.out::println);
    }
}