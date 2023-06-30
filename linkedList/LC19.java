package linkedList;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        ListNode pre = null;
        cur = head; // reset
        for (int i = 0; i < count - n; i++) {
            pre = cur;
            cur = cur.next;
        }

        if (pre != null)
            pre.next = cur.next;
        else
            return head.next;

        return head;
    }
}
