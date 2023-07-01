package linkedList;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            // 先存下cur.next
            ListNode tmp = cur.next;
            // 反转指向：cur指向pre
            cur.next = pre;
            // 更新pre和cur指向，为下次操作准备：
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}