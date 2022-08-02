from typing import *
from LinkedListUtil import *

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        def mergeTwoLists(left, right):
            head = ListNode(0)
            tail = head
            while left and right:
                if left.val <= right.val:
                    tail.next = left
                    tail = tail.next
                    left = left.next
                else:
                    tail.next = right
                    tail = tail.next
                    right = right.next
            if left:
                tail.next = left
                tail = tail.next
            if right:
                tail.next = right
                tail = tail.next

            return head.next

        def helper(lists, l, r):
            if l == r:
                return lists[l]
            else:
                mid = int((l+r)/2)
                left = helper(lists, l, mid)
                right = helper(lists, mid+1, r)
                return mergeTwoLists(left, right)

        return helper(lists, 0, len(lists)-1)


l1 = generateLinkedList("1,2,3")
l2 = generateLinkedList("2,5,6")
l3 = generateLinkedList("3, 9, 10")
res = Solution().mergeKLists([l1, l2, l3])
res.print()