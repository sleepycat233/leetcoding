from typing import *
from LinkedListUtil import *
from queue import PriorityQueue

class Solution:

    def mergeKLists3(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
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

    # priority queue
    # we use a wrapper class otherwise we get: TypeError: '<' not supported between instances of 'ListNode' and 'ListNode'
    # another solution would be using triple tuple: pq.put((node.val, id(node), node))
    def mergeKLists2(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

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


    # divide and conquer
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
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

if __name__ == '__main__':
    l1 = generateLinkedList("1,2,3")
    l2 = generateLinkedList("2,5,6")
    l3 = generateLinkedList("3, 9, 10")
    res = Solution().mergeKLists3([l1, l2, l3])
    res.print()
