import java.util.*;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(
            (ListNode n1, ListNode n2) -> Integer.compare(n1.val, n2.val));

        for(int i = 0; i < lists.length; i++) {
            q.offer(lists[i]);
        }
        for (int i = q.size(); i > 0; i--) {
            System.out.println(q.poll());
        }

        return null;
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
        
        sol.mergeKLists();
    }
}
