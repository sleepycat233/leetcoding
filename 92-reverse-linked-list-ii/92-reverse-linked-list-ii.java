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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode tl = dummy;
        ListNode tm = dummy;
        ListNode hr = null;
        ListNode hm = null;

        for(int i = 1; i < left; i++) {
            tl = tl.next;
            tm = tm.next;
        }

        for(int j = left-1; j < right; j++) {
            tm = tm.next;
        }
        hr = tm.next;
        hm = tl.next;

        tl.next = null;
        tm.next = null;

        reverseList_recursive(hm);
        tl.next = tm;
        hm.next = hr;

        return dummy.next;
    
    }

    public ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList_recursive(head.next);
        head.next.next = head; // * niubi
        head.next = null;
        return p;
    }
}