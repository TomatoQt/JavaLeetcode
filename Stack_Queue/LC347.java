package Stack_Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {
    /*Comparator接口说明:
     * 返回负数，形参中第一个参数排在前面；返回正数，形参中第二个参数排在前面
     * 对于队列：排在前面意味着往队头靠
     * 对于堆（使用PriorityQueue实现）：从队头到队尾按从小到大排就是最小堆（小顶堆），
     *                                从队头到队尾按从大到小排就是最大堆（大顶堆）--->队头元素相当于堆的根节点
     * */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        // (number, frequency)
        Map<Integer, Integer> map = new HashMap<>();
        // 统计频率
        for (int item : nums)
            map.put(item, map.getOrDefault(item, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else { // pq.size() >= k
                // 只有当前频率大于小顶堆频率时才弹出，考虑以下例子：
                // k=2, 频率数组=[3,2,1]
                // 不能为了1，把3弹出
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int index = 0;
        while (pq.size() > 0)
            result[index++] = pq.poll()[0];

        return result;
    }
}
