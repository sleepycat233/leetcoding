from typing import *
from BinaryTreeUtil import *

class Solution:
    # preorder and flatten at the same time
    def flatten4(self, root: Optional[TreeNode]) -> None:
        stack = []
        curr = root
        prev = None

        while curr or stack:
            while curr:
                if prev:
                    prev.right = curr
                    prev.left = None
                if curr.right:
                    stack.append(curr.right)
                prev = curr
                curr = curr.left
            curr = stack.pop() if stack else None



    def flatten(self, root: Optional[TreeNode]) -> None:
        self.flattenTree(root)

    def flattenTree(self, node):
        if not node:
            return None
        if not node.left and not node.right:
            return node

        leftTail = self.flattenTree(node.left)
        rightTail = self.flattenTree(node.right)

        if not leftTail:
            return rightTail

        leftTail.right = node.right
        node.right = node.left
        node.left = None

        return rightTail if rightTail else leftTail


    def flatten2(self, root: Optional[TreeNode]) -> None:
        node = root
        while node:
            if node.left:
                rightMost = node.left
                if node.right:
                    while rightMost.left and not rightMost.right:
                        rightMost = rightMost.left
                    while rightMost.right:
                        rightMost = rightMost.right

                    rightMost.right = node.right
                    node.right = node.left
                    node.left = None

                else:
                    node.right = node.left
                    node.left = None

            node = node.right

    def flatten3(self, root: Optional[TreeNode]) -> None:
        node = root
        while node:
            if node.left:
                predecessor = node.left
                while predecessor.right:
                    predecessor = predecessor.right
                predecessor.right = node.right
                node.right = node.left
                node.left = None
            node = node.right


t1 = generateBinaryTree("1,2,5,3,4,null,6")
print(inorder(t1))
Solution().flatten4(t1)
print(inorder(t1))
