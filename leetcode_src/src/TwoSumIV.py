from typing import *
from BinaryTreeUtil import *

class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        diffset = set()

        def preorder(node):
            if node == None:
                return False
            elif node.val in diffset:
                return True
            diffset.add(k - node.val)

            if preorder(node.left) or preorder(node.right):
                return True

        return preorder(root)

if __name__ == '__main__':
    t1 = generateBinaryTree("5,3,6,2,4,null,7")
    print(Solution().findTarget(t1, 9))