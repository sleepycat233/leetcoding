// https://leetcode.com/problems/linked-list-cycle/

import java.util.*;

/* class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
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
        int i=0;
        while (n != null && i < MAXCOUNT) {
            System.out.printf("[%d]->", n.val);
            n = n.next;
            i++;
        }
        System.out.println();
    }
} */

// cycle detection: 快慢指针
// https://cloud.tencent.com/developer/article/1688590#:~:text=%E5%BF%AB%E6%85%A2%E6%8C%87%E9%92%88%E6%96%B9%E6%B3%95%EF%BC%8C%E5%8F%88%E7%A7%B0,%EF%BC%88%E5%A6%82%E4%B8%8B%E5%9B%BE%E6%89%80%E7%A4%BA%EF%BC%89%E3%80%82
// https://web.archive.org/web/20160401024212/http://learningarsenal.info:80/index.php/2015/08/24/detecting-start-of-a-loop-in-singly-linked-list/

public class LinkedListCycle {
    public boolean hasCycle(ListNode headNode) {
        if(headNode == null || headNode.next == null) return false;

        ListNode tortoise = headNode, hare = headNode;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == tortoise) return true;
        }
        return false;
    }

    public static void main(String[] args) {
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

        LinkedListCycle sol = new LinkedListCycle();
        System.out.println(sol.hasCycle(l1));
    }
}
