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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        ListNode tmp = null;
        while(curr != null) {
            ListNode prev = curr.next;
            curr.next = tmp;
            tmp = curr;
            curr = prev;
        }
        return tmp;
    }
}