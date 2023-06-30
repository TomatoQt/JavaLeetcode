package Stack_Queue;

import java.util.*;

public class LC1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (!stack.empty() && stack.peek() == item)
                stack.pop();
            else
                stack.push(item);
        }

        List<Character> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
