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
        if(left == right) return head;
        ListNode breakNode;
        ListNode chainHead;
        if(left == 1) {
            breakNode = null;
            chainHead = head;
        }
        else {
            breakNode = head;
            for(int i = 0; i < left-2; i++) {
                breakNode = breakNode.next;
            }
            chainHead = breakNode.next;
        }

        ListNode curr = chainHead;
        ListNode prev = null;
        for(int j = left; j <= right; j++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(breakNode != null)
            breakNode.next = prev;
                else
            head = prev;

        // if(curr != null)
            chainHead.next = curr;

        return head;
    }
}