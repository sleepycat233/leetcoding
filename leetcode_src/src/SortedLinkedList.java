import java.util.*;

public class SortedLinkedList {
    ListNode head;
    ListNode tail;

    public SortedLinkedList()
    {

    }

    public void add(int x) {
        ListNode newNode = new ListNode(x);
        tail.next = newNode;
        tail = newNode;
    }

    public void removeDuplicate()
    {
        ListNode curr = head;
        ListNode next = curr;
        while (curr != null) {
            while (next != null && curr.val == next.val) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
        }
    }

    public static SortedLinkedList sortedIntersect(SortedLinkedList A, SortedLinkedList B)
    {
        SortedLinkedList res = new SortedLinkedList();
        ListNode na = A.head;
        ListNode nb = B.head;

        while(na != null && nb != null) {
            while(na.next != null && na.val == na.next.val) {
                na = na.next;
            }
            while(nb.next != null && nb.val == nb.next.val) {
                nb = nb.next;
            }

            if(na.val == nb.val) {
                // res.add(na.val);
                System.out.println(na.val);
                na = na.next;
                nb = nb.next;
            }
            else if(na.val < nb.val) {
                na = na.next;
            }
            else {
                nb = nb.next;
            }
        }

        return res;
    }


    public static void main(String[] args)
    {
        SortedLinkedList l1 = new SortedLinkedList();
        SortedLinkedList l2 = new SortedLinkedList();
        SortedLinkedList res = new SortedLinkedList();
        ListNode pn = null, nn = null;
        for (int i = 5; i > 0; i--) {
            nn = new ListNode(i, pn);
            pn = nn;
            nn = new ListNode(i, pn);
            pn = nn;
        }
        l1.head = pn;
        l1.head.print();
        l1.removeDuplicate();
        l1.head.print();

        pn = null;
        for (int i = 5; i > 0; i--) {
            nn = new ListNode(i, pn);
            if(i == 5) l1.tail = nn;
            pn = nn;
        }
        l1.head = pn;
        l1.add(20);
        l1.add(20);
        l1.add(20);
        l1.head.print();

        pn = null;
        for (int i = 5; i > 0; i--) {
            nn = new ListNode(i, pn);
            if (i == 5)
                l2.tail = nn;
            pn = nn;
        }
        l2.head = pn;
        l2.add(20);
        l2.head.print();

        res = SortedLinkedList.sortedIntersect(l1, l2);
        // res.head.print();
    }
}
