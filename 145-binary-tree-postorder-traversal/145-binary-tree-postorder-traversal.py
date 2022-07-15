# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        s1 = []
        s2 = []
        res = []

        if root: s1.append(root)
        while s1:
            head = s1.pop()
            s2.append(head.val)
            if head.left: s1.append(head.left)
            if head.right: s1.append(head.right)
        # while s2:
        #     res.append(s2.pop().val)

        s2.reverse()
        return s2