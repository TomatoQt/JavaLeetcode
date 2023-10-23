package linkedList;

import java.util.PriorityQueue;

public class LC23 {
    // 分治法
//    public ListNode mergeKLists(ListNode[] lists) {
//
//    }

    // 优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (o1, o2) -> (o1.val - o2.val));
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        while (!pq.isEmpty()) {
            p.next = pq.poll();
            p = p.next;
            if (p.next != null)
                pq.add(p.next);
        }

        return dummy.next;
    }
}
