import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedListII {

    //stack
    public ListNode reverseBetween_iterative(ListNode head, int left, int right) {
        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode leftNode = head;
        ListNode rightNode = head;

        for(int i = 0; i < right; i++) {
            if(i == left-1) leftNode = rightNode;
            stack.push(rightNode);
            rightNode = rightNode.next;
        }

        rightNode = stack.pop();
        while(true) {
            if(leftNode == rightNode || rightNode.next == leftNode) break;

            int t = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = t;

            rightNode = stack.pop();
            leftNode = leftNode.next;
        }

        return head;
    }

    // improvement: // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
    // ListNode dummyNode = new ListNode(-1);
    // dummyNode.next = head;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode breakNode;
        ListNode chainHead;
        if(left == 1) {
            breakNode = null;
            chainHead = head;
        }
        else {
            breakNode = head;
            for(int i = 0; i < left-2; i++) {
                breakNode = breakNode.next;
            }
            chainHead = breakNode.next;
        }

        ListNode curr = chainHead;
        ListNode prev = null;
        for(int j = left; j <= right; j++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(breakNode != null)
            breakNode.next = prev;
        else
            head = prev;

        chainHead.next = curr;

        return head;
    }

    // one pass with a dummy node
    // 头插法

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;

        for(int i = 0; i < left-1; i++) {
            pre = pre.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = pre.next;
        ListNode tmp = null;
        for(int j = 0; j < right - left + 1; j++) {
            ListNode next = curr.next;
            curr.next = tmp;
            tmp = curr;
            curr = next;
        }

        pre.next = tmp;
        leftNode.next = curr;

        return dummyNode.next;
    }

    public ListNode reverseBetween3(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode tl = dummy;
        ListNode tm = dummy;
        ListNode hr = null;
        ListNode hm = null;

        for(int i = 1; i < left; i++) {
            tl = tl.next;
            tm = tm.next;
        }

        for(int j = left-1; j < right; j++) {
            tm = tm.next;
        }
        hr = tm.next;
        hm = tl.next;

        tl.next = null;
        tm.next = null;

        reverseList_recursive(hm);
        tl.next = tm;
        hm.next = hr;

        return dummy.next;
    }

    private ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList_recursive(head.next);
        head.next.next = head; // * niubi
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ReverseLinkedListII sol = new ReverseLinkedListII();
        ListNode l1 = LinkedListUtil.generateLinkedList("1,2,3,4,5");
        l1 = sol.reverseBetween_iterative(l1, 2, 4);
        l1.print();
    }
}