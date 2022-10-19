from typing import *
from BinaryTreeUtil import *

class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        data = [[] for _  in range(200)]
        pivot = 100
        lbound = float('inf')
        rbound = float('-inf')

        def preorder(node, dif):
            nonlocal lbound, rbound

            if not node:
                if dif < lbound: lbound = dif+1
                elif dif > rbound: rbound = dif-1
                return
            else:
                data[pivot + dif].append(node.val)
                preorder(node.left, dif-1)
                preorder(node.right, dif+1)

        preorder(root, 0)
        return data[lbound+pivot:rbound+pivot+1]

if __name__ == '__main__':
    t1 = generateBinaryTree("3,9,8,4,0,1,7,null,null,null,2,5")
    print(inorder(t1))
    print(Solution().verticalOrder(t1))
