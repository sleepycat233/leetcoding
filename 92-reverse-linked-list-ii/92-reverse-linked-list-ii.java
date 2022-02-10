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
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;

        for(int i = 0; i < left-1; i++) {
            pre = pre.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = pre.next;
        ListNode tmp = null;
        for(int j = 0; j < right - left + 1; j++) {
            ListNode next = curr.next;
            curr.next = tmp;
            tmp = curr;
            curr = next;
        }

        pre.next = tmp;
        leftNode.next = curr;

        return dummyNode.next;
    }
}