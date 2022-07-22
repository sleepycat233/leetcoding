# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
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