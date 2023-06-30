package Stack_Queue;

import java.util.*;

public class LC239 {
    class MonoQue {
        Deque<Integer> deque = new LinkedList<>();

        // 弹出元素时，比较当前要弹出的值是否等于队列出口的值，相等则弹出
        // 同时判断队列此时是否为空
        void poll(int val) {
            if (!deque.isEmpty() && deque.peek() == val)
                deque.poll();
        }

        // 添加元素时，如果要添加的元素大于入口处的元素，则将入口元素弹出
        // 保证队列单调递减
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast())
                deque.removeLast();
            deque.add(val);
        }

        // 队列出口元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonoQue monoQue = new MonoQue();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            monoQue.add(nums[i]);
        }
        int left = 0, right = k, index = 0;
        // 初始化，取出最大值
        res[index++] = monoQue.peek();
        while (right < nums.length) {
            monoQue.poll(nums[left++]);
            monoQue.add(nums[right++]);
            res[index++] = monoQue.peek();
        }

        return res;
    }
}
