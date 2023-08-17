package Stack_Queue;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.empty()) {
            while (!stackIn.empty())
                stackOut.push(stackIn.pop());
        }
        // pop时要保证stackIn的元素全部转移完毕
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.empty()) {
            while (!stackIn.empty())
                stackOut.push(stackIn.pop());
        }
        // peek时要保证stackIn的元素全部转移完毕
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */