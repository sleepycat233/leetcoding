import java.util.Arrays;

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
    static public ListNode generateLinkedList(String str) {
        String[] nums = str.split("\\D");   //split by non-digit
        // System.out.println(Arrays.toString(nums));
        ListNode nn = null;
        for(int i = nums.length; i-- > 0; ) {
            if(!nums[i].isBlank()) {
                nn = new ListNode(Integer.parseInt(nums[i]), nn);
            }
        }

        return nn;
    }
}
