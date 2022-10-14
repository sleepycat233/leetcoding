# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast = slow = head
        prev = None
        if not head.next: return None
        
        while fast.next and fast.next.next:
            fast = fast.next.next
            prev = slow
            slow = slow.next
        
        if not fast.next:
            prev.next = prev.next.next
        else:
            slow.next = slow.next.next
        
        return head
        