package linkedList;

public class LinkedListInterlink {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int countA = 0, countB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            curA = curA.next;
            countA++;
        }
        while (curB != null) {
            curB = curB.next;
            countB++;
        }
        // reset
        curA = headA;
        curB = headB;
        if (countA < countB) {
            // curB jump
            for (int i = 0; i < countB - countA; i++)
                curB = curB.next;
        } else if (countA > countB) {
            // curA jump
            for (int i = 0; i < countA - countB; i++)
                curA = curA.next;
        }
        while (curA != null && curB != null && curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        if (curA == null || curB == null)
            return null;
        return curA;
    }
}
