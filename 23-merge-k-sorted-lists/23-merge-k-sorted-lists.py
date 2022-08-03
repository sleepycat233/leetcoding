# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from queue import PriorityQueue
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        class Wrapper():
            def __init__(self, node):
                self.node = node
            def __lt__(self, other):
                return self.node.val < other.node.val

        head = tail = ListNode(-1)
        pq = PriorityQueue()

        if not lists: return None
        for l in lists:
            if l:
                pq.put(Wrapper(l))

        while not pq.empty():
            node = pq.get().node
            tail.next = node
            # tail.next = ListNode(val)
            tail = tail.next

            if node := node.next:
                pq.put(Wrapper(node))

        return head.next