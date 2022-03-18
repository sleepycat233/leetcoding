class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    void print() {
        ListNode n = this;
        while(n != null) {
            System.out.printf("[%d]->", n.val);
            n = n.next;
        }
        System.out.println();
    }
}

public class LinkedListUtil {
    
}
