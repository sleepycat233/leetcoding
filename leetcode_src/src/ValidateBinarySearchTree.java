import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree {

    //wrong.
/*     public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        else if ((root.left != null && root.left.val > root.val)
                || (root.right != null && root.right.val < root.val)) {
            return false;
        }
        if(isValidBST(root.left) == false || isValidBST(root.right) == false) return false;
        else return true;
    } */

    //wrong too!
    /* private int leftmax = Integer.MIN_VALUE, rightmin = Integer.MAX_VALUE;
    // private boolean verify_rec()

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        else {
            boolean r1 = isValidBST(root.left);
            if(root.left != null) leftmax = Math.min(rightmin, root.left.val);
            boolean r2 = isValidBST(root.right);
            if(root.right != null) rightmin = Math.max(leftmax, root.right.val);

            if(r1 == false || r2 == false) return false;
            if((root.left != null && root.left.val > root.val)
                || (root.right != null && root.right.val < root.val)) return false;
            if(root.left != null && root.left.val > leftmax) leftmax = root.left.val;
            if(root.right != null && root.right.val < rightmin) rightmin = root.right.val;
            if(leftmax > root.val || rightmin < root.val) return false;

            return true;
        }
    } */

    // Runtime: 2 ms, faster than 22.11% of Java online submissions for Validate Binary Search Tree.
    // Memory Usage: 44.7 MB, less than 6.29% of Java online submissions for Validate Binary Search Tree.
    public boolean isValidBST(TreeNode root)
    {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        int prev = arr.get(0);
        for(int i = 1; i < arr.size(); i++) {
            if(arr.get(i) <= prev) {
                return false;
            }
            prev = arr.get(i);
        }
        return true;
    }

    private void inorder(TreeNode node, List<Integer> arr) {
        if(node == null) return;

        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
    }


    public boolean isValidBST2(TreeNode root) {
        return verify(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean verify(TreeNode root, long lower, long upper)
    {
        if (root == null) {
            return true;
        }
        else if (root.val >= upper || root.val <= lower) {
            return false;
        }
        return verify(root.left, lower, root.val) && verify(root.right, root.val, upper);
    }

    Deque<TreeNode> stack3 = new LinkedList<>();
    Deque<Integer> lower = new LinkedList<>();
    Deque<Integer> upper = new LinkedList<>();
    public boolean isValidBST3(TreeNode root) {
        Integer low = null, up = null;
        updateNode(root, low, up);
        while(!stack3.isEmpty()) {
            root = stack3.pop();
            low = lower.pop();
            up = upper.pop();

            if(root == null) continue;
            if((low != null && root.val <= low)
             || up != null && root.val >= up) {
                return false;
            }
            updateNode(root.right, root.val, up);
            updateNode(root.left, low, root.val);
        }
        return true;
    }

    private void updateNode(TreeNode node, Integer low, Integer up) {
        stack3.push(node);
        lower.push(low);
        upper.push(up);
    }

    public static void main(String[] args) {
        TreeNode t1 = BinaryTreeUtil.generateBinaryTree("3,1,5,0,6");
        t1.printByLayer();
        TreeNode t2 = BinaryTreeUtil.generateBinaryTree("2,1,3");
        t2.printByLayer();


        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();
        System.out.println(sol.isValidBST(t1));
        System.out.println(sol.isValidBST(t2));

        System.out.println(sol.isValidBST2(t1));
        System.out.println(sol.isValidBST2(t2));

        System.out.println(sol.isValidBST3(t1));
        System.out.println(sol.isValidBST3(t2));
    }
}
