package Stack_Queue;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        while (!inStack.empty())
            outStack.push(inStack.pop());
        int res = outStack.pop();
        while (!outStack.empty())
            inStack.push(outStack.pop());
        return res;
    }

    public int peek() {
        while (!inStack.empty())
            outStack.push(inStack.pop());
        int res = outStack.peek();
        while (!outStack.empty())
            inStack.push(outStack.pop());
        return res;
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
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