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


}
