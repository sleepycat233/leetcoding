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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> s = new LinkedList<>();
        ListNode fast = head;
        ListNode slow = head;
        ListNode l2;
        while(fast != null && fast.next != null) {
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null) { //even
            l2 = slow;
        }
        else { //odd
            l2 = slow.next;
        }

        while(!s.isEmpty()) {
            if(s.pop() != l2.val) {
                return false;
            }
            l2 = l2.next;
        }
        return true;
    }
}