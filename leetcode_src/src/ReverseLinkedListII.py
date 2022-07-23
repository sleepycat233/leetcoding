from typing import *
from LinkedListUtil import *

class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(-1, head)
        before = dummy

        for _ in range(left-1):
            before = before.next

        pre = before.next
        i = pre.next

        for _ in range(right - left):
            pre.next = i.next
            i.next = before.next
            before.next = i
            i = pre.next

        return dummy.next


    def reverseBetween_recursion(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
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

    def main(self):
        l1 = generateLinkedList("1,2,3,4,5")
        l1 = Solution().reverseBetween_recursion(l1, 2, 4)
        l1.print()

Solution().main()