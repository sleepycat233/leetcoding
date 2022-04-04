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
private int getLen(ListNode list) {
        int len = 0;
        while(list != null) {
            len++;
            list = list.next;
        }
        return len;
    }

    private boolean containsOne(int[] a) {
        for(int x : a) {
            if(x == 1) return true;
        }
        return false;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);

        ListNode large, small;
        if(len1 > len2) {
            large = l1;
            small = l2;
        }
        else {
            large = l2;
            small = l1;
        }

        int dif = Math.abs(len1 - len2);
        ListNode dummy = new ListNode(-1, null);
        ListNode node = dummy;

        // for(int i = 0; i < dif; i++) {
        while(dif-- > 0) {
            node.next = new ListNode(large.val);
            node = node.next;
            large = large.next;
        }

        int[] carry = new int[Math.max(len1, len2) + 1];
        int ci = Math.min(len1, len2);

        while(large != null) {
            int sum = large.val + small.val;
            node.next = new ListNode(sum%10);
            node = node.next;
            carry[ci--] = sum/10;

            small = small.next;
            large = large.next;
        }


        ListNode start = dummy.next;
        while(containsOne(carry)) {
            ListNode n = start;
            if(carry[carry.length-1] == 1) {
                carry[carry.length-1] = 0;
                ListNode leadingone = new ListNode(1, start);
                dummy.next = leadingone;
                start = leadingone.next;
            }

            for(int i = carry.length-2; i >= 0; i--) {
                if(carry[i] == 1) {
                    carry[i] = 0;
                    n.val++;
                    if(n.val == 10) {
                        n.val = 0;
                        carry[i+1] = 1;
                    }
                }
                n = n.next;
            }
        }

        return dummy.next;
    }
}