package linkedList;

public class LC707 {
    class MyLinkedList {
        private int nodeNum;
        private ListNode dummyHead;

        public MyLinkedList() {
            dummyHead = new ListNode();
            nodeNum = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= nodeNum)
                return -1;

            ListNode cur = dummyHead.next;
            int count = 0;
            // 只要不满足，就一直往count++的方向找
            while (count < index) {
                cur = cur.next;
                count++;
            }
            // 退出while，count == index
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(nodeNum, val);
        }

        public void addAtIndex(int index, int val) {
            if (index >= 0 && index <= nodeNum) { // 把index==nodeNum的情况考虑进来
                ListNode pre = dummyHead;
                ListNode cur = pre.next;
                int count = 0;
                while (count < index) {
                    pre = cur;
                    cur = cur.next;
                    count++;
                }
                ListNode newNode = new ListNode(val);
                nodeNum++;
                pre.next = newNode;
                newNode.next = cur;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < nodeNum) { // index==nodeNum感觉越界了，就没有包括进来
                ListNode pre = dummyHead;
                ListNode cur = pre.next;
                int count = 0;
                // 只要不满足，就一直往count++的方向找
                while (count < index) {
                    pre = cur;
                    cur = cur.next;
                    count++;
                }
                // 退出while，count == index
                pre.next = cur.next;
                nodeNum--;
            }
        }
    }
}
