# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
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
        