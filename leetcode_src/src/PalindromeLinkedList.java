import java.util.*;

public class PalindromeLinkedList {
    // 23 ms, faster than 22.02%
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> s = new LinkedList<>();
        ListNode curr = head;

        while(curr != null) {
            s.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(!s.isEmpty()) {
            if(s.pop() != curr.val) {
                return false;
            }
            curr = curr.next;
        }

        return true;
    }

    // two-pointer: O(n) time, O(n) space.
    // Runtime: 14 ms, faster than 38.27%
    // Memory Usage: 105 MB, less than 46.53%
    public boolean isPalindrome2(ListNode head) {
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

    // Runtime: 5 ms, faster than 90.69% of Java online submissions for Palindrome Linked List.
    // Memory Usage : 52.8 MB, less than 88.84 %
    public boolean isPalindrome3(ListNode head)
    {
        ListNode prev = null;
        ListNode slow, fast;
        slow = fast = head;

        System.out.println("original: ");
        head.print();

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

        System.out.println("l1(after reverse) is: ");
        l1.print();
        System.out.println("l2 is: ");
        l2.print();

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

        System.out.println("final: ");
        head.print();

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

    // method4: recursion
    // O(n) time and space
    private ListNode front;
    public boolean isPalindrome4(ListNode head) {
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

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n = new ListNode(2, n);
        n = new ListNode(3, n);
        n = new ListNode(2, n);
        n = new ListNode(1, n);

        n.print();

        PalindromeLinkedList sol = new PalindromeLinkedList();
        System.out.println(sol.isPalindrome4(n));
    }
}