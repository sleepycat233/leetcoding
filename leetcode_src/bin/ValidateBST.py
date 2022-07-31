class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        prev = None
        while stack or root:
            while root:
                stack.append(root)
                root = root.left

            root = stack.pop()
            curr = root.val
            if prev and prev >= curr: return False

            prev = curr
            root = root.right

        return True