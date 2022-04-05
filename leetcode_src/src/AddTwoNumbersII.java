import java.util.*;

public class AddTwoNumbersII {
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

    private void pushval(ListNode list, Deque<Integer> stack) {
        while(list != null) {
            stack.push(list.val);
            list = list.next;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        pushval(l1, s1);
        pushval(l2, s2);
        ListNode n = null;

        int digit = 0;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry == 1) {
            int sum = 0;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            sum += carry;
            digit = sum%10;
            carry = sum/10;
            n = new ListNode(digit, n);
        }

        return n;
    }



    public static void main(String[] args) {
        AddTwoNumbersII sol = new AddTwoNumbersII();
        // ListNode l1 = LinkedListUtil.generateLinkedList("7,2,4,3");
        // ListNode l2 = LinkedListUtil.generateLinkedList("5,6,4");
        ListNode l1 = LinkedListUtil.generateLinkedList("9,3,3,3,4");
        ListNode l2 = LinkedListUtil.generateLinkedList("6,6,6,6");
        ListNode res = sol.addTwoNumbers2(l1, l2);

        res.print();
    }
}