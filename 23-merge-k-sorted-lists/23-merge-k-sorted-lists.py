# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists: return None
        def mergeTwoLists(left, right):
            head = ListNode(0)
            tail = head
            while left and right:
                if left.val <= right.val:
                    tail.next = left
                    left = left.next
                else:
                    tail.next = right
                    right = right.next
                tail = tail.next

            if left:
                tail.next = left
            if right:
                tail.next = right

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
        