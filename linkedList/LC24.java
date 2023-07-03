package linkedList;

// 两两交换链表中的节点
public class LC24 {
    // 递归
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

    public ListNode swapPairs_(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null) {
            ListNode firstNode = cur.next;
            ListNode secondNode = firstNode.next;
            ListNode temp = secondNode.next;
            // swap
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            // next round
            cur = firstNode;
        }

        return dummyHead.next;
    }
}
