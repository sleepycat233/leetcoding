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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = list1;
        ListNode l2 = list2;
        ListNode prev = null;
        ListNode curr = list1;
        while(curr != null && l2 != null) {
            ListNode t = l2;
            if(curr.val >= l2.val) {
                l2 = l2.next;
                t.next = curr;
                if(prev != null) {
                    prev.next = t;
                }
                else {
                    res = t;
                }
                prev = t;
            }
            else {
                if(curr != null) prev = curr;
                curr = curr.next;
            }
        }
        if(l2 != null) {
            if(prev != null) prev.next = l2;
            else res = l2;
        }
        return res;
    }
}