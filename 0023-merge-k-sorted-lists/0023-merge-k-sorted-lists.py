# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from queue import PriorityQueue
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = PriorityQueue()
        if not lists: return None

        for node in lists:
            if node:
                pq.put((node.val, id(node), node))

        prev = dummy = ListNode(-1)
        while not pq.empty():
            val, _, curr = pq.get()
            if curr.next:
                pq.put((curr.next.val, id(curr.next), curr.next))
            prev.next = curr
            prev = curr

        return dummy.next