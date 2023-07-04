package linkedList;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode slow = dummyHead, fast = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 结束while循环的时候，就是找到了被删除节点的上一个节点
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
