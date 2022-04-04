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
private void pushval(ListNode list, Deque<Integer> stack) {
        while(list != null) {
            stack.push(list.val);
            list = list.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        pushval(l1, s1);
        pushval(l2, s2);
        ListNode n = null;

        int digit = 0;
        int carry = 0;
        int sum = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            sum = s1.pop() + s2.pop() + carry;
            digit = sum%10;
            carry = sum/10;
            n = new ListNode(digit, n);
        }
        while (!s1.isEmpty()) {
            sum = s1.pop() + carry;
            digit = sum % 10;
            carry = sum / 10;
            n = new ListNode(digit, n);
        }
        while (!s2.isEmpty()) {
            sum = s2.pop() + carry;
            digit = sum % 10;
            carry = sum / 10;
            n = new ListNode(digit, n);
        }
        if(carry == 1) n = new ListNode(1, n);

        return n;
    }
}