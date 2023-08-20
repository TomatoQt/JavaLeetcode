package Stack_Queue;

import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int op2, op1;
        for (String str : tokens) {
            switch (str) {
                case "+" -> {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                }
                case "-" -> {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                }
                case "*" -> {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                }
                case "/" -> {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                }
                default -> // numbers
                    stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
