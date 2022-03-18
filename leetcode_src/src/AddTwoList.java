// https://leetcode.com/problems/add-two-numbers/

// Definition for singly-linked list.

import java.util.*;

public class AddTwoList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int sum, digit, carry = 0;
        ListNode rl = null, cn, pn = null;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            digit = sum % 10;
            carry = sum / 10;
            cn = new ListNode(digit, null);
            if (pn != null)
                pn.next = cn;
            else
                rl = cn;
            pn = cn;

            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode reml = null;
        if(l1 != null) reml = l1;
        else if(l2 != null) reml = l2;
        while(reml != null) {
            sum = reml.val + carry;
            digit = sum % 10;
            carry = sum / 10;
            cn = new ListNode(digit, null);
            pn.next = cn;
            pn = cn;

            reml = reml.next;
        }
        if(carry != 0) {
            cn = new ListNode(carry, null);
            pn.next = cn;
        }

        return rl;
    }

    public ListNode addTwoNumbers_opt(ListNode l1, ListNode l2)
    {
        int sum, digit, carry = 0;
        ListNode rl = null, cn, pn = null;
        while (l1 != null || l2 != null) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            sum = v1 + v2 + carry;
            digit = sum % 10;
            carry = sum / 10;
            cn = new ListNode(digit, null);
            if (pn != null)
                pn.next = cn;
            else
                rl = cn;
            pn = cn;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if (carry != 0) {
            cn = new ListNode(carry, null);
            pn.next = cn;
        }

        return rl;
    }

        public List<Integer> addTwoNumbers_ll(List<Integer> l1, List<Integer> l2)
        {
            List<Integer> rl = new LinkedList<>();
            ListIterator<Integer> ite1 = l1.listIterator();
            ListIterator<Integer> ite2 = l2.listIterator();
            int carry = 0, sum, digit;

            while (ite1.hasNext() && ite2.hasNext()) {
                sum = ite1.next() + ite2.next() + carry;
                digit = sum % 10;
                carry = sum / 10;
                rl.add(digit);
            }

            ListIterator<Integer> remainIte;
            if (ite1.hasNext())
                remainIte = ite1;
            else if (ite2.hasNext())
                remainIte = ite2;
            else
                remainIte = null;

            while (remainIte != null && remainIte.hasNext()) {
                sum = remainIte.next() + carry;
                digit = sum % 10;
                carry = sum / 10;
                rl.add(digit);
            }
            if (carry != 0) {
                rl.add(carry);
            }

            return rl;
        }

        public static void main(String[] args)
    {
        // List<Integer> l1 = new LinkedList<>(Arrays.asList(1, 2, 3, 9, 1, 9));
        // List<Integer> l2 = new LinkedList<>(Arrays.asList(5, 4, 7));
        // List<Integer> rl;

        // AddTwoList sol = new AddTwoList();
        // rl = sol.addTwoNumbers_ll(l1,l2);
        // System.out.println(Arrays.toString(rl.toArray()));


        AddTwoList sol = new AddTwoList();
        ListNode l2, l1 = null, pn = null, nn = null, rn;
        for(int i = 0; i < 10; i++) {
            nn = new ListNode(i, pn);
            pn = nn;
        }
        l1 = nn;
        pn = null;
        for (int i = 6; i < 11; i++) {
            nn = new ListNode(i, pn);
            pn = nn;
        }
        l2 = nn;

        rn = sol.addTwoNumbers_opt(l1, l2);
        l1.print();
        l2.print();
        rn.print();
        // System.out.println(Arrays.toString(rl.toArray()));
    }
    }
