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
    private ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return isp_rec(head);
    }

    private boolean isp_rec(ListNode curr) {
        if(curr == null) {
            return true;
        }
        else {
            if(!isp_rec(curr.next)) {
                return false;
            }
            if(curr.val != front.val) {
                return false;
            }
            front = front.next;
        }
        return true;
    }
}