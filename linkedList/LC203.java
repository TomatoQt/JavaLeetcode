package linkedList;

// 移除链表元素
public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode fakeHead = new ListNode(val - 1, head);
        ListNode pre = fakeHead;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }

        return fakeHead.next;
    }
}