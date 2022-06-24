// https://leetcode.com/problems/linked-list-cycle-ii/

/* class ListNode {
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
        next = null;
    }
    ListNode(int x, ListNode n)
    {
        val = x;
        next = n;
    }

    void print()
    {
        ListNode n = this;
        final int MAXCOUNT = 20;
        int i = 0;
        while (n != null && i < MAXCOUNT) {
            System.out.printf("[%d]->", n.val);
            n = n.next;
            i++;
        }
        System.out.println();
    }
} */

// cycle detection: 快慢指针
// https://web.archive.org/web/20160401024212/http://learningarsenal.info:80/index.php/2015/08/24/detecting-start-of-a-loop-in-singly-linked-list/

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode headNode)
    {
        if (headNode == null || headNode.next == null)
            return null;

        ListNode tortoise = headNode, hare = headNode;
        boolean hasloop = false;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                hasloop = true;
                break;
            }
        }

        if(hasloop == true) {
            tortoise = headNode;
            while(tortoise != hare) {
                tortoise = tortoise.next;
                hare = hare.next;
            }
            return tortoise;
        } else {
            return null;
        }
    }

    public static void main(String[] args)
    {
        ListNode pn = null, nn = null, l1;
        ListNode tailn = new ListNode(11, null);
        pn = tailn;
        for (int i = 0; i < 5; i++) {
            nn = new ListNode(i, pn);
            pn = nn;
        }
        tailn.next = pn.next;
        l1 = nn;
        l1.print();

        LinkedListCycleII sol = new LinkedListCycleII();
        ListNode loopStart = sol.detectCycle(l1);
        System.out.println(loopStart.val);
        System.out.println(loopStart.next.val);
    }
}
