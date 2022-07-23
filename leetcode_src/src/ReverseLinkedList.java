import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode headNode = null;
        ListNode prevNode = null;
        while(head != null) {
            headNode = new ListNode(head.val, prevNode);
            prevNode = headNode;
            head = head.next;
        }

        return headNode;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode listhead = null;
    public ListNode reverseList3(ListNode head) {
        helper(null, head);
        return listhead;
    }

    private void helper(ListNode prev, ListNode curr) {
        if(curr == null) {
            listhead = prev;
        }
        else {
            helper(curr, curr.next);
            curr.next = prev;
        }
    }

    public ListNode reverseList_recursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList_recursive(head.next);
        head.next.next = head;  //* niubi
        head.next = null;
        return p;
    }

    public ListNode reverseList_iterative(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        if(head == null) return head;

        while(head.next != null) {
            stack.push(head);
            head = head.next;
        }
        while(!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next.next = node;
            node.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();
        ListNode l1 = LinkedListUtil.generateLinkedList("1,3,5,6");
        l1 = sol.reverseList_iterative(l1);
        l1.print();
    }
}
