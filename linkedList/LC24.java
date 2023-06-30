package linkedList;

// 两两交换链表中的节点
public class LC24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head, next = cur.next;
        ListNode newNode = swapPairs(next.next);
        // swap
        next.next = cur;
        cur.next = newNode;

        return next;
    }
}
