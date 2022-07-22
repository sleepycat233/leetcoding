# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        isStop = False
        leftNode = head
        def recurse(rightNode, m, n):
            nonlocal isStop, leftNode
            if n == 1:
                return
            rightNode = rightNode.next
            if m > 1:
                leftNode = leftNode.next
            recurse(rightNode, m-1, n-1)
            if leftNode == rightNode or rightNode.next == leftNode:
                isStop = True
            if not isStop:
                leftNode.val, rightNode.val = rightNode.val, leftNode.val
                leftNode = leftNode.next
        recurse(head, left, right)

        return head