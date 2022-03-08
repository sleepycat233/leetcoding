import java.util.*;

public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null) {
            if(val < root.val) {
                root = root.left;
            }
            else if(val > root.val) {
                root = root.right;
            }
            else {
                break;
            }
        }

        return root;
    }

    public static void main(String[] args)
    {
        String value = "4,2,7,1,3";

        TreeNode tree1 = BinaryTreeUtil.generateBinaryTree(value);
        tree1.printByLayer();
        SearchBST sol = new SearchBST();
        System.out.println(sol.searchBST(tree1, 2).val);
    }
}
