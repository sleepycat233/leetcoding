public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pivot = dummy;
        ListNode prei = dummy;
        ListNode i = head;

        while (i != null) {
            if (i.val < x) {
                prei.next = i.next;
                i.next = pivot.next;
                pivot.next = i;

                if (prei.next != i) {
                    i = prei.next;
                }
                else {
                    prei = prei.next;
                    i = prei.next;
                }
                pivot = pivot.next;
            } else {
                prei = i;
                i = i.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        PartitionList sol = new PartitionList();

        ListNode l1 = LinkedListUtil.generateLinkedList("1,4,3,2,5,2");
        sol.partition(l1, 4);
        l1.print();
    }
}
