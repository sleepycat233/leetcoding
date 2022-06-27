import java.util.ArrayList;
import java.util.List;

public class TreeMorrisTraversal {
    public void Morris(TreeNode root) {
        TreeNode curr = root;
        TreeNode mostRight = null;

        while(curr != null) {
            mostRight = curr.left;
            if(mostRight != null) {
                while(mostRight.right != null && mostRight.right != curr) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right != curr) {
                    mostRight.right = curr;
                    curr = curr.right;
                }
                else {
                    mostRight.right = null;
                    curr = curr.right;
                }
            }
            else {
                curr = curr.right;
            }
        }
    }

    public List<Integer> MorrisInorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode mostRight = null;

        while (curr != null) {
            mostRight = curr.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != curr) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right != curr) {
                    mostRight.right = curr;
                    curr = curr.left;
                } else {
                    res.add(curr.val);
                    mostRight.right = null;
                    curr = curr.right;
                }
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = BinaryTreeUtil.generatePerfectTree(3);
        t1.printByLayer();
        TreeMorrisTraversal sol = new TreeMorrisTraversal();
        List<Integer> res = sol.MorrisInorder(t1);
        System.out.println(res);
    }
}
