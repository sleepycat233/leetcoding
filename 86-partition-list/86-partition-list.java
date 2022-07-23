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
    public ListNode partition(ListNode head, int x) {

        ListNode dummy = new ListNode(-1, head);
        ListNode pivot = dummy;
        ListNode prei = dummy;
        ListNode i = head;

        while (i != null) {
            if (i.val < x) {
                prei.next = i.next;
                i.next = pivot.next;
                pivot.next = i;

                if (prei.next != i) {
                    i = prei.next;
                }
                else {
                    prei = prei.next;
                    i = prei.next;
                }
                pivot = pivot.next;
            } else {
                prei = i;
                i = i.next;
            }
        }

        return dummy.next;
    
    }
}