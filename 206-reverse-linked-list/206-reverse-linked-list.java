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

        ListNode headNode = null;
        ListNode prevNode = null;
        while(head != null) {
            headNode = new ListNode(head.val, prevNode);
            prevNode = headNode;
            head = head.next;
        }

        return headNode;
    }
}