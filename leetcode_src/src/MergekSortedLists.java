import java.util.*;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(
            (ListNode n1, ListNode n2) -> Integer.compare(n1.val, n2.val));

        if(lists == null) return null;
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) q.offer(lists[i]);
        }

        ListNode prev = new ListNode();
        ListNode dummy = prev;
        while(!q.isEmpty()) {
            ListNode curr = q.poll();
            if (curr.next != null) q.offer(curr.next);
            prev.next = curr;
            prev = curr;
        }

        return dummy.next;
    }

    public void test() {
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(3);
        q.offer(4);
        q.offer(2);
        q.offer(5);
        q.offer(1);
        q.offer(0);
        System.out.println(q.toString());
        for (int i = q.size(); i > 0; i--) {
            System.out.println(q.poll());
        }
    }

    public static void main(String[] args) {
        MergekSortedLists sol = new MergekSortedLists();
        ListNode l1 = LinkedListUtil.generateLinkedList("[1,4,5]");
        ListNode l2 = LinkedListUtil.generateLinkedList("[1,3,4]");
        ListNode l3 = LinkedListUtil.generateLinkedList("[2,6]");
        l1.print();
        l2.print();
        l3.print();
        ListNode[] ln = new ListNode[]{l1, l2, l3};
        ListNode res = sol.mergeKLists(ln);
        res.print();
        ListNode a = sol.mergeKLists(null);
        ListNode b = sol.mergeKLists(new ListNode[]{});
        
    }
}
