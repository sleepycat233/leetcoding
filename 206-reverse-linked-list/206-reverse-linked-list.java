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
    private ListNode listhead = null;
    public ListNode reverseList(ListNode head) {
        helper(null, head);
        return listhead;
    }

    private void helper(ListNode prev, ListNode curr) {
        if(curr == null) {
            listhead = prev;
        }
        else {
            helper(curr, curr.next);
            curr.next = prev;
        }
    }
}