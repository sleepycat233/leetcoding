from typing import *
from LinkedListUtil import *

class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        beforeHead = ListNode(-1, None)
        afterHead = ListNode(-1, None)
        before = beforeHead
        after = afterHead

        while head:
            if head.val < x:
                before.next = head
                before = before.next
            else:
                after.next = head
                after = after.next

            head = head.next

        after.next = None
        before.next = afterHead.next

        return beforeHead.next


l1 = generateLinkedList("1,4,3,2,5,2")
l1 = Solution().partition(l1, 3)
l1.print()