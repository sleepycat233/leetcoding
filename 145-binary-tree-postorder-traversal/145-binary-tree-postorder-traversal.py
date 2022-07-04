# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack = []
        res = []
        prev = None

        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if not root.right or prev == root.right:
                res.append(root.val)
                prev = root
                root = None
            else:
                stack.append(root)
                root = root.right

        return res