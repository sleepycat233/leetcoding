from typing import *
from TreeInorderTraversal import TreeNode

class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        s1 = []
        s2 = []

        if root: s1.append(root)
        while s1:
            head = s1.pop()
            s2.append(head.val)
            if head.left: s1.append(head.left)
            if head.right: s1.append(head.right)

        s2.reverse()
        return s2

    def postorderTraversal2(self, root: Optional[TreeNode]) -> List[int]:
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