from typing import *
from BinaryTreeUtil import *

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        prev = TreeNode()
        def helper(node):
            nonlocal prev

            if not node:
                return
            else:
                helper(node.right)
                helper(node.left)

    def flatten2(self, root: Optional[TreeNode]) -> None:
        
