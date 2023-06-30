package Stack_Queue;

import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0)
            return false;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(')
                stack.push(')');
            else if (item == '[')
                stack.push(']');
            else if (item == '{')
                stack.push('}');
            // 遍历的过程中栈已经清空了，说明右括号的部分多余了
            // 栈顶元素和当前元素不一致，说明不合法
            else if (stack.empty() || stack.peek() != item)
                return false;
            // 只剩下栈顶元素和当前元素相等的情况
            else
                stack.pop();
        }

        return stack.empty();
    }
}
