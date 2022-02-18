public class ReverseLinkedListII {
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

    // 头插法
}