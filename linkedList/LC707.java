package linkedList;

public class LC707 {
    class MyLinkedList {
        int size;
        ListNode fakeHead;

        public MyLinkedList() {
            this.size = 0;
            fakeHead = new ListNode(0);
        }

        public int get(int index) {
            // index 不合法，直接返回-1
            if (index < 0 || index >= size)
                return -1;
            ListNode cur = fakeHead;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.next.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size)
                return;
            else if (index == size) {
                ListNode cur = fakeHead;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
                cur.next = new ListNode(val);
            } else if (index < 0) {
                fakeHead.next = new ListNode(val, fakeHead.next);
            } else {
                ListNode pre = fakeHead, cur = fakeHead.next;
                for (int i = 0; i < index; i++) {
                    pre = pre.next;
                    cur = cur.next;
                }
                pre.next = new ListNode(val, cur);
            }
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >=size)
                return;
            else {
                ListNode pre = fakeHead, cur = fakeHead.next;
                for (int i = 0; i < index; i++) {
                    pre = pre.next;
                    cur = cur.next;
                }
                pre.next = cur.next;
            }
            size--;
        }
    }
}
