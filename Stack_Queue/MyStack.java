package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
        // 保证queue1仅包含最后一个元素
        while (queue1.size() > 1)
            queue2.add(queue1.poll());
    }

    public int pop() {
        int res = queue1.poll();
        // 保证queue2仅包含最后一个元素
        while (queue2.size() > 1)
            queue1.add(queue2.poll());
        // 交换queue1和queue2
        Queue<Integer> tempQ = queue1;
        queue1 = queue2;
        queue2 = tempQ;

        return res;
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */