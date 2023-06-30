package linkedList;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}