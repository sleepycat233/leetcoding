from typing import *
from BinaryTreeUtil import *

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        stack = [(root, 0)]
        if not root: return False

        run = 0
        while stack:
            node, run = stack.pop()
            if node.left:
                stack.append((node.left, run+node.val))
            if node.right:
                stack.append((node.right, run+node.val))

            if not node.left and not node.right and run + node.val == targetSum:
                return True

        return False

if __name__ == '__main__':
    t1 = generateBinaryTree("5,4,8,11,null,13,4,7,2,null,null,null, null,null,1")
    print(inorder(t1))

    print(Solution().hasPathSum(t1, 18))
