package linkedList;

public class LC142 {
    // 快慢指针 追及问题 思维
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head; // 初始化 speed(fast) = 2 * speed(slow)

        while (fast != null && fast.next != null) { // fast步长为2，保证不会访问空指针
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // 有环，找到相遇点
                ListNode p1 = slow;
                ListNode p2 = head;

                // 推论：2个节点，一个从开头出发，一个从meet出发，以相同速度前进，再相遇就是环入口
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null; // 有null指针，无环
    }
}
