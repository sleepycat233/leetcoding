public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = list1;
        ListNode l2 = list2;
        ListNode prev = null;
        ListNode curr = list1;
        while(curr != null && l2 != null) {
            ListNode t = l2;
            if(curr.val >= l2.val) {
                l2 = l2.next;
                t.next = curr;
                if(prev != null) {
                    prev.next = t;
                }
                else {
                    res = t;
                }
                prev = t;
            }
            else {
                if(curr != null) prev = curr;
                curr = curr.next;
            }
        }
        if(l2 != null) {
            if(prev != null) prev.next = l2;
            else res = l2;
        }
        return res;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(list1 != null || list2 != null) {
            if(list1 == null) {
                res.next = list2;
                break;
            }
            else if(list2 == null) {
                res.next = list1;
                break;
            }
            else if (list1.val <= list2.val) {
                res.next = new ListNode(list1.val);
                res = res.next;
                list1 = list1.next;
            }
            else {
                res.next = new ListNode(list2.val);
                res = res.next;
                list2 = list2.next;
            }
        }

        return dummy.next;
    }

    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        ListNode res = null;
        if (list1 != null || list2 != null) {
            res = merge_rec(list1, list2);
        }
        return res;
    }

    private ListNode merge_rec(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        else if(l2 == null) {
            return l1;
        }
        else if(l1.val < l2.val) {
            l1.next = merge_rec(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge_rec(l2.next, l1);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode pn = null, nn = null, l1, l2;
        for (int i = 5; i > 0; i--) {
            nn = new ListNode(i, pn);
            pn = nn;
        }
        l1 = pn;
        pn = null;
        for (int i = 8; i > 3; i--) {
            nn = new ListNode(i, pn);
            pn = nn;
        }
        l2 = pn;

        l1.print();
        l2.print();
        MergeTwoSortedLists sol = new MergeTwoSortedLists();
        ListNode res = sol.mergeTwoLists3(l1, l2);
        res.print();
    }
}
