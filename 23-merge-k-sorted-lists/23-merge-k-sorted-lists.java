/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(
            (ListNode n1, ListNode n2) -> Integer.compare(n1.val, n2.val));

        if(lists == null) return null;
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) q.offer(lists[i]);
        }

        ListNode prev = new ListNode();
        ListNode dummy = prev;
        while(!q.isEmpty()) {
            ListNode curr = q.poll();
            if (curr.next != null) q.offer(curr.next);
            prev.next = curr;
            prev = curr;
        }

        return dummy.next;
    }
}