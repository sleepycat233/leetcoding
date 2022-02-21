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
        ListNode res = null;
        if (list1 != null || list2 != null) {
            res = merge_rec(list1, list2);
        }
        return res;
    }

    private ListNode merge_rec(ListNode l1, ListNode l2) {
        if(l1 == null) {
            // return new ListNode(l2.val);
            return l2;
        }
        else if(l2 == null) {
            // return new ListNode(l1.val);
            return l1;
        }
        else if(l1.val < l2.val) {
            return new ListNode(l1.val, merge_rec(l1.next, l2));
        }
        else {
            return new ListNode(l2.val, merge_rec(l2.next, l1));
        }
    }
}