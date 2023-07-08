import java.net.Inet4Address;
import java.util.*;

import linkedList.ListNode;

public class Main {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head; // 初始化 speed(fast) = 2 * speed(slow)

        // 第一次循环，寻找相遇点
        do {
            if (fast == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        // 推论：2个节点，一个从开头出发，一个从meet出发，以相同速度前进，再相遇就是环入口
        // 重新利用fast
        fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
        } while (slow != fast);

        return slow;
    }

    public static void main(String[] args) {

    }
}
