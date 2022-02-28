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
        ListNode prev = null;
        ListNode slow, fast;
        slow = fast = head;

        // System.out.println("original: ");
        // head.print();

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null) prev.next = null;
        ListNode hol1 = reverseList(head);
        ListNode l1 = hol1;
        ListNode l2;
        if(fast == null) l2 = slow;
        else l2 = slow.next;

        // System.out.println("l1(after reverse) is: ");
        // l1.print();
        // System.out.println("l2 is: ");
        // l2.print();

        boolean isPalindrome = true;
        while(l1 != null && l2 != null) {
            if(l1.val != l2.val) {
                isPalindrome = false;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        reverseList(hol1);
        if(prev != null) prev.next = slow;

        // System.out.println("final: ");
        // head.print();

        if(isPalindrome) return true;
        else return false;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev, curr, next;
        prev = null;
        curr = head;
        next = curr;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}