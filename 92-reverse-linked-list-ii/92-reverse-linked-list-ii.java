/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

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
}