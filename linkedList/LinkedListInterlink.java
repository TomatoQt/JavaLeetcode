package linkedList;

public class LinkedListInterlink {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int A_count = 0, B_count = 0;
        ListNode A_cur = headA, B_cur = headB;

        while (A_cur != null) {
            A_cur = A_cur.next;
            A_count++;
        }

        while (B_cur != null) {
            B_cur = B_cur.next;
            B_count++;
        }

        A_cur = headA;
        B_cur = headB;

        // 让A指向最长的链表
        if (A_count < B_count) {
            int temp_count = A_count;
            A_count = B_count;
            B_count = temp_count;

            ListNode temp_node = A_cur;
            A_cur = B_cur;
            B_cur = temp_node;
        }

        for (int i = 0; i < (A_count - B_count); i++) {
            A_cur = A_cur.next;
        }

        while (A_cur != null && B_cur != null) {
            if (A_cur == B_cur)
                return A_cur;
            A_cur = A_cur.next;
            B_cur = B_cur.next;
        }

        return null;
    }
}
