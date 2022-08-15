from BinaryTreeUtil import *

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def helper(root, pv, qv):
            if pv <= root.val and qv >= root.val:
                return root
            elif qv < root.val:
                return helper(root.left, pv, qv)
            else:
                return helper(root.right, pv, qv)

        if p.val > q.val:
            p, q = q, p
        return helper(root, p.val, q.val)

if __name__ == '__main__':
    t1 = generateBinaryTree("6,2,8,0,4,7,9,null,null,3,5")
    print(inorder(t1))
    print(Solution().lowestCommonAncestor(t1, TreeNode(2), TreeNode(8)).val)