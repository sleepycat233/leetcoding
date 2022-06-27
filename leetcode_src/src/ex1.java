import java.util.*;

public class ex1 {
    public static void removePrefixStrings(List<String> list, String prefix)
    {
        Iterator<String> ite = list.iterator();
        while(ite.hasNext()) {
            String str = ite.next();
            boolean match = true;
            if(str.length() < prefix.length()) continue;

            for(int i = 0; i < prefix.length(); i++) {
                if(str.charAt(i) != prefix.charAt(i)) {
                    match = false;
                    break;
                }
            }

            if(match) {
                ite.remove();
            }
        }
    }

    ListNode head;
    public ex1() {
        ListNode pn = null, nn = null;
        for (int i = 5; i > 0; i--) {
            nn = new ListNode(i, pn);
            pn = nn;
            nn = new ListNode(i, pn);
            pn = nn;
        }
        head = pn;
    }

    public void removeDuplicate() {
        ListNode curr = head;
        ListNode next = curr;
        while(curr != null) {
            while(next != null && curr.val == next.val) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
        }
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("abc");
        l.add("abcd");
        l.add("abcdd");
        l.add("abd");
        l.add("ac");

        ex1.removePrefixStrings(l, "abc");
        System.out.println(l);

        ex1 sol = new ex1();
        sol.head.print();
        sol.removeDuplicate();
        sol.head.print();
    }
}
