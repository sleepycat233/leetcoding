from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

""" def generateBinaryTree(s: str) -> TreeNode:
    values = deque([x.strip() for x in s.split(',')])
    prev = deque([TreeNode(values.popleft)])
    # curr = deque([])

    while values:
        curr = deque()
        nodeCount = len(prev)

        while nodeCount:
            nodeCount -= 1
            pn = prev.popleft()
            pn.left = TreeNode(lv) if lv != 'null' else None

        prev = curr """

def generateBinaryTree(s: str) -> TreeNode:
    values = [x.strip() for x in s.split(',')]
    root = TreeNode()
    def generate(v):
        nonlocal root

        if v >= len(values) or values[v] == 'null':
            return None
        else:
            node = TreeNode(int(values[v]))
            if v == 0:
                root = node

            node.left = generate(v*2+1)
            node.right = generate(v*2+2)
            return node

    return generate(0)

def inorder(root):
    res = []

    def helper(node):
        if not node:
            return
        helper(node.left)
        res.append(node.val)
        helper(node.right)

    helper(root)
    return res
